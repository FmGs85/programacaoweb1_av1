package com.example.salareservas.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "registro_utilizacao_ambiente")
public class RegistroUtilizacaoAmbiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_utilizacao_ambiente_id")
    private Long registroUtilizacaoAmbienteId;

    @Column(name = "registro_utilizacao_ambiente_hora_entrada")
    private LocalDateTime registroUtilizacaoAmbienteHoraEntrada;

    @Column(name = "registro_utilizacao_ambiente_hora_saida")
    private LocalDateTime registroUtilizacaoAmbienteHoraSaida;

    @Column(name = "registro_utilizacao_ambiente_status")
    private Integer registroUtilizacaoAmbienteStatus;

    @Column(name = "registro_utilizacao_ambiente_observacao", length = 400)
    private String registroUtilizacaoAmbienteObservacao;

    @ManyToOne
    @JoinColumn(name = "planejamento_alocacao_id")
    private PlanejamentoAlocacao planejamentoAlocacao;

    @Column(name = "usuario_id_retirada")
    private Long usuarioIdRetirada;

    @Column(name = "usuario_id_devolucao")
    private Long usuarioIdDevolucao;

    @ManyToOne
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente;

    public RegistroUtilizacaoAmbiente() {}

    public Long getRegistroUtilizacaoAmbienteId() {
        return registroUtilizacaoAmbienteId;
    }

    public void setRegistroUtilizacaoAmbienteId(Long registroUtilizacaoAmbienteId) {
        this.registroUtilizacaoAmbienteId = registroUtilizacaoAmbienteId;
    }

    public LocalDateTime getRegistroUtilizacaoAmbienteHoraEntrada() {
        return registroUtilizacaoAmbienteHoraEntrada;
    }

    public void setRegistroUtilizacaoAmbienteHoraEntrada(LocalDateTime registroUtilizacaoAmbienteHoraEntrada) {
        this.registroUtilizacaoAmbienteHoraEntrada = registroUtilizacaoAmbienteHoraEntrada;
    }

    public LocalDateTime getRegistroUtilizacaoAmbienteHoraSaida() {
        return registroUtilizacaoAmbienteHoraSaida;
    }

    public void setRegistroUtilizacaoAmbienteHoraSaida(LocalDateTime registroUtilizacaoAmbienteHoraSaida) {
        this.registroUtilizacaoAmbienteHoraSaida = registroUtilizacaoAmbienteHoraSaida;
    }

    public Integer getRegistroUtilizacaoAmbienteStatus() {
        return registroUtilizacaoAmbienteStatus;
    }

    public void setRegistroUtilizacaoAmbienteStatus(Integer registroUtilizacaoAmbienteStatus) {
        this.registroUtilizacaoAmbienteStatus = registroUtilizacaoAmbienteStatus;
    }

    public String getRegistroUtilizacaoAmbienteObservacao() {
        return registroUtilizacaoAmbienteObservacao;
    }

    public void setRegistroUtilizacaoAmbienteObservacao(String registroUtilizacaoAmbienteObservacao) {
        this.registroUtilizacaoAmbienteObservacao = registroUtilizacaoAmbienteObservacao;
    }

    public PlanejamentoAlocacao getPlanejamentoAlocacao() {
        return planejamentoAlocacao;
    }

    public void setPlanejamentoAlocacao(PlanejamentoAlocacao planejamentoAlocacao) {
        this.planejamentoAlocacao = planejamentoAlocacao;
    }

    public Long getUsuarioIdRetirada() {
        return usuarioIdRetirada;
    }

    public void setUsuarioIdRetirada(Long usuarioIdRetirada) {
        this.usuarioIdRetirada = usuarioIdRetirada;
    }

    public Long getUsuarioIdDevolucao() {
        return usuarioIdDevolucao;
    }

    public void setUsuarioIdDevolucao(Long usuarioIdDevolucao) {
        this.usuarioIdDevolucao = usuarioIdDevolucao;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
}
