package com.grupo19.gastroreserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.grupo19.gastroreserva.infra.persistence")
public class GastroReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GastroReservaApplication.class, args);
	}

}
