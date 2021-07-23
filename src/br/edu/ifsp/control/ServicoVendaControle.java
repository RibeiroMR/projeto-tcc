/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.EntidadesServicoVenda;
import br.edu.ifsp.model.Servico;
import br.edu.ifsp.model.ServicoVenda;
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
public class ServicoVendaControle {

    private final String SQLinserir = "INSERT INTO servicovenda(codVenda, codServico, subtotal, quantidade) VALUES (?, ?, ?, ?)";
//    private final String SQLlistar = "SELECT * FROM servicovenda";
//    private final String SQLalterar = "UPDATE itemvenda SET subtotal=?, quantidade=? WHERE codVenda = ? AND codServico = ?";
    private final String SQLlistarServicoVenda = "SELECT s.codServico, s.descricao, s.preco, sv.codVenda, sv.codServico, sv.subtotal, sv.quantidade\n"
            + "FROM venda v, servico s, servicovenda sv \n"
            + "WHERE v.codVenda = sv.codVenda\n"
            + "AND sv.codServico = s.codServico AND v.codVenda = ?";

    public void inserir(ArrayList<ServicoVenda> listaObj) {
        Connection con = Conexao.abrir();
        PreparedStatement stmt = null;
        int adicionado = 0;
        int cont = listaObj.size();

        try {
            stmt = con.prepareStatement(SQLinserir);

            for (int i = 0; i < cont; i++) {
                stmt.setInt(1, listaObj.get(i).getVenda());
                stmt.setInt(2, listaObj.get(i).getServico());
                stmt.setDouble(3, listaObj.get(i).getSubtotal());
                stmt.setDouble(4, listaObj.get(i).getQuantidade());

                adicionado = stmt.executeUpdate();
            }

            if (adicionado > 0) {
                System.out.println("Os dados de Serviços da Venda foram salvos!");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!\n" + ex, "Registro de Serviços da Venda", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public ArrayList<EntidadesServicoVenda> listarServicosVenda(String codigoVenda) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<EntidadesServicoVenda> listaEntidadesVenda = new ArrayList<>();
        Servico sv;
        ServicoVenda servicoVenda;
        EntidadesServicoVenda entidadesServicoVenda;

        try {
            stmt = con.prepareStatement(SQLlistarServicoVenda);
            stmt.setString(1, codigoVenda);

            rs = stmt.executeQuery();

            while (rs.next()) {
                sv = new Servico();
                servicoVenda = new ServicoVenda();
                entidadesServicoVenda = new EntidadesServicoVenda();

                sv.setCodigo(rs.getInt("codServico"));
                sv.setDescricao(rs.getString("descricao"));
                sv.setPreco(rs.getDouble("preco"));

                servicoVenda.setVenda(rs.getInt("codVenda"));
                servicoVenda.setServico(rs.getInt("codServico"));
                servicoVenda.setQuantidade(rs.getDouble("quantidade"));
                servicoVenda.setSubtotal(rs.getDouble("subtotal"));

                entidadesServicoVenda.setServicoObj(sv);
                entidadesServicoVenda.setServicoVendaObj(servicoVenda);

                listaEntidadesVenda.add(entidadesServicoVenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoVendaControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return listaEntidadesVenda;
    }
    
//    public List<ServicoVenda> listar() {
//        Connection con = Conexao.abrir();
//
//        PreparedStatement stmt = null;
//
//        ResultSet rs = null;
//
//        List<ServicoVenda> servicosvenda = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement(SQLlistar);
//
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                ServicoVenda svvd = new ServicoVenda();
//
//                svvd.setVenda(rs.getInt("codVenda"));
//                svvd.setServico(rs.getInt("codServico"));
//                svvd.setSubtotal(rs.getDouble("subtotal"));
//                svvd.setQuantidade(rs.getDouble("quantidade"));
//
//                servicosvenda.add(svvd);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ServicoVendaControle.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            Conexao.fechar(con, stmt, rs);
//        }
//
//        return servicosvenda;
//    }
    

//    public void alterar(ServicoVenda obj) {
//        Connection con = Conexao.abrir();
//
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement(SQLalterar);
//
//            stmt.setDouble(1, obj.getSubtotal());
//            stmt.setDouble(2, obj.getQuantidade());
//            stmt.setInt(3, obj.getVenda());
//            stmt.setInt(4, obj.getServico());
//
//            int adicionado = stmt.executeUpdate();
//
//            if (adicionado > 0) {
//                System.out.println("Dados alterados para Serviços da Venda!");
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex);
//            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!\n" + ex, "Registro de Serviços da Venda", 0);
//        } finally {
//            Conexao.fechar(con, stmt);
//        }
//    }
}
