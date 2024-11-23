package apisquadra.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    private ResponseEntity<Map<String, Object>> respostaJson(String mensagem, HttpStatus status) {
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        resposta.put("status", status.value());
        return new ResponseEntity<>(resposta, status);
    }

    @ExceptionHandler(RegistroExistente.class)
    public ResponseEntity<Map<String, Object>> RegistroExistente(RuntimeException ex) {
        return respostaJson(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExceptionPersonalizada.class)
    public ResponseEntity<Map<String, Object>> ExceptionPersonalizada(RuntimeException ex) {
        return respostaJson(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> HttpMessageNotReadableException (HttpMessageNotReadableException ex) {
        return respostaJson("Json tem algum erro ", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException (IllegalArgumentException ex){
        return respostaJson("Registro não encontrado no banco de dados ", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> DataIntegrityViolationException (DataIntegrityViolationException ex){
        return respostaJson("Chave Primária não existe", HttpStatus.NOT_FOUND);

    }



}
