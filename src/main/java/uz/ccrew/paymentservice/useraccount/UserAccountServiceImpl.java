package uz.ccrew.paymentservice.useraccount;

import uz.ccrew.paymentservice.user.User;
import uz.ccrew.paymentservice.account.Account;
import uz.ccrew.paymentservice.user.UserRepository;
import uz.ccrew.paymentservice.exp.BadRequestException;
import uz.ccrew.paymentservice.account.AccountRepository;
import uz.ccrew.paymentservice.useraccount.dto.UserAccountDTO;
import uz.ccrew.paymentservice.useraccount.dto.UserAccountCreateDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final UserAccountRepository userAccountRepository;

    @Override
    public UserAccountDTO create(UserAccountCreateDTO dto) {
        User user = userRepository.findById(dto.userId()).orElseThrow(() -> new BadRequestException("User not found"));
        Account account = accountRepository.findById(dto.accountNumber()).orElseThrow(() -> new BadRequestException("Account not found"));

        UserAccount userAccount = UserAccount.builder()
                .id(new UserAccount.UserAccountId(dto.userId(), dto.accountNumber()))
                .user(user)
                .account(account)
                .isMain(dto.isMain())
                .build();

        userAccountRepository.save(userAccount);

        return UserAccountDTO.builder()
                .userId(userAccount.getId().getUserId())
                .accountNumber(userAccount.getId().getAccountNumber())
                .isMain(userAccount.getIsMain())
                .build();
    }
}
