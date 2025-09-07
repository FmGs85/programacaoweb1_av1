package com.example.salareservas.dto.request;

public class AmbienteRequestDTO {

    private String ambienteDescricao;
    private Integer ambienteAndar;
    private String ambienteTipo;
    private Integer ambienteNumeroPcs;
    private Integer ambienteCapacidade;
    private Integer ambienteStatus;


    public AmbienteRequestDTO() {}


    public String getAmbienteDescricao() {
        return ambienteDescricao;
    }

    public void setAmbienteDescricao(String ambienteDescricao) {
        this.ambienteDescricao = ambienteDescricao;
    }

    public Integer getAmbienteAndar() {
        return ambienteAndar;
    }

    public void setAmbienteAndar(Integer ambienteAndar) {
        this.ambienteAndar = ambienteAndar;
    }

    public String getAmbienteTipo() {
        return ambienteTipo;
    }

    public void setAmbienteTipo(String ambienteTipo) {
        this.ambienteTipo = ambienteTipo;
    }

    public Integer getAmbienteNumeroPcs() {
        return ambienteNumeroPcs;
    }

    public void setAmbienteNumeroPcs(Integer ambienteNumeroPcs) {
        this.ambienteNumeroPcs = ambienteNumeroPcs;
    }

    public Integer getAmbienteCapacidade() {
        return ambienteCapacidade;
    }

    public void setAmbienteCapacidade(Integer ambienteCapacidade) {
        this.ambienteCapacidade = ambienteCapacidade;
    }

    public Integer getAmbienteStatus() {
        return ambienteStatus;
    }

    public void setAmbienteStatus(Integer ambienteStatus) {
        this.ambienteStatus = ambienteStatus;
    }
}
