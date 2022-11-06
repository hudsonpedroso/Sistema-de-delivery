package com.algaworks.delivery.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.delivery.domain.model.Cliente;
import com.algaworks.delivery.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor // gera instância dos objetos declarados
@RestController
public class ClienteController {

	
	// @Autowired --> notação para criar automaticamente a instância do repository
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		//return clienteRepository.findByNome("Joao da Silva");
		//return clienteRepository.findByNomeContaining("a");
		return clienteRepository.findAll();
	}
	
}
