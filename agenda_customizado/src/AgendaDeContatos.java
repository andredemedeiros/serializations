import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDeContatos implements Serializable {
    private static final long serialVersionUID = 1L;

    public String nomeAgenda;
    public List<Pessoa> pessoas;

    public AgendaDeContatos(String nomeAgenda) {
        this.nomeAgenda = nomeAgenda;
        this.pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, byte[] foto) {
        Pessoa pessoa = new Pessoa(nome, idade, foto);
        this.pessoas.add(pessoa);
    }

    // Método de serialização customizada
    public void writeObject(DataOutputStream o) throws IOException {
        // Grava o nome da agenda
        o.writeUTF(nomeAgenda);
        // Grava o número de pessoas
        o.writeInt(pessoas.size());
        // Grava os dados de cada pessoa
        for (Pessoa pessoa : pessoas) {
            o.writeUTF(pessoa.nome);  // Grava o nome da pessoa
            o.writeInt(pessoa.idade);  // Grava a idade da pessoa
            o.writeInt(pessoa.foto.length);  // Grava o tamanho da foto
            o.write(pessoa.foto);  // Grava os bytes da foto
        }
    }

    // Método de desserialização customizada
    public static AgendaDeContatos readObject(DataInputStream o) throws IOException {
        String nomeAgenda = o.readUTF();  // Lê o nome da agenda
        // Cria uma nova instância de AgendaDeContatos
        AgendaDeContatos agenda = new AgendaDeContatos(nomeAgenda);
        // Lê o número de pessoas na agenda
        int numPessoas = o.readInt();
        // Lê cada pessoa e adiciona à lista
        for (int i = 0; i < numPessoas; i++) {
            String nomePessoa = o.readUTF();  // Lê o nome da pessoa
            int idadePessoa = o.readInt();  // Lê a idade da pessoa
            int fotoLength = o.readInt();  // Lê o tamanho da foto
            byte[] foto = new byte[fotoLength];
            o.readFully(foto);  // Lê os bytes da foto
            agenda.adicionarPessoa(nomePessoa, idadePessoa, foto);
        }
        return agenda;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agenda de Contatos: ").append(nomeAgenda).append("\n");
        sb.append("------------------------------------\n");
        for (Pessoa pessoa : pessoas) {
            sb.append(pessoa.toString()).append("\n");
        }
        sb.append("------------------------------------\n");
        return sb.toString();
    }
}
