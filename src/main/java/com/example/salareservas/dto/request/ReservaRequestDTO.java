package com.example.salareservas.dto.request;

import java.time.LocalDateTime;

public class ReservaRequestDTO {

    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String reservadoPara;
    private Long salaId;
    private Long usuarioId;

    // Construtores
    public ReservaRequestDTO() {}

    public ReservaRequestDTO(LocalDateTime inicio, LocalDateTime fim,
                             String reservadoPara, Long salaId, Long usuarioId) {
        this.inicio = inicio;
        this.fim = fim;
        this.reservadoPara = reservadoPara;
        this.salaId = salaId;
        this.usuarioId = usuarioId;
    }

    // Getters e Setters
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

    public Long getSalaId() {
        return salaId;
    }

    public void setSalaId(Long salaId) {
        this.salaId = salaId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}