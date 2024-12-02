package com.exemplo;

import java.io.*;
import java.net.*;
import java.nio.file.*;


public class SerializacaoJsonCliente {
    public static void main(String[] args) {
        // Criando a agenda de contatos
        AgendaDeContatos agenda = new AgendaDeContatos("Agenda de Contatos");

        // Caminho da foto (deve existir no sistema)
        Path fotoPath1 = Paths.get("/home/andre/Documents/distribuidos/serializations/agenda_json/src/main/java/com/exemplo/foto1.jpg");
        //Path fotoPath2 = Paths.get("foto_maria1.jpg");

        try {
            // Lendo as fotos como arrays de bytes
            byte[] fotoAndre = Files.readAllBytes(fotoPath1);
            //byte[] fotoMaria = Files.readAllBytes(fotoPath2);

            // Adicionando pessoas com as fotos à agenda
            agenda.adicionarPessoa("André Filipe de Medeiros", 30, fotoAndre);
            //agenda.adicionarPessoa("Maria Oliveira", 25, fotoMaria);

            System.out.println("Enviando: \n");
            System.out.println(agenda.toString());

            // Envio ao servidor por socket TCP
            Socket clientSocket;
            clientSocket = new Socket("localhost", 6789);
            ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
            outToServer.writeObject(agenda);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
