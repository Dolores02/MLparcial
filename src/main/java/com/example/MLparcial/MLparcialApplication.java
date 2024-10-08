package com.example.MLparcial;

import jakarta.transaction.Transactional;
import com.example.MLparcial.entities.Mutante;
import com.example.MLparcial.repositories.MutanteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class MLparcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MLparcialApplication.class, args);
		System.out.println("FUNCIONANDO!!! :) ");
	}

	@Bean
	@Transactional
	CommandLineRunner init(MutanteRepository mutanteRepository) {
		return args -> {

		};
	}
}