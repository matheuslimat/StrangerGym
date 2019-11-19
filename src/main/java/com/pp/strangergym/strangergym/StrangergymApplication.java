package com.pp.strangergym.strangergym;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pp.strangergym.controllers.AlunoController;
import com.pp.strangergym.controllers.ProfessorController;
import com.pp.strangergym.controllers.TreinoController;
import com.pp.strangergym.models.Aluno;
import com.pp.strangergym.models.Professor;
import com.pp.strangergym.models.Treino;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.pp.strangergym.models"})
@EnableJpaRepositories({"com.pp.strangergym.repository"})
@ComponentScan({"com.pp.strangergym.controllers","com.pp.strangergym.strangergym", "com.pp.strangergym", "com.pp.strangergym.repository", "com.pp.strangergym.models", "com.pp.strangergym.services", "com.pp.strangergym.config" })
public class StrangergymApplication implements CommandLineRunner {
	
//	@Autowired
//	private BCryptPasswordEncoder pe;
	
	@Autowired
	private TreinoController tc;
//	
	@Autowired
	private AlunoController ac;
	
	@Autowired
	private ProfessorController pc;
	
	public static void main(String[] args) {
		SpringApplication.run(StrangergymApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Treino treino1 = new Treino(Long.parseLong("1"), "Treino master" , "esse treino é master", "02/03/2018", "02/04/2020");
		
		tc.cadastrarTreino(treino1);
		
		Aluno aluno1 = new Aluno("matheus.costa", "aa11bb22", "Matheus", "Lima Tavares", "M", new Date().toString(), treino1);
		
		ac.cadastrarAluno(aluno1);
		
//		Professor professor = new Professor("matheus.professor", "senha", "nome", "sobrenome", "sexo", Arrays.asList(aluno1));
//		
//		pc.cadastrarAluno(professor);
		
	}

	
}
