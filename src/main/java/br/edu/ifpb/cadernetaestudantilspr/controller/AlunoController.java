package br.edu.ifpb.cadernetaestudantilspr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Controller
@RequestMapping("/aluno")
public class AlunoController  {

    @Autowired
    private AlunoService alunoService;


    public void excluir(Aluno aluno) {
        alunoDAO.delete(aluno);
    }


    public Aluno update(Aluno aluno) {
        return alunoDAO.update(aluno);
    }

    public void refresh(Aluno aluno) {
        alunoDAO.refresh(aluno);
    }

    public List<Aluno> findAll() {
        return alunoDAO.findAll();
    }

    public Aluno find(Integer id) {
        return alunoDAO.find(id);
    }


    public Aluno insert(Aluno aluno) {
        return alunoDAO.insert(aluno);
    }

}
