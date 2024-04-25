package tn.esprit.spring.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());

    }

    public Info infoAPI() {
        return new Info().title("\uD83C\uDFBF cloud9 \uD83D\uDEA0")
                .description("Case Study - pi")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        return new Contact().name("cloud9")
                .email("yesmine.guesmi@esprit.tn");
    }


    @Bean
    public GroupedOpenApi productPublicApi() {
        return GroupedOpenApi.builder()
                .group("cloud9")
                .pathsToMatch("/**/**")
                .pathsToExclude("**")
                .build();
    }


}
