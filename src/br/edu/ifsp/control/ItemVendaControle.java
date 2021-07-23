/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.EntidadesItemVenda;
import br.edu.ifsp.model.ItemVenda;
import br.edu.ifsp.model.Produto;
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
public class ItemVendaControle {

    private final String SQLinserir = "INSERT INTO itemvenda(codVenda, codProduto, quantidade, subtotal) VALUES (?, ?, ?, ?)";
//    private final String SQLlistar = "SELECT * FROM itemvenda";
//    private final String SQLalterar = "UPDATE itemvenda SET quantidade=?, subtotal=? WHERE codVenda = ? AND codProduto = ?";
    private final String SQLlistarItensVenda = "SELECT p.codProduto, p.descricao, p.marca, p.modelo, p.preco, p.precoreal, p.estoque, iv.codVenda, iv.codProduto, iv.quantidade, iv.subtotal\n"
            + "FROM venda v, produto p, itemvenda iv \n"
            + "WHERE v.codVenda = iv.codVenda\n"
            + "AND iv.codProduto = p.codProduto AND v.codVenda = ?";

    public void inserir(ArrayList<ItemVenda> listaObj) {
        Connection con = Conexao.abrir();
        PreparedStatement stmt = null;
        int adicionado = 0;
        int cont = listaObj.size();

        try {
            stmt = con.prepareStatement(SQLinserir);

            for (int i = 0; i < cont; i++) {
                stmt.setInt(1, listaObj.get(i).getVenda());
                stmt.setInt(2, listaObj.get(i).getProduto());
                stmt.setDouble(3, listaObj.get(i).getQuantidade());
                stmt.setDouble(4, listaObj.get(i).getSubtotal());

                adicionado = stmt.executeUpdate();
            }
            if (adicionado > 0) {
                System.out.println("Os dados de Item da Venda foram salvos!");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!\n" + ex, "Registro de Itens da Venda", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public ArrayList<EntidadesItemVenda> listarItensVenda(String codigoVenda) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<EntidadesItemVenda> listaEntidadesVenda = new ArrayList<>();
        Produto pr;
        ItemVenda itenVenda;
        EntidadesItemVenda entidadesItemVenda;
        
        try {
            stmt = con.prepareStatement(SQLlistarItensVenda);
            stmt.setString(1, codigoVenda);

            rs = stmt.executeQuery();

            while (rs.next()) {
                pr = new Produto();
                itenVenda = new ItemVenda();
                entidadesItemVenda = new EntidadesItemVenda();
                        
                pr.setCodigo(rs.getInt("codProduto"));
                pr.setDescricao(rs.getString("descricao"));
                pr.setMarca(rs.getString("marca"));
                pr.setModelo(rs.getString("modelo"));
                pr.setPreco(rs.getDouble("preco"));
                pr.setPrecoreal(rs.getDouble("precoreal"));
                pr.setEstoque(rs.getDouble("estoque"));
                
                itenVenda.setVenda(rs.getInt("codVenda"));
                itenVenda.setProduto(rs.getInt("codProduto"));
                itenVenda.setQuantidade(rs.getDouble("quantidade"));
                itenVenda.setSubtotal(rs.getDouble("subtotal"));
                
                entidadesItemVenda.setProdutoObj(pr);
                entidadesItemVenda.setItemVendaObj(itenVenda);

                listaEntidadesVenda.add(entidadesItemVenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return listaEntidadesVenda;
    }

//    public void alterar(ItemVenda obj) {
//        Connection con = Conexao.abrir();
//
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement(SQLalterar);
//
//            stmt.setDouble(1, obj.getQuantidade());
//            stmt.setDouble(2, obj.getSubtotal());
//            stmt.setInt(3, obj.getVenda());
//            stmt.setInt(4, obj.getProduto());
//
//            int adicionado = stmt.executeUpdate();
//
//            if (adicionado > 0) {
//                System.out.println("Dados alterados para Itens da Venda!");
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex);
//            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!\n" + ex, "Registro de Itens da Venda", 0);
//        } finally {
//            Conexao.fechar(con, stmt);
//        }
//    }
}
