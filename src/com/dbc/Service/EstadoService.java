package com.dbc.Service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Estado;
import com.dbc.repository.EstadoRepository;

import java.util.List;

public class EstadoService {
    private EstadoRepository estadoRepository;
    public EstadoService(){estadoRepository = new EstadoRepository();}

    public void adicionarEstados(Estado estado) {
        try {
            Estado estadoAdicionado = estadoRepository.adicionar(estado);
            System.out.println("Estado adicionada com sucesso! " + estadoAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // remoção
    public void removerEstados(Integer id) {
        try {
            boolean conseguiuRemover = estadoRepository.remover(id);
            System.out.println("estado removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editarEstados(Integer id, Estado estado) {
        try {
            boolean conseguiuEditar = estadoRepository.editar(id, estado);
            System.out.println("estado editado? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listarEstados() {
        try {
            List<Estado> listar = estadoRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}

