package uz.ccrew.paymentservice.card;

import lombok.*;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    private String cardNumber;

    @Column(nullable = false)
    private Long balance;

    @Column
    private String pinCode;

    @Column
    private String phoneNumber;
}
