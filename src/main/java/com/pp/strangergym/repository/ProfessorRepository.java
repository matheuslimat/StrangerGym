package com.pp.strangergym.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pp.strangergym.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String>{
	@Query("SELECT u FROM Professor u WHERE u.professorLogin = :professorLogin")
	Professor findByUsername(@Param("professorLogin") String login);
}
