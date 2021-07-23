/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.Compra;
import br.edu.ifsp.model.EntidadesCompra;
import br.edu.ifsp.model.Fornecedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Murilo
 */
public class CompraControle {

    private final String SQLinserirCompra = "INSERT INTO compra(codFornecedor, data, total, situacao) VALUES (?, ?, ?, ?)";
    private final String SQLlistar = "SELECT c.codCompra, c.codFornecedor, c.data, c.total, c.situacao, "
            + "f.codFornecedor, f.nomefantasia, f.cnpj, f.endereco, f.numero, f.bairro, f.cidade, f.cep, f.uf, f.telefone, f.telefonesecundario, f.contato, f.contatosecundario "
            + "FROM compra c, fornecedor f WHERE c.codFornecedor = f.codFornecedor ORDER BY c.data DESC, c.codCompra DESC";
    private final String SQLlistarPorNome = "SELECT c.codCompra, c.codFornecedor, c.data, c.total, c.situacao, "
            + "f.codFornecedor, f.nomefantasia, f.cnpj, f.endereco, f.numero, f.bairro, f.cidade, f.cep, f.uf, f.telefone, f.telefonesecundario, f.contato, f.contatosecundario "
            + "FROM compra c, fornecedor f "
            + "WHERE c.codFornecedor = f.codFornecedor "
            + "AND f.nomefantasia LIKE ? "
            + "ORDER BY c.data DESC, c.codCompra DESC";
    private final String SQLlistarPorData = "SELECT c.codCompra, c.codFornecedor, c.data, c.total, c.situacao, "
            + "f.codFornecedor, f.nomefantasia, f.cnpj, f.endereco, f.numero, f.bairro, f.cidade, f.cep, f.uf, f.telefone, f.telefonesecundario, f.contato, f.contatosecundario "
            + "FROM compra c, fornecedor f "
            + "WHERE c.codFornecedor = f.codFornecedor "
            + "AND c.data BETWEEN ? AND ? "
            + "ORDER BY c.data DESC, c.codCompra DESC";
    private final String SQLalterarSituacaoCompra = "UPDATE compra SET situacao=? WHERE codCompra=?";

    public int inserirCompra(Compra compra) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        int codigo = 0;

        try {
            stmt = con.prepareStatement(SQLinserirCompra, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, compra.getCodFornecedor());
            stmt.setDate(2, new Date(compra.getData().getTime()));
            stmt.setDouble(3, compra.getTotal());
            stmt.setString(4, compra.getSituacao());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Os dados da Compra foram salvos!", "Informações de Compra", 1);
            }

            rs = stmt.getGeneratedKeys();

            while (rs.next()) {
                codigo = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!\n" + ex, "Registro de Compra", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
        return codigo;
    }

