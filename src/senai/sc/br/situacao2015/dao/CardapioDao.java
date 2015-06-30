package senai.sc.br.situacao2015.dao;

import java.util.List;

import javax.persistence.Query;

import senai.sc.br.situacao2015.entity.Cardapio;




public class CardapioDao extends Dao {
	
	public void salvar(Cardapio cardapio){
		getEntityManager().merge(cardapio);
	}

	@SuppressWarnings("unchecked")
	public List<Cardapio> listarTodos() {
		Query query = getEntityManager().createQuery("From Cardapio",Cardapio.class);
		return query.getResultList();
	}

	public void excluir(Long id) {
		Cardapio cardapio = getEntityManager().getReference(Cardapio.class, id);
		getEntityManager().remove(cardapio);
	}

	public Cardapio buscarPorId(Long id) {
		return getEntityManager().find(Cardapio.class, id);
	}


}
