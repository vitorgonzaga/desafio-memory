package com.memory.gerenciador.domain.medicamento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.memory.gerenciador.domain.fabricante.Fabricante;
import com.memory.gerenciador.domain.reacao.Reacao;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table(name = "medicamentos")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @ManyToMany
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

    public void atualizarInformacoes(DadosAtualizacaoMedicamento dados, Fabricante fabricante, List<Reacao> reacoes) {
        if(dados.registroAnvisa() != null) {
            this.registroAnvisa = dados.registroAnvisa();
        }
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.dataValidade() != null) {
            this.dataValidade = dados.dataValidade();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if(dados.preco() != null) {
            this.preco = dados.preco();
        }
        if(dados.quantidadeComprimidos() != null) {
            this.quantidadeComprimidos = dados.quantidadeComprimidos();
        }
        if(fabricante != null) {
            this.fabricante = fabricante;
        }
        if(reacoes != null) {
            this.reacoes = reacoes;
        }

    }
}
