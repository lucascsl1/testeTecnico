package testeTecnico.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import testeTecnico.entidades.Produto;

@Repository
public interface ProdutoDAO extends CrudRepository<Produto, Long>{

}
