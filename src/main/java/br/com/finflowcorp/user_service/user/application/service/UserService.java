package br.com.finflowcorp.user_service.user.application.service;

import br.com.finflowcorp.user_service.user.application.api.UserRequest;
import br.com.finflowcorp.user_service.user.application.api.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
