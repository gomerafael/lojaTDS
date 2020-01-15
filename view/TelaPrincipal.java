/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.view;

import java.awt.Toolkit;
import java.util.Observer;
import lojatds.controller.ClienteController;
import lojatds.controller.CompraController;
import lojatds.controller.FornecedorController;
import lojatds.controller.ProdutoController;
import lojatds.controller.VendaController;
import lojatds.model.dao.DAOFactory;
import lojatds.model.dao.jdbc.ConnectionFactory;

/**
 *
 * @author Rafa
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrameTelaBemVindo = new javax.swing.JInternalFrame();
        jLabelGerenciar = new javax.swing.JLabel();
        jButtonTelaBemVindoSair = new javax.swing.JButton();
        jButtonGerenciarCliente = new javax.swing.JButton();
        jButtonGerenciarFornecedor = new javax.swing.JButton();
        jButtonGerenciarProduto = new javax.swing.JButton();
        jLabelFerramentas = new javax.swing.JLabel();
        jButtonEfetuarVenda = new javax.swing.JButton();
        jButtonEfetuarCompra = new javax.swing.JButton();
        jLabelEstoque = new javax.swing.JLabel();
        jButtonEstoqueAtual = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuGerenciar = new javax.swing.JMenu();
        jMenuItemCadCliente = new javax.swing.JMenuItem();
        jMenuItemCadFornecedor = new javax.swing.JMenuItem();
        jMenuItemCadProduto = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuItemRelatorioFornecedores = new javax.swing.JMenuItem();
        jMenuItemRelatorioClientes = new javax.swing.JMenuItem();
        jMenuItemRelatorioVendas = new javax.swing.JMenuItem();
        jMenuItemRelatorioCompras = new javax.swing.JMenuItem();
        jMenuFerramentas = new javax.swing.JMenu();
        jMenuItemVenda = new javax.swing.JMenuItem();
        jMenuItemCompra = new javax.swing.JMenuItem();
        jMenuItemTelaBemVindo = new javax.swing.JMenuItem();
        jMenuEstoque = new javax.swing.JMenu();
        jMenuItemEstoqueAtual = new javax.swing.JMenuItem();
        jMenuOpcoesSair = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jInternalFrameTelaBemVindo.setTitle("Loja calif");
        jInternalFrameTelaBemVindo.setVisible(true);
        jInternalFrameTelaBemVindo.getContentPane().setLayout(null);

        jLabelGerenciar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelGerenciar.setText("Gerenciar");
        jInternalFrameTelaBemVindo.getContentPane().add(jLabelGerenciar);
        jLabelGerenciar.setBounds(20, 60, 60, 14);

        jButtonTelaBemVindoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/Exit_1.jpg"))); // NOI18N
        jButtonTelaBemVindoSair.setToolTipText("Fechar tela");
        jButtonTelaBemVindoSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTelaBemVindoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTelaBemVindoSairActionPerformed(evt);
            }
        });
        jInternalFrameTelaBemVindo.getContentPane().add(jButtonTelaBemVindoSair);
        jButtonTelaBemVindoSair.setBounds(1070, 10, 30, 30);

        jButtonGerenciarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/Iconeuser.png"))); // NOI18N
        jButtonGerenciarCliente.setToolTipText("Gerenciar Clientes");
        jButtonGerenciarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGerenciarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarClienteActionPerformed(evt);
            }
        });
        jInternalFrameTelaBemVindo.getContentPane().add(jButtonGerenciarCliente);
        jButtonGerenciarCliente.setBounds(20, 80, 100, 110);

        jButtonGerenciarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/user-12.png"))); // NOI18N
        jButtonGerenciarFornecedor.setToolTipText("Gerenciar Fornecedores");
        jButtonGerenciarFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGerenciarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarFornecedorActionPerformed(evt);
            }
        });
        jInternalFrameTelaBemVindo.getContentPane().add(jButtonGerenciarFornecedor);
        jButtonGerenciarFornecedor.setBounds(140, 80, 100, 110);

        jButtonGerenciarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/iconprodc.png"))); // NOI18N
        jButtonGerenciarProduto.setToolTipText("Gerenciar Produtos");
        jButtonGerenciarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGerenciarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarProdutoActionPerformed(evt);
            }
        });
        jInternalFrameTelaBemVindo.getContentPane().add(jButtonGerenciarProduto);
        jButtonGerenciarProduto.setBounds(260, 80, 100, 110);

        jLabelFerramentas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelFerramentas.setText("Ferramentas");
        jInternalFrameTelaBemVindo.getContentPane().add(jLabelFerramentas);
        jLabelFerramentas.setBounds(20, 210, 80, 14);

        jButtonEfetuarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/iconevendascar.png"))); // NOI18N
        jButtonEfetuarVenda.setToolTipText("Efetuar venda");
        jButtonEfetuarVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEfetuarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEfetuarVendaActionPerformed(evt);
            }
        });
        jInternalFrameTelaBemVindo.getContentPane().add(jButtonEfetuarVenda);
        jButtonEfetuarVenda.setBounds(20, 230, 100, 110);

        jButtonEfetuarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/iconebag.png"))); // NOI18N
        jButtonEfetuarCompra.setToolTipText("Efetuar compra");
        jButtonEfetuarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEfetuarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEfetuarCompraActionPerformed(evt);
            }
        });
        jInternalFrameTelaBemVindo.getContentPane().add(jButtonEfetuarCompra);
        jButtonEfetuarCompra.setBounds(140, 230, 100, 110);

        jLabelEstoque.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelEstoque.setText("Estoque");
        jInternalFrameTelaBemVindo.getContentPane().add(jLabelEstoque);
        jLabelEstoque.setBounds(20, 360, 80, 14);

        jButtonEstoqueAtual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/Iconeestoqueatual.png"))); // NOI18N
        jButtonEstoqueAtual.setToolTipText("Estoque atual");
        jButtonEstoqueAtual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEstoqueAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstoqueAtualActionPerformed(evt);
            }
        });
        jInternalFrameTelaBemVindo.getContentPane().add(jButtonEstoqueAtual);
        jButtonEstoqueAtual.setBounds(20, 380, 100, 110);

        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jInternalFrameTelaBemVindo.getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 50, 1090, 480);

        getContentPane().add(jInternalFrameTelaBemVindo);
        jInternalFrameTelaBemVindo.setBounds(0, 90, 1130, 560);
        this.setExtendedState(MAXIMIZED_BOTH);

        jMenuGerenciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/user_gray.png"))); // NOI18N
        jMenuGerenciar.setText("Gerenciar");
        jMenuGerenciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItemCadCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/user_green.png"))); // NOI18N
        jMenuItemCadCliente.setText("Clientes");
        jMenuItemCadCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadClienteActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemCadCliente);

        jMenuItemCadFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/user_orange.png"))); // NOI18N
        jMenuItemCadFornecedor.setText("Fornecedores");
        jMenuItemCadFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemCadFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadFornecedorActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemCadFornecedor);

        jMenuItemCadProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/box.png"))); // NOI18N
        jMenuItemCadProduto.setText("Produtos");
        jMenuItemCadProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemCadProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadProdutoActionPerformed(evt);
            }
        });
        jMenuGerenciar.add(jMenuItemCadProduto);

        jMenuBar1.add(jMenuGerenciar);

        jMenuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/page_white_acrobat.png"))); // NOI18N
        jMenuRelatorio.setText("Relatórios");
        jMenuRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItemRelatorioFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/group_gear.png"))); // NOI18N
        jMenuItemRelatorioFornecedores.setText("Relatório de fornecedores");
        jMenuItemRelatorioFornecedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemRelatorioFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioFornecedoresActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItemRelatorioFornecedores);

        jMenuItemRelatorioClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/group.png"))); // NOI18N
        jMenuItemRelatorioClientes.setText("Relatório de clientes");
        jMenuItemRelatorioClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemRelatorioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioClientesActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItemRelatorioClientes);

        jMenuItemRelatorioVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/chart_bar.png"))); // NOI18N
        jMenuItemRelatorioVendas.setText("Relatório de vendas");
        jMenuItemRelatorioVendas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemRelatorioVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioVendasActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItemRelatorioVendas);

        jMenuItemRelatorioCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/chart_curve.png"))); // NOI18N
        jMenuItemRelatorioCompras.setText("Relatório de compras");
        jMenuItemRelatorioCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemRelatorioCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioComprasActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItemRelatorioCompras);

        jMenuBar1.add(jMenuRelatorio);

        jMenuFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/wrench.png"))); // NOI18N
        jMenuFerramentas.setText("Ferramentas");
        jMenuFerramentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItemVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/cart_put.png"))); // NOI18N
        jMenuItemVenda.setText("Efetuar venda");
        jMenuItemVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVendaActionPerformed(evt);
            }
        });
        jMenuFerramentas.add(jMenuItemVenda);

        jMenuItemCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/basket_go.png"))); // NOI18N
        jMenuItemCompra.setText("Efetuar compra");
        jMenuItemCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCompraActionPerformed(evt);
            }
        });
        jMenuFerramentas.add(jMenuItemCompra);

        jMenuItemTelaBemVindo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/computer_link.png"))); // NOI18N
        jMenuItemTelaBemVindo.setText("Tela de interação");
        jMenuItemTelaBemVindo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemTelaBemVindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTelaBemVindoActionPerformed(evt);
            }
        });
        jMenuFerramentas.add(jMenuItemTelaBemVindo);

        jMenuBar1.add(jMenuFerramentas);

        jMenuEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/database_gear.png"))); // NOI18N
        jMenuEstoque.setText("Estoque");
        jMenuEstoque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItemEstoqueAtual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/door_open.png"))); // NOI18N
        jMenuItemEstoqueAtual.setText("Estoque atual");
        jMenuItemEstoqueAtual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemEstoqueAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstoqueAtualActionPerformed(evt);
            }
        });
        jMenuEstoque.add(jMenuItemEstoqueAtual);

        jMenuBar1.add(jMenuEstoque);

        jMenuOpcoesSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/cog_go.png"))); // NOI18N
        jMenuOpcoesSair.setText("Opções");
        jMenuOpcoesSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItemSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/cancel.png"))); // NOI18N
        jMenuItemSair.setText("Sair");
        jMenuItemSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuOpcoesSair.add(jMenuItemSair);

        jMenuBar1.add(jMenuOpcoesSair);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1147, 716));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        TelaSair telasair = new TelaSair();
        telasair.setVisible(true);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemCadProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadProdutoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaGerenciarClientes().setVisible(true);
                DAOFactory dao = DAOFactory.getDAOFactory();
                ProdutoController controller = new ProdutoController(dao);
                TelaGerenciarProdutos view = new TelaGerenciarProdutos(controller);
                controller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItemCadProdutoActionPerformed

    private void jMenuItemCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCompraActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                DAOFactory dao = DAOFactory.getDAOFactory();
                FornecedorController fornecedorcontroller = new FornecedorController(dao);
                ProdutoController produtocontroller = new ProdutoController(dao);
                CompraController compracontroller = new CompraController(dao);
                TelaEfetuarCompra view = new TelaEfetuarCompra(fornecedorcontroller, produtocontroller,compracontroller);
                fornecedorcontroller.addObserver(view);
                produtocontroller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItemCompraActionPerformed

    private void jMenuItemEstoqueAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstoqueAtualActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DAOFactory dao = DAOFactory.getDAOFactory();
                ProdutoController controller = new ProdutoController(dao);
                TelaEstoqueAtual view = new TelaEstoqueAtual(controller);
                controller.addObserver((Observer) view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItemEstoqueAtualActionPerformed

    private void jMenuItemCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadClienteActionPerformed
        //TelaGerenciarClientes telagercliente = new TelaGerenciarClientes();
        //telagercliente.setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DAOFactory dao = DAOFactory.getDAOFactory();
                ClienteController cctrl = new ClienteController(dao);
                TelaGerenciarClientes view = new TelaGerenciarClientes(cctrl);
                cctrl.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItemCadClienteActionPerformed

    private void jMenuItemCadFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadFornecedorActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaGerenciarClientes().setVisible(true);
                DAOFactory dao = DAOFactory.getDAOFactory();
                FornecedorController controller = new FornecedorController(dao);
                TelaGerenciarFornecedores view = new TelaGerenciarFornecedores(controller);
                controller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItemCadFornecedorActionPerformed

    private void jMenuItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVendaActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                DAOFactory dao = DAOFactory.getDAOFactory();
                ClienteController clientecontroller = new ClienteController(dao);
                ProdutoController produtocontroller = new ProdutoController(dao);
                VendaController vendacontroller = new VendaController(dao);
                TelaEfetuarVenda view = new TelaEfetuarVenda(clientecontroller, produtocontroller, vendacontroller);
                clientecontroller.addObserver(view);
                produtocontroller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItemVendaActionPerformed

    private void jButtonTelaBemVindoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTelaBemVindoSairActionPerformed
        jInternalFrameTelaBemVindo.dispose();
    }//GEN-LAST:event_jButtonTelaBemVindoSairActionPerformed

    private void jButtonGerenciarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarClienteActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DAOFactory dao = DAOFactory.getDAOFactory();
                ClienteController cctrl = new ClienteController(dao);
                TelaGerenciarClientes view = new TelaGerenciarClientes(cctrl);
                cctrl.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonGerenciarClienteActionPerformed

    private void jButtonGerenciarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarFornecedorActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaGerenciarClientes().setVisible(true);
                DAOFactory dao = DAOFactory.getDAOFactory();
                FornecedorController controller = new FornecedorController(dao);
                TelaGerenciarFornecedores view = new TelaGerenciarFornecedores(controller);
                controller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonGerenciarFornecedorActionPerformed

    private void jButtonGerenciarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarProdutoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                DAOFactory dao = DAOFactory.getDAOFactory();
                ProdutoController controller = new ProdutoController(dao);
                TelaGerenciarProdutos view = new TelaGerenciarProdutos(controller);
                controller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonGerenciarProdutoActionPerformed

    private void jMenuItemTelaBemVindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTelaBemVindoActionPerformed
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemTelaBemVindoActionPerformed

    private void jButtonEfetuarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEfetuarVendaActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                DAOFactory dao = DAOFactory.getDAOFactory();
                ClienteController clientecontroller = new ClienteController(dao);
                ProdutoController produtocontroller = new ProdutoController(dao);
                VendaController vendacontroller = new VendaController(dao);
                TelaEfetuarVenda view = new TelaEfetuarVenda(clientecontroller, produtocontroller, vendacontroller);
                clientecontroller.addObserver(view);
                produtocontroller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonEfetuarVendaActionPerformed

    private void jButtonEfetuarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEfetuarCompraActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                DAOFactory dao = DAOFactory.getDAOFactory();
                FornecedorController fornecedorcontroller = new FornecedorController(dao);
                ProdutoController produtocontroller = new ProdutoController(dao);
                CompraController compracontroller = new CompraController(dao);
                TelaEfetuarCompra view = new TelaEfetuarCompra(fornecedorcontroller, produtocontroller,compracontroller);
                fornecedorcontroller.addObserver(view);
                produtocontroller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonEfetuarCompraActionPerformed

    private void jButtonEstoqueAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstoqueAtualActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DAOFactory dao = DAOFactory.getDAOFactory();
                ProdutoController controller = new ProdutoController(dao);
                TelaEstoqueAtual view = new TelaEstoqueAtual(controller);
                controller.addObserver((Observer) view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonEstoqueAtualActionPerformed

    private void jMenuItemRelatorioFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioFornecedoresActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaGerenciarClientes().setVisible(true);
                DAOFactory dao = DAOFactory.getDAOFactory();
                FornecedorController controller = new FornecedorController(dao);
                TelaRelatorioFornecedores view = new TelaRelatorioFornecedores(controller);
                controller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItemRelatorioFornecedoresActionPerformed

    private void jMenuItemRelatorioClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioClientesActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaGerenciarClientes().setVisible(true);
                DAOFactory dao = DAOFactory.getDAOFactory();
                ClienteController controller = new ClienteController(dao);
                TelaRelatorioClientes view = new TelaRelatorioClientes(controller);
                controller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItemRelatorioClientesActionPerformed

    private void jMenuItemRelatorioVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioVendasActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaGerenciarClientes().setVisible(true);
                DAOFactory dao = DAOFactory.getDAOFactory();
                VendaController controller = new VendaController(dao);
                TelaRelatorioVendas view = new TelaRelatorioVendas(controller);
                controller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItemRelatorioVendasActionPerformed

    private void jMenuItemRelatorioComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioComprasActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaGerenciarClientes().setVisible(true);
                DAOFactory dao = DAOFactory.getDAOFactory();
                CompraController controller = new CompraController(dao);
                TelaRelatorioCompras view = new TelaRelatorioCompras(controller);
                controller.addObserver(view);
                view.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItemRelatorioComprasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEfetuarCompra;
    private javax.swing.JButton jButtonEfetuarVenda;
    private javax.swing.JButton jButtonEstoqueAtual;
    private javax.swing.JButton jButtonGerenciarCliente;
    private javax.swing.JButton jButtonGerenciarFornecedor;
    private javax.swing.JButton jButtonGerenciarProduto;
    private javax.swing.JButton jButtonTelaBemVindoSair;
    private javax.swing.JInternalFrame jInternalFrameTelaBemVindo;
    private javax.swing.JLabel jLabelEstoque;
    private javax.swing.JLabel jLabelFerramentas;
    private javax.swing.JLabel jLabelGerenciar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEstoque;
    private javax.swing.JMenu jMenuFerramentas;
    private javax.swing.JMenu jMenuGerenciar;
    private javax.swing.JMenuItem jMenuItemCadCliente;
    private javax.swing.JMenuItem jMenuItemCadFornecedor;
    private javax.swing.JMenuItem jMenuItemCadProduto;
    private javax.swing.JMenuItem jMenuItemCompra;
    private javax.swing.JMenuItem jMenuItemEstoqueAtual;
    private javax.swing.JMenuItem jMenuItemRelatorioClientes;
    private javax.swing.JMenuItem jMenuItemRelatorioCompras;
    private javax.swing.JMenuItem jMenuItemRelatorioFornecedores;
    private javax.swing.JMenuItem jMenuItemRelatorioVendas;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemTelaBemVindo;
    private javax.swing.JMenuItem jMenuItemVenda;
    private javax.swing.JMenu jMenuOpcoesSair;
    private javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
