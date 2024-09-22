package uz.ccrew.paymentservice.user.dto;

import uz.ccrew.paymentservice.user.UserRole;

import lombok.Builder;

@Builder
public record UserDTO(Long userId,
                      UserRole role) {
}
