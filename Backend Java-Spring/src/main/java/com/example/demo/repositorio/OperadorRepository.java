package com.example.demo.repositorio;

import com.example.demo.modelo.entidades.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OperadorRepository extends JpaRepository<Operador, UUID> {

    Optional<Operador> findByEmail(String email);

}
