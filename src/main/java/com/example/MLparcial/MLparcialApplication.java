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

			String[] dna1 = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
			String[] dna2 = {"ATGCGA","CAGTGC","TTATTT", "AGACGG", "GCGTCA", "TCACTG"};

			Mutante mutante = Mutante.builder().build();
            /*
                CASOS MUTANTES

                String[] dnaMutant1 = ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]; // anduvo
                String[] dnaMutant2 = ["ATGCGA", "CAGTGC", "TTAAGT", "AGATGG", "CTCCTA", "TCACTG"]; // no
                String[] dnaMutant3 = ["AAAAAA", "CTGAGA", "TTATGT", "AGACGG", "GCGTCA", "TCACTG"]; // si
                String[] dnaMutant4 = ["ATGCGA", "CAGTGC", "TTAAGT", "AGATGG", "CTGCTA", "TCACTG"]; // no
                String[] dnaMutant5 = ["ATGCGA", "CTGTGC", "TTGTGT", "AGTGGG", "CTCTTA", "TCACTG"]; // si

                CASOS NO MUTANTES
                String[] dnaHuman1 = ["ATGCGA", "CAGTGC", "TTATGT", "AGACGG", "GCGTCA", "TCACTG"];
                String[] dnaHuman2 = ["ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"];
                String[] dnaHuman3 = ["ATGCTA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"];
                String[] dnaHuman4 = ["ATGCGA", "CATGGC", "TTATTT", "AGACGG", "CCGTCA", "TCACTG"];
                String[] dnaHuman5 = ["ATGCGA", "CAGTAC", "TTATTT", "AGTCGG", "GCGTCA", "TCACTG"];

            */

		};
	}
}