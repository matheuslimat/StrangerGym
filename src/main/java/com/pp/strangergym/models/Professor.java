package com.pp.strangergym.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "professor")
public class Professor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String professorLogin;
	
	@NotBlank
	private String senha;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	private String sexo;
	
	@OneToMany()
	@JoinColumn(name = "idProfessor")
	private List<Aluno> alunos = new ArrayList<>();
	
	public Professor() {}

	public Professor(@NotBlank String professorLogin, @NotBlank String senha, @NotBlank String nome,
			@NotBlank String sobrenome, @NotBlank String sexo, List<Aluno> alunos) {
		super();
		this.professorLogin = professorLogin;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.alunos = alunos;
	}
	
	

}
