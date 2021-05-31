package br.edu.ifpb.cadernetaestudantilspr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/relatorio")
public class RelatorioController {

    @RequestMapping
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("relatorio");

        return modelAndView;
    }
}
