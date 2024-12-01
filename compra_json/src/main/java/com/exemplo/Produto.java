package com.exemplo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Produto implements Serializable {

    @JsonProperty("nome")   // Anotação para definir como o campo será mapeado no JSON
    public String nome;

    @JsonProperty("valor")
    public float valor;

    public Produto() {
        // Construtor padrão é necessário para o Jackson
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
