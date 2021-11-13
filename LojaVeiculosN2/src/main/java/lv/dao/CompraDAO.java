package lv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lv.model.Compra;

public class CompraDAO {
	
	private Connection conexao;

	public CompraDAO() throws ClassNotFoundException {
		conexao = DbConnect.getDbConnection();
	}

	public void insert(Compra compra) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"insert into lojaveiculos.compra (Valor, IdVeiculo, DataCompra) values (?, ?, ?) ");

			preparedStatement.setDouble(1, compra.getValor());
			preparedStatement.setInt(2, compra.getIdVeiculo());
			preparedStatement.setDate(3,  new java.sql.Date(compra.getDataCompra().getTime()));

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Compra compra) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"delete from lojaveiculos.compra where idCompra = ?");

			preparedStatement.setInt(1, compra.getIdCompra());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
