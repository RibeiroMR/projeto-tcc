/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.EntidadesItemCompra;
import br.edu.ifsp.model.ItemCompra;
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
public class ItemCompraControle {

    private final String SQLinserir = "INSERT INTO itemcompra(codCompra, codProduto, quantidade, subtotal) VALUES (?, ?, ?, ?)";
    private final String SQLlistarItensVenda = "SELECT p.codProduto, p.descricao, p.marca, p.modelo, p.preco, p.precoreal, p.estoque, ic.codCompra, ic.codProduto, ic.quantidade, ic.subtotal\n"
            + "FROM compra c, produto p, itemcompra ic \n"
            + "WHERE c.codCompra = ic.codCompra\n"
            + "AND ic.codProduto = p.codProduto AND c.codCompra = ?";
    
    public void inserir(ArrayList<ItemCompra> listaItemCompra) {
        Connection con = Conexao.abrir();
        PreparedStatement stmt = null;
        int adicionado = 0;
        int cont = listaItemCompra.size();

        try {
            stmt = con.prepareStatement(SQLinserir);

            for (int i = 0; i < cont; i++) {
                stmt.setInt(1, listaItemCompra.get(i).getCodCompra());
                stmt.setInt(2, listaItemCompra.get(i).getCodProduto());
                stmt.setDouble(3, listaItemCompra.get(i).getQuantidade());
                stmt.setDouble(4, listaItemCompra.get(i).getSubtotal());

                adicionado = stmt.executeUpdate();
            }
            if (adicionado > 0) {
                System.out.println("Os dados de Compra foram salvos!");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!\n" + ex, "Registro de Itens da Compra", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }
    
    public ArrayList<EntidadesItemCompra> listarItensCompra(String codigoCompra) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<EntidadesItemCompra> listaEntidadesItemCompra = new ArrayList<>();
        Produto pr;
        ItemCompra itenCompra;
        EntidadesItemCompra entidadesItemCompra;
        
        try {
            stmt = con.prepareStatement(SQLlistarItensVenda);
            stmt.setString(1, codigoCompra);

            rs = stmt.executeQuery();

            while (rs.next()) {
                pr = new Produto();
                itenCompra = new ItemCompra();
                entidadesItemCompra = new EntidadesItemCompra();
                        
                pr.setCodigo(rs.getInt("codProduto"));
                pr.setDescricao(rs.getString("descricao"));
                pr.setMarca(rs.getString("marca"));
                pr.setModelo(rs.getString("modelo"));
                pr.setPreco(rs.getDouble("preco"));
                pr.setPrecoreal(rs.getDouble("precoreal"));
                pr.setEstoque(rs.getDouble("estoque"));
                
                itenCompra.setCodCompra(rs.getInt("codCompra"));
                itenCompra.setCodProduto(rs.getInt("codProduto"));
                itenCompra.setQuantidade(rs.getDouble("quantidade"));
                itenCompra.setSubtotal(rs.getDouble("subtotal"));
                
                entidadesItemCompra.setProdutoObj(pr);
                entidadesItemCompra.setItemCompraObj(itenCompra);

                listaEntidadesItemCompra.add(entidadesItemCompra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemCompraControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return listaEntidadesItemCompra;
    }
    
}
