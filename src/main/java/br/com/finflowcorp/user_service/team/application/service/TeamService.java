package br.com.finflowcorp.user_service.team.application.service;

import br.com.finflowcorp.user_service.team.application.api.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface TeamService {
    TeamResponse createTeam(TeamRequest teamRequest);
    List<TeamListResponse> getAllTeams();
    TeamDetalhadoResponse getTeamById(UUID id);
    void deleteTeamById(UUID id);
    void updateTeam(UUID id, @Valid TeamAlteracaoRequest teamAlteracaoRequest);
}
