package br.com.krejci.transactionmanager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket accountApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("accounts").select()
                .apis(RequestHandlerSelectors.basePackage("br.com.krejci.transactionmanager.adapter.inbound.rest.account"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    @Bean
    public Docket transactionApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("transactions").select()
                .apis(RequestHandlerSelectors.basePackage("br.com.krejci.transactionmanager.adapter.inbound.rest.transaction"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Transaction Manager",
                "Transaction manager",
                "API v1",
                "to be  defined",
                new Contact("rafael krejci", "to be defined", "rafael.krejci@gmail.com"),
                "To be defined", "API license URL", Collections.emptyList());
    }
}