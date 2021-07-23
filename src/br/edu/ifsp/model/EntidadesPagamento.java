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
public class EntidadesPagamento {
    
    private Venda vendaObj;
    private Cliente clientesObj;
    private Pagamento pagamentosObj;
    private ArrayList<EntidadesPagamento> listaEntidadePagamento;

    public EntidadesPagamento() {
    }

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
     * @return the clientesObj
     */
    public Cliente getClientesObj() {
        return clientesObj;
    }

    /**
     * @param clientesObj the clientesObj to set
     */
    public void setClientesObj(Cliente clientesObj) {
        this.clientesObj = clientesObj;
    }

    /**
     * @return the pagamentosObj
     */
    public Pagamento getPagamentosObj() {
        return pagamentosObj;
    }

    /**
     * @param pagamentosObj the pagamentosObj to set
     */
    public void setPagamentosObj(Pagamento pagamentosObj) {
        this.pagamentosObj = pagamentosObj;
    }

    /**
     * @return the listaEntidadePagamento
     */
    public ArrayList<EntidadesPagamento> getListaEntidadePagamento() {
        return listaEntidadePagamento;
    }

    /**
     * @param listaEntidadePagamento the listaEntidadePagamento to set
     */
    public void setListaEntidadePagamento(ArrayList<EntidadesPagamento> listaEntidadePagamento) {
        this.listaEntidadePagamento = listaEntidadePagamento;
    }

    @Override
    public String toString() {
        return "EntidadesPagamento{" + "vendaObj=" + vendaObj + ", clientesObj=" + clientesObj + ", pagamentosObj=" + pagamentosObj + ", listaEntidadePagamento=" + listaEntidadePagamento + '}';
    }
    
}
