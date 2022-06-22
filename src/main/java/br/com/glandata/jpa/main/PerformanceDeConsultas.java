package br.com.glandata.jpa.main;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.NotaFiscalDao;
import br.com.glandata.jpa.model.NotaFiscal;
import br.com.glandata.jpa.util.JPAUtil;

public class PerformanceDeConsultas {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		NotaFiscalDao notaFiscalDao = new NotaFiscalDao(em);
		
		NotaFiscal nf = notaFiscalDao.buscarPorId(1L);
		
		//System.out.println(nf.getData());

		System.out.println(nf.getItens().size());
}

}
