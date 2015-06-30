package senai.sc.br.situacao2015.dao;

import java.util.List;

import javax.persistence.Query;

import senai.sc.br.situacao2015.entity.TipoMesa;

public class TipoMesaDao extends Dao {

	@SuppressWarnings("unchecked")
	public List<TipoMesa> listarTodos() {
		Query query = getEntityManager().createQuery("From TipoMesa",
				TipoMesa.class);
		return query.getResultList();
	}

	public TipoMesa buscaPorId(Long id) {
		return getEntityManager().getReference(TipoMesa.class, id);
	}

	
}
