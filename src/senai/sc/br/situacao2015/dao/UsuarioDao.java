//package senai.sc.br.situacao2015.dao;
//
//import javax.persistence.Query;
//
//import senai.sc.br.situacao2015.entity.Usuario;
//
//
//
//public class UsuarioDao extends Dao {
//	
//	public Usuario buscaPonNome(String nome) {
//		Query query = getEntityManager().createQuery("From Usuario u Where u.nome = :nome", Usuario.class);
//		query.setParameter("nome", nome);
//		return (Usuario) query.getSingleResult();
//	}
//}
