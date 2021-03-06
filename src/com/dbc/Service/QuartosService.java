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

    public void listarQuartosPorHotel(Integer idHotel){
        try {
            List<Quartos> listar = quartosRepository.listarQuartosPorHotel(idHotel);
            listar.forEach(System.out::println);
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    public  Quartos getQuartoPorId(Integer id){
        try {
            return quartosRepository.getQuartoPorId(id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removerQuartoPorHotel(Integer indexHotel) {
        try {
            boolean conseguiuRemover = quartosRepository.removerPorHotel(indexHotel);
//            System.out.println("quarto removido? " + conseguiuRemover + "| com id=" + indexHotel);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
