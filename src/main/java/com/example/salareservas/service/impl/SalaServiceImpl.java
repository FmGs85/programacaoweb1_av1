package com.example.salareservas.service.impl;

import com.example.salareservas.dto.request.SalaRequestDTO;
import com.example.salareservas.dto.response.SalaResponseDTO;
import com.example.salareservas.entity.Sala;
import com.example.salareservas.exception.ResourceNotFoundException;
import com.example.salareservas.exception.BusinessException;
import com.example.salareservas.repository.SalaRepository;
import com.example.salareservas.service.SalaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;

    public SalaServiceImpl(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Override
    public SalaResponseDTO criar(SalaRequestDTO dto) {
        validarSalaRequest(dto);

        Sala sala = new Sala();
        sala.setBloco(dto.getBloco());
        sala.setCapacidade(dto.getCapacidade());
        sala.setNome(dto.getNome());

        sala = salaRepository.save(sala);
        return toResponseDTO(sala);
    }

    @Override
    @Transactional(readOnly = true)
    public SalaResponseDTO buscarPorId(Long id) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada com ID: " + id));
        return toResponseDTO(sala);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SalaResponseDTO> listarTodas() {
        return salaRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SalaResponseDTO atualizar(Long id, SalaRequestDTO dto) {
        validarSalaRequest(dto);

        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada com ID: " + id));

        sala.setBloco(dto.getBloco());
        sala.setCapacidade(dto.getCapacidade());
        sala.setNome(dto.getNome());

        sala = salaRepository.save(sala);
        return toResponseDTO(sala);
    }

    @Override
    public void deletar(Long id) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada com ID: " + id));
        salaRepository.delete(sala);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SalaResponseDTO> buscarPorBloco(String bloco) {
        return salaRepository.findByBloco(bloco).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SalaResponseDTO> buscarPorCapacidadeMinima(Integer capacidade) {
        return salaRepository.findByCapacidadeGreaterThanEqual(capacidade).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private void validarSalaRequest(SalaRequestDTO dto) {
        if (dto.getBloco() == null || dto.getBloco().trim().isEmpty()) {
            throw new BusinessException("Bloco é obrigatório");
        }
        if (dto.getBloco().length() > 255) {
            throw new BusinessException("Bloco deve ter no máximo 255 caracteres");
        }
        if (dto.getCapacidade() == null) {
            throw new BusinessException("Capacidade é obrigatória");
        }
        if (dto.getCapacidade() < 1) {
            throw new BusinessException("Capacidade deve ser maior que zero");
        }
        if (dto.getCapacidade() > 500) {
            throw new BusinessException("Capacidade máxima é 500");
        }
        if (dto.getNome() == null || dto.getNome().trim().isEmpty()) {
            throw new BusinessException("Nome da sala é obrigatório");
        }
        if (dto.getNome().length() > 25) {
            throw new BusinessException("Nome deve ter no máximo 25 caracteres");
        }
    }

    private SalaResponseDTO toResponseDTO(Sala sala) {
        SalaResponseDTO dto = new SalaResponseDTO();
        dto.setId(sala.getId());
        dto.setBloco(sala.getBloco());
        dto.setCapacidade(sala.getCapacidade());
        dto.setNome(sala.getNome());
        return dto;
    }
}