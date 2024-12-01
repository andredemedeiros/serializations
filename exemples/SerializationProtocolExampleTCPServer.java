import java.io.*;
import java.net.*;

class SerializationProtocolExampleTCPServer {
	public static void main(String argv[]) {
		ServerSocket listenSocket;
		try {
			listenSocket = new ServerSocket(6789);
			while (true) {
				Socket connectionSocket = listenSocket.accept();
				ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
				ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
				PessoaSerializationProtocol p = (PessoaSerializationProtocol) inFromClient.readObject();
				p.cidade = "Fortaleza";
				p.ano = 2014;
				outToClient.writeObject(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}