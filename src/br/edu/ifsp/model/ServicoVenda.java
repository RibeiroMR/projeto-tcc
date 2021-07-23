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
public class ServicoVenda {
    
    private int venda;
    private int servico;
    private Double subtotal;
    private Double quantidade;

    public ServicoVenda() {
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public int getServico() {
        return servico;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ServicoVenda{" + "venda=" + venda + ", servico=" + servico + ", subtotal=" + subtotal + ", quantidade=" + quantidade + '}';
    }
    
}
