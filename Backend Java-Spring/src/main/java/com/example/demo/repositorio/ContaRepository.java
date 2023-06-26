package com.example.demo.repositorio;

import com.example.demo.modelo.entidades.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContaRepository extends JpaRepository<Conta, UUID> {

    Optional<Conta> findByAgenciaAndNumeroConta(Integer agencia, String numeroConta);
    @Query("SELECT ct FROM Operador op JOIN op.cliente cl JOIN cl.listaConta ct WHERE op.id = :id")
    Optional<Conta> buscarSaldoPeloIdOperador(@Param("id") UUID id);



}
