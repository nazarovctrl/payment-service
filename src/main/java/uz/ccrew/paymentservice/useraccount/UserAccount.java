package uz.ccrew.paymentservice.useraccount;

import uz.ccrew.paymentservice.user.User;
import uz.ccrew.paymentservice.account.Account;

import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_accounts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    @EmbeddedId
    private UserAccountId id;

    @Column(nullable = false)
    private Boolean isMain;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_accounts_f1"))
    private User user;

    @OneToOne
    @MapsId("accountNumber")
    @JoinColumn(name = "account_number", foreignKey = @ForeignKey(name = "user_accounts_f2"))
    private Account account;

    @Embeddable
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserAccountId implements Serializable {
        private Long userId;
        private String accountNumber;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserAccountId that = (UserAccountId) o;
            return Objects.equals(userId, that.userId) &&
                    Objects.equals(accountNumber, that.accountNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, accountNumber);
        }
    }
}
