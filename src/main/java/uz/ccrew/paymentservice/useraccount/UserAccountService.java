package uz.ccrew.paymentservice.useraccount;

import uz.ccrew.paymentservice.useraccount.dto.UserAccountCreateDTO;
import uz.ccrew.paymentservice.useraccount.dto.UserAccountDTO;

public interface UserAccountService {
    UserAccountDTO create(UserAccountCreateDTO dto);
}
