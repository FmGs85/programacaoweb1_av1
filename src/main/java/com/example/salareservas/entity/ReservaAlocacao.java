package com.example.salareservas.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reserva_alocacao")
public class ReservaAlocacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_alocacao_id")
    private Long reservaAlocacaoId;

    @Column(name = "reserva_alocacao_justificativa", length = 300)
    private String reservaAlocacaoJustificativa;

    @Column(name = "reserva_alocacao_data")
    private LocalDate reservaAlocacaoData;

    @Column(name = "reserva_alocacao_hora_inicio")
    private LocalTime reservaAlocacaoHoraInicio;

    @Column(name = "reserva_alocacao_hora_fim")
    private LocalTime reservaAlocacaoHoraFim;

    @Column(name = "reserva_alocacao_status")
    private Integer reservaAlocacaoStatus;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public ReservaAlocacao() {}


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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}