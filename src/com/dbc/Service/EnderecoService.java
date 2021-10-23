package com.dbc.Service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Endereco;
import com.dbc.model.Reserva;
import com.dbc.repository.EnderecoRepository;

import java.util.List;

public class EnderecoService {
    private EnderecoRepository enderecoRepository;
    public EnderecoService(){enderecoRepository = new EnderecoRepository();}

    public void adicionarEndereco(Endereco endereco) {
        try {
            Endereco enderecoAdicionado = enderecoRepository.adicionar(endereco);
            System.out.println("Endereco adicionado com sucesso! " + enderecoAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // remoção
    public void removerEndereco(Integer id) {
        try {
            boolean conseguiuRemover = enderecoRepository.remover(id);
            System.out.println("endereco removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editarEndereco(Integer id, Endereco endereco) {
        try {
            boolean conseguiuEditar = enderecoRepository.editar(id, endereco);
            System.out.println("endereco editado? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listarEndereco() {
        try {
            List<Endereco> listar = enderecoRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}

