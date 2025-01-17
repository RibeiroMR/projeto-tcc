/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.view;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.control.ParcelamentoControle;
import br.edu.ifsp.util.NumberRenderer;
import br.edu.ifsp.model.Parcelamento;
import java.awt.Component;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Murilo
 */
public class InterCadParcelamento extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private boolean novo;
    private int rowSelectedInTable = -1;

    public InterCadParcelamento() {
        initComponents();

        conexao = Conexao.abrir();

        listaParcelamento();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollFrameServico = new javax.swing.JScrollPane();
        panelServico = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableParcelamento = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        ftxtJurosPercentual = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        spinQtdMinima = new javax.swing.JSpinner();
        spinQtdMaxima = new javax.swing.JSpinner();
        btnNovo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Parcelamento");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de Parcelamento");

        btnVoltar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("Quantia Miníma *");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAlterar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnGravar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.setEnabled(false);
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGravar)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar)
                .addGap(123, 123, 123)
                .addComponent(btnCancelar)
                .addContainerGap(623, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addComponent(btnGravar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tableParcelamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableParcelamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableParcelamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableParcelamentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableParcelamento);

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setText("Quantia Maxíma *");

        ftxtJurosPercentual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftxtJurosPercentual.setEnabled(false);
        ftxtJurosPercentual.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftxtJurosPercentual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftxtJurosPercentualFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setText("Juros Percentual (%) *");

        spinQtdMinima.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spinQtdMinima.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        spinQtdMinima.setEnabled(false);

        spinQtdMaxima.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spinQtdMaxima.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        spinQtdMaxima.setEnabled(false);

        btnNovo.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setEnabled(false);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelServicoLayout = new javax.swing.GroupLayout(panelServico);
        panelServico.setLayout(panelServicoLayout);
        panelServicoLayout.setHorizontalGroup(
            panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelServicoLayout.createSequentialGroup()
                        .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinQtdMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelServicoLayout.createSequentialGroup()
                                .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelServicoLayout.createSequentialGroup()
                                        .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panelServicoLayout.createSequentialGroup()
                                        .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spinQtdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 7, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelServicoLayout.createSequentialGroup()
                        .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(ftxtJurosPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelServicoLayout.setVerticalGroup(
            panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelServicoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinQtdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinQtdMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftxtJurosPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        scrollFrameServico.setViewportView(panelServico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollFrameServico)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollFrameServico)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
//        btnNovo.setEnabled(true);
        btnAlterar.setEnabled(true);
        habilitarCampos(false);
        btnGravar.setEnabled(false);
        btnCancelar.setEnabled(false);
        tableParcelamento.setEnabled(true);
        tableParcelamento.clearSelection();
        rowSelectedInTable = -1;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(InterCadParcelamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novo = true;

//        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
        habilitarCampos(true);
        limparCampos();
        btnGravar.setEnabled(true);
        btnCancelar.setEnabled(true);

        tableParcelamento.setEnabled(false);
        tableParcelamento.clearSelection();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        adicionar();
        rowSelectedInTable = -1;
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (rowSelectedInTable != -1) {
            novo = false;

//            btnNovo.setEnabled(false);
            btnAlterar.setEnabled(false);
            habilitarCampos(true);
            btnGravar.setEnabled(true);
            btnCancelar.setEnabled(true);

            tableParcelamento.setEnabled(false);
            tableParcelamento.setRowSelectionInterval(rowSelectedInTable, rowSelectedInTable);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um parcelamento da lista!", "Alteração de Dados", 1);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tableParcelamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableParcelamentoMouseClicked
        setCampos();
    }//GEN-LAST:event_tableParcelamentoMouseClicked

    private void ftxtJurosPercentualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftxtJurosPercentualFocusLost
        Double valor = Double.parseDouble(ftxtJurosPercentual.getText().replace(".", "").replace(",", "."));
        if (valor >= 1) {
            valor = valor / 100;
            System.out.println("Ajuste Porcentual = " + valor);
        }
        ftxtJurosPercentual.setText(valor.toString().replace(".", ","));
    }//GEN-LAST:event_ftxtJurosPercentualFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JFormattedTextField ftxtJurosPercentual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelServico;
    private javax.swing.JScrollPane scrollFrameServico;
    private javax.swing.JSpinner spinQtdMaxima;
    private javax.swing.JSpinner spinQtdMinima;
    private javax.swing.JTable tableParcelamento;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        spinQtdMinima.setValue(1);
        spinQtdMaxima.setValue(1);
        ftxtJurosPercentual.setText(null);
    }

    private void habilitarCampos(boolean habilita) {
//        spinQtdMinima.setEnabled(habilita);
//        spinQtdMaxima.setEnabled(habilita);
        ftxtJurosPercentual.setEnabled(habilita);
    }

    private void organizarJtable() {
        tableParcelamento.setDefaultEditor(Object.class, null);

        tableParcelamento.getColumnModel().getColumn(0).setMinWidth(0);
        tableParcelamento.getColumnModel().getColumn(0).setMaxWidth(0);

        tableParcelamento.getColumnModel().getColumn(1).setHeaderValue("Qtd. Miníma");
        tableParcelamento.getColumnModel().getColumn(2).setHeaderValue("Qtd. Maxima");
        tableParcelamento.getColumnModel().getColumn(3).setHeaderValue("Juros Percentual");

        tableParcelamento.getColumnModel().getColumn(3).setCellRenderer(NumberRenderer.getPercentRenderer());
    }

    private void listaParcelamento() {
        String sql = "SELECT * FROM parcelamento";

        try {
            pst = conexao.prepareStatement(sql);

            rs = pst.executeQuery();

            tableParcelamento.setModel(DbUtils.resultSetToTableModel(rs));

            organizarJtable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void adicionar() {
        if ((ftxtJurosPercentual.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios (*) !");
        } else if (0 > (Double.parseDouble(ftxtJurosPercentual.getText().replace(".", "").replace(",", ".")))) {
            JOptionPane.showMessageDialog(null, "Não informe valores abaixo que Zero (*) !");
        } else {
            if (Integer.parseInt(spinQtdMaxima.getValue().toString()) < Integer.parseInt(spinQtdMinima.getValue().toString())) {
                JOptionPane.showMessageDialog(null, "A quantida maxíma não pode ser menor que quantidade minima!");
            } else {
                int op = JOptionPane.showInternalConfirmDialog(getInstance(), "Prosseguir com as inserções feitas?", "Registro de parcelamento",
                        JOptionPane.YES_NO_OPTION);

                if (op == JOptionPane.YES_NO_OPTION) {
                    Parcelamento parcelamento = new Parcelamento();

                    ParcelamentoControle parcControl = new ParcelamentoControle();

                    parcelamento.setQuantidademinima(Integer.parseInt(spinQtdMinima.getValue().toString()));
                    parcelamento.setQuantidademaxima(Integer.parseInt(spinQtdMaxima.getValue().toString()));

                    Double valor = Double.parseDouble(ftxtJurosPercentual.getText().replace(".", "").replace(",", "."));
                    if (valor >= 1) {
                        valor = valor / 100;
                        System.out.println("Ajuste Porcentual = " + valor);
                    }
                    String juros = valor.toString();
                    parcelamento.setJurospercentual(Double.parseDouble(juros));

//                    if (novo) {
//                        parcControl.adicionar(parcelamento);
//                    } else {
                    parcelamento.setCodigo(Integer.parseInt(tableParcelamento.getModel().getValueAt(rowSelectedInTable, 0).toString()));

                    if (parcControl.verificarJurosPercentual(parcelamento)) {
                        parcControl.atualizar(parcelamento);
                    } else {
                        JOptionPane.showMessageDialog(null, "O valor do Juros é maior que os Juros Subjacente!");
                    }
//                    }

                    limparCampos();

                    tableParcelamento.setEnabled(true);
//                    btnNovo.setEnabled(true);
                    btnAlterar.setEnabled(true);

                    habilitarCampos(false);

                    btnGravar.setEnabled(false);
                    btnCancelar.setEnabled(false);

                    listaParcelamento();
                }
            }
        }
    }

    private Component getInstance() {
        return this;
    }

    private void setCampos() {
        rowSelectedInTable = tableParcelamento.getSelectedRow();

        spinQtdMinima.setValue(tableParcelamento.getModel().getValueAt(rowSelectedInTable, 1));
        spinQtdMaxima.setValue(tableParcelamento.getModel().getValueAt(rowSelectedInTable, 2));

        String juros = tableParcelamento.getModel().getValueAt(rowSelectedInTable, 3).toString();
        String jurosFormat = juros.replace("%", "").replace(".", ",");
        ftxtJurosPercentual.setText(jurosFormat);
    }

}
