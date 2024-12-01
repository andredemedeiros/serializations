import java.io.*;
import java.net.*;

class SerializacaoSimplesServidor {
	public static void main(String argv[]) {

		//recebimento do cliente por socket tcp
		ServerSocket listenSocket;
		try {
			listenSocket = new ServerSocket(6789);
			while (true) {
				Socket connectionSocket = listenSocket.accept();
				ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
				ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
				Compra cp = (Compra) inFromClient.readObject();			
				
				System.out.println("Recebido: \n");
				System.out.println(cp.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}