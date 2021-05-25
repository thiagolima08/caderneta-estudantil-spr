package br.edu.ifpb.cadernetaestudantilspr.exception;

public class ProfessorAlreadyRegisteredException extends RuntimeException{
    private final String message;
    public ProfessorAlreadyRegisteredException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
