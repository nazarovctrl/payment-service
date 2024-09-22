package uz.ccrew.paymentservice.card;

import uz.ccrew.paymentservice.card.dto.CardDTO;
import uz.ccrew.paymentservice.card.dto.TopUpDTO;
import uz.ccrew.paymentservice.response.Response;
import uz.ccrew.paymentservice.account.dto.AccountDTO;
import uz.ccrew.paymentservice.response.ResponseMaker;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
@Tag(name = "Card Controller", description = "Card API")
@SecurityRequirement(name = "basicAuth")
public class CardController {
    private final CardService cardService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @Operation(summary = "Create card")
    public ResponseEntity<Response<CardDTO>> create() {
        CardDTO result = cardService.create();
        return ResponseMaker.ok(result);
    }

    @PatchMapping("/top-up")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @Operation(summary = "Top up")
    public ResponseEntity<Response<CardDTO>> topUp(@RequestBody @Valid TopUpDTO dto) {
        CardDTO result = cardService.topUp(dto);
        return ResponseMaker.ok(result);
    }
}
