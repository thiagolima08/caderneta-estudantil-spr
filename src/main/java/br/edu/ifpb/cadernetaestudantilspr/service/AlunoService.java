package br.edu.ifpb.cadernetaestudantilspr.service;

import br.edu.ifpb.cadernetaestudantilspr.repository.AlunoRepository;
import br.edu.ifpb.cadernetaestudantilspr.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.MathContext;
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
    public void delete(Long id) {
        this.alunoRepository.deleteById(id);
    }

    @Transactional
    public void save(Aluno aluno) {
        this.alunoRepository.save(aluno);
    }

    @Transactional
    public void updateNotasAndSituacao(Aluno aluno) {
        if (alunoHasAllGrades(aluno) && alunohasFaltas(aluno) && !alunoHasFinal(aluno))  {
            double media = (aluno.getNota1().add(aluno.getNota2()).add(aluno.getNota3())).divide(new BigDecimal(3), new MathContext(4)).doubleValue();
            if (aluno.getFaltas() > 25) {
                aluno.setSituacao(Aluno.Situacao.RF);
            } else if (media > 70) {
                aluno.setSituacao(Aluno.Situacao.AP);
            } else if (media < 70 && media >= 40) {
                aluno.setSituacao(Aluno.Situacao.FN);
            } else if (media < 40) {
                aluno.setSituacao(Aluno.Situacao.RP);
            }
        } else if (alunoHasAllGrades(aluno) && alunohasFaltas(aluno) && alunoHasFinal(aluno)) {
            BigDecimal media =  aluno.getNota1().add(aluno.getNota2()).add(aluno.getNota3()).divide(new BigDecimal(3), new MathContext(4));
            BigDecimal finalAdd = (aluno.getNotaFinal().multiply(new BigDecimal(40)));

            BigDecimal mediaTotal = media.multiply(new BigDecimal(60), new MathContext(4));

            BigDecimal mediaMaisFinal = mediaTotal.add(finalAdd);

            double finalMedia = mediaMaisFinal.divide(new BigDecimal(100), new MathContext(4)).doubleValue();

            if (finalMedia >= 50) {
                aluno.setSituacao(Aluno.Situacao.AP);
            } else {
                aluno.setSituacao(Aluno.Situacao.RP);
            }
        }

        this.alunoRepository.save(aluno);

    }

    private boolean alunoHasAllGrades(Aluno aluno) {
        return (aluno.getNota1() != null && aluno.getNota2() != null && aluno.getNota3() != null);
    }

    private boolean alunoHasFinal(Aluno aluno) {
        return aluno.getNotaFinal() != null;
    }

    private boolean alunohasFaltas(Aluno aluno) {
        return aluno.getFaltas() != null;
    }

}
