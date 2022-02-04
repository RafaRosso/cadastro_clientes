package com.rafaelrosso.cadastro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.rafaelrosso.cadastro.model.Cliente;
import com.rafaelrosso.cadastro.services.ClienteService;

//Todas as classes controller são responsaveis por definir a interface
//http para que o frontend consiga interagir com o banco de dados
@RestController
@RequestMapping("/comercial/clientes")
public class ClienteController {
	
	
	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping()	
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> listarTodos(){
		
		return clienteService.listar();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody @Valid Cliente novoCliente) {
		
		var saved = clienteService.save(novoCliente);
		
		return saved;
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Cliente update(@PathVariable Long id, @RequestBody @Valid Cliente novoCliente) {
		novoCliente.setId(id);
		
		var saved = clienteService.save(novoCliente);
		
		return saved;
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
	

}
