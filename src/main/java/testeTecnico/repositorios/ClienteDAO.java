package testeTecnico.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import testeTecnico.entidades.Cliente;

@Repository
public interface ClienteDAO extends CrudRepository<Cliente, Long>{
}
