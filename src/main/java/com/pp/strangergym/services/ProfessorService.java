package com.pp.strangergym.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.strangergym.models.Professor;
import com.pp.strangergym.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository pr;
	
	public Professor find(String login) {
		Professor professor = pr.findByUsername(login);
		return professor;
	}
	
	public Iterable<Professor> findAll() {
		Iterable<Professor> listaProfessores = pr.findAll();
		return listaProfessores;
	}
	
	public Professor create(Professor professor) {
		pr.save(professor);
		return professor;
	}

}
