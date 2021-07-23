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
public class EntidadesServicoVenda {
    
    private Venda vendaObj;
    private Servico servicoObj;
    private ServicoVenda servicoVendaObj;
    private ArrayList<EntidadesServicoVenda> listaEntidadeServicoVenda;

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
     * @return the servicoObj
     */
    public Servico getServicoObj() {
        return servicoObj;
    }

    /**
     * @param servicoObj the servicoObj to set
     */
    public void setServicoObj(Servico servicoObj) {
        this.servicoObj = servicoObj;
    }

    /**
     * @return the servicoVendaObj
     */
    public ServicoVenda getServicoVendaObj() {
        return servicoVendaObj;
    }

    /**
     * @param servicoVendaObj the servicoVendaObj to set
     */
    public void setServicoVendaObj(ServicoVenda servicoVendaObj) {
        this.servicoVendaObj = servicoVendaObj;
    }

    /**
     * @return the listaEntidadeServicoVenda
     */
    public ArrayList<EntidadesServicoVenda> getListaEntidadeServicoVenda() {
        return listaEntidadeServicoVenda;
    }

    /**
     * @param listaEntidadeServicoVenda the listaEntidadeServicoVenda to set
     */
    public void setListaEntidadeServicoVenda(ArrayList<EntidadesServicoVenda> listaEntidadeServicoVenda) {
        this.listaEntidadeServicoVenda = listaEntidadeServicoVenda;
    }

    @Override
    public String toString() {
        return "EntidadesServicoVenda{" + "vendaObj=" + vendaObj + ", servicoObj=" + servicoObj + ", servicoVendaObj=" + servicoVendaObj + ", listaEntidadeServicoVenda=" + listaEntidadeServicoVenda + '}';
    }
    
}
