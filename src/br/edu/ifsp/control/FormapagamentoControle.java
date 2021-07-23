/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.FormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Murilo
 */
public class FormapagamentoControle {

    private final String SQLinserir = "INSERT INTO formapagamento(forma, descricao) VALUES (?, ?)";
    private final String SQLlistar = "SELECT * FROM formapagamento";
    private final String SQLbuscarCodigoFormaPagamento = "SELECT * FROM formapagamento WHERE codFormapagamento = ?";
    private final String SQLalterar = "UPDATE formapagamento SET forma=?, descricao=? WHERE codFormapagamento=?";

    public void adicionar(FormaPagamento formaPagamento) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLinserir);

            stmt.setString(1, formaPagamento.getForma());
            stmt.setString(2, formaPagamento.getDescricao());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do Forma de Pagamento salvo!", "Informações de Forma de Pagamento", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!", "Registro de Forma de Pagamento", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public ArrayList<FormaPagamento> listar() {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<FormaPagamento> formaspagamentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(SQLlistar);

            rs = stmt.executeQuery();

            while (rs.next()) {
                FormaPagamento fp = new FormaPagamento();

                fp.setCodigo(rs.getInt("codFormapagamento"));
                fp.setForma(rs.getString("forma"));
                fp.setDescricao(rs.getString("descricao"));

                formaspagamentos.add(fp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return formaspagamentos;
    }

    public void atualizar(FormaPagamento formaPagamento) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLalterar);

            stmt.setString(1, formaPagamento.getForma());
            stmt.setString(2, formaPagamento.getDescricao());
            stmt.setInt(3, formaPagamento.getCodigo());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterados!", "Registro de Forma de Pagamento", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!", "Registro de Forma de Pagamento", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public FormaPagamento buscarCodigoFormaPagamento(String formaPagamento) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        FormaPagamento fp = new FormaPagamento();

        try {
            stmt = con.prepareStatement(SQLbuscarCodigoFormaPagamento);
            stmt.setString(1, formaPagamento);

            rs = stmt.executeQuery();

            while (rs.next()) {
                fp.setCodigo(rs.getInt("codFormapagamento"));
                fp.setForma(rs.getString("forma"));
                fp.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return fp;
    }
}
