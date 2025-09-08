package com.example.salareservas.repository;

import com.example.salareservas.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findBySalaId(Long salaId);
    List<Reserva> findByUsuarioUsuarioId(Long usuarioId);

    @Query("SELECT r FROM Reserva r WHERE r.sala.id = :salaId AND " +
            "((r.inicio BETWEEN :inicio AND :fim) OR (r.fim BETWEEN :inicio AND :fim) OR " +
            "(r.inicio <= :inicio AND r.fim >= :fim))")
    List<Reserva> findConflictingReservas(@Param("salaId") Long salaId,
                                          @Param("inicio") LocalDateTime inicio,
                                          @Param("fim") LocalDateTime fim);
}