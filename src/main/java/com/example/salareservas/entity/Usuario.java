package com.example.salareservas.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "usuario_nome", length = 300)
    private String usuarioNome;

    @Column(name =  "usuario_matricula", length = 45)
    private String usuarioMatricula;

    @Column(name = "usuario_tipo")
    private Integer usuarioTipo;

    @Column(name = "usuario_status")
    private Integer usuarioStatus;

    @Column(name = "usuario_log_data_criacao")
    private LocalDateTime usuarioLogDataCriacao;

    @Column(name = "usuario_log_responsavel_id")
    private Long usuarioLogResponsavelId;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "usuario")
    private List<ReservaAlocacao> reservaAlocacoes;

    @OneToMany(mappedBy = "usuario")
    private List<PlanejamentoAlocacao> planejamentoAlocacoes;


    public Usuario(){}

    public Usuario(Long usuarioId, String usuarioNome, String usuarioMatricula, Integer usuarioTipo, Integer usuarioStatus, LocalDateTime usuarioLogDataCriacao){
        this.usuarioId = usuarioId;
        this.usuarioNome = usuarioNome;
        this.usuarioMatricula = usuarioMatricula;
        this.usuarioTipo = usuarioTipo;
        this.usuarioStatus = usuarioStatus;
        this.usuarioLogDataCriacao = usuarioLogDataCriacao;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioMatricula() {
        return usuarioMatricula;
    }

    public void setUsuarioMatricula(String usuarioMatricula) {
        this.usuarioMatricula = usuarioMatricula;
    }

    public Integer getUsuarioTipo() {
        return usuarioTipo;
    }

    public void setUsuarioTipo(Integer usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }

    public Integer getUsuarioStatus() {
        return usuarioStatus;
    }

    public void setUsuarioStatus(Integer usuarioStatus) {
        this.usuarioStatus = usuarioStatus;
    }

    public LocalDateTime getUsuarioLogDataCriacao() {
        return usuarioLogDataCriacao;
    }

    public void setUsuarioLogDataCriacao(LocalDateTime usuarioLogDataCriacao) {
        this.usuarioLogDataCriacao = usuarioLogDataCriacao;
    }

    public Long getUsuarioLogResponsavelId() {
        return usuarioLogResponsavelId;
    }

    public void setUsuarioLogResponsavelId(Long usuarioLogResponsavelId) {
        this.usuarioLogResponsavelId = usuarioLogResponsavelId;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<ReservaAlocacao> getReservaAlocacoes() {
        return reservaAlocacoes;
    }

    public void setReservaAlocacoes(List<ReservaAlocacao> reservaAlocacoes) {
        this.reservaAlocacoes = reservaAlocacoes;
    }

    public List<PlanejamentoAlocacao> getPlanejamentoAlocacoes() {
        return planejamentoAlocacoes;
    }

    public void setPlanejamentoAlocacoes(List<PlanejamentoAlocacao> planejamentoAlocacoes) {
        this.planejamentoAlocacoes = planejamentoAlocacoes;
    }
}
