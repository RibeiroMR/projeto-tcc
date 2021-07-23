/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Murilo
 */
public class ServicoControle {

    private final String SQLinserir = "INSERT INTO servico(descricao, preco) VALUES (?, ?)";
    private final String SQLlistar = "SELECT * FROM servico ORDER BY descricao";
    private final String SQLlistarPorDescricao = "SELECT * FROM servico WHERE descricao LIKE ?";
    private final String SQLalterar = "UPDATE servico SET descricao=?, preco=? WHERE codServico=?";

    public void adcionar(Servico servico) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLinserir);

            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(2, servico.getPreco());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do Serviço salvo!", "Informações de Serviço", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!", "Registro de Serviço", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public ArrayList<Servico> listar() {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Servico> servicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(SQLlistar);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Servico srv = new Servico();

                srv.setCodigo(rs.getInt("codServico"));
                srv.setDescricao(rs.getString("descricao"));
                srv.setPreco(rs.getDouble("preco"));

                servicos.add(srv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return servicos;
    }

    public void atualizar(Servico servico) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLalterar);

            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(2, servico.getPreco());
            stmt.setInt(3, servico.getCodigo());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterados!", "Registro de Serviço", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!", "Registro de Serviço", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public ArrayList<Servico> buscarPorDescricao(String descricao) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Servico> servicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(SQLlistarPorDescricao);
            stmt.setString(1, "%" + descricao + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Servico srv = new Servico();

                srv.setCodigo(rs.getInt("codServico"));
                srv.setDescricao(rs.getString("descricao"));
                srv.setPreco(rs.getDouble("preco"));

                servicos.add(srv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return servicos;
    }

    public Servico buscarDescricao(String descricao) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        Servico srv = new Servico();

        try {
            stmt = con.prepareStatement("SELECT * FROM servico WHERE descricao = '" + descricao + "';");

            rs = stmt.executeQuery();

            while (rs.next()) {
                srv.setCodigo(rs.getInt("codServico"));
                srv.setDescricao(rs.getString("descricao"));
                srv.setPreco(rs.getDouble("preco"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return srv;
    }
    
    public Servico buscarCodigo(int codigo) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        Servico srv = new Servico();

        try {
            stmt = con.prepareStatement("SELECT * FROM servico WHERE codServico = " + codigo + ";");

            rs = stmt.executeQuery();

            while (rs.next()) {
                srv.setCodigo(rs.getInt("codServico"));
                srv.setDescricao(rs.getString("descricao"));
                srv.setPreco(rs.getDouble("preco"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return srv;
    }
}
