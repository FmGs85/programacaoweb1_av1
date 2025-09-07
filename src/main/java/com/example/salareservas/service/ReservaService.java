package com.example.salareservas.service;

import com.example.salareservas.dto.request.ReservaRequestDTO;
import com.example.salareservas.dto.response.ReservaResponseDTO;
import java.util.List;

public interface ReservaService {
    ReservaResponseDTO criar(ReservaRequestDTO dto);
    ReservaResponseDTO buscarPorId(Long id);
    List<ReservaResponseDTO> listarTodas();
    ReservaResponseDTO atualizar(Long id, ReservaRequestDTO dto);
    void deletar(Long id);
    List<ReservaResponseDTO> buscarPorSala(Long salaId);
    List<ReservaResponseDTO> buscarPorUsuario(Long usuarioId);
    boolean verificarDisponibilidade(Long salaId, ReservaRequestDTO dto);
}