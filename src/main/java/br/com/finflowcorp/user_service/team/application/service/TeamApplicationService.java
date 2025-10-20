package br.com.finflowcorp.user_service.team.application.service;

import br.com.finflowcorp.user_service.handler.APIException;
import br.com.finflowcorp.user_service.team.application.api.*;
import br.com.finflowcorp.user_service.team.application.repository.TeamRepository;
import br.com.finflowcorp.user_service.team.domain.Team;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class TeamApplicationService implements TeamService {
    private final TeamRepository teamRepository;

    @Override
    public TeamResponse createTeam(TeamRequest teamRequest) {
        log.info("[start] TeamApplicationService - createTeam");
        if (teamRepository.existsByName(teamRequest.getName())) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Team already exists");
        }
        Team team = new Team(teamRequest);
        Team savedTeam = teamRepository.save(team);
        log.info("[finish] TeamApplicationService - createTeam");
        return new TeamResponse(savedTeam);
    }

    @Override
    public List<TeamListResponse> getAllTeams() {
        log.info("[start] TeamApplicationService - getAllTeams");
        List<Team> teams = teamRepository.findAll();
        log.info("[finish] TeamApplicationService - getAllTeams");
        return TeamListResponse.converte(teams);
    }

    @Override
    public TeamDetalhadoResponse getTeamById(UUID id) {
        log.info("[start] TeamApplicationService - getTeamById");
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Team with ID {} not found", id);
                    return APIException.build(HttpStatus.NOT_FOUND, "Team not found");
                });
        log.info("[finish] TeamApplicationService - getTeamById");
        return new TeamDetalhadoResponse(team);
    }

    @Override
    public void deleteTeamById(UUID id) {
        log.info("[start] TeamApplicationService - deleteTeamById");
        Team team = teamRepository.findTeamById(id);
        teamRepository.delete(team);
        log.info("[finish] TeamApplicationService - deleteTeamById");
    }

    @Override
    public void updateTeam(UUID id, TeamAlteracaoRequest teamAlteracaoRequest) {
        log.info("[start] TeamApplicationService - updateTeam");
        Team team = teamRepository.findTeamById(id);
        if (!team.getName().equals(teamAlteracaoRequest.getName()) &&
                teamRepository.existsByName(teamAlteracaoRequest.getName())) {
            throw APIException.build(HttpStatus.CONFLICT, "Team already exists");
        }
        team.altera(teamAlteracaoRequest);
        teamRepository.save(team);
        log.info("[finish] TeamApplicationService - updateTeam");
    }

}
