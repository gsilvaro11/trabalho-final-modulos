package com.dbc;

import java.util.Map;

public class Hoteis {
    private Estado estado;
    private Cidade cidade;
    private String hoteis;
    private Integer quartosDisp;
    private String diferencial;

    Hoteis(){};
    public Hoteis(Estado estado, Cidade cidade, String hoteis, Integer quartosDisp, String diferencial) {
        this.estado = estado;
        this.cidade = cidade;
        this.hoteis = hoteis;
        this.quartosDisp = quartosDisp;
        this.diferencial = diferencial;
    }

    public Estado getEstado() {
        return estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public String getHoteis() {
        return hoteis;
    }

    public Integer getQuartosDisp() {
        return quartosDisp;
    }

    public String getDiferencial() {
        return diferencial;
    }

    @Override
    public String toString() {
        return "Hoteis{" +
                "estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", hoteis='" + hoteis + '\'' +
                ", quartosDisp=" + quartosDisp +
                ", diferencial='" + diferencial + '\'' +
                '}';
    }
}
