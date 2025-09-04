package com.example.salareservas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "dias_sem_alocacao")
public class DiasSemAlocacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dias_sem_alocacao_id")
    private Long diasSemAlocacaoId;

    @Column(name = "dias_sem_alocacao_data")
    private LocalDate diasSemAlocacaoData;

    @Column(name = "dias_sem_alocacao_dia_semana")
    private Integer diasSemAlocacaoDiaSemana;

    @Column(name = "dias_sem_alocacao_horario_inicio")
    private LocalTime diasSemAlocacaoHorarioInicio;

    @Column(name = "dias_sem_alocacao_horario_fim")
    private LocalTime diasSemAlocacaoHorarioFim;

    @Column(name = "dias_sem_alocacao_status")
    private Integer diasSemAlocacaoStatus;

    @ManyToOne
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente;

    public DiasSemAlocacao(){}

    public Long getDiasSemAlocacaoId() {
        return diasSemAlocacaoId;
    }

    public void setDiasSemAlocacaoId(Long diasSemAlocacaoId) {
        this.diasSemAlocacaoId = diasSemAlocacaoId;
    }

    public LocalDate getDiasSemAlocacaoData() {
        return diasSemAlocacaoData;
    }

    public void setDiasSemAlocacaoData(LocalDate diasSemAlocacaoData) {
        this.diasSemAlocacaoData = diasSemAlocacaoData;
    }

    public Integer getDiasSemAlocacaoDiaSemana() {
        return diasSemAlocacaoDiaSemana;
    }

    public void setDiasSemAlocacaoDiaSemana(Integer diasSemAlocacaoDiaSemana) {
        this.diasSemAlocacaoDiaSemana = diasSemAlocacaoDiaSemana;
    }

    public LocalTime getDiasSemAlocacaoHorarioInicio() {
        return diasSemAlocacaoHorarioInicio;
    }

    public void setDiasSemAlocacaoHorarioInicio(LocalTime diasSemAlocacaoHorarioInicio) {
        this.diasSemAlocacaoHorarioInicio = diasSemAlocacaoHorarioInicio;
    }

    public LocalTime getDiasSemAlocacaoHorarioFim() {
        return diasSemAlocacaoHorarioFim;
    }

    public void setDiasSemAlocacaoHorarioFim(LocalTime diasSemAlocacaoHorarioFim) {
        this.diasSemAlocacaoHorarioFim = diasSemAlocacaoHorarioFim;
    }

    public Integer getDiasSemAlocacaoStatus() {
        return diasSemAlocacaoStatus;
    }

    public void setDiasSemAlocacaoStatus(Integer diasSemAlocacaoStatus) {
        this.diasSemAlocacaoStatus = diasSemAlocacaoStatus;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
}
