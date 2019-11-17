package com.pp.strangergym.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.strangergym.models.Treino;
import com.pp.strangergym.repository.TreinoRepository;

@Service
public class TreinoService {
	
	@Autowired
	private TreinoRepository tr;
	
	public Treino buscarTreino(long id) {
		Treino treino = tr.findById(id);
		return treino;
	}
	
	public Iterable<Treino> buscarTreinos() {
		Iterable<Treino> listaTreinos = tr.findAll();
		return listaTreinos;
	}

}
