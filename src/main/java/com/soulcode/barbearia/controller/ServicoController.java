package com.soulcode.barbearia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.barbearia.model.Servico;
import com.soulcode.barbearia.repository.ServicoRepository;

public class ServicoController {
  
  @Autowired
  private ServicoRepository servicoRepository;
  
  @GetMapping(value = "/servicos")
  
  public ModelAndView servicos() {
    try {
      List<Servico> servicos = servicoRepository.findAll();
      ModelAndView mv = new ModelAndView("servicos");
      mv.addObject("cls", servicos);
      return mv;
    } catch(Exception ex) {
      ModelAndView erro = new ModelAndView("erro");
      erro.addObject("msg", "Erro interno no servidor.");
      return erro;
    }
  }

  @GetMapping(value = "/servicos/{id}")
  public ModelAndView clientById(@PathVariable Integer id) {
    try {
      Optional<Servico> servicoOpt = servicoRepository.findById(id);
      if(servicoOpt.isPresent()) {
        Servico servico = servicoOpt.get();
        ModelAndView mv = new ModelAndView("servico");
        mv.addObject("cl", servico);
        return mv;
      }
      else {
        ModelAndView erro = new ModelAndView("erro");
        erro.addObject("msg", "Servico não encontrado.");
        return erro;
      }
    } catch(Exception ex) {
      ModelAndView erro = new ModelAndView("erro");
      erro.addObject("msg", "Erro interno no servidor.");
      return erro;
    }
  }

  @PostMapping(value = "/servicos/delete")
  public String delete(@RequestParam Integer id) {
    try {
      servicoRepository.deleteById(id);
    } catch(Exception ex) {
      return "erro";
    }
    return "redirect:/servicos";
  }

  @PostMapping(value = "/servicos")
  public String create(Servico servico) {
    try {
      servicoRepository.save(servico);
    } catch(Exception ex) {
      return "erro";
    }
    return "redirect:/servicos";
  }

  @GetMapping(value = "/servicos/{id}/edit")
  public ModelAndView update(@PathVariable Integer id){
    try {
      Optional<Servico> servicoOpt = servicoRepository.findById(id);
      if(servicoOpt.isPresent()) {
        ModelAndView mv = new ModelAndView("servico-edit");
        Servico servico = servicoOpt.get();
        mv.addObject("cl", servico);
        return mv;
      }
      else {
        ModelAndView erro = new ModelAndView("erro");
        erro.addObject("msg", "Servico não encontrado.");
        return erro;
      }
    } catch(Exception ex) {
      ModelAndView erro = new ModelAndView("erro");
      erro.addObject("msg", "Erro interno no servidor.");
      return erro;
    }
  }

  @PostMapping(value = "/servicos/edit")
  public String edit(Servico servico) {
    try {
      Optional<Servico> servicoOpt = servicoRepository.findById(servico.getId());
      if(servicoOpt.isPresent()) {
        servicoRepository.save(servico);
      }
    } catch(Exception ex) {
      return "erro";
    }
    return "redirect:/servicos";
  }
}

