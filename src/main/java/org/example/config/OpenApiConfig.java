package org.example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Ордер",
                description = "API order",
                version = "1.0.0",
                contact = @Contact(
                        name = "Nikita",
                        email = "test@gmail.com",
                        url = "https://github.com/Turfal"
                )
        )
)
public class OpenApiConfig {
    // Конфигурация для Swagger
}