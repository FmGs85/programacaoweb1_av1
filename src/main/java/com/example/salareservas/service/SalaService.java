package com.example.salareservas.service;

import com.example.salareservas.dto.request.SalaRequestDTO;
import com.example.salareservas.dto.response.SalaResponseDTO;
import java.util.List;

public interface SalaService {
    SalaResponseDTO criar(SalaRequestDTO dto);
    SalaResponseDTO buscarPorId(Long id);
    List<SalaResponseDTO> listarTodas();
    SalaResponseDTO atualizar(Long id, SalaRequestDTO dto);
    void deletar(Long id);
    List<SalaResponseDTO> buscarPorBloco(String bloco);
    List<SalaResponseDTO> buscarPorCapacidadeMinima(Integer capacidade);
}