package lv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lv.model.Compra;

public class CompraDAO {
	
	private Connection conexao;

	public CompraDAO() throws ClassNotFoundException {
		conexao = DbConnect.getDbConnection();
	}

	public void insert(Compra compra) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"insert into YMCg3mgime.Compra (Valor, IdVeiculo, DataCompra) values (?, ?, ?) ");

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
					"delete from YMCg3mgime.Compra where idCompra = ?");

			preparedStatement.setInt(1, compra.getIdCompra());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Compra compra) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"update YMCg3mgime.Compra set Valor=?, IdVeiculo=?, DataCompra=? where idCompra = ?");

			preparedStatement.setDouble(1, compra.getValor());
			preparedStatement.setInt(2, compra.getIdVeiculo());
			preparedStatement.setDate(3,  new java.sql.Date(compra.getDataCompra().getTime()));
			preparedStatement.setInt(4, compra.getIdCompra());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Compra> getAllCompras() {

		List<Compra> compraList = new ArrayList<Compra>();

		try {
			Statement statement = conexao.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM YMCg3mgime.Compra");
			while (rs.next()) {

				Compra compra = new Compra();

				compra.setIdCompra(rs.getInt("idCompra"));
				compra.setDataCompra(rs.getString("DataCompra"));
				compra.setValor(rs.getString("Valor"));
				compra.setIdVeiculo(rs.getString("idVeiculo"));

				compraList.add(compra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return compraList;
	} 
	

	public Compra getCompraById(int id) {

		Compra compra = new Compra();
		compra.setIdCompra(id);

		return getCompraById(compra);

	} 
	

	public Compra getCompraById(Compra compra) {

		Compra compraOutput = new Compra();

		try {
			PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * from YMCg3mgime.Compra WHERE idCompra=?");

			preparedStatement.setLong(1, compra.getIdCompra());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				compraOutput.setIdCompra(rs.getInt("idCompra"));
				compraOutput.setDataCompra(rs.getString("DataCompra"));
				compraOutput.setValor(rs.getString("Valor"));
				compraOutput.setIdVeiculo(rs.getString("idVeiculo"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return compraOutput;
	} 

}
