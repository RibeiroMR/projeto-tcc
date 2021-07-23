/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.model;

import java.util.ArrayList;

/**
 *
 * @author Murilo
 */
public class EntidadesCompra {
    
    private Compra compraObj;
    private Fornecedor fornecedorObj;
    private ArrayList<EntidadesCompra> listaEntidadeCompras;

    public EntidadesCompra() {
    }

    /**
     * @return the compraObj
     */
    public Compra getCompraObj() {
        return compraObj;
    }

    /**
     * @param compraObj the compraObj to set
     */
    public void setCompraObj(Compra compraObj) {
        this.compraObj = compraObj;
    }

    /**
     * @return the fornecedorObj
     */
    public Fornecedor getFornecedorObj() {
        return fornecedorObj;
    }

    /**
     * @param fornecedorObj the fornecedorObj to set
     */
    public void setFornecedorObj(Fornecedor fornecedorObj) {
        this.fornecedorObj = fornecedorObj;
    }

    /**
     * @return the listaEntidadeCompras
     */
    public ArrayList<EntidadesCompra> getListaEntidadeCompras() {
        return listaEntidadeCompras;
    }

    /**
     * @param listaEntidadeCompras the listaEntidadeCompras to set
     */
    public void setListaEntidadeCompras(ArrayList<EntidadesCompra> listaEntidadeCompras) {
        this.listaEntidadeCompras = listaEntidadeCompras;
    }

    @Override
    public String toString() {
        return "EntidadesCompra{" + "compraObj=" + compraObj + ", fornecedorObj=" + fornecedorObj + ", listaEntidadeCompras=" + listaEntidadeCompras + '}';
    }
    
}
