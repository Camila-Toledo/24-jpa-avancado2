package br.com.glandata.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.model.ItemNotaFiscal;

public class ItemNotaFiscalDao {

	private EntityManager em;

	public ItemNotaFiscalDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(ItemNotaFiscal itemNotaFiscal) {
		em.persist(itemNotaFiscal);
	}

	public void atualizar(ItemNotaFiscal itemNotaFiscal) {
		em.merge(itemNotaFiscal);
	}

	public void remover(ItemNotaFiscal itemNotaFiscal) {
		itemNotaFiscal = em.merge(itemNotaFiscal);
		em.remove(itemNotaFiscal);
	}

	public ItemNotaFiscal buscarPorId(Long id) {
		return em.find(ItemNotaFiscal.class, id);
	}

	public List<ItemNotaFiscal> listarTodos() {
		String jpql = "SELECT inf FROM ItemNotaFiscal inf";
		return em.createQuery(jpql, ItemNotaFiscal.class).getResultList();
	}

}
