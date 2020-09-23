package co.mainsoft.prueba.controladores;

import co.mainsoft.prueba.repositorio.daos.IClienteDao;
import co.mainsoft.prueba.repositorio.entidades.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private IClienteDao iClienteDao;

    @PostMapping("nuevo")
    private Cliente addProducto(@RequestBody Cliente cliente){
        return iClienteDao.save(cliente);
    }
}
