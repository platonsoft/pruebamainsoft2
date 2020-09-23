package co.mainsoft.prueba.repositorio.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVenta;

    @JoinColumn(referencedColumnName = "idCliente")
    @ManyToOne()
    private Cliente idCliente;
    private Date fecha;

}
