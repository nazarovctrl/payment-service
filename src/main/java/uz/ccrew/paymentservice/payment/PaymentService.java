package uz.ccrew.paymentservice.payment;

import uz.ccrew.paymentservice.payment.dto.WithdrawAccountDTO;
import uz.ccrew.paymentservice.payment.dto.WithdrawCardDTO;
import uz.ccrew.paymentservice.payment.dto.PaymentDTO;

public interface PaymentService {
    PaymentDTO withdrawByCard(WithdrawCardDTO dto);

    PaymentDTO withdrawByAccount(WithdrawAccountDTO dto);
}
