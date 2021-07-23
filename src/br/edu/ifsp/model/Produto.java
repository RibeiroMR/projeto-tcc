/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.model;

/**
 *
 * @author Murilo
 */
public class Produto {
    
    
    private int codigo;
    private String descricao;
    private String marca;
    private String modelo;
    private Double preco;
    private Double precoreal;
    private Double estoque;
    private Double estoqueminimo;

    public Produto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPrecoreal() {
        return precoreal;
    }

    public void setPrecoreal(Double precoreal) {
        this.precoreal = precoreal;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public Double getEstoqueminimo() {
        return estoqueminimo;
    }

    public void setEstoqueminimo(Double estoqueminimo) {
        this.estoqueminimo = estoqueminimo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.codigo;
        return hash;
    }

    @Override
    public String toString() {
        return descricao + "; " + modelo + "; Marca: " + marca + "; R$ " + preco;
    }
    
}
