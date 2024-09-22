package uz.ccrew.paymentservice.payment;

import uz.ccrew.paymentservice.card.Card;
import uz.ccrew.paymentservice.account.Account;
import uz.ccrew.paymentservice.payment.enums.PaymentType;
import uz.ccrew.paymentservice.payment.enums.PaymentStatus;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Check(name = "payments_c1", constraints = "payment_type = 'CARD' and payer_card_number is not null or payment_type = 'ACCOUNT' and payer_account_number is not null")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Payment {
    @Id
    @UuidGenerator
    private UUID paymentId;

    @Enumerated(EnumType.STRING)
    @Column
    private PaymentStatus status;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime payedTime;

    @Column
    private LocalDateTime reversedTime;

    @Enumerated(EnumType.STRING)
    @Column
    private PaymentType paymentType;

    @Column(name = "payer_card_number")
    private Long payerCardNumber;

    @Column(name = "payer_account_number")
    private Long payerAccountNumber;

    @Column(name = "receiver_account_number", nullable = false)
    private Long receiverAccountNumber;


    @ManyToOne
    @JoinColumn(name = "payer_card_number", foreignKey = @ForeignKey(name = "payments_f1"), insertable = false, updatable = false)
    private Card payerCard;

    @ManyToOne
    @JoinColumn(name = "payer_account_number", foreignKey = @ForeignKey(name = "payments_f2"), insertable = false, updatable = false)
    private Account payerAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_account_number", foreignKey = @ForeignKey(name = "payments_f3"), insertable = false, updatable = false)
    private Account receiverAccount;
}
