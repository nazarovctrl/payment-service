package uz.ccrew.paymentservice.payment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WithdrawCardDTO(@NotBlank(message = "Invalid card number")
                              String cardNumber,
                              @Min(value = 1000)
                              @NotNull(message = "Payment amount can not be null")
                              Long amount) {
}
