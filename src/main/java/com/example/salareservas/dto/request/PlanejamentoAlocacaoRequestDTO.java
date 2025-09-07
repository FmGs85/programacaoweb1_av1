package com.example.salareservas.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class PlanejamentoAlocacaoRequestDTO {

    private LocalDate planejamentoAlocacaoData;
    private LocalTime planejamentoAlocacaoHoraInicio;
    private LocalTime planejamentoAlocacaoHoraFim;
    private String planejamentoAlocacaoObservacao;
    private Integer planejamentoAlocacaoStatus;
    private Long ambienteId;
    private Long usuarioId;
    private Long reservaAlocacaoId;


    public PlanejamentoAlocacaoRequestDTO() {}


    public LocalDate getPlanejamentoAlocacaoData() {
        return planejamentoAlocacaoData;
    }

    public void setPlanejamentoAlocacaoData(LocalDate planejamentoAlocacaoData) {
        this.planejamentoAlocacaoData = planejamentoAlocacaoData;
    }

    public LocalTime getPlanejamentoAlocacaoHoraInicio() {
        return planejamentoAlocacaoHoraInicio;
    }

    public void setPlanejamentoAlocacaoHoraInicio(LocalTime planejamentoAlocacaoHoraInicio) {
        this.planejamentoAlocacaoHoraInicio = planejamentoAlocacaoHoraInicio;
    }

    public LocalTime getPlanejamentoAlocacaoHoraFim() {
        return planejamentoAlocacaoHoraFim;
    }

    public void setPlanejamentoAlocacaoHoraFim(LocalTime planejamentoAlocacaoHoraFim) {
        this.planejamentoAlocacaoHoraFim = planejamentoAlocacaoHoraFim;
    }

    public String getPlanejamentoAlocacaoObservacao() {
        return planejamentoAlocacaoObservacao;
    }

    public void setPlanejamentoAlocacaoObservacao(String planejamentoAlocacaoObservacao) {
        this.planejamentoAlocacaoObservacao = planejamentoAlocacaoObservacao;
    }

    public Integer getPlanejamentoAlocacaoStatus() {
        return planejamentoAlocacaoStatus;
    }

    public void setPlanejamentoAlocacaoStatus(Integer planejamentoAlocacaoStatus) {
        this.planejamentoAlocacaoStatus = planejamentoAlocacaoStatus;
    }

    public AmbienteResponseDTO getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(AmbienteResponseDTO ambiente) {
        this.ambiente = ambiente;
    }

    public UsuarioResponseDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponseDTO usuario) {
        this.usuario = usuario;
    }

    public ReservaAlocacaoResponseDTO getReservaAlocacao() {
        return reservaAlocacao;
    }

    public void setReservaAlocacao(ReservaAlocacaoResponseDTO reservaAlocacao) {
        this.reservaAlocacao = reservaAlocacao;
    }
} planejamentoAlocacaoStatus;
    }

public Long getAmbienteId() {
    return ambienteId;
}

public void setAmbienteId(Long ambienteId) {
    this.ambienteId = ambienteId;
}

public Long getUsuarioId() {
    return usuarioId;
}

public void setUsuarioId(Long usuarioId) {
    this.usuarioId = usuarioId;
}

public Long getReservaAlocacaoId() {
    return reservaAlocacaoId;
}

public void setReservaAlocacaoId(Long reservaAlocacaoId) {
    this.reservaAlocacaoId = reservaAlocacaoId;
}
}