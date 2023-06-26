package com.example.demo.repositorio;

import com.example.demo.modelo.entidades.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferenciaRepository extends JpaRepository<Transferencia, UUID> {

}
