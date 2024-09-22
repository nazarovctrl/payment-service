package uz.ccrew.paymentservice.useraccount.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserAccountCreateDTO(@NotNull(message = "Invalid userId")
                                   Long userId,
                                   @NotBlank(message = "Invalid cardNumber")
                                   String accountNumber,
                                   @NotNull(message = "Invalid IsMain")
                                   Boolean isMain) {
}
