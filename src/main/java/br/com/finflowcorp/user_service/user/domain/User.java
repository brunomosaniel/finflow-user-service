package br.com.finflowcorp.user_service.user.domain;

import br.com.finflowcorp.user_service.user.application.api.UserAlteracaoRequest;
import br.com.finflowcorp.user_service.user.application.api.UserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String role;

    @Column(name = "id_team", nullable = false)
    private UUID idTeam;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    public User(UserRequest userRequest) {
        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
        this.email = userRequest.getEmail();
        this.role = userRequest.getRole();
        this.idTeam = userRequest.getIdTeam();
    }

    public void altera(UserAlteracaoRequest userAlteracaoRequest) {
        this.firstName = userAlteracaoRequest.getFirstName();
        this.lastName = userAlteracaoRequest.getLastName();
        this.email = userAlteracaoRequest.getEmail();
        this.role = userAlteracaoRequest.getRole();
    }
}
