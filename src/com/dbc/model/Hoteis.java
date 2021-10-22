package com.dbc.model;
public class Hoteis {
    private Integer id_hotel;
    private Cidade cidade;
    private String nome_hotel;
    private String endereco;
    private Integer numero_hotel;

    public Integer getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Integer id_hotel) {
        this.id_hotel = id_hotel;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNome_hotel() {
        return nome_hotel;
    }

    public void setNome_hotel(String nome_hotel) {
        this.nome_hotel = nome_hotel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero_hotel() {
        return numero_hotel;
    }

    public void setNumero_hotel(Integer numero_hotel) {
        this.numero_hotel = numero_hotel;
    }

    @Override
    public String toString() {
        return "Hoteis{" +
                "id_hotel=" + id_hotel +
                ", cidade=" + cidade +
                ", nome_hotel='" + nome_hotel + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero_hotel=" + numero_hotel +
                '}';
    }
}


