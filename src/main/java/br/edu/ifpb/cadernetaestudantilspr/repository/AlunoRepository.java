package br.edu.ifpb.cadernetaestudantilspr.repository;

import br.edu.ifpb.cadernetaestudantilspr.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
