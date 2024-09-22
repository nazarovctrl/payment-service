package uz.ccrew.paymentservice.useraccount.dto;

import lombok.Builder;

@Builder
public record UserAccountDTO(Long userId,
                             Long accountNumber,
                             Boolean isMain) {
}
