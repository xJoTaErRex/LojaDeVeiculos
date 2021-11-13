package lv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lv.model.Venda;

public class VendaDAO {
	
	private Connection conexao;

	public VendaDAO() throws ClassNotFoundException {
		conexao = DbConnect.getDbConnection();
	}

	public void insert(Venda venda) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"insert into lojaveiculos.venda (Valor, IdVeiculo, NomeVendedor, DataCompra) values (?, ?, ?, ?) ");

			preparedStatement.setDouble(1, venda.getValor());
			preparedStatement.setInt(2, venda.getIdVeiculo());
			preparedStatement.setString(3, venda.getNomeVendedor());
			preparedStatement.setDate(4,  new java.sql.Date(venda.getDataVenda().getTime()));

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
