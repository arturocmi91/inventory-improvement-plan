package com.artiraci.inventoryimprovementplan;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryImprovementPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryImprovementPlanApplication.class, args);
	}
@Bean
	public OpenAPI customOpenAPI(){
		return  new OpenAPI()
				.info(new Info()
						.title("Inventory Project")
						.version("0.11")
						.description("Sample app with Swagger")
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache2.0").url("https://springdoc.org")));


}
}
