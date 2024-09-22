package uz.ccrew.paymentservice.payment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record WithdrawCardDTO(@NotBlank(message = "Invalid card number")
                              @Length(min = 16, max = 16, message = "Invalid cardNumber")
                              String cardNumber,
                              @Min(value = 1000)
                              @NotNull(message = "Payment amount can not be null")
                              Long amount) {
}
