package com.orderitem.orderitemservice.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	  public Docket mainConfig() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select().apis(RequestHandlerSelectors.any())
	        .paths(PathSelectors.regex("/.*"))
	        .build()
	        .apiInfo(apiInfo())
	        .directModelSubstitute(LocalDate.class, String.class)
	        .genericModelSubstitutes(ResponseEntity.class);
	  }

	  private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	        .title("Order Item Service Management")
	        .description("Order Item Service Management Swagger UI")
	        .version("1.0")
	        .contact(new Contact("Prateek Goyal", "EPAM-DBS", "GoyalPrateek19@gmail.com"))
	        .build();
	  }
}
