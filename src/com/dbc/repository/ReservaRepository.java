package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Hoteis;
import com.dbc.model.Quartos;
import com.dbc.model.Reserva;
import com.dbc.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepository implements Repositorio <Integer , Reserva> {
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
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM RESERVA WHERE id_reserva = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerPessoaPorId.res=" + res);

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
    public boolean editar(Integer id, Reserva reserva) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE RESERVA SET ");
            sql.append(" id_hoteis = ?,");
            sql.append(" id_quartos = ?,");
            sql.append(" id_usuario = ?,");
            sql.append(" data_reserva = ? ");
            sql.append(" WHERE id_reserva = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, reserva.getHoteis().getIdHotel());
            stmt.setInt(2, reserva.getQuartos().getIdQuarto());
            stmt.setInt(3, reserva.getUsuario().getIdUsuario());
            stmt.setDate(4, Date.valueOf(reserva.getDataReserva()));
            stmt.setInt(5, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarReserva.res=" + res);

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
    public List<Reserva> listar() throws BancoDeDadosException {
        List<Reserva> listaReserva = new ArrayList<>();
        Connection con = null;

        try {
            con = ConexaoBancoDeDados.getConnection();
            String sql = "SELECT r.ID_RESERVA, r.ID_HOTEIS, h.NOME,\n" +
                    "r.ID_QUARTOS, qt.NUMERO_QUARTO , qt.VALOR_DIARIA , qt.DESCRICAO ,\n" +
                    "r.ID_USUARIO, u.NOME, u.CPF ,u.DATA_NASCIMENTO \n" +
                    "FROM RESERVA  r\n" +
                    "INNER JOIN HOTEIS h ON (h.ID_HOTEIS = r.ID_HOTEIS)\n" +
                    "INNER JOIN QUARTOS qt ON (qt.ID_QUARTOS = r.ID_QUARTOS)\n" +
                    "INNER JOIN USUARIO u ON (u.ID_USUARIO = r.ID_USUARIO) ";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Reserva reserva = new Reserva();
                Quartos quartos = new Quartos();
                Hoteis hoteis = new Hoteis();
                Usuario usuario = new Usuario();

                quartos.setIdQuarto(res.getInt("id_quartos"));
                quartos.setNumeroQuarto(res.getInt("numero_quarto"));
                quartos.setValorDiaria(res.getDouble("valor_diaria"));
                quartos.setDescricao(res.getString("descricao"));

                hoteis.setIdHotel(res.getInt("id_hoteis"));
                hoteis.setNome(res.getString("nome"));
                quartos.setHoteis(hoteis);

                usuario.setIdUsuario(res.getInt("id_usuario"));
                usuario.setNome(res.getString("nome"));
                usuario.setCpf(res.getString("cpf"));
                usuario.setDataNascimento(res.getDate("data_nascimento").toLocalDate());

                reserva.setIdReserva(res.getInt("id_reserva"));
                reserva.setHoteis(hoteis);
                reserva.setQuartos(quartos);
                reserva.setUsuario(usuario);
                listaReserva.add(reserva);
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
        return listaReserva;
    }

    public boolean removerPorHotel(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM RESERVA WHERE id_hoteis = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerPessoaPorId.res=" + res);

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
}
