package com.carstorewithspring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Loja de Carros")
                        .version("v1")
                        .description("Loja de Carros")
                        .contact(contact())
                );
    }

    private Contact contact() {
        return new Contact()
                .email("kayanbrandao.krb@gmail.com")
                .name("Kayan Rosa Brandão")
                .url("https://github.com/kayanbrandao/car-store-with-spring");
    }
}
