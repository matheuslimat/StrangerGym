package com.pp.strangergym.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pp.strangergym.models.Professor;
import com.pp.strangergym.services.ProfessorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api") // tem q ser um substantivo n pode ser verbo
@Api(value = "API REST Academia") // anotação do swagger
@CrossOrigin(origins = "*") // qualquer protocolo acessa essa api n só http
public class ProfessorController {
	
	@Autowired
	ProfessorService ps;
	
	@GetMapping("/professor")
	@ApiOperation(value = "Retorna todos os Professores")
	public @ResponseBody Iterable<Professor> listarAlunos() { // 
		return ps.findAll();
	}
	
	@GetMapping("/professor/{login}")
	@ApiOperation(value = "Retorna um professor quando especificado o login")
	public @ResponseBody Professor getProfessor(@PathVariable("login") String login) { // 
		return ps.find(login);
	}
	
	@PostMapping("/professor")
	@ApiOperation(value = "Cadastra um professor")
	public Professor cadastrarAluno(@RequestBody @Valid Professor professor) {
		return ps.create(professor);
	}
	
}
