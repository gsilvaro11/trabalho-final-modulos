package com.dbc;

public enum Estado {
    RIO_GRANDE_DO_SUL(1),
    SAO_PAULO(2),
    PERNAMBUCO(3);
    private Integer numeroIndex;

    Estado(Integer numeroIndex){
        this.numeroIndex = numeroIndex;
    }

}
