package com.example.demo.servicos.execoes;

public class EmailOperadorException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public EmailOperadorException(String email, String message) {
            super("Erro ao cadastrar e-mail :" + email + " " + message);
        }

}
