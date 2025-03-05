package com.tailan.estacionamento.dtos;

import com.tailan.estacionamento.entities.Veiculo;
import com.tailan.estacionamento.entities.VeiculoType;

public record VeiculoDto(String  marca, String  modelo, String cor, String placa, VeiculoType tipo){
    public VeiculoDto(Veiculo veiculo){
        this(veiculo.getMarca(), veiculo.getModelo(), veiculo.getCor(), veiculo.getPlaca(), veiculo.getTipo());
    }


}
