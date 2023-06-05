/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Interfaces.MiInterfazRemota;
import Interfaces.MiInterfazRemotaPrivada;
import java.awt.Color;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import main.ClienteMS;
import main.MiClaseRemota;
import main.MiclassRemotaPunto;
/**
 *
 * @author angel
 */
public class MiClienteChat extends javax.swing.JFrame {

    public  Registry registryG;
    public  Registry registryPrivate; 
    public  MiInterfazRemota remoteMi;
    public MiInterfazRemotaPrivada remoteMiPri;
      
    public MiClienteChat() {
        initComponents();
        TextAreas();
        RegisterCliente();
       
    }

    public void ChatPrivadoServer() {
        try {

           MiclassRemotaPunto  remoteMiPri = new MiclassRemotaPunto();
            //se registara un puertto 
            Registry registry = LocateRegistry.createRegistry(1234);
            registry.rebind("MiInterfazRemotaPrivada", remoteMiPri);

            System.out.println("Servidor RMI Privado listo");
        } catch (Exception e) {
            System.err.println("Error  Registry in  servidor: " + e.toString());
            e.printStackTrace();
        }
        RegisterClientePunto();
    }
    
    public void RegisterClientePunto() {
        try {
            
            // Registry registry = LocateRegistry.getRegistry("192.168.84.200", 1099);
            //remoteMiaux = (MiInterfazRemota) Naming.lookup("rmi://192.168.100.5:1099/MiInterfazRemota");

            registryPrivate = LocateRegistry.getRegistry("192.168.100.5", 1234);
            remoteMiPri = (MiInterfazRemotaPrivada) registryPrivate.lookup("MiInterfazRemotaPrivada");
            
            ClienteMS cliente = new ClienteMS(ChatP1);
            remoteMiPri.registerClient(cliente);
            // System.out.println(remoteMiaux);
            System.out.println("Conexion exitosa");
            
        } catch (Exception e) {
            System.err.println("Error Registry in server: " + e.toString());
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BtnGeneral = new javax.swing.JButton();
        ChatGeneral = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ChatGeneralArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ChatP1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        Registrarce = new javax.swing.JButton();
        BtnConexion = new javax.swing.JButton();
        ChatP1Send = new javax.swing.JTextField();
        BtnSP1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnGeneral.setText("Send");
        BtnGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGeneralActionPerformed(evt);
            }
        });
        jPanel2.add(BtnGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 57, -1));
        jPanel2.add(ChatGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 250, -1));

        ChatGeneralArea.setColumns(20);
        ChatGeneralArea.setRows(5);
        jScrollPane1.setViewportView(ChatGeneralArea);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 313, 301));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dubai", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chat General");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 160, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngwing.com (6).png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 550));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dubai", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Chat General");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 160, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 570));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ChatP1.setColumns(20);
        ChatP1.setRows(5);
        jScrollPane2.setViewportView(ChatP1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 320, 220));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dubai", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Chat Privado");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 160, -1));

        Registrarce.setText("Registra");
        Registrarce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarceActionPerformed(evt);
            }
        });
        jPanel3.add(Registrarce, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        BtnConexion.setText("Conecta");
        BtnConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConexionActionPerformed(evt);
            }
        });
        jPanel3.add(BtnConexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));
        jPanel3.add(ChatP1Send, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 270, -1));

        BtnSP1.setText("Send");
        BtnSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSP1ActionPerformed(evt);
            }
        });
        jPanel3.add(BtnSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 60, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngwing.com (7).png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 450, 570));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 470, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      public void RegisterCliente() {
        try {
            
            // Registry registry = LocateRegistry.getRegistry("192.168.84.200", 1099);
            //remoteMiaux = (MiInterfazRemota) Naming.lookup("rmi://192.168.100.5:1099/MiInterfazRemota");

            registryG = LocateRegistry.getRegistry("192.168.100.5", 1099);
            remoteMi = (MiInterfazRemota) registryG.lookup("MiInterfazRemota");

            ClienteMS cliente = new ClienteMS(ChatGeneralArea);
            remoteMi.registerClient(cliente);
            // System.out.println(remoteMiaux);
            System.out.println("Conexion exitosa");
            
        } catch (Exception e) {
            System.err.println("Error send the message: " + e.toString());
        }

    }
    
    private void BtnGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGeneralActionPerformed

        String MS = ChatGeneral.getText();

        try {
            // Registry registry = LocateRegistry.getRegistry("192.168.84.200", 1099);
            /* Registry registry = LocateRegistry.getRegistry("192.168.100.5", 1099);
            MiInterfazRemota remoteMi = (MiInterfazRemota) registry.lookup("MiInterfazRemota");*/

            //ClienteMS cliente = new ClienteMS(ChatGeneralArea);
            //remoteMi.registerClient(cliente);
            //System.out.println(cliente);
            // System.out.println(auxms + "main");
           // ChatGeneralArea.append(MS + "\n");

           // remoteMi.poolMS(MS);
            remoteMi.SendMS(MS);
        } catch (Exception e) {
            System.err.println("Error send the message: " + e.toString());
        }
        ChatGeneral.setText("");
    }//GEN-LAST:event_BtnGeneralActionPerformed

    private void BtnSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSP1ActionPerformed
        // TODO add your handling code here:
        String MS = ChatP1Send.getText();
        try {
         
            
            remoteMiPri.SendMS(MS);
        } catch (Exception ex) {
            System.out.println("Error send the Messange Private");
        }

      
      ChatP1Send.setText("");
    }//GEN-LAST:event_BtnSP1ActionPerformed

    private void BtnConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConexionActionPerformed
        ChatPrivadoServer();
               
    }//GEN-LAST:event_BtnConexionActionPerformed

    private void RegistrarceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarceActionPerformed
         RegisterClientePunto();
    }//GEN-LAST:event_RegistrarceActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void  TextAreas () {
        ChatGeneralArea.setEditable(false);
        ChatP1.setEditable(false);
    }
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
            java.util.logging.Logger.getLogger(MiClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
      
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiClienteChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConexion;
    private javax.swing.JButton BtnGeneral;
    private javax.swing.JButton BtnSP1;
    private javax.swing.JTextField ChatGeneral;
    private javax.swing.JTextArea ChatGeneralArea;
    private javax.swing.JTextArea ChatP1;
    private javax.swing.JTextField ChatP1Send;
    private javax.swing.JButton Registrarce;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
