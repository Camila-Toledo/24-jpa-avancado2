package br.com.glandata.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "computadores")
public class Computador extends Produto {

	public Computador() {
	}

	public Computador(String processador, String potencia) {
		this.processador = processador;
		this.potencia = potencia;
	}

	@Getter
	@Setter
	private String processador;

	@Getter
	@Setter
	private String potencia;
}
