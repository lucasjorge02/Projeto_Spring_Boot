package com.example.demo.servicos;

import com.example.demo.modelo.entidades.Conta;
import com.example.demo.repositorio.ContaRepository;
import com.example.demo.servicos.execoes.ContaException;
import com.example.demo.servicos.execoes.SaldoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service

public class ContaService {

    @Autowired
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository repository) {
        this.contaRepository = repository;
    }

    public void  salvarContaNoBanco(Conta conta) {
        contaRepository.save(conta);
    }

    public void verificarConta(Conta conta) {
        Optional<Conta> contaExistente = contaRepository.findByAgenciaAndNumeroConta(conta.getAgencia() , conta.getNumeroConta());
        if (contaExistente.isPresent()) {
            throw new ContaException("Conta inválida ou já registrada!");
        }
    }

    public Conta buscarSaldoPeloOperador(UUID id) {
        Optional<Conta> contaExistente = contaRepository.buscarSaldoPeloIdOperador(id);
        if(contaExistente.isEmpty()){
            throw new SaldoException(" Não foi possível achar o seu saldo!");
        }
        return contaExistente.get();
    }

    public Conta buscarConta(String numeroConta, Integer agencia) {
        Optional<Conta> contaExistente = contaRepository.findByAgenciaAndNumeroConta(agencia, numeroConta);
        if (contaExistente.isEmpty()) {
            throw new ContaException("Conta inválida!");
        }
        return contaExistente.get();
    }
}
