package com.dbc.Service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Usuario;
import com.dbc.repository.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(){
        this.usuarioRepository = new UsuarioRepository();
    }

    public void adicionarUsuario(Usuario usuario){
        try {
            Usuario novoUsuario = usuarioRepository.adicionar(usuario);
            System.out.println("Usuário adicionando com sucesso!!! " + novoUsuario);
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    public Usuario getUsuarioPorId(Integer id){
        try {
           return usuarioRepository.getUsuarioPorId(id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
            return null;
        }
    }


}
