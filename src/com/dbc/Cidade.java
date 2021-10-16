package com.dbc;

public enum Cidade {
    PORTO_ALEGRE(1),
    SAO_PAULO(2),
    RECIFE(2);

    private Integer numeroIndex;

    Cidade(Integer numeroIndex){
        this.numeroIndex = numeroIndex;
    }

}
