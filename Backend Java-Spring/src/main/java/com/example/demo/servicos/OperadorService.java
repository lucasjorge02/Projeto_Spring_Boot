package com.example.demo.servicos;

import com.example.demo.modelo.entidades.Operador;
import com.example.demo.repositorio.OperadorRepository;
import com.example.demo.servicos.execoes.EmailNaoEncontradoException;
import com.example.demo.servicos.execoes.EmailOperadorException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service

public class OperadorService {

    @Autowired
    private final OperadorRepository operadorRepository;

    public OperadorService(OperadorRepository operadorRepository) {
        this.operadorRepository = operadorRepository;
    }

    public void salvarOperadorNoBanco(Operador operador) {
        operadorRepository.save(operador);
    }

    public void verificarEmail(Operador operador) {
        Optional<Operador> operadorExistente = operadorRepository.findByEmail(operador.getEmail());
        if (operadorExistente.isPresent()) {
            throw new EmailOperadorException(operadorExistente.get().getEmail(), " esse e-mail já está cadastrado!");
        }
    }

    public Operador buscarOperadorPorEmail(String email) {
        Optional<Operador> operadorExistente = operadorRepository.findByEmail(email);
        if (operadorExistente.isEmpty()) {
            throw new EntityNotFoundException("Este e-mail não foi encontrado: " + email);
        }
        return operadorExistente.get();
    }

    public Operador buscarOperadorPorId(UUID id){
        Optional<Operador> operadorExistente = operadorRepository.findById(id);
        if (operadorExistente.isEmpty()) {
            throw new EntityNotFoundException(" Não foi possível achar um operador com esse Id: " + id);
        }
        return operadorExistente.get();
    }

}