package br.com.glandata.jpa.main;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.ClienteDao;
import br.com.glandata.jpa.dao.NotaFiscalDao;
import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Cliente;
import br.com.glandata.jpa.model.ItemNotaFiscal;
import br.com.glandata.jpa.model.NotaFiscal;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class GeraNotaFiscal {

	public static void main(String[] args) {

		// Este método invoca a classe que popula os dados
		PopulaDados.cadastraDadosBase();

		EntityManager em = JPAUtil.getEntityManager();

		ClienteDao clienteDao = new ClienteDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		NotaFiscalDao notaFiscalDao = new NotaFiscalDao(em);

		em.getTransaction().begin();

		Cliente cliente1 = clienteDao.buscarPorId(1L); // Busca cliente a partir do id informado

		Produto produto1 = produtoDao.buscarPorId(1L);
		Produto produto2 = produtoDao.buscarPorId(2L);
		Produto produto3 = produtoDao.buscarPorId(3L);

		NotaFiscal notaFiscal = new NotaFiscal(cliente1);
		notaFiscal.adicionarItem(new ItemNotaFiscal(2, notaFiscal, produto1));
		notaFiscal.adicionarItem(new ItemNotaFiscal(1, notaFiscal, produto2));
		notaFiscal.adicionarItem(new ItemNotaFiscal(4, notaFiscal, produto3));

		notaFiscal.calculaTotalNotaFiscal();

		notaFiscalDao.cadastrar(notaFiscal);

		em.getTransaction().commit();

		em.close();

	}

}
