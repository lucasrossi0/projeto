package br.com.projeto.yeahbuddy.jdbc.service;

import br.com.projeto.yeahbuddy.jdbc.sistema.Menu;

public enum TiposMenu {

  CADASTRARUSUARIOS {
    @Override
    public void getChoice() {
      Menu.cadastrarUsuarios();
    }
  },

  CADASTRARTREINO {
    @Override
    public void getChoice() {
      Menu.cadastrarTreinos();
    }
  },

  LISTARUSUARIOS {
    @Override
    public void getChoice() {
      Menu.listarUsuarios();
    }
  },

  LISTARTREINOS {
    @Override
    public void getChoice() {
      Menu.listarTreinos();
    }
  },

  SAIR {
    @Override
    public void getChoice() {
      Menu.sair();
    }
  };

  public abstract void getChoice();
}
