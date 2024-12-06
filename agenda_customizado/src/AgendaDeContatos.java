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

 
    public void writeObject(DataOutputStream o) throws IOException {
       
        o.writeUTF(nomeAgenda);
       
        o.writeInt(pessoas.size());
        
        for (Pessoa pessoa : pessoas) {
            o.writeUTF(pessoa.nome);  
            o.writeInt(pessoa.idade);
            o.writeInt(pessoa.foto.length);  
            o.write(pessoa.foto); 
        }
    }


    public static AgendaDeContatos readObject(DataInputStream o) throws IOException {
        String nomeAgenda = o.readUTF();  
    
        AgendaDeContatos agenda = new AgendaDeContatos(nomeAgenda);
      
        int numPessoas = o.readInt();
      
        for (int i = 0; i < numPessoas; i++) {
            String nomePessoa = o.readUTF(); 
            int idadePessoa = o.readInt(); 
            int fotoLength = o.readInt(); 
            byte[] foto = new byte[fotoLength];
            o.readFully(foto); 
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
