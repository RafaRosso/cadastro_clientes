package com.rafaelrosso.cadastro.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rafaelrosso.cadastro.model.Usuario;
import com.rafaelrosso.cadastro.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return usuarioRepository.findByEmail(login).orElseThrow(() -> new EntityNotFoundException("Usuario não cadastrado.") );
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
 

}
