package senai.sc.br.situacao2015.dao;

import java.util.List;

import javax.persistence.Query;

import senai.sc.br.situacao2015.entity.Funcionario;

public class FuncionarioDao extends Dao{
	
	public void salvar(Funcionario funcionario){
		getEntityManager().merge(funcionario);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listarTodos() {
		Query query = getEntityManager().createQuery("From Funcionario",Funcionario.class);
		return query.getResultList();
	}

	public void excluir(Long id) {
	    Funcionario funcionario = getEntityManager().getReference(Funcionario.class, id);
		getEntityManager().remove(funcionario);
	}

	public Funcionario buscarPorId(Long id) {
		return getEntityManager().find(Funcionario.class, id);
	}


}
