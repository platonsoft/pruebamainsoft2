package co.mainsoft.prueba.repositorio.daos;

import co.mainsoft.prueba.repositorio.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoDao extends JpaRepository<Producto, Long> {
}
