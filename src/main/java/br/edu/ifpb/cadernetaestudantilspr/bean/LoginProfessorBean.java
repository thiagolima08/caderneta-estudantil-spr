package br.edu.ifpb.cadernetaestudantilspr.bean;

import br.edu.ifpb.pweb2.cdi.controller.ProfessorController;
import br.edu.ifpb.pweb2.cdi.model.Professor;
import br.edu.ifpb.pweb2.cdi.util.SessionUtils;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@Named(value = "loginProfessorBean")
@SessionScoped
public class LoginProfessorBean extends GenericBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private Professor professor;

    @Inject
    private ProfessorController professorController;

    public Professor getProfessor() {
        return this.professor;
    }

    public String login() {
        if (!professor.getEmail().equals("") && !professor.getPassword().equals("")) {
            boolean verified = professorController.login(professor);
            if (verified) {
                System.out.println("Logado com sucesso!");
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("professor", professor);
                return "home?faces-redirect=true";
            }
        }

		this.addErrorMessage("Email e/ou senha inválidos");
        return "";
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index?faces-redirect=true";
    }
}
