package br.edu.ifpb.cadernetaestudantilspr.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;


	// ATTRIBUTES

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MMM-YYYY")
	private Date datanascimento;
//	private LocalDate datanascimento;
	
	private Integer faltas;
	
	private BigDecimal nota1;
	
	private BigDecimal nota2;
	
	private BigDecimal nota3;
	
	private BigDecimal notaFinal;
	
	private Situacao situacao = Situacao.MT;
	
	public enum Situacao  {
		
		AP("aprovado"), 
		RP("reprovado por nota final"), 
		FN("está na final"), 
		MT("matriculado"), 
		RF("reprovado por faltas");
		
		private String descricao;
		
		Situacao(String descricao) {
			this.descricao = descricao;
		}
	
		public String getDescricao() {
			return descricao;
		}
	}
	
	
	public Aluno() {}
	
	//public Aluno(String nome, Date datanascimento, Integer faltas, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3,
	public Aluno(String nome, Date datanascimento, Integer faltas, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3,
			BigDecimal notaFinal) {
		super();
		this.nome = nome;
		this.datanascimento = datanascimento;
		this.faltas = faltas;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.notaFinal = notaFinal;
	}
	
	// GETTERS AND SETTERS
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//public Date getDatanascimento() {
	public Date getDatanascimento() {
		return datanascimento;
	}

	//public void setDatanascimento(Date datanascimento) {
	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	public BigDecimal getNota1() {
		return nota1;
	}

	public void setNota1(BigDecimal nota1) {
		this.nota1 = nota1;
	}

	public BigDecimal getNota2() {
		return nota2;
	}

	public void setNota2(BigDecimal nota2) {
		this.nota2 = nota2;
	}

	public BigDecimal getNota3() {
		return nota3;
	}

	public void setNota3(BigDecimal nota3) {
		this.nota3 = nota3;
	}

	public BigDecimal getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(BigDecimal notaFinal) {
		this.notaFinal = notaFinal;
	}
	
	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	// TO STRING, HASHCODE, EQUALS


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", datanascimento=" + datanascimento + ", faltas=" + faltas + ", nota1=" + nota1
				+ ", nota2=" + nota2 + ", nota3=" + nota3 + ", final=" + notaFinal + ", situacao=" + situacao + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
}
