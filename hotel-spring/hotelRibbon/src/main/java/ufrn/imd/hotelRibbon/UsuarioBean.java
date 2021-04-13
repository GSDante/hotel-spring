package ufrn.imd.hotelRibbon;

public class UsuarioBean {
	protected long id;
	private String login;
	private String senha; 
	private long tokenValue;
	
	private int port;
	
	public UsuarioBean() {

	}
	

	public UsuarioBean(long id, String login, String senha, long tokenValue, int port) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.tokenValue = tokenValue;
		this.port = port;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(long tokenValue) {
		this.tokenValue = tokenValue;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
}
