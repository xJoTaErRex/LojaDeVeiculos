package lv.model;

import java.sql.Date;

public class Compra {

    private int idCompra;
    private double valor;
    private Date dataCompra;
    private int idVeiculo;
    

    //Construtores
	public Compra(int idCompra, double valor, Date dataCompra, int idVeiculo) {
		super();
		this.idCompra = idCompra;
		this.valor = valor;
		this.dataCompra = dataCompra;
		this.idVeiculo = idVeiculo;
	}

	public Compra() {
		super();
	}
	
	
	//Id
    public int getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    
    //Valor
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }


    //Data da Compra
    public Date getDataCompra() {
        return dataCompra;
    }
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    
    //Id do Veiculo
    public int getIdVeiculo() {
        return idVeiculo;
    }
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    
    //Metodo toString
    @Override
   	public String toString() {
   		return "Compra [idCompra=" + idCompra + ", valor=" + valor + ", dataCompra=" + dataCompra + ", idVeiculo="
   				+ idVeiculo + "]";
   	}



}
