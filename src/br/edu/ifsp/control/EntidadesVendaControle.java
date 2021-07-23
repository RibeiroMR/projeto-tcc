/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.Cliente;
import br.edu.ifsp.model.EntidadesVenda;
import br.edu.ifsp.model.Funcionario;
import br.edu.ifsp.model.Parcelamento;
import br.edu.ifsp.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Murilo
 */
public class EntidadesVendaControle {

    private final String SQLlistar = "SELECT v.codVenda, v.codCliente, v.codFuncionario, v.codParcelamento, v.datapedido, v.subtotal, v.total, v.qtdpagamento, v.juroscalculado,\n"
            + "c.codCliente, c.nome, c.cpf, c.datanascimento, c.endereco, c.numero, c.bairro, c.cidade, c.uf, c.cep, c.telefone, c.telefonesecundario,\n"
            + "f.codFuncionario, f.nome, f.cpf, f.datanascimento, f.endereco, f.numero, f.bairro, f.cidade, f.cep, f.uf, f.telefone, f.telefonesecundario, f.cargo, f.login, f.senha, f.ultimoacesso, f.tipo,\n"
            + "p.codParcelamento, p.qtdminima, p.qtdmaxima, p.jurospercentual\n"
            + "FROM venda v, cliente c, funcionario f, parcelamento p "
            + "WHERE v.codCliente = c.codCliente "
            + "AND v.codFuncionario = f.codFuncionario "
            + "AND v.codParcelamento = p.codParcelamento "
            + "ORDER BY v.datapedido DESC, v.codvenda DESC";

    private final String SQLconsultar = "SELECT v.codVenda, v.codCliente, v.codFuncionario, v.codParcelamento, v.datapedido, v.subtotal, v.total, v.qtdpagamento, v.juroscalculado,\n"
            + "c.codCliente, c.nome, c.cpf, c.datanascimento, c.endereco, c.numero, c.bairro, c.cidade, c.uf, c.cep, c.telefone, c.telefonesecundario,\n"
            + "f.codFuncionario, f.nome, f.cpf, f.datanascimento, f.endereco, f.numero, f.bairro, f.cidade, f.cep, f.uf, f.telefone, f.telefonesecundario, f.cargo, f.login, f.senha, f.ultimoacesso, f.tipo,\n"
            + "p.codParcelamento, p.qtdminima, p.qtdmaxima, p.jurospercentual\n"
            + "FROM venda v, cliente c, funcionario f, parcelamento p "
            + "WHERE v.codCliente = c.codCliente "
            + "AND v.codFuncionario = f.codFuncionario "
            + "AND v.codParcelamento = p.codParcelamento "
            + "AND v.datapedido BETWEEN ? AND ? "
            + "ORDER BY v.datapedido DESC, v.codvenda DESC";

    private final String SQLconsultarNomeCliente = "SELECT v.codVenda, v.codCliente, v.codFuncionario, v.codParcelamento, v.datapedido, v.subtotal, v.total, v.qtdpagamento, v.juroscalculado,\n"
            + "c.codCliente, c.nome, c.cpf, c.datanascimento, c.endereco, c.numero, c.bairro, c.cidade, c.uf, c.cep, c.telefone, c.telefonesecundario,\n"
            + "f.codFuncionario, f.nome, f.cpf, f.datanascimento, f.endereco, f.numero, f.bairro, f.cidade, f.cep, f.uf, f.telefone, f.telefonesecundario, f.cargo, f.login, f.senha, f.ultimoacesso, f.tipo,\n"
            + "p.codParcelamento, p.qtdminima, p.qtdmaxima, p.jurospercentual\n"
            + "FROM venda v, cliente c, funcionario f, parcelamento p "
            + "WHERE v.codCliente = c.codCliente "
            + "AND v.codFuncionario = f.codFuncionario "
            + "AND v.codParcelamento = p.codParcelamento "
            + "AND c.nome LIKE ? "
            + "ORDER BY v.datapedido DESC, v.codvenda DESC";

