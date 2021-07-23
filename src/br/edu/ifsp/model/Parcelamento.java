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
public class Parcelamento {
    
    private int codigo;
    private int quantidademinima;
    private int quantidademaxima;
    private Double jurospercentual;

    public Parcelamento() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidademinima() {
        return quantidademinima;
    }

    public void setQuantidademinima(int quantidademinima) {
        this.quantidademinima = quantidademinima;
    }

    public int getQuantidademaxima() {
        return quantidademaxima;
    }

    public void setQuantidademaxima(int quantidademaxima) {
        this.quantidademaxima = quantidademaxima;
    }

    public Double getJurospercentual() {
        return jurospercentual;
    }

    public void setJurospercentual(Double jurospercentual) {
        this.jurospercentual = jurospercentual;
    }

    @Override
    public String toString() {
        return "Parcelamento{" + "codigo=" + codigo + ", quantidademinima=" + quantidademinima + ", quantidademaxima=" + quantidademaxima + ", jurospercentual=" + jurospercentual + '}';
    }
            
}
