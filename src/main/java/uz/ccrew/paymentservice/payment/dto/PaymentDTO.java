package uz.ccrew.paymentservice.payment.dto;

import uz.ccrew.paymentservice.payment.enums.PaymentStatus;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PaymentDTO(String paymentId,
                         PaymentStatus status,
                         LocalDateTime payedTime,
                         LocalDateTime reversedTime) {
}
