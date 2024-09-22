package uz.ccrew.paymentservice.user.dto;

import lombok.Builder;
import uz.ccrew.paymentservice.user.UserRole;

@Builder
public record UserDTO(Long userId,
                      UserRole role) {
}
