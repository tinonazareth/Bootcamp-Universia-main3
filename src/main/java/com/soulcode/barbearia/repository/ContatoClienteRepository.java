package com.soulcode.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.barbearia.model.ContatoCliente;


@Repository
public interface ContatoClienteRepository extends JpaRepository<ContatoCliente, Integer> {
  
}