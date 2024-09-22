package uz.ccrew.paymentservice.useraccount;

import uz.ccrew.paymentservice.response.Response;
import uz.ccrew.paymentservice.response.ResponseMaker;
import uz.ccrew.paymentservice.useraccount.dto.UserAccountDTO;
import uz.ccrew.paymentservice.useraccount.dto.UserAccountCreateDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/v1/user-account")
@RequiredArgsConstructor
@Tag(name = "UserAccount Controller", description = "User Account API")
public class UserAccountController {
    private final UserAccountService userAccountService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @Operation(summary = "Create user account")
    public ResponseEntity<Response<UserAccountDTO>> create(@RequestBody @Valid UserAccountCreateDTO dto) {
        UserAccountDTO result = userAccountService.create(dto);
        return ResponseMaker.ok(result);
    }
}
