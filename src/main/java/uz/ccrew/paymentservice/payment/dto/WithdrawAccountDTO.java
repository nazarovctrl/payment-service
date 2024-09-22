package uz.ccrew.paymentservice.payment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WithdrawAccountDTO(@NotBlank(message = "Invalid account number")
                                 String accountNumber,

                                 @Min(value = 1000)
                                 @NotNull(message = "Payment amount can not be null")
                                 Long amount) {
}
