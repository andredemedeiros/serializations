import java.io.Serializable;

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    public String nome;
    public int idade;
    public byte[] foto;  // A foto será armazenada como um array de bytes

    public Pessoa(String nome, int idade, byte[] foto) {
        this.nome = nome;
        this.idade = idade;
        this.foto = foto;
    }

    @Override
    public String toString() {
        return String.format("Pessoa: %s, Idade: %d, Foto: %d bytes", nome, idade, foto.length);
    }
}
