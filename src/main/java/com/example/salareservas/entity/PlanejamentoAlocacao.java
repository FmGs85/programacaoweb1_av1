package com.example.salareservas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "planejamento_alocacao")
public class PlanejamentoAlocacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planejamento_alocacao_id")
    private Long planejamentoAlocacaoId;

    @Column(name = "planejamento_alocacao_data")
    private LocalDate planejamentoAlocacaoData;

    @Column(name = "planejamento_alocacao_hora_inicio")
    private LocalTime planejamentoAlocacaoHoraInicio;

    @Column(name = "planejamento_alocacao_hora_fim")
    private LocalTime planejamentoAlocacaoHoraFim;

    @Column(name = "planejamento_alocacao_observacao", length = 300)
    private String planejamentoAlocacaoObservacao;

    @Column(name = "planejamento_alocacao_status")
    private Integer planejamentoAlocacaoStatus;

    @ManyToOne
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "reserva_alocacao_id")
    private ReservaAlocacao reservaAlocacao;

    public PlanejamentoAlocacao() {}

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
        this.planejamentoAlocacaoStatus = planejamentoAlocacaoStatus;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ReservaAlocacao getReservaAlocacao() {
        return reservaAlocacao;
    }

    public void setReservaAlocacao(ReservaAlocacao reservaAlocacao) {
        this.reservaAlocacao = reservaAlocacao;
    }
}
