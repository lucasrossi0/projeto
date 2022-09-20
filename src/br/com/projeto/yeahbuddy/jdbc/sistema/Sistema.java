package br.com.projeto.yeahbuddy.jdbc.sistema;

import br.com.projeto.yeahbuddy.jdbc.service.TreinoGerenciamento;
import br.com.projeto.yeahbuddy.jdbc.service.UsuarioGerenciamento;

public class Sistema {
  public static void main(String[] args) {
    Menu.tipoMenuSelecionado();

    UsuarioGerenciamento usuarioGerenciamento1 = UsuarioGerenciamento.getInstance();
    usuarioGerenciamento1.Acesso();

    TreinoGerenciamento treinoGerenciamento1 = TreinoGerenciamento.getInstance();
    treinoGerenciamento1.Acesso();
  }
}