package com.exemplo;

import java.io.*;
import java.net.*;

public class SerializacaoJsonCliente {
    public static void main(String[] args) {
        // criar a lista de produtos e a compra
        Compra cp = new Compra("André Filipe de Medeiros - 542104");
        
        cp.adicionarProduto("Computador Gamer Alienware Aurora R15", 10000);
        cp.adicionarProduto("Teclado Gamer Razer Blackwidow V4", 1000);
        cp.adicionarProduto("Mouse gamer Razer DeathAdder Essential", 1000);
        cp.adicionarProduto("Headset Gamer Sem Fio Logitech G Astro A50 X LIGHTSPEED", 1000);
        cp.adicionarProduto("Cadeira Gamer DT3 Sports Rhino", 2000);

        // exibir os dados que serão enviados
        System.out.println("Enviando: \n");
        System.out.println(cp.toString());

        // enviar ao servidor por socket TCP
        try (Socket clientSocket = new Socket("localhost", 6789);
             ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream())) {

            outToServer.writeObject(cp);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
