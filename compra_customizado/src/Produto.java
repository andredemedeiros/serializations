import java.io.Serializable;

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    public String nome;
    public float valor;

    public Produto(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Produto: %s, Valor: %.2f", nome, valor);
    }

}
