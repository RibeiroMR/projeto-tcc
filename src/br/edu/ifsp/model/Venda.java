/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.model;

import java.util.Date;

/**
 *
 * @author Murilo
 */
public class Venda {
    
    private int codigo;
    private int cliente;
    private int funcionario;
    private int parcelamento;
    private Date dataPedido;
    private Double subtotal;
    private Double total;
    private int qtdpagamento;
    private Double juroscalculado;

    public Venda() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }

    public int getParcelamento() {
        return parcelamento;
    }

    public void setParcelamento(int parcelamento) {
        this.parcelamento = parcelamento;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getQtdpagamento() {
        return qtdpagamento;
    }

    public void setQtdpagamento(int qtdpagamento) {
        this.qtdpagamento = qtdpagamento;
    }

    public Double getJuroscalculado() {
        return juroscalculado;
    }

    public void setJuroscalculado(Double juroscalculado) {
        this.juroscalculado = juroscalculado;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", cliente=" + cliente + ", funcionario=" + funcionario + ", parcelamento=" + parcelamento + ", dataPedido=" + dataPedido + ", subtotal=" + subtotal + ", total=" + total + ", qtdpagamento=" + qtdpagamento + '}';
    }    
    
}
