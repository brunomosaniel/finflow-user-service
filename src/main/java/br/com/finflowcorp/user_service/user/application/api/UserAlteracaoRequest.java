package br.com.finflowcorp.user_service.user.application.api;

import jakarta.persistence.Column;
import lombok.Value;

@Value
public class UserAlteracaoRequest {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String role;
}
