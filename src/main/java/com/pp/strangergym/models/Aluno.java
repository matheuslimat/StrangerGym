package com.pp.strangergym.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.pp.strangergym.enums.RoleEnum;

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

	@OneToOne(cascade = CascadeType.REMOVE) // Removendo o aluno remove o treino associado a ele
	@JoinColumn(name="id_login")
	private Treino treino;

	
	@ManyToOne(cascade = CascadeType.ALL)
	private Professor professor;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="Permissao_Aluno")
	private Set<Integer> role = new HashSet<Integer>();
	
	public Set<RoleEnum> getRole() {
		return role.stream().map(x -> RoleEnum.toEnum(x)).collect(Collectors.toSet());
	}

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
	
	public void addRole(RoleEnum role) {
		this.role.add(role.getCod());
	}

}
