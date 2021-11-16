package lv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lv.model.Veiculo;
public class VeiculoDAO {
	
	private Connection conexao;

	public VeiculoDAO() throws ClassNotFoundException {
		conexao = DbConnect.getDbConnection();
	}

	public void insert(Veiculo veiculo) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"insert into YMCg3mgime.Veiculo (Modelo, Marca, Motorizacao, Cor, PrecoVenda, "
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
					"delete from YMCg3mgime.Veiculo where idVeiculo = ?");

			preparedStatement.setInt(1, veiculo.getIdVeiculo());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Veiculo veiculo) {

		try {

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"update YMCg3mgime.Veiculo set Modelo=?, Marca=?, Motorizacao=?, Cor=?, PrecoVenda=?, "
					+ "Ano=?, Kilometragem=?, Opcionais=?, Observacoes=?, DataEntrada=?, UnidadeEmEstoque=? "
					+ "where idVeiculo =? ");

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
			preparedStatement.setInt(12, veiculo.getIdVeiculo());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Veiculo> getAllVeiculos() {

		List<Veiculo> veiculoList = new ArrayList<Veiculo>();

		try {
			Statement statement = conexao.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM YMCg3mgime.Veiculo");
			while (rs.next()) {

				Veiculo veiculo = new Veiculo();
				
				veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
				veiculo.setModelo(rs.getString("Modelo"));
				veiculo.setMarca(rs.getString("Marca"));
				veiculo.setMotorizacao(rs.getString("Motorizacao"));
				veiculo.setCor(rs.getString("Cor"));
				veiculo.setPrecoVenda(rs.getString("PrecoVenda"));
				veiculo.setAno(rs.getString("Ano"));
				veiculo.setKilometragem(rs.getString("Kilometragem"));
				veiculo.setOpcionais(rs.getString("Opcionais"));
				veiculo.setObservacoes(rs.getString("Observacoes"));
				veiculo.setDataEntrada(rs.getString("DataEntrada"));
				veiculo.setUnidadeEmEstoque(rs.getString("UnidadeEmEstoque"));

				veiculoList.add(veiculo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return veiculoList;
	} 
	

	public Veiculo getVeiculoById(int id) {

		Veiculo veiculo = new Veiculo();
		veiculo.setIdVeiculo(id);

		return getVeiculoById(veiculo);

	} 
	

	public Veiculo getVeiculoById(Veiculo veiculo) {

		Veiculo veiculoOutput = new Veiculo();

		try {
			PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * from YMCg3mgime.Veiculo WHERE idVeiculo=?");

			preparedStatement.setLong(1, veiculo.getIdVeiculo());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				
				veiculoOutput.setIdVeiculo(rs.getInt("idVeiculo"));
				veiculoOutput.setModelo(rs.getString("Modelo"));
				veiculoOutput.setMarca(rs.getString("Marca"));
				veiculoOutput.setMotorizacao(rs.getString("Motorizacao"));
				veiculoOutput.setCor(rs.getString("Cor"));
				veiculoOutput.setPrecoVenda(rs.getString("PrecoVenda"));
				veiculoOutput.setAno(rs.getString("Ano"));
				veiculoOutput.setKilometragem(rs.getString("Kilometragem"));
				veiculoOutput.setOpcionais(rs.getString("Opcionais"));
				veiculoOutput.setObservacoes(rs.getString("Observacoes"));
				veiculoOutput.setDataEntrada(rs.getString("DataEntrada"));
				veiculoOutput.setUnidadeEmEstoque(rs.getString("UnidadeEmEstoque"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return veiculoOutput;
	} 

}
