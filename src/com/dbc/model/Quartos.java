package com.dbc.model;
public class Quartos {
    private Integer id_quarto;
    private Hoteis hoteis;
    private Integer numero_quarto;
    private Number valor_diaria;

    public Integer getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(Integer id_quarto) {
        this.id_quarto = id_quarto;
    }

    public Hoteis getHoteis() {
        return hoteis;
    }

    public void setHoteis(Hoteis hoteis) {
        this.hoteis = hoteis;
    }

    public Integer getNumero_quarto() {
        return numero_quarto;
    }

    public void setNumero_quarto(Integer numero_quarto) {
        this.numero_quarto = numero_quarto;
    }

    public Number getValor_diaria() {
        return valor_diaria;
    }

    public void setValor_diaria(Number valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    @Override
    public String toString() {
        return "Quartos{" +
                "id_quarto=" + id_quarto +
                ", hoteis=" + hoteis +
                ", numero_quarto=" + numero_quarto +
                ", valor_diaria=" + valor_diaria +
                '}';
    }
}
