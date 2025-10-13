package br.com.finflowcorp.user_service.user.application.api;

import br.com.finflowcorp.user_service.user.application.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    UserResponse createUser(@Valid @RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/user")
    @ResponseStatus(code = HttpStatus.OK)
    List<UserListResponse> listAllUser() {
        return userService.listaTodosUser();
    }

    @GetMapping("/busca-atraves-id/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    UserDetalhadoResponse buscaUserAtravesId(@PathVariable UUID id) {
        return userService.buscaUserAtravesId(id);
    }
}
