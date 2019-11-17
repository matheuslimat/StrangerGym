package com.pp.strangergym.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api") // tem q ser um substantivo n pode ser verbo
public class TreinoController {
	
	@Autowired
	public TreinoRepository tr;
	
	@GetMapping("/listarTreinos")
	public @ResponseBody Iterable<Treino> listarTreinos() { // 
		Iterable<Treino> listaTreinos = tr.findAll();
		return listaTreinos;
	}
	
	@GetMapping("/listarTreinos/{idTreino}")
	public @ResponseBody Optional<Treino> getTreino(@PathVariable("idTreino") Long idTreino) { // 
		return tr.findById(idTreino);
	}
	
	@PostMapping("/cadastrarTreino")
	public Treino cadastrarTreino(@RequestBody @Valid Treino treino) {
		return tr.save(treino);
	}
	
	@DeleteMapping("/treino")
	public Treino deletaTreino(@RequestBody Treino treino) {
		tr.delete(treino);
		// retorna como resposta o evento q foi deletado
		return treino;
	}
	
	@PutMapping("/treino")
	public Treino atualizarTreino(@RequestBody Treino treino) {
		return tr.save(treino);
	}
}
