package com.pp.strangergym.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Professor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String login;
	
	@NotEmpty
	private String senha;
	
	private String nome;
	
	private String sobrenome;
	
	private String sexo;
	
	@OneToMany
	private List<Aluno> alunos = new ArrayList<>();
	
	@OneToMany
	private List<Treino> treinos = new ArrayList<Treino>();
	

}
