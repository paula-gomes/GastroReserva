package com.grupo19.GastroReserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.grupo19.GastroReserva.infra.persistence")
public class GastroReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GastroReservaApplication.class, args);
	}

}
