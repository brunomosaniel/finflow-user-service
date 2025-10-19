package br.com.finflowcorp.user_service.team.domain;

import br.com.finflowcorp.user_service.team.application.api.TeamRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "teams")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    public Team(TeamRequest teamRequest) {
        this.name = teamRequest.getName();
        this.description = teamRequest.getDescription();
    }
}