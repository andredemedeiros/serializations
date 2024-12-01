package com.exemplo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement(localName = "produto") // Custom XML root element name
public class Produto implements Serializable {

    @JacksonXmlProperty(localName = "nome")   // Specify XML element name for the field
    public String nome;

    @JacksonXmlProperty(localName = "valor")
    public float valor;

    public Produto() {
        // Default constructor for Jackson
    }

    public Produto(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Produto: %s, Valor: %.2f", nome, valor);
    }
}
