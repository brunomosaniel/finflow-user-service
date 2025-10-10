package br.com.finflowcorp.user_service.user.application.api;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value
public class UserRequest {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String role;

    @NotNull
    @Column(columnDefinition = "uuid", name = "idTeam", nullable = false)
    private UUID idTeam;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;
}
