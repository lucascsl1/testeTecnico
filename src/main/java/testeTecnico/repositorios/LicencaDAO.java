package testeTecnico.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import testeTecnico.entidades.Licenca;

@Repository
public interface LicencaDAO extends CrudRepository<Licenca, Long>{

}
