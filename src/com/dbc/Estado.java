package com.dbc;

public enum Estado {
    RIO_GRANDE_DO_SUL("Rio Grande do Sul"),
    PERNAMBUCO("Pernambuco"),
    SAO_PAULO("São Paulo");
    private String name;

    Estado(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
