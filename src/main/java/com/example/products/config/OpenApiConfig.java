package com.example.products.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${server.port:8080}")
    private String serverPort;

    @Bean
    public OpenAPI customOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:" + serverPort);
        devServer.setDescription("Development server");

        Contact contact = new Contact();
        contact.setEmail("admin@products.com");
        contact.setName("Products API Team");
        contact.setUrl("https://www.products.com");

        License mitLicense = new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Products Management API")
                .version("1.0.0")
                .contact(contact)
                .description("This API exposes endpoints to manage products and categories in an e-commerce system.")
                .termsOfService("https://www.products.com/terms")
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer));
    }
}