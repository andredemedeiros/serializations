package com.exemplo;

import java.io.*;
import java.net.*;
import java.nio.file.*;


public class SerializacaoJsonCliente {
    public static void main(String[] args) {
       
        AgendaDeContatos agenda = new AgendaDeContatos("Agenda de Contatos");

       
        Path fotoPath1 = Paths.get("/home/andre/Documents/distribuidos/serializations/agenda_json/src/main/java/com/exemplo/foto1.jpg");


        try {
  
            byte[] fotoAndre = Files.readAllBytes(fotoPath1);
            

            agenda.adicionarPessoa("André Filipe de Medeiros", 30, fotoAndre);
          

            System.out.println("Enviando: \n");
            System.out.println(agenda.toString());


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
