package com.algaworks.delivery.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.delivery.domain.model.Cliente;


@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		var c1 = new Cliente();
		c1.setId(1L);
		c1.setNome("João3");
		c1.setTelefone("36529988");
		c1.setEmail("jj@g.com");
		
		var c2 = new Cliente();
		c2.setId(2L);
		c2.setNome("Maria");
		c2.setTelefone("36529977");
		c2.setEmail("mm@g.com");
		
		return Arrays.asList(c1, c2);
	}
	
}
