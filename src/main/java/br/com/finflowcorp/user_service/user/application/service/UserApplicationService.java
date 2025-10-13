package br.com.finflowcorp.user_service.user.application.service;

import br.com.finflowcorp.user_service.handler.APIException;
import br.com.finflowcorp.user_service.user.application.api.UserDetalhadoResponse;
import br.com.finflowcorp.user_service.user.application.api.UserListResponse;
import br.com.finflowcorp.user_service.user.application.api.UserRequest;
import br.com.finflowcorp.user_service.user.application.api.UserResponse;
import br.com.finflowcorp.user_service.user.application.repository.UserRepository;
import br.com.finflowcorp.user_service.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserApplicationService implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        log.info("[start] UserApplicationService - createUser");
        User user = new User(userRequest);
        User userCriado = userRepository.save(user);
        log.info("[finish] UserApplicationService - createUser");
        return new UserResponse(userCriado);
    }

    @Override
    public List<UserListResponse> listaTodosUser() {
        log.info("[start] UserApplicationService - listaTodosUser");
        List<User> users = userRepository.findAll();
        log.info("[finish] UserApplicationService - listaTodosUser");
        return UserListResponse.converte(users);
    }

    @Override
    public UserDetalhadoResponse buscaUserAtravesId(UUID id) {
        log.info("[start] UserApplicationService - buscaUserAtravesId");
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Usuário com ID {} não encontrado", id);
                    return APIException.build(HttpStatus.NOT_FOUND, "User não encontrado");
                });
        log.info("[finish] UserApplicationService - buscaUserAtravesId");
        return new UserDetalhadoResponse(user);
    }
}
