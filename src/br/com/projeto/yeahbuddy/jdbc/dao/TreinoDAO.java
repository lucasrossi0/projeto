package br.com.projeto.yeahbuddy.jdbc.dao;

import br.com.projeto.yeahbuddy.jdbc.conexao.Conexao;
import br.com.projeto.yeahbuddy.jdbc.modelo.Treino;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreinoDAO {
  private final Conexao connection;
  private PreparedStatement preparedStatement;

  public TreinoDAO() {
    connection = new Conexao();
  }

  public void cadastrar(Treino treino) {
    try {
      String query = "INSERT INTO treinos (nome, dia) VALUES (?, ?)";
      preparedStatement = connection.getConnection().prepareStatement(query);

      preparedStatement.setString(1, treino.getNome());
      preparedStatement.setString(2, treino.getDia());

      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Treino> listar() {
    ArrayList<Treino> treinos = new ArrayList<>();

    try {
      String query = "SELECT * FROM treinos";
      preparedStatement = connection.getConnection().prepareStatement(query);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        treinos.add(new Treino(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("dia"))
        );
      }

      return treinos;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ArrayList<>();
  }
}
