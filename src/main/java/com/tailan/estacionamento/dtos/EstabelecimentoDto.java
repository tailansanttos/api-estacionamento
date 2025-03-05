package com.tailan.estacionamento.dtos;

public record EstabelecimentoDto(String nome, String cnpj, String endereco, String telefone, Integer quantidadeMotos, Integer quantidadeCarros) {
}
