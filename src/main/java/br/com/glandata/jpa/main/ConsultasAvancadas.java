package br.com.glandata.jpa.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.NotaFiscalDao;
import br.com.glandata.jpa.util.JPAUtil;

public class ConsultasAvancadas {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		NotaFiscalDao notaFiscalDao = new NotaFiscalDao(em);

		BigDecimal totalFaturado = notaFiscalDao.totalFaturado();

		System.out.println("O total faturado é: R$" + totalFaturado);

		em.close();
	}

}
