package com.memory.gerenciador.domain.medicamento;

import com.memory.gerenciador.domain.fabricante.DadosFabricante;
import com.memory.gerenciador.domain.reacao.Reacao;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record DadosAtualizacaoMedicamento(

        @NotNull
        Long id,
        String nome,
        String registroAnvisa,
        LocalDate dataValidade,
        String telefone,
        BigDecimal preco,
        Integer quantidadeComprimidos,
        Long fabricanteId,
        List<Long> reacoes

) {
}
