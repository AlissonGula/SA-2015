package senai.sc.br.situacao2015.dao;

import java.util.List;

import javax.persistence.Query;

import senai.sc.br.situacao2015.entity.Reserva;


public class ReservaDao extends Dao{

	public void salvar(Reserva reserva){
		getEntityManager().merge(reserva);
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> listarTodos() {
		Query query = getEntityManager().createQuery("From Rserva",Reserva.class);
		return query.getResultList();
	}

	public void excluir(Long id) {
		Reserva reserva = getEntityManager().getReference(Reserva.class, id);
		getEntityManager().remove(reserva);
	}

	public Reserva buscarPorId(Long id) {
		return getEntityManager().find(Reserva.class, id);
	}

	
}
