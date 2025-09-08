package com.example.salareservas.repository;

import com.example.salareservas.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
    List<Sala> findByBloco(String bloco);
    List<Sala> findByCapacidadeGreaterThanEqual(Integer capacidade);
}