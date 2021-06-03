package br.edu.ifpb.cadernetaestudantilspr.controller;

import br.edu.ifpb.cadernetaestudantilspr.model.Aluno;
import br.edu.ifpb.cadernetaestudantilspr.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        modelAndView.addObject("alunos", alunos);

        return modelAndView;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView addNota(@PathVariable("id") Long id, ModelAndView modelAndView) {
        modelAndView.setViewName("form-notas");
        Aluno aluno = alunoService.getAluno(id);
        modelAndView.addObject("aluno", aluno);

        return modelAndView;
    }

    @RequestMapping(value = "form-nota", method = RequestMethod.POST)
    public ModelAndView updateNota(Aluno aluno, ModelAndView modelAndView) {
        alunoService.updateNotasAndSituacao(aluno);
        modelAndView.setViewName("redirect:/relatorio");
        return modelAndView;
    }
}
