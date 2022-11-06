package com.algaworks.delivery.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // --> apenas atributo com notação include será considerado no equal e hashcode

@Entity
//@Table(name = "tb_cliente") --> Exemplo de notação para nome diferente da classe
public class Cliente {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String nome;
	
	private String email;
	
	@Column(name = "fone") // --> setar coluna de nome diferente do BD. 
	private String telefone;
	

	
	public Cliente() {
		
	}
	
	
	
	
}
