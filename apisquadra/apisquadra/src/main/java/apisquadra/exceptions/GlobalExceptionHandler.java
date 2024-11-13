package apisquadra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RegistroExistente.class)
    public ResponseEntity<Map<String, Object>> handleApiExceptions(RuntimeException ex) {
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", ex.getMessage());
        resposta.put("status", 404);
        return new ResponseEntity<>(resposta, HttpStatus.NOT_FOUND);
    }
}
