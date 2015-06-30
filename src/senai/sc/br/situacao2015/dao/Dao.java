package senai.sc.br.situacao2015.dao;

import javax.persistence.EntityManager;

import senai.sc.br.situacao2015.util.JPAUtil;


public abstract class Dao {

	protected EntityManager getEntityManager() {
		return JPAUtil.getEntityManager();
	}
	

}