package com.soulcode.barbearia.model;


import jakarta.persistence.*;

@Entity
@Table(name = "contatoclientes")
public class ContatoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
        
    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String mensagem;


    //@Column(nullable = false)
    //private LocalDateTime data_contato;

    public ContatoCliente(){

    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }


    public String getMensagem() {
      return mensagem;
    }

    public void setMensagem(String mensagem) {
      this.mensagem = mensagem;
    }

    //public LocalDateTime getData_contato() {
    // return data_contato;
    //}

    //public void setData_contato(LocalDateTime data_contato) {
    //  this.data_contato = data_contato;
    //}
    
        public String getNome() {
      return nome;
    }

    public void setNome(String nome) {
      this.nome = nome;
    }

    public String getTelefone() {
      return telefone;
    }

    public void setTelefone(String telefone) {
      this.telefone = telefone;
    }
}