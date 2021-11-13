package lv.model;

import java.sql.Date;

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
                      Date dataEntrada, 
                     int idVeiculo, int unidadeEmEstoque){
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
            this.idVeiculo = idVeiculo;
            this.unidadeEmEstoque = unidadeEmEstoque;
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
	
	//Ano
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	//Kilometragem
	public int getKilometragem() {
		return kilometragem;
	}
	public void setKilometragem(int kilometragem) {
		this.kilometragem = kilometragem;
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
	
	//Data de Entrada
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	
	
	@Override
	public String toString() {
    return "Veiculo [idVeiculo=" + idVeiculo + ", modelo=" + modelo + ", marca=" + marca + ", motorizacao="
	   			+ motorizacao + ", cor=" + cor + ", precoVenda=" + precoVenda + ", ano=" + ano + ", kilometragem="
	   			+ kilometragem + ", opcionais=" + opcionais + ", observacoes=" + observacoes + ", unidadeEmEstoque="
	   			+ unidadeEmEstoque + ", dataEntrada=" + dataEntrada + "]";
	}

}
