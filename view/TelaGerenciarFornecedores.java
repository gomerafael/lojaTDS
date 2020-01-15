/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lojatds.controller.FornecedorController;
import lojatds.model.Fornecedor;
import lojatds.model.dao.DAOFactory;
import lojatds.model.dao.DatabaseException;
import lojatds.model.dao.jdbc.ConnectionFactory;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Rafa
 */
public class TelaGerenciarFornecedores extends javax.swing.JFrame implements Observer {

    private final FornecedorController controller;
    private FornecedorTableModel fornecedorModel;
    private static Connection conn;

    public TelaGerenciarFornecedores(FornecedorController controller) {
        super("Gerenciar Fornecedores");
        this.controller = controller;
        fornecedorModel = new FornecedorTableModel();
        initComponents();
        jTableFornecedores.setModel(fornecedorModel);
        try {
            fornecedorModel.updateFornecedores(controller.listar());
        } catch (DatabaseException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco: " + ex.getMessage());
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

        jInternalFrameFornecedor = new javax.swing.JInternalFrame();
        jTextFieldPesquisarFornecedor = new javax.swing.JTextField();
        jButtonPesquisarFornecedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFornecedores = new javax.swing.JTable();
        jLabelCodigoFornecedor = new javax.swing.JLabel();
        jTextFieldCodigoFornecedor = new javax.swing.JTextField();
        jLabelNomeFornecedor = new javax.swing.JLabel();
        jTextFieldNomeFornecedor = new javax.swing.JTextField();
        jLabelCnpjFornecedor = new javax.swing.JLabel();
        jLabelTelefoneFornecedor = new javax.swing.JLabel();
        jLabelCepFornecedor = new javax.swing.JLabel();
        jFormattedTextFieldTelefoneFornecedor = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCepFornecedor = new javax.swing.JFormattedTextField();
        jLabelLogradouroFornecedor = new javax.swing.JLabel();
        jTextFieldLogradouroFornecedor = new javax.swing.JTextField();
        jLabelCidadeFornecedor = new javax.swing.JLabel();
        jTextFieldCidadeFornecedor = new javax.swing.JTextField();
        jLabelUfFornecedor = new javax.swing.JLabel();
        jButtonNovoFornecedor = new javax.swing.JButton();
        jButtonEditarFornecedor = new javax.swing.JButton();
        jButtonExcluirFornecedor = new javax.swing.JButton();
        jButtonLimparFornecedor = new javax.swing.JButton();
        jFormattedTextFieldCnpjFornecedor = new javax.swing.JFormattedTextField();
        jComboBoxUfFornecedor = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jInternalFrameFornecedor.setVisible(true);

        jTextFieldPesquisarFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarFornecedorKeyReleased(evt);
            }
        });

        jButtonPesquisarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/search.png"))); // NOI18N
        jButtonPesquisarFornecedor.setText("Pesquisar");
        jButtonPesquisarFornecedor.setToolTipText("Pesquisar fornecedores");
        jButtonPesquisarFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarFornecedorActionPerformed(evt);
            }
        });

        jTableFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFornecedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFornecedores);

        jLabelCodigoFornecedor.setText("Código:");

        jTextFieldCodigoFornecedor.setEnabled(false);

        jLabelNomeFornecedor.setText("Nome:");

        jLabelCnpjFornecedor.setText("CNPJ:");

        jLabelTelefoneFornecedor.setText("Telefone:");

        jLabelCepFornecedor.setText("CEP:");

        try {
            jFormattedTextFieldTelefoneFornecedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldCepFornecedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelLogradouroFornecedor.setText("Logradouro:");

        jLabelCidadeFornecedor.setText("Cidade:");

        jTextFieldCidadeFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCidadeFornecedorActionPerformed(evt);
            }
        });

        jLabelUfFornecedor.setText("UF:");

        jButtonNovoFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/user_add.png"))); // NOI18N
        jButtonNovoFornecedor.setText("Novo");
        jButtonNovoFornecedor.setToolTipText("Cadastrar novo fornecedor");
        jButtonNovoFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNovoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoFornecedorActionPerformed(evt);
            }
        });

        jButtonEditarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/user_edit.png"))); // NOI18N
        jButtonEditarFornecedor.setText("Editar");
        jButtonEditarFornecedor.setToolTipText("Editar fornecedor");
        jButtonEditarFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarFornecedorActionPerformed(evt);
            }
        });

        jButtonExcluirFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/user_delete.png"))); // NOI18N
        jButtonExcluirFornecedor.setText("Excluir");
        jButtonExcluirFornecedor.setToolTipText("Excluir fornecedor");
        jButtonExcluirFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExcluirFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirFornecedorActionPerformed(evt);
            }
        });

        jButtonLimparFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/DeleteGrey.png"))); // NOI18N
        jButtonLimparFornecedor.setText("Limpar");
        jButtonLimparFornecedor.setToolTipText("Limpar campos");
        jButtonLimparFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLimparFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparFornecedorActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldCnpjFornecedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jComboBoxUfFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        javax.swing.GroupLayout jInternalFrameFornecedorLayout = new javax.swing.GroupLayout(jInternalFrameFornecedor.getContentPane());
        jInternalFrameFornecedor.getContentPane().setLayout(jInternalFrameFornecedorLayout);
        jInternalFrameFornecedorLayout.setHorizontalGroup(
            jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                        .addComponent(jTextFieldPesquisarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addGap(267, 267, 267))
                    .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                        .addComponent(jLabelCodigoFornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabelTelefoneFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldTelefoneFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                                .addComponent(jLabelNomeFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeFornecedor)))
                        .addGap(196, 196, 196))
                    .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                        .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCepFornecedor)
                            .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                                .addComponent(jLabelCnpjFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldCnpjFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(504, Short.MAX_VALUE))
                    .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                        .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                                .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                                        .addComponent(jLabelCidadeFornecedor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldCidadeFornecedor)
                                        .addGap(23, 23, 23)
                                        .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                                                .addComponent(jLabelLogradouroFornecedor)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldLogradouroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                                                .addComponent(jLabelUfFornecedor)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jComboBoxUfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                                                        .addComponent(jButtonEditarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(89, 89, 89)
                                                        .addComponent(jButtonExcluirFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(95, 95, 95))
                                    .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                                        .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButtonNovoFornecedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrameFornecedorLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(jFormattedTextFieldCepFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jButtonLimparFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jInternalFrameFornecedorLayout.setVerticalGroup(
            jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jTextFieldPesquisarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                    .addGroup(jInternalFrameFornecedorLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPesquisarFornecedor)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigoFornecedor)
                    .addComponent(jTextFieldCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeFornecedor)
                    .addComponent(jTextFieldNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCnpjFornecedor)
                    .addComponent(jLabelTelefoneFornecedor)
                    .addComponent(jFormattedTextFieldTelefoneFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCnpjFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCepFornecedor)
                    .addComponent(jFormattedTextFieldCepFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLogradouroFornecedor)
                    .addComponent(jTextFieldLogradouroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCidadeFornecedor)
                    .addComponent(jTextFieldCidadeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUfFornecedor)
                    .addComponent(jComboBoxUfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jInternalFrameFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluirFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimparFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrameFornecedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrameFornecedor)
        );

        setSize(new java.awt.Dimension(710, 573));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCidadeFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCidadeFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCidadeFornecedorActionPerformed

    private void jButtonNovoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoFornecedorActionPerformed
        if (jTextFieldNomeFornecedor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome é um campo obrigatório.");
            jTextFieldNomeFornecedor.requestFocus();
        } else {
            if (jFormattedTextFieldCnpjFornecedor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "CNPJ é um campo obrigatório.");
                jFormattedTextFieldCnpjFornecedor.requestFocus();
            } else if (JOptionPane.showConfirmDialog(this, "Deseja cadastrar o fornecedor?",
                    "Cadastrar fornecedor", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.OK_OPTION) {

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setNome(jTextFieldNomeFornecedor.getText());
                fornecedor.setCNPJ(jFormattedTextFieldCnpjFornecedor.getText());
                fornecedor.setTelefone(jFormattedTextFieldTelefoneFornecedor.getText());
                fornecedor.setCEP(jFormattedTextFieldCepFornecedor.getText());
                fornecedor.setLogradouro(jTextFieldLogradouroFornecedor.getText());
                fornecedor.setCidade(jTextFieldCidadeFornecedor.getText());
                fornecedor.setUF((String) jComboBoxUfFornecedor.getSelectedItem());

                try {
                    controller.cadastrar(fornecedor);
                    JOptionPane.showMessageDialog(null, "Fornecedor registrado com sucesso!");
                    jTextFieldCodigoFornecedor.setText("");
                    jTextFieldNomeFornecedor.setText("");
                    jFormattedTextFieldCnpjFornecedor.setText("");
                    jFormattedTextFieldTelefoneFornecedor.setText("");
                    jTextFieldCidadeFornecedor.setText("");
                    jTextFieldLogradouroFornecedor.setText("");
                    jFormattedTextFieldCepFornecedor.setText("");

                } catch (DatabaseException ex) {
                    Logger.getLogger(TelaGerenciarClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButtonNovoFornecedorActionPerformed

    private void jTableFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFornecedoresMouseClicked
        int linha = jTableFornecedores.getSelectedRow();
        Fornecedor ev = fornecedorModel.getFornecedor(linha);
        jTextFieldCodigoFornecedor.setText("" + ev.getCodigo());
        jTextFieldNomeFornecedor.setText(ev.getNome());
        jFormattedTextFieldCnpjFornecedor.setText(ev.getCNPJ());
        jFormattedTextFieldTelefoneFornecedor.setText(ev.getTelefone());
        jTextFieldCidadeFornecedor.setText(ev.getCidade());
        jTextFieldLogradouroFornecedor.setText(ev.getLogradouro());
        jFormattedTextFieldCepFornecedor.setText(ev.getCEP());
        jComboBoxUfFornecedor.setSelectedItem(ev.getUF());
    }//GEN-LAST:event_jTableFornecedoresMouseClicked

    private void jButtonLimparFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparFornecedorActionPerformed
        jTextFieldCodigoFornecedor.setText("");
        jTextFieldNomeFornecedor.setText("");
        jFormattedTextFieldCnpjFornecedor.setText("");
        jFormattedTextFieldTelefoneFornecedor.setText("");
        jTextFieldCidadeFornecedor.setText("");
        jTextFieldLogradouroFornecedor.setText("");
        jFormattedTextFieldCepFornecedor.setText("");
    }//GEN-LAST:event_jButtonLimparFornecedorActionPerformed

    private void jButtonPesquisarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarFornecedorActionPerformed
        try {
            fornecedorModel.updateFornecedores(controller.pesquisar(jTextFieldPesquisarFornecedor.getText()));
        } catch (DatabaseException ex) {
            Logger.getLogger(TelaGerenciarFornecedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPesquisarFornecedorActionPerformed

    private void jButtonEditarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarFornecedorActionPerformed
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(jTextFieldNomeFornecedor.getText());
        fornecedor.setCNPJ(jFormattedTextFieldCnpjFornecedor.getText());
        fornecedor.setTelefone(jFormattedTextFieldTelefoneFornecedor.getText());
        fornecedor.setCEP(jFormattedTextFieldCepFornecedor.getText());
        fornecedor.setLogradouro(jTextFieldLogradouroFornecedor.getText());
        fornecedor.setCidade(jTextFieldCidadeFornecedor.getText());
        fornecedor.setUF((String) jComboBoxUfFornecedor.getSelectedItem());
        fornecedor.setCodigo(Integer.parseInt(jTextFieldCodigoFornecedor.getText()));

        try {
            controller.atualizar(fornecedor);
            JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");
            jTextFieldCodigoFornecedor.setText("");
            jTextFieldNomeFornecedor.setText("");
            jFormattedTextFieldCnpjFornecedor.setText("");
            jFormattedTextFieldTelefoneFornecedor.setText("");
            jTextFieldCidadeFornecedor.setText("");
            jTextFieldLogradouroFornecedor.setText("");
            jFormattedTextFieldCepFornecedor.setText("");

        } catch (DatabaseException ex) {
            Logger.getLogger(TelaGerenciarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEditarFornecedorActionPerformed

    private void jButtonExcluirFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirFornecedorActionPerformed
        try {
            int codigo = Integer.parseInt(jTextFieldCodigoFornecedor.getText());
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o fornecedor?",
                    "Excluir fornecedor", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.OK_OPTION) {
                if (controller.excluir(codigo)) {
                    JOptionPane.showMessageDialog(this, "Fornecedor removido com sucesso!");
                    jTextFieldCodigoFornecedor.setText("");
                    jTextFieldNomeFornecedor.setText("");
                    jFormattedTextFieldCnpjFornecedor.setText("");
                    jFormattedTextFieldTelefoneFornecedor.setText("");
                    jTextFieldCidadeFornecedor.setText("");
                    jTextFieldLogradouroFornecedor.setText("");
                    jFormattedTextFieldCepFornecedor.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Falha");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Código Inválido");
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(this, "Erro no banco: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonExcluirFornecedorActionPerformed

    private void jTextFieldPesquisarFornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarFornecedorKeyReleased
        try {
            fornecedorModel.updateFornecedores(controller.pesquisar(jTextFieldPesquisarFornecedor.getText()));
        } catch (DatabaseException ex) {
            Logger.getLogger(TelaGerenciarFornecedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldPesquisarFornecedorKeyReleased

    public void pesquisarFornecedores(String nome) {
        String sql = "Select * from fornecedor where nome_pessoa like ?";

        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();
            jTableFornecedores.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "JA AVISEI CARAIO");
        }
    }

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
            java.util.logging.Logger.getLogger(TelaGerenciarFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditarFornecedor;
    private javax.swing.JButton jButtonExcluirFornecedor;
    private javax.swing.JButton jButtonLimparFornecedor;
    private javax.swing.JButton jButtonNovoFornecedor;
    private javax.swing.JButton jButtonPesquisarFornecedor;
    private javax.swing.JComboBox jComboBoxUfFornecedor;
    private javax.swing.JFormattedTextField jFormattedTextFieldCepFornecedor;
    private javax.swing.JFormattedTextField jFormattedTextFieldCnpjFornecedor;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefoneFornecedor;
    private javax.swing.JInternalFrame jInternalFrameFornecedor;
    private javax.swing.JLabel jLabelCepFornecedor;
    private javax.swing.JLabel jLabelCidadeFornecedor;
    private javax.swing.JLabel jLabelCnpjFornecedor;
    private javax.swing.JLabel jLabelCodigoFornecedor;
    private javax.swing.JLabel jLabelLogradouroFornecedor;
    private javax.swing.JLabel jLabelNomeFornecedor;
    private javax.swing.JLabel jLabelTelefoneFornecedor;
    private javax.swing.JLabel jLabelUfFornecedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFornecedores;
    private javax.swing.JTextField jTextFieldCidadeFornecedor;
    private javax.swing.JTextField jTextFieldCodigoFornecedor;
    private javax.swing.JTextField jTextFieldLogradouroFornecedor;
    private javax.swing.JTextField jTextFieldNomeFornecedor;
    private javax.swing.JTextField jTextFieldPesquisarFornecedor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        try {
            System.out.println(controller.listar());
            fornecedorModel.updateFornecedores(controller.listar());
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(this, "Erro no banco: " + e.getMessage());
        }
    }
}
