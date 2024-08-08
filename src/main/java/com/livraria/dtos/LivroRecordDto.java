package com.livraria.dtos;

import com.livraria.models.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record LivroRecordDto(@NotBlank String titulo, @NotBlank String autor, @NotNull BigDecimal preco, @NotNull
                             GeneroLivro genero) {
}
