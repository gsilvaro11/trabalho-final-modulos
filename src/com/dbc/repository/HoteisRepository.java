package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Cidade;
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

            String sql = "INSERT INTO HOTEIS\n" +
                    "(ID_HOTEIS,ID_ENDERECOS, NOME)\n" +
                    "VALUES(?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, hoteis.getIdHotel());
            stmt.setInt(2, hoteis.getEndereco().getId_endereco());
            stmt.setString(3, hoteis.getNome());

//


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
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE HOTEIS SET ");
            sql.append(" id_enderecos = ?,");
            sql.append(" nome = ?");
            sql.append(" WHERE id_hoteis = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, hoteis.getEndereco().getId_endereco());
            stmt.setString(2, hoteis.getNome());
            stmt.setInt(3,id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarHotel.res=" + res);

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
                hoteis.setIdHotel(res.getInt("id_hoteis"));
                hoteis.setNome(res.getString("nome"));
                Endereco endereco = new Endereco();
                endereco.setId_endereco(res.getInt("id_enderecos"));
                hoteis.setEndereco(endereco);
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
    public List<Hoteis> listarHoteisPorCidade(Integer idCidade) throws BancoDeDadosException {
        List<Hoteis> listaDeHoteisPorCidade = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();


            String sql = "SELECT H.ID_HOTEIS,c.NOME_CIDADES, H.ID_ENDERECOS, H.NOME, E.logradouro," +
                    "numero_enderecos, cep FROM HOTEIS H\n" +
                    "\tLEFT JOIN ENDERECOS e ON (H.ID_ENDERECOS = e.ID_ENDERECOS)\n" +
                    "\tLEFT JOIN CIDADES c ON (e.ID_CIDADES = c.ID_CIDADES)\n" +
                    "\tWHERE c.ID_CIDADES = ?\n" +
                    "\tORDER BY H.ID_HOTEIS";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idCidade);
            // Executa-se a consulta


            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Hoteis hoteis = new Hoteis();
                hoteis.setIdHotel(res.getInt("id_hoteis"));
                Endereco endereco = new Endereco();

                endereco.setId_endereco(res.getInt("id_enderecos"));
                endereco.setLogradouro(res.getString("logradouro"));
                endereco.setCep(res.getString("cep"));
                hoteis.setEndereco(endereco);
                hoteis.setNome(res.getString("nome"));
                listaDeHoteisPorCidade.add(hoteis);
            }
            return listaDeHoteisPorCidade;
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
}


