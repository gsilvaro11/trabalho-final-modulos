package com.dbc.model;
public class Hoteis {
    private Integer idHotel;
    private Endereco endereco;
    private String nome;

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Hoteis{" +
                "idHotel=" + idHotel +
                ", endereco=" + endereco +
                ", nome='" + nome + '\'' +
                '}';
    }
}

