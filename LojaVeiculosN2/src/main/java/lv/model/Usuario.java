package lv.model;

public class Usuario {
	
    private int idUsuario = 0;
    private String nome;
    private String login;
    private String cargo;
    private String senha;
    private boolean verif_ADM;
   
   //Construtores
	public Usuario(String nome, String login, String cargo, String senha, boolean verif_ADM) {
		super();
		this.nome = nome;
		this.login = login;
		this.cargo = cargo;
		this.senha = senha;
		this.verif_ADM = verif_ADM;
	}

	public Usuario(String nome, String login, String cargo, String senha) {
		super();
		this.nome = nome;
		this.login = login;
		this.cargo = cargo;
		this.senha = senha;
	}
   
	public Usuario() {
		super();
	}

	//Id
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    //Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    //Login
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    //Cargo
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    //Senha
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Verificação de Administrador
    public int getVerif_ADM() {
        if(verif_ADM == true) {
        	return 1;
        }
    	return 0;
    }
    public void setVerif_ADM(boolean verif_ADM) {
        this.verif_ADM = verif_ADM;
    }
    
    @Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", login=" + login + ", cargo=" + cargo
				+ ", senha=" + senha + ", verif_ADM=" + verif_ADM + "]";
	}
    
    
}