/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.control;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.model.Parcelamento;
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
public class ParcelamentoControle {

    private final String SQLinserir = "INSERT INTO parcelamento(qtdminima, qtdmaxima, jurospercentual) VALUES (?, ?, ?)";
    private final String SQLlistar = "SELECT * FROM parcelamento";
    private final String SQLbuscarJuros = "SELECT * FROM parcelamento";
    private final String SQLalterar = "UPDATE parcelamento SET qtdminima=?, qtdmaxima=?, jurospercentual=? WHERE codParcelamento=?";

//    public void adicionar(Parcelamento parcelamento) {
//        Connection con = Conexao.abrir();
//
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement(SQLinserir);
//
//            stmt.setInt(1, parcelamento.getQuantidademinima());
//            stmt.setInt(2, parcelamento.getQuantidademaxima());
//            stmt.setDouble(3, parcelamento.getJurospercentual());
//
//            int adicionado = stmt.executeUpdate();
//
//            if (adicionado > 0) {
//                JOptionPane.showMessageDialog(null, "Dados do Parcelamento salvo!", "Informações de Parcelamento", 1);
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex);
//            JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!", "Registro de Parcelamento", 0);
//        } finally {
//            Conexao.fechar(con, stmt);
//        }
//    }
    public ArrayList<Parcelamento> listar() {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Parcelamento> parcelamentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(SQLlistar);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Parcelamento par = new Parcelamento();

                par.setCodigo(rs.getInt("codParcelamento"));
                par.setQuantidademinima(rs.getInt("qtdminima"));
                par.setQuantidademaxima(rs.getInt("qtdmaxima"));
                par.setJurospercentual(rs.getDouble("jurospercentual"));

                parcelamentos.add(par);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParcelamentoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return parcelamentos;
    }

    public Parcelamento compararParcelamento(int quantia) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        Parcelamento par = new Parcelamento();

        try {
            stmt = con.prepareStatement(SQLlistar);

            rs = stmt.executeQuery();

            while (rs.next()) {
                if (quantia >= rs.getInt("qtdminima") && quantia <= rs.getInt("qtdmaxima")) {
                    par.setCodigo(rs.getInt("codParcelamento"));
                    par.setQuantidademinima(rs.getInt("qtdminima"));
                    par.setQuantidademaxima(rs.getInt("qtdmaxima"));
                    par.setJurospercentual(rs.getDouble("jurospercentual"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParcelamentoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }

        return par;
    }

    public void atualizar(Parcelamento parcelamento) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(SQLalterar);

            stmt.setInt(1, parcelamento.getQuantidademinima());
            stmt.setInt(2, parcelamento.getQuantidademaxima());
            stmt.setDouble(3, parcelamento.getJurospercentual());
            stmt.setInt(4, parcelamento.getCodigo());

            int adicionado = stmt.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterados!", "Registro de Parcelamento", 1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!", "Registro de Parcelamento", 0);
        } finally {
            Conexao.fechar(con, stmt);
        }
    }

    public boolean verificarJurosPercentual(Parcelamento p) {
        Connection con = Conexao.abrir();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Parcelamento> parcelamentos = new ArrayList<>();
        ArrayList<Double> juros = new ArrayList<>();

        try {
            stmt = con.prepareStatement(SQLbuscarJuros);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Parcelamento par = new Parcelamento();

                par.setCodigo(rs.getInt("codParcelamento"));
                par.setQuantidademinima(rs.getInt("qtdminima"));
                par.setQuantidademaxima(rs.getInt("qtdmaxima"));
                par.setJurospercentual(rs.getDouble("jurospercentual"));

                parcelamentos.add(par);
            }

            for (int i = 0; i < parcelamentos.size(); i++) {
                if (parcelamentos.get(i).getCodigo() == p.getCodigo()) {
                    juros.add(p.getJurospercentual());
                } else {
                    juros.add(parcelamentos.get(i).getJurospercentual());
                }
            }
            System.out.println("ORDEM DOS JUROS: " + juros);
            System.out.println("ESTA ORDENADO: " + isSorted(juros));
        } catch (SQLException ex) {
            Logger.getLogger(ParcelamentoControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechar(con, stmt, rs);
        }
        return isSorted(juros);
    }

    public static boolean isSorted(ArrayList<Double> vetor) {
        /*
    * Vetor com 1 elemento estar ordenado!
    * Vetor com 2 elemento está em ordem crescente ou decrescente!
         */
//        if (vetor.size() <= 2) {
//            return true;
//        }

        /*
    *Se k é negativo, então a diferença (d) entre um elemento e seu sucessor
    *também tem que ser negativo, caso contrário, não está em ordem decrescente!
    *
    *Se k é positivo, a diferença (d) também é positiva,
    *caso contrário, a lista não está em ordem crescente!
         */
        double k = vetor.get(1) - vetor.get(0);

        for (int i = 1; i < (vetor.size() - 1); i++) {

            double d = vetor.get(i + 1) - vetor.get(i);

            if ((k < 0 && d > 0) || (k > 0 && d < 0)) {
                return false;
            }
        }
        return true;
    }
}
