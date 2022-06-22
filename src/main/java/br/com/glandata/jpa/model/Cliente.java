package br.com.glandata.jpa.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
public class Cliente {

	public Cliente() {
	}
	
	public Cliente(String nome, String cpf) {
		this.dadosPessoais = new DadosPessoais(nome, cpf);
	}
	
	public Cliente(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Embedded
	private DadosPessoais dadosPessoais;
	
	public String getNome() {
		return this.dadosPessoais.getNome();
	}
}
