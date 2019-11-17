package com.pp.strangergym.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String login;
	
	@NotEmpty
	private String senha;
	
	private String nome;
	
	private String sobrenome;
	
	private String sexo;
	
	private Date anoNasc;
	
//	@OneToOne
//	private Treino treino;
//	
//	@OneToOne
//	private Professor professor;
	
}
