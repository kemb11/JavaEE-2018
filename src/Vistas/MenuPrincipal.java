/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.Curso;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Usuario
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        CursosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
         // ocultar la columna del id
        CursosTable.getColumnModel().removeColumn( CursosTable.getColumnModel().getColumn(0) ); 
        
        // Agregar los paneles al contenedor(cardlayout)
        PanelPrincipal.add(CursosPanel, "cursos");
        PanelPrincipal.add(CarrerasPanel, "carreras");
        PanelPrincipal.add(SedesPanel, "sedes");
        
        //Por defecto que muestre los cursos
        opcionSeleccionada("cursos");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLateral = new javax.swing.JPanel();
        CursosOpcion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CarrerasOpcion = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        SedesOpcion = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();
        CursosPanel = new javax.swing.JPanel();
        BuscarTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CursosTable = new javax.swing.JTable();
        VerCursoButton = new javax.swing.JButton();
        InscripcionesButton = new javax.swing.JButton();
        CarrerasPanel = new javax.swing.JPanel();
        SedesPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelLateral.setBackground(new java.awt.Color(29, 131, 72));

        CursosOpcion.setBackground(new java.awt.Color(29, 131, 72));
        CursosOpcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CursosOpcionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CursosOpcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CursosOpcionMouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cursos.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cursos");

        javax.swing.GroupLayout CursosOpcionLayout = new javax.swing.GroupLayout(CursosOpcion);
        CursosOpcion.setLayout(CursosOpcionLayout);
        CursosOpcionLayout.setHorizontalGroup(
            CursosOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CursosOpcionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CursosOpcionLayout.setVerticalGroup(
            CursosOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CursosOpcionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(CursosOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10))
        );

        CarrerasOpcion.setBackground(new java.awt.Color(29, 131, 72));
        CarrerasOpcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarrerasOpcionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CarrerasOpcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CarrerasOpcionMouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/carreras.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Carreras");

        javax.swing.GroupLayout CarrerasOpcionLayout = new javax.swing.GroupLayout(CarrerasOpcion);
        CarrerasOpcion.setLayout(CarrerasOpcionLayout);
        CarrerasOpcionLayout.setHorizontalGroup(
            CarrerasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CarrerasOpcionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        CarrerasOpcionLayout.setVerticalGroup(
            CarrerasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CarrerasOpcionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(CarrerasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10))
        );

        SedesOpcion.setBackground(new java.awt.Color(29, 131, 72));
        SedesOpcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SedesOpcionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SedesOpcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SedesOpcionMouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sede.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Sedes");

        javax.swing.GroupLayout SedesOpcionLayout = new javax.swing.GroupLayout(SedesOpcion);
        SedesOpcion.setLayout(SedesOpcionLayout);
        SedesOpcionLayout.setHorizontalGroup(
            SedesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SedesOpcionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SedesOpcionLayout.setVerticalGroup(
            SedesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SedesOpcionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SedesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout PanelLateralLayout = new javax.swing.GroupLayout(PanelLateral);
        PanelLateral.setLayout(PanelLateralLayout);
        PanelLateralLayout.setHorizontalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CursosOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CarrerasOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SedesOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        PanelLateralLayout.setVerticalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(CursosOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CarrerasOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SedesOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipal.setBackground(new java.awt.Color(73, 202, 114));
        PanelPrincipal.setLayout(new java.awt.CardLayout());

        CursosPanel.setBackground(new java.awt.Color(73, 202, 114));

        BuscarTextField.setText("Buscar por curso, carrera, sede");
        BuscarTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscarTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscarTextFieldFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar:");

        CursosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ObjCurso", "Nombre", "Creditos", "Optativo", "Carrera", "Sede"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(CursosTable);

        VerCursoButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VerCursoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ver_verde.png"))); // NOI18N
        VerCursoButton.setText("Ver Curso");
        VerCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerCursoButtonActionPerformed(evt);
            }
        });

        InscripcionesButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InscripcionesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/inscripcion_verde.png"))); // NOI18N
        InscripcionesButton.setText("Inscribirse");
        InscripcionesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscripcionesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CursosPanelLayout = new javax.swing.GroupLayout(CursosPanel);
        CursosPanel.setLayout(CursosPanelLayout);
        CursosPanelLayout.setHorizontalGroup(
            CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CursosPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CursosPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CursosPanelLayout.createSequentialGroup()
                        .addComponent(VerCursoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InscripcionesButton)))
                .addGap(25, 25, 25))
        );
        CursosPanelLayout.setVerticalGroup(
            CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CursosPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BuscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VerCursoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InscripcionesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PanelPrincipal.add(CursosPanel, "cardCursos");

        CarrerasPanel.setBackground(new java.awt.Color(73, 202, 114));

        javax.swing.GroupLayout CarrerasPanelLayout = new javax.swing.GroupLayout(CarrerasPanel);
        CarrerasPanel.setLayout(CarrerasPanelLayout);
        CarrerasPanelLayout.setHorizontalGroup(
            CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );
        CarrerasPanelLayout.setVerticalGroup(
            CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        PanelPrincipal.add(CarrerasPanel, "cardCarreras");

        SedesPanel.setBackground(new java.awt.Color(73, 202, 114));

        javax.swing.GroupLayout SedesPanelLayout = new javax.swing.GroupLayout(SedesPanel);
        SedesPanel.setLayout(SedesPanelLayout);
        SedesPanelLayout.setHorizontalGroup(
            SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );
        SedesPanelLayout.setVerticalGroup(
            SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        PanelPrincipal.add(SedesPanel, "cardSedes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CursosOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CursosOpcionMouseClicked
        opcionSeleccionada("cursos");
    }//GEN-LAST:event_CursosOpcionMouseClicked

    private void SedesOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SedesOpcionMouseClicked
        opcionSeleccionada("sedes");
    }//GEN-LAST:event_SedesOpcionMouseClicked

    private void CarrerasOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarrerasOpcionMouseClicked
        opcionSeleccionada("carreras");
    }//GEN-LAST:event_CarrerasOpcionMouseClicked

    private void CursosOpcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CursosOpcionMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_CursosOpcionMouseEntered

    private void CursosOpcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CursosOpcionMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_CursosOpcionMouseExited

    private void CarrerasOpcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarrerasOpcionMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_CarrerasOpcionMouseEntered

    private void CarrerasOpcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarrerasOpcionMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_CarrerasOpcionMouseExited

    private void SedesOpcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SedesOpcionMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_SedesOpcionMouseExited

    private void SedesOpcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SedesOpcionMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_SedesOpcionMouseEntered

    private void BuscarTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarTextFieldFocusGained
        if (BuscarTextField.getText().equals("Buscar por curso, carrera, sede")) {
            BuscarTextField.setText("");
            BuscarTextField.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_BuscarTextFieldFocusGained

    private void BuscarTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarTextFieldFocusLost
        if (BuscarTextField.getText().isEmpty()) {
            BuscarTextField.setText("Buscar por curso, carrera, sede");
            BuscarTextField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_BuscarTextFieldFocusLost

    private void VerCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerCursoButtonActionPerformed
        if(CursosTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un curso","", WARNING_MESSAGE);
        }else{
            DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();
            Curso curso = (Curso) modelo.getValueAt(CursosTable.getSelectedRow(), 0);
            Estudiante_VerCurso verC = new Estudiante_VerCurso(curso);
            verC.setVisible(true);
        }
    }//GEN-LAST:event_VerCursoButtonActionPerformed

    private void InscripcionesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscripcionesButtonActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();

        if(CursosTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un curso","", WARNING_MESSAGE);
        }else{

        }
    }//GEN-LAST:event_InscripcionesButtonActionPerformed

    void opcionSeleccionada(String opcion){
        CardLayout cl = (CardLayout)(PanelPrincipal.getLayout());
        switch(opcion){
            case "cursos":
                CursosOpcion.setBackground(Color.decode("#4a9f6e"));
                CarrerasOpcion.setBackground(Color.decode("#1d8348"));
                SedesOpcion.setBackground(Color.decode("#1d8348"));                
                
                DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();
                while(modelo.getRowCount()>0)modelo.removeRow(0);//limpiar la tabla
                
                //Por defecto que se vea asi
                BuscarTextField.setText("Buscar por curso, carrera, sede");
                BuscarTextField.setForeground(Color.GRAY);        
                CursosTable.requestFocus();       
                
                listarCursos();
                
                cl.show(PanelPrincipal, "cursos");
                break;
            case "carreras":
                CarrerasOpcion.setBackground(Color.decode("#4a9f6e"));
                CursosOpcion.setBackground(Color.decode("#1d8348"));
                SedesOpcion.setBackground(Color.decode("#1d8348"));
                cl.show(PanelPrincipal, "carreras");
                break;
            case "sedes":
                SedesOpcion.setBackground(Color.decode("#4a9f6e"));
                CursosOpcion.setBackground(Color.decode("#1d8348"));
                CarrerasOpcion.setBackground(Color.decode("#1d8348"));                
                cl.show(PanelPrincipal, "sedes");
                break;
        }
    }
    
    public void listarCursos(){
        
        // LLamar a funcion de contrlador
        List<Curso> lista = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2018PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            lista = em.createNativeQuery("SELECT * FROM curso", Curso.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        //
        
        DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();
        
        while(modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        for (Curso curso : lista) {
            String esOptativo = "No";
            if(curso.isOptativo()){
                esOptativo = "Si";
            }
            Object[] datos={curso, curso.getNombre(), String.valueOf(curso.getCreditos()), esOptativo};
            modelo.addRow(datos);
        }
        
        resizeColumnWidth(CursosTable);
    }
    
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
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
                // setTheme(String themeName, String licenseKey, String logoString)
                com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme("Green-Medium-Font", "INSERT YOUR LICENSE KEY HERE", "my company");
                
                // select the Look and Feel
                UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscarTextField;
    private javax.swing.JPanel CarrerasOpcion;
    private javax.swing.JPanel CarrerasPanel;
    private javax.swing.JPanel CursosOpcion;
    private javax.swing.JPanel CursosPanel;
    private javax.swing.JTable CursosTable;
    private javax.swing.JButton InscripcionesButton;
    private javax.swing.JPanel PanelLateral;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel SedesOpcion;
    private javax.swing.JPanel SedesPanel;
    private javax.swing.JButton VerCursoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
