package com.example.salareservas.repository;

import com.example.salareservas.entity.PlanejamentoAlocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlanejamentoAlocacaoRepository extends JpaRepository<PlanejamentoAlocacao, Long> {
    List<PlanejamentoAlocacao> findByAmbienteAmbienteId(Long ambienteId);
    List<PlanejamentoAlocacao> findByUsuarioUsuarioId(Long usuarioId);
    List<PlanejamentoAlocacao> findByPlanejamentoAlocacaoData(LocalDate data);
    List<PlanejamentoAlocacao> findByPlanejamentoAlocacaoStatus(Integer status);
}