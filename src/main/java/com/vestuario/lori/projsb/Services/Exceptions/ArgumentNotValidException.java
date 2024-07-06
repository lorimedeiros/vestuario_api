package com.vestuario.lori.projsb.Services.Exceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ArgumentNotValidException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratador400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors(); //capturando os campos em que ocorreu o erro

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroDTO::new).toList());
    }

    public record DadosErroDTO(String mensagem, String campo){
        public DadosErroDTO(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
