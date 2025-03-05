package com.tailan.estacionamento.service;

import com.tailan.estacionamento.dtos.VeiculoDto;
import com.tailan.estacionamento.entities.Veiculo;
import com.tailan.estacionamento.exceptions.VeiculoNaoExisteException;
import com.tailan.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoDto criarVeiculo(VeiculoDto veiculoDto) {
        Veiculo veiculo = new Veiculo(veiculoDto);
        veiculoRepository.save(veiculo);
        return veiculoDto;
    }

    public List<Veiculo> listarVeiculos() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return veiculos;
    }

    public Veiculo buscarVeiculo(String id) {
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new VeiculoNaoExisteException("Veiculo não encontrado"));
        return veiculo;
    }

    public VeiculoDto atualizarVeiculo(String id, VeiculoDto veiculoDto)  {
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new VeiculoNaoExisteException("Veiculo não encontrado"));
        if(!veiculo.getCor().isEmpty()) veiculo.setCor(veiculo.getCor());

        VeiculoDto newVeiculo = new VeiculoDto(veiculo);
        veiculoRepository.save(veiculo);
        return veiculoDto;
    }

    public void deletarVeiculo(String id) {
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new VeiculoNaoExisteException("Veiculo não encontrado"));
        veiculoRepository.delete(veiculo);
    }
}
