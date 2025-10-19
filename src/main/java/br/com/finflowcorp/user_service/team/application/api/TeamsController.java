package br.com.finflowcorp.user_service.team.application.api;

import br.com.finflowcorp.user_service.team.application.service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
