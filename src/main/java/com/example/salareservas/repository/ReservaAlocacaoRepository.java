package com.example.salareservas.repository;

import com.example.salareservas.entity.ReservaAlocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaAlocacaoRepository extends JpaRepository<ReservaAlocacao, Long> {
    List<ReservaAlocacao> findByReservaAlocacaoData(LocalDate data);
    List<ReservaAlocacao> findByUsuarioUsuarioId(Long usuarioId);
    List<ReservaAlocacao> findByReservaAlocacaoStatus(Integer status);
}