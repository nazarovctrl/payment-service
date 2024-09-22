package uz.ccrew.paymentservice.user.service;

import uz.ccrew.paymentservice.user.dto.UserCreateDTO;
import uz.ccrew.paymentservice.user.dto.UserDTO;

public interface UserService {
    UserDTO create(UserCreateDTO dto);
}
