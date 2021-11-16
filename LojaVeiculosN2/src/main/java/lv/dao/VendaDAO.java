package lv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lv.model.Venda;

public class VendaDAO {
	
	private Connection conexao;

	public VendaDAO() throws ClassNotFoundException {
		conexao = DbConnect.getDbConnection();
	}

	public void insert(Venda venda) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"insert into YMCg3mgime.Venda (Valor, IdVeiculo, NomeVendedor, DataVenda) values (?, ?, ?, ?) ");

			preparedStatement.setDouble(1, venda.getValor());
			preparedStatement.setInt(2, venda.getIdVeiculo());
			preparedStatement.setString(3, venda.getNomeVendedor());
			preparedStatement.setDate(4,  new java.sql.Date(venda.getDataVenda().getTime()));

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Venda venda) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"delete from YMCg3mgime.Venda where idVenda = ?");

			preparedStatement.setInt(1, venda.getIdVenda());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Venda venda) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"update YMCg3mgime.Venda  set Valor=?, IdVeiculo=?, NomeVendedor=?, DataVenda=? where idVenda=? ");

			preparedStatement.setDouble(1, venda.getValor());
			preparedStatement.setInt(2, venda.getIdVenda());
			preparedStatement.setString(3, venda.getNomeVendedor());
			preparedStatement.setDate(4,  new java.sql.Date(venda.getDataVenda().getTime()));
			preparedStatement.setDouble(5, venda.getIdVenda());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Venda> getAllVendas() {

		List<Venda> vendaList = new ArrayList<Venda>();

		try {
			Statement statement = conexao.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM YMCg3mgime.Venda");
			while (rs.next()) {

				Venda venda = new Venda();

				venda.setIdVenda(rs.getInt("idVenda"));
				venda.setValor(rs.getString("Valor"));
				venda.setIdVeiculo(rs.getString("idVeiculo"));
				venda.setNomeVendedor(rs.getString("NomeVendedor"));
				venda.setDataVenda(rs.getString("DataVenda"));
				
				vendaList.add(venda);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vendaList;
	} 
	

	public Venda getVendaById(int id) {

		Venda venda = new Venda();
		venda.setIdVenda(id);

		return getVendaById(venda);

	} 
	

	public Venda getVendaById(Venda venda) {

		Venda vendaOutput = new Venda();

		try {
			PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * from YMCg3mgime.Venda WHERE idVenda=?");

			preparedStatement.setLong(1, venda.getIdVenda());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				vendaOutput.setIdVenda(rs.getInt("idVenda"));
				vendaOutput.setValor(rs.getString("Valor"));
				vendaOutput.setIdVeiculo(rs.getString("idVeiculo"));
				vendaOutput.setNomeVendedor(rs.getString("NomeVendedor"));
				vendaOutput.setDataVenda(rs.getString("DataVenda"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vendaOutput;
	} 

}
