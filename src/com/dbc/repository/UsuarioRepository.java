package com.dbc.repository;

import com.dbc.Usuario;
import com.dbc.exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UsuarioRepository implements Repositorio<Integer, Usuario>{

    private UsuarioRepository usuarioRepository;

    public UsuarioRepository(){
        this.usuarioRepository = new UsuarioRepository();
    }

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
        Connection con = null;
        try{
            con = ConexaoBancoDeDados.getConnection();
            Integer proximoId = this.getProximoId(con);
            usuario.setId_Usuario(proxmoId);

            String sql = "INSERT INTO PESSOA"
        } catch ()
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
