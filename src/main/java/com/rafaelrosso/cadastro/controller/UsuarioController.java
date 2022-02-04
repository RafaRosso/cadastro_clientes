package com.rafaelrosso.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelrosso.cadastro.model.Usuario;
import com.rafaelrosso.cadastro.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
	
}
