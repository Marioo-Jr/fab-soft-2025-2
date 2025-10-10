package br.univille.fabsoft_backend;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FabsoftBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabsoftBackendApplication.class, args);
	}
	@Bean
	public GroupedOpenApi userOpenApi() {
	String packagesToscan[] = {"br.univille.fabsoft_backend"};
	return GroupedOpenApi.builder().group("backend").packagesToScan(packagesToscan)
			.build();
	}
}
