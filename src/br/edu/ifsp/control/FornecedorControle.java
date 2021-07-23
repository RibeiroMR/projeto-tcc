/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.Fornecedor;
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
public class FornecedorControle {

    private final String SQLinserir = "INSERT INTO fornecedor(nomefantasia, cnpj, endereco, numero, bairro, cidade, cep, uf, telefone, telefonesecundario, contato, contatosecundario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQLalterar = "UPDATE fornecedor SET nomefantasia=?, cnpj=?, endereco=?, numero=?, bairro=?, cidade=?, cep=?, uf=?, telefone=?, telefonesecundario=?, contato=?, contatosecundario=? WHERE codFornecedor=?";
    private final String SQLlistar = "SELECT * FROM fornecedor";
    private final String SQLlistarPorNome = "SELECT * FROM fornecedor WHERE nomefantasia LIKE ?";
    private final String SQLconsultarCnpj = "SELECT * FROM fornecedor WHERE cnpj LIKE ?";

    public void adicionar(Fornecedor fornecedor) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLinserir);

            stmt.setString(1, fornecedor.getNomefantasia());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getNumero());
            stmt.setString(5, fornecedor.getBairro());
            stmt.setString(6, fornecedor.getCidade());
            stmt.setString(7, fornecedor.getCep());
            stmt.setString(8, fornecedor.getUf());
            stmt.setString(9, fornecedor.getTelefone());
            stmt.setString(10, fornecedor.getTelefonesecundario());
            stmt.setString(11, fornecedor.getContato());
            stmt.setString(12, fornecedor.getContatosecundario());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do Fornecedor foram salvo!", "Informações de Fornecedor", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!", "Registro de Fornecedor", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public ArrayList<Fornecedor> listar() {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            stmt = con.prepareStatement(SQLlistar);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fn = new Fornecedor();

                fn.setCodigo(rs.getInt("codFornecedor"));
                fn.setNomefantasia(rs.getString("nomefantasia"));
                fn.setCnpj(rs.getString("cnpj"));
                fn.setEndereco(rs.getString("endereco"));
                fn.setNumero(rs.getString("numero"));
                fn.setBairro(rs.getString("bairro"));
                fn.setCidade(rs.getString("cidade"));
                fn.setCep(rs.getString("cep"));
                fn.setUf(rs.getString("uf"));
                fn.setTelefone(rs.getString("telefone"));
                fn.setTelefonesecundario(rs.getString("telefonesecundario"));
                fn.setContato(rs.getString("contato"));
                fn.setContatosecundario(rs.getString("contatosecundario"));

                fornecedores.add(fn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return fornecedores;
    }

    public void atualizar(Fornecedor fornecedor) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLalterar);

            stmt.setString(1, fornecedor.getNomefantasia());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getNumero());
            stmt.setString(5, fornecedor.getBairro());
            stmt.setString(6, fornecedor.getCidade());
            stmt.setString(7, fornecedor.getCep());
            stmt.setString(8, fornecedor.getUf());
            stmt.setString(9, fornecedor.getTelefone());
            stmt.setString(10, fornecedor.getTelefonesecundario());
            stmt.setString(11, fornecedor.getContato());
            stmt.setString(12, fornecedor.getContatosecundario());
            stmt.setInt(13, fornecedor.getCodigo());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterados!", "Registro de Fornecedor", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!", "Registro de Fornecedor", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public boolean consultarCnpj(String cnpj) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        boolean result = false;

        try {
            stmt = con.prepareStatement(SQLconsultarCnpj);
            stmt.setString(1, "%" + cnpj + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }
        return result;
    }

    public Fornecedor buscarPorNome(String nome) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        Fornecedor fornecedor = new Fornecedor();
        
        try {
            stmt = con.prepareStatement(SQLlistarPorNome);
            stmt.setString(1, "%" + nome + "%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {           
                fornecedor.setCodigo(rs.getInt("codFornecedor"));
                fornecedor.setNomefantasia(rs.getString("nomefantasia"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getString("numero"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setUf(rs.getString("uf"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setTelefonesecundario(rs.getString("telefonesecundario"));
                fornecedor.setContato(rs.getString("contato"));                
                fornecedor.setContatosecundario(rs.getString("contatosecundario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }
        return fornecedor;
    }

}
