package com.dbc.model;
public class Hoteis {
    private Integer idHotel;
    private Endereco endereco;
    private String nome;

    public Integer getId_hotel() {
        return idHotel;
    }

    public void setId_hotel(Integer id_hotel) {
        this.idHotel = id_hotel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome_hotel() {
        return nome;
    }

    public void setNome_hotel(String nome_hotel) {
        this.nome = nome_hotel;
    }

    @Override
    public String toString() {
        return "Hoteis{" +
                "id_hotel=" + idHotel +
                ", endereco=" + endereco +
                ", nome_hotel='" + nome + '\'' +
                '}';
    }
}

