package com.dbc.Service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Hoteis;
import com.dbc.repository.HoteisRepository;

import java.util.List;

public class HoteisService {
    private HoteisRepository hoteisRepository;

    public HoteisService() {
        hoteisRepository = new HoteisRepository();
    }

    public void adicionar(Hoteis hoteis) {
        try {
            Hoteis hotelAdicionado = hoteisRepository.adicionar(hoteis);
            System.out.println("Hotel adicionado com sucesso! " + hotelAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // remoção
    public void removerPessoa(Integer id) {
        try {
            boolean conseguiuRemover = hoteisRepository.remover(id);
            System.out.println("hotel removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editarPessoa(Integer id, Hoteis pessoa) {
        try {
            boolean conseguiuEditar = hoteisRepository.editar(id, pessoa);
            System.out.println("pessoa editada? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listarHoteis() {
        try {
            List<Hoteis> listar = hoteisRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarHoteisPorCidade(Integer idCidade) {
        try {
            hoteisRepository.listarHoteisPorCidade(idCidade).forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

}

