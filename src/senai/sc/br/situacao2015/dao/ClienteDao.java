package senai.sc.br.situacao2015.dao;

import java.util.List;

import javax.persistence.Query;

import senai.sc.br.situacao2015.entity.Cliente;



public class ClienteDao extends Dao {

	public void salvar(Cliente cliente){
		getEntityManager().merge(cliente);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarTodos() {
		Query query = getEntityManager().createQuery("From Cliente",Cliente.class);
		return query.getResultList();
	}

	public void excluir(Long id) {
		Cliente cliente = getEntityManager().getReference(Cliente.class, id);
		getEntityManager().remove(cliente);
	}

	public Cliente buscarPorId(Long id) {
		return getEntityManager().find(Cliente.class, id);
	}

}