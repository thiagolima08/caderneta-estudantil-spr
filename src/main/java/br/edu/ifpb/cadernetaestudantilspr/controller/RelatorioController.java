package br.edu.ifpb.cadernetaestudantilspr.controller;

import br.edu.ifpb.cadernetaestudantilspr.model.Aluno;
import br.edu.ifpb.cadernetaestudantilspr.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/relatorio")
public class RelatorioController {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping
    public ModelAndView relatorio(ModelAndView modelAndView) {
        modelAndView.setViewName("relatorio");
        List<Aluno> alunos = alunoService.getAlunos();
        System.out.println(alunos); // TODO remove
        modelAndView.addObject("alunos", alunos);

        return modelAndView;
    }
}
