package uz.ccrew.paymentservice.account;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_number_seq_gen")
    @SequenceGenerator(name = "account_number_seq_gen", sequenceName = "account_number_seq", allocationSize = 1)
    private Long accountNumber;

    @Column(nullable = false)
    private Long balance;
}
