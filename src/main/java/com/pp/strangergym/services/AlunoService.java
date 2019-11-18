package com.pp.strangergym.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.strangergym.models.Aluno;
import com.pp.strangergym.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository ar;
	
	public Aluno find(String login) {
		Aluno aluno = ar.findByUsername(login);
		return aluno;
	}
	
	public Iterable<Aluno> findAll() {
		Iterable<Aluno> listaAlunos = ar.findAll();
		return listaAlunos;
	}
	
	public Aluno create(Aluno aluno) {
		ar.save(aluno);
		return aluno;
	}
	
	public void delete(String login) {
		Aluno aluno = ar.findById(login).get();
		ar.delete(aluno);
	}
	
	public Aluno update(Aluno aluno) {
		Aluno newObj = find(aluno.getLogin());
		updateData(newObj, aluno);
		
		return ar.save(newObj);
	}

	private void updateData(Aluno newObj, Aluno aluno) {
		newObj.setNome(aluno.getNome());
		newObj.setTreino(aluno.getTreino());
	}

}
