package com.dbc.model;

import java.time.LocalDate;

public class Reserva {
    private Integer id_reserva;
    private Hoteis hoteis;
    private Quartos quartos;
    private Usuario usuario;
    private LocalDate data_reserva;

    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Hoteis getHoteis() {
        return hoteis;
    }

    public void setHoteis(Hoteis hoteis) {
        this.hoteis = hoteis;
    }

    public Quartos getQuartos() {
        return quartos;
    }

    public void setQuartos(Quartos quartos) {
        this.quartos = quartos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(LocalDate data_reserva) {
        this.data_reserva = data_reserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id_reserva=" + id_reserva +
                ", hoteis=" + hoteis +
                ", quartos=" + quartos +
                ", usuario=" + usuario +
                ", data_reserva=" + data_reserva +
                '}';
    }
}
