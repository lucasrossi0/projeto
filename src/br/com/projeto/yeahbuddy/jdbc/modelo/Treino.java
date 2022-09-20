package br.com.projeto.yeahbuddy.jdbc.modelo;

public class Treino {
  private int id;
  private String nome;
  private String dia;

  public Treino() {
  }

  public Treino(int id, String nome, String dia) {
    this.id = id;
    this.nome = nome;
    this.dia = dia;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDia() {
    return dia;
  }

  public void setDia(String dia) {
    this.dia = dia;
  }
}