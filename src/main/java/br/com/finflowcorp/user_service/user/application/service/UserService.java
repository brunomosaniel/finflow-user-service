package br.com.finflowcorp.user_service.user.application.service;

import br.com.finflowcorp.user_service.user.application.api.UserDetalhadoResponse;
import br.com.finflowcorp.user_service.user.application.api.UserListResponse;
import br.com.finflowcorp.user_service.user.application.api.UserRequest;
import br.com.finflowcorp.user_service.user.application.api.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    List<UserListResponse> listaTodosUser();
    UserDetalhadoResponse buscaUserAtravesId(UUID id);
}
