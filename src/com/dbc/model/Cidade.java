package com.dbc.model;

public class Cidade {
    private Integer idCidade;
    private String nome;
    private Estado estado;

    public Integer getId_cidade() {
        return idCidade;
    }

    public void setId_cidade(Integer id_cidade) {
        this.idCidade = id_cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "Cidade{" +
                "id_cidade=" + idCidade +
                ", nome='" + nome + '\'' +
                ", estado=" + estado +
                '}';
    }
}
