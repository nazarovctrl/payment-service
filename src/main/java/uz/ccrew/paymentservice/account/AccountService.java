package uz.ccrew.paymentservice.account;

import uz.ccrew.paymentservice.account.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO create();

    List<AccountDTO> getList();
}
