package br.com.glandata.jpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.model.NotaFiscal;
import br.com.glandata.jpa.model.RelatorioFaturamentoVo;

public class NotaFiscalDao {

	private EntityManager em;

	public NotaFiscalDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(NotaFiscal notaFiscal) {
		em.persist(notaFiscal);
	}

	public void atualizar(NotaFiscal notaFiscal) {
		em.merge(notaFiscal);
	}

	public void remover(NotaFiscal notaFiscal) {
		notaFiscal = em.merge(notaFiscal);
		em.remove(notaFiscal);
	}

	public NotaFiscal buscarPorId(Long id) {
		return em.find(NotaFiscal.class, id);
	}

	public List<NotaFiscal> listarTodos() {
		String jpql = "SELECT nf FROM NotaFiscal nf";
		return em.createQuery(jpql, NotaFiscal.class).getResultList();
	}

	public BigDecimal totalFaturado() {
		String jpql = "SELECT SUM(nf.valorTotal) FROM NotaFiscal nf";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}

	public List<RelatorioFaturamentoVo> relatorioDeFaturamento() {
		String jpql = "SELECT new br.com.glandata.jpa.model.RelatorioFaturamentoVo ( " 
					+ "produto.nome, "
					+ "SUM(item.quantidade) as quantidade, " 
					+ "MAX(notaFiscal.data) )" + "FROM NotaFiscal notaFiscal "
					+ "JOIN notaFiscal.itens item " 
					+ "JOIN item.produto produto " 
					+ "GROUP BY produto.nome "
					+ "ORDER BY quantidade DESC";

		return em.createQuery(jpql, RelatorioFaturamentoVo.class).getResultList();
	}

	public NotaFiscal buscaNotaFiscalComCliente(Long id) {
		String jpql = "SELECT nf FROM NotaFiscal nf JOIN FETCH nf.cliente WHERE nf.id = :id";
		return em.createQuery(jpql, NotaFiscal.class).setParameter("id", id).getSingleResult();
	}

}
