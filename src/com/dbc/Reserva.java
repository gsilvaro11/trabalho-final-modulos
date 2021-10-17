package com.dbc;

import java.util.ArrayList;

public class Reserva implements Impressao{
    private ArrayList<String> listaEstado;
    private ArrayList<String> listaCidade;
    private ArrayList<String> listaHotel;
    private ArrayList<Integer> listaQuarto;
    private ArrayList<Double> listaValor;

    public ArrayList<String> getListaEstado() {
        return listaEstado;
    }

    public void setListaEstado(ArrayList<String> listaEstado) {
        this.listaEstado = listaEstado;
    }

    public ArrayList<String> getListaCidade() {
        return listaCidade;
    }

    public void setListaCidade(ArrayList<String> listaCidade) {
        this.listaCidade = listaCidade;
    }

    public ArrayList<String> getListaHotel() {
        return listaHotel;
    }

    public void setListaHotel(ArrayList<String> listaHotel) {
        this.listaHotel = listaHotel;
    }

    public ArrayList<Integer> getListaQuarto() {
        return listaQuarto;
    }

    public void setListaQuarto(ArrayList<Integer> listaQuarto) {
        this.listaQuarto = listaQuarto;
    }

    public ArrayList<Double> getListaValor() {
        return listaValor;
    }

    public void setListaValor(ArrayList<Double> listaValor) {
        this.listaValor = listaValor;
    }


    @Override
    public void imprime() {
        System.out.println(getListaEstado().size());
    }
}
