package com.tailan.estacionamento.exceptions;

public class VeiculoNaoExisteException extends RuntimeException
{
  public VeiculoNaoExisteException(String message) {
    super(message);
  }
}
