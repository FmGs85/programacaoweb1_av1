package com.example.salareservas.service;

import com.example.salareservas.dto.request.AmbienteRequestDTO;
import com.example.salareservas.dto.response.AmbienteResponseDTO;
import java.util.List;

public interface AmbienteService {
    AmbienteResponseDTO criar(AmbienteRequestDTO dto);
    AmbienteResponseDTO buscarPorId(Long id);
    List<AmbienteResponseDTO> listarTodos();
    AmbienteResponseDTO atualizar(Long id, AmbienteRequestDTO dto);
    void deletar(Long id);
    List<AmbienteResponseDTO> buscarPorStatus(Integer status);
    List<AmbienteResponseDTO> buscarPorTipo(String tipo);
}