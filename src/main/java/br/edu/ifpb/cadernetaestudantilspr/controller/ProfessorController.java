package br.edu.ifpb.cadernetaestudantilspr.controller;

import br.edu.ifpb.cadernetaestudantilspr.exception.InvalidCredentialsException;
import br.edu.ifpb.cadernetaestudantilspr.exception.ProfessorAlreadyRegisteredException;
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
        try {
            professorService.saveProfessor(professor);
            modelAndView.setViewName("redirect:/professor/signin");
            attr.addFlashAttribute("mensagem", "Professor cadastrado com sucesso!");

            return modelAndView;
        } catch (ProfessorAlreadyRegisteredException ex) {
            modelAndView.setViewName("formprofessor");
            modelAndView.addObject("errorMessage", ex.getMessage());

            return modelAndView;
        }

    }

    @RequestMapping(value = "/signup")
    public ModelAndView signUp(ModelAndView modelAndView) {
        Professor professor = new Professor();

        modelAndView.addObject("professor", professor);
        modelAndView.setViewName("formprofessor");

        return modelAndView;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signIn(ModelAndView modelAndView) {
        Professor professor = new Professor();
        modelAndView.addObject("professor", professor);
        modelAndView.setViewName("loginprofessor");

        return modelAndView;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signIn(Professor professor, ModelAndView modelAndView) {
        try {
            professorService.signIn(professor);
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        } catch(InvalidCredentialsException ex) {
            modelAndView.setViewName("loginprofessor");
            modelAndView.addObject("errorMessage", ex.getMessage());

            return modelAndView;
        }
    }
}
