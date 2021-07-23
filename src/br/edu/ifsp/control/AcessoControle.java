/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.Acesso;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murilo
 */
public class AcessoControle {

    private final String SQLinserir = "INSERT INTO acesso(horarioEntrada, codFuncionario) VALUES (?, ?)";
    private final String SQLupdate = "UPDATE acesso SET horarioSaida=? WHERE codAcesso=? AND codFuncionario=?";

    public int inserirEntrada(Acesso acesso) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;
        
        ResultSet rs = null;

        int codigo = 0;
        
        try {
            stmt = con.prepareStatement(SQLinserir, Statement.RETURN_GENERATED_KEYS);            

            stmt.setTimestamp(1, Timestamp.valueOf(acesso.getHorarioEntrada()));
            stmt.setInt(2, acesso.getCodFuncionario());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                System.out.println("Os dados de Acesso salvos! Informações de Acesso");
            }
            
            rs = stmt.getGeneratedKeys();
            
            while (rs.next()) {
                codigo = rs.getInt(1);
            }            
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!\n" + ex, "Registro de Acesso", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
        
        return codigo;
    }

    public void atualizarSaida(Acesso acesso) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLupdate);            

            stmt.setTimestamp(1, Timestamp.valueOf(acesso.getHorarioEntrada()));
            stmt.setInt(2, acesso.getCodAcesso());
            stmt.setInt(3, acesso.getCodFuncionario());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                System.out.println("Os dados de Saida atualizado! Informações de Acesso");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar Dados!\n" + ex, "Registro de Acesso", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

}
