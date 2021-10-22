package com.dbc.model;
public class Estado {
    private Integer idEstado;
    private String nome;

    public Integer getId_estado() {
        return idEstado;
    }

    public void setId_estado(Integer id_estado) {
        this.idEstado = id_estado;
    }

    public String getNome_estado() {
        return nome;
    }

    public void setNome_estado(String nome_estado) {
        this.nome = nome_estado;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id_estado=" + idEstado +
                ", nome_estado='" + nome + '\'' +
                '}';
    }
}
