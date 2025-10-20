package br.com.finflowcorp.user_service.team.application.api;

import br.com.finflowcorp.user_service.team.application.service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamsController {

    private final TeamService teamService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public TeamResponse createTeam(@Valid @RequestBody TeamRequest teamRequest) {
        return teamService.createTeam(teamRequest);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<TeamListResponse> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public TeamDetalhadoResponse getTeamById(@PathVariable UUID id) {
        return teamService.getTeamById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteTeam(@PathVariable UUID id) {
        teamService.deleteTeamById(id);
    }
    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateTeam(@PathVariable UUID id,
                    @Valid @RequestBody TeamAlteracaoRequest teamAlteracaoRequest) {
        teamService.updateTeam(id, teamAlteracaoRequest);
    }
}
