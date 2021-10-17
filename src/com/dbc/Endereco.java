package com.dbc;

public class Endereco {
    private String cidade;
    private String estado;
    private String cep;
    private int numero;

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  @Override
  public String toString() {
    return "Endereco{" +
            "cidade='" + cidade + '\'' +
            ", estado='" + estado + '\'' +
            ", cep='" + cep + '\'' +
            ", numero=" + numero +
            '}';
  }
}
