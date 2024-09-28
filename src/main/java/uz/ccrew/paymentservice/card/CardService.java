package uz.ccrew.paymentservice.card;

import uz.ccrew.paymentservice.card.dto.CardDTO;
import uz.ccrew.paymentservice.card.dto.TopUpDTO;

import java.util.List;

public interface CardService {
    CardDTO create();

    CardDTO topUp(TopUpDTO dto);

    List<CardDTO> getList();
}
