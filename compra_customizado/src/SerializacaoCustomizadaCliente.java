import java.io.*;
import java.net.*;

class SerializacaoCustomizadaCliente {
	public static void main(String argv[]) {

		//lista de produtos
		CompraCustomizada cp = new CompraCustomizada("André Filipe de Medeiros - 542104");
	
		cp.adicionarProduto("Computador Gamer Alienware Aurora R15", 10000);
		cp.adicionarProduto("Teclado Gamer Razer Blackwidow V4", 1000);
		cp.adicionarProduto("Mouse gamer Razer DeathAdder Essential", 1000);
		cp.adicionarProduto("Headset Gamer Sem Fio Logitech G Astro A50 X LIGHTSPEED", 1000);
		cp.adicionarProduto("Cadeira Gamer DT3 Sports Rhino", 2000);

		SerializationUtil.writeObjectToFile("teste.data", cp);

		System.out.println("Enviando: \n");
		System.out.println(cp.toString());

		//envio ao servidor por socket tcp
		Socket clientSocket;
		try {
			clientSocket = new Socket("localhost", 6789);
			ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
			outToServer.writeObject(cp);
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}