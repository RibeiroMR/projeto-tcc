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
public class ComprovanteVenda {

    private String tipo;
    private String descricao;
    private String quantidade;
    private Double precounitario;
    private Double precototal;

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the decricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the decricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the precounitario
     */
    public Double getPrecounitario() {
        return precounitario;
    }

    /**
     * @param precounitario the precounitario to set
     */
    public void setPrecounitario(Double precounitario) {
        this.precounitario = precounitario;
    }

    /**
     * @return the precototal
     */
    public Double getPrecototal() {
        return precototal;
    }

    /**
     * @param precototal the precototal to set
     */
    public void setPrecototal(Double precototal) {
        this.precototal = precototal;
    }

}
