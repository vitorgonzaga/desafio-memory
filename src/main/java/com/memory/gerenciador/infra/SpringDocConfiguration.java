package com.memory.gerenciador.infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gerenciador Medicamento API - Desafio Técnico Memory")
                        .description("API Rest Gerenciador de Medicamentos, contendo as funcionalidades de CRUD de medicamentos")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@memory"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://gerenciador.memory/api/licenca")));
    }

}
