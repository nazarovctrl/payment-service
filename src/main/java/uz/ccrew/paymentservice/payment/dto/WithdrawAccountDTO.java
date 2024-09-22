package uz.ccrew.paymentservice.payment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record WithdrawAccountDTO(@NotBlank(message = "Invalid account number")
                                 @Length(min = 10, max = 10, message = "Invalid accountNumber")
                                 String accountNumber,

                                 @Min(value = 1000)
                                 @NotNull(message = "Payment amount can not be null")
                                 Long amount) {
}
