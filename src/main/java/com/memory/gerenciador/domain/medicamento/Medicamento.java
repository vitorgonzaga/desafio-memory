package com.memory.gerenciador.domain.medicamento;

import com.memory.gerenciador.domain.fabricante.Fabricante;
import com.memory.gerenciador.domain.reacao.Reacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table(name = "medicamentos")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registroAnvisa;
    private String nome;
    private LocalDate dataValidade;
    private String telefone;
    private BigDecimal preco;
    private Integer quantidadeComprimidos;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "medicamentos_reacoes",
            joinColumns = @JoinColumn(
                    name = "medicamento_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "reacao_id",
                    referencedColumnName = "id"
            )
    )
    private List<Reacao> reacoes;


}
