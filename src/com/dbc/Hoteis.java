package com.dbc;

import java.util.ArrayList;
import java.util.Arrays;

public class Hoteis implements Impressao{
    private ArrayList<Estado> estados;
    private Cidade[][] cidades;
    private String[][][] hoteis;
    private Integer[][][] numeroQuarto;
    private String[][][] descricao;
    private Double[][][] valorQuarto;

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

    public Cidade[][] getCidades() {
        return cidades;
    }

    public void setCidades(Cidade[][] cidades) {
        this.cidades = cidades;
    }

    public String[][][] getHoteis() {
        return hoteis;
    }

    public void setHoteis(String[][][] hoteis) {
        this.hoteis = hoteis;
    }

    public Integer[][][] getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer[][][] numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String[][][] getDescricao() {
        return descricao;
    }

    public void setDescricao(String[][][] descricao) {
        this.descricao = descricao;
    }

    public Double[][][] getValorQuarto() {
        return valorQuarto;
    }

    public void setValorQuarto(Double[][][] valorQuarto) {
        this.valorQuarto = valorQuarto;
    }

    @Override
    public void imprime() {
        System.out.println("\n=============================");
        System.out.println("Indice      Estado");
        for(int i = 0; i < getEstados().size(); i++){
            System.out.println(i + "           " + getEstados().get(i).getName());
        }
        System.out.println("=============================\n");
    }

    public void imprime(Integer index) {
        System.out.println("\n=============================");
        System.out.println("Cidades do " + getEstados().get(index).getName() + ":");
        System.out.println("Index   Estado");
        for (int i = 0; i < getCidades()[index].length; i++) {
            System.out.println(i + "       " +getCidades()[index][i].getName());
        }
        System.out.println("=============================\n");
    }

    public void imprime(Integer indexEstado, Integer indexCidade) {
        System.out.println("\n=============================");
        System.out.println("Hoteis da cidade " + getCidades()[indexEstado][indexCidade] + ":");
        System.out.println("Index     Hoteis");
        for (int i = 0; i < getHoteis()[indexEstado][indexCidade].length; i++){
            System.out.println(i + "         " + getHoteis()[indexEstado][indexCidade][i]);
        }
        System.out.println("=============================\n");
    }

    public void imprimeQuartos(Integer indexEstado, Integer indexCidade, Integer indexHotel) {
        System.out.println("\n=============================");
        System.out.println("Hotel " + getHoteis()[indexEstado][indexCidade][indexHotel] +  ":");
        for (int i = 0; i < getNumeroQuarto()[indexCidade][indexHotel].length; i++){
            System.out.printf("%s quarto:\n", i);
            System.out.println("Numero quarto: " + getNumeroQuarto()[indexCidade][indexHotel][i]);
            System.out.println("Descrição: " + getDescricao()[indexCidade][indexHotel][i]);
            System.out.println("Valor: " + getValorQuarto()[indexCidade][indexHotel][i]  + "\n");

        }
        System.out.println("=============================\n");
    }

}
