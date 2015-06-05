package senai.sc.br.situacao2015.dao;

import java.util.List;

import javax.persistence.Query;

import senai.sc.br.situacao2015.entity.TipoFuncionario;

public class TipoFuncionarioDao extends Dao{

	@SuppressWarnings("unchecked")
	public List<TipoFuncionario> listarTodos() {
		Query query = getEntityManager().createQuery("From TipoFuncionario",
				TipoFuncionario.class);
		return query.getResultList();
	}

	public TipoFuncionario buscaPorId(Long id) {
		return getEntityManager().getReference(TipoFuncionario.class, id);
	}
}
