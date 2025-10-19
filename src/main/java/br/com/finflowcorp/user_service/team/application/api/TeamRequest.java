package br.com.finflowcorp.user_service.team.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class TeamRequest {
    @NotBlank(message = "Nome do time é obrigatório")
    String name;

    String description;
}