/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.Cliente;
import br.edu.ifsp.model.EntidadesPagamento;
import br.edu.ifsp.model.Pagamento;
import br.edu.ifsp.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Murilo
 */
public class PagamentoControle {

    private final String SQLinserir = "INSERT INTO pagamento(codVenda, numero, preco, datapagamento, datavencimento, situacao, codFormapagamento) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String SQLlistarPagamentos = "SELECT v.codVenda, v.codCliente, v.codFuncionario, v.codParcelamento, v.datapedido, v.subtotal, v.total, v.qtdpagamento,\n"
            + "c.codCliente, c.nome, c.cpf, c.datanascimento, c.endereco, c.numero, c.bairro, c.cidade, c.uf, c.cep, c.telefone, c.telefonesecundario,\n"
            + "p.codPagamento, p.codVenda, p.numero, p.preco, p.datapagamento, p.datavencimento, p.situacao, p.codFormapagamento\n"
            + "FROM venda v, cliente c, pagamento p\n"
            + "WHERE v.codCliente = c.codCliente AND v.codVenda = p.codVenda AND v.codVenda = ?";
    private final String SQLalterar = "UPDATE pagamento SET datapagamento=?, situacao=?, codFormapagamento=? WHERE codPagamento = ?";
    private final String SQLatualizarsituacao = "UPDATE pagamento SET situacao = 'Atrasado' WHERE situacao = 'Pendente' AND datavencimento < ?;";

    public void inserir(ArrayList<Pagamento> listaObj) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;
        int adicionado = 0;
        int cont = listaObj.size();

        try {
            stmt = con.prepareStatement(SQLinserir);

            for (int i = 0; i < cont; i++) {
                stmt.setInt(1, listaObj.get(i).getVenda());
                stmt.setInt(2, listaObj.get(i).getNumero());
                stmt.setDouble(3, listaObj.get(i).getPreco());
                if (listaObj.get(i).getDatapagamento() == null) {
                    stmt.setNull(4, java.sql.Types.DATE);
                    stmt.setNull(7, java.sql.Types.INTEGER);
                } else {
                    stmt.setDate(4, new Date(listaObj.get(i).getDatapagamento().getTime()));
                    stmt.setInt(7, listaObj.get(i).getFormaPagamento());
                }
                stmt.setDate(5, new Date(listaObj.get(i).getDatavencimento().getTime()));
                stmt.setString(6, listaObj.get(i).getSituacao());

                adicionado = stmt.executeUpdate();
            }
            if (adicionado > 0) {
                System.out.println("Os dados de Pagamento foram salvos!");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao Salvar Dados! - Registro de Pagamento");
            System.err.println(ex);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public void quitarPagamento(Pagamento pagamento) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;
        int adicionado = 0;

        try {
            stmt = con.prepareStatement(SQLalterar);
            stmt.setInt(4, pagamento.getCodigo());

            stmt.setDate(1, new Date(pagamento.getDatapagamento().getTime()));
            stmt.setString(2, pagamento.getSituacao());
            stmt.setInt(3, pagamento.getFormaPagamento());

            adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                System.out.println("Os dados de Pagamento foram salvos!");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao Salvar Dados! - Registro de Pagamento");
            System.err.println(ex);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public void atualizarsituacao() {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;
        int adicionado = 0;

        try {
            stmt = con.prepareStatement(SQLatualizarsituacao);

            stmt.setDate(1, new Date(System.currentTimeMillis()));

            adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                System.out.println("Atualizados! " + adicionado);
            }
            System.out.println("Foi executado a atualização da situação de pagamento!");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Dados! - Registro de Pagamento");
            System.err.println(ex);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public ArrayList<EntidadesPagamento> consultarPagamentoVenda(String codVenda) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<EntidadesPagamento> listaEntidadesPagamento = new ArrayList<>();
        Venda venda;
        Cliente cliente;
        Pagamento pagamento;

        EntidadesPagamento entidadesPagamento;

        try {
            stmt = con.prepareStatement(SQLlistarPagamentos);
            stmt.setString(1, codVenda);

            rs = stmt.executeQuery();

            while (rs.next()) {
                venda = new Venda();
                cliente = new Cliente();
                pagamento = new Pagamento();
                entidadesPagamento = new EntidadesPagamento();

                venda.setCodigo(rs.getInt("v.codVenda"));
                venda.setCliente(rs.getInt("v.codCliente"));
                venda.setFuncionario(rs.getInt("v.codFuncionario"));
                venda.setParcelamento(rs.getInt("v.codParcelamento"));
                venda.setDataPedido(rs.getDate("v.datapedido"));
                venda.setSubtotal(rs.getDouble("v.subtotal"));
                venda.setTotal(rs.getDouble("v.total"));
                venda.setQtdpagamento(rs.getInt("v.qtdpagamento"));

                cliente.setCodigo(rs.getInt("c.codCliente"));
                cliente.setNome(rs.getString("c.nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDatanascimento(rs.getDate("c.datanascimento"));
                cliente.setEndereco(rs.getString("c.endereco"));
                cliente.setEndereco(rs.getString("c.numero"));
                cliente.setBairro(rs.getString("c.bairro"));
                cliente.setCidade(rs.getString("c.cidade"));
                cliente.setUf(rs.getString("c.uf"));
                cliente.setCep(rs.getString("c.cep"));
                cliente.setTelefone(rs.getString("c.telefone"));
                cliente.setTelefonesecundario(rs.getString("c.telefonesecundario"));

                pagamento.setCodigo(rs.getInt("p.codPagamento"));
                pagamento.setVenda(rs.getInt("p.codVenda"));
                pagamento.setNumero(rs.getInt("p.numero"));
                pagamento.setPreco(rs.getDouble("p.preco"));
                pagamento.setDatapagamento(rs.getDate("p.datapagamento"));
                pagamento.setDatavencimento(rs.getDate("p.datavencimento"));
                pagamento.setSituacao(rs.getString("p.situacao"));
                pagamento.setFormaPagamento(rs.getInt("p.codFormapagamento"));

                entidadesPagamento.setVendaObj(venda);
                entidadesPagamento.setClientesObj(cliente);
                entidadesPagamento.setPagamentosObj(pagamento);

                listaEntidadesPagamento.add(entidadesPagamento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return listaEntidadesPagamento;
    }
}
