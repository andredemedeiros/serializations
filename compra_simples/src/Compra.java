import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String nomeCliente;
	public List<Produto> produtos;

	public Compra(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(String pdNome, float pdValor) {
        Produto pd = new Produto(pdNome, pdValor);
        this.produtos.add(pd);
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
        sb.append(String.format("Valor total: %.2f",total)).append("\n");
        return sb.toString();
    }

}
