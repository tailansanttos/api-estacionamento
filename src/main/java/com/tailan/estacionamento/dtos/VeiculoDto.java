package com.tailan.estacionamento.dtos;

import com.tailan.estacionamento.entities.VeiculoType;

public record VeiculoDto(String  marca, String  modelo, String cor, String placa, VeiculoType tipo){
}
