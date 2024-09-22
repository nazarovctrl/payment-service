package uz.ccrew.paymentservice.payment.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record WithdrawAccountDTO(@NotNull(message = "Invalid accountNumber")
                                 @Min(value = 1000000000, message = "Invalid accountNumber")
                                 @Max(value = 9999999999L, message = "Invalid accountNumber")
                                 Long accountNumber,

                                 @Min(value = 1000)
                                 @NotNull(message = "Payment amount can not be null")
                                 Long amount) {
}
