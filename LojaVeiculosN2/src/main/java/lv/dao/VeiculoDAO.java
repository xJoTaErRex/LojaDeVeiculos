package lv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lv.model.Compra;
import lv.model.Veiculo;

public class VeiculoDAO {
	
	private Connection conexao;

	public VeiculoDAO() throws ClassNotFoundException {
		conexao = DbConnect.getDbConnection();
	}

	public void insert(Veiculo veiculo) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"insert into lojaveiculos.veiculo (Modelo, Marca, Motorizacao, Cor, PrecoVenda, "
					+ "Ano, Kilometragem, Opcionais, Observacoes, DataEntrada, UnidadeEmEstoque) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

			preparedStatement.setString(1, veiculo.getModelo());
			preparedStatement.setString(2, veiculo.getMarca());
			preparedStatement.setString(3, veiculo.getMotorizacao());
			preparedStatement.setString(4,  veiculo.getCor());
			preparedStatement.setDouble(5, veiculo.getPrecoVenda());
			preparedStatement.setInt(6, veiculo.getAno());
			preparedStatement.setInt(7, veiculo.getKilometragem());
			preparedStatement.setString(8, veiculo.getOpcionais());
			preparedStatement.setString(9, veiculo.getObservacoes());
			preparedStatement.setDate(10,  new java.sql.Date(veiculo.getDataEntrada().getTime()));
			preparedStatement.setInt(11, veiculo.getUnidadeEmEstoque());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Veiculo veiculo) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"delete from lojaveiculos.veiculo where idVeiculo = ?");

			preparedStatement.setInt(1, veiculo.getIdVeiculo());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
