package br.edu.ifpb.cadernetaestudantilspr.controller;

import br.edu.ifpb.cadernetaestudantilspr.model.Professor;
import br.edu.ifpb.cadernetaestudantilspr.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signUp(Professor professor, ModelAndView modelAndView, RedirectAttributes attr) {
        professorService.saveProfessor(professor);
        modelAndView.setViewName("redirect:/alunos");
        attr.addFlashAttribute("mensagem", "Aluno salvo com sucesso!");

        return modelAndView;
    }

    /*
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signIn() {
       // TODO
    }
     */
}
