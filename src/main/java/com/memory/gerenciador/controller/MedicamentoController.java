package com.memory.gerenciador.controller;

import com.memory.gerenciador.domain.medicamento.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("medicamentos")
public class MedicamentoController {

     @Autowired
     MedicamentoRepository medicamentoRepository;

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

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedicamento dados) {
        Medicamento medicamento = medicamentoService.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedicamento(medicamento));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoMedicamento>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<DadosDetalhamentoMedicamento> page = medicamentoRepository.findAll(paginacao).map(DadosDetalhamentoMedicamento::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/pesquisa")
    public ResponseEntity<List<DadosDetalhamentoMedicamento>> listarPorNome(@RequestParam String nome) {
        List<Medicamento> listaMedicamentosPorNome = medicamentoRepository.findByNomeLike("%" + nome + "%");
        List<DadosDetalhamentoMedicamento> dtos = listaMedicamentosPorNome.stream().map(DadosDetalhamentoMedicamento::new).toList();
        return ResponseEntity.ok(dtos);
    }


}
