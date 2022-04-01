package testeTecnico.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import testeTecnico.entidades.Licenca;

@Repository
@Transactional
public interface LicencaDAO extends CrudRepository<Licenca, Long>{

}
