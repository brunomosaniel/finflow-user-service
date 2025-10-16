package br.com.finflowcorp.user_service.user.application.service;

import br.com.finflowcorp.user_service.user.application.api.*;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    List<UserListResponse> getAllUsers();
    UserDetalhadoResponse getUserById(UUID id);
    void deleteUserById(UUID id);
    void updateUser(UUID id, UserAlteracaoRequest userAlteracaoRequest);
}