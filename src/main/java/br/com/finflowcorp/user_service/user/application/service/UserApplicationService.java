package br.com.finflowcorp.user_service.user.application.service;

import br.com.finflowcorp.user_service.handler.APIException;
import br.com.finflowcorp.user_service.user.application.api.*;
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
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw APIException.build(HttpStatus.CONFLICT, "Email already exists");
        }
        User user = new User(userRequest);
        User savedUser = userRepository.save(user);
        log.info("[finish] UserApplicationService - createUser");
        return new UserResponse(savedUser);
    }

    @Override
    public List<UserListResponse> getAllUsers() {
        log.info("[start] UserApplicationService - getAllUsers");
        List<User> users = userRepository.findAll();
        log.info("[finish] UserApplicationService - getAllUsers");
        return UserListResponse.converte(users);
    }

    @Override
    public UserDetalhadoResponse getUserById(UUID id) {
        log.info("[start] UserApplicationService - getUserById");
        User user = findUserById(id);
        log.info("[finish] UserApplicationService - getUserById");
        return new UserDetalhadoResponse(user);
    }

    @Override
    public void deleteUserById(UUID id) {
        log.info("[start] UserApplicationService - deleteUserById");
        User user = findUserById(id);
        userRepository.deleteById(id);
        log.info("[finish] UserApplicationService - deleteUserById");
    }

    @Override
    public void updateUser(UUID id, UserAlteracaoRequest userAlteracaoRequest) {
        log.info("[start] UserApplicationService - updateUser");
        User user = findUserById(id);
        if (!user.getEmail().equals(userAlteracaoRequest.getEmail()) &&
                userRepository.existsByEmail(userAlteracaoRequest.getEmail())) {
            throw APIException.build(HttpStatus.CONFLICT, "Email already exists");
        }
        user.altera(userAlteracaoRequest);
        userRepository.save(user);
        log.info("[finish] UserApplicationService - updateUser");
    }

    private User findUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("User with ID {} not found", id);
                    return APIException.build(HttpStatus.NOT_FOUND, "User not found");
                });
    }
}