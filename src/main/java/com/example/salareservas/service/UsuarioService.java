package com.example.salareservas.service;

import com.example.salareservas.dto.request.UsuarioRequestDTO;
import com.example.salareservas.dto.response.UsuarioResponseDTO;
import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO criar(UsuarioRequestDTO dto);
    UsuarioResponseDTO buscarPorId(Long id);
    List<UsuarioResponseDTO> listarTodos();
    UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto);
    void deletar(Long id);
    UsuarioResponseDTO buscarPorMatricula(String matricula);
}