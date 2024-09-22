package uz.ccrew.paymentservice.payment;

import uz.ccrew.paymentservice.response.Response;
import uz.ccrew.paymentservice.response.ResponseMaker;
import uz.ccrew.paymentservice.payment.dto.PaymentDTO;
import uz.ccrew.paymentservice.payment.dto.WithdrawCardDTO;
import uz.ccrew.paymentservice.payment.dto.WithdrawAccountDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
@Tag(name = "Payment Controller", description = "Payment API")
@SecurityRequirement(name = "basicAuth")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/withdraw/card")
    @PreAuthorize("hasAuthority('CLIENT')")
    @Operation(summary = "Withdraw by card")
    public ResponseEntity<Response<PaymentDTO>> withdrawByCard(@RequestBody @Valid WithdrawCardDTO dto) {
        PaymentDTO result = paymentService.withdrawByCard(dto);
        return ResponseMaker.ok(result);
    }

    @PostMapping("/withdraw/account")
    @PreAuthorize("hasAuthority('CLIENT')")
    @Operation(summary = "Withdraw by account")
    public ResponseEntity<Response<PaymentDTO>> withdrawByCard(@RequestBody @Valid WithdrawAccountDTO dto) {
        PaymentDTO result = paymentService.withdrawByAccount(dto);
        return ResponseMaker.ok(result);
    }
}
