package foo.garcia.model;

public class ContaSimples {
	int clienteId;
	int numeroConta;
	double saldo;
	
	public ContaSimples(int clienteId, int numeroConta, double saldo) {
		this.clienteId = clienteId;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
