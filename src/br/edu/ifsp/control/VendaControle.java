/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Murilo
 */
public class VendaControle {

//    private final String SQLinserir = "INSERT INTO venda(codCliente, codFuncionario, datapedido, total, qtdpagamento) VALUES (?, ?, ?, ?, ?)";
    private final String SQLinserirComParcelamento = "INSERT INTO venda(codCliente, codFuncionario, codParcelamento, datapedido, subtotal, total, qtdpagamento, juroscalculado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
////    private final String SQLlistar = "SELECT * FROM venda ORDER BY datapedido DESC";
//    private final String SQLalterar = "UPDATE venda SET codFuncionario=?, datapedido=?, subtotal=?, total=? WHERE codVenda = ?";
//    private final String SQLconsultarDataVenda = "SELECT * FROM venda WHERE datapedido BETWEEN ? AND ?";

    public int inserirVendaComParcelamento(Venda obj) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        int codigo = 0;

        try {
            stmt = con.prepareStatement(SQLinserirComParcelamento, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, obj.getCliente());
            stmt.setInt(2, obj.getFuncionario());
            stmt.setInt(3, obj.getParcelamento());
            stmt.setDate(4, new Date(obj.getDataPedido().getTime()));
            stmt.setDouble(5, obj.getSubtotal());
            stmt.setDouble(6, obj.getTotal());
            stmt.setInt(7, obj.getQtdpagamento());
            stmt.setDouble(8, obj.getJuroscalculado());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Os dados da Venda foram salvos!", "Informações de Venda", 1);
            }

            rs = stmt.getGeneratedKeys();

            while (rs.next()) {
                codigo = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!\n" + ex, "Registro de Venda", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
        return codigo;
    }

//    public List<Venda> listar() {
//        Connection con = Conexao.abrir();
//
//        PreparedStatement stmt = null;
//
//        ResultSet rs = null;
//
//        List<Venda> vendas = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement(SQLlistar);
//
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                Venda vd = new Venda();
//
//                vd.setCodigo(rs.getInt("codVenda"));
//                vd.setCliente(rs.getInt("codCliente"));
//                vd.setFuncionario(rs.getInt("codFuncionario"));
//                vd.setParcelamento(rs.getInt("codParcelamento"));
//                vd.setDataPedido(rs.getDate("datapedido"));
//                vd.setSubtotal(rs.getDouble("subtotal"));
//                vd.setTotal(rs.getDouble("total"));
//                vd.setQtdpagamento(rs.getInt("qtdpagamento"));
//
//                vendas.add(vd);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(VendaControle.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            Conexao.fechar(con, stmt, rs);
//        }
//
//        return vendas;
//    }
//    public void alterar(Venda obj) {
//        Connection con = Conexao.abrir();
//
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement(SQLalterar);
//
//            stmt.setInt(1, obj.getFuncionario());
//            stmt.setDate(2, new Date(obj.getDataPedido().getTime()));
//            stmt.setDouble(3, obj.getSubtotal());
//            stmt.setDouble(4, obj.getTotal());
//            stmt.setInt(5, obj.getCodigo());
//
//            int adicionado = stmt.executeUpdate();
//
//            if (adicionado > 0) {
//                JOptionPane.showMessageDialog(null, "Dados Alterados!", "Registro de Venda", 1);
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex);
//            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!\n" + ex, "Registro de Venda", 0);
//        } finally {
//            Conexao.fechar(con, stmt);
//        }
//    }

//    public List<Venda> consultarVendas(String dataMinima, String dataMaxima) {
//        Connection con = Conexao.abrir();
//
//        PreparedStatement stmt = null;
//
//        ResultSet rs = null;
//
//        List<Venda> vendas = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement(SQLconsultarDataVenda);
//            stmt.setString(1, dataMinima);
//            stmt.setString(2, dataMaxima);
//
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                Venda vd = new Venda();
//
//                vd.setCodigo(rs.getInt("codVenda"));
//                vd.setCliente(rs.getInt("codCliente"));
//                vd.setFuncionario(rs.getInt("codFuncionario"));
//                vd.setParcelamento(rs.getInt("codParcelamento"));
//                vd.setDataPedido(rs.getDate("datapedido"));
//                vd.setSubtotal(rs.getDouble("subtotal"));
//                vd.setTotal(rs.getDouble("total"));
//                vd.setQtdpagamento(rs.getInt("qtdpagamento"));
//
//                vendas.add(vd);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(VendaControle.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            Conexao.fechar(con, stmt, rs);
//        }
//        return vendas;
//    }
}
