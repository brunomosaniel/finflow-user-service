package br.com.finflowcorp.user_service.user.application.service;

import br.com.finflowcorp.user_service.user.application.api.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    List<UserListResponse> listaTodosUser();
    UserDetalhadoResponse buscaUserAtravesId(UUID id);
    void deletaUserPorId(UUID id);
    void alteraUSer(UUID id, @Valid UserAlteracaoRequest userAlteracaoRequest);
}
