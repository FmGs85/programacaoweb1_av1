package com.example.salareservas.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String bloco;

    private Integer capacidade;

    @Column(length = 25)
    private String nome;

    @OneToMany(mappedBy = "sala")
    private List<Reserva> reservas;

    public Sala() {}

    public Sala(Long id, String bloco, Integer capacidade, String nome){
        this.id = id;
        this.bloco = bloco;
        this.capacidade = capacidade;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
