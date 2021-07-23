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
public class EntidadesItemVenda {

    private Venda vendaObj;
    private Produto produtoObj;
    private ItemVenda itemVendaObj;
    private ArrayList<EntidadesItemVenda> listaEntidadeItemVenda;

    /**
     * @return the vendaObj
     */
    public Venda getVendaObj() {
        return vendaObj;
    }

    /**
     * @param vendaObj the vendaObj to set
     */
    public void setVendaObj(Venda vendaObj) {
        this.vendaObj = vendaObj;
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
     * @return the itemVendaObj
     */
    public ItemVenda getItemVendaObj() {
        return itemVendaObj;
    }

    /**
     * @param itemVendaObj the itemVendaObj to set
     */
    public void setItemVendaObj(ItemVenda itemVendaObj) {
        this.itemVendaObj = itemVendaObj;
    }

    /**
     * @return the listaEntidadeItemVenda
     */
    public ArrayList<EntidadesItemVenda> getListaEntidadeItemVenda() {
        return listaEntidadeItemVenda;
    }

    /**
     * @param listaEntidadeItemVenda the listaEntidadeItemVenda to set
     */
    public void setListaEntidadeItemVenda(ArrayList<EntidadesItemVenda> listaEntidadeItemVenda) {
        this.listaEntidadeItemVenda = listaEntidadeItemVenda;
    }

    @Override
    public String toString() {
        return "EntidadesItemVenda{" + "vendaObj=" + vendaObj + ", produtoObj=" + produtoObj + ", itemVendaObj=" + itemVendaObj + ", listaEntidadeItemVenda=" + listaEntidadeItemVenda + '}';
    }

}
