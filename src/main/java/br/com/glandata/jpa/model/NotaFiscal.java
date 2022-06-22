package br.com.glandata.jpa.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal {

	public NotaFiscal() {
	}

	public NotaFiscal(Cliente cliente) {
		this.cliente = cliente;
	}

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;

	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@Getter
	@Setter
	private LocalDate data = LocalDate.now();

	@Getter
	@Setter
	@OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL)
	private List<ItemNotaFiscal> itens = new ArrayList<>();

	public void adicionarItem(ItemNotaFiscal item) {
		itens.add(item);
	}

	public void calculaTotalNotaFiscal() {

//		BigDecimal valorTotalCalculado = BigDecimal.ZERO;
//
//		for (ItemNotaFiscal item : this.itens) {
//
//			BigDecimal precoUnitario = item.getPrecoUnitario();
//			BigDecimal quantidade = new BigDecimal(item.getQuantidade());
//
//			valorTotalCalculado = valorTotalCalculado.add(precoUnitario.multiply(quantidade));
//		}
//
//		this.valorTotal = valorTotalCalculado;

		this.itens.forEach(item -> this.setValorTotal(
				this.valorTotal.add(item.getPrecoUnitario().multiply(new BigDecimal(item.getQuantidade())))));
	}
}
