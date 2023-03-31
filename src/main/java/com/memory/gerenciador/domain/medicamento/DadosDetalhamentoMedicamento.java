package com.memory.gerenciador.domain.medicamento;

import com.memory.gerenciador.domain.fabricante.DadosFabricante;
import com.memory.gerenciador.domain.fabricante.Fabricante;
import com.memory.gerenciador.domain.reacao.Reacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record DadosDetalhamentoMedicamento(
        Long id,
        String nome,
        String registroAnvisa,
        LocalDate dataValidade,
        String telefone,
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
