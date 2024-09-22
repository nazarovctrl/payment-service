package uz.ccrew.paymentservice.payment;

import uz.ccrew.paymentservice.user.User;
import uz.ccrew.paymentservice.card.Card;
import uz.ccrew.paymentservice.user.AuthUtil;
import uz.ccrew.paymentservice.account.Account;
import uz.ccrew.paymentservice.card.CardRepository;
import uz.ccrew.paymentservice.payment.dto.PaymentDTO;
import uz.ccrew.paymentservice.exp.BadRequestException;
import uz.ccrew.paymentservice.account.AccountRepository;
import uz.ccrew.paymentservice.payment.enums.PaymentType;
import uz.ccrew.paymentservice.payment.enums.PaymentStatus;
import uz.ccrew.paymentservice.payment.dto.WithdrawCardDTO;
import uz.ccrew.paymentservice.payment.dto.WithdrawAccountDTO;
import uz.ccrew.paymentservice.useraccount.UserAccountRepository;

import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final AuthUtil authUtil;
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final PaymentRepository paymentRepository;
    private final UserAccountRepository userAccountRepository;

    @Transactional
    @Override
    public PaymentDTO withdrawByCard(WithdrawCardDTO dto) {
        User user = authUtil.loadLoggedUser();

        Account receiverAccount = userAccountRepository.findMainAccountByUser(user.getUserId())
                .orElseThrow(() -> new BadRequestException("Receiver main account not found"));


        Card card = cardRepository.findById(dto.cardNumber()).orElseThrow(() -> new BadRequestException("Card not found"));
        if (card.getBalance() < dto.amount()) {
            throw new BadRequestException("Not enough money on the card");
        }

        card.setBalance(card.getBalance() - dto.amount());
        cardRepository.save(card);

        receiverAccount.setBalance(receiverAccount.getBalance() + dto.amount());
        accountRepository.save(receiverAccount);

        Payment payment = Payment.builder()
                .amount(dto.amount())
                .payerType(PaymentType.CARD)
                .payerCardNumber(dto.cardNumber())
                .receiverAccountNumber(receiverAccount.getAccountNumber())
                .payedTime(LocalDateTime.now())
                .status(PaymentStatus.PAYED)
                .build();
        paymentRepository.save(payment);

        return PaymentDTO.builder()
                .paymentId(payment.getPaymentId().toString())
                .status(payment.getStatus())
                .payedTime(payment.getPayedTime())
                .build();
    }

    @Override
    public PaymentDTO withdrawByAccount(WithdrawAccountDTO dto) {
        User user = authUtil.loadLoggedUser();

        Account receiverAccount = userAccountRepository.findMainAccountByUser(user.getUserId())
                .orElseThrow(() -> new BadRequestException("Receiver main account not found"));


        Account account = accountRepository.findById(dto.accountNumber()).orElseThrow(() -> new BadRequestException("Card not found"));
        if (account.getBalance() < dto.amount()) {
            throw new BadRequestException("Not enough money on the account");
        }
        account.setBalance(account.getBalance() - dto.amount());
        accountRepository.save(account);

        receiverAccount.setBalance(receiverAccount.getBalance() + dto.amount());
        accountRepository.save(receiverAccount);

        Payment payment = Payment.builder()
                .amount(dto.amount())
                .payerType(PaymentType.ACCOUNT)
                .payerAccountNumber(dto.accountNumber())
                .receiverAccountNumber(receiverAccount.getAccountNumber())
                .payedTime(LocalDateTime.now())
                .status(PaymentStatus.PAYED)
                .build();
        paymentRepository.save(payment);

        return PaymentDTO.builder()
                .paymentId(payment.getPaymentId().toString())
                .status(payment.getStatus())
                .payedTime(payment.getPayedTime())
                .build();
    }
}
