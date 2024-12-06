import java.io.*;
import java.net.*;
import java.nio.file.*;

class Cliente {

    public static void main(String[] args) {

        Agenda.AgendaDeContatos.Builder agendaBuilder = Agenda.AgendaDeContatos.newBuilder();
        agendaBuilder.setNomeAgenda("Agenda de Contatos");


        Path fotoPath1 = Paths.get("/home/andre/Documents/distribuidos/serializations/agenda_customizado/bin/foto1.jpg");

        try {

            byte[] fotoAndre = Files.readAllBytes(fotoPath1);


            Agenda.Pessoa andre = Agenda.Pessoa.newBuilder()
                    .setNome("André Filipe de Medeiros")
                    .setIdade(30)
                    .setFoto(com.google.protobuf.ByteString.copyFrom(fotoAndre))
                    .build();


            agendaBuilder.addPessoas(andre);


            System.out.println("Enviando: \n");
            System.out.println(agendaBuilder.toString());


            try (Socket clientSocket = new Socket("localhost", 6789);
                 OutputStream outStream = clientSocket.getOutputStream()) {

              
                agendaBuilder.build().writeTo(outStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
