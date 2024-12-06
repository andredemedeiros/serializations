import java.io.*;
import java.net.*;

class SerializacaoCustomizadaServidor {
    public static void main(String argv[]) {
     
        ServerSocket listenSocket;
        try {
            listenSocket = new ServerSocket(6789);
            while (true) {
                Socket connectionSocket = listenSocket.accept();
                DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
                

                AgendaDeContatos agenda = AgendaDeContatos.readObject(inFromClient);
                
                System.out.println("Recebido: \n");
                System.out.println(agenda.toString());
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
