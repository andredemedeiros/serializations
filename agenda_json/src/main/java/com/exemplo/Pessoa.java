package com.exemplo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Pessoa implements Serializable {

    @JsonProperty("nome")   
    public String nome;

    @JsonProperty("idade")
    public int idade;

    @JsonProperty("foto")
    public byte[] foto;

    public Pessoa() {
        
    }

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
