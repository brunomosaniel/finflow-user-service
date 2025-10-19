package br.com.finflowcorp.user_service.team.application.service;

import br.com.finflowcorp.user_service.handler.APIException;
import br.com.finflowcorp.user_service.team.application.api.TeamListResponse;
import br.com.finflowcorp.user_service.team.application.api.TeamRequest;
import br.com.finflowcorp.user_service.team.application.api.TeamResponse;
import br.com.finflowcorp.user_service.team.application.repository.TeamRepository;
import br.com.finflowcorp.user_service.team.domain.Team;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
