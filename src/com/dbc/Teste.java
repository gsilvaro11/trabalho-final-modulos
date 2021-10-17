package com.dbc;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Teste {

    @Test
    public void verificaLoginUsarioEAdmin(){
        //SETUP
        Usuario usuario = new Usuario();
        usuario.setLogin("jujuba");
        usuario.setSenha("1234");

        //ATC
        boolean login = usuario.logar("jujuba", "1234");
        String nomeLogin = usuario.getLogin();
        String senhaLogin = usuario.getSenha();

        //ASSERT
        assertTrue(login);
        assertEquals("jujuba", nomeLogin);
        assertEquals("1234", senhaLogin);

    }

    @Test
    public  void cadastroContato(){
        Contato contato = new Contato();

        contato.setEmail("Matheus.camilo16@hotmail.com");
        contato.setTelefone("12981117598");

        assertEquals("Matheus.camilo16@hotmail.com",contato.getEmail());
        assertEquals("12981117598",contato.getTelefone());
    }

    @Test
    public void Endereco(){
        Endereco endereco = new Endereco();

        endereco.setCep("12504-010");
        endereco.setCidade("Guaratinguetá");
        endereco.setEstado("SP");
        endereco.setNumero(484);

        assertEquals("12504-010",endereco.getCep());
        assertEquals("Guaratinguetá",endereco.getCidade());
        assertEquals("SP",endereco.getEstado());
        assertEquals(484,endereco.getNumero());

    }
    @Test
    public  void Hoteis(){
        Hoteis hoteis = new Hoteis();
        String[][][] listaHoteis = {
                {{"HOTEL LAGHETOO", "HOTEL DEVILLE"}, {"PRODIGY HOTEL", "HOTEL FIOREZE"}},
                {{"IBIS", "HOLLYDAY"}, {"HOTEL COSTEIRO", "HOTEL 7 COLINAS"}},
                {{"LOTUS", "GUARA INN"}, {"SAN MICHEL", "SAN RAPHAEL"}}
        };
        Integer[][][] listaNumeroQuarto = {
                {{320, 110}, {8, 27}},
                {{88, 12}, {369, 458}},
                {{340, 157}, {478, 69}}
        };

        String[][][] listaDescricaoQuarto = {
                {{"Casal", "Solteiro"}, {"Casal", "Solteiro"}},
                {{"Casal", "Solteiro"}, {"Casal", "Solteiro"}},
                {{"Casal", "Solteiro"}, {"Casal", "Solteiro"}}
        };

        Double[][][] listaValorQuarto = {
                {{270.0d, 158.0d}, {326.0d, 257.0d}},
                {{425.0d, 175.0d}, {177.99d, 110.0d}},
                {{127.0d}, {255.99d, 427.0d}}
        };

        ArrayList<Estado> listaEstados = new ArrayList<>();

        listaEstados.add(Estado.RIO_GRANDE_DO_SUL);
        listaEstados.add(Estado.PERNAMBUCO);
        listaEstados.add(Estado.SAO_PAULO);

        hoteis.setHoteis(listaHoteis);

        hoteis.setEstados(listaEstados);
        hoteis.setHoteis(listaHoteis);
        hoteis.setNumeroQuarto(listaNumeroQuarto);
        hoteis.setDescricao(listaDescricaoQuarto);
        hoteis.setValorQuarto(listaValorQuarto);

        assertEquals(listaHoteis, hoteis.getHoteis());
    }


}
