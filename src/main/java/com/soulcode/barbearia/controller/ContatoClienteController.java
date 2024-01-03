package com.soulcode.barbearia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.barbearia.model.ContatoCliente;
import com.soulcode.barbearia.repository.ContatoClienteRepository;

@Controller
public class ContatoClienteController {
  
  @Autowired
  private ContatoClienteRepository contatoClienteRepository;
  
  @GetMapping(value = "/contatoclientes")
  
  public ModelAndView contatoclientes() {
    try {
      List<ContatoCliente> contatoclientes = contatoClienteRepository.findAll();
      ModelAndView mv = new ModelAndView("contatoclientes");
      mv.addObject("ccls", contatoclientes);
      return mv;
    } catch(Exception ex) {
      ModelAndView erro = new ModelAndView("erro");
      erro.addObject("msg", "Erro interno no servidor.");
      return erro;
    }
  }

  @GetMapping(value = "/contatoclientes/{id}")
  public ModelAndView clientById(@PathVariable Integer id) {
    try {
      Optional<ContatoCliente> contatoclienteOpt = contatoClienteRepository.findById(id);
      if(contatoclienteOpt.isPresent()) {
        ContatoCliente contatocliente = contatoclienteOpt.get();
        ModelAndView mv = new ModelAndView("contatocliente");
        mv.addObject("ccl", contatocliente);
        return mv;
      }
      else {
        ModelAndView erro = new ModelAndView("erro");
        erro.addObject("msg", "ContatoCliente não encontrado.");
        return erro;
      }
    } catch(Exception ex) {
      ModelAndView erro = new ModelAndView("erro");
      erro.addObject("msg", "Erro interno no servidor.");
      return erro;
    }
  }

  @PostMapping(value = "/contatoclientes/delete")
  public String delete(@RequestParam Integer id) {
    try {
      contatoClienteRepository.deleteById(id);
    } catch(Exception ex) {
      return "erro";
    }
    return "redirect:/contatoclientes";
  }

  @PostMapping(value = "/contatoclientes")
  public String create(ContatoCliente contatocliente) {
    try {
      contatoClienteRepository.save(contatocliente);
    } catch(Exception ex) {
      ex.printStackTrace();
      return "erro";
    }
    return "redirect:/contatoclientes";
  }

  @GetMapping(value = "/contatoclientes/{id}/edit")
  public ModelAndView update(@PathVariable Integer id){
    try {
      Optional<ContatoCliente> contatoclientOpt = contatoClienteRepository.findById(id);
      if(contatoclientOpt.isPresent()) {
        ModelAndView mv = new ModelAndView("contatocliente-edit");
        ContatoCliente contatocliente = contatoclientOpt.get();
        mv.addObject("ccl", contatocliente);
        return mv;
      }
      else {
        ModelAndView erro = new ModelAndView("erro");
        erro.addObject("msg", "ContatoCliente não encontrado.");
        return erro;
      }
    } catch(Exception ex) {
      ModelAndView erro = new ModelAndView("erro");
      erro.addObject("msg", "Erro interno no servidor.");
      return erro;
    }
  }

  @PostMapping(value = "/contatoclientes/edit")
  public String edit(ContatoCliente contatocliente) {
    try {
      Optional<ContatoCliente> contatoclientOpt = contatoClienteRepository.findById(contatocliente.getId());
      if(contatoclientOpt.isPresent()) {
        contatoClienteRepository.save(contatocliente);
      }
    } catch(Exception ex) {
      return "erro";
    }
    return "redirect:/contatoclientes";
  }
}

