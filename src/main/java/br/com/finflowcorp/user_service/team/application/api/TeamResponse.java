package br.com.finflowcorp.user_service.team.application.api;

import br.com.finflowcorp.user_service.team.domain.Team;
import lombok.Value;

import java.util.UUID;

@Value
public class TeamResponse {
    UUID id;
    public TeamResponse(Team savedTeam) {
        this.id = savedTeam.getId();
    }
}
