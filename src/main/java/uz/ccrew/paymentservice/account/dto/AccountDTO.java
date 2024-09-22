package uz.ccrew.paymentservice.account.dto;

import lombok.Builder;

@Builder
public record AccountDTO(String accountNumber,
                         Long balance) {
}
