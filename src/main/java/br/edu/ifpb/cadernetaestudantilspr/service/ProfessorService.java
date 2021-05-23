package br.edu.ifpb.cadernetaestudantilspr.service;

import br.edu.ifpb.cadernetaestudantilspr.model.Professor;
import br.edu.ifpb.cadernetaestudantilspr.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public void saveProfessor(Professor professor) {
        professorRepository.save(professor);
    }
}
