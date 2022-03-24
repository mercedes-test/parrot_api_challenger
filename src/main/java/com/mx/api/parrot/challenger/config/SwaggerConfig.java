package com.mx.api.parrot.challenger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.mx.api.parrot.challenger"))
				.paths(PathSelectors.ant("/**")).build();
	}

	/**
	 * Gestion de entidades
	 * 
	 * @return Documentacion swagger Usuarios
	 */
	@Bean
	public Docket apiManagementEntities() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("User Management").select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.ant("/api/management/**")).build()
				.apiInfo(apiInfo());
	}

	/**
	 * Gestion de entidades
	 * 
	 * @return Documentacion swagger para gestion de lista de  articulos.
	 */
	@Bean
	public Docket apiOrders() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Order").select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.ant("/api/order/**")).build()
				.apiInfo(apiInfo());
	}
	
	/**
	 * Gestion de entidades
	 * 
	 * @return Documentacion swagger para gestion de reportes
	 */
	@Bean
	public Docket apiBooks() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Books Google").select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.ant("/api/report/**")).build()
				.apiInfo(apiInfo());
	}

	/**
	 * Informacion general de Api.
	 *
	 * @return Informacion de Api.
	 */
	private ApiInfo apiInfo() {
		@SuppressWarnings("rawtypes")
		List<VendorExtension> list = new ArrayList<>();
		return new ApiInfo("API Parrot Challenger", "Order client", "0.0.1-SNAPSHOT",
				"Test Parrot", new Contact("Parrot", "", ""), "Parrot", "", list);
	}
}
