package br.com.glandata.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "chinelos")
public class Chinelo extends Produto {

	public Chinelo() {
	}

	public Chinelo(String marca, Integer tamanho) {
		this.marca = marca;
		this.tamanho = tamanho;
	}

	@Getter
	@Setter
	private String marca;

	@Getter
	@Setter
	private Integer tamanho;

}
