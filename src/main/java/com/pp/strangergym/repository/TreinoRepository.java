package com.pp.strangergym.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pp.strangergym.models.Treino;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long>{

}
