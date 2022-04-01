package testeTecnico.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import testeTecnico.entidades.Cliente;

@Repository
@Transactional
public interface ClienteDAO extends CrudRepository<Cliente, Long>{

}
