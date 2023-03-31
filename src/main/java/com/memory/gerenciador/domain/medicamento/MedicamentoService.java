package com.memory.gerenciador.domain.medicamento;

import com.memory.gerenciador.domain.fabricante.Fabricante;
import com.memory.gerenciador.domain.fabricante.FabricanteRepository;
import com.memory.gerenciador.domain.medicamento.validacoes.ValidadorCadastramentoMedicamento;
import com.memory.gerenciador.domain.medicamento.validacoes.ValidadorReacoesCadastradas;
import com.memory.gerenciador.domain.reacao.Reacao;
import com.memory.gerenciador.domain.reacao.ReacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private ReacaoRepository reacaoRepository;

    @Autowired
    private ValidadorReacoesCadastradas validadorReacoesCadastradas;

    @Autowired
    private List<ValidadorCadastramentoMedicamento> validadores;

    public DadosDetalhamentoMedicamento cadastrar(DadosCadastroMedicamento dados) {

        validadores.forEach(validador -> validador.validar(dados));

        Fabricante fabricante = fabricanteRepository.getReferenceById(dados.fabricanteId());

        Medicamento medicamento = new Medicamento(
                null,
                dados.registroAnvisa(),
                dados.nome(),
                dados.dataValidade(),
                dados.telefone(),
                dados.preco(),
                dados.quantidadeComprimidos(),
                fabricante,
                validadorReacoesCadastradas.getReacoes()
        );

        medicamentoRepository.save(medicamento);


        return new DadosDetalhamentoMedicamento(medicamento);

    }
}
