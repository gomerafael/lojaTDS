/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.view;

import java.text.MessageFormat;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import lojatds.controller.ClienteController;
import lojatds.model.dao.DAOFactory;
import lojatds.model.dao.DatabaseException;



/**
 *
 * @author Rafa
 */
public class TelaRelatorioClientes extends javax.swing.JFrame implements Observer{
    
    
    private final ClienteController controller;
    private ClienteTableModel clienteModel;
    /**
     * Creates new form TelaRelatorioClientes
     * @param controller
     */
    public TelaRelatorioClientes(ClienteController controller) {
        super("Relatório de clientes");
        this.controller = controller;
        clienteModel = new ClienteTableModel();
        initComponents();
        jTableRelatorioClientes.setModel(clienteModel);
        try {
            clienteModel.updateClientes(controller.listar());
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

        jInternalFrameRelatorioClientes = new javax.swing.JInternalFrame();
        jLabelRelatorioClientes = new javax.swing.JLabel();
        jButtonRelatorioClientesSim = new javax.swing.JButton();
        jButtonRelatorioClientesNao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelatorioClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jInternalFrameRelatorioClientes.setVisible(true);

        jLabelRelatorioClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelRelatorioClientes.setText("Deseja imprimir relatório de clientes?");

        jButtonRelatorioClientesSim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/bullet_green.png"))); // NOI18N
        jButtonRelatorioClientesSim.setText("Sim");
        jButtonRelatorioClientesSim.setToolTipText("Imprimir relatório de clientes");
        jButtonRelatorioClientesSim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRelatorioClientesSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatorioClientesSimActionPerformed(evt);
            }
        });

        jButtonRelatorioClientesNao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatds/view/imagens/bullet_red.png"))); // NOI18N
        jButtonRelatorioClientesNao.setText("Não");
        jButtonRelatorioClientesNao.setToolTipText("Cancelar operação");
        jButtonRelatorioClientesNao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRelatorioClientesNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatorioClientesNaoActionPerformed(evt);
            }
        });

        jTableRelatorioClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableRelatorioClientes);

        javax.swing.GroupLayout jInternalFrameRelatorioClientesLayout = new javax.swing.GroupLayout(jInternalFrameRelatorioClientes.getContentPane());
        jInternalFrameRelatorioClientes.getContentPane().setLayout(jInternalFrameRelatorioClientesLayout);
        jInternalFrameRelatorioClientesLayout.setHorizontalGroup(
            jInternalFrameRelatorioClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameRelatorioClientesLayout.createSequentialGroup()
                .addGroup(jInternalFrameRelatorioClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrameRelatorioClientesLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jButtonRelatorioClientesSim)
                        .addGap(159, 159, 159)
                        .addComponent(jButtonRelatorioClientesNao))
                    .addGroup(jInternalFrameRelatorioClientesLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrameRelatorioClientesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelRelatorioClientes)
                .addGap(263, 263, 263))
        );
        jInternalFrameRelatorioClientesLayout.setVerticalGroup(
            jInternalFrameRelatorioClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameRelatorioClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRelatorioClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jInternalFrameRelatorioClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRelatorioClientesSim)
                    .addComponent(jButtonRelatorioClientesNao))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrameRelatorioClientes);
        jInternalFrameRelatorioClientes.setBounds(0, 0, 780, 280);

        setSize(new java.awt.Dimension(796, 320));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRelatorioClientesNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioClientesNaoActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonRelatorioClientesNaoActionPerformed

    private void jButtonRelatorioClientesSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioClientesSimActionPerformed
        MessageFormat Header = new MessageFormat("Lista de clientes");
        MessageFormat Footer = new MessageFormat("Page{0, number, integer}");
        try {
            jTableRelatorioClientes.print(JTable.PrintMode.NORMAL, Header, Footer);
            
        } catch(java.awt.print.PrinterException e) {
            System.err.format("Erro de impressão!", e.getMessage());
        }
    }//GEN-LAST:event_jButtonRelatorioClientesSimActionPerformed

    
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
            java.util.logging.Logger.getLogger(TelaRelatorioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRelatorioClientesNao;
    private javax.swing.JButton jButtonRelatorioClientesSim;
    private javax.swing.JInternalFrame jInternalFrameRelatorioClientes;
    private javax.swing.JLabel jLabelRelatorioClientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelatorioClientes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        try {
            System.out.println(controller.listar());
            clienteModel.updateClientes(controller.listar());
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(this, "Erro no banco: " + e.getMessage());
        }
    }
}
