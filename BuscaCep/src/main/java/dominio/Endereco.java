package dominio;

public class Endereco {
	public String logradouro;
	public String bairro;
	public String estado;
	public String regiao;

	public Endereco() {
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getEstado() {
		return estado;
	}


	public String getRegiao() {
		return regiao;
	}

	@Override
	public String toString() {
		return "Cep [logradouro=" + logradouro + ", bairro=" + bairro + ", estado=" + estado
				+ ", regiao=" + regiao + "]";
	}
}
