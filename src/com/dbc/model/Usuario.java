package com.dbc.model;

import java.time.LocalDate;

public class Usuario {
    private Integer id_usuario;
    private String nome_usuario;
    private String cpf;
    private LocalDate data_nascimento;
    private String login;
    private String senha;
    private Integer tipo_usuario; // 0 - Comum, 1 - Admin.

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(Integer tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nome_usuario='" + nome_usuario + '\'' +
                ", cpf='" + cpf + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", tipo_usuario=" + tipo_usuario +
                '}';
    }
}
