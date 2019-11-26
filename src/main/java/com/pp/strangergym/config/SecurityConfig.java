package com.pp.strangergym.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.pp.strangergym.security.JWTAuthenticationFilter;
import com.pp.strangergym.security.JWTAuthorizationFilter;
import com.pp.strangergym.security.JWTutil;
import com.pp.strangergym.services.AlunoService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private JWTutil jwtUtil;
	
	@Autowired
	private UserDetailsService userService;
	
	public static final String[] PUBLIC_MATCHERS = {
			"api/aluno",
			"/swagger-ui.html#/",
			"/login"
		};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.antMatchers(HttpMethod.GET, "/api/professor/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/aluno/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/treino").permitAll()
			.antMatchers(HttpMethod.POST, "/api/aluno/**").permitAll()
			.antMatchers(HttpMethod.DELETE, "/api/aluno/**").permitAll()
			.antMatchers(HttpMethod.POST, "/api/treino").permitAll()
			.antMatchers("/", "/v2/api-docs", "/configuration/ui", "/swagger-resources", "/swagger-resources/**",
			"/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil))
			.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userService))
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncorder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncorder());
	}
	
	@Bean
    CorsConfigurationSource configurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedHeader("*");
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
