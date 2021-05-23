package br.edu.ifpb.cadernetaestudantilspr.controller;

import br.edu.ifpb.pweb2.cdi.dao.ProfessorDAO;
import br.edu.ifpb.pweb2.cdi.dao.Transactional;
import br.edu.ifpb.pweb2.cdi.model.Professor;

import javax.inject.Inject;
import java.io.Serializable;

public class ProfessorController implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private ProfessorDAO professorDAO;

    @Transactional
    public boolean cadastrarProfessor(Professor professor) {
        professor.hashPassword();
		Professor professorExist = this.findByEmail(professor.getEmail());
		if (professorExist == null) {
			this.professorDAO.insert(professor);
			return true;
		}

		return false;
    }

    public Professor findByEmail(String email) {
        return professorDAO.findByEmail(email);
    }

    public boolean login(Professor p) {
        Professor professor = this.findByEmail(p.getEmail());
        if (professor != null) {
            return professor.verifyPassword(p.getPassword());
        }

        return false;
    }
}
