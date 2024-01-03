package com.soulcode.barbearia.controller;

import com.soulcode.barbearia.model.Agendamento;
import com.soulcode.barbearia.model.Cliente;
import com.soulcode.barbearia.model.Servico;
import com.soulcode.barbearia.repository.AgendamentoRepository;
import com.soulcode.barbearia.repository.ClienteRepository;
import com.soulcode.barbearia.repository.ServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalTimeConverter;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping(value = "/agendamentos")
    public ModelAndView agendamentos() {
    try {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        List<Servico> servicos = servicoRepository.findAll();
        List<Cliente> clientes = clienteRepository.findAll();
        ModelAndView mv = new ModelAndView("agendamentos");
        mv.addObject("agnd", agendamentos);
        mv.addObject("serv", servicos);
        mv.addObject("cls", clientes);
        return mv;
    } catch(Exception ex) {
        ModelAndView erro = new ModelAndView("erro");
        erro.addObject("msg", "Erro interno no servidor.");
        return erro;
    }
}

    @PostMapping(value = "/agendamentos")
    public String create(@RequestParam Integer servicoId, @RequestParam Integer clienteId, @RequestParam LocalDate appointmentDate, @RequestParam LocalTime appointmentTime, Agendamento agendamento) {
    try {
        Optional<Servico> servicoOpt = servicoRepository.findById(servicoId);
        Optional<Cliente> clienteOpt = clienteRepository.findById(clienteId);
        if(servicoOpt.isPresent() && clienteOpt.isPresent()) {
            Servico servico = servicoOpt.get();
            Cliente cliente = clienteOpt.get();
            agendamento.setServico(servico);
            agendamento.setCliente(cliente);
            LocalDateTime dataHoraAgendamento = LocalDateTime.parse(appointmentDate + "T" + appointmentTime);
            agendamento.setDataHoraAgendamento(dataHoraAgendamento);
            agendamentoRepository.save(agendamento);

    }
        return "redirect:/agendamentos";
    } catch(Exception ex) {
        ex.printStackTrace();
        return "erro";
    }
}
    @PostMapping(value = "/agendamentos/delete")
    public String delete(@RequestParam Integer id) {
        try {
            agendamentoRepository.deleteById(id);
        return "redirect:/agendamentos";
        } catch(Exception ex) {
        return "erro";
        }
    }
}
