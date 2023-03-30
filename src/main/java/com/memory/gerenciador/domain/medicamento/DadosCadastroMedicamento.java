package com.memory.gerenciador.domain.medicamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.memory.gerenciador.domain.reacao.Reacao;
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
        String telefone,

        @DecimalMin(value = "0.0", inclusive = false)
        @Digits(integer = 8, fraction = 2)
        BigDecimal preco,

        @Min(value = 1)
        Integer quantidadeComprimidos,

        List<Reacao> reacoes
) {

}
