package com.tailan.estacionamento.entities;

import com.tailan.estacionamento.dtos.EstabelecimentoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tb_estabelecimentos")
@AllArgsConstructor
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String telefone;
    @NotNull
    private Integer quantidadeMotos;
    @NotNull
    private Integer quantidadeCarros;

    public Estabelecimento() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantidadeCarros() {
        return quantidadeCarros;
    }

    public void setQuantidadeCarros(Integer quantidadeCarros) {
        this.quantidadeCarros = quantidadeCarros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeMotos() {
        return quantidadeMotos;
    }

    public void setQuantidadeMotos(Integer quantidadeMotos) {
        this.quantidadeMotos = quantidadeMotos;
    }

    public String getTelefome() {
        return telefone;
    }

    public void setTelefome(String telefone) {
        this.telefone = telefone;
    }

    public Estabelecimento(EstabelecimentoDto data){
        this.nome = data.nome();
        this.cnpj = data.cnpj();
        this.endereco = data.endereco();
        this.telefone = data.telefone();
        this.quantidadeMotos = data.quantidadeMotos();
        this.quantidadeCarros = data.quantidadeCarros();
    }
}
