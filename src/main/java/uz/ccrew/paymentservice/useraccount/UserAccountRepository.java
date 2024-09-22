package uz.ccrew.paymentservice.useraccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.ccrew.paymentservice.account.Account;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, UserAccount.UserAccountId> {

    @Query("""
            select w.account
              from UserAccount w
             where w.user.id = ?1
             """)
    Optional<Account> findMainAccountByUser(Long id);
}
