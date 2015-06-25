package senai.sc.br.situacao2015.dao;

import java.util.List;

import javax.persistence.Query;

import senai.sc.br.situacao2015.entity.TipoReserva;


public class TipoReservaDao extends Dao{

	@SuppressWarnings("unchecked")
	public List<TipoReserva> listarTodos() {
		Query query = getEntityManager().createQuery("From TipoReserva",
				TipoReserva.class);
		return query.getResultList();
	}

	public TipoReserva buscaPorId(Long id) {
		return getEntityManager().getReference(TipoReserva.class, id);
	}
	
}
