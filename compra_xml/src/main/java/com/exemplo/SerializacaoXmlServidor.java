package com.exemplo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.net.*;

public class SerializacaoXmlServidor {
    public static void main(String[] args) {
        // recebimento do cliente por socket TCP
        ServerSocket listenSocket;
        try {
            listenSocket = new ServerSocket(6789);
            while (true) {
                Socket connectionSocket = listenSocket.accept();
                InputStream inFromClient = connectionSocket.getInputStream();
                OutputStream outToClient = connectionSocket.getOutputStream();

                // configurar o XmlMapper para deserializar XML
                XmlMapper xmlMapper = new XmlMapper();
                Compra cp = xmlMapper.readValue(inFromClient, Compra.class);  // deserializa o XML para o objeto Compra

                System.out.println("Recebido: \n");
                System.out.println(cp.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
