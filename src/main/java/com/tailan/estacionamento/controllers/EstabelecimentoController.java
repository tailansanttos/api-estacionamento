package com.tailan.estacionamento.controllers;

import com.tailan.estacionamento.dtos.EstabelecimentoDto;
import com.tailan.estacionamento.entities.Estabelecimento;
import com.tailan.estacionamento.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estabelecimentos")
public class EstabelecimentoController {
    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @PostMapping
    public ResponseEntity<EstabelecimentoDto> criarEstabelecimento(@RequestBody EstabelecimentoDto dto) {
        estabelecimentoService.criarEstabelecimento(dto);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<Estabelecimento>> getAllEstabelecimentos(@RequestParam(value = "nome", required = false)  String  nome) {
        List<Estabelecimento> estabelecimentos = estabelecimentoService.listarEstabelecimento(nome);
        return ResponseEntity.ok().body(estabelecimentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstabelecimentoDto> atualizarEstabelecimento(@PathVariable(value = "id") String id, @RequestBody EstabelecimentoDto dto) {
        estabelecimentoService.atualizarEstabelecimento(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstabelecimento(@PathVariable(value = "id") String id) {
        estabelecimentoService.deletarEstabelecimento(id);
        return ResponseEntity.noContent().build();
    }
}
