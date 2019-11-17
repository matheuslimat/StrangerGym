package com.pp.strangergym.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.pp.strangergym.models.Treino;
import com.pp.strangergym.repository.TreinoRepository;
import com.pp.strangergym.services.TreinoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api") // tem q ser um substantivo n pode ser verbo
@Api(value = "API REST Academia") // anotação do swagger
@CrossOrigin(origins = "*") // qualquer protocolo acessa essa api n só http
public class TreinoController {
	
	@Autowired
	TreinoService ts; // instancia treino service
	
	@GetMapping("/listarTreinos")
	@ApiOperation(value = "Retorna uma lista de Treinos de todo mundo")
	public @ResponseBody Iterable<Treino> listarTreinos() { // 
		Iterable<Treino> listaTreinos = ts.buscarTreinos();
		return listaTreinos;
	}
	
	@GetMapping("/listarTreinos/{idTreino}")
	@ApiOperation(value = "Retorna uma treino quando especificado um idTreino")
	public @ResponseBody Treino getTreino(@PathVariable("idTreino") Long idTreino) { // 
		return ts.buscarTreino(idTreino);
	}
	
//	@PostMapping("/cadastrarTreino")
//	@ApiOperation(value = "Cadastra um treino")
//	public Treino cadastrarTreino(@RequestBody @Valid Treino treino) {
//		return tr.save(treino);
//	}
//	
//	@DeleteMapping("/treino")
//	@ApiOperation(value = "Deleta um treino passando o Json dele")
//	public Treino deletaTreino(@RequestBody Treino treino) {
//		tr.delete(treino);
//		// retorna como resposta o evento q foi deletado
//		return treino;
//	}
//	
//	@PutMapping("/treino")
//	@ApiOperation(value = "Atualiza o treino passando o Json dele")
//	public Treino atualizarTreino(@RequestBody Treino treino) {
//		return tr.save(treino);
//	}
}
