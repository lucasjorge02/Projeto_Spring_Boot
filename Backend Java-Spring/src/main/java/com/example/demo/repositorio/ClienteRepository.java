package com.example.demo.repositorio;

import com.example.demo.modelo.entidades.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

        Optional<Cliente> findByNumeroDocumento(String numeroDocumento);

}
