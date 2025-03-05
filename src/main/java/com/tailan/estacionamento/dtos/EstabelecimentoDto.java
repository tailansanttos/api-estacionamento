package com.tailan.estacionamento.dtos;

import com.tailan.estacionamento.entities.Estabelecimento;

public record EstabelecimentoDto(String nome, String cnpj, String endereco, String telefone, Integer quantidadeMotos, Integer quantidadeCarros) {

    public EstabelecimentoDto (Estabelecimento estabelecimento){
        this(estabelecimento.getNome(), estabelecimento.getCnpj(), estabelecimento.getEndereco(), estabelecimento.getTelefome(), estabelecimento.getQuantidadeMotos(), estabelecimento.getQuantidadeCarros());
    }
}
