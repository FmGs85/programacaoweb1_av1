package com.example.salareservas.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ambiente")
public class Ambiente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ambiente_id")
    private Long ambienteId;

    @Column(name = "ambiente_descricao", length = 45)
    private String ambienteDescricao;

    @Column(name = "ambiente_andar")
    private Integer ambienteAndar;

    @Column(name = "ambiente_tipo", length = 45)
    private String ambienteTipo;

    @Column(name = "ambiente_numero_pcs")
    private Integer ambienteNumeroPcs;

    @Column(name = "ambiente_capacidade")
    private Integer ambienteCapacidade;

    @Column(name = "ambiente_status")
    private Integer ambienteStatus;

    @OneToMany(mappedBy = "ambiente")
    private List<DiasSemAlocacao> diasSemAlocacao;

    @OneToMany(mappedBy = "ambiente")
    private List<PlanejamentoAlocacao> planejamentoAlocacoes;

    @OneToMany(mappedBy = "ambiente")
    private List<RegistroUtilizacaoAmbiente>registroUtilizacoes;

    public Ambiente() {}

    public Long getAmbienteId() {
        return ambienteId;
    }

    public void setAmbienteId(Long ambienteId) {
        this.ambienteId = ambienteId;
    }

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

    public List<DiasSemAlocacao> getDiasSemAlocacao() {
        return diasSemAlocacao;
    }

    public void setDiasSemAlocacao(List<DiasSemAlocacao> diasSemAlocacao) {
        this.diasSemAlocacao = diasSemAlocacao;
    }

    public List<PlanejamentoAlocacao> getPlanejamentoAlocacoes() {
        return planejamentoAlocacoes;
    }

    public void setPlanejamentoAlocacoes(List<PlanejamentoAlocacao> planejamentoAlocacoes) {
        this.planejamentoAlocacoes = planejamentoAlocacoes;
    }

    public List<RegistroUtilizacaoAmbiente> getRegistroUtilizacoes() {
        return registroUtilizacoes;
    }

    public void setRegistroUtilizacoes(List<RegistroUtilizacaoAmbiente> registroUtilizacoes) {
        this.registroUtilizacoes = registroUtilizacoes;
    }
}
