package com.example.salareservas.service.impl;

import com.example.salareservas.dto.request.ReservaRequestDTO;
import com.example.salareservas.dto.response.ReservaResponseDTO;
import com.example.salareservas.dto.response.SalaResponseDTO;
import com.example.salareservas.dto.response.UsuarioResponseDTO;
import com.example.salareservas.entity.Reserva;
import com.example.salareservas.entity.Sala;
import com.example.salareservas.entity.Usuario;
import com.example.salareservas.exception.BusinessException;
import com.example.salareservas.exception.ResourceNotFoundException;
import com.example.salareservas.repository.ReservaRepository;
import com.example.salareservas.repository.SalaRepository;
import com.example.salareservas.repository.UsuarioRepository;
import com.example.salareservas.service.ReservaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;
    private final UsuarioRepository usuarioRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository,
                              SalaRepository salaRepository,
                              UsuarioRepository usuarioRepository) {
        this.reservaRepository = reservaRepository;
        this.salaRepository = salaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public ReservaResponseDTO criar(ReservaRequestDTO dto) {
        validarReservaRequest(dto);

        if (dto.getFim().isBefore(dto.getInicio()) || dto.getFim().isEqual(dto.getInicio())) {
            throw new BusinessException("A data/hora de fim deve ser posterior à data/hora de início");
        }

        if (dto.getInicio().isBefore(LocalDateTime.now())) {
            throw new BusinessException("A reserva deve ser para uma data futura");
        }

        if (!verificarDisponibilidade(dto.getSalaId(), dto)) {
            throw new BusinessException("A sala não está disponível no período solicitado");
        }

        Sala sala = salaRepository.findById(dto.getSalaId())
                .orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada com ID: " + dto.getSalaId()));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));

        Reserva reserva = new Reserva();
        reserva.setInicio(dto.getInicio());
        reserva.setFim(dto.getFim());
        reserva.setReservadoPara(dto.getReservadoPara());
        reserva.setSala(sala);
        reserva.setUsuario(usuario);
        reserva.setTempo(LocalDateTime.now());

        reserva = reservaRepository.save(reserva);
        return toResponseDTO(reserva);
    }

    @Override
    @Transactional(readOnly = true)
    public ReservaResponseDTO buscarPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada com ID: " + id));
        return toResponseDTO(reserva);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservaResponseDTO> listarTodas() {
        return reservaRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaResponseDTO atualizar(Long id, ReservaRequestDTO dto) {
        validarReservaRequest(dto);

        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada com ID: " + id));

        if (dto.getFim().isBefore(dto.getInicio()) || dto.getFim().isEqual(dto.getInicio())) {
            throw new BusinessException("A data/hora de fim deve ser posterior à data/hora de início");
        }

        List<Reserva> conflitos = reservaRepository.findConflictingReservas(
                dto.getSalaId(), dto.getInicio(), dto.getFim());
        conflitos = conflitos.stream()
                .filter(r -> !r.getId().equals(id))
                .collect(Collectors.toList());

        if (!conflitos.isEmpty()) {
            throw new BusinessException("A sala não está disponível no período solicitado");
        }

        Sala sala = salaRepository.findById(dto.getSalaId())
                .orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada com ID: " + dto.getSalaId()));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));

        reserva.setInicio(dto.getInicio());
        reserva.setFim(dto.getFim());
        reserva.setReservadoPara(dto.getReservadoPara());
        reserva.setSala(sala);
        reserva.setUsuario(usuario);

        reserva = reservaRepository.save(reserva);
        return toResponseDTO(reserva);
    }

    @Override
    public void deletar(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada com ID: " + id));
        reservaRepository.delete(reserva);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservaResponseDTO> buscarPorSala(Long salaId) {
        return reservaRepository.findBySalaId(salaId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservaResponseDTO> buscarPorUsuario(Long usuarioId) {
        return reservaRepository.findByUsuarioUsuarioId(usuarioId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean verificarDisponibilidade(Long salaId, ReservaRequestDTO dto) {
        List<Reserva> conflitos = reservaRepository.findConflictingReservas(
                salaId, dto.getInicio(), dto.getFim());
        return conflitos.isEmpty();
    }

    private void validarReservaRequest(ReservaRequestDTO dto) {
        if (dto.getInicio() == null) {
            throw new BusinessException("Data/hora de início é obrigatória");
        }
        if (dto.getFim() == null) {
            throw new BusinessException("Data/hora de fim é obrigatória");
        }
        if (dto.getReservadoPara() == null || dto.getReservadoPara().trim().isEmpty()) {
            throw new BusinessException("Campo 'reservado para' é obrigatório");
        }
        if (dto.getReservadoPara().length() > 255) {
            throw new BusinessException("Campo 'reservado para' deve ter no máximo 255 caracteres");
        }
        if (dto.getSalaId() == null || dto.getSalaId() <= 0) {
            throw new BusinessException("ID da sala é obrigatório e deve ser positivo");
        }
        if (dto.getUsuarioId() == null || dto.getUsuarioId() <= 0) {
            throw new BusinessException("ID do usuário é obrigatório e deve ser positivo");
        }
    }

    private ReservaResponseDTO toResponseDTO(Reserva reserva) {
        ReservaResponseDTO dto = new ReservaResponseDTO();
        dto.setId(reserva.getId());
        dto.setInicio(reserva.getInicio());
        dto.setFim(reserva.getFim());
        dto.setReservadoPara(reserva.getReservadoPara());
        dto.setTempo(reserva.getTempo());

        if (reserva.getSala() != null) {
            SalaResponseDTO salaDto = new SalaResponseDTO();
            salaDto.setId(reserva.getSala().getId());
            salaDto.setNome(reserva.getSala().getNome());
            salaDto.setBloco(reserva.getSala().getBloco());
            salaDto.setCapacidade(reserva.getSala().getCapacidade());
            dto.setSala(salaDto);
        }

        if (reserva.getUsuario() != null) {
            UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO();
            usuarioDto.setUsuarioId(reserva.getUsuario().getUsuarioId());
            usuarioDto.setUsuarioNome(reserva.getUsuario().getUsuarioNome());
            usuarioDto.setUsuarioMatricula(reserva.getUsuario().getUsuarioMatricula());
            usuarioDto.setUsuarioTipo(reserva.getUsuario().getUsuarioTipo());
            usuarioDto.setUsuarioStatus(reserva.getUsuario().getUsuarioStatus());
            dto.setUsuario(usuarioDto);
        }

        return dto;
    }
}