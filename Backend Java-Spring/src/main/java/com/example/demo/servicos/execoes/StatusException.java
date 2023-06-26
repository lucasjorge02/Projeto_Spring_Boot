package com.example.demo.servicos.execoes;

public class StatusException extends  RuntimeException{

    private static final long serialVersionUID = 1L;
    public StatusException(String message) {
        super(message);
    }
}
