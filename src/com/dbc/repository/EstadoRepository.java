package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Estado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstadoRepository  implements Repositorio<Integer, Estado>{
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Estado adicionar(Estado object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Estado estado) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Estado> listar() throws BancoDeDadosException {
        List<Estado> listaDeEstados = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM ESTADOS";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Estado estado = new Estado();
                estado.setIdEstado(res.getInt("id_estados"));
                estado.setNome(res.getString("nome_estados"));
                listaDeEstados.add(estado);
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
        return listaDeEstados;
    }
}