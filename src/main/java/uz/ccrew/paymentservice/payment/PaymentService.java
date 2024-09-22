package uz.ccrew.paymentservice.payment;

import uz.ccrew.paymentservice.payment.dto.PaymentDTO;
import uz.ccrew.paymentservice.payment.dto.WithdrawCardDTO;
import uz.ccrew.paymentservice.payment.dto.WithdrawAccountDTO;

import java.util.UUID;

public interface PaymentService {
    PaymentDTO withdrawByCard(WithdrawCardDTO dto);

    PaymentDTO withdrawByAccount(WithdrawAccountDTO dto);

    PaymentDTO reverse(UUID paymentId);
}
