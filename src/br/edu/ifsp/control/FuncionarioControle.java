/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.Funcionario;
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
public class FuncionarioControle {

    private final String SQLinserir = "INSERT INTO funcionario(nome, cpf, datanascimento, endereco, numero, bairro, cidade, uf, cep, telefone, telefonesecundario, cargo, login, senha, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQLalterar = "UPDATE funcionario SET nome=?, cpf=?, datanascimento=?, endereco=?, numero=?, bairro=?, cidade=?, uf=?, cep=?, telefone=?, telefonesecundario=?, cargo=?, login=?, senha=?, tipo=? WHERE codFuncionario = ?";
    private final String SQLatualzarUltimoAcesso = "UPDATE funcionario SET ultimoacesso=? WHERE codFuncionario = ?";
    private final String SQLlistar = "SELECT * FROM funcionario";
    private final String SQLconsultarCpf = "SELECT * FROM funcionario WHERE cpf LIKE ?";

    public void adicionar(Funcionario funcionario) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLinserir);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setDate(3, new Date(funcionario.getDatanascimento().getTime()));
            stmt.setString(4, funcionario.getEndereco());
            stmt.setString(5, funcionario.getNumero());
            stmt.setString(6, funcionario.getBairro());
            stmt.setString(7, funcionario.getCidade());
            stmt.setString(8, funcionario.getUf());
            stmt.setString(9, funcionario.getCep());
            stmt.setString(10, funcionario.getTelefone());
            stmt.setString(11, funcionario.getTelefonesecundario());
            stmt.setString(12, funcionario.getCargo());

            stmt.setString(13, funcionario.getLogin());
            stmt.setString(14, funcionario.getSenha());
            stmt.setString(15, funcionario.getTipo());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Os dados do Funcionário foram salvos!", "Informações de Funcionário", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!\n" + ex, "Registro de Funcionário", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public ArrayList<Funcionario> listar() {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(SQLlistar);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario fun = new Funcionario();

                fun.setCodigo(rs.getInt("codFuncionario"));
                fun.setNome(rs.getString("nome"));
                fun.setCpf(rs.getString("cpf"));
                fun.setDatanascimento(rs.getDate("datanascimento"));
                fun.setEndereco(rs.getString("endereco"));
                fun.setEndereco(rs.getString("numero"));
                fun.setBairro(rs.getString("bairro"));
                fun.setCidade(rs.getString("cidade"));
                fun.setUf(rs.getString("uf"));
                fun.setCep(rs.getString("cep"));
                fun.setTelefone(rs.getString("telefone"));
                fun.setTelefonesecundario(rs.getString("telefonesecundario"));
                fun.setCargo(rs.getString("cargo"));
                fun.setLogin(rs.getString("login"));
                fun.setSenha(rs.getString("senha"));
                fun.setTipo(rs.getString("tipo"));

                funcionarios.add(fun);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return funcionarios;
    }

    public void atualizar(Funcionario funcionario) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLalterar);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setDate(3, new Date(funcionario.getDatanascimento().getTime()));
            stmt.setString(4, funcionario.getEndereco());
            stmt.setString(5, funcionario.getNumero());
            stmt.setString(6, funcionario.getBairro());
            stmt.setString(7, funcionario.getCidade());
            stmt.setString(8, funcionario.getUf());
            stmt.setString(9, funcionario.getCep());
            stmt.setString(10, funcionario.getTelefone());
            stmt.setString(11, funcionario.getTelefonesecundario());
            stmt.setString(12, funcionario.getCargo());

            stmt.setString(13, funcionario.getLogin());
            stmt.setString(14, funcionario.getSenha());
            stmt.setString(15, funcionario.getTipo());

            stmt.setInt(16, funcionario.getCodigo());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterados!", "Registro de Funcionário", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!\n" + ex, "Registro de Funcionário", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public void altualizarUltimoAcesso(int codusuario) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLatualzarUltimoAcesso);

            stmt.setDate(1, new Date(System.currentTimeMillis()));
            
            stmt.setInt(2, codusuario);

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                System.out.println("Ultimo acesso atualizado! Registro de Funcionário");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Ultimo acesso!\n" + ex, "Registro de Funcionário", 0);
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
            Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }
        return result;
    }

}
