package com.tailan.estacionamento.entities;

import com.tailan.estacionamento.dtos.VeiculoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tb_veiculos")
@AllArgsConstructor
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String cor;
    @NotBlank
    private String placa;


    @Enumerated(EnumType.STRING)
    private VeiculoType tipo;

    public Veiculo() {
    }

    public Veiculo(VeiculoDto data){
        this.marca = data.marca();
        this.modelo = data.modelo();
        this.cor = data.cor();
        this.placa = data.placa();
        this.tipo = data.tipo();
    }

    public @NotBlank String getCor() {
        return cor;
    }

    public void setCor(@NotBlank String cor) {
        this.cor = cor;
    }

    public @NotBlank String getMarca() {
        return marca;
    }

    public void setMarca(@NotBlank String marca) {
        this.marca = marca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotBlank String getModelo() {
        return modelo;
    }

    public void setModelo(@NotBlank String modelo) {
        this.modelo = modelo;
    }

    public @NotBlank String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotBlank String placa) {
        this.placa = placa;
    }

    public VeiculoType getTipo() {
        return tipo;
    }

    public void setTipo( VeiculoType tipo) {
        this.tipo = tipo;
    }
}
