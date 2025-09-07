package com.example.salareservas.service;

import com.example.salareservas.dto.request.PlanejamentoAlocacaoRequestDTO;
import com.example.salareservas.dto.response.PlanejamentoAlocacaoResponseDTO;
import java.time.LocalDate;
import java.util.List;

public interface PlanejamentoAlocacaoService {
    PlanejamentoAlocacaoResponseDTO criar(PlanejamentoAlocacaoRequestDTO dto);
    PlanejamentoAlocacaoResponseDTO buscarPorId(Long id);
    List<PlanejamentoAlocacaoResponseDTO> listarTodos();
    PlanejamentoAlocacaoResponseDTO atualizar(Long id, PlanejamentoAlocacaoRequestDTO dto);
    void deletar(Long id);
    List<PlanejamentoAlocacaoResponseDTO> buscarPorAmbiente(Long ambienteId);
    List<PlanejamentoAlocacaoResponseDTO> buscarPorData(LocalDate data);
}