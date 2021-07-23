/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.Cliente;
import java.sql.Connection;
import java.sql.Date;
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
public class ClienteControle {

    private final String SQLinserir = "INSERT INTO cliente(nome, cpf, datanascimento, endereco, numero, bairro, cidade, uf, cep, telefone, telefonesecundario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQLalterar = "UPDATE cliente SET nome=?, cpf=?, datanascimento=?, endereco=?, numero=?, bairro=?, cidade=?, uf=?, cep=?, telefone=?, telefonesecundario=? WHERE codCliente = ?";
    private final String SQLlistar = "SELECT * FROM cliente ORDER BY nome";
    private final String SQLlistarPorNome = "SELECT * FROM cliente WHERE nome LIKE ? ORDER BY nome";
    private final String SQLconsultarCpf = "SELECT * FROM cliente WHERE cpf LIKE ?";

    public void adiconar(Cliente cliente) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLinserir);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setDate(3, new Date(cliente.getDatanascimento().getTime()));
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getNumero());
            stmt.setString(6, cliente.getBairro());
            stmt.setString(7, cliente.getCidade());
            stmt.setString(8, cliente.getUf());
            stmt.setString(9, cliente.getCep());
            stmt.setString(10, cliente.getTelefone());
            stmt.setString(11, cliente.getTelefonesecundario());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Os dados do Cliente foram salvos!", "Informações de Cliente", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!\n" + ex, "Registro de Cliente", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public ArrayList<Cliente> listar() {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(SQLlistar);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cl = new Cliente();

                cl.setCodigo(rs.getInt("codCliente"));
                cl.setNome(rs.getString("nome"));
                cl.setCpf(rs.getString("cpf"));
                cl.setDatanascimento(rs.getDate("datanascimento"));
                cl.setEndereco(rs.getString("endereco"));
                cl.setNumero(rs.getString("numero"));
                cl.setBairro(rs.getString("bairro"));
                cl.setCidade(rs.getString("cidade"));
                cl.setUf(rs.getString("uf"));
                cl.setCep(rs.getString("cep"));
                cl.setTelefone(rs.getString("telefone"));
                cl.setTelefonesecundario(rs.getString("telefonesecundario"));

                clientes.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return clientes;
    }

    public void atualizar(Cliente cliente) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLalterar);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setDate(3, new Date(cliente.getDatanascimento().getTime()));
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getNumero());
            stmt.setString(6, cliente.getBairro());
            stmt.setString(7, cliente.getCidade());
            stmt.setString(8, cliente.getUf());
            stmt.setString(9, cliente.getCep());
            stmt.setString(10, cliente.getTelefone());
            stmt.setString(11, cliente.getTelefonesecundario());
            stmt.setInt(12, cliente.getCodigo());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterados!", "Registro de Cliente", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!\n" + ex, "Registro de Cliente", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public boolean consultarCpf(String cpf) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        boolean result = false;

        try {
            stmt = con.prepareStatement(SQLconsultarCpf);
            stmt.setString(1, "%" + cpf + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }
        return result;
    }

    public Cliente buscarPorNome(String nome) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        Cliente cl = new Cliente();

        try {
            stmt = con.prepareStatement(SQLlistarPorNome);
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                cl.setCodigo(rs.getInt("codCliente"));
                cl.setNome(rs.getString("nome"));
                cl.setCpf(rs.getString("cpf"));
                cl.setDatanascimento(rs.getDate("datanascimento"));
                cl.setEndereco(rs.getString("endereco"));
                cl.setEndereco(rs.getString("numero"));
                cl.setBairro(rs.getString("bairro"));
                cl.setCidade(rs.getString("cidade"));
                cl.setUf(rs.getString("uf"));
                cl.setCep(rs.getString("cep"));
                cl.setTelefone(rs.getString("telefone"));
                cl.setTelefonesecundario(rs.getString("telefonesecundario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt);
        }
        return cl;
    }
}
