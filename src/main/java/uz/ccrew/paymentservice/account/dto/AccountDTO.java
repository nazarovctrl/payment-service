package uz.ccrew.paymentservice.account.dto;

import lombok.Builder;

@Builder
public record AccountDTO(Long accountNumber,
                         Long balance) {
}
