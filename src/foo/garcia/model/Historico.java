package foo.garcia.model;

public class Historico {
	String nomeOperacao;
	double valorOperacao;

	public Historico (String nomeOperacao, double valorOperacao) {
		this.nomeOperacao = nomeOperacao;
		this.valorOperacao = valorOperacao;
	}
	
	public String getNomeOperacao() {
		return nomeOperacao;
	}

	public void setNomeOperacao(String nomeOperacao) {
		this.nomeOperacao = nomeOperacao;
	}

	public double getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}
}
