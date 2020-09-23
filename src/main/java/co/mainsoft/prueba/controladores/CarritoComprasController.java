package co.mainsoft.prueba.controladores;

import co.mainsoft.prueba.repositorio.model.Usuario;
import co.mainsoft.prueba.servicios.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class CarritoComprasController {

    @Autowired
    private ICarritoService iCarritoService;

    @GetMapping(value = "error")
    public void throwException() {
        throw new IllegalArgumentException("Error Interno Api");
    }

    @PostMapping("login")
    private ResponseEntity<Usuario> getToken(@RequestBody Usuario usuario){
        return iCarritoService.login(usuario);
    }

}
