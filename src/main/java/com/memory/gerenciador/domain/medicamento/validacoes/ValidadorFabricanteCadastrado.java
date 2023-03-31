package com.memory.gerenciador.domain.medicamento.validacoes;

import com.memory.gerenciador.domain.fabricante.FabricanteRepository;
import com.memory.gerenciador.domain.medicamento.DadosCadastroMedicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorFabricanteCadastrado implements ValidadorCadastramentoMedicamento {

    @Autowired
    FabricanteRepository fabricanteRepository;

    @Override
    public void validar(DadosCadastroMedicamento dados) {
        if(!fabricanteRepository.existsById(dados.fabricanteId())) {
            throw new RuntimeException("Id do fabricante informado não existe!");
        }
    }
}
