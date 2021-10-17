package com.dbc;

import org.junit.Test;
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

}
