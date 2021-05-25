package br.edu.ifpb.cadernetaestudantilspr.exception;

public class InvalidCredentialsException extends RuntimeException{
    private final String message;

    public InvalidCredentialsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
