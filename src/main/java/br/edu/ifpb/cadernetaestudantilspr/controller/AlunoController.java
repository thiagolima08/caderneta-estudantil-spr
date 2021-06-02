package br.edu.ifpb.cadernetaestudantilspr.controller;


import br.edu.ifpb.cadernetaestudantilspr.model.Aluno;
import br.edu.ifpb.cadernetaestudantilspr.model.Professor;
import br.edu.ifpb.cadernetaestudantilspr.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController  {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView buscarAlunos(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        try {
            List<Aluno> alunos = alunoService.getAlunos();
            modelAndView.addObject("alunos", alunos);
        } catch (Exception e) {
            modelAndView.addObject("mensagem", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping("/{id}")
    public String buscarAlunoPorId(@PathVariable("id") Long id, Model model, RedirectAttributes attr) {
        Aluno aluno = alunoService.getAluno(id);
        if (aluno != null) {
            model.addAttribute("aluno", aluno);
        } else {
            attr.addFlashAttribute("mensagem", "Aluno não encontrado!");
            model.addAttribute("aluno", new Aluno());
        }
        return "alunos/form";
    }

    @RequestMapping(value = "/cadastrar-aluno")
    public ModelAndView signUp(ModelAndView modelAndView) {
        Aluno aluno = new Aluno();

        modelAndView.addObject("aluno", aluno);
        modelAndView.setViewName("cadastrar-aluno");

        return modelAndView;
    }

    @RequestMapping(value = "/cadastrar-aluno", method = RequestMethod.POST)
    public ModelAndView adicionarAluno(Aluno aluno, ModelAndView modelAndView, RedirectAttributes attr) {
        alunoService.save(aluno);
        modelAndView.setViewName("redirect:/alunos");
        attr.addFlashAttribute("mensagem", "Aluno salvo com sucesso!");
        return modelAndView;
    }


    @RequestMapping(value = "/{id}/delete")
    public ModelAndView deletarAlunoPorId(@PathVariable("id") Long id, ModelAndView modelAndView,
                                    RedirectAttributes attr) {
        alunoService.delete(id);
        modelAndView.setViewName("redirect:/alunos/list");
        attr.addFlashAttribute("mensagem", "Aluno excluído!");
        return modelAndView;
    }

}
