package lv.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Venda {

	private int idVenda;
    private double valor;
    private String nomeVendedor;
    private Date dataVenda;
    private int idVeiculo;
    

    //Contrutores
    public Venda(double valor, int idVeiculo, String nomeVendedor, Date dataVenda){
            super();
            this.valor = valor;
            this.idVeiculo = idVeiculo;
            this.nomeVendedor = nomeVendedor;
            this.dataVenda = dataVenda;
    }

	public Venda(String valor, String idVeiculo, String nomeVendedor, String dataVenda) {
		super();
		setValor(valor);
		setIdVeiculo(idVeiculo);
		this.nomeVendedor = nomeVendedor;
		setDataVenda(dataVenda);
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
    public void setIdVenda(String idVenda) {
    	setIdVenda(Integer.parseInt(idVenda));
	}
    
    //Valor
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setValor(String valor) {	
		setValor(Double.valueOf(valor));
	}


    //DataVenda
    public Date getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    public void setDataVenda(String dataVenda) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.setDataVenda(dateFormat.parse(dataVenda));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("erro, data errada");
		} 
	}

    
    //IdVeiculo
    public int getIdVeiculo() {
        return idVeiculo;
    }
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    public void setIdVeiculo(String idCompra) {
    	setIdVeiculo(Integer.parseInt(idCompra));
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

