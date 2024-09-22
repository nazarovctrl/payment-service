package uz.ccrew.paymentservice.card;

import uz.ccrew.paymentservice.card.dto.CardDTO;
import uz.ccrew.paymentservice.card.dto.TopUpDTO;

public interface CardService {
    CardDTO create();

    CardDTO topUp(TopUpDTO dto);
}
