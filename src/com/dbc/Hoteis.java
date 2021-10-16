package com.dbc;

public abstract class Hoteis implements Imprimir {
    private String estado;
    private String cidade;
    private String nome;
    private int quartosDisp;
    private String diferencial;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuartosDisp() {
        return quartosDisp;
    }

    public void setQuartosDisp(int quartosDisp) {
        this.quartosDisp = quartosDisp;
    }

    public String getDiferencial() {
        return diferencial;
    }

    public void setDiferencial(String diferencial) {
        this.diferencial = diferencial;
    }
}
