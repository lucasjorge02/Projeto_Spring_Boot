package com.example.demo.servicos;

import com.example.demo.modelo.entidades.Cliente;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.servicos.execoes.DocumentoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository repository) {
        this.clienteRepository = repository;
    }



    public Cliente salvarClienteNoBanco(Cliente cliente) {

        clienteRepository.save(cliente);

        return cliente;
    }

    public void verificarNumeroDocumento(Cliente cliente) {

        Optional<Cliente> clienteExistente = clienteRepository.findByNumeroDocumento(cliente.getNumeroDocumento());
        if (clienteExistente.isPresent()) {
            throw new DocumentoException(cliente.getTipoDocumento(), cliente.getNumeroDocumento(), "esse documento já está sendo utilizado!");
        }

    }




}
