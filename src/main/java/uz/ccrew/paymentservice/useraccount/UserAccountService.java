package uz.ccrew.paymentservice.useraccount;

import uz.ccrew.paymentservice.useraccount.dto.UserAccountDTO;
import uz.ccrew.paymentservice.useraccount.dto.UserAccountCreateDTO;

public interface UserAccountService {
    UserAccountDTO create(UserAccountCreateDTO dto);
}
