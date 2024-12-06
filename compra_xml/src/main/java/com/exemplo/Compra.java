package com.exemplo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "compra") 
public class Compra implements Serializable {

    @JacksonXmlProperty(localName = "nomeCliente")
    public String nomeCliente;

    @JacksonXmlProperty(localName = "produtos")
    public List<Produto> produtos;

    public Compra() {
        this.produtos = new ArrayList<>();
    }

    public Compra(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(String nome, float valor) {
        Produto produto = new Produto(nome, valor);
        this.produtos.add(produto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dados da compra:\n");
        sb.append("Nome do cliente: ").append(nomeCliente).append("\n");
        sb.append("------------------------------------\n");
        float total = 0;
        for (Produto produto : produtos) {
            sb.append(produto.toString()).append("\n");
            total += produto.valor;
        }
        sb.append("------------------------------------\n");
        sb.append(String.format("Valor total: %.2f", total)).append("\n");
        return sb.toString();
    }
}
