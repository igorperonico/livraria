package com.livraria.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record LivroRecordDto(@NotBlank String titulo, @NotNull String autor, @NotNull BigDecimal preco) {
}
