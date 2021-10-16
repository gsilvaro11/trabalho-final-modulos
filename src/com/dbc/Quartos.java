package com.dbc;

public class Quartos extends Hoteis{
    private String nome;
    private int qtdCamas;
    private boolean tv;
    private double valor;

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdCamas() {
        return qtdCamas;
    }

    public void setQtdCamas(int qtdCamas) {
        this.qtdCamas = qtdCamas;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public void imprimir() {

    }
}
