package br.edu.ifpb.cadernetaestudantilspr.bean;

import br.edu.ifpb.pweb2.cdi.controller.AlunoController;
import br.edu.ifpb.pweb2.cdi.model.Aluno;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "alunoBean")
@ViewScoped
public class AlunoBean extends GenericBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Aluno> alunos;

    @Inject
    private AlunoController alunoController;

    public void init() {
        this.alunos = alunoController.findAll();
//        System.out.println(this.alunos);
    }


    public List<Aluno> getAlunos() {
        return this.alunos;
    }


    public void onRowEdit(RowEditEvent<Aluno> event) {
        Aluno aluno = event.getObject();
        System.out.println(aluno);
        alunoController.update(event.getObject());
        System.out.println(event.getObject().toString());
        FacesMessage msg = new FacesMessage("Aluno Editado", String.valueOf(event.getObject().getNome()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Aluno> event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada", String.valueOf(event.getObject().getNome()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
