package com.dbc;

public class Reserva implements Imprimir{
    Usuario usuario;
    Hoteis hoteis;
    Quartos quartos;
    private String data;

    @Override
    public void imprimir() {
        System.out.println(usuario.getNome()+hoteis.getNome()+quartos.getNome()+quartos.getValor()+data);

    }
}
