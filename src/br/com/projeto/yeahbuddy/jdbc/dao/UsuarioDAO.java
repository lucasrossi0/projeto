package br.com.projeto.yeahbuddy.jdbc.dao;

import br.com.projeto.yeahbuddy.jdbc.conexao.Conexao;
import br.com.projeto.yeahbuddy.jdbc.modelo.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
  private final Conexao connection;
  private PreparedStatement preparedStatement;

  public UsuarioDAO() {
    connection = new Conexao();
  }

  public void cadastrar(Usuario usuario) {
    try {
      String query = "INSERT INTO usuarios (nome, email, cpf, telefone) VALUES (?, ?, ?, ?)";
      preparedStatement = connection.getConnection().prepareStatement(query);

      preparedStatement.setString(1, usuario.getNome());
      preparedStatement.setString(2, usuario.getEmail());
      preparedStatement.setInt(3, usuario.getCpf());
      preparedStatement.setInt(4, usuario.getTelefone());

      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void validarLogin(int cpf) {
    try {
      String query = "SELECT nome, cpf FROM usuarios WHERE cpf = " + cpf;
      preparedStatement = connection.getConnection().prepareStatement(query);

      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        resultSet.getInt("cpf");
        System.out.println("Seja bem-vindo(a), " + resultSet.getString("nome") + "!");
      } else {
        System.out.println("Usuário não encontrado, faça seu cadastro.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<Usuario> listar() {
    ArrayList<Usuario> usuarios = new ArrayList<>();

    try {
      String query = "SELECT * FROM usuarios";
      preparedStatement = connection.getConnection().prepareStatement(query);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        usuarios.add(new Usuario(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("email"),
                resultSet.getInt("cpf"),
                resultSet.getInt("telefone"))
        );
      }

      return usuarios;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ArrayList<>();
  }
}
