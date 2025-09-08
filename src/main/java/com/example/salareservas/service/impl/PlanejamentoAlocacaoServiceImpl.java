package com.example.salareservas.service.impl;

import com.example.salareservas.dto.request.PlanejamentoAlocacaoRequestDTO;
import com.example.salareservas.dto.response.PlanejamentoAlocacaoResponseDTO;
import com.example.salareservas.dto.response.AmbienteResponseDTO;
import com.example.salareservas.dto.response.UsuarioResponseDTO;
import com.example.salareservas.dto.response.ReservaAlocacaoResponseDTO;
import com.example.salareservas.entity.PlanejamentoAlocacao;
import com.example.salareservas.entity.Ambiente;
import com.example.salareservas.entity.Usuario;
import com.example.salareservas.entity.ReservaAlocacao;
import com.example.salareservas.exception.BusinessException;
import com.example.salareservas.exception.ResourceNotFoundException;
import com.example.salareservas.repository.PlanejamentoAlocacaoRepository;
import com.example.salareservas.repository.AmbienteRepository;
import com.example.salareservas.repository.UsuarioRepository;
import com.example.salareservas.repository.ReservaAlocacaoRepository;
import com.example.salareservas.service.PlanejamentoAlocacaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanejamentoAlocacaoServiceImpl implements PlanejamentoAlocacaoService {

    private final PlanejamentoAlocacaoRepository planejamentoAlocacaoRepository;
    private final AmbienteRepository ambienteRepository;
    private final UsuarioRepository usuarioRepository;
    private final ReservaAlocacaoRepository reservaAlocacaoRepository;

    public PlanejamentoAlocacaoServiceImpl(PlanejamentoAlocacaoRepository planejamentoAlocacaoRepository,
                                           AmbienteRepository ambienteRepository,
                                           UsuarioRepository usuarioRepository,
                                           ReservaAlocacaoRepository reservaAlocacaoRepository) {
        this.planejamentoAlocacaoRepository = planejamentoAlocacaoRepository;
        this.ambienteRepository = ambienteRepository;
        this.usuarioRepository = usuarioRepository;
        this.reservaAlocacaoRepository = reservaAlocacaoRepository;
    }

    @Override
    public PlanejamentoAlocacaoResponseDTO criar(PlanejamentoAlocacaoRequestDTO dto) {
        validarPlanejamentoAlocacaoRequest(dto);

        Ambiente ambiente = ambienteRepository.findById(dto.getAmbienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Ambiente não encontrado com ID: " + dto.getAmbienteId()));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));

        ReservaAlocacao reservaAlocacao = null;
        if (dto.getReservaAlocacaoId() != null) {
            reservaAlocacao = reservaAlocacaoRepository.findById(dto.getReservaAlocacaoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Reserva Alocação não encontrada com ID: " + dto.getReservaAlocacaoId()));
        }

        PlanejamentoAlocacao planejamentoAlocacao = new PlanejamentoAlocacao();
        planejamentoAlocacao.setPlanejamentoAlocacaoData(dto.getPlanejamentoAlocacaoData());
        planejamentoAlocacao.setPlanejamentoAlocacaoHoraInicio(dto.getPlanejamentoAlocacaoHoraInicio());
        planejamentoAlocacao.setPlanejamentoAlocacaoHoraFim(dto.getPlanejamentoAlocacaoHoraFim());
        planejamentoAlocacao.setPlanejamentoAlocacaoObservacao(dto.getPlanejamentoAlocacaoObservacao());
        planejamentoAlocacao.setPlanejamentoAlocacaoStatus(dto.getPlanejamentoAlocacaoStatus());
        planejamentoAlocacao.setAmbiente(ambiente);
        planejamentoAlocacao.setUsuario(usuario);
        planejamentoAlocacao.setReservaAlocacao(reservaAlocacao);

        planejamentoAlocacao = planejamentoAlocacaoRepository.save(planejamentoAlocacao);
        return toResponseDTO(planejamentoAlocacao);
    }

    @Override
    @Transactional(readOnly = true)
    public PlanejamentoAlocacaoResponseDTO buscarPorId(Long id) {
        PlanejamentoAlocacao planejamentoAlocacao = planejamentoAlocacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planejamento de Alocação não encontrado com ID: " + id));
        return toResponseDTO(planejamentoAlocacao);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanejamentoAlocacaoResponseDTO> listarTodos() {
        return planejamentoAlocacaoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlanejamentoAlocacaoResponseDTO atualizar(Long id, PlanejamentoAlocacaoRequestDTO dto) {
        validarPlanejamentoAlocacaoRequest(dto);

        PlanejamentoAlocacao planejamentoAlocacao = planejamentoAlocacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planejamento de Alocação não encontrado com ID: " + id));

        Ambiente ambiente = ambienteRepository.findById(dto.getAmbienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Ambiente não encontrado com ID: " + dto.getAmbienteId()));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));

        ReservaAlocacao reservaAlocacao = null;
        if (dto.getReservaAlocacaoId() != null) {
            reservaAlocacao = reservaAlocacaoRepository.findById(dto.getReservaAlocacaoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Reserva Alocação não encontrada com ID: " + dto.getReservaAlocacaoId()));
        }

        planejamentoAlocacao.setPlanejamentoAlocacaoData(dto.getPlanejamentoAlocacaoData());
        planejamentoAlocacao.setPlanejamentoAlocacaoHoraInicio(dto.getPlanejamentoAlocacaoHoraInicio());
        planejamentoAlocacao.setPlanejamentoAlocacaoHoraFim(dto.getPlanejamentoAlocacaoHoraFim());
        planejamentoAlocacao.setPlanejamentoAlocacaoObservacao(dto.getPlanejamentoAlocacaoObservacao());
        planejamentoAlocacao.setPlanejamentoAlocacaoStatus(dto.getPlanejamentoAlocacaoStatus());
        planejamentoAlocacao.setAmbiente(ambiente);
        planejamentoAlocacao.setUsuario(usuario);
        planejamentoAlocacao.setReservaAlocacao(reservaAlocacao);

        planejamentoAlocacao = planejamentoAlocacaoRepository.save(planejamentoAlocacao);
        return toResponseDTO(planejamentoAlocacao);
    }

    @Override
    public void deletar(Long id) {
        PlanejamentoAlocacao planejamentoAlocacao = planejamentoAlocacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planejamento de Alocação não encontrado com ID: " + id));
        planejamentoAlocacaoRepository.delete(planejamentoAlocacao);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanejamentoAlocacaoResponseDTO> buscarPorAmbiente(Long ambienteId) {
        return planejamentoAlocacaoRepository.findByAmbienteAmbienteId(ambienteId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanejamentoAlocacaoResponseDTO> buscarPorData(LocalDate data) {
        return planejamentoAlocacaoRepository.findByPlanejamentoAlocacaoData(data).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private void validarPlanejamentoAlocacaoRequest(PlanejamentoAlocacaoRequestDTO dto) {
        if (dto.getPlanejamentoAlocacaoData() == null) {
            throw new BusinessException("Data é obrigatória");
        }
        if (dto.getPlanejamentoAlocacaoData().isBefore(LocalDate.now())) {
            throw new BusinessException("Data não pode ser no passado");
        }
        if (dto.getPlanejamentoAlocacaoHoraInicio() == null) {
            throw new BusinessException("Hora de início é obrigatória");
        }
        if (dto.getPlanejamentoAlocacaoHoraFim() == null) {
            throw new BusinessException("Hora de fim é obrigatória");
        }
        if (dto.getPlanejamentoAlocacaoHoraFim().isBefore(dto.getPlanejamentoAlocacaoHoraInicio()) ||
                dto.getPlanejamentoAlocacaoHoraFim().equals(dto.getPlanejamentoAlocacaoHoraInicio())) {
            throw new BusinessException("Hora de fim deve ser posterior à hora de início");
        }
        if (dto.getPlanejamentoAlocacaoObservacao() != null && dto.getPlanejamentoAlocacaoObservacao().length() > 300) {
            throw new BusinessException("Observação deve ter no máximo 300 caracteres");
        }
        if (dto.getPlanejamentoAlocacaoStatus() == null) {
            throw new BusinessException("Status é obrigatório");
        }
        if (dto.getPlanejamentoAlocacaoStatus() < 0 || dto.getPlanejamentoAlocacaoStatus() > 2) {
            throw new BusinessException("Status inválido");
        }
        if (dto.getAmbienteId() == null || dto.getAmbienteId() <= 0) {
            throw new BusinessException("ID do ambiente é obrigatório e deve ser positivo");
        }
        if (dto.getUsuarioId() == null || dto.getUsuarioId() <= 0) {
            throw new BusinessException("ID do usuário é obrigatório e deve ser positivo");
        }
    }

    private PlanejamentoAlocacaoResponseDTO toResponseDTO(PlanejamentoAlocacao planejamentoAlocacao) {
        PlanejamentoAlocacaoResponseDTO dto = new PlanejamentoAlocacaoResponseDTO();
        dto.setPlanejamentoAlocacaoId(planejamentoAlocacao.getPlanejamentoAlocacaoId());
        dto.setPlanejamentoAlocacaoData(planejamentoAlocacao.getPlanejamentoAlocacaoData());
        dto.setPlanejamentoAlocacaoHoraInicio(planejamentoAlocacao.getPlanejamentoAlocacaoHoraInicio());
        dto.setPlanejamentoAlocacaoHoraFim(planejamentoAlocacao.getPlanejamentoAlocacaoHoraFim());
        dto.setPlanejamentoAlocacaoObservacao(planejamentoAlocacao.getPlanejamentoAlocacaoObservacao());
        dto.setPlanejamentoAlocacaoStatus(planejamentoAlocacao.getPlanejamentoAlocacaoStatus());

        if (planejamentoAlocacao.getAmbiente() != null) {
            AmbienteResponseDTO ambienteDto = new AmbienteResponseDTO();
            ambienteDto.setAmbienteId(planejamentoAlocacao.getAmbiente().getAmbienteId());
            ambienteDto.setAmbienteDescricao(planejamentoAlocacao.getAmbiente().getAmbienteDescricao());
            ambienteDto.setAmbienteAndar(planejamentoAlocacao.getAmbiente().getAmbienteAndar());
            ambienteDto.setAmbienteTipo(planejamentoAlocacao.getAmbiente().getAmbienteTipo());
            ambienteDto.setAmbienteCapacidade(planejamentoAlocacao.getAmbiente().getAmbienteCapacidade());
            ambienteDto.setAmbienteStatus(planejamentoAlocacao.getAmbiente().getAmbienteStatus());
            dto.setAmbiente(ambienteDto);
        }

        if (planejamentoAlocacao.getUsuario() != null) {
            UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO();
            usuarioDto.setUsuarioId(planejamentoAlocacao.getUsuario().getUsuarioId());
            usuarioDto.setUsuarioNome(planejamentoAlocacao.getUsuario().getUsuarioNome());
            usuarioDto.setUsuarioMatricula(planejamentoAlocacao.getUsuario().getUsuarioMatricula());
            usuarioDto.setUsuarioTipo(planejamentoAlocacao.getUsuario().getUsuarioTipo());
            usuarioDto.setUsuarioStatus(planejamentoAlocacao.getUsuario().getUsuarioStatus());
            dto.setUsuario(usuarioDto);
        }

        if (planejamentoAlocacao.getReservaAlocacao() != null) {
            ReservaAlocacaoResponseDTO reservaAlocacaoDto = new ReservaAlocacaoResponseDTO();
            reservaAlocacaoDto.setReservaAlocacaoId(planejamentoAlocacao.getReservaAlocacao().getReservaAlocacaoId());
            reservaAlocacaoDto.setReservaAlocacaoJustificativa(planejamentoAlocacao.getReservaAlocacao().getReservaAlocacaoJustificativa());
            reservaAlocacaoDto.setReservaAlocacaoData(planejamentoAlocacao.getReservaAlocacao().getReservaAlocacaoData());
            reservaAlocacaoDto.setReservaAlocacaoHoraInicio(planejamentoAlocacao.getReservaAlocacao().getReservaAlocacaoHoraInicio());
            reservaAlocacaoDto.setReservaAlocacaoHoraFim(planejamentoAlocacao.getReservaAlocacao().getReservaAlocacaoHoraFim());
            reservaAlocacaoDto.setReservaAlocacaoStatus(planejamentoAlocacao.getReservaAlocacao().getReservaAlocacaoStatus());
            dto.setReservaAlocacao(reservaAlocacaoDto);
        }

        return dto;
    }
}