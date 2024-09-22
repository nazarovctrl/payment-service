package uz.ccrew.paymentservice.useraccount.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record UserAccountCreateDTO(@NotNull(message = "Invalid userId")
                                   Long userId,
                                   @NotNull(message = "Invalid accountNumber")
                                   @Min(value = 1000000000, message = "Invalid accountNumber")
                                   @Max(value = 9999999999L, message = "Invalid accountNumber")
                                   Long accountNumber,
                                   @NotNull(message = "Invalid IsMain")
                                   Boolean isMain) {
}
