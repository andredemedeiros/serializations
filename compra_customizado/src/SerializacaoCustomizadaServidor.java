import java.io.*;
import java.net.*;

class SerializacaoCustomizadaServidor {
    public static void main(String argv[]) {
		ServerSocket listenSocket;
        try {
			listenSocket = new ServerSocket(6789);
            while (true) {
				Socket connectionSocket = listenSocket.accept();
				ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
				ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
                CompraCustomizada cp = (CompraCustomizada) inFromClient.readObject();
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