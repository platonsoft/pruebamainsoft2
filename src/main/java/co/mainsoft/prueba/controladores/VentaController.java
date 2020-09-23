package co.mainsoft.prueba.controladores;

import co.mainsoft.prueba.repositorio.daos.IDetalleVentaDao;
import co.mainsoft.prueba.repositorio.daos.IVentaDao;
import co.mainsoft.prueba.repositorio.entidades.DetalleVenta;
import co.mainsoft.prueba.repositorio.entidades.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rx.Observable;
import rx.Subscription;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/venta")
public class VentaController {

    @Autowired
    private IVentaDao iVentaDao;

    @Autowired
    private IDetalleVentaDao iDetalleVentaDao;

    @GetMapping("lista")
    private List<Venta> listaVentas(){
        return iVentaDao.findAll();
    }

    @GetMapping("{idVenta}")
    private Subscription getVentaDetalle(@PathVariable Long idVenta){
        return Observable.just(iDetalleVentaDao.findAllByIdVenta_IdVenta(idVenta)).subscribe();
    }

    @GetMapping("{idCliente}")
    private Subscription getVentaCliente(@PathVariable Long idCliente){
        return Observable.just(iDetalleVentaDao.findAllByIdCliente_idCliente(idCliente)).subscribe();
    }

    @PostMapping("nuevo")
    private Venta addVenta(@RequestBody Venta venta){
        return iVentaDao.save(venta);
    }
}
