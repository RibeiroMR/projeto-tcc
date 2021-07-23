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
public class EntidadesItemCompra {
    
    private Compra compraObj;
    private Produto produtoObj;
    private ItemCompra itemCompraObj;
    private ArrayList<EntidadesItemCompra> listaEntidadeItemConpra;

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
     * @return the produtoObj
     */
    public Produto getProdutoObj() {
        return produtoObj;
    }

    /**
     * @param produtoObj the produtoObj to set
     */
    public void setProdutoObj(Produto produtoObj) {
        this.produtoObj = produtoObj;
    }

    /**
     * @return the itemCompraObj
     */
    public ItemCompra getItemCompraObj() {
        return itemCompraObj;
    }

    /**
     * @param itemCompraObj the itemCompraObj to set
     */
    public void setItemCompraObj(ItemCompra itemCompraObj) {
        this.itemCompraObj = itemCompraObj;
    }

    /**
     * @return the listaEntidadeItemConpra
     */
    public ArrayList<EntidadesItemCompra> getListaEntidadeItemConpra() {
        return listaEntidadeItemConpra;
    }

    /**
     * @param listaEntidadeItemConpra the listaEntidadeItemConpra to set
     */
    public void setListaEntidadeItemConpra(ArrayList<EntidadesItemCompra> listaEntidadeItemConpra) {
        this.listaEntidadeItemConpra = listaEntidadeItemConpra;
    }

    @Override
    public String toString() {
        return "EntidadesItemCompra{" + "compraObj=" + compraObj + ", produtoObj=" + produtoObj + ", itemCompraObj=" + itemCompraObj + ", listaEntidadeItemConpra=" + listaEntidadeItemConpra + '}';
    }

}
