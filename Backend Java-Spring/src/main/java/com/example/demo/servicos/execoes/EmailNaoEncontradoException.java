package com.example.demo.servicos.execoes;

public class EmailNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public EmailNaoEncontradoException(String email, String message) {
        super(email + " " + message);
    }
}
