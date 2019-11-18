package com.pp.strangergym.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLogin;
	
	@NotBlank
	private String login;

	@NotBlank
	private String senha;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	private String sexo;

	@NotBlank
	private String anoNasc;

	@OneToOne
	@JoinColumn(name="id_login")
	//esse treino vai dar o joincolumn no id_login ou seja vai pertencer a esse aluno
	private Treino treino;

//	@OneToOne
//	private Professor professor;

	public Aluno() {
	}

	public Aluno(String login, @NotBlank String senha, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String sexo, @NotBlank String anoNasc, Treino treino) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.anoNasc = anoNasc;
		this.treino = treino;
	}

}
