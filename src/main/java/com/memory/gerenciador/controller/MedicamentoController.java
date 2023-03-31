package com.memory.gerenciador.controller;

import com.memory.gerenciador.domain.medicamento.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedicamento dados, UriComponentsBuilder uriComponentsBuilder) {
        DadosDetalhamentoMedicamento dto = medicamentoService.cadastrar(dados);
        // boa prática disponibilizar uma url com o detalhamento (vai no headers). Pendente de implementação.
        URI uri = uriComponentsBuilder.path("/medicamento/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
