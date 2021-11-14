package lv.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Compra {

    private int idCompra;
    private double valor;
    private Date dataCompra;
    private int idVeiculo;
    

    //Construtores
	public Compra(double valor, Date dataCompra, int idVeiculo) {
		super();
		this.valor = valor;
		this.dataCompra = dataCompra;
		this.idVeiculo = idVeiculo;
	}
	public Compra(String valor, String dataCompra, String idVeiculo) {
		super();
		setValor(valor);
	    setDataCompra(dataCompra);
		setIdVeiculo(idVeiculo);
	}
	public Compra() {
		super();
	}
	public Compra(String id, String valor, String dataCompra, String idVeiculo) {
		super();
		setIdCompra(id);
		setValor(valor);
	    setDataCompra(dataCompra);
		setIdVeiculo(idVeiculo);
	}
	
	
	//Id
    public int getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    public void setIdCompra(String idCompra) {
    	setIdCompra(Integer.parseInt(idCompra));
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


    //Data da Compra
    public Date getDataCompra() {
        return dataCompra;
    }
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    public void setDataCompra(String dataCompra) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.setDataCompra(dateFormat.parse(dataCompra));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("erro, data errada");
		} 
	}
    
    //Id do Veiculo
    public int getIdVeiculo() {
        return idVeiculo;
    }
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    public void setIdVeiculo(String idVeiculo) {
    	setIdVeiculo(Integer.parseInt(idVeiculo));
	}
    
    //Metodo toString
    @Override
   	public String toString() {
   		return "Compra [idCompra=" + idCompra + ", valor=" + valor + ", dataCompra=" + dataCompra + ", idVeiculo="
   				+ idVeiculo + "]";
   	}



}
