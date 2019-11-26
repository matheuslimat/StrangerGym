package com.pp.strangergym.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pp.strangergym.models.Aluno;
import com.pp.strangergym.services.AlunoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api") // tem q ser um substantivo n pode ser verbo
@Api(value = "API REST Academia") // anotação do swagger
@CrossOrigin(origins = "*") // qualquer protocolo acessa essa api n só http
public class AlunoController {
	
	@Autowired
	AlunoService as;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_PROFESSOR')")
	@GetMapping("/aluno")
	@ApiOperation(value = "Retorna todos os Alunos")
	public @ResponseBody Iterable<Aluno> listarAlunos() { // 
		return as.findAll();
	}
	
	@GetMapping("/aluno/{login}")
	@ApiOperation(value = "Retorna um aluno quando especificado o login")
	public @ResponseBody Aluno getAluno(@PathVariable("login") String login) { // 
		return as.find(login);
	}
	
	@PreAuthorize("hasRole('ROLE_USUARIO')")
	@PostMapping("/aluno")
	@ApiOperation(value = "Cadastra um aluno")
	public Aluno cadastrarAluno(@RequestBody @Valid Aluno aluno) {
		return as.create(aluno);
	}
	
	// response body pq estamos passando o login no corpo da requisição
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/aluno/{login}")
	@ApiOperation(value = "Deleta um aluno passando login dele")
	public @ResponseBody void  delete(@PathVariable("login") String login) {
		as.delete(login);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/aluno")
	@ApiOperation(value = "Atualiza nome e treino do aluno passando o Json dele")
	public Aluno atualizarTreino(@RequestBody Aluno aluno) {
		return as.update(aluno);
	}
	
}
