package com.pp.strangergym.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Professor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotBlank
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String login;
	
	@NotBlank
	private String senha;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	private String sexo;
	
	@OneToMany
	private List<Aluno> alunos = new ArrayList<>();
	
	@OneToMany
	private List<Treino> treinos = new ArrayList<Treino>();
	

}
