package com.exemplo;

import java.io.*;
import java.net.*;

public class SerializacaoJsonServidor {
    public static void main(String argv[]) {
        // Recebimento do cliente por socket TCP
        ServerSocket listenSocket;
        try {
            listenSocket = new ServerSocket(6789);
            while (true) {
                Socket connectionSocket = listenSocket.accept();
                ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
                ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
                AgendaDeContatos agenda = (AgendaDeContatos) inFromClient.readObject();

                System.out.println("Recebido: \n");
                System.out.println(agenda.toString());

                // A partir daqui, o servidor pode tratar a foto, como salvar o arquivo novamente, por exemplo
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
