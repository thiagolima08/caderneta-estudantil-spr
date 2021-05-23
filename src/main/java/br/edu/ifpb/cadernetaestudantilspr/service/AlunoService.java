package br.edu.ifpb.cadernetaestudantilspr.service;

import br.edu.ifpb.cadernetaestudantilspr.controller.repository.AlunoRepository;
import br.edu.ifpb.cadernetaestudantilspr.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAlunos(){
        return this.alunoRepository.findAll();
    }

    public Aluno getAluno(Long id){
        Optional<Aluno> aluno = this.alunoRepository.findById(id);
        return aluno.get();
    }

    @Transactional
    public Aluno saveOrUpdate(Aluno aluno) {
        Optional<Aluno> alunoInserted = this.alunoRepository.findById(aluno.getId());
        if (alunoInserted.isPresent()) {
            alunoInserted.get().setNome(aluno.getNome());
            alunoInserted.get().setDatanascimento(aluno.getDatanascimento());
            alunoInserted.get().setSituacao(aluno.getSituacao());
            alunoInserted.get().setFaltas(aluno.getFaltas());
            alunoInserted.get().setNota1(aluno.getNota1());
            alunoInserted.get().setNota2(aluno.getNota2());
            alunoInserted.get().setNota3(aluno.getNota3());
            alunoInserted.get().setNotaFinal(aluno.getNotaFinal());
            this.alunoRepository.save(alunoInserted.get());
            return alunoInserted.get();
        }
        this.alunoRepository.save(alunoInserted.get());
        return alunoInserted.get();
    }

    public void delete(Long id) {
        this.alunoRepository.deleteById(id);
    }



}
