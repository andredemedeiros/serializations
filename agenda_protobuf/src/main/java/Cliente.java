import java.io.*;
import java.net.*;
import java.nio.file.*;

class Cliente {

    public static void main(String[] args) {
        // Criando a agenda de contatos usando Protobuf
        Agenda.AgendaDeContatos.Builder agendaBuilder = Agenda.AgendaDeContatos.newBuilder();
        agendaBuilder.setNomeAgenda("Agenda de Contatos");

        // Caminho da foto (deve existir no sistema)
        Path fotoPath1 = Paths.get("/home/andre/Documents/distribuidos/serializations/agenda_customizado/bin/foto1.jpg");

        try {
            // Lendo as fotos como arrays de bytes
            byte[] fotoAndre = Files.readAllBytes(fotoPath1);

            // Criando a pessoa e adicionando à agenda
            Agenda.Pessoa andre = Agenda.Pessoa.newBuilder()
                    .setNome("André Filipe de Medeiros")
                    .setIdade(30)
                    .setFoto(com.google.protobuf.ByteString.copyFrom(fotoAndre))
                    .build();

            // Adicionando a pessoa à agenda
            agendaBuilder.addPessoas(andre);

            // Exibindo a agenda no console
            System.out.println("Enviando: \n");
            System.out.println(agendaBuilder.toString());

            // Envio ao servidor por socket TCP
            try (Socket clientSocket = new Socket("localhost", 6789);
                 OutputStream outStream = clientSocket.getOutputStream()) {

                // Serializando a agenda para o formato binário do Protobuf
                agendaBuilder.build().writeTo(outStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
