package co.mainsoft.prueba.repositorio.entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetalleVenta;

    @JoinColumn(referencedColumnName = "idVenta")
    @ManyToOne()
    private Venta idVenta;
    @JoinColumn(referencedColumnName = "idProducto")
    @ManyToOne()
    private Producto idProducto;
}
