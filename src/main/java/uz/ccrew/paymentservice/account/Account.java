package uz.ccrew.paymentservice.account;

import lombok.*;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private String accountNumber;

    @Column(nullable = false)
    private Long balance;
}
