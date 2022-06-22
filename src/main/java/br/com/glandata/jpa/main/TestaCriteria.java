package br.com.glandata.jpa.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class TestaCriteria {

	public static void main(String[] args) {

		LocalDate data = LocalDate.of(2022, 6, 21);

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);

		List<Produto> produtos = produtoDao.buscarPorParametrosComCriteria(null, new BigDecimal("3000"), data);

		produtos.forEach(p -> System.out.println(p.getNome()));

	}

}
