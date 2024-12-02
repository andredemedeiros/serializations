import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6789)) {
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    InputStream inputStream = socket.getInputStream();
                    CompraOuterClass.Compra compra = CompraOuterClass.Compra.parseFrom(inputStream);  // Read protobuf object from input stream
                    System.out.println("Recebido: \n");
                    System.out.println(compra);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}