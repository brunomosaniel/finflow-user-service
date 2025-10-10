package br.com.finflowcorp.user_service.user.application.service;

import br.com.finflowcorp.user_service.user.application.api.UserRequest;
import br.com.finflowcorp.user_service.user.application.api.UserResponse;
import br.com.finflowcorp.user_service.user.application.repository.UserRepository;
import br.com.finflowcorp.user_service.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
