package uz.ccrew.paymentservice.useraccount.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record UserAccountCreateDTO(@NotNull(message = "Invalid userId")
                                   Long userId,
                                   @NotBlank(message = "Invalid cardNumber")
                                   String accountNumber,
                                   @NotNull(message = "Invalid IsMain")
                                   Boolean isMain) {
}
