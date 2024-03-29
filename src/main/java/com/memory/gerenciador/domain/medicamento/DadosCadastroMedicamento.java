package com.memory.gerenciador.domain.medicamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record DadosCadastroMedicamento(
        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{1}\\.\\d{4}\\.\\d{4}\\.\\d{3}\\-\\d{1}")
        String registroAnvisa,

        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataValidade,

        @NotBlank
        @Pattern(regexp = "\\(\\d{2}\\)\\d{4}\\-\\d{4}")
        String telefone,

        @NotNull
        @DecimalMin(value = "0.0", inclusive = false)
        @Digits(integer = 8, fraction = 2)
        BigDecimal preco,

        @Min(value = 1)
        Integer quantidadeComprimidos,

        @NotNull
        Long fabricanteId,

        @NotNull
        List<Long> reacoes

) {

}
