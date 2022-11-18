package com.algaworks.delivery.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.delivery.domain.model.Cliente;
import com.algaworks.delivery.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor // gera instância dos objetos declarados
@RestController
@RequestMapping("/clientes") //evita repetição de caminho para cada @GetMapping
public class ClienteController {

	
	// @Autowired --> notação para criar automaticamente a instância do repository
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		
		//return clienteRepository.findByNome("Joao da Silva");
		//return clienteRepository.findByNomeContaining("a");
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> getCliente(@PathVariable Long clienteId) {

		return clienteRepository.findById(clienteId)
//				.map(opCliente -> ResponseEntity.ok(opCliente))
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		
//		Optional<Cliente> opCliente = clienteRepository.findById(clienteId);
		
//		if(opCliente.isPresent()) {
//			return ResponseEntity.ok(opCliente.get());
//		}
//		else {
//			return ResponseEntity.notFound().build();
//		}
	}
	
	@PostMapping            //@RequestBody desserializa o body que vem em JSON para objeto Java
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastrar(@RequestBody Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, 
			@RequestBody Cliente cliente) {
		
		if(!clienteRepository.existsById(clienteId))
			return ResponseEntity.notFound().build();
		
		cliente.setId(clienteId);
		cliente = clienteRepository.save(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> excluir (@PathVariable Long clienteId) {
		
		if(!clienteRepository.existsById(clienteId))
			return ResponseEntity.notFound().build();
		
		clienteRepository.deleteById(clienteId);
		
		return ResponseEntity.noContent().build(); //response no content() para responstas sem body
	}
}
