package br.com.glandata.jpa.main;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.NotaFiscalDao;
import br.com.glandata.jpa.model.NotaFiscal;
import br.com.glandata.jpa.util.JPAUtil;

public class PerformanceDeConsultas2 {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		// NotaFiscal nf = em.find(NotaFiscal.class, 1L);
		// em.close();
		// System.out.println(nf.getCliente().getNome());

		NotaFiscalDao notaFiscalDao = new NotaFiscalDao(em);

		NotaFiscal nf = notaFiscalDao.buscaNotaFiscalComCliente(1L);

		System.out.println(nf.getCliente().getNome());
	}

}
