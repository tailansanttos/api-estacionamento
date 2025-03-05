package com.tailan.estacionamento.repository;

import com.tailan.estacionamento.entities.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, String> {
    List<Estabelecimento> findByNome(String nome);
}
