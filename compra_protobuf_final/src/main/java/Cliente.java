import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        //Produto.newBuilder()
        // Create a Compra object with products
        CompraOuterClass.Compra.Builder compraBuilder = CompraOuterClass.Compra.newBuilder();
        compraBuilder.setNomeCliente("André Filipe de Medeiros - 542104");

        // Add products to the Compra
        compraBuilder.addProdutos(CompraOuterClass.Produto.newBuilder().setNome("Computador Gamer Alienware Aurora R15").setValor(10000.0f).build());
        compraBuilder.addProdutos(CompraOuterClass.Produto.newBuilder().setNome("Teclado Gamer Razer Blackwidow V4").setValor(1000.0f).build());
        compraBuilder.addProdutos(CompraOuterClass.Produto.newBuilder().setNome("Mouse gamer Razer DeathAdder Essential").setValor(1000.0f).build());
        compraBuilder.addProdutos(CompraOuterClass.Produto.newBuilder().setNome("Headset Gamer Sem Fio Logitech G Astro A50 X LIGHTSPEED").setValor(1000.0f).build());
        compraBuilder.addProdutos(CompraOuterClass.Produto.newBuilder().setNome("Cadeira Gamer DT3 Sports Rhino").setValor(2000.0f).build());

        CompraOuterClass.Compra compra = compraBuilder.build();
        System.out.println("Enviando: \n");
        System.out.println(compra);

        try (Socket socket = new Socket("localhost", 6789)) {
            OutputStream outputStream = socket.getOutputStream();
            compra.writeTo(outputStream);  // Write the protobuf object to output stream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}