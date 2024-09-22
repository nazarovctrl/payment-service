package uz.ccrew.paymentservice.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.ccrew.paymentservice.user.User;
import uz.ccrew.paymentservice.user.UserRepository;
import uz.ccrew.paymentservice.user.UserRole;
import uz.ccrew.paymentservice.user.dto.UserCreateDTO;
import uz.ccrew.paymentservice.user.dto.UserDTO;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO create(UserCreateDTO dto) {
        User client = User.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .name(dto.name())
                .role(UserRole.CLIENT)
                .build();

        userRepository.save(client);
        return UserDTO.builder()
                .userId(client.getUserId())
                .role(client.getRole())
                .build();
    }
}
