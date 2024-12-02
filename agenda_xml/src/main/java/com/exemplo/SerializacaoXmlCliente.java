package com.exemplo;

import java.io.*;
import java.net.*;
import java.nio.file.*;

public class SerializacaoXmlCliente {
    public static void main(String[] args) {
        // Criando a agenda de contatos
        AgendaDeContatos agenda = new AgendaDeContatos("Agenda de Contatos");

        // Caminho da foto (deve existir no sistema)
        Path fotoPath1 = Paths.get("/home/andre/Documents/distribuidos/serializations/agenda_xml/src/main/java/com/exemplo/foto1.jpg");

        try {
            // Lendo as fotos como arrays de bytes
            byte[] fotoAndre = Files.readAllBytes(fotoPath1);

            // Adicionando pessoas com as fotos à agenda
            agenda.adicionarPessoa("André Filipe de Medeiros", 30, fotoAndre);

            System.out.println("Enviando: \n");
            System.out.println(agenda.toString());

            // Envio ao servidor por socket TCP
            Socket clientSocket = new Socket("localhost", 6789);
            ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
            
            // Escrever o objeto no fluxo de saída
            outToServer.writeObject(agenda);

            // Certifique-se de que todos os dados foram enviados
            outToServer.flush();  // Força o envio completo da mensagem
            
            // Adicionar uma pequena pausa para garantir que o servidor tenha tempo de ler o objeto
            // Thread.sleep(1000); // Un-comment if needed for testing
            
            // Fechar o socket após garantir que a transmissão foi concluída
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
