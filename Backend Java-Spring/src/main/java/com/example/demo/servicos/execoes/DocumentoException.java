package com.example.demo.servicos.execoes;

import com.example.demo.modelo.auxiliares.TipoDocumento;

public class DocumentoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DocumentoException(TipoDocumento tipoDocumento, String numeroDocumento, String message) {
        super("Erro ao cadastrar " + tipoDocumento + ": " + numeroDocumento + " " + message);
    }

}
