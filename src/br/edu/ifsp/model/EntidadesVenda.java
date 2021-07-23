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
public class EntidadesVenda {
    
    private Venda vendaObj;
    private Cliente clientesObj;
    private Funcionario funcionariosObj;
    private Parcelamento parcelamentosObj;
    private ArrayList<EntidadesVenda> listaEntidadeVenda;

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
     * @return the funcionariosObj
     */
    public Funcionario getFuncionariosObj() {
        return funcionariosObj;
    }

    /**
     * @param funcionariosObj the funcionariosObj to set
     */
    public void setFuncionariosObj(Funcionario funcionariosObj) {
        this.funcionariosObj = funcionariosObj;
    }

    /**
     * @return the parcelamentosObj
     */
    public Parcelamento getParcelamentosObj() {
        return parcelamentosObj;
    }

    /**
     * @param parcelamentosObj the parcelamentosObj to set
     */
    public void setParcelamentosObj(Parcelamento parcelamentosObj) {
        this.parcelamentosObj = parcelamentosObj;
    }

    /**
     * @return the listaEntidadeVenda
     */
    public ArrayList<EntidadesVenda> getListaEntidadeVenda() {
        return listaEntidadeVenda;
    }

    /**
     * @param listaEntidadeVenda the listaEntidadeVenda to set
     */
    public void setListaEntidadeVenda(ArrayList<EntidadesVenda> listaEntidadeVenda) {
        this.listaEntidadeVenda = listaEntidadeVenda;
    }

    @Override
    public String toString() {
        return "EntidadesVenda{" + "vendaObj=" + vendaObj + ", clientesObj=" + clientesObj + ", funcionariosObj=" + funcionariosObj + ", parcelamentosObj=" + parcelamentosObj + ", listaEntidadeVenda=" + listaEntidadeVenda + '}';
    }
    
}
