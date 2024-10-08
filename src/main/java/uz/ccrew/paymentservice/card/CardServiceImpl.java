package uz.ccrew.paymentservice.card;

import uz.ccrew.paymentservice.card.dto.CardDTO;
import uz.ccrew.paymentservice.card.dto.TopUpDTO;
import uz.ccrew.paymentservice.exp.BadRequestException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Override
    public CardDTO create() {
        Card card = Card.builder()
                .balance(0L)
                .build();

        cardRepository.save(card);

        return CardDTO.builder()
                .cardNumber(card.getCardNumber())
                .balance(card.getBalance())
                .build();
    }

    @Override
    public CardDTO topUp(TopUpDTO dto) {
        Card card = cardRepository.findById(dto.cardNumber())
                .orElseThrow(() -> new BadRequestException("Card not found"));

        card.setBalance(card.getBalance() + dto.amount());
        cardRepository.save(card);

        return CardDTO.builder()
                .cardNumber(card.getCardNumber())
                .balance(card.getBalance())
                .build();
    }

    @Override
    public List<CardDTO> getList() {
        return cardRepository.findAll().stream()
                .map(card -> CardDTO.builder()
                        .cardNumber(card.getCardNumber())
                        .balance(card.getBalance())
                        .build()).toList();
    }
}
