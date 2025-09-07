package com.example.salareservas.service;

import com.example.salareservas.dto.request.ReservaAlocacaoRequestDTO;
import com.example.salareservas.dto.response.ReservaAlocacaoResponseDTO;
import java.time.LocalDate;
import java.util.List;

public interface ReservaAlocacaoService {
    ReservaAlocacaoResponseDTO criar(ReservaAlocacaoRequestDTO dto);
    ReservaAlocacaoResponseDTO buscarPorId(Long id);
    List<ReservaAlocacaoResponseDTO> listarTodas();
    ReservaAlocacaoResponseDTO atualizar(Long id, ReservaAlocacaoRequestDTO dto);
    void deletar(Long id);
    List<ReservaAlocacaoResponseDTO> buscarPorData(LocalDate data);
    List<ReservaAlocacaoResponseDTO> buscarPorUsuario(Long usuarioId);
}