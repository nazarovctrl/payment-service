package uz.ccrew.paymentservice.account;

import org.springframework.web.bind.annotation.GetMapping;
import uz.ccrew.paymentservice.response.Response;
import uz.ccrew.paymentservice.account.dto.AccountDTO;
import uz.ccrew.paymentservice.response.ResponseMaker;

import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;


@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
@Tag(name = "Account Controller", description = "Account API")
@SecurityRequirement(name = "basicAuth")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @Operation(summary = "Create account")
    public ResponseEntity<Response<AccountDTO>> create() {
        AccountDTO result = accountService.create();
        return ResponseMaker.ok(result);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @Operation(summary = "List")
    public ResponseEntity<Response<List<AccountDTO>>> getList() {
        List<AccountDTO> result = accountService.getList();
        return ResponseMaker.ok(result);
    }
}
