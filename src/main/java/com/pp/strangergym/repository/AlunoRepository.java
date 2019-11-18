package com.pp.strangergym.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pp.strangergym.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String>{
	Optional<Aluno> findById(String login);
}
