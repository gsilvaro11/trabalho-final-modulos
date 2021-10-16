package com.dbc;

public enum Estado {
    SAO_PAULO(1),
    PERNAMBUCO(2);

    private Integer index;

    Estado(Integer index){
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }



}
