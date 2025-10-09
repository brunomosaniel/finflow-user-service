package br.com.finflowcorp.user_service.user.application.service;

import br.com.finflowcorp.user_service.user.application.api.UserRequest;
import br.com.finflowcorp.user_service.user.application.api.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserApplicationService implements UserService {
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        return null;
    }
}
