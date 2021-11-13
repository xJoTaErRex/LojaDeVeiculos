package lv.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Veiculo {

    private int idVeiculo;
    private String modelo;
    private String marca;
    private String motorizacao;
    private String cor;
    private double precoVenda;
    private int ano;
    private int kilometragem;
    private String opcionais;
    private String observacoes;
    private int unidadeEmEstoque;
    private Date dataEntrada;
    

   //Construtores
   public Veiculo(String modelo, String marca, String motorizacao, String cor,
                      double precoVenda, int ano, int kilometragem, String opcionais, String observacoes,
                      Date dataEntrada, int unidadeEmEstoque){
            super();
            this.modelo = modelo;
            this.marca = marca;
            this.motorizacao = motorizacao;
            this.cor = cor;
            this.precoVenda = precoVenda;
            this.ano = ano;
            this.kilometragem = kilometragem;
            this.opcionais = opcionais;
            this.observacoes = observacoes;
            this.dataEntrada = dataEntrada;
            this.unidadeEmEstoque = unidadeEmEstoque;
    }
	public Veiculo(String modelo, String marca, String motorizacao, String cor, String precoVenda, String ano,
			String kilometragem, String opcionais, String observacoes, String dataEntrada, String unidadeEmEstoque) {
		super();
		this.setModelo(modelo);
		this.setMarca(marca);
		this.setMotorizacao(motorizacao);
		this.setCor(cor);
		this.setPrecoVenda(precoVenda);
		this.setAno(ano);
		this.setKilometragem(ano);
		this.setOpcionais(opcionais);
		this.setObservacoes(observacoes);
		this.setDataEntrada(dataEntrada);
		this.setUnidadeEmEstoque(unidadeEmEstoque);
	}

    public Veiculo(){
		super();
		// TODO Auto-generated constructor stub
	}
   
   
   
    //Id
    public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public void setIdVeiculo(String idVeiculo) {
    	setIdVeiculo(Integer.parseInt(idVeiculo));
	}
	
	//Modelo
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	//Marca
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	//Motorização
	public String getMotorizacao() {
		return motorizacao;
	}
	public void setMotorizacao(String motorizacao) {
		this.motorizacao = motorizacao;
	}
	
	//Cor
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	//Preço
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public void setPrecoVenda(String precoVenda) {	
		setPrecoVenda(Double.valueOf(precoVenda));
	}
	
	//Ano
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public void setAno(String ano) {
		setAno(Integer.parseInt(ano));
	}
	
	//Kilometragem
	public int getKilometragem() {
		return kilometragem;
	}
	public void setKilometragem(int kilometragem) {
		this.kilometragem = kilometragem;
	}
	public void setKilometragem(String km) {
		setAno(Integer.parseInt(km));
	}
	
	//Opcionais
	public String getOpcionais() {
		return opcionais;
	}
	public void setOpcionais(String opcionais) {
		this.opcionais = opcionais;
	}
	
	//Observações
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	//Estoque
	public int getUnidadeEmEstoque() {
		return unidadeEmEstoque;
	}
	public void setUnidadeEmEstoque(int unidadeEmEstoque) {
		this.unidadeEmEstoque = unidadeEmEstoque;
	}
	public void  setUnidadeEmEstoque(String unidades) {
		try {
			setUnidadeEmEstoque(Integer.valueOf(unidades));
		   } 
		   catch (NumberFormatException e) { 
			   setUnidadeEmEstoque(0);
		   }
	}
	
	//Data de Entrada
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.setDataEntrada(dateFormat.parse(dataEntrada));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("erro, data errada");
		} 
	}
	
	
	
	@Override
	public String toString() {
    return "Veiculo [idVeiculo=" + idVeiculo + ", modelo=" + modelo + ", marca=" + marca + ", motorizacao="
	   			+ motorizacao + ", cor=" + cor + ", precoVenda=" + precoVenda + ", ano=" + ano + ", kilometragem="
	   			+ kilometragem + ", opcionais=" + opcionais + ", observacoes=" + observacoes + ", unidadeEmEstoque="
	   			+ unidadeEmEstoque + ", dataEntrada=" + dataEntrada + "]";
	}

}
