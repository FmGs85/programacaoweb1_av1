package com.example.salareservas.service.impl;

import com.example.salareservas.dto.request.ReservaAlocacaoRequestDTO;
import com.example.salareservas.dto.response.ReservaAlocacaoResponseDTO;
import com.example.salareservas.dto.response.UsuarioResponseDTO;
import com.example.salareservas.entity.ReservaAlocacao;
import com.example.salareservas.entity.Usuario;
import com.example.salareservas.exception.BusinessException;
import com.example.salareservas.exception.ResourceNotFoundException;
import com.example.salareservas.repository.ReservaAlocacaoRepository;
import com.example.salareservas.repository.UsuarioRepository;
import com.example.salareservas.service.ReservaAlocacaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservaAlocacaoServiceImpl implements ReservaAlocacaoService {

    private final ReservaAlocacaoRepository reservaAlocacaoRepository;
    private final UsuarioRepository usuarioRepository;

    public ReservaAlocacaoServiceImpl(ReservaAlocacaoRepository reservaAlocacaoRepository,
                                      UsuarioRepository usuarioRepository) {
        this.reservaAlocacaoRepository = reservaAlocacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public ReservaAlocacaoResponseDTO criar(ReservaAlocacaoRequestDTO dto) {
        validarReservaAlocacaoRequest(dto);

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));

        ReservaAlocacao reservaAlocacao = new ReservaAlocacao();
        reservaAlocacao.setReservaAlocacaoJustificativa(dto.getReservaAlocacaoJustificativa());
        reservaAlocacao.setReservaAlocacaoData(dto.getReservaAlocacaoData());
        reservaAlocacao.setReservaAlocacaoHoraInicio(dto.getReservaAlocacaoHoraInicio());
        reservaAlocacao.setReservaAlocacaoHoraFim(dto.getReservaAlocacaoHoraFim());
        reservaAlocacao.setReservaAlocacaoStatus(dto.getReservaAlocacaoStatus());
        reservaAlocacao.setUsuario(usuario);

        reservaAlocacao = reservaAlocacaoRepository.save(reservaAlocacao);
        return toResponseDTO(reservaAlocacao);
    }

    @Override
    @Transactional(readOnly = true)
    public ReservaAlocacaoResponseDTO buscarPorId(Long id) {
        ReservaAlocacao reservaAlocacao = reservaAlocacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva Alocação não encontrada com ID: " + id));
        return toResponseDTO(reservaAlocacao);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservaAlocacaoResponseDTO> listarTodas() {
        return reservaAlocacaoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaAlocacaoResponseDTO atualizar(Long id, ReservaAlocacaoRequestDTO dto) {
        validarReservaAlocacaoRequest(dto);

        ReservaAlocacao reservaAlocacao = reservaAlocacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva Alocação não encontrada com ID: " + id));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));

        reservaAlocacao.setReservaAlocacaoJustificativa(dto.getReservaAlocacaoJustificativa());
        reservaAlocacao.setReservaAlocacaoData(dto.getReservaAlocacaoData());
        reservaAlocacao.setReservaAlocacaoHoraInicio(dto.getReservaAlocacaoHoraInicio());
        reservaAlocacao.setReservaAlocacaoHoraFim(dto.getReservaAlocacaoHoraFim());
        reservaAlocacao.setReservaAlocacaoStatus(dto.getReservaAlocacaoStatus());
        reservaAlocacao.setUsuario(usuario);

        reservaAlocacao = reservaAlocacaoRepository.save(reservaAlocacao);
        return toResponseDTO(reservaAlocacao);
    }

    @Override
    public void deletar(Long id) {
        ReservaAlocacao reservaAlocacao = reservaAlocacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva Alocação não encontrada com ID: " + id));
        reservaAlocacaoRepository.delete(reservaAlocacao);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservaAlocacaoResponseDTO> buscarPorData(LocalDate data) {
        return reservaAlocacaoRepository.findByReservaAlocacaoData(data).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservaAlocacaoResponseDTO> buscarPorUsuario(Long usuarioId) {
        return reservaAlocacaoRepository.findByUsuarioUsuarioId(usuarioId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private void validarReservaAlocacaoRequest(ReservaAlocacaoRequestDTO dto) {
        if (dto.getReservaAlocacaoJustificativa() == null || dto.getReservaAlocacaoJustificativa().trim().isEmpty()) {
            throw new BusinessException("Justificativa é obrigatória");
        }
        if (dto.getReservaAlocacaoJustificativa().length() < 10 ||
                dto.getReservaAlocacaoJustificativa().length() > 300) {
            throw new BusinessException("Justificativa deve ter entre 10 e 300 caracteres");
        }
        if (dto.getReservaAlocacaoData() == null) {
            throw new BusinessException("Data é obrigatória");
        }
        if (dto.getReservaAlocacaoData().isBefore(LocalDate.now())) {
            throw new BusinessException("Data não pode ser no passado");
        }
        if (dto.getReservaAlocacaoHoraInicio() == null) {
            throw new BusinessException("Hora de início é obrigatória");
        }
        if (dto.getReservaAlocacaoHoraFim() == null) {
            throw new BusinessException("Hora de fim é obrigatória");
        }
        if (dto.getReservaAlocacaoHoraFim().isBefore(dto.getReservaAlocacaoHoraInicio()) ||
                dto.getReservaAlocacaoHoraFim().equals(dto.getReservaAlocacaoHoraInicio())) {
            throw new BusinessException("Hora de fim deve ser posterior à hora de início");
        }
        if (dto.getReservaAlocacaoStatus() == null) {
            throw new BusinessException("Status é obrigatório");
        }
        if (dto.getReservaAlocacaoStatus() < 0 || dto.getReservaAlocacaoStatus() > 2) {
            throw new BusinessException("Status inválido");
        }
        if (dto.getUsuarioId() == null || dto.getUsuarioId() <= 0) {
            throw new BusinessException("ID do usuário é obrigatório e deve ser positivo");
        }
    }

    private ReservaAlocacaoResponseDTO toResponseDTO(ReservaAlocacao reservaAlocacao) {
        ReservaAlocacaoResponseDTO dto = new ReservaAlocacaoResponseDTO();
        dto.setReservaAlocacaoId(reservaAlocacao.getReservaAlocacaoId());
        dto.setReservaAlocacaoJustificativa(reservaAlocacao.getReservaAlocacaoJustificativa());
        dto.setReservaAlocacaoData(reservaAlocacao.getReservaAlocacaoData());
        dto.setReservaAlocacaoHoraInicio(reservaAlocacao.getReservaAlocacaoHoraInicio());
        dto.setReservaAlocacaoHoraFim(reservaAlocacao.getReservaAlocacaoHoraFim());
        dto.setReservaAlocacaoStatus(reservaAlocacao.getReservaAlocacaoStatus());

        if (reservaAlocacao.getUsuario() != null) {
            UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO();
            usuarioDto.setUsuarioId(reservaAlocacao.getUsuario().getUsuarioId());
            usuarioDto.setUsuarioNome(reservaAlocacao.getUsuario().getUsuarioNome());
            usuarioDto.setUsuarioMatricula(reservaAlocacao.getUsuario().getUsuarioMatricula());
            usuarioDto.setUsuarioTipo(reservaAlocacao.getUsuario().getUsuarioTipo());
            usuarioDto.setUsuarioStatus(reservaAlocacao.getUsuario().getUsuarioStatus());
            dto.setUsuario(usuarioDto);
        }

        return dto;
    }
}