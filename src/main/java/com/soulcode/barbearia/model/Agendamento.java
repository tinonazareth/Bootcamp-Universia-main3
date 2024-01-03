package com.soulcode.barbearia.model;

//import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.LocalTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //@Column(nullable = false, length = 50)
  //private LocalDate data;

  //@Column(nullable = false, length = 50)
  //private LocalTime horario;

  @Column(nullable = false, length = 50)
  private LocalDateTime dataHoraAgendamento;



  @ManyToOne
  @JoinColumn(nullable = false)
  private Servico servico;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Cliente cliente;

    public Agendamento(){

  }


  public Servico getServico() {
    return servico;
  }


  public void setServico(Servico servico) {
    this.servico = servico;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  //public LocalDate getData() {
  //  return data;
  //}

  //public void setData(LocalDate data) {
  //  this.data = data;
  //}

  //public LocalTime getHorario() {
  //return horario;
  //}

  //public void setHorario(LocalTime horario) {
  //  this.horario = horario;
  //}


  public Cliente getCliente() {
    return cliente;
  }


  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

    public LocalDateTime getDataHoraAgendamento() {
    return dataHoraAgendamento;
  }


  public void setDataHoraAgendamento(LocalDateTime dataHoraAgendamento) {
    this.dataHoraAgendamento = dataHoraAgendamento;
  }





}