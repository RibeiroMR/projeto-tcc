/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.view;

import br.edu.ifsp.connection.Conexao;
import br.edu.ifsp.control.ClienteControle;
import br.edu.ifsp.control.EntidadesVendaControle;
import br.edu.ifsp.control.FormapagamentoControle;
import br.edu.ifsp.control.ItemVendaControle;
import br.edu.ifsp.control.PagamentoControle;
import br.edu.ifsp.control.ParcelamentoControle;
import br.edu.ifsp.control.ProdutoControle;
import br.edu.ifsp.control.ServicoControle;
import br.edu.ifsp.control.ServicoVendaControle;
import br.edu.ifsp.control.VendaControle;
import br.edu.ifsp.util.NumberRenderer;
import br.edu.ifsp.model.Cliente;
import br.edu.ifsp.model.ComprovanteVenda;
import br.edu.ifsp.model.EntidadesItemVenda;
import br.edu.ifsp.model.EntidadesPagamento;
import br.edu.ifsp.model.EntidadesServicoVenda;
import br.edu.ifsp.model.EntidadesVenda;
import br.edu.ifsp.model.FormaPagamento;
import br.edu.ifsp.model.ItemVenda;
import br.edu.ifsp.model.Pagamento;
import br.edu.ifsp.model.PagamentosColunas;
import br.edu.ifsp.model.Parcelamento;
import br.edu.ifsp.model.Produto;
import br.edu.ifsp.model.Servico;
import br.edu.ifsp.model.ServicoVenda;
import br.edu.ifsp.model.Venda;
import br.edu.ifsp.util.FormatRenderer;
import br.edu.ifsp.util.SoNumero;
import java.awt.Component;
import java.awt.Frame;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Murilo
 */
public class InterFazerVenda extends javax.swing.JInternalFrame {

    ClienteControle clienteControl = new ClienteControle();
    Cliente cliente = new Cliente();
    List<Cliente> listaClientes = new ArrayList<>();

    ProdutoControle produtoControl = new ProdutoControle();
    Produto produto = new Produto();
    List<Produto> listaProdutos = new ArrayList<>();

    ServicoControle servicoControl = new ServicoControle();
    Servico servico = new Servico();
    List<Servico> listaServicos = new ArrayList<>();

    VendaControle vendaControl = new VendaControle();
    Venda venda = new Venda();

    ParcelamentoControle parcelamentoControl = new ParcelamentoControle();
    Parcelamento parcelamento = new Parcelamento();

    ItemVendaControle itemVendaControl = new ItemVendaControle();
    ItemVenda itemVenda = new ItemVenda();
    ArrayList<ItemVenda> listaItemVenda = new ArrayList<>();

    ServicoVendaControle servicoVendaControl = new ServicoVendaControle();
    ServicoVenda servicoVenda = new ServicoVenda();
    ArrayList<ServicoVenda> listaServicoVenda = new ArrayList<>();

    PagamentoControle pagamentoControl = new PagamentoControle();
    Pagamento pagamento = new Pagamento();
    ArrayList<Pagamento> listaPagamento = new ArrayList<>();
    ArrayList<EntidadesPagamento> listaPagmentosVenda = new ArrayList<>();

    ArrayList<EntidadesVenda> listaEntidadesVenda = new ArrayList<>();
    EntidadesVendaControle entidadesVendaControl = new EntidadesVendaControle();

    ArrayList<EntidadesItemVenda> listaEntidadesItemVenda = new ArrayList<>();
    ArrayList<EntidadesServicoVenda> listaEntidadesServicoVenda = new ArrayList<>();

    ArrayList<FormaPagamento> listaFormaPagamento = new ArrayList<>();
    FormaPagamento formaPagamento = new FormaPagamento();
    FormapagamentoControle formaPagamentoControl = new FormapagamentoControle();

