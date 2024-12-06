import java.io.*;
import java.net.*;
import java.nio.file.*;

class SerializacaoCustomizadaCliente {
    public static void main(String argv[]) {
        
        AgendaDeContatos agenda = new AgendaDeContatos("Agenda de Contatos");

        
        Path fotoPath1 = Paths.get("foto1.jpg");
      

        try {
        
            byte[] fotoAndre = Files.readAllBytes(fotoPath1);



            agenda.adicionarPessoa("André Filipe de Medeiros", 30, fotoAndre);
        

            SerializationUtil.writeObjectToFile("teste.data", agenda);
            
            System.out.println("Enviando: \n");
            System.out.println(agenda.toString());

          
            Socket clientSocket;
            clientSocket = new Socket("localhost", 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            agenda.writeObject(outToServer);  
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
