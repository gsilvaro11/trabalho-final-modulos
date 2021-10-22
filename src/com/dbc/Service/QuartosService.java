package com.dbc.Service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Quartos;
import com.dbc.repository.QuartosRepository;

import java.util.List;

public class QuartosService {
    private QuartosRepository quartosRepository;

    public QuartosService(){quartosRepository = new QuartosRepository();}

    //Criação de um objeto

    public void listarQuartos(){
        try {
            List<Quartos> listar = quartosRepository.listar();
            listar.forEach(System.out::println);
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    public void listarQuartosPorHotel(Integer numeroHotel){
        try {
            List<Quartos> listar = quartosRepository.listarQuartosPorHotel(numeroHotel);
            listar.forEach(System.out::println);
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

}
