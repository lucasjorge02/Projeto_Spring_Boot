package com.example.demo.servicos.execoes;

public class SaldoException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public SaldoException(String message) {
        super(message);
    }

}
