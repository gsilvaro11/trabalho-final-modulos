package com.dbc.model;
public class Endereco {
    private Integer id_endereco;
    private Cidade cidade;
    private String cep;
    private Integer numero;
    private String logradouro;

    public Integer getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Integer id_endereco) {
        this.id_endereco = id_endereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }


    @Override
    public String toString() {
        return "Endereco{" +
                "id_endereco=" + id_endereco +
                ", cidade=" + cidade +
                ", cep='" + cep + '\'' +
                ", numero=" + numero +
                ", logradouro='" + logradouro + '\'' +
                '}';
    }
}
