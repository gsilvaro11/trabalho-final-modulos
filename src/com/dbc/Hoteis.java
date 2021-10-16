package com.dbc;

import java.util.ArrayList;
import java.util.Map;

public class Hoteis {
    private ArrayList<String> estados;
    private String[][] cidades;
    private String[][][] hoteis;




    public void imprimeEstado(){
        System.out.println("Estado          Indice");
        for(int i = 0; i < getEstados().size(); i++){
            System.out.println(getEstados().get(i) + " " + "                " + i);
        }
    }

    public void imprimeCidade(Integer index){
        System.out.println("Cidades do " + getEstados().get(index));
        for (int i = 0; i < getCidades()[index].length; i++) {
            System.out.println(getCidades()[index][i]);
        }
    }

    public void imprimeHoteis(Integer indexEstado, Integer indexCidade){
        System.out.println("Hoteis da cidade:  " + getCidades()[indexEstado][indexCidade]);
        for (int i = 0; i < getHoteis()[indexEstado][indexCidade].length; i++){
            System.out.println(getHoteis()[indexEstado][indexCidade][i]);
        }
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

    public String[][] getCidades() {
        return cidades;
    }

    public void setCidades(String[][] cidades) {
        this.cidades = cidades;
    }

    public String[][][] getHoteis() {
        return hoteis;
    }

    public void setHoteis(String[][][] hoteis) {
        this.hoteis = hoteis;
    }
}
