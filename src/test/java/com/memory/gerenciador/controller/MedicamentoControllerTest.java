package com.memory.gerenciador.controller;

import com.jayway.jsonpath.JsonPath;
import com.memory.gerenciador.domain.medicamento.*;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest(properties = "spring.flyway.clean-disabled=false")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@ActiveProfiles("test")
class MedicamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<DadosCadastroMedicamento> dadosCadastroMedicamentoJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoMedicamento> dadosDetalhamentoMedicamentoJson;

    @Autowired
    private JacksonTester<DadosAtualizacaoMedicamento> dadosAtualizacaoMedicamentoJson;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    // Caso queira restringir o testes apenas à camada de controller;
    // @MockBean
    // private MedicamentoService medicamentoService;

    @BeforeEach
    void clearDatabase(@Autowired Flyway flyway) {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    @DisplayName("1. Deveria retornar codigo http 400 quando requisição post é enviada sem o body da requisicao")
    void cadastrarCenario1() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(post("/medicamentos"))
                .andReturn().getResponse();
        assertEquals(response.getStatus(), HttpStatus.BAD_REQUEST.value());
    }
    @Test
    @DisplayName("2. Deveria retornar codigo http 200 quando informacoes de cadastro estão válidas")
    void cadastrarCenario2() throws Exception {
        //given or arrange
        List<Long> reacoes = Arrays.asList(1l, 2l);
        String jsonRequest = jsonCadastroInput("MedicamentoTeste2", "2.2222.2222.222-2", 1l, reacoes);

        // when or act
        MockHttpServletResponse response = mockMvc
                .perform(
                        post("/medicamentos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonRequest)
                                .characterEncoding("UTF-8")
                ).andReturn().getResponse();

        String jsonResponse = response.getContentAsString();
        System.out.println("jsonResponse = " + jsonResponse);

        Integer id = JsonPath.parse(jsonResponse).read("$['id']");
        System.out.println("id = " + id);
        
        String jsonDB = jsonCadastroOutput(id.longValue());
        System.out.println("jsonDB = " + jsonDB);

        // Then or assert
        assertEquals(response.getStatus(), HttpStatus.CREATED.value());
        assertEquals(jsonResponse, jsonDB);
    }

    @Test
    @DisplayName("3. Adicionando reacao (id: 9) com sucesso")
    void atualizarCenario1() throws Exception {
        // when or act
        MockHttpServletResponse response = mockMvc
                .perform(
                        put("/medicamentos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content('{' +
                                        "\"id\": 3," +
                                        "\"reacoes\": [9, 11]" +
                                        '}')
                                .characterEncoding("UTF-8")
                ).andReturn().getResponse();

        String jsonResponse = response.getContentAsString();
        Integer id = JsonPath.parse(jsonResponse).read("$['id']");
        String jsonDB = jsonCadastroOutput(id.longValue());

        // then or assert
        assertEquals(response.getStatus(), HttpStatus.OK.value());
        assertEquals(jsonResponse, jsonDB);
    }

    private String jsonCadastroInput(String nome, String registroAnvisa, Long fabricanteId, List<Long> reacoes) throws IOException {

        LocalDate nextYear = LocalDate.now().plusYears(1);

        DadosCadastroMedicamento dto = new DadosCadastroMedicamento(
                nome,
                registroAnvisa,
                nextYear,
                "(11)2536-6352",
                BigDecimal.valueOf(9.99),
                16,
                fabricanteId,
                reacoes);

        return dadosCadastroMedicamentoJson.write(dto).getJson();
    }

    private String jsonCadastroOutput(Long id) throws IOException {
        Medicamento medicamento = medicamentoRepository.getReferenceById(id);
        DadosDetalhamentoMedicamento dto = new DadosDetalhamentoMedicamento(medicamento);
        return dadosDetalhamentoMedicamentoJson.write(dto).getJson();
    }
}