    public ArrayList<EntidadesVenda> listar() {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<EntidadesVenda> listaEntidadesVenda = new ArrayList<>();
        Venda venda;
        Cliente cliente;
        Funcionario funcionario;
        Parcelamento parcelamento;
        EntidadesVenda entidadesVenda;

        try {
            stmt = con.prepareStatement(SQLlistar);

            rs = stmt.executeQuery();

            while (rs.next()) {
                venda = new Venda();
                cliente = new Cliente();
                funcionario = new Funcionario();
                parcelamento = new Parcelamento();
                entidadesVenda = new EntidadesVenda();

                venda.setCodigo(rs.getInt("v.codVenda"));
                venda.setCliente(rs.getInt("v.codCliente"));
                venda.setFuncionario(rs.getInt("v.codFuncionario"));
                venda.setParcelamento(rs.getInt("v.codParcelamento"));
                venda.setDataPedido(rs.getDate("v.datapedido"));
                venda.setSubtotal(rs.getDouble("v.subtotal"));
                venda.setTotal(rs.getDouble("v.total"));
                venda.setQtdpagamento(rs.getInt("v.qtdpagamento"));
                venda.setJuroscalculado(rs.getDouble("v.juroscalculado"));

                cliente.setCodigo(rs.getInt("c.codCliente"));
                cliente.setNome(rs.getString("c.nome"));
                cliente.setCpf(rs.getString("c.cpf"));
                cliente.setDatanascimento(rs.getDate("c.datanascimento"));
                cliente.setEndereco(rs.getString("c.endereco"));
                cliente.setNumero(rs.getString("c.numero"));
                cliente.setBairro(rs.getString("c.bairro"));
                cliente.setCidade(rs.getString("c.cidade"));
                cliente.setUf(rs.getString("c.uf"));
                cliente.setCep(rs.getString("c.cep"));
                cliente.setTelefone(rs.getString("c.telefone"));
                cliente.setTelefonesecundario(rs.getString("c.telefonesecundario"));

                funcionario.setCodigo(rs.getInt("f.codFuncionario"));
                funcionario.setNome(rs.getString("f.nome"));
                funcionario.setCpf(rs.getString("f.cpf"));
                funcionario.setDatanascimento(rs.getDate("f.datanascimento"));
                funcionario.setEndereco(rs.getString("f.endereco"));
                funcionario.setEndereco(rs.getString("f.numero"));
                funcionario.setBairro(rs.getString("f.bairro"));
                funcionario.setCidade(rs.getString("f.cidade"));
                funcionario.setUf(rs.getString("f.uf"));
                funcionario.setCep(rs.getString("f.cep"));
                funcionario.setTelefone(rs.getString("f.telefone"));
                funcionario.setTelefonesecundario(rs.getString("f.telefonesecundario"));
                funcionario.setCargo(rs.getString("f.cargo"));
                funcionario.setLogin(rs.getString("f.login"));
                funcionario.setSenha(rs.getString("f.senha"));
                funcionario.setTipo(rs.getString("f.tipo"));

                parcelamento.setCodigo(rs.getInt("p.codParcelamento"));
                parcelamento.setQuantidademinima(rs.getInt("p.qtdminima"));
                parcelamento.setQuantidademaxima(rs.getInt("p.qtdmaxima"));
                parcelamento.setJurospercentual(rs.getDouble("p.jurospercentual"));

                entidadesVenda.setVendaObj(venda);
                entidadesVenda.setClientesObj(cliente);
                entidadesVenda.setFuncionariosObj(funcionario);
                entidadesVenda.setParcelamentosObj(parcelamento);

                listaEntidadesVenda.add(entidadesVenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return listaEntidadesVenda;
    }

    public ArrayList<EntidadesVenda> consultarVendas(String dataMinima, String dataMaxima) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<EntidadesVenda> listaEntidadesVenda = new ArrayList<>();
        Venda venda;
        Cliente cliente;
        Funcionario funcionario;
        Parcelamento parcelamento;
        EntidadesVenda entidadesVenda;

        try {
            stmt = con.prepareStatement(SQLconsultar);
            stmt.setString(1, dataMinima);
            stmt.setString(2, dataMaxima);

            rs = stmt.executeQuery();

            while (rs.next()) {
                venda = new Venda();
                cliente = new Cliente();
                funcionario = new Funcionario();
                parcelamento = new Parcelamento();
                entidadesVenda = new EntidadesVenda();

                venda.setCodigo(rs.getInt("v.codVenda"));
                venda.setCliente(rs.getInt("v.codCliente"));
                venda.setFuncionario(rs.getInt("v.codFuncionario"));
                venda.setParcelamento(rs.getInt("v.codParcelamento"));
                venda.setDataPedido(rs.getDate("v.datapedido"));
                venda.setSubtotal(rs.getDouble("v.subtotal"));
                venda.setTotal(rs.getDouble("v.total"));
                venda.setQtdpagamento(rs.getInt("v.qtdpagamento"));
                venda.setJuroscalculado(rs.getDouble("v.juroscalculado"));

                cliente.setCodigo(rs.getInt("c.codCliente"));
                cliente.setNome(rs.getString("c.nome"));
                cliente.setCpf(rs.getString("c.cpf"));
                cliente.setDatanascimento(rs.getDate("c.datanascimento"));
                cliente.setEndereco(rs.getString("c.endereco"));
                cliente.setEndereco(rs.getString("c.numero"));
                cliente.setBairro(rs.getString("c.bairro"));
                cliente.setCidade(rs.getString("c.cidade"));
                cliente.setUf(rs.getString("c.uf"));
                cliente.setCep(rs.getString("c.cep"));
                cliente.setTelefone(rs.getString("c.telefone"));
                cliente.setTelefonesecundario(rs.getString("c.telefonesecundario"));

                funcionario.setCodigo(rs.getInt("f.codFuncionario"));
                funcionario.setNome(rs.getString("f.nome"));
                funcionario.setCpf(rs.getString("f.cpf"));
                funcionario.setDatanascimento(rs.getDate("f.datanascimento"));
                funcionario.setEndereco(rs.getString("f.endereco"));
                funcionario.setEndereco(rs.getString("f.numero"));
                funcionario.setBairro(rs.getString("f.bairro"));
                funcionario.setCidade(rs.getString("f.cidade"));
                funcionario.setUf(rs.getString("f.uf"));
                funcionario.setCep(rs.getString("f.cep"));
                funcionario.setTelefone(rs.getString("f.telefone"));
                funcionario.setTelefonesecundario(rs.getString("f.telefonesecundario"));
                funcionario.setCargo(rs.getString("f.cargo"));
                funcionario.setLogin(rs.getString("f.login"));
                funcionario.setSenha(rs.getString("f.senha"));
                funcionario.setTipo(rs.getString("f.tipo"));

                parcelamento.setCodigo(rs.getInt("p.codParcelamento"));
                parcelamento.setQuantidademinima(rs.getInt("p.qtdminima"));
                parcelamento.setQuantidademaxima(rs.getInt("p.qtdmaxima"));
                parcelamento.setJurospercentual(rs.getDouble("p.jurospercentual"));

                entidadesVenda.setVendaObj(venda);
                entidadesVenda.setClientesObj(cliente);
                entidadesVenda.setFuncionariosObj(funcionario);
                entidadesVenda.setParcelamentosObj(parcelamento);

                listaEntidadesVenda.add(entidadesVenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesVendaControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return listaEntidadesVenda;
    }

    public ArrayList<EntidadesVenda> consultarVendasPorNome(String nome) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<EntidadesVenda> listaEntidadesVenda = new ArrayList<>();
        Venda venda;
        Cliente cliente;
        Funcionario funcionario;
        Parcelamento parcelamento;
        EntidadesVenda entidadesVenda;

        try {
            stmt = con.prepareStatement(SQLconsultarNomeCliente);
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                venda = new Venda();
                cliente = new Cliente();
                funcionario = new Funcionario();
                parcelamento = new Parcelamento();
                entidadesVenda = new EntidadesVenda();

                venda.setCodigo(rs.getInt("v.codVenda"));
                venda.setCliente(rs.getInt("v.codCliente"));
                venda.setFuncionario(rs.getInt("v.codFuncionario"));
                venda.setParcelamento(rs.getInt("v.codParcelamento"));
                venda.setDataPedido(rs.getDate("v.datapedido"));
                venda.setSubtotal(rs.getDouble("v.subtotal"));
                venda.setTotal(rs.getDouble("v.total"));
                venda.setQtdpagamento(rs.getInt("v.qtdpagamento"));
                venda.setJuroscalculado(rs.getDouble("v.juroscalculado"));

                cliente.setCodigo(rs.getInt("c.codCliente"));
                cliente.setNome(rs.getString("c.nome"));
                cliente.setCpf(rs.getString("c.cpf"));
                cliente.setDatanascimento(rs.getDate("c.datanascimento"));
                cliente.setEndereco(rs.getString("c.endereco"));
                cliente.setEndereco(rs.getString("c.numero"));
                cliente.setBairro(rs.getString("c.bairro"));
                cliente.setCidade(rs.getString("c.cidade"));
                cliente.setUf(rs.getString("c.uf"));
                cliente.setCep(rs.getString("c.cep"));
                cliente.setTelefone(rs.getString("c.telefone"));
                cliente.setTelefonesecundario(rs.getString("c.telefonesecundario"));

                funcionario.setCodigo(rs.getInt("f.codFuncionario"));
                funcionario.setNome(rs.getString("f.nome"));
                funcionario.setCpf(rs.getString("f.cpf"));
                funcionario.setDatanascimento(rs.getDate("f.datanascimento"));
                funcionario.setEndereco(rs.getString("f.endereco"));
                funcionario.setEndereco(rs.getString("f.numero"));
                funcionario.setBairro(rs.getString("f.bairro"));
                funcionario.setCidade(rs.getString("f.cidade"));
                funcionario.setUf(rs.getString("f.uf"));
                funcionario.setCep(rs.getString("f.cep"));
                funcionario.setTelefone(rs.getString("f.telefone"));
                funcionario.setTelefonesecundario(rs.getString("f.telefonesecundario"));
                funcionario.setCargo(rs.getString("f.cargo"));
                funcionario.setLogin(rs.getString("f.login"));
                funcionario.setSenha(rs.getString("f.senha"));
                funcionario.setTipo(rs.getString("f.tipo"));

                parcelamento.setCodigo(rs.getInt("p.codParcelamento"));
                parcelamento.setQuantidademinima(rs.getInt("p.qtdminima"));
                parcelamento.setQuantidademaxima(rs.getInt("p.qtdmaxima"));
                parcelamento.setJurospercentual(rs.getDouble("p.jurospercentual"));

                entidadesVenda.setVendaObj(venda);
                entidadesVenda.setClientesObj(cliente);
                entidadesVenda.setFuncionariosObj(funcionario);
                entidadesVenda.setParcelamentosObj(parcelamento);

                listaEntidadesVenda.add(entidadesVenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesVendaControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return listaEntidadesVenda;
    }
}
