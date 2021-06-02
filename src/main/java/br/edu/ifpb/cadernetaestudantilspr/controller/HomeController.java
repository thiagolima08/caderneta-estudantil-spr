package br.edu.ifpb.cadernetaestudantilspr.controller;

import br.edu.ifpb.cadernetaestudantilspr.model.Aluno;
import br.edu.ifpb.cadernetaestudantilspr.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping
    public ModelAndView home(ModelAndView modelAndView) {
        List<Aluno> alunos = alunoService.getAlunos();
        modelAndView.addObject("alunos", alunos);
        modelAndView.setViewName("home");

        return modelAndView;
    }
}
