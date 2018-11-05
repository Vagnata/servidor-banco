package foo.garcia.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import foo.garcia.contracts.BancoRemoto;
import foo.garcia.model.Cliente;
import foo.garcia.model.ContaEspecial;
import foo.garcia.model.ContaSimples;
import foo.garcia.model.Historico;

@SuppressWarnings("serial")
public class BancoController extends UnicastRemoteObject implements BancoRemoto {
	final static int SIZE = 10000;
	public static Cliente[] clientes = new Cliente[SIZE];
	public static ContaEspecial[][] contasEspeciais = new ContaEspecial[SIZE][SIZE];
	public static ContaSimples[][] contasSimples = new ContaSimples[SIZE][SIZE];
	public static Historico[] historicos = new Historico[SIZE];
	public static int contadorHistorico = 0;

	public BancoController() throws RemoteException {
		super();
	}

	@Override
	public synchronized String depositar(int idCliente, int numeroConta, double valor) {
		ContaEspecial contaEspecial = this.buscarContaEspecial(idCliente, numeroConta);
		ContaSimples contaSimples = this.buscarContaSimples(idCliente, numeroConta);

		if (contaEspecial != null) {
			contaEspecial.setSaldo(contaEspecial.getSaldo() + valor);
			salvarHistorico("Depósito", valor);
			return "Depósito realizado em uma conta especial";
		}

		if (contaSimples != null) {
			contaSimples.setSaldo(contaSimples.getSaldo() + valor);
			salvarHistorico("Depósito", valor);
			return "Depósito realizado em uma conta Simples";
		}

		return "Nenhuma conta encontrada";
	}

	@Override
	public synchronized String sacar(int idCliente, int numeroConta, double valor) {
		ContaEspecial contaEspecial = this.buscarContaEspecial(idCliente, numeroConta);
		ContaSimples contaSimples = this.buscarContaSimples(idCliente, numeroConta);

		if (contaEspecial != null) {
			if (contaEspecial.getSaldo() + contaEspecial.getLimiteCredito() - valor < 0) {
				return "Saldo insuficiente para realizar esta operação";
			}
			contaEspecial.setSaldo(contaEspecial.getSaldo() - valor);
			salvarHistorico("Saque", valor);
			return "Saque realizado em uma conta especial";
		}

		if (contaSimples != null) {
			if(contaSimples.getSaldo() - valor < 0) {
				return "Saldo insuficiente para realizar esta operação";
			}
			contaSimples.setSaldo(contaSimples.getSaldo() - valor);
			salvarHistorico("Saque", valor);
			return "Saque realizado em uma conta Simples";
		}

		return "Nenhuma conta encontrada";
	}

	@Override
	public synchronized String transferencia(int idCliente, int numeroContaOrigem, int numeroContaDestino, double valor) {
		return "Transfer";
	}

	@Override
	public String taxa(int numeroConta, double valor) {
		return "taxa";
	}

	@Override
	public synchronized String adicionarCliente(String nome, int id) {
		if (BancoController.clientes[id] != null) {
			return "Já existe um cliente com este ID único!";
		} else {
			BancoController.clientes[id] = new Cliente();
			return "Cliente cadastrado com sucesso";
		}
	}

	@Override
	public String cadastrarContaSimples(int idCliente, int numeroConta, double saldo) {
		if (buscarCliente(idCliente) instanceof Cliente) {
			if (buscarContaSimples(idCliente, numeroConta) == null) {
				contasSimples[idCliente][numeroConta] = new ContaSimples(idCliente, numeroConta, saldo);

				return "Conta simples cadastrada com sucesso!";
			}

			return "Número de conta já utilizado!";
		}

		return "Nenhum cliente com este ID foi encontrado!";
	}

	@Override
	public String cadastrarContaEspecial(int idCliente, int numeroConta, double saldo, double valorCredito) {
		if (buscarCliente(idCliente) instanceof Cliente) {
			if (buscarContaEspecial(idCliente, numeroConta) == null) {
				contasEspeciais[idCliente][numeroConta] = new ContaEspecial(idCliente, numeroConta, saldo,
						valorCredito);

				return "Conta especial cadastrada com sucesso!";
			}

			return "Número de conta já utilizado!";
		}

		return "Nenhum cliente com este ID foi encontrado!";
	}

	@Override
	public String retornaContasDoCliente(int idCliente) {
		String retorno = "";
		if (contasSimples[idCliente] != null) {
			for (ContaSimples contaSimples : contasSimples[idCliente]) {
				retorno += "rola";
			}			
		}

		if (contasEspeciais[idCliente] != null) {
			for (ContaEspecial contaEspecial : contasEspeciais[idCliente]) {
				retorno += contaEspecial.toString();
			}
		}

		if (!retorno.isEmpty()) {
			return retorno;
		}

		return "Este cliente não possui nenhuma conta!";
	}

	private ContaEspecial buscarContaEspecial(int idCliente, int numeroConta) {
		if (contasEspeciais[idCliente][numeroConta] != null) {
			return contasEspeciais[idCliente][numeroConta];
		}

		return null;
	}

	private ContaSimples buscarContaSimples(int idCliente, int numeroConta) {
		if (contasSimples[idCliente][numeroConta] != null) {
			return contasSimples[idCliente][numeroConta];
		}

		return null;
	}

	private Cliente buscarCliente(int idCliente) {
		if (clientes[idCliente] != null) {
			return clientes[idCliente];
		}

		return null;
	}

	private void salvarHistorico(String transacao, double valor) {
		BancoController.historicos[contadorHistorico] = new Historico(transacao, valor);
		contadorHistorico++;
		System.out.println("Transação de " + transacao + " no valor de " + valor + " realizada com sucesso");
	}
}
