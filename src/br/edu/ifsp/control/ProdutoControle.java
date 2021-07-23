/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Murilo
 */
public class ProdutoControle {

    private final String SQLinserir = "INSERT INTO produto(descricao, marca, modelo, preco, precoreal, estoque, estoqueminimo) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String SQLlistar = "SELECT * FROM produto ORDER BY descricao";
    private final String SQLlistarPorDescricao = "SELECT * FROM produto WHERE descricao LIKE ?";
    private final String SQLalterar = "UPDATE produto SET descricao=?, marca=?, modelo=?, preco=?, precoreal=?, estoque=?, estoqueminimo=? WHERE codProduto=?";
    private final String SQLalterarProdutoLista = "UPDATE produto SET estoque=? WHERE codProduto=?";

    public int adicionar(Produto produto) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        int codigo = 0;

        try {
            stmt = con.prepareStatement(SQLinserir, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, produto.getDescricao());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getModelo());
            stmt.setDouble(4, produto.getPreco());
            stmt.setDouble(5, produto.getPrecoreal());
            stmt.setDouble(6, produto.getEstoque());
            stmt.setDouble(7, produto.getEstoqueminimo());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do produto salvo!", "Informações de Produto", 1);
            }

            rs = stmt.getGeneratedKeys();

            while (rs.next()) {
                codigo = rs.getInt(1);
            }

            System.out.println("Codigo gerado pelo insert foi " + codigo);
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!", "Registro de Produto", 0);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return codigo;
    }

    public ArrayList<Produto> listar() {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(SQLlistar);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto pr = new Produto();

                pr.setCodigo(rs.getInt("codProduto"));
                pr.setDescricao(rs.getString("descricao"));
                pr.setMarca(rs.getString("marca"));
                pr.setModelo(rs.getString("modelo"));
                pr.setPreco(rs.getDouble("preco"));
                pr.setPrecoreal(rs.getDouble("precoreal"));
                pr.setEstoque(rs.getDouble("estoque"));
                pr.setEstoqueminimo(rs.getDouble("estoqueminimo"));

                produtos.add(pr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return produtos;
    }

    public void atualizar(Produto produto) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(SQLalterar);

            stmt.setString(1, produto.getDescricao());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getModelo());
            stmt.setDouble(4, produto.getPreco());
            stmt.setDouble(5, produto.getPrecoreal());
            stmt.setDouble(6, produto.getEstoque());
            stmt.setDouble(7, produto.getEstoqueminimo());
            stmt.setInt(8, produto.getCodigo());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterado!", "Registro de Produto", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!", "Registro de Produto", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public Produto buscarPorNome(String descricao) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        Produto pr = new Produto();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao = '" + descricao + "';");

            rs = stmt.executeQuery();

            while (rs.next()) {
                pr.setCodigo(rs.getInt("codProduto"));
                pr.setDescricao(rs.getString("descricao"));
                pr.setMarca(rs.getString("marca"));
                pr.setModelo(rs.getString("modelo"));
                pr.setPreco(rs.getDouble("preco"));
                pr.setPrecoreal(rs.getDouble("precoreal"));
                pr.setEstoque(rs.getDouble("estoque"));
                pr.setEstoqueminimo(rs.getDouble("estoqueminimo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return pr;
    }

    public Produto buscarPorCodigo(String codigo) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        Produto pr = new Produto();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE codProduto = " + codigo + ";");

            rs = stmt.executeQuery();

            while (rs.next()) {
                pr.setCodigo(rs.getInt("codProduto"));
                pr.setDescricao(rs.getString("descricao"));
                pr.setMarca(rs.getString("marca"));
                pr.setModelo(rs.getString("modelo"));
                pr.setPreco(rs.getDouble("preco"));
                pr.setPrecoreal(rs.getDouble("precoreal"));
                pr.setEstoque(rs.getDouble("estoque"));
                pr.setEstoqueminimo(rs.getDouble("estoqueminimo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return pr;
    }

    public ArrayList<Produto> buscarPorDescricao(String descricao) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(SQLlistarPorDescricao);
            stmt.setString(1, "%" + descricao + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto pr = new Produto();

                pr.setCodigo(rs.getInt("codProduto"));
                pr.setDescricao(rs.getString("descricao"));
                pr.setMarca(rs.getString("marca"));
                pr.setModelo(rs.getString("modelo"));
                pr.setPreco(rs.getDouble("preco"));
                pr.setPrecoreal(rs.getDouble("precoreal"));
                pr.setEstoque(rs.getDouble("estoque"));
                pr.setEstoqueminimo(rs.getDouble("estoqueminimo"));

                produtos.add(pr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return produtos;
    }

    public void alterarEstoqueLista(List<Produto> listaProdutos) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;
        int adicionado = 0;
        try {
            stmt = con.prepareStatement(SQLalterarProdutoLista);

            for (int i = 0; i < listaProdutos.size(); i++) {

                stmt.setDouble(1, listaProdutos.get(i).getEstoque());
                stmt.setInt(2, listaProdutos.get(i).getCodigo());

                adicionado = stmt.executeUpdate();
            }

            if (adicionado > 0) {
                System.out.println("Estoque atualizado");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar estoque");
            System.err.println(ex);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }
}
