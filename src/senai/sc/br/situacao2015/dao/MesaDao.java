package senai.sc.br.situacao2015.dao;

import java.util.List;

import javax.persistence.Query;

import senai.sc.br.situacao2015.entity.Mesa;

public class MesaDao extends Dao{

	public void salvar(Mesa mesa){
		getEntityManager().merge(mesa);
	}

	@SuppressWarnings("unchecked")
	public List<Mesa> listarTodos() {
		Query query = getEntityManager().createQuery("From Mesa",Mesa.class);
		return query.getResultList();
	}

	public void excluir(Long id) {
		Mesa mesa = getEntityManager().getReference(Mesa.class, id);
		getEntityManager().remove(mesa);
	}

	public Mesa buscarPorId(Long id) {
		return getEntityManager().find(Mesa.class, id);
	}

	
}
