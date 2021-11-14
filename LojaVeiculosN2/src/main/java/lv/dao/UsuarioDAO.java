package lv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lv.model.Usuario;

public class UsuarioDAO {
	
	private Connection conexao;

	public UsuarioDAO() throws ClassNotFoundException {
		conexao = DbConnect.getDbConnection();
	}

	public void insert(Usuario user) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"insert into lojaveiculos.user (Nome, Login, Cargo, VerifADM, Senha) values (?, ?, ?, ?, ?) ");

			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getLogin());
			preparedStatement.setString(3, user.getCargo());
			preparedStatement.setInt(4, user.getVerif_ADM());
			preparedStatement.setString(5, user.getSenha());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Usuario user) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"delete from lojaveiculos.user where idUser = ?");

			preparedStatement.setInt(1, user.getIdUsuario());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Usuario> getAllUsuario() {

		List<Usuario> usuarioList = new ArrayList<Usuario>();

		try {
			Statement statement = conexao.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM lojaveiculos.user");
			while (rs.next()) {

				Usuario usuario = new Usuario();
				
				usuario.setIdUsuario(rs.getInt("idUser"));
				usuario.setNome(rs.getString("Nome"));
				usuario.setLogin(rs.getString("Login"));
				usuario.setCargo(rs.getString("Cargo"));
				usuario.setVerif_ADM(rs.getBoolean("VerifADM"));
				usuario.setSenha(rs.getString("Senha"));

				usuarioList.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarioList;
	} 
	

	public Usuario getUsuarioById(int id) {

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);

		return getUsuarioById(usuario);

	} 
	

	public Usuario getUsuarioById(Usuario usuario) {

		Usuario usuarioOutput = new Usuario();

		try {
			PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * from lojaveiculos.user WHERE idUser=?");

			preparedStatement.setLong(1, usuario.getIdUsuario());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				
				usuarioOutput.setIdUsuario(rs.getInt("idUser"));
				usuarioOutput.setNome(rs.getString("Nome"));
				usuarioOutput.setLogin(rs.getString("Login"));
				usuarioOutput.setCargo(rs.getString("Cargo"));
				usuarioOutput.setVerif_ADM(rs.getBoolean("VerifADM"));
				usuarioOutput.setSenha(rs.getString("Senha"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarioOutput;
	} 

}
