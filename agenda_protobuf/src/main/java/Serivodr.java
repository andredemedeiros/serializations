import java.io.*;
import java.net.*;

class Servidor {
    public static void main(String argv[]) {
        // Recebimento do cliente por socket TCP
        ServerSocket listenSocket;
        try {
            listenSocket = new ServerSocket(6789);
            System.out.println("Aguardando conexão...");

            // Aceitando a conexão do cliente
            while (true) {
                Socket connectionSocket = listenSocket.accept();
                System.out.println("Conexão recebida de: " + connectionSocket.getInetAddress());

                // Lendo o fluxo de dados binários do socket
                InputStream inFromClient = connectionSocket.getInputStream();

                // Deserializando os dados do Protobuf para um objeto AgendaDeContatos
                Agenda.AgendaDeContatos agenda = Agenda.AgendaDeContatos.parseFrom(inFromClient);

                // Exibindo a agenda recebida
                System.out.println("Recebido: \n");
                System.out.println(agenda.toString());

                // Fechando a conexão com o cliente
                connectionSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
