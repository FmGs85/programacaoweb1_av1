package com.example.salareservas.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaAlocacaoResponseDTO {
    private Long reservaAlocacaoId;
    private String reservaAlocacaoJustificativa;
    private LocalDate reservaAlocacaoData;
    private LocalTime reservaAlocacaoHoraInicio;
    private LocalTime reservaAlocacaoHoraFim;
    private Integer reservaAlocacaoStatus;
    private UsuarioResponseDTO usuario;


    public ReservaAlocacaoResponseDTO() {}


    public Long getReservaAlocacaoId() {
        return reservaAlocacaoId;
    }

    public void setReservaAlocacaoId(Long reservaAlocacaoId) {
        this.reservaAlocacaoId = reservaAlocacaoId;
    }

    public String getReservaAlocacaoJustificativa() {
        return reservaAlocacaoJustificativa;
    }

    public void setReservaAlocacaoJustificativa(String reservaAlocacaoJustificativa) {
        this.reservaAlocacaoJustificativa = reservaAlocacaoJustificativa;
    }

    public LocalDate getReservaAlocacaoData() {
        return reservaAlocacaoData;
    }

    public void setReservaAlocacaoData(LocalDate reservaAlocacaoData) {
        this.reservaAlocacaoData = reservaAlocacaoData;
    }

    public LocalTime getReservaAlocacaoHoraInicio() {
        return reservaAlocacaoHoraInicio;
    }

    public void setReservaAlocacaoHoraInicio(LocalTime reservaAlocacaoHoraInicio) {
        this.reservaAlocacaoHoraInicio = reservaAlocacaoHoraInicio;
    }

    public LocalTime getReservaAlocacaoHoraFim() {
        return reservaAlocacaoHoraFim;
    }

    public void setReservaAlocacaoHoraFim(LocalTime reservaAlocacaoHoraFim) {
        this.reservaAlocacaoHoraFim = reservaAlocacaoHoraFim;
    }

    public Integer getReservaAlocacaoStatus() {
        return reservaAlocacaoStatus;
    }

    public void setReservaAlocacaoStatus(Integer reservaAlocacaoStatus) {
        this.reservaAlocacaoStatus = reservaAlocacaoStatus;
    }

    public UsuarioResponseDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponseDTO usuario) {
        this.usuario = usuario;
    }
}