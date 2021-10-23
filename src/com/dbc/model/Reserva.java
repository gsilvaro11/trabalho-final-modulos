package com.dbc.model;

import java.time.LocalDate;

public class Reserva {
    private Integer idReserva;
    private Hoteis hoteis;
    private Quartos quartos;
    private Usuario usuario;
    private LocalDate dataReserva;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
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

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    @Override
    public String toString() {
        return
                "Reserva - " + idReserva +
                ", hoteis=" +  hoteis +
                ", quartos=" + quartos +
                ", usuario=" + usuario +
                ", dataReserva=" + dataReserva +
                '}';
    }
}
