package com.dbc.model;
public class Quartos {
    private Integer idQuarto;
    private Hoteis hoteis;
    private Integer numeroQuarto;
    private Number valorDiaria;
    private String descricao;

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Hoteis getHoteis() {
        return hoteis;
    }

    public void setHoteis(Hoteis hoteis) {
        this.hoteis = hoteis;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Number getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Number valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Quartos Nº: " + numeroQuarto +
                ", Valor da diária: R$" + valorDiaria +
                ", Descricão do Quarto: " + descricao +
                ", Índice [" + idQuarto +  "]" ;

    }
}