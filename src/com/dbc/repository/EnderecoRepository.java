package com.dbc.repository;

import com.dbc.Service.EnderecoService;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository implements Repositorio<Integer, Endereco> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_enderecos.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Endereco adicionar(Endereco object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Endereco endereco) throws BancoDeDadosException {
        return false;
    }

    @Override
        public List<Endereco> listar() throws BancoDeDadosException {
            List<Endereco> listaEndereco = new ArrayList<>();
            Connection con = null;

            try {
                con = ConexaoBancoDeDados.getConnection();
                    String sql = "SELECT * FROM ENDERECOS ";

                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet res = stmt.executeQuery(sql);

                while (res.next()) {
                    Cidade cidade = new Cidade();
                    Endereco endereco = new Endereco();

                    endereco.setId_endereco(res.getInt("id_enderecos"));
                    cidade.setIdCidade(res.getInt("id_cidades"));
                    endereco.setCidade(cidade);
                    endereco.setLogradouro(res.getString("logradouro"));
                    endereco.setNumero(res.getInt("numero_enderecos"));
                    endereco.setCep(res.getString("cep"));
                    listaEndereco.add(endereco);
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
            return listaEndereco;
        }
    }
