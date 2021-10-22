package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Endereco;
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
            hoteis.setIdHotel(proximoId);

            String sql = "INSERT INTO HOTEL\n" +
                    "(ID_HOTEL,ID_ENDERECO, NOME)\n" +
                    "VALUES(?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, hoteis.getIdHotel());
            stmt.setInt(2, hoteis.getEndereco().getId_endereco());
            stmt.setString(3, hoteis.getNome());


            int res = stmt.executeUpdate();
            System.out.println("Hotel foi adicionado com sucesso :" + res);
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
                hoteis.setIdHotel(res.getInt("id_hotel"));
                Endereco endereco = new Endereco();
                endereco.setId_endereco(res.getInt("id_endereco"));
                hoteis.setEndereco(endereco);
                hoteis.setNome(res.getString("nome"));
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

