package foo.garcia.connectionFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import foo.garcia.controller.BancoController;

public class ServidorService {
	public static void main(String args[]) {
		try {
			BancoController bancoController = new BancoController();

			Registry r = LocateRegistry.createRegistry(2126);
			Naming.rebind("rmi://localhost:2126/banco", bancoController);
			System.out.println("Bem-vindo ao Servidor de Banco!!");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
