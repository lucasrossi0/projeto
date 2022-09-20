package br.com.projeto.yeahbuddy.jdbc.service;

// Singleton
public class UsuarioGerenciamento {
  private static UsuarioGerenciamento usuarioGerenciamento;

  private UsuarioGerenciamento() {

  }

  public static UsuarioGerenciamento getInstance() {
    if (usuarioGerenciamento == null) {
      usuarioGerenciamento = new UsuarioGerenciamento();
    }

    return usuarioGerenciamento;
  }

  public void Acesso() {
  }
}
