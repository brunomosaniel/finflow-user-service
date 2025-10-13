package br.com.finflowcorp.user_service.user.application.api;

import br.com.finflowcorp.user_service.user.domain.User;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class UserListResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private UUID idTeam;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public static List<UserListResponse> converte(List<User> users) {
        return users.stream()
                .map(UserListResponse::new)
                .collect(Collectors.toList());
    }

    public UserListResponse(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.idTeam = user.getIdTeam();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
