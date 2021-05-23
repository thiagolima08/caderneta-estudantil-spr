package br.edu.ifpb.cadernetaestudantilspr.repository;

import br.edu.ifpb.cadernetaestudantilspr.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByEmail(String email);
}
