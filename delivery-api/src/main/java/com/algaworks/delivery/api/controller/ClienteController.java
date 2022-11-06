package com.algaworks.delivery.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.delivery.domain.model.Cliente;


@RestController
public class ClienteController {

	@PersistenceContext   // notação para manager de comunicação model e banco de dados
	private EntityManager manager; 
	
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		return manager.createQuery("from Cliente", Cliente.class)
			.getResultList();
		
	}
	
}
