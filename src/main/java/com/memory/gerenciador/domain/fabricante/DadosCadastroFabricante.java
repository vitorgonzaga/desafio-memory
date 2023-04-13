package com.memory.gerenciador.domain.fabricante;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroFabricante(

        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}")
        String cnpj

) {
}
