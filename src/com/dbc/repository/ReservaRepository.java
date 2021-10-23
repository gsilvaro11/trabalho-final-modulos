package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Reserva;

import java.sql.*;
import java.util.List;

public class ReservaRepository implements Repositorio <Integer , Reserva>{
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_reservas.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }


    @Override
    public Reserva adicionar(Reserva reserva) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            reserva.setIdReserva(proximoId);

            String sql = "INSERT INTO RESERVA\n" +
                    "(ID_RESERVA, ID_HOTEIS, ID_QUARTOS,ID_USUARIO, DATA_RESERVA)\n" +
                    "VALUES(?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, reserva.getIdReserva());
            stmt.setInt(2, reserva.getHoteis().getIdHotel());
            stmt.setInt(3, reserva.getQuartos().getIdQuarto());
            stmt.setInt(4, reserva.getUsuario().getIdUsuario());
            stmt.setDate(5, Date.valueOf(reserva.getDataReserva()));

            int res = stmt.executeUpdate();
            System.out.println("adicionarReserva.res=" + res);
            return reserva;
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
        return false;
    }

    @Override
    public boolean editar(Integer id, Reserva reserva) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Reserva> listar() throws BancoDeDadosException {
        return null;
    }
}
