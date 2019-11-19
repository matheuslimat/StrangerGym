package com.pp.strangergym.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pp.strangergym.models.Aluno;
import com.pp.strangergym.security.services.TokenService;
import com.pp.strangergym.services.AlunoService;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
	private AlunoService service;
	
	public JWTLoginFilter(String url, AuthenticationManager authManager,AlunoService service) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
		this.service = service;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException {
		
		Aluno credentials = new ObjectMapper()
				.readValue(request.getInputStream(), Aluno.class);
		
		Aluno usuarioCompleto = service.find(credentials.getLogin());
		
		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(
						credentials.getLogin(), 
						credentials.getSenha(), 
						usuarioCompleto.getAuthorities()
						)
				);
	}
	
	@Override
	protected void successfulAuthentication(
			HttpServletRequest request, 
			HttpServletResponse response,
			FilterChain filterChain,
			Authentication auth) throws IOException, ServletException {
		
		TokenService.addAuthentication(response, auth.getName());
	}

}