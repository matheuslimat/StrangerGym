package com.pp.strangergym.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import com.pp.strangergym.security.filters.AuthEntryPoint;
import com.pp.strangergym.services.AlunoService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private AuthEntryPoint entryPoint;

//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable()
//			.authorizeRequests()
//			.antMatchers(SecurityConstants.SWAGGER).permitAll()
//			.antMatchers(HttpMethod.POST, "/aluno/").hasAuthority(RoleEnum.ADMIN.getAuthority())
//			.antMatchers(HttpMethod.POST, "/aluno").permitAll()
//			.antMatchers(HttpMethod.GET, "api/aluno/").permitAll()
//			.antMatchers(HttpMethod.GET, "/treino/**").permitAll()
//			.antMatchers("/professor/**").hasAuthority(RoleEnum.ADMIN.getAuthority())
//			.anyRequest().authenticated().and()
//			.exceptionHandling().authenticationEntryPoint(entryPoint).and()
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager(),alunoService),
//	                UsernamePasswordAuthenticationFilter.class)
//			.addFilterBefore(new JWTAuthenticationFilter(alunoService),
//	                UsernamePasswordAuthenticationFilter.class);
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(alunoService).passwordEncoder(encoder());
//	}
//	
	
	private static final String[] PUBLIC_MATCHERS_GET = {
			"/aluno",
			"/professor/**",
			"/treino/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/professor/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/aluno/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/treino").permitAll()
			.antMatchers(HttpMethod.POST, "/api/aluno/**").permitAll()
			.antMatchers(HttpMethod.DELETE, "/api/aluno/**").permitAll()
			.antMatchers(HttpMethod.POST, "/api/treino").permitAll()
			.antMatchers("/", "/v2/api-docs", "/configuration/ui", "/swagger-resources", "/swagger-resources/**",
			"/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
			.anyRequest().authenticated();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
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
	
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
