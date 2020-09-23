package co.mainsoft.prueba.repositorio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {
    private String httpStatus;
    private String message;
    private String code;
    private String backendMessage;
}
