package com.example.salareservas.service.impl;

import com.example.salareservas.dto.request.AmbienteRequestDTO;
import com.example.salareservas.dto.response.AmbienteResponseDTO;
import com.example.salareservas.entity.Ambiente;
import com.example.salareservas.exception.BusinessException;
import com.example.salareservas.exception.ResourceNotFoundException;
import com.example.salareservas.repository.AmbienteRepository;
import com.example.salareservas.service.AmbienteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AmbienteServiceImpl implements AmbienteService {

    private final AmbienteRepository ambienteRepository;

    public AmbienteServiceImpl(AmbienteRepository ambienteRepository) {
        this.ambienteRepository = ambienteRepository;
    }

    @Override
    public AmbienteResponseDTO criar(AmbienteRequestDTO dto) {
        validarAmbienteRequest(dto);

        Ambiente ambiente = new Ambiente();
        ambiente.setAmbienteStatus(dto.getAmbienteStatus());

        ambiente = ambienteRepository.save(ambiente);
        return toResponseDTO(ambiente);
    }

    @Override
    @Transactional(readOnly = true)
    public AmbienteResponseDTO buscarPorId(Long id) {
        Ambiente ambiente = ambienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ambiente não encontrado com ID: " + id));
        return toResponseDTO(ambiente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AmbienteResponseDTO> listarTodos() {
        return ambienteRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AmbienteResponseDTO atualizar(Long id, AmbienteRequestDTO dto) {
        validarAmbienteRequest(dto);

        Ambiente ambiente = ambienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ambiente não encontrado com ID: " + id));

        ambiente.setAmbienteDescricao(dto.getAmbienteDescricao());
        ambiente.setAmbienteAndar(dto.getAmbienteAndar());
        ambiente.setAmbienteTipo(dto.getAmbienteTipo());
        ambiente.setAmbienteNumeroPcs(dto.getAmbienteNumeroPcs());
        ambiente.setAmbienteCapacidade(dto.getAmbienteCapacidade());
        ambiente.setAmbienteStatus(dto.getAmbienteStatus());

        ambiente = ambienteRepository.save(ambiente);
        return toResponseDTO(ambiente);
    }

    @Override
    public void deletar(Long id) {
        Ambiente ambiente = ambienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ambiente não encontrado com ID: " + id));
        ambienteRepository.delete(ambiente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AmbienteResponseDTO> buscarPorStatus(Integer status) {
        return ambienteRepository.findByAmbienteStatus(status).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AmbienteResponseDTO> buscarPorTipo(String tipo) {
        return ambienteRepository.findByAmbienteTipo(tipo).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private void validarAmbienteRequest(AmbienteRequestDTO dto) {
        if (dto.getAmbienteDescricao() == null || dto.getAmbienteDescricao().trim().isEmpty()) {
            throw new BusinessException("Descrição do ambiente é obrigatória");
        }
        if (dto.getAmbienteDescricao().length() > 45) {
            throw new BusinessException("Descrição deve ter no máximo 45 caracteres");
        }
        if (dto.getAmbienteAndar() == null) {
            throw new BusinessException("Andar é obrigatório");
        }
        if (dto.getAmbienteAndar() < -2 || dto.getAmbienteAndar() > 20) {
            throw new BusinessException("Andar inválido");
        }
        if (dto.getAmbienteTipo() == null || dto.getAmbienteTipo().trim().isEmpty()) {
            throw new BusinessException("Tipo de ambiente é obrigatório");
        }
        if (dto.getAmbienteTipo().length() > 45) {
            throw new BusinessException("Tipo deve ter no máximo 45 caracteres");
        }
        if (dto.getAmbienteNumeroPcs() != null && dto.getAmbienteNumeroPcs() < 0) {
            throw new BusinessException("Número de PCs não pode ser negativo");
        }
        if (dto.getAmbienteCapacidade() == null) {
            throw new BusinessException("Capacidade é obrigatória");
        }
        if (dto.getAmbienteCapacidade() < 1) {
            throw new BusinessException("Capacidade deve ser maior que zero");
        }
        if (dto.getAmbienteStatus() == null) {
            throw new BusinessException("Status é obrigatório");
        }
        if (dto.getAmbienteStatus() < 0 || dto.getAmbienteStatus() > 1) {
            throw new BusinessException("Status inválido");
        }
    }

    private AmbienteResponseDTO toResponseDTO(Ambiente ambiente) {
        AmbienteResponseDTO dto = new AmbienteResponseDTO();
        dto.setAmbienteId(ambiente.getAmbienteId());
        dto.setAmbienteDescricao(ambiente.getAmbienteDescricao());
        dto.setAmbienteAndar(ambiente.getAmbienteAndar());
        dto.setAmbienteTipo(ambiente.getAmbienteTipo());
        dto.setAmbienteNumeroPcs(ambiente.getAmbienteNumeroPcs());
        dto.setAmbienteCapacidade(ambiente.getAmbienteCapacidade());
        dto.setAmbienteStatus(ambiente.getAmbienteStatus());
        return dto;
    }
}