import java.io.*;
import java.net.*;

class Servidor {
    public static void main(String argv[]) {
   
        ServerSocket listenSocket;
        try {
            listenSocket = new ServerSocket(6789);
            System.out.println("Aguardando conexão...");

       
            while (true) {
                Socket connectionSocket = listenSocket.accept();
                System.out.println("Conexão recebida de: " + connectionSocket.getInetAddress());

             
                InputStream inFromClient = connectionSocket.getInputStream();

             
                Agenda.AgendaDeContatos agenda = Agenda.AgendaDeContatos.parseFrom(inFromClient);

                System.out.println("Recebido: \n");
                System.out.println(agenda.toString());

    
                connectionSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
