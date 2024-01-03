package com.soulcode.barbearia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soulcode.barbearia.model.Servico;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
  @Query(value = "SELECT * FROM servicos ", nativeQuery = true)
  List<Servico> findByServicos();
}
