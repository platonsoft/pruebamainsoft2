package co.mainsoft.prueba.controladores;

import co.mainsoft.prueba.repositorio.model.ErrorResponseDto;
import co.mainsoft.prueba.servicios.CarritoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations= RestController.class)
public class CarritoErrorController{

    private static final Logger logger = LogManager.getLogger(CarritoService.class);

    @ExceptionHandler
    @ResponseBody
    public ErrorResponseDto handleErrorJson(Exception ex, HttpServletRequest request) {
        return new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                ex.getMessage(),
                ex.getLocalizedMessage(),
                ex.getCause().getMessage());
    }

}