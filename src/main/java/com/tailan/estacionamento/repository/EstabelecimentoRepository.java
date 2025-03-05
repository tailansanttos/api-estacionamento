package com.tailan.estacionamento.repository;

import com.tailan.estacionamento.entities.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, String> {
}
