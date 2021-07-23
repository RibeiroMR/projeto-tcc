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
public class Usuario {

    private String login;
    private String senha;
    private String ultimoacesso;
    private String tipo;

    public Usuario() {
    }
       
    public Usuario(String login, String senha, String tipo) {
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUltimoacesso() {
        return ultimoacesso;
    }

    public void setUltimoacesso(String ultimoacesso) {
        this.ultimoacesso = ultimoacesso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "login=" + login + ", senha=" + senha + ", ultimoacesso=" + ultimoacesso + ", tipo=" + tipo + '}';
    }
        
}
