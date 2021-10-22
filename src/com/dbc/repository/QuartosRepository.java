package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Hoteis;
import com.dbc.model.Quartos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuartosRepository implements Repositorio<Integer, Quartos>{
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_quartos.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if(res.next()){
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Quartos adicionar(Quartos object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Quartos quartos) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Quartos> listar() throws BancoDeDadosException {
        return null;
    }


    public List<Quartos> listarQuartosPorHotel(Integer idHotel) throws BancoDeDadosException {
        List<Quartos> listaQuartos = new ArrayList<>();
        Connection con = null;

        try {
            con = ConexaoBancoDeDados.getConnection();
            String sql = "SELECT * FROM QUARTOS WHERE id_hoteis = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idHotel);
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Quartos quartos = new Quartos();
                Hoteis hoteis = new Hoteis();

                quartos.setIdQuarto(res.getInt("id_quartos"));
                hoteis.setIdHotel(res.getInt("id_hoteis"));
                quartos.setNumeroQuarto(res.getInt("numero_quarto"));
                quartos.setValorDiaria(res.getDouble("valor_diaria"));
                quartos.setDescricao(res.getString("descricao"));
                quartos.setHoteis(hoteis);

                listaQuartos.add(quartos);
            }


        }catch (SQLException e){
            throw new BancoDeDadosException(e.getCause());
        }finally {
            try {
                if(con != null){
                    con.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return listaQuartos;
    }


}
