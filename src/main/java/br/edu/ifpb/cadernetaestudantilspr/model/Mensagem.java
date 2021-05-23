package br.edu.ifpb.cadernetaestudantilspr.model;

import java.io.Serializable;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//@Entity
public class Mensagem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// ATTRIBUTES

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;

	private String texto;
	
	public Mensagem() {}
	
	public Mensagem(String texto) {
		this.texto = texto;
	}
	
	// GETTERS AND SETTERS
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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
		return "Mensagem ["+ texto + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensagem other = (Mensagem) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
}
