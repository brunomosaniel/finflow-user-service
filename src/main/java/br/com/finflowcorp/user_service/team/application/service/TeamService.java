package br.com.finflowcorp.user_service.team.application.service;

import br.com.finflowcorp.user_service.team.application.api.TeamListResponse;
import br.com.finflowcorp.user_service.team.application.api.TeamRequest;
import br.com.finflowcorp.user_service.team.application.api.TeamResponse;

import java.util.List;

public interface TeamService {
    TeamResponse createTeam(TeamRequest teamRequest);
    List<TeamListResponse> getAllTeams();
}
