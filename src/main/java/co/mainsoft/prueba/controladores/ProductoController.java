package co.mainsoft.prueba.controladores;

import co.mainsoft.prueba.repositorio.daos.IProductoDao;
import co.mainsoft.prueba.repositorio.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
public class ProductoController {

    @Autowired
    private IProductoDao iProductoDao;


    @GetMapping("lista")
    private List<Producto> listaProducto(){
        return iProductoDao.findAll();
    }

    @GetMapping("{idProducto}")
    private Producto getProducto(@PathVariable Long idProducto){
        return iProductoDao.getOne(idProducto);
    }

    @PostMapping("nuevo")
    private Producto addProducto(@RequestBody Producto producto){
        return iProductoDao.save(producto);
    }

    @PutMapping("editar")
    private Boolean setProducto(@RequestBody Producto producto){
        iProductoDao.save(producto);
        return true;
    }

    @DeleteMapping("eliminar")
    private Boolean setProducto(@RequestBody Long idProducto){
        iProductoDao.deleteById(idProducto);
        return true;
    }
}
