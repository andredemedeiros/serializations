package com.exemplo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgendaDeContatos implements Serializable {

    @JsonProperty("nomeAgenda")
    public String nomeAgenda;

    @JsonProperty("pessoas")
    public List<Pessoa> pessoas;

    public AgendaDeContatos() {
        // Construtor padrão é necessário para o Jackson
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
