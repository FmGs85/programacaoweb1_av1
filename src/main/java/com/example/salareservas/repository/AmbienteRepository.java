package com.example.salareservas.repository;

import com.example.salareservas.entity.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Long> {
    List<Ambiente> findByAmbienteStatus(Integer status);
    List<Ambiente> findByAmbienteTipo(String tipo);
    List<Ambiente> findByAmbienteCapacidadeGreaterThanEqual(Integer capacidade);
}