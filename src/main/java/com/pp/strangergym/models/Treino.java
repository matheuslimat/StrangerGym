package com.pp.strangergym.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Treino implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTreino;
	
	private String titulo;
	
	private String descricao;
	
	private String dataInicio;
	
	private String dataFim;
	
	@OneToOne
	private Aluno aluno;

}
