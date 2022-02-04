package com.rafaelrosso.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rafaelrosso.cadastro.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	//Find [e montado em tempo de execucao, o spring cria um select filtrado pelo campo especifico no caso cpfCnpj
	Cliente findByCpfCnpj(String cpfCnpj);
	
}
