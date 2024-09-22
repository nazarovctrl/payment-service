package uz.ccrew.paymentservice.card.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopUpDTO(@NotBlank(message = "Invalid cardNumber")
                       String cardNumber,
                       @Min(value = 1000, message = "Amount minimum is 1000")
                       @NotNull(message = "Invalid amount")
                       Long amount) {
}
