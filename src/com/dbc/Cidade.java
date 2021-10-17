package com.dbc;

public enum Cidade {
    PORTO_ALEGRE("Porto Alegre"),
    GRAMADO("Gramado"),
    RECIFE("Recife"),
    OLINDA("Olinda"),
    GUARATINGUETA("Guaratinguetá"),
    SAO_PAULO("São paulo");

    private String name;

    Cidade(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
