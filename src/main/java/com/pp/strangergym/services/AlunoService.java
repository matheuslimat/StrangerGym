package com.pp.strangergym.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pp.strangergym.enums.RoleEnum;
import com.pp.strangergym.models.Aluno;
import com.pp.strangergym.repository.AlunoRepository;

@Service
public class AlunoService implements UserDetailsService {

	@Autowired
	private AlunoRepository ar;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Aluno find(String login) {
		Aluno aluno = ar.findByLogin(login);
		return aluno;
	}
	
	public Iterable<Aluno> findAll() {
		Iterable<Aluno> listaAlunos = ar.findAll();
		return listaAlunos;
	}
	
	public Aluno create(Aluno aluno) {
		aluno.setSenha(encoder.encode(aluno.getSenha()));
		// o role deve ser especificado tambem na classe springsecurity
		//aluno.setRole(RoleEnum.CLIENTE);
		return ar.save(aluno);
		
//		ar.save(aluno);
//		return aluno;
	}
	
	public void delete(String login) {
		Aluno aluno = ar.findById(login).get();
		ar.delete(aluno);
	}
	
	public Aluno update(Aluno aluno) {
		Aluno newObj = find(aluno.getLogin());
		updateData(newObj, aluno);
		
		return ar.save(newObj);
	}

	private void updateData(Aluno newObj, Aluno aluno) {
		newObj.setNome(aluno.getNome());
		newObj.setTreino(aluno.getTreino());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return find(username);
	}

}
