package br.com.finflowcorp.user_service.team.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class TeamAlteracaoRequest {
    @NotBlank(message = "Name is required")
    String name;
    String description;
}
