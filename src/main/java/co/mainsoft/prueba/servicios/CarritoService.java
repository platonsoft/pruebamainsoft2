package co.mainsoft.prueba.servicios;

import co.mainsoft.prueba.repositorio.model.Usuario;
import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class CarritoService implements ICarritoService{

    private static final Logger logger = LogManager.getLogger(CarritoService.class);

    @Override
    public ResponseEntity<Usuario> login(Usuario usuario) {
        try{
            if (validaUsuario(usuario)){
                String token = getJWTToken(usuario.getUsername());
                Usuario user = new Usuario();
                user.setToken(token);
                user.setUsername(usuario.getUsername());
                logger.debug("Logueo exitoso");
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
            logger.info("Datos Incorrectos en el Logueo");
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String getJWTToken(String username) {
        return "Bearer " + Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, Objects.requireNonNull(CLAVE_SECRETA))
                .compact();
    }

    private Boolean validaUsuario(Usuario usuario){
        try {
            InputStream inputStreamObject = getClass().getClassLoader().getResourceAsStream("Usuarios.json");
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStreamObject), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            Usuario[] usuarios = (new Gson()).fromJson(responseStrBuilder.toString(), Usuario[].class);
            Optional<Usuario> usuarioOpt = Arrays.stream(usuarios)
                    .filter(u -> u.getUsername().equals(usuario.getUsername()))
                    .filter(u -> u.getPassword().equals(usuario.getPassword()))
                    .findFirst();

            return usuarioOpt.isPresent();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
