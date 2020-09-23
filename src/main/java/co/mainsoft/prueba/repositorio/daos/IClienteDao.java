package co.mainsoft.prueba.repositorio.daos;

import co.mainsoft.prueba.repositorio.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Long> {
}
