import java.io.*;
import java.net.*;

class SerializacaoCustomizadaServidor {
    public static void main(String argv[]) {
        // Recebimento do cliente por socket TCP
        ServerSocket listenSocket;
        try {
            listenSocket = new ServerSocket(6789);
            while (true) {
                Socket connectionSocket = listenSocket.accept();
                DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
                
                // Usando o método de desserialização customizada
                AgendaDeContatos agenda = AgendaDeContatos.readObject(inFromClient);
                
                System.out.println("Recebido: \n");
                System.out.println(agenda.toString());
                
                // A partir daqui, o servidor pode tratar a foto, como salvar o arquivo novamente, por exemplo
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
