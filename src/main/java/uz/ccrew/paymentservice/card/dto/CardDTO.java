package uz.ccrew.paymentservice.card.dto;

import lombok.Builder;

@Builder
public record CardDTO(Long cardNumber,
                      Long balance) {
}
