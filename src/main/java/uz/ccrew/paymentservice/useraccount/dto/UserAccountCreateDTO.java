package uz.ccrew.paymentservice.useraccount.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UserAccountCreateDTO(@NotNull(message = "Invalid userId")
                                   Long userId,
                                   @NotBlank(message = "Invalid accountNumber")
                                   @Length(min = 10, max = 10, message = "Invalid accountNumber")
                                   String accountNumber,
                                   @NotNull(message = "Invalid IsMain")
                                   Boolean isMain) {
}
