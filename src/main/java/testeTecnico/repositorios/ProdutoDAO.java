package testeTecnico.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import testeTecnico.entidades.Produto;

@Repository
@Transactional
public interface ProdutoDAO extends CrudRepository<Produto, Long>{

}
