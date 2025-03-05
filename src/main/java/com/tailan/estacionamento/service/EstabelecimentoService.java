package com.tailan.estacionamento.service;

import com.tailan.estacionamento.dtos.EstabelecimentoDto;
import com.tailan.estacionamento.entities.Estabelecimento;
import com.tailan.estacionamento.exceptions.EstabelecimentoNaoExisteException;
import com.tailan.estacionamento.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstabelecimentoService {
    @Autowired
    private  EstabelecimentoRepository estabelecimentoRepository;

    public EstabelecimentoDto criarEstabelecimento(EstabelecimentoDto dados){
        Estabelecimento novoEstabelecimento = new Estabelecimento(dados);
        estabelecimentoRepository.save(novoEstabelecimento);
        return new EstabelecimentoDto(novoEstabelecimento);
    }

    public List<Estabelecimento> listarEstabelecimento(String nome){
        List<Estabelecimento> estabelecimento = estabelecimentoRepository.findByNome(nome);

        if (estabelecimento.isEmpty()){
           return estabelecimentoRepository.findAll();
        }

        return estabelecimento;
    }

    public EstabelecimentoDto atualizarEstabelecimento(String id, EstabelecimentoDto dados){
        Estabelecimento novoEstabelecimento = estabelecimentoRepository.findById(id).orElseThrow(() -> new EstabelecimentoNaoExisteException(id));

        if (!novoEstabelecimento.getNome().isEmpty()) novoEstabelecimento.setNome(dados.nome());
        if (!novoEstabelecimento.getTelefome().isEmpty()) novoEstabelecimento.setTelefome(dados.telefone());

        EstabelecimentoDto estabelecimentoDto = new EstabelecimentoDto(novoEstabelecimento);
        estabelecimentoRepository.save(novoEstabelecimento);
        return estabelecimentoDto;
    }

    public void deletarEstabelecimento(String id){
        Estabelecimento novoEstabelecimento = estabelecimentoRepository.findById(id).orElseThrow(() -> new EstabelecimentoNaoExisteException(id));
        estabelecimentoRepository.delete(novoEstabelecimento);
    }
}
