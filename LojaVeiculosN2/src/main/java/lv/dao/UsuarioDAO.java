package lv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lv.model.Usuario;

public class UsuarioDAO {
	
	private Connection conexao;

	public UsuarioDAO() throws ClassNotFoundException {
		conexao = DbConnect.getDbConnection();
	}

	public void insert(Usuario user) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"insert into lojaveiculos.user (Nome, Login, Cargo, VerifADM) values (?, ?, ?, ?) ");

			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getLogin());
			preparedStatement.setString(3, user.getCargo());
			preparedStatement.setInt(4, user.getVerif_ADM());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
