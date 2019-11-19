package com.pp.strangergym.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pp.strangergym.enums.RoleEnum;

import lombok.Data;

@Data
@Entity
@Table(name = "aluno")
public class Aluno implements UserDetails,Serializable {
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
	private Treino treino;

	@ManyToOne()
	private Professor professor;
	
	private RoleEnum role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(role);
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

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}


}
