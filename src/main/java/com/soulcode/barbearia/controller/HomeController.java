package com.soulcode.barbearia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @GetMapping(value = {"/", "/home", "/h"})
    public String home() {
    return "index";
    }


    @GetMapping(value="/galeria")
    public String galerias() {
    return "galeria";
    }
    
    //public ModelAndView home(){

    //    ModelAndView mv = new ModelAndView("index");
   //     return mv;

   // }
}
