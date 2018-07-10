/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.Fabrica;
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import javax.swing.SwingWorker;

/**
 *
 * @author Usuario
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal()  {
        initComponents();
        this.setLocationRelativeTo(null); //centrar
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Iconos/cargando.gif"));
        imagenGif.setIcon(icon);
        icon.setImageObserver(imagenGif);
        
        try {
            this.setIconImage(ImageIO.read(getClass().getResource("/Iconos/logoApp.png")));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        
        Contenedor.add(IniciarPanel, "iniciar");
        Contenedor.add(CargandoPanel, "cargando");
        
        mostrarCargando(false);
    }

    public void vaciar() {
        IdTextField.setText("");
        PasswordField.setText("");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        Contenedor = new javax.swing.JPanel();
        CargandoPanel = new javax.swing.JPanel();
        imagenGif = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IniciarPanel = new javax.swing.JPanel();
        PasswordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        IdTextField = new javax.swing.JTextField();
        IniciarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingresar");
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login.png"))); // NOI18N

        Contenedor.setLayout(new java.awt.CardLayout());

        imagenGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cargando.gif"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cargando...");

        javax.swing.GroupLayout CargandoPanelLayout = new javax.swing.GroupLayout(CargandoPanel);
        CargandoPanel.setLayout(CargandoPanelLayout);
        CargandoPanelLayout.setHorizontalGroup(
            CargandoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CargandoPanelLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(CargandoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenGif)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39))
        );
        CargandoPanelLayout.setVerticalGroup(
            CargandoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CargandoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenGif)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        Contenedor.add(CargandoPanel, "card3");

        PasswordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        IdTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        IdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdTextFieldActionPerformed(evt);
            }
        });

        IniciarButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        IniciarButton.setText("Iniciar");
        IniciarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Id:");

        javax.swing.GroupLayout IniciarPanelLayout = new javax.swing.GroupLayout(IniciarPanel);
        IniciarPanel.setLayout(IniciarPanelLayout);
        IniciarPanelLayout.setHorizontalGroup(
            IniciarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IniciarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IniciarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IniciarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(IniciarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(IdTextField)
                        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        IniciarPanelLayout.setVerticalGroup(
            IniciarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IniciarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(IniciarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Contenedor.add(IniciarPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel3)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(44, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addContainerGap(241, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(119, Short.MAX_VALUE)
                    .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdTextFieldActionPerformed

    private void IniciarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarButtonActionPerformed
        // TODO add your handling code here:       

        String id = IdTextField.getText();
        String pass = new String(PasswordField.getPassword());
        if (!(id.isEmpty() && pass.isEmpty())) {

            new SwingWorker<String, Void>(){
                @Override
                protected String doInBackground() throws Exception {
                    try {
                        String tipo = Fabrica.getInstance().getContAdmin().login(id, pass);
                        return tipo;
                    } catch (InternalException ex) {
                        mostrarMensajeError(ex.getMessage());
                        return null;
                    }
                }

                @Override
                protected void done(){

                    try {
                        String tipo = get(); // asi se obtiene lo que retorna el doInBackground
                        if(tipo!=null){
                            switch(tipo){
                                case "estudiante":
                                Estudiante_MenuPrincipal em = new Estudiante_MenuPrincipal();
                                em.setVisible(true);
                                break;
                                case "docente":
                                Docente_MenuPrincipal dm = new Docente_MenuPrincipal();
                                dm.setVisible(true);
                                break;
                                case "admin":
                                Admin_MenuPrincipal am = new Admin_MenuPrincipal();
                                am.setVisible(true);
                                break;
                            }
                        }else{
                            //ha ocurrido un error
                        }
                    } catch (InterruptedException | ExecutionException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    mostrarCargando(false);
                }
            }.execute();
        } else {
            JOptionPane.showMessageDialog(this, "Rellene los campos", "Error", JOptionPane.WARNING_MESSAGE);
        }
        mostrarCargando(true);
    }//GEN-LAST:event_IniciarButtonActionPerformed

    public void mostrarCargando(boolean mostrar){        
        if(mostrar){
            CardLayout cl = (CardLayout)(Contenedor.getLayout());
            cl.show(Contenedor, "cargando");
        }else{
            CardLayout cl = (CardLayout)(Contenedor.getLayout());
            cl.show(Contenedor, "iniciar");
        }
    }
    
    public void mostrarMensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.WARNING_MESSAGE);
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
                /*if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/

                // setTheme(String themeName, String licenseKey, String logoString)
                com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme("Green-Medium-Font", "INSERT YOUR LICENSE KEY HERE", "my company");

                // select the Look and Feel
                UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CargandoPanel;
    private javax.swing.JPanel Contenedor;
    private javax.swing.JTextField IdTextField;
    private javax.swing.JButton IniciarButton;
    private javax.swing.JPanel IniciarPanel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel imagenGif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}
