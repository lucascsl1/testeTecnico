package testeTecnico.repositorios.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import testeTecnico.entidades.Cliente;
import testeTecnico.entidades.Licenca;
import testeTecnico.entidades.Produto;

@Repository
public class RepositorioDAOImplementation {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("deprecation")
	private Criteria criteria(final Class<?> clazz)	{
		return entityManager.unwrap(Session.class).createCriteria(clazz);
	}

	@SuppressWarnings("unchecked")
	public List<Licenca> licencasPorCliente(Cliente cliente) {
		Criteria criteria = criteria(Licenca.class);
		criteria.add(Restrictions.eq("cliente", cliente));

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> produtosPorCliente(Cliente cliente) {
		Criteria criteria = criteria(Produto.class);
		criteria.add(Restrictions.eq("cliente", cliente));

		return criteria.list();
	}

}
