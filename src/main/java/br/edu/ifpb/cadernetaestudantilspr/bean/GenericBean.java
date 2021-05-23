//package br.edu.ifpb.cadernetaestudantilspr.bean;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.application.FacesMessage.Severity;
//import javax.faces.context.FacesContext;
//import javax.faces.context.Flash;
//
//public class GenericBean {
//	protected void addMessage(String mensagem, Severity severidade) {
//		FacesMessage fm = new FacesMessage(mensagem);
//		fm.setSeverity(severidade);
//		FacesContext fc = FacesContext.getCurrentInstance();
//		fc.addMessage(null, fm);
//	}
//
//	protected void addInfoMessage(String mensagem) {
//		this.addMessage(mensagem, FacesMessage.SEVERITY_INFO);
//	}
//
//	protected void addErrorMessage(String mensagem) {
//		this.addMessage(mensagem, FacesMessage.SEVERITY_ERROR);
//	}
//
//	protected void addWarnMessage(String mensagem) {
//		this.addMessage(mensagem, FacesMessage.SEVERITY_WARN);
//	}
//
//	protected void addFatalMessage(String mensagem) {
//		this.addMessage(mensagem, FacesMessage.SEVERITY_FATAL);
//	}
//
//	protected void putFlash(String nome, Object valor) {
//		Flash f = FacesContext.getCurrentInstance().getExternalContext().getFlash();
//		f.put(nome, valor);
//	}
//
//	protected Object getFlash(String nome) {
//		Flash f = FacesContext.getCurrentInstance().getExternalContext().getFlash();
//		return f.get(nome);
//	}
//
//	protected Flash getFlash() {
//		return FacesContext.getCurrentInstance().getExternalContext().getFlash();
//	}
//
//	protected void KeepMessages() {
//		this.getFlash().setKeepMessages(true);
//	}
//}
