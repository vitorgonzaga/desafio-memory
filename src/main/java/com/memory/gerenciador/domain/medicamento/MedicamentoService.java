package com.memory.gerenciador.domain.medicamento;

import com.memory.gerenciador.domain.fabricante.Fabricante;
import com.memory.gerenciador.domain.fabricante.FabricanteRepository;
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

    public DadosDetalhamentoMedicamento cadastrar(DadosCadastroMedicamento dados) {
        if(!fabricanteRepository.existsById(dados.fabricanteId())) {
            throw new RuntimeException("Id do fabricante informado não existe!");
        }

        List<Reacao> reacoes = new ArrayList<>();

        dados.reacoes().forEach(reacaoId -> {
            if (!reacaoRepository.existsById(reacaoId)) {
                throw new RuntimeException("A reacão de id: " + reacaoId + " informado na requisição não existe!");
            } else {
                Reacao reacao = reacaoRepository.getReferenceById(reacaoId);
                reacoes.add(reacao);
            }
        });

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
                reacoes
        );

        medicamentoRepository.save(medicamento);


        return new DadosDetalhamentoMedicamento(medicamento);

    }
}
