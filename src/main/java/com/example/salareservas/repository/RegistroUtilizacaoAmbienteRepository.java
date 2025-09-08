package com.example.salareservas.repository;

import com.example.salareservas.entity.RegistroUtilizacaoAmbiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RegistroUtilizacaoAmbienteRepository extends JpaRepository<RegistroUtilizacaoAmbiente, Long> {
    List<RegistroUtilizacaoAmbiente> findByAmbienteAmbienteId(Long ambienteId);
    List<RegistroUtilizacaoAmbiente> findByPlanejamentoAlocacaoPlanejamentoAlocacaoId(Long planejamentoId);
    List<RegistroUtilizacaoAmbiente> findByRegistroUtilizacaoAmbienteStatus(Integer status);
}