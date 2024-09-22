package uz.ccrew.paymentservice.account;

import uz.ccrew.paymentservice.account.dto.AccountDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public AccountDTO create() {
        Account account = Account.builder()
                .accountNumber("1231")
                .balance(0L)
                .build();
        accountRepository.save(account);

        return AccountDTO.builder()
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .build();
    }

    @Override
    public List<AccountDTO> getList() {
        List<Account> accountList = accountRepository.findAll();

        return accountList.stream()
                .map(account -> AccountDTO.builder()
                        .accountNumber(account.getAccountNumber())
                        .balance(account.getBalance())
                        .build()).toList();
    }
}
