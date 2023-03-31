package com.memory.gerenciador.domain.fabricante;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.memory.gerenciador.domain.medicamento.Medicamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "fabricantes")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Medicamento> medicamentos;

}
