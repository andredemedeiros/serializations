import java.io.*;
import java.net.*;
import java.nio.file.*;

class SerializacaoCustomizadaCliente {
    public static void main(String argv[]) {
        // Criando a agenda de contatos
        AgendaDeContatos agenda = new AgendaDeContatos("Agenda de Contatos");

        // Caminho da foto (deve existir no sistema)
        Path fotoPath1 = Paths.get("foto1.jpg");
        //Path fotoPath2 = Paths.get("foto_maria1.jpg");

        try {
            // Lendo as fotos como arrays de bytes
            byte[] fotoAndre = Files.readAllBytes(fotoPath1);
            //byte[] fotoMaria = Files.readAllBytes(fotoPath2);

            // Adicionando pessoas à agenda
            agenda.adicionarPessoa("André Filipe de Medeiros", 30, fotoAndre);
            //agenda.adicionarPessoa("Maria Oliveira", 25, fotoMaria);

            SerializationUtil.writeObjectToFile("teste.data", agenda);
            
            System.out.println("Enviando: \n");
            System.out.println(agenda.toString());

            // Envio ao servidor por socket TCP com serialização customizada
            Socket clientSocket;
            clientSocket = new Socket("localhost", 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            agenda.writeObject(outToServer);  // Serialização customizada
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
