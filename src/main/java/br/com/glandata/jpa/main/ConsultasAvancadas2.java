package br.com.glandata.jpa.main;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class ConsultasAvancadas2 {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);

		String nomeProduto = null;
		String nomeCategoria = "Celulares";
		BigDecimal valorInicial = new BigDecimal("2000");
		BigDecimal valorMaximo = new BigDecimal("3000");

		List<Produto> produtosPorParametro = produtoDao.buscarPorParametros(nomeProduto, nomeCategoria, valorInicial, valorMaximo);

		produtosPorParametro.forEach(p -> System.out.println(p));
	}

}
