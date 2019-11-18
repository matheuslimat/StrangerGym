package com.pp.strangergym.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pp.strangergym.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String>{
	
	@Query("SELECT u FROM Aluno u WHERE u.login = :login")
	Aluno findByUsername(@Param("login") String login);
}
