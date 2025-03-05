package com.tailan.estacionamento.exceptions;

public class EstabelecimentoNaoExisteException extends RuntimeException {
    public EstabelecimentoNaoExisteException(String message) {
        super(message);
    }
}
