package com.tailan.estacionamento.controllers;

import com.tailan.estacionamento.dtos.VeiculoDto;
import com.tailan.estacionamento.entities.Veiculo;
import com.tailan.estacionamento.repository.VeiculoRepository;
import com.tailan.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService service;

    @PostMapping
    public ResponseEntity<VeiculoDto> criarVeiculo(@RequestBody VeiculoDto veiculoDto) {
        service.criarVeiculo(veiculoDto);
        return ResponseEntity.ok().body(veiculoDto);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAllVeiculos() {
       List<Veiculo> veiculos = service.listarVeiculos();
       return ResponseEntity.ok().body(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable String id) {
       Veiculo veiculo = service.buscarVeiculo(id);
       return ResponseEntity.ok().body(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDto> atualizarVeiculo(@PathVariable String id, @RequestBody VeiculoDto veiculoDto) {
        service.atualizarVeiculo(id, veiculoDto);
        return ResponseEntity.ok().body(veiculoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable String id) {
        service.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}
