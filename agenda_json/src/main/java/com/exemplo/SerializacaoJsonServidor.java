package com.exemplo;

import java.io.*;
import java.net.*;

public class SerializacaoJsonServidor {
    public static void main(String argv[]) {

        ServerSocket listenSocket;
        try {
            listenSocket = new ServerSocket(6789);
            while (true) {
                Socket connectionSocket = listenSocket.accept();
                ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());

                AgendaDeContatos agenda = (AgendaDeContatos) inFromClient.readObject();

                System.out.println("Recebido: \n");
                System.out.println(agenda.toString());

     
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
