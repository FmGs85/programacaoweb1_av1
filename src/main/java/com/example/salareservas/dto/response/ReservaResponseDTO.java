package com.example.salareservas.dto.response;

import java.time.LocalDateTime;

public class ReservaResponseDTO {
    private Long id;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String reservadoPara;
    private LocalDateTime tempo;
    private SalaResponseDTO sala;
    private UsuarioResponseDTO usuario;


    public ReservaResponseDTO() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public String getReservadoPara() {
        return reservadoPara;
    }

    public void setReservadoPara(String reservadoPara) {
        this.reservadoPara = reservadoPara;
    }

    public LocalDateTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }

    public SalaResponseDTO getSala() {
        return sala;
    }

    public void setSala(SalaResponseDTO sala) {
        this.sala = sala;
    }

    public UsuarioResponseDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponseDTO usuario) {
        this.usuario = usuario;
    }
}