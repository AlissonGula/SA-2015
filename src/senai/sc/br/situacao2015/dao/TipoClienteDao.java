package senai.sc.br.situacao2015.dao;

import java.util.List;

import javax.persistence.Query;

import senai.sc.br.situacao2015.entity.TipoCliente;

public class TipoClienteDao extends Dao {


	@SuppressWarnings("unchecked")
	public List<TipoCliente> listarTodos() {
		Query query = getEntityManager().createQuery("From TipoCliente",
				TipoCliente.class);
		return query.getResultList();
	}

	public TipoCliente buscaPorId(Long id) {
		return getEntityManager().getReference(TipoCliente.class, id);
	}

}
