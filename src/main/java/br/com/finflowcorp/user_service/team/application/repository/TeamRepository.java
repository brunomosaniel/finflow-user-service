package br.com.finflowcorp.user_service.team.application.repository;

import br.com.finflowcorp.user_service.team.domain.Team;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    boolean existsByName(@NotBlank(message = "Nome do time é obrigatório") String name);
    Team findTeamById(UUID id);
}
