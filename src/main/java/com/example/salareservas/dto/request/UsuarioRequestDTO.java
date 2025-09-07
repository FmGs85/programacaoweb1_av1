package com.example.salareservas.dto.request;

public class UsuarioRequestDTO {

    private String usuarioNome;
    private String usuarioMatricula;
    private Integer usuarioTipo;
    private Integer usuarioStatus;


    public UsuarioRequestDTO() {}

    public UsuarioRequestDTO(String usuarioNome, String usuarioMatricula,
                             Integer usuarioTipo, Integer usuarioStatus) {
        this.usuarioNome = usuarioNome;
        this.usuarioMatricula = usuarioMatricula;
        this.usuarioTipo = usuarioTipo;
        this.usuarioStatus = usuarioStatus;
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
}