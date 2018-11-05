package foo.garcia.model;

public class ContaEspecial {
	int clienteId;
	double limiteCredito;
	int numeroConta;
	double saldo;

	public ContaEspecial(int clienteId, int numeroConta, double saldo, double limiteCredito) {
		this.clienteId = clienteId;
		this.limiteCredito = limiteCredito;
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
	
	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
}
