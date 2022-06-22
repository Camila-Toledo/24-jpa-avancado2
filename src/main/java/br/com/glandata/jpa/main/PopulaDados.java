package br.com.glandata.jpa.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.CategoriaDao;
import br.com.glandata.jpa.dao.ClienteDao;
import br.com.glandata.jpa.dao.NotaFiscalDao;
import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Categoria;
import br.com.glandata.jpa.model.Chinelo;
import br.com.glandata.jpa.model.Cliente;
import br.com.glandata.jpa.model.ItemNotaFiscal;
import br.com.glandata.jpa.model.NotaFiscal;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class PopulaDados {

	public static void main(String[] args) {
		cadastraDadosBase();
	}

	public static void cadastraDadosBase() {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		ClienteDao clienteDao = new ClienteDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		NotaFiscalDao notaFiscalDao = new NotaFiscalDao(em);

		Categoria categoria1 = new Categoria("CELULARES");
		Categoria categoria2 = new Categoria("TELEVISORES");
		Categoria categoria3 = new Categoria("VESTUARIO");
		Categoria categoria4 = new Categoria("GAMES");
		categoriaDao.cadastrar(categoria1);
		categoriaDao.cadastrar(categoria2);
		categoriaDao.cadastrar(categoria3);
		categoriaDao.cadastrar(categoria4);

		Chinelo chinelo = new Chinelo();
		chinelo.setCategoria(categoria3);
		chinelo.setMarca("Havainas de Pau");
		chinelo.setNome("Sandalia Havaianas");
		chinelo.setDescricao("Chinelo de Dedo");
		chinelo.setTamanho(39);
		chinelo.setPreco(new BigDecimal("90.00"));
		em.persist(chinelo);

		Cliente cliente1 = new Cliente("Douglas", "456789");
		Cliente cliente2 = new Cliente("Sandra", "789456");
		Cliente cliente3 = new Cliente("Guilherme", "321987");
		Cliente cliente4 = new Cliente("Gustavo", "85271");
		Cliente cliente5 = new Cliente("Ailton", "85271");
		clienteDao.cadastrar(cliente1);
		clienteDao.cadastrar(cliente2);
		clienteDao.cadastrar(cliente3);
		clienteDao.cadastrar(cliente4);
		clienteDao.cadastrar(cliente5);

		Produto produto1 = new Produto("Moto G30", "Celular 4G", new BigDecimal("1200.00"), categoria1);
		Produto produto2 = new Produto("Moto G100", "Celular 5G", new BigDecimal("2000.00"), categoria1);
		Produto produto3 = new Produto("Samsung Galaxy S10", "Smartfone Borda Curva", new BigDecimal("3000.00"),
				categoria1);
		Produto produto4 = new Produto("IPhone 13", "Smartfone Top de Linha Apple", new BigDecimal("10000.00"),
				categoria1);
		Produto produto5 = new Produto("TV Samsung 50", "Televisor de 50 Polegadas", new BigDecimal("2000.00"),
				categoria2);
		Produto produto6 = new Produto("TV Samsung 60", "Televisor de 60 Polegadas", new BigDecimal("3000.00"),
				categoria2);
		Produto produto7 = new Produto("Camisa Social Azul", "Tamanho M - Azul", new BigDecimal("90.00"), categoria3);
		Produto produto8 = new Produto("Camisa Social Verde", "Tamanho p - Verde", new BigDecimal("90.00"), categoria3);
		Produto produto9 = new Produto("Camisa Social Preta", "Tamanho G - Preta", new BigDecimal("90.00"), categoria3);
		Produto produto10 = new Produto("Sonic III", "Jogo Clássico", new BigDecimal("150.00"), categoria4);
		Produto produto11 = new Produto("Free Fire", "Jogo Mobile Viciante", new BigDecimal("20.00"), categoria4);
		Produto produto12 = new Produto("TKOF 97", "The Kinf Of Figherts 97", new BigDecimal("50.00"), categoria4);
		Produto produto13 = new Produto("Forza 5", "Simulador de Corrida", new BigDecimal("250.00"), categoria4);
		produtoDao.cadastrar(produto1);
		produtoDao.cadastrar(produto2);
		produtoDao.cadastrar(produto3);
		produtoDao.cadastrar(produto4);
		produtoDao.cadastrar(produto5);
		produtoDao.cadastrar(produto6);
		produtoDao.cadastrar(produto7);
		produtoDao.cadastrar(produto8);
		produtoDao.cadastrar(produto9);
		produtoDao.cadastrar(produto10);
		produtoDao.cadastrar(produto11);
		produtoDao.cadastrar(produto12);
		produtoDao.cadastrar(produto13);

		NotaFiscal notaFiscal1 = new NotaFiscal(cliente1);
		notaFiscal1.adicionarItem(new ItemNotaFiscal(1, notaFiscal1, produto1));
		notaFiscal1.adicionarItem(new ItemNotaFiscal(1, notaFiscal1, produto10));
		notaFiscal1.adicionarItem(new ItemNotaFiscal(2, notaFiscal1, produto9));
		notaFiscal1.adicionarItem(new ItemNotaFiscal(2, notaFiscal1, produto3));
		notaFiscal1.adicionarItem(new ItemNotaFiscal(3, notaFiscal1, produto6));
		notaFiscal1.adicionarItem(new ItemNotaFiscal(1, notaFiscal1, produto7));
		notaFiscal1.adicionarItem(new ItemNotaFiscal(4, notaFiscal1, produto12));
		notaFiscal1.calculaTotalNotaFiscal();
		notaFiscalDao.cadastrar(notaFiscal1);

		NotaFiscal notaFiscal2 = new NotaFiscal(cliente4);
		notaFiscal2.adicionarItem(new ItemNotaFiscal(3, notaFiscal2, produto13));
		notaFiscal2.adicionarItem(new ItemNotaFiscal(4, notaFiscal2, produto11));
		notaFiscal2.adicionarItem(new ItemNotaFiscal(2, notaFiscal2, produto8));
		notaFiscal2.adicionarItem(new ItemNotaFiscal(1, notaFiscal2, produto4));
		notaFiscal2.adicionarItem(new ItemNotaFiscal(1, notaFiscal2, produto2));
		notaFiscal2.adicionarItem(new ItemNotaFiscal(3, notaFiscal2, produto5));
		notaFiscal2.adicionarItem(new ItemNotaFiscal(5, notaFiscal2, produto12));
		notaFiscal2.adicionarItem(new ItemNotaFiscal(2, notaFiscal2, produto1));
		notaFiscal2.calculaTotalNotaFiscal();
		notaFiscalDao.cadastrar(notaFiscal2);

		NotaFiscal notaFiscal3 = new NotaFiscal(cliente2);
		notaFiscal3.adicionarItem(new ItemNotaFiscal(3, notaFiscal3, produto5));
		notaFiscal3.adicionarItem(new ItemNotaFiscal(3, notaFiscal3, produto12));
		notaFiscal3.adicionarItem(new ItemNotaFiscal(2, notaFiscal3, produto7));
		notaFiscal3.adicionarItem(new ItemNotaFiscal(2, notaFiscal3, produto3));
		notaFiscal3.adicionarItem(new ItemNotaFiscal(1, notaFiscal3, produto11));
		notaFiscal3.calculaTotalNotaFiscal();
		notaFiscalDao.cadastrar(notaFiscal3);

		NotaFiscal notaFiscal4 = new NotaFiscal(cliente5);
		notaFiscal4.adicionarItem(new ItemNotaFiscal(1, notaFiscal4, produto1));
		notaFiscal4.adicionarItem(new ItemNotaFiscal(2, notaFiscal4, produto3));
		notaFiscal4.adicionarItem(new ItemNotaFiscal(3, notaFiscal4, produto6));
		notaFiscal4.adicionarItem(new ItemNotaFiscal(3, notaFiscal4, produto9));
		notaFiscal4.adicionarItem(new ItemNotaFiscal(5, notaFiscal4, produto11));
		notaFiscal4.adicionarItem(new ItemNotaFiscal(1, notaFiscal4, produto7));
		notaFiscal4.adicionarItem(new ItemNotaFiscal(2, notaFiscal4, produto5));
		notaFiscal4.adicionarItem(new ItemNotaFiscal(4, notaFiscal4, produto13));
		notaFiscal4.calculaTotalNotaFiscal();
		notaFiscalDao.cadastrar(notaFiscal4);

		NotaFiscal notaFiscal5 = new NotaFiscal(cliente1);
		notaFiscal5.adicionarItem(new ItemNotaFiscal(2, notaFiscal5, produto7));
		notaFiscal5.adicionarItem(new ItemNotaFiscal(2, notaFiscal5, produto10));
		notaFiscal5.adicionarItem(new ItemNotaFiscal(2, notaFiscal5, produto3));
		notaFiscal5.calculaTotalNotaFiscal();
		notaFiscalDao.cadastrar(notaFiscal5);

		em.getTransaction().commit();
		em.close();
	}
}