    public ArrayList<EntidadesCompra> listar() {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<EntidadesCompra> listaEntidadesCompra = new ArrayList<>();
        Compra compra;
        Fornecedor fornecedor;
        EntidadesCompra entidadesCompra;

        try {
            stmt = con.prepareStatement(SQLlistar);

            rs = stmt.executeQuery();

            while (rs.next()) {
                compra = new Compra();
                fornecedor = new Fornecedor();
                entidadesCompra = new EntidadesCompra();

                compra.setCodigo(rs.getInt("c.codCompra"));
                compra.setCodFornecedor(rs.getInt("c.codFornecedor"));
                compra.setData(rs.getDate("c.data"));
                compra.setTotal(rs.getDouble("c.total"));
                compra.setSituacao(rs.getString("c.situacao"));

                fornecedor.setCodigo(rs.getInt("f.codFornecedor"));
                fornecedor.setNomefantasia(rs.getString("f.nomefantasia"));
                fornecedor.setCnpj(rs.getString("f.cnpj"));
                fornecedor.setEndereco(rs.getString("f.endereco"));
                fornecedor.setNumero(rs.getString("f.numero"));
                fornecedor.setBairro(rs.getString("f.bairro"));
                fornecedor.setCidade(rs.getString("f.cidade"));
                fornecedor.setCep(rs.getString("f.cep"));
                fornecedor.setUf(rs.getString("f.uf"));
                fornecedor.setTelefone(rs.getString("f.telefone"));
                fornecedor.setTelefonesecundario(rs.getString("f.telefonesecundario"));
                fornecedor.setContato(rs.getString("f.contato"));
                fornecedor.setContatosecundario(rs.getString("f.contatosecundario"));

                entidadesCompra.setCompraObj(compra);
                entidadesCompra.setFornecedorObj(fornecedor);

                listaEntidadesCompra.add(entidadesCompra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return listaEntidadesCompra;
    }

    public void alterarSituacaoCompra(int codCompra, String situacao) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;
        int adicionado = 0;
        try {
            stmt = con.prepareStatement(SQLalterarSituacaoCompra);

            stmt.setString(1, situacao);
            stmt.setInt(2, codCompra);

            adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                System.out.println("Situação compra atualizada");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar situação compra");
            System.err.println(ex);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public ArrayList<EntidadesCompra> listarPorFornecedor(String text) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<EntidadesCompra> listaEntidadesCompra = new ArrayList<>();
        Compra compra;
        Fornecedor fornecedor;
        EntidadesCompra entidadesCompra;

        try {
            stmt = con.prepareStatement(SQLlistarPorNome);
            stmt.setString(1, "%" + text + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                compra = new Compra();
                fornecedor = new Fornecedor();
                entidadesCompra = new EntidadesCompra();

                compra.setCodigo(rs.getInt("c.codCompra"));
                compra.setCodFornecedor(rs.getInt("c.codFornecedor"));
                compra.setData(rs.getDate("c.data"));
                compra.setTotal(rs.getDouble("c.total"));
                compra.setSituacao(rs.getString("c.situacao"));

                fornecedor.setCodigo(rs.getInt("f.codFornecedor"));
                fornecedor.setNomefantasia(rs.getString("f.nomefantasia"));
                fornecedor.setCnpj(rs.getString("f.cnpj"));
                fornecedor.setEndereco(rs.getString("f.endereco"));
                fornecedor.setNumero(rs.getString("f.numero"));
                fornecedor.setBairro(rs.getString("f.bairro"));
                fornecedor.setCidade(rs.getString("f.cidade"));
                fornecedor.setCep(rs.getString("f.cep"));
                fornecedor.setUf(rs.getString("f.uf"));
                fornecedor.setTelefone(rs.getString("f.telefone"));
                fornecedor.setTelefonesecundario(rs.getString("f.telefonesecundario"));
                fornecedor.setContato(rs.getString("f.contato"));
                fornecedor.setContatosecundario(rs.getString("f.contatosecundario"));

                entidadesCompra.setCompraObj(compra);
                entidadesCompra.setFornecedorObj(fornecedor);

                listaEntidadesCompra.add(entidadesCompra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return listaEntidadesCompra;
    }

    public ArrayList<EntidadesCompra> listarPorData(String dateMin, String dateMax) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<EntidadesCompra> listaEntidadesCompra = new ArrayList<>();
        Compra compra;
        Fornecedor fornecedor;
        EntidadesCompra entidadesCompra;

        try {
            stmt = con.prepareStatement(SQLlistarPorData);
            stmt.setString(1, dateMin);
            stmt.setString(2, dateMax);

            rs = stmt.executeQuery();

            while (rs.next()) {
                compra = new Compra();
                fornecedor = new Fornecedor();
                entidadesCompra = new EntidadesCompra();

                compra.setCodigo(rs.getInt("c.codCompra"));
                compra.setCodFornecedor(rs.getInt("c.codFornecedor"));
                compra.setData(rs.getDate("c.data"));
                compra.setTotal(rs.getDouble("c.total"));
                compra.setSituacao(rs.getString("c.situacao"));

                fornecedor.setCodigo(rs.getInt("f.codFornecedor"));
                fornecedor.setNomefantasia(rs.getString("f.nomefantasia"));
                fornecedor.setCnpj(rs.getString("f.cnpj"));
                fornecedor.setEndereco(rs.getString("f.endereco"));
                fornecedor.setNumero(rs.getString("f.numero"));
                fornecedor.setBairro(rs.getString("f.bairro"));
                fornecedor.setCidade(rs.getString("f.cidade"));
                fornecedor.setCep(rs.getString("f.cep"));
                fornecedor.setUf(rs.getString("f.uf"));
                fornecedor.setTelefone(rs.getString("f.telefone"));
                fornecedor.setTelefonesecundario(rs.getString("f.telefonesecundario"));
                fornecedor.setContato(rs.getString("f.contato"));
                fornecedor.setContatosecundario(rs.getString("f.contatosecundario"));

                entidadesCompra.setCompraObj(compra);
                entidadesCompra.setFornecedorObj(fornecedor);

                listaEntidadesCompra.add(entidadesCompra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return listaEntidadesCompra;
    }
}
