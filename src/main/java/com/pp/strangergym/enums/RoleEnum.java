package com.pp.strangergym.enums;

public enum RoleEnum{
	
	USUARIO(1, "ROLE_USUARIO"),
	PROFESSOR(2, "ROLE_PROFESSOR"),
	ADMIN(3, "ROLE_ADMIN");
	
	private int cod;
	private String descricao;

	private RoleEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static RoleEnum toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (RoleEnum x : RoleEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id Invalido: " + cod);
	}


}
