package co.mainsoft.prueba.repositorio.daos;

import co.mainsoft.prueba.repositorio.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaDao extends JpaRepository<Venta, Long> {
}
