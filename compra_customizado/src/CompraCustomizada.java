import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CompraCustomizada implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public String nomeCliente;
    public List<Produto> produtos;

    public CompraCustomizada(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(String pdNome, float pdValor) {
        Produto pd = new Produto(pdNome, pdValor);
        this.produtos.add(pd);
    }
    
    public void writeObject(DataOutputStream o) throws IOException {
        //nome do cliente
        o.writeUTF(nomeCliente);
        //número de produtos
        o.writeInt(produtos.size());
        //dados de cada produto
        for (Produto produto : produtos) {
            o.writeUTF(produto.nome);  
            o.writeFloat(produto.valor);
        }
    }

    public static CompraCustomizada readObject(DataInputStream o) throws IOException {
        String nomeCli = o.readUTF();
        //nova instância de Compra
        CompraCustomizada compra = new CompraCustomizada(nomeCli);
        //número de produtos
        int numProdutos = o.readInt();
        //adicionar produtos à lista
        for (int i = 0; i < numProdutos; i++) {
            String nomeProduto = o.readUTF();  
            float valorProduto = o.readFloat();
            Produto produto = new Produto(nomeProduto, valorProduto);
            compra.adicionarProduto(nomeProduto, valorProduto);
        }

        return compra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dados da compra:\n");
        sb.append("Nome do cliente: ").append(nomeCliente).append("\n");
        sb.append("------------------------------------\n");
        float total = 0;
        for (Produto pd : produtos) {
            sb.append(pd.toString()).append("\n");
            total += pd.valor;
        }
        sb.append("------------------------------------\n");
        sb.append(String.format("Valor total: %.2f", total)).append("\n");
        return sb.toString();
    }
}
