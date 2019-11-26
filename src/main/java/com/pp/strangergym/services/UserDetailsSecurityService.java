package com.pp.strangergym.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.pp.strangergym.models.Aluno;
import com.pp.strangergym.security.UserSecutiry;

@Service
public class UserDetailsSecurityService implements UserDetailsService {

	@Autowired
	private AlunoService as;

	@Override
	public UserDetails loadUserByUsername(String login) {
		Aluno aluno = as.find(login);

		return new UserSecutiry(aluno.getIdLogin(), aluno.getLogin(), aluno.getSenha(), aluno.getRole());
	}

}
