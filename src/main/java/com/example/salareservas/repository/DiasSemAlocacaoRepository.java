package com.example.salareservas.repository;

import com.example.salareservas.entity.DiasSemAlocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiasSemAlocacaoRepository extends JpaRepository<DiasSemAlocacao, Long> {
    List<DiasSemAlocacao> findByAmbienteAmbienteId(Long ambienteId);
    List<DiasSemAlocacao> findByDiasSemAlocacaoData(LocalDate data);
    List<DiasSemAlocacao> findByDiasSemAlocacaoStatus(Integer status);
}