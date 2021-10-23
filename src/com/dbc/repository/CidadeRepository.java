package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Cidade;
import com.dbc.model.Estado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CidadeRepository implements Repositorio<Integer, Cidade>{
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Cidade adicionar(Cidade object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Cidade cidade) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Cidade> listar() throws BancoDeDadosException {
        List<Cidade> listaDeCidades = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM CIDADES";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(res.getInt("id_cidades"));
                cidade.setNome(res.getString("nome_cidades"));
                listaDeCidades.add(cidade);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaDeCidades;
    }
    public List<Cidade> listarPorEstado(Integer idEstado) throws BancoDeDadosException {
        List<Cidade> listaDeCidadesPorEstado = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
//            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM CIDADES WHERE ID_ESTADOS = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idEstado);

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Cidade cidade = new Cidade();
                Estado estado = new Estado();
                cidade.setIdCidade(res.getInt("id_cidades"));
                cidade.setNome(res.getString("nome_cidades"));
                estado.setIdEstado(idEstado);
                cidade.setEstado(estado);
                listaDeCidadesPorEstado.add(cidade);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaDeCidadesPorEstado;
    }
}

