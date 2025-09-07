package com.example.salareservas.dto.response;

public class SalaResponseDTO {
    private Long id;
    private String bloco;
    private Integer capacidade;
    private String nome;


    public SalaResponseDTO() {}

    public SalaResponseDTO(Long id, String bloco, Integer capacidade, String nome) {
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
}