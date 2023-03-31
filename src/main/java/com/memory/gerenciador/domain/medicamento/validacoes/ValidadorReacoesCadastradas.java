package com.memory.gerenciador.domain.medicamento.validacoes;

import com.memory.gerenciador.domain.medicamento.DadosCadastroMedicamento;
import com.memory.gerenciador.domain.reacao.Reacao;
import com.memory.gerenciador.domain.reacao.ReacaoRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class ValidadorReacoesCadastradas implements ValidadorCadastramentoMedicamento {

    private List<Reacao> reacoes = new ArrayList<>();

    @Autowired
    private ReacaoRepository reacaoRepository;

    @Override
    public void validar(DadosCadastroMedicamento dados) {

        dados.reacoes().forEach(reacaoId -> {
            if (!reacaoRepository.existsById(reacaoId)) {
                throw new RuntimeException("A reacão de id: " + reacaoId + " informado na requisição não existe!");
            } else {
                Reacao reacao = reacaoRepository.getReferenceById(reacaoId);
                reacoes.add(reacao);
            }
        });

    }
}
