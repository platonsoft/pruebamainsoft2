package co.mainsoft.prueba.servicios;

import co.mainsoft.prueba.repositorio.model.Usuario;
import org.springframework.http.ResponseEntity;

public interface ICarritoService {
    String CLAVE_SECRETA = "Mainsoft";
    ResponseEntity<Usuario> login(Usuario usuario);
}
