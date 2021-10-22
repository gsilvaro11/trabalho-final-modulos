package com.dbc.model;
public class Hoteis {
    private Integer id_hotel;
    private String nome_hotel;
    private Endereco endereco;

    public Integer getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Integer id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getNome_hotel() {
        return nome_hotel;
    }

    public void setNome_hotel(String nome_hotel) {
        this.nome_hotel = nome_hotel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Hoteis{" +
                "id_hotel=" + id_hotel +
                ", nome_hotel='" + nome_hotel + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
