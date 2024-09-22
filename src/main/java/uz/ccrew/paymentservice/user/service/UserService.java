package uz.ccrew.paymentservice.user.service;

import uz.ccrew.paymentservice.user.dto.UserDTO;
import uz.ccrew.paymentservice.user.dto.UserCreateDTO;

public interface UserService {
    UserDTO create(UserCreateDTO dto);
}
