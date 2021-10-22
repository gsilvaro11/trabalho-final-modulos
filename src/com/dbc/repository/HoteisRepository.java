package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Hoteis;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoteisRepository implements Repositorio<Integer , Hoteis> {


    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_hoteis.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Hoteis adicionar(Hoteis hoteis) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            hoteis.setId_hotel(proximoId);

            String sql = "INSERT INTO HOTEL\n" +
                    "(ID_HOTEL,ID_CIDADES, NOME, ENDERECO, NUMERO_HOTEL)\n" +
                    "VALUES(?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, hoteis.getId_hotel());
            stmt.setInt(2, hoteis.getCidade().getId_cidade());
            stmt.setString(3, hoteis.getNome_hotel());
            stmt.setString(4, hoteis.getEndereco());
            stmt.setInt(5 , hoteis.getNumero_hotel());

            int res = stmt.executeUpdate();
            System.out.println("Hotel foi adicionado com sucesso :" + hoteis.getNome_hotel());
            return hoteis;
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
    }


    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM HOTEIS WHERE id_hoteis = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerHotelPorId.res=" + res);

            return res > 0;
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
    }

    @Override
    public boolean editar(Integer id, Hoteis hoteis) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Hoteis> listar() throws BancoDeDadosException {
        List<Hoteis> listaDeHoteis = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM HOTEIS";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Hoteis hoteis = new Hoteis();
                hoteis.setId_hotel(res.getInt("id_hotel"));
                hoteis.setCidade();

                hoteis.setNome_hotel(res.getString("nome"));
                listaDeHoteis.add(hoteis);
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
        return listaDeHoteis;
    }
    }

