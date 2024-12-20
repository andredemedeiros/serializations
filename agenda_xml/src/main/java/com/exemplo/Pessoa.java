package com.exemplo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement(localName = "pessoa") 
public class Pessoa implements Serializable {

    @JacksonXmlProperty(localName = "nome")   
    public String nome;

    @JacksonXmlProperty(localName = "idade")
    public int idade;

    @JacksonXmlProperty(localName = "foto")
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
