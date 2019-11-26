package com.pp.strangergym.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pp.strangergym.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	Aluno findByLogin(String login);
}
