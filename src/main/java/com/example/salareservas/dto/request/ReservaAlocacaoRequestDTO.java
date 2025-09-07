package com.example.salareservas.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaAlocacaoRequestDTO {

    private String reservaAlocacaoJustificativa;
    private LocalDate reservaAlocacaoData;
    private LocalTime reservaAlocacaoHoraInicio;
    private LocalTime reservaAlocacaoHoraFim;
    private Integer reservaAlocacaoStatus;
    private Long usuarioId;

    // Construtores
    public ReservaAlocacaoRequestDTO() {}

    // Getters e Setters
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
