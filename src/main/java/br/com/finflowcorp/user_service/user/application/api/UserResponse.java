package br.com.finflowcorp.user_service.user.application.api;

import br.com.finflowcorp.user_service.user.domain.User;
import lombok.Value;

import java.util.UUID;

@Value
public class UserResponse {
    private UUID id;

    public UserResponse(User userCriado) {
        this.id = userCriado.getId();
    }
}
