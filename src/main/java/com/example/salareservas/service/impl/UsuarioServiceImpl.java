package com.example.salareservas.service.impl;

import com.example.salareservas.dto.request.UsuarioRequestDTO;
import com.example.salareservas.dto.response.UsuarioResponseDTO;
import com.example.salareservas.entity.Usuario;
import com.example.salareservas.exception.ResourceNotFoundException;
import com.example.salareservas.exception.BusinessException;
import com.example.salareservas.repository.UsuarioRepository;
import com.example.salareservas.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        validarUsuarioRequest(dto);

        if (usuarioRepository.existsByUsuarioMatricula(dto.getUsuarioMatricula())) {
            throw new BusinessException("Matrícula já cadastrada: " + dto.getUsuarioMatricula());
        }

        Usuario usuario = new Usuario();
        usuario.setUsuarioNome(dto.getUsuarioNome());
        usuario.setUsuarioMatricula(dto.getUsuarioMatricula());
        usuario.setUsuarioTipo(dto.getUsuarioTipo());
        usuario.setUsuarioStatus(dto.getUsuarioStatus());
        usuario.setUsuarioLogDataCriacao(LocalDateTime.now());

        usuario = usuarioRepository.save(usuario);
        return toResponseDTO(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
        return toResponseDTO(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        validarUsuarioRequest(dto);

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));

        if (!usuario.getUsuarioMatricula().equals(dto.getUsuarioMatricula()) &&
                usuarioRepository.existsByUsuarioMatricula(dto.getUsuarioMatricula())) {
            throw new BusinessException("Matrícula já cadastrada: " + dto.getUsuarioMatricula());
        }

        usuario.setUsuarioNome(dto.getUsuarioNome());
        usuario.setUsuarioMatricula(dto.getUsuarioMatricula());
        usuario.setUsuarioTipo(dto.getUsuarioTipo());
        usuario.setUsuarioStatus(dto.getUsuarioStatus());

        usuario = usuarioRepository.save(usuario);
        return toResponseDTO(usuario);
    }

    @Override
    public void deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
        usuarioRepository.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorMatricula(String matricula) {
        Usuario usuario = usuarioRepository.findByUsuarioMatricula(matricula)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com matrícula: " + matricula));
        return toResponseDTO(usuario);
    }

    private void validarUsuarioRequest(UsuarioRequestDTO dto) {
        if (dto.getUsuarioNome() == null || dto.getUsuarioNome().trim().isEmpty()) {
            throw new BusinessException("Nome do usuário é obrigatório");
        }
        if (dto.getUsuarioNome().length() < 3 || dto.getUsuarioNome().length() > 300) {
            throw new BusinessException("Nome deve ter entre 3 e 300 caracteres");
        }
        if (dto.getUsuarioMatricula() == null || dto.getUsuarioMatricula().trim().isEmpty()) {
            throw new BusinessException("Matrícula é obrigatória");
        }
        if (dto.getUsuarioMatricula().length() > 45) {
            throw new BusinessException("Matrícula deve ter no máximo 45 caracteres");
        }
        if (!dto.getUsuarioMatricula().matches("^[A-Za-z0-9]+$")) {
            throw new BusinessException("Matrícula deve conter apenas letras e números");
        }
        if (dto.getUsuarioTipo() == null) {
            throw new BusinessException("Tipo de usuário é obrigatório");
        }
        if (dto.getUsuarioTipo() < 1 || dto.getUsuarioTipo() > 3) {
            throw new BusinessException("Tipo de usuário inválido");
        }
        if (dto.getUsuarioStatus() == null) {
            throw new BusinessException("Status é obrigatório");
        }
        if (dto.getUsuarioStatus() < 0 || dto.getUsuarioStatus() > 1) {
            throw new BusinessException("Status inválido");
        }
    }

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setUsuarioId(usuario.getUsuarioId());
        dto.setUsuarioNome(usuario.getUsuarioNome());
        dto.setUsuarioMatricula(usuario.getUsuarioMatricula());
        dto.setUsuarioTipo(usuario.getUsuarioTipo());
        dto.setUsuarioStatus(usuario.getUsuarioStatus());
        dto.setUsuarioLogDataCriacao(usuario.getUsuarioLogDataCriacao());
        return dto;
    }
}