package com.dock.desafio2.exceptions.handler;

import com.dock.desafio2.exceptions.RegistroNaoExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RegistroNaoExisteExceptionHandler {

    @ExceptionHandler(RegistroNaoExisteException.class)
    public ResponseEntity<ApiError> handle(RegistroNaoExisteException e) {

        ApiError error = new ApiError("registro_nao_existe", e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
