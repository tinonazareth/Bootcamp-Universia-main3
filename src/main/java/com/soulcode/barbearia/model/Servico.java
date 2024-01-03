package com.soulcode.barbearia.model;

//import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicos")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nome_servico;

    @Column(nullable = false)
    private Float preco;
    

    public Servico(){

    }

    public Integer getId() {
      return id;
    }
    public void setId(Integer id) {
      this.id = id;
    }
    public String getNome_servico() {
      return nome_servico;
    }
    public void setNome_servico(String nome_servico) {
      this.nome_servico = nome_servico;
    }

    public Float getPreco() {
      return preco;
    }
    public void setPreco(Float preco) {
      this.preco = preco;
    }

    
}