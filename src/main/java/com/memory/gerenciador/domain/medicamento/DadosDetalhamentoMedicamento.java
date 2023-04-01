package com.memory.gerenciador.domain.medicamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.memory.gerenciador.domain.fabricante.DadosFabricante;
import com.memory.gerenciador.domain.reacao.Reacao;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record DadosDetalhamentoMedicamento(
        Long id,
        String nome,
        String registroAnvisa,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataValidade,
        String telefone,
        @DecimalMin(value = "0.0", inclusive = false)
        @Digits(integer = 8, fraction = 2)
        BigDecimal preco,
        Integer quantidadeComprimidos,
        DadosFabricante fabricante,
        List<Reacao> reacoes

) {
    public DadosDetalhamentoMedicamento(Medicamento medicamento) {
        this(
                medicamento.getId(),
                medicamento.getNome(),
                medicamento.getRegistroAnvisa(),
                medicamento.getDataValidade(),
                medicamento.getTelefone(),
                medicamento.getPreco(),
                medicamento.getQuantidadeComprimidos(),
                new DadosFabricante(medicamento.getFabricante()),
                medicamento.getReacoes()
        );
    }
}
