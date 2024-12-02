package com.exemplo;

import java.io.*;
import java.net.*;

public class SerializacaoXmlServidor {
    public static void main(String argv[]) {
        // Recebimento do cliente por socket TCP
        ServerSocket listenSocket;
        try {
            listenSocket = new ServerSocket(6789);
            while (true) {
                Socket connectionSocket = listenSocket.accept();
                ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
                
                // Aguarde a leitura do objeto (try-catch block is already handling IOException)
                AgendaDeContatos agenda = (AgendaDeContatos) inFromClient.readObject();

                System.out.println("Recebido: \n");
                System.out.println(agenda.toString());

                // Fechar os streams e o socket
                inFromClient.close();
                connectionSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
