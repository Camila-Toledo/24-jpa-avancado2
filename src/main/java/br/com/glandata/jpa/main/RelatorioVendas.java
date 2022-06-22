package br.com.glandata.jpa.main;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.NotaFiscalDao;
import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.model.RelatorioFaturamentoVo;
import br.com.glandata.jpa.util.JPAUtil;

public class RelatorioVendas {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		NotaFiscalDao notaFiscalDao = new NotaFiscalDao(em);

		List<RelatorioFaturamentoVo> listaRelatorio = notaFiscalDao.relatorioDeFaturamento();

		System.out.println("RELATÓRIO DE VENDAS");

		for (RelatorioFaturamentoVo relatorio : listaRelatorio) {

			System.out.println("Produto: " + relatorio.getNomeProduto() + "\t\t Quantidade Vendida: "
					+ relatorio.getQuantidade() + "\t\t Data Última Venda: " + relatorio.getDataUltimaCompra());

		}

		ProdutoDao produtoDao = new ProdutoDao(em);

		List<Produto> produtosPorNomeDaCategoria = produtoDao.buscarPorNomeDaCategoria("Celulares");

		System.out.println("Relatório de produtos por categoria");

		produtosPorNomeDaCategoria.forEach(p -> System.out.println(p));

	}

}
