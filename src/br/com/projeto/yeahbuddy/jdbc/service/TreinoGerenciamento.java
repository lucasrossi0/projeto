package br.com.projeto.yeahbuddy.jdbc.service;

public class TreinoGerenciamento {
  private static TreinoGerenciamento treinoGerenciamento;

  private TreinoGerenciamento() {

  }

  public static TreinoGerenciamento getInstance() {
    if (treinoGerenciamento == null) {
      treinoGerenciamento = new TreinoGerenciamento();
    }

    return treinoGerenciamento;
  }

  public void Acesso() {
  }
}