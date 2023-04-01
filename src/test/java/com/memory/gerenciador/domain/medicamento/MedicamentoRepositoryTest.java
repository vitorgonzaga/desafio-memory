package com.memory.gerenciador.domain.medicamento;

import com.memory.gerenciador.domain.fabricante.Fabricante;
import com.memory.gerenciador.domain.fabricante.FabricanteRepository;
import com.memory.gerenciador.domain.reacao.Reacao;
import com.memory.gerenciador.domain.reacao.ReacaoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicamentoRepositoryTest {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private ReacaoRepository reacaoRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Dado os registros contidos no banco de dados de teste, deve retornar 1 registro")
    /*
     * Por se tratar de um método criado automaticamente pelo SpringData não identifico necessidade de criar um teste,
     * mas fiz com a intenção de exercitar.
     */
    void findByNomeLikeCenario1() {
        // given or arrange
        List<Long> reacoes = new ArrayList<>(Arrays.asList(1l, 2l, 3l));
        Medicamento medicamento = cadastrarMedicamento("MedicamentoTeste", "9.9999.9999.999-9", 1l, reacoes);
        System.out.println("medicamento = " + medicamento);

        // When or act
        List<Medicamento> resultado = medicamentoRepository.findByNomeLike("%Teste%");

        // Then or assert
        assertThat(resultado.get(0), equalTo(medicamento));
    }

    private Medicamento cadastrarMedicamento(String nome, String registroAnvisa, Long fabricanteId, List<Long> reacoesId) {
        Medicamento medicamento = criarMedicamento(nome, registroAnvisa, fabricanteId, reacoesId);
        em.persist(medicamento);
        return medicamento;
    }

    private Medicamento criarMedicamento(String nome, String registroAnvisa, Long fabricanteId, List<Long> reacoes ) {
        LocalDate nextYear = LocalDate.now().plusYears(1);

        Fabricante fabricante = fabricanteRepository.getReferenceById(fabricanteId);

        List<Reacao> reacoesObj = new ArrayList<>();

        reacoes.forEach(reacaoId -> {
            Reacao reacao = reacaoRepository.getReferenceById(reacaoId);
            reacoesObj.add(reacao);
        });

        return new Medicamento(
        null,
            registroAnvisa,
            nome,
            nextYear,
            "(11)9999-9999",
            new BigDecimal(9),
            9,
            fabricante,
            reacoesObj
        );
    }

}