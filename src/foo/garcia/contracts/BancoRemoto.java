package foo.garcia.contracts;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoRemoto extends Remote {
	//Métodos das Contas
	public String depositar(int idCliente, int numeroConta, double valor) throws RemoteException;
	public String sacar(int idCliente, int numeroConta, double valor) throws RemoteException;
	public String transferencia(int idCliente, int numeroContaOrigem, int numeroContaDestino, double valor) throws RemoteException;
	public String taxa(int numeroConta, double valor) throws RemoteException;
	//Métodos dos Clientes
	public String adicionarCliente(String nome, int id) throws RemoteException;
	public String cadastrarContaSimples(int idCliente, int numeroConta, double saldo) throws RemoteException;
	public String cadastrarContaEspecial(int idCliente, int numeroConta, double saldo, double valorCredito) throws RemoteException;
	public String retornaContasDoCliente(int idCliente) throws RemoteException;
}
