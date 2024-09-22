package uz.ccrew.paymentservice.card;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "cards")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_number_seq_gen")
    @SequenceGenerator(name = "card_number_seq_gen", sequenceName = "card_number_seq", allocationSize = 1)
    private Long cardNumber;

    @Column(nullable = false)
    private Long balance;

    @Column
    private String pinCode;

    @Column
    private String phoneNumber;
}
