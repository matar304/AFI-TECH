package com.afitech.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI afitechOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API Afitech")
                        .description("Documentation des API Afitech")
                        .version("1.0"))
                .tags(Arrays.asList(
                        new Tag().name("Secrétaires").description("Gestion des secrétaires"),
                        new Tag().name("Étudiants").description("Gestion des étudiants"),
                        new Tag().name("Notes").description("Gestion des notes")
                ));
    }
}
