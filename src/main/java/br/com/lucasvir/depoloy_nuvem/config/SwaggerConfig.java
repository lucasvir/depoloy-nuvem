package br.com.lucasvir.depoloy_nuvem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private Contact createContact() {
        Contact contact = new Contact();
        contact.setName("Lucas do Amaral Virmond");
        contact.setUrl("http://github.com/lucasvir");

        return contact;
    }

    @Bean
    public OpenAPI cadeOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Santander BootCamp - Deploy Cloud")
                                .description("API para estudos no Santander BootCamp.")
                                .version("1.0")
                                .contact(createContact())
                );
    }
}
