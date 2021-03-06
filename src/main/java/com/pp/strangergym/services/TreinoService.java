package com.pp.strangergym.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.strangergym.models.Treino;
import com.pp.strangergym.repository.TreinoRepository;

@Service
public class TreinoService {
	
	@Autowired
	private TreinoRepository tr;
	
	public Treino find(long id) {
		Treino treino = tr.findById(id);
		return treino;
	}
	
	public Iterable<Treino> findAll() {
		Iterable<Treino> listaTreinos = tr.findAll();
		return listaTreinos;
	}
	
	public Treino create(Treino treino) {
		tr.save(treino);
		return treino;
	}
	
	public Treino delete(Treino treino) {
		tr.delete(treino);
		return treino;
	}
	
	public Treino update(Treino treino) {
		tr.save(treino);
		return treino;
	}

}
