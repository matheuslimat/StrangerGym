package com.pp.strangergym.strangergym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.pp.strangergym.models"})
@EnableJpaRepositories({"com.pp.strangergym.repository"})
@ComponentScan({"com.pp.strangergym.controllers","com.pp.strangergym.strangergym", "com.pp.strangergym", "com.pp.strangergym.repository", "com.pp.strangergym.models", "com.pp.strangergym.services" })
public class StrangergymApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StrangergymApplication.class, args);
	}
	
}
