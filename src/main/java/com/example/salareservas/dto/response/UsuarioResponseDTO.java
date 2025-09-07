package com.example.salareservas.dto.response;

import java.time.LocalDateTime;

public class UsuarioResponseDTO {
    private Long usuarioId;
    private String usuarioNome;
    private String usuarioMatricula;
    private Integer usuarioTipo;
    private Integer usuarioStatus;
    private LocalDateTime usuarioLogDataCriacao;


    public UsuarioResponseDTO() {}

    public UsuarioResponseDTO(Long usuarioId, String usuarioNome, String usuarioMatricula,
                              Integer usuarioTipo, Integer usuarioStatus, LocalDateTime usuarioLogDataCriacao) {
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
}