package com.exemplo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "agendadecontatos") 
public class AgendaDeContatos implements Serializable {

    @JacksonXmlProperty(localName = "nomeAgenda")
    public String nomeAgenda;

    @JacksonXmlProperty(localName = "pessoas")
    public List<Pessoa> pessoas;

    public AgendaDeContatos() {
        this.pessoas = new ArrayList<>();
    }

    public AgendaDeContatos(String nomeAgenda) {
        this.nomeAgenda = nomeAgenda;
        this.pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, byte[] foto) {
        Pessoa pessoa = new Pessoa(nome, idade, foto);
        this.pessoas.add(pessoa);
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
