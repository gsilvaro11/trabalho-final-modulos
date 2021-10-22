package com.dbc.model;
public class Estado {
    private Integer id_estado;
    private String nome_estado;

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public String getNome_estado() {
        return nome_estado;
    }

    public void setNome_estado(String nome_estado) {
        this.nome_estado = nome_estado;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id_estado=" + id_estado +
                ", nome_estado='" + nome_estado + '\'' +
                '}';
    }
}
