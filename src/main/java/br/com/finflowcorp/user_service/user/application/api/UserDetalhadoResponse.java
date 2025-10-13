package br.com.finflowcorp.user_service.user.application.api;

import br.com.finflowcorp.user_service.user.domain.User;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value
public class UserDetalhadoResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private UUID idTeam;
    private OffsetDateTime createdAt;

    public UserDetalhadoResponse(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();;
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.idTeam = user.getIdTeam();
        this.createdAt = user.getCreatedAt();
    }
}
