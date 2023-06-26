package com.example.demo.servicos.execoes;

public class ValidacaoDtoException extends RuntimeException{
    private static final long serialVersionUID = 1L;
        public ValidacaoDtoException(String message) {
            super("Esse campo não pode ser nulo ou vazio: " + message);

        }



}
