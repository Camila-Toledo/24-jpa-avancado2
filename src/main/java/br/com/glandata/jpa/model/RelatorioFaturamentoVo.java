package br.com.glandata.jpa.model;

import java.time.LocalDate;

import lombok.Getter;

public class RelatorioFaturamentoVo {

	public RelatorioFaturamentoVo() {
	}

	public RelatorioFaturamentoVo(String nomeProduto, Long quantidade, LocalDate dataUltimaCompra) {
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.dataUltimaCompra = dataUltimaCompra;
	}

	@Getter
	private String nomeProduto;

	@Getter
	private Long quantidade;

	@Getter
	private LocalDate dataUltimaCompra;

}
