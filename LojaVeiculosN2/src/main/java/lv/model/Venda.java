package lv.model;

import java.sql.Date;

public class Venda {

	private int idVenda;
    private double valor;
    private String nomeVendedor;
    private Date dataVenda;
    private int idVeiculo;
    

    //Contrutores
    public Venda(int idVenda, double valor, Date dataVenda, 
                     int idVeiculo, String nomeVendedor){
            super();
            this.idVenda = idVenda;
            this.valor = valor;
            this.dataVenda = dataVenda;
            this.idVeiculo = idVeiculo;
            this.nomeVendedor = nomeVendedor;
    }

	public Venda() {
		super();

	}

    //Id
    public int getIdVenda() {
        return idVenda;
    }
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
    
    //Valor
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }


    //DataVenda
    public Date getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    
    //IdVeiculo
    public int getIdVeiculo() {
        return idVeiculo;
    }
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    

    //Nome Vendedor
    public String getNomeVendedor() {
        return nomeVendedor;
    }
    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }
    
    
    @Override
   	public String toString() {
   		return "Venda [idVenda=" + idVenda + ", valor=" + valor + ", nomeVendedor=" + nomeVendedor + ", dataVenda="
   				+ dataVenda + ", idVeiculo=" + idVeiculo + "]";
   	}


}

