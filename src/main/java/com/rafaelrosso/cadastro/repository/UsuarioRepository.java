package com.rafaelrosso.cadastro.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.rafaelrosso.cadastro.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Optional<UserDetails> findByEmail(String login);
	
}
