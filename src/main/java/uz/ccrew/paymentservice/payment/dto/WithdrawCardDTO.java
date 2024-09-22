package uz.ccrew.paymentservice.payment.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record WithdrawCardDTO(@NotNull(message = "Invalid cardNumber")
                              @Min(value = 8600000000000000L, message = "Invalid cardNumber")
                              @Max(value = 8600999999999999L, message = "Invalid cardNumber")
                              Long cardNumber,
                              @Min(value = 1000)
                              @NotNull(message = "Payment amount can not be null")
                              Long amount) {
}
