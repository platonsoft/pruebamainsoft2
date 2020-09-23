package co.mainsoft.prueba.repositorio.daos;

import co.mainsoft.prueba.repositorio.entidades.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleVentaDao extends JpaRepository<DetalleVenta, Long> {
    List<DetalleVenta> findAllByIdVenta_IdVenta(Long idVenta);

    @Query("select dv from DetalleVenta dv inner join Venta v on v.idCliente.idCliente=?1 ")
    List<DetalleVenta> findAllByIdCliente_idCliente(Long idCliente);

}
