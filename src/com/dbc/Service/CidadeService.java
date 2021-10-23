package com.dbc.Service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Cidade;
import com.dbc.repository.CidadeRepository;

import java.util.List;

public class CidadeService {
    private CidadeRepository cidadeRepository;
    public CidadeService(){cidadeRepository = new CidadeRepository();}

// criação de um objeto
    public void adicionarCidade(Cidade cidade) {
        try {
            Cidade cidadeAdicionada = cidadeRepository.adicionar(cidade);
            System.out.println("cidade adicionada com sucesso! " + cidadeAdicionada);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // remoção
    public void removerCidade(Integer id) {
        try {
            boolean conseguiuRemover = cidadeRepository.remover(id);
            System.out.println("cidade removida? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editarCidade(Integer id, Cidade cidade) {
        try {
            boolean conseguiuEditar = cidadeRepository.editar(id, cidade);
            System.out.println("cidade editada? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listarCidades() {
        try {
            List<Cidade> listar = cidadeRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
    public void listarCidadesPorEstado(Integer idEstado) {
        try {
            cidadeRepository.listarPorEstado(idEstado).forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}