    public InterFazerVenda() {
        initComponents();

        listarClientes();
        listarProdutos();
        listarServicos();
        listarFormaPagamento();

        txtQtdProduto.setDocument(new SoNumero());
        txtQtdServico.setDocument(new SoNumero());
        txtQtdProduto.setText("1");
        txtQtdServico.setText("1");

        listarVendas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelFazerVenda = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        checkAddParcelamento = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        lblJurosPercentual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableQtdParcelas = new javax.swing.JTable();
        cboxNumParcelas = new javax.swing.JComboBox<>();
        lblJurosPercentual1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboxProduto = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtQtdProduto = new javax.swing.JTextField();
        btnAddProduto = new javax.swing.JButton();
        btnRemoveProduto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProdutoServicoVenda = new javax.swing.JTable();
        btnAddServico = new javax.swing.JButton();
        cboxServico = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtQtdServico = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cboxCliente = new javax.swing.JComboBox<>();
        txtBuscaCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCodProduto = new javax.swing.JTextField();
        labelEstoque = new javax.swing.JLabel();
        labelEstoque1 = new javax.swing.JLabel();
        txtCodServico = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTotalVenda = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cboxFormaPagamento = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableVendas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProdutosVenda = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableServicosVenda = new javax.swing.JTable();
        dateMinVenda = new com.toedter.calendar.JDateChooser();
        dateMaxVenda = new com.toedter.calendar.JDateChooser();
        btnConsultaVendas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnVisualizarParcelas = new javax.swing.JButton();
        btnRelatorioVendas = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Nova Venda");

        jTabbedPane1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkAddParcelamento.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        checkAddParcelamento.setText("Adicionar Parcelamento");
        checkAddParcelamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkAddParcelamentoItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel7.setText("Juros:");

        lblJurosPercentual.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblJurosPercentual.setText("0.0");

        tableQtdParcelas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableQtdParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parcelas", "Valor das Parcelas (R$)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableQtdParcelas.setMaximumSize(new java.awt.Dimension(12345678, 0));
        jScrollPane1.setViewportView(tableQtdParcelas);
        if (tableQtdParcelas.getColumnModel().getColumnCount() > 0) {
            tableQtdParcelas.getColumnModel().getColumn(0).setMinWidth(60);
            tableQtdParcelas.getColumnModel().getColumn(0).setPreferredWidth(60);
            tableQtdParcelas.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        cboxNumParcelas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboxNumParcelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cboxNumParcelas.setEnabled(false);
        cboxNumParcelas.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboxNumParcelasPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        lblJurosPercentual1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblJurosPercentual1.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(checkAddParcelamento)
                        .addGap(0, 104, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblJurosPercentual))
                            .addComponent(cboxNumParcelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblJurosPercentual1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkAddParcelamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboxNumParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblJurosPercentual)
                            .addComponent(lblJurosPercentual1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setText("Produto:");

        cboxProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboxProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione um produto -" }));
        cboxProduto.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboxProdutoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel9.setText("Quantidade:");

        txtQtdProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtQtdProduto.setText("1");

        btnAddProduto.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnAddProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/mais.png"))); // NOI18N
        btnAddProduto.setText("Adicionar");
        btnAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdutoActionPerformed(evt);
            }
        });

        btnRemoveProduto.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnRemoveProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/menos.png"))); // NOI18N
        btnRemoveProduto.setText("Remover");
        btnRemoveProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveProdutoActionPerformed(evt);
            }
        });

        tableProdutoServicoVenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableProdutoServicoVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo", "Descrição", "Quantidade", "Preço Unitario", "Preço Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableProdutoServicoVenda);

        btnAddServico.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnAddServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/mais.png"))); // NOI18N
        btnAddServico.setText("Adicionar");
        btnAddServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServicoActionPerformed(evt);
            }
        });

        cboxServico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboxServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione um serviço -" }));
        cboxServico.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboxServicoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setText("Serviço:");

        txtQtdServico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtQtdServico.setText("1");

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel10.setText("Quantidade:");

        cboxCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboxClientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        txtBuscaCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaClienteKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel11.setText("Código:");

        txtCodProduto.setEditable(false);
        txtCodProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCodProduto.setEnabled(false);

        labelEstoque.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        labelEstoque.setText("0,0");

        labelEstoque1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelEstoque1.setText("Estoque:");

        txtCodServico.setEditable(false);
        txtCodServico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCodServico.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel12.setText("Código:");

        txtCodCliente.setEditable(false);
        txtCodCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCodCliente.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel13.setText("Procurar Nome:");

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel1.setText("Total da venda:");

        txtTotalVenda.setEditable(false);
        txtTotalVenda.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        txtTotalVenda.setForeground(new java.awt.Color(0, 102, 0));
        txtTotalVenda.setText("R$ 0,00");

        btnFinalizar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnFinalizar.setForeground(new java.awt.Color(0, 102, 0));
        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/acordo (1).png"))); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/cruz.png"))); // NOI18N
        btnCancelar.setText("Sair");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel8.setText("Subtotal:");

        txtSubTotal.setEditable(false);
        txtSubTotal.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        txtSubTotal.setForeground(new java.awt.Color(153, 0, 0));
        txtSubTotal.setText("R$ 0,00");

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel14.setText("Código:");

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel15.setText("Forma de Pagamento:");

        cboxFormaPagamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione a Forma de Pagamento  -" }));

        javax.swing.GroupLayout panelFazerVendaLayout = new javax.swing.GroupLayout(panelFazerVenda);
        panelFazerVenda.setLayout(panelFazerVendaLayout);
        panelFazerVendaLayout.setHorizontalGroup(
            panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFazerVendaLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelFazerVendaLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addGap(559, 559, 559)
                        .addComponent(jLabel10))
                    .addGroup(panelFazerVendaLayout.createSequentialGroup()
                        .addComponent(txtCodServico, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(cboxServico, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtQtdServico, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnAddServico))
                    .addComponent(btnRemoveProduto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFazerVendaLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFazerVendaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFazerVendaLayout.createSequentialGroup()
                                        .addComponent(btnCancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFinalizar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTotalVenda, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(1, 1, 1))
                            .addGroup(panelFazerVendaLayout.createSequentialGroup()
                                .addComponent(cboxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFazerVendaLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFazerVendaLayout.createSequentialGroup()
                        .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(6, 6, 6)
                        .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFazerVendaLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 132, Short.MAX_VALUE))
                            .addComponent(txtBuscaCliente)))
                    .addGroup(panelFazerVendaLayout.createSequentialGroup()
                        .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFazerVendaLayout.createSequentialGroup()
                                .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(cboxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFazerVendaLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addGap(353, 353, 353)
                                .addComponent(labelEstoque1)
                                .addGap(6, 6, 6)
                                .addComponent(labelEstoque)))
                        .addGap(6, 6, 6)
                        .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(panelFazerVendaLayout.createSequentialGroup()
                                .addComponent(txtQtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnAddProduto)))))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        panelFazerVendaLayout.setVerticalGroup(
            panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFazerVendaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(6, 6, 6)
                .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3)
                    .addGroup(panelFazerVendaLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEstoque)
                            .addComponent(labelEstoque1)
                            .addComponent(jLabel9))))
                .addGap(6, 6, 6)
                .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addGap(6, 6, 6)
                .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodServico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxServico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdServico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddServico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnRemoveProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFazerVendaLayout.createSequentialGroup()
                        .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelFazerVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fazer Venda", panelFazerVenda);

        tableVendas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do cliente", "Funcionário", "Data do pedido", "Subtotal", "Total da venda", "Quantiade de parcelamento", "Juros"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVendasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableVendas);

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel6.setText("Data Máxima:");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setText("Data Minima:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de produtos da venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 12))); // NOI18N

        tableProdutosVenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableProdutosVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Quantidade", "Preço", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableProdutosVenda);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de serviços da venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 12))); // NOI18N

        tableServicosVenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableServicosVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Quantidade", "Preço", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableServicosVenda);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        dateMinVenda.setDateFormatString("dd/MM/yyyy");
        dateMinVenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        dateMaxVenda.setDateFormatString("dd/MM/yyyy");

        btnConsultaVendas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnConsultaVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/pesquisar.png"))); // NOI18N
        btnConsultaVendas.setText("Consultar");
        btnConsultaVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaVendasActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/apagador.png"))); // NOI18N
        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnVisualizarParcelas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnVisualizarParcelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/note (1).png"))); // NOI18N
        btnVisualizarParcelas.setText("Ver Parcelas");
        btnVisualizarParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarParcelasActionPerformed(evt);
            }
        });

        btnRelatorioVendas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnRelatorioVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifsp/icons/printer.png"))); // NOI18N
        btnRelatorioVendas.setText("Gerar Relatório");
        btnRelatorioVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioVendasActionPerformed(evt);
            }
        });

        txtPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel17.setText("Busca nome do cliente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVisualizarParcelas))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateMinVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateMaxVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsultaVendas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRelatorioVendas)
                                .addGap(66, 66, 66)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateMaxVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConsultaVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRelatorioVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(dateMinVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVisualizarParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Vendas", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaClienteKeyReleased
        cliente = (Cliente) clienteControl.buscarPorNome(txtBuscaCliente.getText());
        cboxCliente.setSelectedItem(cliente.toString());
    }//GEN-LAST:event_txtBuscaClienteKeyReleased

    private void cboxClientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboxClientePopupMenuWillBecomeInvisible
        if (cboxCliente.isPopupVisible()) {
            if (cboxCliente.getSelectedIndex() != 0) {
                String a = cboxCliente.getSelectedItem().toString();
                String result[] = a.split(". ");

                Cliente c = clienteControl.buscarPorNome(result[0]);
                txtCodCliente.setText(String.valueOf(c.getCodigo()));
            } else {
                txtCodCliente.setText("");
            }
        }
    }//GEN-LAST:event_cboxClientePopupMenuWillBecomeInvisible

    private void cboxServicoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboxServicoPopupMenuWillBecomeInvisible
        if (cboxServico.isPopupVisible()) {
            if (cboxServico.getSelectedIndex() != 0) {
                String a = cboxServico.getSelectedItem().toString();
                String result[] = a.split("; ");

                Servico s = servicoControl.buscarDescricao(result[0]);
                txtCodServico.setText(String.valueOf(s.getCodigo()));
            } else {
                txtCodServico.setText("");
            }
        }
    }//GEN-LAST:event_cboxServicoPopupMenuWillBecomeInvisible

    private void btnAddServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServicoActionPerformed
        if (txtQtdServico.getText().equals("") || cboxServico.getSelectedIndex() == 0 || Integer.parseInt(txtQtdServico.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Você deve informar a número de serviços a ser prestado!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            servico = servicoControl.buscarCodigo(Integer.parseInt(txtCodServico.getText()));

            DefaultTableModel modelo = (DefaultTableModel) tableProdutoServicoVenda.getModel();

            int cont = 0;
            for (int i = 0; i < cont; i++) {
                modelo.setNumRows(0);
            }

            int tableTamanho = tableProdutoServicoVenda.getRowCount();
            double quantidade = 0;
            quantidade = Double.parseDouble(txtQtdServico.getText());

            if (tableProdutoServicoVenda.getRowCount() == 0) {
                addLinhaListaSVenda(modelo, quantidade);
            } else {
                int i = 0;
                boolean achou = false;
                do {
                    if (String.valueOf(tableProdutoServicoVenda.getValueAt(i, 0)).equals(txtCodServico.getText())
                            && tableProdutoServicoVenda.getValueAt(i, 1).equals("SERVIÇO")) {

                        tableProdutoServicoVenda.setValueAt(quantidade + (double) tableProdutoServicoVenda.getValueAt(i, 3), i, 3);
                        tableProdutoServicoVenda.setValueAt((servico.getPreco() * quantidade) + (double) tableProdutoServicoVenda.getValueAt(i, 5), i, 5);
                        achou = true;
                    }
                    i++;
                } while (i < tableTamanho && !achou);
                if (achou == false) {
                    addLinhaListaSVenda(modelo, quantidade);
                }
            }

            tableProdutoServicoVenda.getColumnModel().getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());
            tableProdutoServicoVenda.getColumnModel().getColumn(5).setCellRenderer(NumberRenderer.getCurrencyRenderer());

            somarValorTotalProdutoServico();

            calcularParcelamentos();

            txtCodServico.setText("");
            txtQtdServico.setText("1");
            cboxServico.setSelectedIndex(0);

            resizeColumnWidth(tableProdutoServicoVenda);
        }
    }//GEN-LAST:event_btnAddServicoActionPerformed

    public void addLinhaListaSVenda(DefaultTableModel modelo, double quantidade) {
        modelo.addRow(new Object[]{
            servico.getCodigo(),
            "SERVIÇO",
            servico.getDescricao(),
            quantidade,
            servico.getPreco(),
            quantidade * servico.getPreco()
        });
    }

    private void btnAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdutoActionPerformed
        if (txtQtdProduto.getText().equals("") || cboxProduto.getSelectedIndex() == 0 || Integer.parseInt(txtQtdProduto.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Informe Produto e Quantia!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            if (verificarQuantidadeEstoque()) {
                produto = produtoControl.buscarPorCodigo(txtCodProduto.getText());

                DefaultTableModel modelo = (DefaultTableModel) tableProdutoServicoVenda.getModel();

                int cont = 0;
                for (int i = 0; i < cont; i++) {
                    modelo.setNumRows(0);
                }

                int tableTamanho = tableProdutoServicoVenda.getRowCount();
                double quantidade = 0;
                quantidade = Double.parseDouble(txtQtdProduto.getText());

                System.out.println("Tamanho (ANTES) da Table Prod./Serv. Venda: " + tableProdutoServicoVenda.getRowCount());

                if (tableProdutoServicoVenda.getRowCount() == 0) {
                    addLinhaListaPVenda(modelo, quantidade);
                } else {
                    int i = 0;
                    boolean achou = false;
                    do {
                        if (String.valueOf(tableProdutoServicoVenda.getValueAt(i, 0)).equals(txtCodProduto.getText())
                                && tableProdutoServicoVenda.getValueAt(i, 1).equals("PRODUTO")) {
                            if ((quantidade + (double) tableProdutoServicoVenda.getValueAt(i, 3)) <= Double.parseDouble(labelEstoque.getText().replace(",", "."))) {
                                tableProdutoServicoVenda.setValueAt(quantidade + (double) tableProdutoServicoVenda.getValueAt(i, 3), i, 3);
                                tableProdutoServicoVenda.setValueAt((produto.getPreco() * quantidade) + (double) tableProdutoServicoVenda.getValueAt(i, 5), i, 5);
                            } else {
                                JOptionPane.showMessageDialog(this, "QUANTIDADE + QUANTIDADE NA LISTA não pode ultrapassar o estoque", "Atenção", JOptionPane.WARNING_MESSAGE);
                            }
                            achou = true;
                        }
                        i++;
                    } while (i < tableTamanho && !achou);
                    if (achou == false) {
                        addLinhaListaPVenda(modelo, quantidade);
                    }
                }

                System.out.println("Tamanho (DEPOIS) da Table Prod./Serv. Venda: " + tableProdutoServicoVenda.getRowCount());

                tableProdutoServicoVenda.getColumnModel().getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());
                tableProdutoServicoVenda.getColumnModel().getColumn(5).setCellRenderer(NumberRenderer.getCurrencyRenderer());

                somarValorTotalProdutoServico();

                calcularParcelamentos();

                txtCodProduto.setText("");
                txtQtdProduto.setText("1");
                cboxProduto.setSelectedIndex(0);
                cboxFormaPagamento.setSelectedIndex(0);
                labelEstoque.setText("0,0");

                resizeColumnWidth(tableProdutoServicoVenda);
            } else {
                JOptionPane.showMessageDialog(this, "A quantia informada não pode ultrapassar o estoque", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAddProdutoActionPerformed

    public void addLinhaListaPVenda(DefaultTableModel modelo, double quantidade) {
        modelo.addRow(new Object[]{
            produto.getCodigo(),
            "PRODUTO",
            produto.getDescricao(),
            quantidade,
            produto.getPreco(),
            quantidade * produto.getPreco()
        });
    }

    private void cboxProdutoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboxProdutoPopupMenuWillBecomeInvisible
        if (cboxProduto.isPopupVisible()) {
            if (cboxProduto.getSelectedIndex() != 0) {
                String a = cboxProduto.getSelectedItem().toString();
                String result[] = a.split("; ");
                Produto p = produtoControl.buscarPorNome(result[0]);
                txtCodProduto.setText(String.valueOf(p.getCodigo()));

                String estoque = String.valueOf(p.getEstoque());
                String estoqueFormat = estoque.replace(" ", "").replace(".", ",");
                labelEstoque.setText(estoqueFormat);
            } else {
                txtCodProduto.setText("");
                labelEstoque.setText("0,0");
            }
        }
    }//GEN-LAST:event_cboxProdutoPopupMenuWillBecomeInvisible

    private void btnRemoveProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveProdutoActionPerformed
        if (tableProdutoServicoVenda.getSelectedRow() != -1) {
            subtrairValorProdutoServico(tableProdutoServicoVenda.getSelectedRow());
            if (tableProdutoServicoVenda.getRowCount() == 0) {
                txtSubTotal.setText("R$ 0,00");
                txtTotalVenda.setText("R$ 0,00");
            }
            calcularParcelamentos();
        }
    }//GEN-LAST:event_btnRemoveProdutoActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (tableProdutoServicoVenda.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Adicionar Produto ou Serviço a lista!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtCodCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Selecione o Cliente da venda", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        } else if (cboxFormaPagamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione a Forma de Pagemento", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String opt[] = {"Sim", "Não"};

            int op = JOptionPane.showOptionDialog(this, "Confirmar pedido de venda?", "Finalizar Venda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, opt[1]);

            if (op == JOptionPane.YES_OPTION) {
                String valortotal = txtTotalVenda.getText().replace("R$", "").replace(" ", "").replace(",", ".");
                String subtotal = txtSubTotal.getText().replace("R$", "").replace(" ", "").replace(",", ".");
                int codVenda = 0;
                int qtdparcelas = 1;

                venda = new Venda();

                venda.setCliente(Integer.parseInt(txtCodCliente.getText()));
                venda.setFuncionario(Integer.parseInt(FrameInicial.lblCodUser.getText()));
                venda.setDataPedido(new Date(System.currentTimeMillis()));

                if (checkAddParcelamento.isSelected()) {
                    qtdparcelas = Integer.parseInt((String) cboxNumParcelas.getSelectedItem());
                    venda.setParcelamento(parcelamento.getCodigo());
                    venda.setQtdpagamento(qtdparcelas);
                    venda.setSubtotal(Double.parseDouble(subtotal));
                    venda.setTotal(Double.parseDouble(valortotal));
                    venda.setJuroscalculado(Double.parseDouble(lblJurosPercentual.getText()) / 100);
                } else {
                    venda.setParcelamento(1);
                    venda.setQtdpagamento(qtdparcelas);
                    venda.setSubtotal(Double.parseDouble(subtotal));
                    venda.setTotal(Double.parseDouble(valortotal));
                    venda.setJuroscalculado(Double.parseDouble(lblJurosPercentual.getText()) / 100);
                }

                codVenda = vendaControl.inserirVendaComParcelamento(venda);

                String a = cboxCliente.getSelectedItem().toString();
                String result[] = a.split("CPF");

                try {

                    DefaultTableModel modelListaVenda = (DefaultTableModel) tableProdutoServicoVenda.getModel();

                    List<ComprovanteVenda> listaComprovante = new ArrayList<>();

                    for (int i = 0; i < modelListaVenda.getRowCount(); i++) {
                        ComprovanteVenda comprovante = new ComprovanteVenda();

                        comprovante.setTipo(String.valueOf(tableProdutoServicoVenda.getValueAt(i, 1)));
                        comprovante.setDescricao(String.valueOf(tableProdutoServicoVenda.getValueAt(i, 2)));
                        comprovante.setQuantidade(String.valueOf(tableProdutoServicoVenda.getValueAt(i, 3)));
                        comprovante.setPrecounitario(Double.parseDouble(tableProdutoServicoVenda.getValueAt(i, 4).toString()));
                        comprovante.setPrecototal(Double.parseDouble(tableProdutoServicoVenda.getValueAt(i, 5).toString()));

                        listaComprovante.add(comprovante);
                    }

                    DefaultTableModel modelListaPagamento = (DefaultTableModel) tableQtdParcelas.getModel();

                    List<PagamentosColunas> listaPagamentoColunas = new ArrayList<>();

                    for (int i = 0; i < modelListaPagamento.getRowCount(); i++) {
                        PagamentosColunas pag = new PagamentosColunas();

                        pag.setParcela(String.valueOf(tableQtdParcelas.getValueAt(i, 0)));
                        pag.setValorparcela(String.valueOf(tableQtdParcelas.getValueAt(i, 1)));

                        listaPagamentoColunas.add(pag);
                    }

                    JRBeanCollectionDataSource itemJRBean = new JRBeanCollectionDataSource(listaComprovante);
                    JRBeanCollectionDataSource itemJRBean1 = new JRBeanCollectionDataSource(listaPagamentoColunas);

                    Map<String, Object> parametros = new HashMap<>();
                    parametros.put("CollectionBeanComprovante", itemJRBean);
                    parametros.put("CollectionBeanPagamentos", itemJRBean1);

                    parametros.put("numVenda", String.valueOf(codVenda));
                    parametros.put("dataVenda", venda.getDataPedido());
                    parametros.put("nomeCliente", result[0]);
                    parametros.put("qtdPagamentos", venda.getQtdpagamento());
                    parametros.put("subtotal", txtSubTotal.getText());
                    parametros.put("jurosPercentual", lblJurosPercentual.getText());
                    parametros.put("total", txtTotalVenda.getText());

                    String fonteRelatorio = "src/br/edu/ifsp/rel/ComprovanteVenda.jrxml";

                    InputStream entrada = new FileInputStream(new File(fonteRelatorio));

                    JasperDesign design = JRXmlLoader.load(entrada);

                    JasperReport relatorio = JasperCompileManager.compileReport(design);

                    JasperPrint print = JasperFillManager.fillReport(relatorio, parametros, new JREmptyDataSource());

                    JasperViewer.viewReport(print, false);
                } catch (JRException | FileNotFoundException ex) {
                    Logger.getLogger(InterFazerVenda.class.getName()).log(Level.SEVERE, null, ex);
                }

                //acrecenta os pagamentos
                acrescentarpagamento(valortotal, codVenda);

                // adiciona os recursos a venda(Produto e/ou Serviço)
                adicionaritens(codVenda);

                DefaultTableModel modelo = (DefaultTableModel) tableProdutoServicoVenda.getModel();
                modelo.setRowCount(0);
                DefaultTableModel modelo1 = (DefaultTableModel) tableQtdParcelas.getModel();
                modelo1.setRowCount(0);
                checkAddParcelamento.setSelected(false);
                cboxNumParcelas.setEnabled(checkAddParcelamento.isSelected());
                cboxNumParcelas.setSelectedIndex(0);
                txtSubTotal.setText("R$ 0,00");
                txtTotalVenda.setText("R$ 0,00");

                cboxCliente.setSelectedIndex(0);
                cboxProduto.setSelectedIndex(0);
                cboxServico.setSelectedIndex(0);

                listarVendas();
            }
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    public void acrescentarpagamento(String valortotal, int codVenda) {
        Date date = venda.getDataPedido();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        listaPagamento = new ArrayList<>();

        String valorparcela = valortotal;
        String numero = "1";

        for (int i = 0; i < venda.getQtdpagamento(); i++) {
            pagamento = new Pagamento();
            if (checkAddParcelamento.isSelected()) {
                numero = String.valueOf(tableQtdParcelas.getValueAt(i, 0)).replace("ª", "");
                valorparcela = String.valueOf(tableQtdParcelas.getValueAt(i, 1));
            }

            pagamento.setVenda(codVenda);
            pagamento.setNumero(Integer.parseInt(numero));
            pagamento.setPreco(Double.parseDouble(valorparcela.replace(" ", "").replace(",", ".")));
            pagamento.setDatavencimento(cal.getTime());

            String formPagamento = cboxFormaPagamento.getSelectedItem().toString();
            String result[] = formPagamento.split("-");

            if (venda.getQtdpagamento() == 1 || i == 0) {
                pagamento.setDatapagamento(cal.getTime());
                pagamento.setFormaPagamento(formaPagamentoControl.buscarCodigoFormaPagamento(result[0]).getCodigo());
                pagamento.setSituacao("Pago");
            } else {
                pagamento.setDatapagamento(null);
                pagamento.setSituacao("Pendente");
            }

            listaPagamento.add(pagamento);

            cal.add(Calendar.MONTH, 1);
        }
        pagamentoControl.inserir(listaPagamento);
    }

    public void adicionaritens(int codVenda) {
        listaItemVenda = new ArrayList<>();
        listaServicoVenda = new ArrayList<>();
        int cont = tableProdutoServicoVenda.getRowCount();
        int codigoProduto = 0;

        for (int i = 0; i < cont; i++) {
            if (tableProdutoServicoVenda.getValueAt(i, 1).equals("PRODUTO")) {
                codigoProduto = Integer.parseInt(String.valueOf(tableProdutoServicoVenda.getValueAt(i, 0)));
                itemVenda = new ItemVenda();
                produto = new Produto();

                itemVenda.setProduto(codigoProduto);
                itemVenda.setVenda(codVenda);
                itemVenda.setQuantidade(Double.parseDouble(String.valueOf(tableProdutoServicoVenda.getValueAt(i, 3))));
                itemVenda.setSubtotal(Double.parseDouble(String.valueOf(tableProdutoServicoVenda.getValueAt(i, 5))));

                //produto
                produto.setCodigo(codigoProduto);
                produto.setEstoque(produtoControl.buscarPorCodigo(String.valueOf(codigoProduto)).getEstoque() - Double.parseDouble(String.valueOf(tableProdutoServicoVenda.getValueAt(i, 3))));

                listaItemVenda.add(itemVenda);
                listaProdutos.add(produto);
            } else {
                servicoVenda = new ServicoVenda();
                servicoVenda.setServico(Integer.parseInt(String.valueOf(tableProdutoServicoVenda.getValueAt(i, 0))));
                servicoVenda.setVenda(codVenda);
                servicoVenda.setQuantidade(Double.parseDouble(String.valueOf(tableProdutoServicoVenda.getValueAt(i, 3))));
                servicoVenda.setSubtotal(Double.parseDouble(String.valueOf(tableProdutoServicoVenda.getValueAt(i, 5))));
                listaServicoVenda.add(servicoVenda);
            }
        }

        if (!listaItemVenda.isEmpty()) {
            // altera o estoque do produto
            produtoControl.alterarEstoqueLista(listaProdutos);
            itemVendaControl.inserir(listaItemVenda);
        }
        if (!listaServicoVenda.isEmpty()) {
            servicoVendaControl.inserir(listaServicoVenda);
        }
    }

    private void checkAddParcelamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkAddParcelamentoItemStateChanged
//        cboxNumParcelas.setEnabled(checkAddParcelamento.isSelected());
        if (!checkAddParcelamento.isSelected()) {
            cboxNumParcelas.setEnabled(checkAddParcelamento.isSelected());
            cboxNumParcelas.setSelectedIndex(0);

            DefaultTableModel modelo = (DefaultTableModel) tableQtdParcelas.getModel();
            modelo.setRowCount(0);
//
//            txtSubTotal.setText("");
            calcularParcelamentos();
        } else {
            cboxNumParcelas.setEnabled(checkAddParcelamento.isSelected());
            calcularParcelamentos();
        }
    }//GEN-LAST:event_checkAddParcelamentoItemStateChanged

    private void cboxNumParcelasPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboxNumParcelasPopupMenuWillBecomeInvisible
        if (tableProdutoServicoVenda.getRowCount() != 0) {
            calcularParcelamentos();
        }
    }//GEN-LAST:event_cboxNumParcelasPopupMenuWillBecomeInvisible

    private void tableVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVendasMouseClicked
        if (tableVendas.getSelectedRow() != -1) {
            listarProdutosServicosVenda();
        }
    }//GEN-LAST:event_tableVendasMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        String opt[] = {"Sim", "Não"};

        int op = JOptionPane.showOptionDialog(this, "Confirme o cancelamento da venda?", "Parar o pedido de venda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, opt[1]);

        if (op == JOptionPane.YES_OPTION) {
            try {
                this.setClosed(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(InterFazerVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
//            DefaultTableModel modelo = (DefaultTableModel) tableProdutoServicoVenda.getModel();
//            modelo.setRowCount(0);
//            DefaultTableModel modelo1 = (DefaultTableModel) tableQtdParcelas.getModel();
//            modelo1.setRowCount(0);
//            checkAddParcelamento.setSelected(false);
//            cboxNumParcelas.setEnabled(checkAddParcelamento.isSelected());
//            cboxNumParcelas.setSelectedIndex(0);
//            txtSubTotal.setText("R$ 0,00");
//            txtTotalVenda.setText("R$ 0,00");
//
//            cboxCliente.setSelectedIndex(0);
//            cboxProduto.setSelectedIndex(0);
//            cboxServico.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConsultaVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaVendasActionPerformed
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");

        if (dateMinVenda.getDate() == null || dateMaxVenda.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Campos de Data vazio!");
        } else if (dateMinVenda.getDate().compareTo(dateMaxVenda.getDate()) > 0) {
            JOptionPane.showMessageDialog(this, "A Data Máxima não pode ser menor que a Data Miníma para a consulta!");
        } else {
            String dateMin = form.format(dateMinVenda.getDate());
            String dateMax = form.format(dateMaxVenda.getDate());
            consultarTabelaVendas(dateMin, dateMax);
        }
    }//GEN-LAST:event_btnConsultaVendasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dateMinVenda.setDate(null);
        dateMaxVenda.setDate(null);
        txtPesquisa.setText("");
        listarVendas();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnVisualizarParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarParcelasActionPerformed
        if (tableVendas.getSelectedRow() != -1) {
            listaPagmentosVenda = new ArrayList<>();
            listaPagmentosVenda = pagamentoControl.consultarPagamentoVenda(String.valueOf(tableVendas.getValueAt(tableVendas.getSelectedRow(), 0)));

//            FramePagamentos frame = new FramePagamentos();
//
//            frame.exportarListaPagamento(listaPagmentosVenda);
//            frame.setVisible(true);
            DialogPagamentos dialog = new DialogPagamentos(new Frame(), true);

            dialog.exportarListaPagamento(listaPagmentosVenda);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma Venda da lista!");
        }
    }//GEN-LAST:event_btnVisualizarParcelasActionPerformed

    private void btnRelatorioVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioVendasActionPerformed
        if (dateMinVenda.getDate() == null || dateMaxVenda.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Um dos campos de inserção da data esta vazio!");
        } else if (dateMinVenda.getDate().compareTo(dateMaxVenda.getDate()) > 0) {
            JOptionPane.showMessageDialog(this, "A Data Máxima não pode ser menor que a Data Miníma!");
        } else {
            try {
                Map parametros = new HashMap();

                parametros.put("dataMin", dateMinVenda.getDate());
                parametros.put("dataMax", dateMaxVenda.getDate());

                JasperReport relCompilado = JasperCompileManager.compileReport("src/br/edu/ifsp/rel/RelatorioVenda.jrxml");

                JasperPrint relPreenchido = JasperFillManager.fillReport(relCompilado, parametros, Conexao.abrir());

                JFrame tela = new JFrame("Relatório de Vendas por Período");
                tela.setSize(1080, 720);

                JRViewer painelRelatorio = new JRViewer(relPreenchido);

                tela.getContentPane().add(painelRelatorio);

                tela.setVisible(true);

                System.out.println("Relatorio gerado");
            } catch (JRException ex) {
                Logger.getLogger(InterFazerVenda.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erro ao gerar Relatório de Venda");
            }
        }
    }//GEN-LAST:event_btnRelatorioVendasActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        pesquisarPorCliente(txtPesquisa.getText());
    }//GEN-LAST:event_txtPesquisaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduto;
    private javax.swing.JButton btnAddServico;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultaVendas;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRelatorioVendas;
    private javax.swing.JButton btnRemoveProduto;
    private javax.swing.JButton btnVisualizarParcelas;
    private javax.swing.JComboBox<String> cboxCliente;
    private javax.swing.JComboBox<String> cboxFormaPagamento;
    private javax.swing.JComboBox<String> cboxNumParcelas;
    private javax.swing.JComboBox<String> cboxProduto;
    private javax.swing.JComboBox<String> cboxServico;
    private javax.swing.JCheckBox checkAddParcelamento;
    private com.toedter.calendar.JDateChooser dateMaxVenda;
    private com.toedter.calendar.JDateChooser dateMinVenda;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelEstoque;
    private javax.swing.JLabel labelEstoque1;
    private javax.swing.JLabel lblJurosPercentual;
    private javax.swing.JLabel lblJurosPercentual1;
    private javax.swing.JPanel panelFazerVenda;
    private javax.swing.JTable tableProdutoServicoVenda;
    private javax.swing.JTable tableProdutosVenda;
    private javax.swing.JTable tableQtdParcelas;
    private javax.swing.JTable tableServicosVenda;
    private javax.swing.JTable tableVendas;
    private javax.swing.JTextField txtBuscaCliente;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtCodServico;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtQtdProduto;
    private javax.swing.JTextField txtQtdServico;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotalVenda;
    // End of variables declaration//GEN-END:variables

    private void listarClientes() {
        listaClientes = clienteControl.listar();

        cboxCliente.removeAllItems();

        cboxCliente.addItem("- Selecione o Cliente -");

        for (Cliente listaC : listaClientes) {
            cboxCliente.addItem(listaC.toString());
        }
    }

    private void listarProdutos() {
        listaProdutos = produtoControl.listar();

        cboxProduto.removeAllItems();

        cboxProduto.addItem("- Selecione o produto -");

        for (Produto listaP : listaProdutos) {
            cboxProduto.addItem(listaP.toString());
        }
    }

    private void listarServicos() {
        listaServicos = servicoControl.listar();

        cboxServico.removeAllItems();

        cboxServico.addItem("- Selecione o serviço -");

        for (Servico listaS : listaServicos) {
            cboxServico.addItem(listaS.toString());
        }
    }

    private void somarValorTotalProdutoServico() {
        double soma = 0;
        double valor;
        int cont = tableProdutoServicoVenda.getRowCount();

        for (int i = 0; i < cont; i++) {
            valor = (double) tableProdutoServicoVenda.getValueAt(i, 5);
            soma = soma + valor;
        }

        String monetario = String.valueOf(String.format("%.2f", soma));
        String monetarioFormat = monetario.replace(" ", "").replace(".", ",");
        txtSubTotal.setText("R$ " + monetarioFormat);
        txtTotalVenda.setText("R$ " + monetarioFormat);
    }

    private void subtrairValorProdutoServico(int linha) {
        DefaultTableModel modelo = (DefaultTableModel) tableProdutoServicoVenda.getModel();
        String valorVenda = txtTotalVenda.getText().replace("R$", "").replace(" ", "").replace(",", ".");
        double subtracao = Double.parseDouble(valorVenda);

        subtracao = subtracao - (double) tableProdutoServicoVenda.getValueAt(linha, 5);

        modelo.removeRow(linha);

        String monetario = String.valueOf(String.format("%.2f", subtracao));
        String monetarioFormat = monetario.replace(" ", "").replace(".", ",");
        txtSubTotal.setText("R$ " + monetarioFormat);
        txtTotalVenda.setText("R$ " + monetarioFormat);
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public void calcularParcelamentos() {
        int numero = Integer.parseInt(String.valueOf(cboxNumParcelas.getSelectedItem()));
        double parcelas;
        DefaultTableModel modelo = (DefaultTableModel) tableQtdParcelas.getModel();

        parcelamento = parcelamentoControl.compararParcelamento(numero);
        
        System.out.println("CÓDIGO DO PARCELAMENTO: " + parcelamento.getCodigo());

        double jurospercentual = 100 * parcelamento.getJurospercentual();

        lblJurosPercentual.setText(String.valueOf(jurospercentual));

        double total = Double.parseDouble(txtSubTotal.getText().replace("R$", "").replace(" ", "").replace(",", "."));
        total = total + (total * parcelamento.getJurospercentual());

        parcelas = total / numero;

        modelo.setRowCount(0);
        for (int i = 1; i <= numero; i++) {
            modelo.addRow(new String[]{
                String.valueOf(i) + "ª",
                String.format("%.2f", parcelas)
            });
        }
        txtTotalVenda.setText(String.format("R$ %.2f", total));
    }

    public void listarVendas() {
        DefaultTableModel modelo = (DefaultTableModel) tableVendas.getModel();
        modelo.setNumRows(0);
        listaEntidadesVenda = entidadesVendaControl.listar();

        int cont = listaEntidadesVenda.size();

        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaEntidadesVenda.get(i).getVendaObj().getCodigo(),
                listaEntidadesVenda.get(i).getClientesObj().getNome(),
                listaEntidadesVenda.get(i).getFuncionariosObj().getNome(),
                listaEntidadesVenda.get(i).getVendaObj().getDataPedido(),
                listaEntidadesVenda.get(i).getVendaObj().getSubtotal(),
                listaEntidadesVenda.get(i).getVendaObj().getTotal(),
                listaEntidadesVenda.get(i).getVendaObj().getQtdpagamento(),
                100 * listaEntidadesVenda.get(i).getVendaObj().getJuroscalculado() + "%"
            });
        }
        organizarJtableVendas();
    }

    private void listarProdutosServicosVenda() {
        DefaultTableModel modeloProduto = (DefaultTableModel) tableProdutosVenda.getModel();
        DefaultTableModel modeloServico = (DefaultTableModel) tableServicosVenda.getModel();
        modeloProduto.setNumRows(0);
        modeloServico.setNumRows(0);

        String indice = String.valueOf(tableVendas.getValueAt(tableVendas.getSelectedRow(), 0));

        listaEntidadesItemVenda = itemVendaControl.listarItensVenda(indice);
        listaEntidadesServicoVenda = servicoVendaControl.listarServicosVenda(indice);

        int cont = listaEntidadesItemVenda.size();
        for (int i = 0; i < cont; i++) {
            modeloProduto.addRow(new Object[]{
                listaEntidadesItemVenda.get(i).getProdutoObj().getCodigo(),
                listaEntidadesItemVenda.get(i).getProdutoObj().getDescricao(),
                listaEntidadesItemVenda.get(i).getItemVendaObj().getQuantidade(),
                listaEntidadesItemVenda.get(i).getProdutoObj().getPreco(),
                listaEntidadesItemVenda.get(i).getItemVendaObj().getSubtotal()
            });
        }

        cont = listaEntidadesServicoVenda.size();
        for (int i = 0; i < cont; i++) {
            modeloServico.addRow(new Object[]{
                listaEntidadesServicoVenda.get(i).getServicoObj().getCodigo(),
                listaEntidadesServicoVenda.get(i).getServicoObj().getDescricao(),
                listaEntidadesServicoVenda.get(i).getServicoVendaObj().getQuantidade(),
                listaEntidadesServicoVenda.get(i).getServicoObj().getPreco(),
                listaEntidadesServicoVenda.get(i).getServicoVendaObj().getSubtotal()
            });
        }
        organizarJTableProdutoServicoVenda();
    }

    private void organizarJtableVendas() {
        tableVendas.getColumnModel().getColumn(3).setCellRenderer(FormatRenderer.getDateRenderer());
        tableVendas.getColumnModel().getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());
        tableVendas.getColumnModel().getColumn(5).setCellRenderer(NumberRenderer.getCurrencyRenderer());
        tableVendas.getColumnModel().getColumn(6).setCellRenderer(NumberRenderer.getNumberRenderer(FRAMEBITS));
    }

    private void organizarJTableProdutoServicoVenda() {
        tableProdutosVenda.getColumnModel().getColumn(2).setCellRenderer(NumberRenderer.getNumberRenderer(FRAMEBITS));
        tableProdutosVenda.getColumnModel().getColumn(3).setCellRenderer(NumberRenderer.getCurrencyRenderer());
        tableProdutosVenda.getColumnModel().getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());

        tableServicosVenda.getColumnModel().getColumn(2).setCellRenderer(NumberRenderer.getNumberRenderer(FRAMEBITS));
        tableServicosVenda.getColumnModel().getColumn(3).setCellRenderer(NumberRenderer.getCurrencyRenderer());
        tableServicosVenda.getColumnModel().getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());
    }

    private boolean verificarQuantidadeEstoque() {
        Double estoque = Double.parseDouble(labelEstoque.getText().replace(",", "."));
        Double quantia = Double.parseDouble(txtQtdProduto.getText());

        if (quantia > estoque) {
            return false;
        } else {
            return true;
        }
    }

    private void consultarTabelaVendas(String dateMin, String dateMax) {
        DefaultTableModel modelo = (DefaultTableModel) tableVendas.getModel();
        modelo.setNumRows(0);
        listaEntidadesVenda = entidadesVendaControl.consultarVendas(dateMin, dateMax);

        int cont = listaEntidadesVenda.size();

        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaEntidadesVenda.get(i).getVendaObj().getCodigo(),
                listaEntidadesVenda.get(i).getClientesObj().getNome(),
                listaEntidadesVenda.get(i).getFuncionariosObj().getNome(),
                listaEntidadesVenda.get(i).getVendaObj().getDataPedido(),
                listaEntidadesVenda.get(i).getVendaObj().getSubtotal(),
                listaEntidadesVenda.get(i).getVendaObj().getTotal(),
                listaEntidadesVenda.get(i).getVendaObj().getQtdpagamento(),
                100 * listaEntidadesVenda.get(i).getVendaObj().getJuroscalculado() + "%"
            });
        }
        organizarJtableVendas();
    }

    private void listarFormaPagamento() {
        listaFormaPagamento = formaPagamentoControl.listar();

        cboxFormaPagamento.removeAllItems();

        cboxFormaPagamento.addItem("- Selecione a Forma de Pagamento -");

        for (FormaPagamento listaFp : listaFormaPagamento) {
            cboxFormaPagamento.addItem(listaFp.toString());
        }
    }

    private void pesquisarPorCliente(String nome) {
        DefaultTableModel modelo = (DefaultTableModel) tableVendas.getModel();
        modelo.setNumRows(0);
        listaEntidadesVenda = entidadesVendaControl.consultarVendasPorNome(nome);

        int cont = listaEntidadesVenda.size();

        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaEntidadesVenda.get(i).getVendaObj().getCodigo(),
                listaEntidadesVenda.get(i).getClientesObj().getNome(),
                listaEntidadesVenda.get(i).getFuncionariosObj().getNome(),
                listaEntidadesVenda.get(i).getVendaObj().getDataPedido(),
                listaEntidadesVenda.get(i).getVendaObj().getSubtotal(),
                listaEntidadesVenda.get(i).getVendaObj().getTotal(),
                listaEntidadesVenda.get(i).getVendaObj().getQtdpagamento(),
                100 * listaEntidadesVenda.get(i).getVendaObj().getJuroscalculado() + "%"
            });
        }
        organizarJtableVendas();
    }
}
