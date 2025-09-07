package com.example.salareservas.dto.request;

public class SalaRequestDTO {

    private String bloco;
    private Integer capacidade;
    private String nome;


    public SalaRequestDTO() {}

    public SalaRequestDTO(String bloco, Integer capacidade, String nome) {
        this.bloco = bloco;
        this.capacidade = capacidade;
        this.nome = nome;
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