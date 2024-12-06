package com.exemplo;

import java.io.*;
import java.net.*;

public class SerializacaoJsonServidor {
    public static void main(String[] args) {
        // recebimento do cliente por socket TCP
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
