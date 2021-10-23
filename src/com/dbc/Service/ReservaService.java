package com.dbc.Service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Reserva;
import com.dbc.repository.ReservaRepository;

import java.util.List;

public class ReservaService {
    private ReservaRepository reservaRepository;
    public ReservaService(){reservaRepository = new ReservaRepository();}


    public void adicionarReserva(Reserva reserva) {
        try {
            Reserva reservaAdicionada = reservaRepository.adicionar(reserva);
            System.out.println("reserva adicinada com sucesso! " + reservaAdicionada);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // remoção
    public void removerReserva(Integer id) {
        try {
            boolean conseguiuRemover = reservaRepository.remover(id);
            System.out.println("reserva removida? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editarReserva(Integer id, Reserva reserva) {
        try {
            boolean conseguiuEditar = reservaRepository.editar(id, reserva);
            System.out.println("reserva editada? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listarReserva() {
        try {
            List<Reserva> listar = reservaRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
