package com.example.salareservas.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class PlanejamentoAlocacaoResponseDTO {
    private Long planejamentoAlocacaoId;
    private LocalDate planejamentoAlocacaoData;
    private LocalTime planejamentoAlocacaoHoraInicio;
    private LocalTime planejamentoAlocacaoHoraFim;
    private String planejamentoAlocacaoObservacao;
    private Integer planejamentoAlocacaoStatus;
    private AmbienteResponseDTO ambiente;
    private UsuarioResponseDTO usuario;
    private ReservaAlocacaoResponseDTO reservaAlocacao;


    public PlanejamentoAlocacaoResponseDTO() {}


    public Long getPlanejamentoAlocacaoId() {
        return planejamentoAlocacaoId;
    }

    public void setPlanejamentoAlocacaoId(Long planejamentoAlocacaoId) {
        this.planejamentoAlocacaoId = planejamentoAlocacaoId;
    }

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
        this.planejamentoAlocacaoStatus =