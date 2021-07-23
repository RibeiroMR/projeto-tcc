/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.model;

import java.time.LocalDateTime;

/**
 *
 * @author Murilo
 */
public class Acesso {

    private int codAcesso;
    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;
    private int codFuncionario;

    /**
     * @return the codAcesso
     */
    public int getCodAcesso() {
        return codAcesso;
    }

    /**
     * @param codAcesso the codAcesso to set
     */
    public void setCodAcesso(int codAcesso) {
        this.codAcesso = codAcesso;
    }

    /**
     * @return the horarioEntrada
     */
    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    /**
     * @param horarioEntrada the horarioEntrada to set
     */
    public void setHorarioEntrada(LocalDateTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    /**
     * @return the horarioSaida
     */
    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    /**
     * @param horarioSaida the horarioSaida to set
     */
    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    /**
     * @return the codFuncionario
     */
    public int getCodFuncionario() {
        return codFuncionario;
    }

    /**
     * @param codFuncionario the codFuncionario to set
     */
    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

}
