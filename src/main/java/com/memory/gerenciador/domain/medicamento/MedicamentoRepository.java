package com.memory.gerenciador.domain.medicamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    List<Medicamento> findByNomeLike(String nome);
}
