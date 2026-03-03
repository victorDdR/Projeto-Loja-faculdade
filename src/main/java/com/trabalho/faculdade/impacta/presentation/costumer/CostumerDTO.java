package com.trabalho.faculdade.impacta.presentation.costumer;

import jakarta.validation.constraints.NotEmpty;

public record CostumerDTO(@NotEmpty String name, @NotEmpty String email) {
}
