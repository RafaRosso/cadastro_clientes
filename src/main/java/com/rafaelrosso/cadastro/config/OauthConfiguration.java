package com.rafaelrosso.cadastro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rafaelrosso.cadastro.services.UsuarioService;


//Classe de configuracao de autenticacao
//definido os endpoints q possuem restricao de acesso e quais possuem permissao total
//Nao implementado codificacao de senha
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OauthConfiguration extends WebSecurityConfigurerAdapter {

	private UsuarioService usuarioService;

	@Autowired
	public OauthConfiguration(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		  .disable()
		  .cors()
		  .disable()
		  .authorizeRequests()
          .antMatchers("/comercial/**").hasAuthority("ADMIN")
          .antMatchers("/login/**").permitAll()
          .antMatchers("/usuarios/*").permitAll()
	      .anyRequest()
	      .authenticated()
	      .and()
	      .formLogin()
	      .and()
	      .httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.usuarioService).passwordEncoder(getPasswordEncoder());
	}

	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
