package br.com.finflowcorp.user_service.team.application.api;

import br.com.finflowcorp.user_service.team.domain.Team;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Value
public class TeamListResponse {
    UUID id;
    String name;
    String description;
    OffsetDateTime createdAt;

    public static List<TeamListResponse> converte(List<Team> teams) {
        return teams.stream()
                .map(TeamListResponse::new)
                .toList();
    }
    public TeamListResponse(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.description = team.getDescription();
        this.createdAt = team.getCreatedAt();
    }
}
