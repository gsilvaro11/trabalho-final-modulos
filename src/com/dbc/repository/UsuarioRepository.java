package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Usuario;

import java.sql.*;
import java.util.List;

public class UsuarioRepository implements Repositorio<Integer, Usuario>{



    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_usuario.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if(res.next()){
            return res.getInt("mysequence");
        }
        return null;
    }

    @Override
    public Usuario adicionar(Usuario usuario) throws BancoDeDadosException {
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
