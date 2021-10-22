package com.dbc.repository;

import com.dbc.Usuario;
import com.dbc.exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UsuarioRepository implements Repositorio<Integer, Usuario>{

    private UsuarioRepository usuarioRepository;

    public UsuarioRepository(){
        this.usuarioRepository = new UsuarioRepository();
    }

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Usuario adicionar(Usuario object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Usuario usuario) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Usuario> listar() throws BancoDeDadosException {
        return null;
    }
}
