package com.dbc;

public abstract class Conta {
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private Contato contato;
    private Endereco endereco;


    public boolean logar(String login, String senha){
        if(this.getLogin().equals(login) && this.getSenha().equals(senha)){
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", contato=" + contato +
                ", endereco=" + endereco +
                '}';
    }
}
