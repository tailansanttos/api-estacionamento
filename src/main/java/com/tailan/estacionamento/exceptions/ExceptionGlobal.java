package com.tailan.estacionamento.exceptions;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGlobal {
    @ExceptionHandler(EstabelecimentoNaoExisteException.class)
    public ResponseEntity<String> estabelecimentoNaoExisteException(EstabelecimentoNaoExisteException ex) {
        return ResponseEntity.notFound().build();
    }


}
