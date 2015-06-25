package senai.sc.br.situacao2015.dao;

import java.util.List;

import javax.persistence.Query;

import senai.sc.br.situacao2015.entity.TipoCardapio;



public class TipoCardapioDao extends Dao {

	@SuppressWarnings("unchecked")
	public List<TipoCardapio> listarTodos() {
		Query query = getEntityManager().createQuery("From TipoCardapio",
				TipoCardapio.class);
		return query.getResultList();
	}

	public TipoCardapio buscaPorId(Long id) {
		return getEntityManager().getReference(TipoCardapio.class, id);
	}

}
