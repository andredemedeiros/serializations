package com.exemplo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.net.*;

public class SerializacaoXmlCliente {
    public static void main(String[] args) {
        // Criar a lista de produtos e a compra
        Compra cp = new Compra("André Filipe de Medeiros - 542104");
        
        cp.adicionarProduto("Computador Gamer Alienware Aurora R15", 10000);
        cp.adicionarProduto("Teclado Gamer Razer Blackwidow V4", 1000);
        cp.adicionarProduto("Mouse gamer Razer DeathAdder Essential", 1000);
        cp.adicionarProduto("Headset Gamer Sem Fio Logitech G Astro A50 X LIGHTSPEED", 1000);
        cp.adicionarProduto("Cadeira Gamer DT3 Sports Rhino", 2000);

        // Exibir os dados que serão enviados
        System.out.println("Enviando: \n");
        System.out.println(cp.toString());

        // Configurar o XmlMapper para serializar em XML
        XmlMapper xmlMapper = new XmlMapper();

        // Enviar ao servidor por socket TCP
        try (Socket clientSocket = new Socket("localhost", 6789);
             OutputStream outToServer = clientSocket.getOutputStream();
             InputStream inFromServer = clientSocket.getInputStream()) {

            // Serializar o objeto 'cp' para XML
            String xml = xmlMapper.writeValueAsString(cp);
            outToServer.write(xml.getBytes());
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
