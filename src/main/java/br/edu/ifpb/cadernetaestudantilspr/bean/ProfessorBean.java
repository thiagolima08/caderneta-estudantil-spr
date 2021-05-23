package br.edu.ifpb.cadernetaestudantilspr.bean;

import br.edu.ifpb.pweb2.cdi.controller.ProfessorController;
import br.edu.ifpb.pweb2.cdi.model.Professor;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "professorBean")
@ViewScoped
public class ProfessorBean extends GenericBean implements Serializable {
    @Inject
    private ProfessorController professorController;

    @Inject
    private Professor professor;

    public String cadastrar() {
        if (!professor.getEmail().equals("") && !professor.getPassword().equals("")) {
            boolean cadastrado = this.professorController.cadastrarProfessor(professor);

			if (cadastrado) {
				return "index?faces-redirect=true";
			}

        }

		professor = new Professor();

		this.addInfoMessage("Email selecionado já cadastrado");
        return "";
    }


    public Professor getProfessor() {
        return this.professor;
    }


}
