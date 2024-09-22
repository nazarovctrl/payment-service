package uz.ccrew.paymentservice.user;

import uz.ccrew.paymentservice.response.Response;
import uz.ccrew.paymentservice.response.ResponseMaker;

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
import uz.ccrew.paymentservice.user.dto.UserCreateDTO;
import uz.ccrew.paymentservice.user.dto.UserDTO;
import uz.ccrew.paymentservice.user.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "User API")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @Operation(summary = "Create user")
    public ResponseEntity<Response<UserDTO>> create(@RequestBody @Valid UserCreateDTO dto) {
        UserDTO result = userService.create(dto);
        return ResponseMaker.ok(result);
    }
}
