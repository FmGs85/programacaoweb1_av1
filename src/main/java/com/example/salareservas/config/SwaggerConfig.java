package com.example.salareservas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema de Reserva de Salas API")
                        .version("1.0.0")
                        .description("API REST para gerenciamento de reservas de salas e ambientes")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact()
                                .name("Equipe de Desenvolvimento")
                                .email("dev@example.com")
                                .url("https://example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Servidor de Desenvolvimento"),
                        new Server().url("https://api.example.com").description("Servidor de Produção")
                ));
    }
}
