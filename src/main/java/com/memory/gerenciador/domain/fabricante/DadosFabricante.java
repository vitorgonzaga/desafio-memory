package com.memory.gerenciador.domain.fabricante;

public record DadosFabricante(Long id, String nome, String cnpj) {
    public DadosFabricante(Fabricante fabricante) {
        this(fabricante.getId(), fabricante.getNome(), fabricante.getCnpj());
    }
}
