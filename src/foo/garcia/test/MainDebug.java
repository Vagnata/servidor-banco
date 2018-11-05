package foo.garcia.test;

import foo.garcia.model.Cliente;
import foo.garcia.model.ContaSimples;
import foo.garcia.model.ContaEspecial;

public class MainDebug {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNome("Vagner Garcia");
		
		ContaSimples contaSimples = new ContaSimples();
		contaSimples.setNumeroConta(111);
		contaSimples.setSaldo(1000.0);
		
		ContaEspecial contaEspecial = new ContaEspecial();
		contaEspecial.setNumeroConta(222);
		contaEspecial.setSaldo(2000.0);
		contaEspecial.setLimiteCredito(1000.0);	
	}
}
