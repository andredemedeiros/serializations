import java.io.*;
import java.net.*;
import compra.CompraOuterClass.Compra;
import com.google.protobuf.InvalidProtocolBufferException;

class SerializacaoSimplesCliente {
	public static void main(String argv[]) {
		
		//criar mensagem de compra
		try {
            Compra compra = Compra.newBuilder()
                    .setNomeCliente("André Filipe de Medeiros - 542104")
                    .addAllProdutos(Arrays.asList("Computador Gamer Alienware Aurora R15"))
                    .setValorTotal(1500)
                    .build();

            // Serialize to byte array
            byte[] data = compra.toByteArray();

            // Deserialize from byte array
            Compra deserializedCompra = Compra.parseFrom(data);

            // Print the deserialized message
            System.out.println(deserializedCompra);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }


		//informações da compra
		String nomeCliente = "André Filipe de Medeiros - 542104";
		List<String> produtos = new ArrayList<>();
        produtos.add("Computador Gamer Alienware Aurora R15");
        produtos.add("Teclado Gamer Razer Blackwidow V4");
		produtos.add("Mouse gamer Razer DeathAdder Essential");
        produtos.add("Headset Gamer Sem Fio Logitech G Astro A50 X LIGHTSPEED");
		produtos.add("Cadeira Gamer DT3 Sports Rhino ");
        long valorTotal = 50000;
		Compra compra = new Compra(nomeCliente, produtos, valorTotal);

		System.out.println("Enviado: \n");
		System.out.println(compra.toString());

		//envio ao servidor por socket tcp
		Socket clientSocket;
		try {
			clientSocket = new Socket("localhost", 6789);
			ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
			outToServer.writeObject(compra);
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}