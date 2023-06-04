/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Interfaces.MiInterfazRemota;
import Interfaces.MiInterfazRemotaPrivada;
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

            System.out.println("Servidor RMI listo...");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        ChatGeneralArea = new javax.swing.JTextArea();
        BtnGeneral = new javax.swing.JButton();
        ChatGeneral = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ChatP1 = new javax.swing.JTextArea();
        ChatP1Send = new javax.swing.JTextField();
        BtnSP1 = new javax.swing.JButton();
        BtnConexion = new javax.swing.JButton();
        Registrarce = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ChatGeneralArea.setColumns(20);
        ChatGeneralArea.setRows(5);
        jScrollPane1.setViewportView(ChatGeneralArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 313, 301));

        BtnGeneral.setText("Send");
        BtnGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGeneralActionPerformed(evt);
            }
        });
        jPanel1.add(BtnGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 57, -1));
        jPanel1.add(ChatGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 250, -1));

        ChatP1.setColumns(20);
        ChatP1.setRows(5);
        jScrollPane2.setViewportView(ChatP1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 327, 150));
        jPanel1.add(ChatP1Send, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 270, -1));

        BtnSP1.setText("Send");
        BtnSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSP1ActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 60, 30));

        BtnConexion.setText("Conecta");
        BtnConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConexionActionPerformed(evt);
            }
        });
        jPanel1.add(BtnConexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, -1, -1));

        Registrarce.setText("Registra");
        Registrarce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarceActionPerformed(evt);
            }
        });
        jPanel1.add(Registrarce, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
