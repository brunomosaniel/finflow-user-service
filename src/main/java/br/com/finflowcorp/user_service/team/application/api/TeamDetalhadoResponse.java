package br.com.finflowcorp.user_service.team.application.api;

import br.com.finflowcorp.user_service.team.domain.Team;
import lombok.Value;

import java.util.UUID;

@Value
public class TeamDetalhadoResponse {
    UUID id;
    String name;
    String description;
    String createdAt;

    public TeamDetalhadoResponse(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.description = team.getDescription();
        this.createdAt = team.getCreatedAt().toString();
    }

}
