package br.com.projeto.yeahbuddy.jdbc.sistema;

import br.com.projeto.yeahbuddy.jdbc.dao.TreinoDAO;
import br.com.projeto.yeahbuddy.jdbc.dao.UsuarioDAO;
import br.com.projeto.yeahbuddy.jdbc.modelo.Treino;
import br.com.projeto.yeahbuddy.jdbc.modelo.Usuario;
import br.com.projeto.yeahbuddy.jdbc.service.TiposMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
  private Menu() {

  }

  public static void tipoMenuSelecionado() {
    teclaApertada();

    Scanner scanner = new Scanner(System.in);

    System.out.println("\n[1] Administrador");
    System.out.println("[2] Usuário");

    System.out.println("\nSelecione o tipo de menu desejado: ");
    int choice = scanner.nextInt();

    if (choice == 1) {
      telaDeMenuAdministrador();
    }

    if (choice == 2) {
      validarLoginUsuarios();
      telaDeMenuUsuario();
    }
  }

  public static void telaDeMenuAdministrador() {
    Scanner scanner = new Scanner(System.in);
    int breakpoint;
    int start = 0;
    int escolha;

    System.out.println("Informe quantas operações gostaria de fazer: ");
    breakpoint = scanner.nextInt();

    if (breakpoint == 0) {
      return;
    }

    do {
      System.out.println("\n\n[1] Cadastrar usuário");
      System.out.println("[2] Cadastrar treino");
      System.out.println("[3] Listar usuários");
      System.out.println("[4] Listar treinos");
      System.out.println("[7] Sair\n");
      System.out.print("Informe o que deseja: ");

      escolha = scanner.nextInt();

      TiposMenu choiceTypes = TiposMenu.values()[escolha-1];
      choiceTypes.getChoice();

      if (escolha == 7) {
        break;
      }

      start++;
    } while (start < breakpoint);
  }

  public static void telaDeMenuUsuario() {
    Scanner scanner = new Scanner(System.in);
    int choice;

    System.out.println("[1] Fazer logout\n");

    System.out.print("Informe o que deseja: ");
    choice = scanner.nextInt();

    if (choice == 0) {
      System.out.println("Logout concluído. Volte sempre!");
      tipoMenuSelecionado();
    }
  }

  public static void cadastrarUsuarios() {
    Scanner scanner = new Scanner(System.in);
    Usuario usuario = new Usuario();

    System.out.println("\n***CADASTRAR USUÁRIO***");

    System.out.print("\nNome: ");
    usuario.setNome(scanner.nextLine());
    System.out.print("E-mail: ");
    usuario.setEmail(scanner.next());
    System.out.print("CPF: ");
    usuario.setCpf(scanner.nextInt());
    System.out.print("Telefone: ");
    usuario.setTelefone(scanner.nextInt());

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    usuarioDAO.cadastrar(usuario);
  }

  public static void listarUsuarios() {
    teclaApertada();

    System.out.println("\n\n*=* USUÁRIOS CADASTRADOS *=*");
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioDAO.listar();
    usuarios.forEach(item -> System.out.println(
            "\nN° usuário: " + item.getId()      +
            "\nNome: "       + item.getNome()    +
            "\nE-mail: "     + item.getEmail()   +
            "\nCPF: "        + item.getCpf()     +
            "\nTelefone: "   + item.getTelefone())
    );
  }

  public static void cadastrarTreinos() {
    Scanner scanner = new Scanner(System.in);
    Treino treino = new Treino();

    System.out.println("\n***CADASTRAR TREINOS***");

    System.out.print("\nNome: ");
    treino.setNome(scanner.nextLine());
    System.out.print("Dia: ");
    treino.setDia(scanner.next());

    TreinoDAO treinoDAO = new TreinoDAO();
    treinoDAO.cadastrar(treino);
  }

  public static void listarTreinos() {
    teclaApertada();

    System.out.println("\n\n*=* TREINOS CADASTRADOS *=*");
    TreinoDAO treinoDAO = new TreinoDAO();

    ArrayList<Treino> treinos = (ArrayList<Treino>) treinoDAO.listar();
    treinos.forEach(item -> System.out.println(
            "\nN° treino: "  + item.getId()      +
            "\nNome: "       + item.getNome()    +
            "\nDia: "        + item.getDia())
    );
  }

  public static void validarLoginUsuarios() {
    System.out.println("\nFaça seu login para continuar: ");

    Scanner scanner = new Scanner(System.in);
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    System.out.print("\nInsira seu CPF: ");
    usuarioDAO.validarLogin(scanner.nextInt());

    teclaApertada();
  }

  public static void sair() {
    System.out.println("Saindo da aplicação.");
  }

  private static void teclaApertada() {
    System.out.println("\nPressione qualquer tecla para continuar...");

    try {
      System.in.read();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
