package com.jr.store.productservice.adapters.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Beans configuration
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("public-apis")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product-service")
                        .version("1.0.0")
                        .description("Endpoints documentation")
                        .contact(new Contact()
                                .name("Jonathan Rojas")
                                .email("jonathanrojas31@gmail.com")
                                .url("https://www.linkedin.com/in/jnrch/")));
    }
}
