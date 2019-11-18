package com.pp.strangergym.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "treino")
public class Treino implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTreino;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String dataInicio;
	
	@NotBlank
	private String dataFim;

//	@OneToOne
//	private Aluno aluno;
	
	
	public Treino() {}

	public Treino(Long idTreino, @NotBlank String titulo, @NotBlank String descricao, @NotBlank String dataInicio,
			@NotBlank String dataFim) {
		super();
		this.idTreino = idTreino;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	
	
}
