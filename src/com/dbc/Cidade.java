package com.dbc;

public enum Cidade {
    SAO_PAULO(1),
    RECIFE(2);

    private Integer nome;

    Cidade(Integer nome){
        this.nome = nome;
    }

    public Integer getNome() {
        return nome;
    }


}
