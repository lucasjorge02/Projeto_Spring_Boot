package com.example.demo.servicos.execoes;

public class SaldoInsufienteException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public SaldoInsufienteException(String message) {
        super(message);
    }

}
