package com.example.demo.servicos;

import com.example.demo.modelo.entidades.Transferencia;
import com.example.demo.repositorio.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {

    @Autowired
    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository){
        this.transferenciaRepository = transferenciaRepository;
    }

    public void salvarTransferencia(Transferencia transferencia){

        transferenciaRepository.save(transferencia);

    }
}
