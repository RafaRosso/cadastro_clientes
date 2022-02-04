package com.rafaelrosso.cadastro.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelrosso.cadastro.exception.ClienteNotFoundException;
import com.rafaelrosso.cadastro.model.Cliente;
import com.rafaelrosso.cadastro.repository.ClienteRepository;


//Todas as classes de service tem o objetivo de utilzar os repositories e adicionar valicoes necessarias
//Faz parte de um utilizado na comunidade
@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Transactional
	public Cliente save(Cliente novoCliente) {
		var clienteExists = clienteRepository.findByCpfCnpj(novoCliente.getCpfCnpj());
		
		if(clienteExists != null){
			throw new ClienteNotFoundException("Cliente já cadastrado.");
		}
			
		var saved = clienteRepository.save(novoCliente);
		
		return saved;
	}
	
	public void delete(Long id) {
		this.findById(id);
		
		clienteRepository.deleteById(id);
	}
	
	public List<Cliente> listar(){
		
		return clienteRepository.findAll();
	}

	public Cliente findById(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado"));
	}

}
