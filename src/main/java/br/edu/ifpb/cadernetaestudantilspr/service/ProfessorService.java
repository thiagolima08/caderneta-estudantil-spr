package br.edu.ifpb.cadernetaestudantilspr.service;

import br.edu.ifpb.cadernetaestudantilspr.exception.InvalidCredentialsException;
import br.edu.ifpb.cadernetaestudantilspr.exception.ProfessorAlreadyRegisteredException;
import br.edu.ifpb.cadernetaestudantilspr.model.Professor;
import br.edu.ifpb.cadernetaestudantilspr.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public void saveProfessor(Professor professor) throws ProfessorAlreadyRegisteredException {
        Professor professorExist = professorRepository.findByEmail(professor.getEmail());
        if (professorExist != null) {
            throw new ProfessorAlreadyRegisteredException("Email já registrado");
        }

        professor.hashPassword();
        professorRepository.save(professor);
    }

    public void signIn(Professor professor) throws InvalidCredentialsException {
        Professor professorExist = professorRepository.findByEmail(professor.getEmail());
        if (professorExist == null) {
            throw new InvalidCredentialsException("Email inválido");
        }

        if (!professorExist.verifyPassword(professor.getPassword())) {
            throw new InvalidCredentialsException("Senha incorreta");
        }
    }
}
