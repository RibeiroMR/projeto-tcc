/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.view;

import static br.edu.ifsp.view.FrameInicial.desktop;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;

/**
 *
 * @author Murilo
 */
public class InterCadastros extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterCadastros
     */
    public InterCadastros() {
        initComponents();

        btnClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnClientes.setHorizontalTextPosition(SwingConstants.CENTER);

        btnFormaPagamento.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnFormaPagamento.setHorizontalTextPosition(SwingConstants.CENTER);

        btnFornecedor.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnFornecedor.setHorizontalTextPosition(SwingConstants.CENTER);

        btnFuncionarios.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnFuncionarios.setHorizontalTextPosition(SwingConstants.CENTER);

        btnParcelamentos.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnParcelamentos.setHorizontalTextPosition(SwingConstants.CENTER);

        btnProdutos.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnProdutos.setHorizontalTextPosition(SwingConstants.CENTER);

        btnServicos.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnServicos.setHorizontalTextPosition(SwingConstants.CENTER);

        if (!FrameInicial.lblUsuario.getText().equals("administrador")) {
            btnFormaPagamento.setEnabled(false);
//            btnFornecedor.setEnabled(false);
            btnFuncionarios.setEnabled(false);
            btnParcelamentos.setEnabled(false);
//            btnProdutos.setEnabled(false);
//            btnServicos.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClientes = new javax.swing.JButton();
        btnFormaPagamento = new javax.swing.JButton();
        btnFornecedor = new javax.swing.JButton();
        btnServicos = new javax.swing.JButton();
        btnFuncionarios = new javax.swing.JButton();
        btnParcelamentos = new javax.swing.JButton();
        btnProdutos = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastros");

        btnClientes.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/client.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnFormaPagamento.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/forma-de-pagamento.png"))); // NOI18N
        btnFormaPagamento.setText("Formas de pagamentos");
        btnFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormaPagamentoActionPerformed(evt);
            }
        });

        btnFornecedor.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/fornecem.png"))); // NOI18N
        btnFornecedor.setText("Fornecedores");
        btnFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedorActionPerformed(evt);
            }
        });

        btnServicos.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/manutencao.png"))); // NOI18N
        btnServicos.setText("Serviços");
        btnServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicosActionPerformed(evt);
            }
        });

        btnFuncionarios.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/funcionarios.png"))); // NOI18N
        btnFuncionarios.setText("Funcionários");
        btnFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionariosActionPerformed(evt);
            }
        });

        btnParcelamentos.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnParcelamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/taxa-de-juro.png"))); // NOI18N
        btnParcelamentos.setText("Juros e parcelas");
        btnParcelamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParcelamentosActionPerformed(evt);
            }
        });

        btnProdutos.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/capacete-de-bicicleta.png"))); // NOI18N
        btnProdutos.setText("Produtos");
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFormaPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnParcelamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClientes)
                    .addComponent(btnFormaPagamento)
                    .addComponent(btnFornecedor))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFuncionarios)
                    .addComponent(btnParcelamentos)
                    .addComponent(btnProdutos))
                .addGap(18, 18, 18)
                .addComponent(btnServicos)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        InterCadCliente internal = new InterCadCliente();

        try {
            addTelaDesk(internal);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(InterCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormaPagamentoActionPerformed
        InterCadFormaPagamento internal = new InterCadFormaPagamento();

        try {
            addTelaDesk(internal);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(InterCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFormaPagamentoActionPerformed

    private void btnFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedorActionPerformed
        InterCadFornecedor internal = new InterCadFornecedor();

        try {
            addTelaDesk(internal);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(InterCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFornecedorActionPerformed

    private void btnServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicosActionPerformed
        InterCadServico internal = new InterCadServico();

        try {
            addTelaDesk(internal);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(InterCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnServicosActionPerformed

    private void btnFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionariosActionPerformed
        InterCadFuncionario internal = new InterCadFuncionario();

        try {
            addTelaDesk(internal);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(InterCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFuncionariosActionPerformed

    private void btnParcelamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParcelamentosActionPerformed
        InterCadParcelamento internal = new InterCadParcelamento();

        try {
            addTelaDesk(internal);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(InterCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnParcelamentosActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        InterCadProduto internal = new InterCadProduto();

        try {
            addTelaDesk(internal);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(InterCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProdutosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnFormaPagamento;
    private javax.swing.JButton btnFornecedor;
    private javax.swing.JButton btnFuncionarios;
    private javax.swing.JButton btnParcelamentos;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JButton btnServicos;
    // End of variables declaration//GEN-END:variables

    public void addTelaDesk(JInternalFrame nova) throws PropertyVetoException {
        for (JInternalFrame jInternalFrame : desktop.getAllFrames()) {
            // Aqui fecho tudo que tem no meu DesktopPainel
            jInternalFrame.setClosed(true);
        }
        centralizaForm(nova);
        desktop.add(nova); //adiciona na tela 
        nova.setVisible(true); // seta visivel   
    }

    private void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 3);
    }
}
