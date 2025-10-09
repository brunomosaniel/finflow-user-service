package br.com.finflowcorp.user_service.user.application.service;

import br.com.finflowcorp.user_service.user.application.api.UserRequest;
import br.com.finflowcorp.user_service.user.application.api.UserResponse;
import jakarta.validation.Valid;

public interface UserService {
    UserResponse createUser(@Valid UserRequest userRequest);
}
