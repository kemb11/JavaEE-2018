/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

/**
 *
 * @author Usuario
 */
public class Estudiante_MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    ArrayList<Object[]> volver = new ArrayList<>();
    ArrayList<JPanel> opciones = new ArrayList<>(); 
    
    public Estudiante_MenuPrincipal() {
        initComponents();

        this.setLocationRelativeTo(null);

        CursosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // ocultar la columna del objeto
        CursosTable.getColumnModel().removeColumn(CursosTable.getColumnModel().getColumn(0));
        SedeTable.getColumnModel().removeColumn(SedeTable.getColumnModel().getColumn(0));
        CarreraTable.getColumnModel().removeColumn(CarreraTable.getColumnModel().getColumn(0));
        NoticiasTable.getColumnModel().removeColumn(NoticiasTable.getColumnModel().getColumn(0));
        ExamenesTable.getColumnModel().removeColumn(ExamenesTable.getColumnModel().getColumn(0));
        ParcialesTable.getColumnModel().removeColumn(ParcialesTable.getColumnModel().getColumn(0));
        MaterialesSubidosTable.getColumnModel().removeColumn(MaterialesSubidosTable.getColumnModel().getColumn(0));
        NotificacionesTable.getColumnModel().removeColumn(NotificacionesTable.getColumnModel().getColumn(0));

        // Agregar los paneles al contenedor(cardlayout)
        PanelPrincipal.add(CursosPanel, "cursos");
        PanelPrincipal.add(CarrerasPanel, "carreras");
        PanelPrincipal.add(SedesPanel, "sedes");
        PanelPrincipal.add(NoticiasPanel, "noticias");
        PanelPrincipal.add(ExamenesPanel, "examenes");
        PanelPrincipal.add(ParcialesPanel, "parciales");
        PanelPrincipal.add(VerCursoPanel, "verCurso");
        PanelPrincipal.add(VerExamenPanel, "verExamen");
        PanelPrincipal.add(VerParcialPanel, "verParcial");
        PanelPrincipal.add(VerNoticia, "ver noticia");
        PanelPrincipal.add(MaterialesSubidosPanel, "verMaterial");
        PanelPrincipal.add(NotificacionesPanel, "notificaciones");
        PanelPrincipal.add(VerPerfilPanel, "verPerfil");
        PanelPrincipal.add(VerNotificacion, "verNotificacion");
        PanelPrincipal.add(EstadisticasCursoPanel, "estadisticasCurso");
        PanelPrincipal.add(EstadisticasCarreraPanel, "estadisticasCarrera");
        PanelPrincipal.add(EstadisticasPanel, "estadisticas");
        PanelPrincipal.add(CargandoPanel, "cargando");
        PanelPrincipal.add(VerCarreraPanel, "verCarrera");

        String nombres = Fabrica.getInstance().getContEst().getLogin().getNombres();
        String apellidos = Fabrica.getInstance().getContEst().getLogin().getApellidos();
        nombreUsrLabel.setText(nombres+" "+apellidos);
        
        opciones.add(CursosOpcion);
        opciones.add(CarrerasOpcion);
        opciones.add(SedesOpcion);
        opciones.add(NoticiasOpcion);
        opciones.add(ExamenesOpcion);
        opciones.add(ParcialesOpcion);
        opciones.add(EstadisticasOpcion);
        
        //Por defecto que muestre las sedes
        opcionSeleccionada(SedesOpcion, "sedes");
        
        setCantidadNotif();
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Iconos/cargandoGrande.gif"));
        imgCargando.setIcon(icon);
        icon.setImageObserver(imgCargando); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCursos = new javax.swing.ButtonGroup();
        buttonGroupExamenes = new javax.swing.ButtonGroup();
        buttonGroupParciales = new javax.swing.ButtonGroup();
        buttonGroupEstadCurso = new javax.swing.ButtonGroup();
        buttonGroupEstadCarrera = new javax.swing.ButtonGroup();
        buttonGroupEstadSede = new javax.swing.ButtonGroup();
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
        SedeSelec = new javax.swing.JLabel();
        NoticiasOpcion = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ExamenesOpcion = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ParcialesOpcion = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        EstadisticasOpcion = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();
        CursosPanel = new javax.swing.JPanel();
        BuscarTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        CursosTable = new javax.swing.JTable();
        VerCursoButton = new javax.swing.JButton();
        InscripcionCButton = new javax.swing.JButton();
        TodosRadioButton = new javax.swing.JRadioButton();
        CursandoRadioButton = new javax.swing.JRadioButton();
        AprobadosRadioButton = new javax.swing.JRadioButton();
        BuscarButton = new javax.swing.JButton();
        InscripcionCButton1 = new javax.swing.JButton();
        CarrerasPanel = new javax.swing.JPanel();
        BuscarCarrera = new javax.swing.JTextField();
        VerCarrera = new javax.swing.JButton();
        btnBuscarCarrera = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        CarreraTable = new javax.swing.JTable();
        btnEstadCarr = new javax.swing.JButton();
        SedesPanel = new javax.swing.JPanel();
        BuscarSede = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        SedeTable = new javax.swing.JTable();
        SeleccionarSede = new javax.swing.JButton();
        btnBuscarSede = new javax.swing.JButton();
        NoticiasPanel = new javax.swing.JPanel();
        BuscarNoticia = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        NoticiasTable = new javax.swing.JTable();
        SeleccionarNoticia = new javax.swing.JButton();
        btnBuscarNoticia = new javax.swing.JButton();
        ExamenesPanel = new javax.swing.JPanel();
        BuscarExamenTextField = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        ExamenesTable = new javax.swing.JTable();
        SeleccionarExamen = new javax.swing.JButton();
        btnBuscarExamen = new javax.swing.JButton();
        TodosExRadioButton = new javax.swing.JRadioButton();
        MisExmenesRadioButton = new javax.swing.JRadioButton();
        InscripcionExButton = new javax.swing.JButton();
        VerExamenPanel = new javax.swing.JPanel();
        CurExamenLabel = new javax.swing.JLabel();
        TituloLabel1 = new javax.swing.JLabel();
        TituloLabel2 = new javax.swing.JLabel();
        FechaInscLabel = new javax.swing.JLabel();
        NotaLabel = new javax.swing.JLabel();
        TituloLabel3 = new javax.swing.JLabel();
        fechaNotaLabel = new javax.swing.JLabel();
        ParcialesPanel = new javax.swing.JPanel();
        BuscarExamenTextField1 = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        ParcialesTable = new javax.swing.JTable();
        SeleccionarParcial = new javax.swing.JButton();
        btnBuscarParcial = new javax.swing.JButton();
        TodosParRadioButton = new javax.swing.JRadioButton();
        MisParcialesRadioButton = new javax.swing.JRadioButton();
        VerParcialPanel = new javax.swing.JPanel();
        CurParcialLabel = new javax.swing.JLabel();
        TituloLabel5 = new javax.swing.JLabel();
        TituloLabel6 = new javax.swing.JLabel();
        FechaParcialLabel = new javax.swing.JLabel();
        NotaPLabel = new javax.swing.JLabel();
        TituloLabel10 = new javax.swing.JLabel();
        fechaNotaPLabel = new javax.swing.JLabel();
        TituloLabel11 = new javax.swing.JLabel();
        InstanciaLabel = new javax.swing.JLabel();
        VerNoticia = new javax.swing.JPanel();
        verNoticia_titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        verNoticia_fecha = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        verNoticia_etiquetas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        verNoticia_texto = new javax.swing.JTextArea();
        VerPerfilPanel = new javax.swing.JPanel();
        nombreEstLabel = new javax.swing.JLabel();
        AuxLabel = new javax.swing.JLabel();
        idEstLabel = new javax.swing.JLabel();
        AuxLabel1 = new javax.swing.JLabel();
        emailEstLabel = new javax.swing.JLabel();
        AuxLabel2 = new javax.swing.JLabel();
        fechaNacLabel = new javax.swing.JLabel();
        ciEstLabel = new javax.swing.JLabel();
        AuxLabel3 = new javax.swing.JLabel();
        AuxLabel4 = new javax.swing.JLabel();
        enviarMailsCheckBox = new javax.swing.JCheckBox();
        VerCursosPerfilButton = new javax.swing.JButton();
        VerExamenesPerfilButton = new javax.swing.JButton();
        VerParcialesPerfilButton = new javax.swing.JButton();
        imagenGif = new javax.swing.JLabel();
        VerCursoPanel = new javax.swing.JPanel();
        CreditosLabel = new javax.swing.JLabel();
        OptativoLabel = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        DescTextArea = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        HorariosTextArea = new javax.swing.JTextArea();
        TituloLabel = new javax.swing.JLabel();
        TituloLabel7 = new javax.swing.JLabel();
        TituloLabel8 = new javax.swing.JLabel();
        TituloLabel9 = new javax.swing.JLabel();
        TituloLabel4 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        PreviasCurTable = new javax.swing.JTable();
        TituloLabel12 = new javax.swing.JLabel();
        TituloLabel13 = new javax.swing.JLabel();
        carreraCurLabel = new javax.swing.JLabel();
        TituloLabel16 = new javax.swing.JLabel();
        TituloLabel18 = new javax.swing.JLabel();
        notaExonExLabel = new javax.swing.JLabel();
        notaAprobCurLabel = new javax.swing.JLabel();
        VerMaterialSubidoButton = new javax.swing.JButton();
        MaterialesSubidosPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        MaterialesSubidosTable = new javax.swing.JTable();
        TituloLabel14 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        DescMaterialTextArea = new javax.swing.JTextArea();
        DescargarMaterialButton = new javax.swing.JButton();
        tituloMateriales = new javax.swing.JLabel();
        NotificacionesPanel = new javax.swing.JPanel();
        BuscarNotifiacion = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        NotificacionesTable = new javax.swing.JTable();
        VerNotificacionButton = new javax.swing.JButton();
        btnBuscarNotificacion = new javax.swing.JButton();
        VerNotificacion = new javax.swing.JPanel();
        tituloVerNotificacion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fechaVerNotificacion = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        textoVerNotificacion = new javax.swing.JTextArea();
        EstadisticasPanel = new javax.swing.JPanel();
        TituloEstadisticasSede = new javax.swing.JLabel();
        TituloLabel17 = new javax.swing.JLabel();
        TituloLabel19 = new javax.swing.JLabel();
        TituloLabel20 = new javax.swing.JLabel();
        TituloLabel21 = new javax.swing.JLabel();
        TituloLabel22 = new javax.swing.JLabel();
        TituloLabel23 = new javax.swing.JLabel();
        TituloLabel24 = new javax.swing.JLabel();
        carrConMasEstSede = new javax.swing.JLabel();
        TituloLabel26 = new javax.swing.JLabel();
        carrConMasApSede = new javax.swing.JLabel();
        TituloLabel28 = new javax.swing.JLabel();
        carrConMejorPromApSede = new javax.swing.JLabel();
        promNotaParSede = new javax.swing.JLabel();
        promNotaExSede = new javax.swing.JLabel();
        promApCarrSede = new javax.swing.JLabel();
        promApCursosSede = new javax.swing.JLabel();
        TituloLabel34 = new javax.swing.JLabel();
        TituloLabel35 = new javax.swing.JLabel();
        cursoConMasEstSede = new javax.swing.JLabel();
        TituloLabel37 = new javax.swing.JLabel();
        cursoConMasApSede = new javax.swing.JLabel();
        TituloLabel39 = new javax.swing.JLabel();
        cursoConMejorPromApSede = new javax.swing.JLabel();
        EnSedeSelecRadioButton = new javax.swing.JRadioButton();
        EnTodasSedesRadioButton = new javax.swing.JRadioButton();
        EstadisticasCarreraPanel = new javax.swing.JPanel();
        TituloEstadisticasCarrera = new javax.swing.JLabel();
        TituloLabel41 = new javax.swing.JLabel();
        TituloLabel44 = new javax.swing.JLabel();
        TituloLabel45 = new javax.swing.JLabel();
        TituloLabel46 = new javax.swing.JLabel();
        promNotaParCarr = new javax.swing.JLabel();
        promNotaExCarr = new javax.swing.JLabel();
        promApCarr = new javax.swing.JLabel();
        TituloLabel57 = new javax.swing.JLabel();
        TituloLabel58 = new javax.swing.JLabel();
        conMasEstCarr = new javax.swing.JLabel();
        TituloLabel60 = new javax.swing.JLabel();
        conMasApCarr = new javax.swing.JLabel();
        TituloLabel62 = new javax.swing.JLabel();
        conMejorPromApCarr = new javax.swing.JLabel();
        EnSedeCarrRadioButton = new javax.swing.JRadioButton();
        EnTodasCarrRadioButton = new javax.swing.JRadioButton();
        EstadisticasCursoPanel = new javax.swing.JPanel();
        TituloEstadisticasCurso = new javax.swing.JLabel();
        TituloLabel42 = new javax.swing.JLabel();
        TituloLabel47 = new javax.swing.JLabel();
        TituloLabel48 = new javax.swing.JLabel();
        TituloLabel49 = new javax.swing.JLabel();
        promNotaParCurso = new javax.swing.JLabel();
        promNotaExCurso = new javax.swing.JLabel();
        promAprobCurso = new javax.swing.JLabel();
        TituloLabel66 = new javax.swing.JLabel();
        EnSelecCursoRadioButton = new javax.swing.JRadioButton();
        EnTodasCursoRadioButton = new javax.swing.JRadioButton();
        CargandoPanel = new javax.swing.JPanel();
        imgCargando = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        VerCarreraPanel = new javax.swing.JPanel();
        NombreCarreraLabel = new javax.swing.JLabel();
        TituloLabel15 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        CursosCarreraTable = new javax.swing.JTable();
        TituloLabel25 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        descCarreraTextArea = new javax.swing.JTextArea();
        TituloLabel27 = new javax.swing.JLabel();
        TituloLabel29 = new javax.swing.JLabel();
        sedeCarreraLabel = new javax.swing.JLabel();
        TituloLabel30 = new javax.swing.JLabel();
        creditosCarrLabel = new javax.swing.JLabel();
        PanelCabecera = new javax.swing.JPanel();
        notificacionIcono = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nombreUsrLabel = new javax.swing.JLabel();
        VolverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Principal");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(10, 10, 10)
                .addGroup(SedesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10))
        );

        SedeSelec.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        SedeSelec.setForeground(new java.awt.Color(255, 255, 51));
        SedeSelec.setText("<html>No hay sede seleccionada</html>");

        NoticiasOpcion.setBackground(new java.awt.Color(29, 131, 72));
        NoticiasOpcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoticiasOpcionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NoticiasOpcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NoticiasOpcionMouseExited(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/noticias.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Noticias");

        javax.swing.GroupLayout NoticiasOpcionLayout = new javax.swing.GroupLayout(NoticiasOpcion);
        NoticiasOpcion.setLayout(NoticiasOpcionLayout);
        NoticiasOpcionLayout.setHorizontalGroup(
            NoticiasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NoticiasOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NoticiasOpcionLayout.setVerticalGroup(
            NoticiasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(NoticiasOpcionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(NoticiasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        ExamenesOpcion.setBackground(new java.awt.Color(29, 131, 72));
        ExamenesOpcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExamenesOpcionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExamenesOpcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExamenesOpcionMouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/examen-blanco.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Exámenes");

        javax.swing.GroupLayout ExamenesOpcionLayout = new javax.swing.GroupLayout(ExamenesOpcion);
        ExamenesOpcion.setLayout(ExamenesOpcionLayout);
        ExamenesOpcionLayout.setHorizontalGroup(
            ExamenesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamenesOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        ExamenesOpcionLayout.setVerticalGroup(
            ExamenesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamenesOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ExamenesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ParcialesOpcion.setBackground(new java.awt.Color(29, 131, 72));
        ParcialesOpcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ParcialesOpcionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ParcialesOpcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ParcialesOpcionMouseExited(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/examen-blanco.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Parciales");

        javax.swing.GroupLayout ParcialesOpcionLayout = new javax.swing.GroupLayout(ParcialesOpcion);
        ParcialesOpcion.setLayout(ParcialesOpcionLayout);
        ParcialesOpcionLayout.setHorizontalGroup(
            ParcialesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParcialesOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ParcialesOpcionLayout.setVerticalGroup(
            ParcialesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParcialesOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ParcialesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addContainerGap())
        );

        EstadisticasOpcion.setBackground(new java.awt.Color(29, 131, 72));
        EstadisticasOpcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EstadisticasOpcionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EstadisticasOpcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EstadisticasOpcionMouseExited(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estadisticas-opcion.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Estadísticas");

        javax.swing.GroupLayout EstadisticasOpcionLayout = new javax.swing.GroupLayout(EstadisticasOpcion);
        EstadisticasOpcion.setLayout(EstadisticasOpcionLayout);
        EstadisticasOpcionLayout.setHorizontalGroup(
            EstadisticasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EstadisticasOpcionLayout.setVerticalGroup(
            EstadisticasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstadisticasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelLateralLayout = new javax.swing.GroupLayout(PanelLateral);
        PanelLateral.setLayout(PanelLateralLayout);
        PanelLateralLayout.setHorizontalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addGroup(PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelLateralLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(EstadisticasOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(CursosOpcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CarrerasOpcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SedesOpcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NoticiasOpcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ExamenesOpcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ParcialesOpcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLateralLayout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(SedeSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelLateralLayout.setVerticalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(CursosOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarrerasOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SedesOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoticiasOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExamenesOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ParcialesOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EstadisticasOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SedeSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelPrincipal.setBackground(new java.awt.Color(73, 202, 114));
        PanelPrincipal.setLayout(new java.awt.CardLayout());

        CursosPanel.setBackground(new java.awt.Color(73, 202, 114));

        BuscarTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarTextField.setText("Buscar por curso, carrera");
        BuscarTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscarTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscarTextFieldFocusLost(evt);
            }
        });
        BuscarTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarTextFieldKeyReleased(evt);
            }
        });

        CursosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ObjCurso", "Nombre", "Creditos", "Optativo", "Carrera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        InscripcionCButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InscripcionCButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/inscripcion_verde.png"))); // NOI18N
        InscripcionCButton.setText("Inscribirse");
        InscripcionCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscripcionCButtonActionPerformed(evt);
            }
        });

        TodosRadioButton.setBackground(new java.awt.Color(73, 202, 114));
        buttonGroupCursos.add(TodosRadioButton);
        TodosRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TodosRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        TodosRadioButton.setSelected(true);
        TodosRadioButton.setText("Todos");
        TodosRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TodosRadioButtonItemStateChanged(evt);
            }
        });
        TodosRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TodosRadioButtonActionPerformed(evt);
            }
        });

        CursandoRadioButton.setBackground(new java.awt.Color(73, 202, 114));
        buttonGroupCursos.add(CursandoRadioButton);
        CursandoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CursandoRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        CursandoRadioButton.setText("Cursando");
        CursandoRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CursandoRadioButtonItemStateChanged(evt);
            }
        });
        CursandoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CursandoRadioButtonActionPerformed(evt);
            }
        });

        AprobadosRadioButton.setBackground(new java.awt.Color(73, 202, 114));
        buttonGroupCursos.add(AprobadosRadioButton);
        AprobadosRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AprobadosRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        AprobadosRadioButton.setText("Aprobados");
        AprobadosRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AprobadosRadioButtonItemStateChanged(evt);
            }
        });
        AprobadosRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AprobadosRadioButtonActionPerformed(evt);
            }
        });

        BuscarButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarButton.setText("Buscar");
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });

        InscripcionCButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InscripcionCButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estadisticas.png"))); // NOI18N
        InscripcionCButton1.setText("Estadísticas");
        InscripcionCButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscripcionCButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CursosPanelLayout = new javax.swing.GroupLayout(CursosPanel);
        CursosPanel.setLayout(CursosPanelLayout);
        CursosPanelLayout.setHorizontalGroup(
            CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CursosPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CursosPanelLayout.createSequentialGroup()
                        .addComponent(BuscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TodosRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CursandoRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AprobadosRadioButton))
                    .addGroup(CursosPanelLayout.createSequentialGroup()
                        .addComponent(VerCursoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InscripcionCButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InscripcionCButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        CursosPanelLayout.setVerticalGroup(
            CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CursosPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TodosRadioButton)
                    .addComponent(CursandoRadioButton)
                    .addComponent(AprobadosRadioButton)
                    .addComponent(BuscarButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VerCursoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InscripcionCButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InscripcionCButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PanelPrincipal.add(CursosPanel, "cardCursos");

        CarrerasPanel.setBackground(new java.awt.Color(73, 202, 114));

        BuscarCarrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarCarrera.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscarCarreraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscarCarreraFocusLost(evt);
            }
        });
        BuscarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarCarreraActionPerformed(evt);
            }
        });
        BuscarCarrera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarCarreraKeyReleased(evt);
            }
        });

        VerCarrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VerCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ver_verde.png"))); // NOI18N
        VerCarrera.setText("Ver Detalles");
        VerCarrera.setToolTipText("");
        VerCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerCarreraActionPerformed(evt);
            }
        });

        btnBuscarCarrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarCarrera.setText("Buscar");
        btnBuscarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCarreraActionPerformed(evt);
            }
        });

        CarreraTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ObjCarrera", "Nombre", "Créditos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(CarreraTable);

        btnEstadCarr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEstadCarr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estadisticas.png"))); // NOI18N
        btnEstadCarr.setText("Estadísticas");
        btnEstadCarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadCarrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CarrerasPanelLayout = new javax.swing.GroupLayout(CarrerasPanel);
        CarrerasPanel.setLayout(CarrerasPanelLayout);
        CarrerasPanelLayout.setHorizontalGroup(
            CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CarrerasPanelLayout.createSequentialGroup()
                .addGroup(CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CarrerasPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(VerCarrera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEstadCarr))
                    .addGroup(CarrerasPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(BuscarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CarrerasPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        CarrerasPanelLayout.setVerticalGroup(
            CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CarrerasPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarCarrera)
                    .addComponent(BuscarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VerCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstadCarr))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipal.add(CarrerasPanel, "cardCarreras");

        SedesPanel.setBackground(new java.awt.Color(73, 202, 114));

        BuscarSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarSede.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscarSedeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscarSedeFocusLost(evt);
            }
        });
        BuscarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarSedeActionPerformed(evt);
            }
        });
        BuscarSede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarSedeKeyReleased(evt);
            }
        });

        SedeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ObjSede", "Nombre", "Direccion", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(SedeTable);
        if (SedeTable.getColumnModel().getColumnCount() > 0) {
            SedeTable.getColumnModel().getColumn(2).setHeaderValue("Direccion");
            SedeTable.getColumnModel().getColumn(3).setHeaderValue("Telefono");
        }

        SeleccionarSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SeleccionarSede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-square.png"))); // NOI18N
        SeleccionarSede.setText("Seleccionar");
        SeleccionarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarSedeActionPerformed(evt);
            }
        });

        btnBuscarSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarSede.setText("Buscar");
        btnBuscarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SedesPanelLayout = new javax.swing.GroupLayout(SedesPanel);
        SedesPanel.setLayout(SedesPanelLayout);
        SedesPanelLayout.setHorizontalGroup(
            SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SedesPanelLayout.createSequentialGroup()
                .addGroup(SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SedesPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(SeleccionarSede))
                    .addGroup(SedesPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(BuscarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SedesPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        SedesPanelLayout.setVerticalGroup(
            SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SedesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarSede)
                    .addComponent(BuscarSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(SeleccionarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelPrincipal.add(SedesPanel, "cardSedes");

        NoticiasPanel.setBackground(new java.awt.Color(73, 202, 114));

        BuscarNoticia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarNoticia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscarNoticiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscarNoticiaFocusLost(evt);
            }
        });
        BuscarNoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarNoticiaActionPerformed(evt);
            }
        });
        BuscarNoticia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarNoticiaKeyReleased(evt);
            }
        });

        NoticiasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objeto", "Título", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(NoticiasTable);

        SeleccionarNoticia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SeleccionarNoticia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ver_verde.png"))); // NOI18N
        SeleccionarNoticia.setText("Ver Noticia");
        SeleccionarNoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarNoticiaActionPerformed(evt);
            }
        });

        btnBuscarNoticia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarNoticia.setText("Buscar");
        btnBuscarNoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNoticiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NoticiasPanelLayout = new javax.swing.GroupLayout(NoticiasPanel);
        NoticiasPanel.setLayout(NoticiasPanelLayout);
        NoticiasPanelLayout.setHorizontalGroup(
            NoticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NoticiasPanelLayout.createSequentialGroup()
                .addGroup(NoticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NoticiasPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(SeleccionarNoticia))
                    .addGroup(NoticiasPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(BuscarNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NoticiasPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        NoticiasPanelLayout.setVerticalGroup(
            NoticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NoticiasPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(NoticiasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarNoticia)
                    .addComponent(BuscarNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(SeleccionarNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelPrincipal.add(NoticiasPanel, "cardSedes");

        ExamenesPanel.setBackground(new java.awt.Color(73, 202, 114));

        BuscarExamenTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarExamenTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscarExamenTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscarExamenTextFieldFocusLost(evt);
            }
        });
        BuscarExamenTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarExamenTextFieldActionPerformed(evt);
            }
        });
        BuscarExamenTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarExamenTextFieldKeyReleased(evt);
            }
        });

        ExamenesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objeto", "Curso", "Fecha", "Inicio inscripcion", "Fin inscripcion", "Muestra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(ExamenesTable);
        if (ExamenesTable.getColumnModel().getColumnCount() > 0) {
            ExamenesTable.getColumnModel().getColumn(4).setHeaderValue("Fin inscripcion");
            ExamenesTable.getColumnModel().getColumn(5).setHeaderValue("Muestra");
        }

        SeleccionarExamen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SeleccionarExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ver_verde.png"))); // NOI18N
        SeleccionarExamen.setText("Ver detalles");
        SeleccionarExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarExamenActionPerformed(evt);
            }
        });

        btnBuscarExamen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarExamen.setText("Buscar");
        btnBuscarExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarExamenActionPerformed(evt);
            }
        });

        TodosExRadioButton.setBackground(new java.awt.Color(73, 202, 114));
        buttonGroupExamenes.add(TodosExRadioButton);
        TodosExRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TodosExRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        TodosExRadioButton.setSelected(true);
        TodosExRadioButton.setText("Todos");
        TodosExRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TodosExRadioButtonItemStateChanged(evt);
            }
        });

        MisExmenesRadioButton.setBackground(new java.awt.Color(73, 202, 114));
        buttonGroupExamenes.add(MisExmenesRadioButton);
        MisExmenesRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MisExmenesRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        MisExmenesRadioButton.setText("Mis exámenes");
        MisExmenesRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MisExmenesRadioButtonItemStateChanged(evt);
            }
        });

        InscripcionExButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InscripcionExButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/inscripcion_verde.png"))); // NOI18N
        InscripcionExButton.setText("Inscribirse");
        InscripcionExButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscripcionExButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ExamenesPanelLayout = new javax.swing.GroupLayout(ExamenesPanel);
        ExamenesPanel.setLayout(ExamenesPanelLayout);
        ExamenesPanelLayout.setHorizontalGroup(
            ExamenesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamenesPanelLayout.createSequentialGroup()
                .addGroup(ExamenesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ExamenesPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(SeleccionarExamen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InscripcionExButton))
                    .addGroup(ExamenesPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(ExamenesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ExamenesPanelLayout.createSequentialGroup()
                                .addComponent(BuscarExamenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TodosExRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MisExmenesRadioButton)))))
                .addGap(25, 25, 25))
        );
        ExamenesPanelLayout.setVerticalGroup(
            ExamenesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExamenesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ExamenesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarExamen)
                    .addComponent(BuscarExamenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MisExmenesRadioButton)
                    .addComponent(TodosExRadioButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(ExamenesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeleccionarExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InscripcionExButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PanelPrincipal.add(ExamenesPanel, "cardSedes");

        VerExamenPanel.setBackground(new java.awt.Color(73, 202, 114));

        CurExamenLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        CurExamenLabel.setForeground(new java.awt.Color(255, 255, 255));
        CurExamenLabel.setText("Nombre");

        TituloLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel1.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel1.setText("Fecha de inscipción:");

        TituloLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel2.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel2.setText("Nota:");

        FechaInscLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FechaInscLabel.setForeground(new java.awt.Color(255, 255, 255));
        FechaInscLabel.setText("-");

        NotaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NotaLabel.setForeground(new java.awt.Color(255, 255, 255));
        NotaLabel.setText("-");

        TituloLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel3.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel3.setText("Fecha de nota:");

        fechaNotaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaNotaLabel.setForeground(new java.awt.Color(255, 255, 255));
        fechaNotaLabel.setText("-");

        javax.swing.GroupLayout VerExamenPanelLayout = new javax.swing.GroupLayout(VerExamenPanel);
        VerExamenPanel.setLayout(VerExamenPanelLayout);
        VerExamenPanelLayout.setHorizontalGroup(
            VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerExamenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerExamenPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NotaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerExamenPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FechaInscLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CurExamenLabel)
                    .addGroup(VerExamenPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaNotaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(624, Short.MAX_VALUE))
        );
        VerExamenPanelLayout.setVerticalGroup(
            VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerExamenPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(CurExamenLabel)
                .addGap(35, 35, 35)
                .addGroup(VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(VerExamenPanelLayout.createSequentialGroup()
                        .addGroup(VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloLabel1)
                            .addComponent(FechaInscLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(TituloLabel2))
                    .addComponent(NotaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloLabel3)
                    .addComponent(fechaNotaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(261, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerExamenPanel, "card7");

        ParcialesPanel.setBackground(new java.awt.Color(73, 202, 114));

        BuscarExamenTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarExamenTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscarExamenTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscarExamenTextField1FocusLost(evt);
            }
        });
        BuscarExamenTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarExamenTextField1ActionPerformed(evt);
            }
        });
        BuscarExamenTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarExamenTextField1KeyReleased(evt);
            }
        });

        ParcialesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objeto", "Curso", "Fecha", "Instancia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(ParcialesTable);

        SeleccionarParcial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SeleccionarParcial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ver_verde.png"))); // NOI18N
        SeleccionarParcial.setText("Ver detalles");
        SeleccionarParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarParcialActionPerformed(evt);
            }
        });

        btnBuscarParcial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarParcial.setText("Buscar");
        btnBuscarParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarParcialActionPerformed(evt);
            }
        });

        TodosParRadioButton.setBackground(new java.awt.Color(73, 202, 114));
        buttonGroupParciales.add(TodosParRadioButton);
        TodosParRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TodosParRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        TodosParRadioButton.setSelected(true);
        TodosParRadioButton.setText("Todos");
        TodosParRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TodosParRadioButtonItemStateChanged(evt);
            }
        });

        MisParcialesRadioButton.setBackground(new java.awt.Color(73, 202, 114));
        buttonGroupParciales.add(MisParcialesRadioButton);
        MisParcialesRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MisParcialesRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        MisParcialesRadioButton.setText("Mis parciales");
        MisParcialesRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MisParcialesRadioButtonItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout ParcialesPanelLayout = new javax.swing.GroupLayout(ParcialesPanel);
        ParcialesPanel.setLayout(ParcialesPanelLayout);
        ParcialesPanelLayout.setHorizontalGroup(
            ParcialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParcialesPanelLayout.createSequentialGroup()
                .addGroup(ParcialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ParcialesPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(SeleccionarParcial))
                    .addGroup(ParcialesPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(ParcialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ParcialesPanelLayout.createSequentialGroup()
                                .addComponent(BuscarExamenTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TodosParRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MisParcialesRadioButton)))))
                .addGap(25, 25, 25))
        );
        ParcialesPanelLayout.setVerticalGroup(
            ParcialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParcialesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ParcialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarParcial)
                    .addComponent(BuscarExamenTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MisParcialesRadioButton)
                    .addComponent(TodosParRadioButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(SeleccionarParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelPrincipal.add(ParcialesPanel, "cardSedes");

        VerParcialPanel.setBackground(new java.awt.Color(73, 202, 114));

        CurParcialLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        CurParcialLabel.setForeground(new java.awt.Color(255, 255, 255));
        CurParcialLabel.setText("Nombre");

        TituloLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel5.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel5.setText("Fecha:");

        TituloLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel6.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel6.setText("Nota:");

        FechaParcialLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FechaParcialLabel.setForeground(new java.awt.Color(255, 255, 255));
        FechaParcialLabel.setText("-");

        NotaPLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NotaPLabel.setForeground(new java.awt.Color(255, 255, 255));
        NotaPLabel.setText("-");

        TituloLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel10.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel10.setText("Fecha de nota:");

        fechaNotaPLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaNotaPLabel.setForeground(new java.awt.Color(255, 255, 255));
        fechaNotaPLabel.setText("-");

        TituloLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel11.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel11.setText("Instancia:");

        InstanciaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InstanciaLabel.setForeground(new java.awt.Color(255, 255, 255));
        InstanciaLabel.setText("-");

        javax.swing.GroupLayout VerParcialPanelLayout = new javax.swing.GroupLayout(VerParcialPanel);
        VerParcialPanel.setLayout(VerParcialPanelLayout);
        VerParcialPanelLayout.setHorizontalGroup(
            VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerParcialPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerParcialPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FechaParcialLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CurParcialLabel)
                    .addGroup(VerParcialPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaNotaPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerParcialPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InstanciaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerParcialPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NotaPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(658, Short.MAX_VALUE))
        );
        VerParcialPanelLayout.setVerticalGroup(
            VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerParcialPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(CurParcialLabel)
                .addGap(35, 35, 35)
                .addGroup(VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloLabel5)
                    .addComponent(FechaParcialLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloLabel11)
                    .addComponent(InstanciaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TituloLabel6)
                    .addComponent(NotaPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloLabel10)
                    .addComponent(fechaNotaPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerParcialPanel, "card7");

        VerNoticia.setBackground(new java.awt.Color(73, 202, 114));

        verNoticia_titulo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        verNoticia_titulo.setForeground(new java.awt.Color(255, 255, 255));
        verNoticia_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verNoticia_titulo.setToolTipText("");
        verNoticia_titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fecha de creación:");

        verNoticia_fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verNoticia_fecha.setForeground(new java.awt.Color(255, 255, 255));
        verNoticia_fecha.setText("jLabel3");

        verNoticia_etiquetas.setEnabled(false);
        jScrollPane9.setViewportView(verNoticia_etiquetas);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Etiquetas");

        verNoticia_texto.setEditable(false);
        verNoticia_texto.setColumns(20);
        verNoticia_texto.setRows(5);
        jScrollPane10.setViewportView(verNoticia_texto);

        javax.swing.GroupLayout VerNoticiaLayout = new javax.swing.GroupLayout(VerNoticia);
        VerNoticia.setLayout(VerNoticiaLayout);
        VerNoticiaLayout.setHorizontalGroup(
            VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerNoticiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGroup(VerNoticiaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verNoticia_fecha))
                    .addComponent(verNoticia_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap(455, Short.MAX_VALUE))
        );
        VerNoticiaLayout.setVerticalGroup(
            VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VerNoticiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(verNoticia_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(verNoticia_fecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        PanelPrincipal.add(VerNoticia, "card11");

        VerPerfilPanel.setBackground(new java.awt.Color(73, 202, 114));

        nombreEstLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nombreEstLabel.setForeground(new java.awt.Color(255, 255, 255));
        nombreEstLabel.setText("Nombre");

        AuxLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuxLabel.setForeground(new java.awt.Color(255, 255, 255));
        AuxLabel.setText("Id:");

        idEstLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idEstLabel.setForeground(new java.awt.Color(255, 255, 255));
        idEstLabel.setText("-");

        AuxLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuxLabel1.setForeground(new java.awt.Color(255, 255, 255));
        AuxLabel1.setText("Email:");

        emailEstLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailEstLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailEstLabel.setText("-");

        AuxLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuxLabel2.setForeground(new java.awt.Color(255, 255, 255));
        AuxLabel2.setText("Fecha de nacimiento");

        fechaNacLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaNacLabel.setForeground(new java.awt.Color(255, 255, 255));
        fechaNacLabel.setText("-");

        ciEstLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ciEstLabel.setForeground(new java.awt.Color(255, 255, 255));
        ciEstLabel.setText("-");

        AuxLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuxLabel3.setForeground(new java.awt.Color(255, 255, 255));
        AuxLabel3.setText("CI:");

        AuxLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuxLabel4.setForeground(new java.awt.Color(255, 255, 255));
        AuxLabel4.setText("Configuración de notificaciones:");

        enviarMailsCheckBox.setBackground(new java.awt.Color(73, 202, 114));
        enviarMailsCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enviarMailsCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        enviarMailsCheckBox.setText("Enviar notificaciones a mi email");
        enviarMailsCheckBox.setFocusPainted(false);
        enviarMailsCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                enviarMailsCheckBoxItemStateChanged(evt);
            }
        });

        VerCursosPerfilButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VerCursosPerfilButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ver_verde.png"))); // NOI18N
        VerCursosPerfilButton.setText("Mis Cursos");
        VerCursosPerfilButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        VerCursosPerfilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerCursosPerfilButtonActionPerformed(evt);
            }
        });

        VerExamenesPerfilButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VerExamenesPerfilButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/examenes.png"))); // NOI18N
        VerExamenesPerfilButton.setText("Mis Exámenes");
        VerExamenesPerfilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerExamenesPerfilButtonActionPerformed(evt);
            }
        });

        VerParcialesPerfilButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VerParcialesPerfilButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/examenes.png"))); // NOI18N
        VerParcialesPerfilButton.setText("Mis Parciales");
        VerParcialesPerfilButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        VerParcialesPerfilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerParcialesPerfilButtonActionPerformed(evt);
            }
        });

        imagenGif.setText("jLabel17");

        javax.swing.GroupLayout VerPerfilPanelLayout = new javax.swing.GroupLayout(VerPerfilPanel);
        VerPerfilPanel.setLayout(VerPerfilPanelLayout);
        VerPerfilPanelLayout.setHorizontalGroup(
            VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                        .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreEstLabel)
                            .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                                .addComponent(AuxLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idEstLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                                .addComponent(AuxLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emailEstLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                                .addComponent(AuxLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ciEstLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AuxLabel4)
                            .addComponent(enviarMailsCheckBox)
                            .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(VerParcialesPerfilButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VerCursosPerfilButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VerExamenesPerfilButton, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                        .addComponent(AuxLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaNacLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                        .addComponent(imagenGif)
                        .addGap(253, 253, 253))))
        );
        VerPerfilPanelLayout.setVerticalGroup(
            VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(nombreEstLabel)
                .addGap(35, 35, 35)
                .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuxLabel)
                    .addComponent(idEstLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuxLabel2)
                    .addComponent(fechaNacLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagenGif))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuxLabel3)
                    .addComponent(ciEstLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuxLabel1)
                    .addComponent(emailEstLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AuxLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enviarMailsCheckBox)
                .addGap(18, 18, 18)
                .addComponent(VerCursosPerfilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VerExamenesPerfilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VerParcialesPerfilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerPerfilPanel, "card12");

        VerCursoPanel.setBackground(new java.awt.Color(73, 202, 114));

        CreditosLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CreditosLabel.setForeground(new java.awt.Color(255, 255, 255));

        OptativoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        OptativoLabel.setForeground(new java.awt.Color(255, 255, 255));

        DescTextArea.setEditable(false);
        DescTextArea.setColumns(20);
        DescTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DescTextArea.setLineWrap(true);
        DescTextArea.setRows(5);
        jScrollPane13.setViewportView(DescTextArea);

        HorariosTextArea.setEditable(false);
        HorariosTextArea.setColumns(20);
        HorariosTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        HorariosTextArea.setLineWrap(true);
        jScrollPane14.setViewportView(HorariosTextArea);

        TituloLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        TituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel.setText("Nombre");

        TituloLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel7.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel7.setText("Créditos:");

        TituloLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel8.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel8.setText("Optativo:");

        TituloLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel9.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel9.setText("Horarios:");

        TituloLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel4.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel4.setText("Descripción:");

        PreviasCurTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Curso", "Tipo de previa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane22.setViewportView(PreviasCurTable);

        TituloLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel12.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel12.setText("Previas:");

        TituloLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel13.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel13.setText("Carrera:");

        carreraCurLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        carreraCurLabel.setForeground(new java.awt.Color(255, 255, 255));

        TituloLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel16.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel16.setText("Nota aprobación:");

        TituloLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel18.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel18.setText("Nota exoneración exámen:");

        notaExonExLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        notaExonExLabel.setForeground(new java.awt.Color(255, 255, 255));

        notaAprobCurLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        notaAprobCurLabel.setForeground(new java.awt.Color(255, 255, 255));

        VerMaterialSubidoButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VerMaterialSubidoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/material.png"))); // NOI18N
        VerMaterialSubidoButton.setText("Material del Curso");
        VerMaterialSubidoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerMaterialSubidoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VerCursoPanelLayout = new javax.swing.GroupLayout(VerCursoPanel);
        VerCursoPanel.setLayout(VerCursoPanelLayout);
        VerCursoPanelLayout.setHorizontalGroup(
            VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerCursoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(jScrollPane14)
                    .addComponent(TituloLabel4)
                    .addComponent(TituloLabel9)
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OptativoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CreditosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TituloLabel)
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carreraCurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notaAprobCurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(notaExonExLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloLabel12)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VerMaterialSubidoButton))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        VerCursoPanelLayout.setVerticalGroup(
            VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerCursoPanelLayout.createSequentialGroup()
                .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(TituloLabel)
                        .addGap(18, 18, 18)
                        .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(VerCursoPanelLayout.createSequentialGroup()
                                .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TituloLabel7)
                                    .addComponent(CreditosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TituloLabel8))
                            .addComponent(OptativoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TituloLabel13)
                            .addComponent(carreraCurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(VerCursoPanelLayout.createSequentialGroup()
                                .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TituloLabel18)
                                    .addComponent(notaExonExLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TituloLabel16))
                            .addComponent(notaAprobCurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TituloLabel9)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TituloLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(VerMaterialSubidoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerCursoPanel, "card7");

        MaterialesSubidosPanel.setBackground(new java.awt.Color(73, 202, 114));

        MaterialesSubidosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objeto", "Título", "Subido", "Docente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MaterialesSubidosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaterialesSubidosTableMouseClicked(evt);
            }
        });
        MaterialesSubidosTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                MaterialesSubidosTablePropertyChange(evt);
            }
        });
        MaterialesSubidosTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MaterialesSubidosTableKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(MaterialesSubidosTable);

        TituloLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel14.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel14.setText("Descripción:");

        DescMaterialTextArea.setEditable(false);
        DescMaterialTextArea.setColumns(20);
        DescMaterialTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DescMaterialTextArea.setLineWrap(true);
        jScrollPane17.setViewportView(DescMaterialTextArea);

        DescargarMaterialButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DescargarMaterialButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/descargar.png"))); // NOI18N
        DescargarMaterialButton.setText("Descargar");
        DescargarMaterialButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DescargarMaterialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescargarMaterialButtonActionPerformed(evt);
            }
        });

        tituloMateriales.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tituloMateriales.setForeground(new java.awt.Color(255, 255, 255));
        tituloMateriales.setText("Material subido para Curso");

        javax.swing.GroupLayout MaterialesSubidosPanelLayout = new javax.swing.GroupLayout(MaterialesSubidosPanel);
        MaterialesSubidosPanel.setLayout(MaterialesSubidosPanelLayout);
        MaterialesSubidosPanelLayout.setHorizontalGroup(
            MaterialesSubidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MaterialesSubidosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MaterialesSubidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescargarMaterialButton)
                    .addGroup(MaterialesSubidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane17)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                        .addComponent(TituloLabel14, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(tituloMateriales))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        MaterialesSubidosPanelLayout.setVerticalGroup(
            MaterialesSubidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MaterialesSubidosPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(tituloMateriales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TituloLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DescargarMaterialButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipal.add(MaterialesSubidosPanel, "card15");

        NotificacionesPanel.setBackground(new java.awt.Color(73, 202, 114));

        BuscarNotifiacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarNotifiacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscarNotifiacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscarNotifiacionFocusLost(evt);
            }
        });
        BuscarNotifiacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarNotifiacionActionPerformed(evt);
            }
        });
        BuscarNotifiacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarNotifiacionKeyReleased(evt);
            }
        });

        NotificacionesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objeto", "Título", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(NotificacionesTable);

        VerNotificacionButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VerNotificacionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ver_verde.png"))); // NOI18N
        VerNotificacionButton.setText("Ver Notificación");
        VerNotificacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerNotificacionButtonActionPerformed(evt);
            }
        });

        btnBuscarNotificacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarNotificacion.setText("Buscar");
        btnBuscarNotificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNotificacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NotificacionesPanelLayout = new javax.swing.GroupLayout(NotificacionesPanel);
        NotificacionesPanel.setLayout(NotificacionesPanelLayout);
        NotificacionesPanelLayout.setHorizontalGroup(
            NotificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NotificacionesPanelLayout.createSequentialGroup()
                .addGroup(NotificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NotificacionesPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(VerNotificacionButton))
                    .addGroup(NotificacionesPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(BuscarNotifiacion, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarNotificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NotificacionesPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        NotificacionesPanelLayout.setVerticalGroup(
            NotificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotificacionesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(NotificacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarNotificacion)
                    .addComponent(BuscarNotifiacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(VerNotificacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelPrincipal.add(NotificacionesPanel, "cardSedes");

        VerNotificacion.setBackground(new java.awt.Color(73, 202, 114));

        tituloVerNotificacion.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tituloVerNotificacion.setForeground(new java.awt.Color(255, 255, 255));
        tituloVerNotificacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tituloVerNotificacion.setToolTipText("");
        tituloVerNotificacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha:");

        fechaVerNotificacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaVerNotificacion.setForeground(new java.awt.Color(255, 255, 255));
        fechaVerNotificacion.setText("-");

        textoVerNotificacion.setEditable(false);
        textoVerNotificacion.setColumns(20);
        textoVerNotificacion.setLineWrap(true);
        textoVerNotificacion.setRows(5);
        jScrollPane15.setViewportView(textoVerNotificacion);

        javax.swing.GroupLayout VerNotificacionLayout = new javax.swing.GroupLayout(VerNotificacion);
        VerNotificacion.setLayout(VerNotificacionLayout);
        VerNotificacionLayout.setHorizontalGroup(
            VerNotificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerNotificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerNotificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addGroup(VerNotificacionLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaVerNotificacion))
                    .addComponent(tituloVerNotificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(455, Short.MAX_VALUE))
        );
        VerNotificacionLayout.setVerticalGroup(
            VerNotificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VerNotificacionLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(tituloVerNotificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerNotificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fechaVerNotificacion))
                .addGap(186, 186, 186))
        );

        PanelPrincipal.add(VerNotificacion, "card11");

        EstadisticasPanel.setBackground(new java.awt.Color(73, 202, 114));

        TituloEstadisticasSede.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TituloEstadisticasSede.setForeground(new java.awt.Color(255, 255, 255));
        TituloEstadisticasSede.setText("Estadísticas para la sede Sede");

        TituloLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel17.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel17.setText("Promedios de aprobación");

        TituloLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel19.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel19.setText("De cursos:");

        TituloLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel20.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel20.setText("De carreras:");

        TituloLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel21.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel21.setText("Promedios de notas obtenidas");

        TituloLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel22.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel22.setText("En Exámenes:");

        TituloLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel23.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel23.setText("En parciales:");

        TituloLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel24.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel24.setText("Carrera con más estudiantes cursando");

        carrConMasEstSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        carrConMasEstSede.setForeground(new java.awt.Color(255, 255, 255));
        carrConMasEstSede.setText("Nombre");

        TituloLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel26.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel26.setText("Carrera con más egresados");

        carrConMasApSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        carrConMasApSede.setForeground(new java.awt.Color(255, 255, 255));
        carrConMasApSede.setText("No hay datos");

        TituloLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel28.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel28.setText("Carrera con mejor promedio de egreso");

        carrConMejorPromApSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        carrConMejorPromApSede.setForeground(new java.awt.Color(255, 255, 255));
        carrConMejorPromApSede.setText("No hay datos");

        promNotaParSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        promNotaParSede.setForeground(new java.awt.Color(255, 255, 255));
        promNotaParSede.setText("No hay datos");

        promNotaExSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        promNotaExSede.setForeground(new java.awt.Color(255, 255, 255));
        promNotaExSede.setText("No hay datos");

        promApCarrSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        promApCarrSede.setForeground(new java.awt.Color(255, 255, 255));
        promApCarrSede.setText("No hay datos");

        promApCursosSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        promApCursosSede.setForeground(new java.awt.Color(255, 255, 255));
        promApCursosSede.setText("No hay datos");

        TituloLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloLabel34.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/grafica.png"))); // NOI18N

        TituloLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel35.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel35.setText("Curso con más estudiantes cursando");

        cursoConMasEstSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cursoConMasEstSede.setForeground(new java.awt.Color(255, 255, 255));
        cursoConMasEstSede.setText("No hay datos");

        TituloLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel37.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel37.setText("Curso con más aprobaciones");

        cursoConMasApSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cursoConMasApSede.setForeground(new java.awt.Color(255, 255, 255));
        cursoConMasApSede.setText("No hay datos");

        TituloLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel39.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel39.setText("Curso con mejor promedio de aprobación");

        cursoConMejorPromApSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cursoConMejorPromApSede.setForeground(new java.awt.Color(255, 255, 255));
        cursoConMejorPromApSede.setText("No hay datos");

        buttonGroupEstadSede.add(EnSedeSelecRadioButton);
        EnSedeSelecRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EnSedeSelecRadioButton.setSelected(true);
        EnSedeSelecRadioButton.setText("Para sede seleccionada");
        EnSedeSelecRadioButton.setFocusPainted(false);
        EnSedeSelecRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EnSedeSelecRadioButtonItemStateChanged(evt);
            }
        });
        EnSedeSelecRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnSedeSelecRadioButtonActionPerformed(evt);
            }
        });

        buttonGroupEstadSede.add(EnTodasSedesRadioButton);
        EnTodasSedesRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EnTodasSedesRadioButton.setText("Para todas las sedes");
        EnTodasSedesRadioButton.setFocusPainted(false);
        EnTodasSedesRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EnTodasSedesRadioButtonItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout EstadisticasPanelLayout = new javax.swing.GroupLayout(EstadisticasPanel);
        EstadisticasPanel.setLayout(EstadisticasPanelLayout);
        EstadisticasPanelLayout.setHorizontalGroup(
            EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                        .addComponent(EnSedeSelecRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EnTodasSedesRadioButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                        .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TituloLabel24)
                            .addComponent(carrConMasEstSede)
                            .addComponent(TituloLabel26)
                            .addComponent(carrConMasApSede)
                            .addComponent(TituloLabel28)
                            .addComponent(carrConMejorPromApSede))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TituloLabel35)
                            .addComponent(cursoConMasEstSede)
                            .addComponent(TituloLabel37)
                            .addComponent(cursoConMasApSede)
                            .addComponent(TituloLabel39)
                            .addComponent(cursoConMejorPromApSede))
                        .addGap(169, 169, 169))
                    .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                        .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TituloLabel17)
                            .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(promApCursosSede))
                            .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(promApCarrSede)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TituloLabel21)
                            .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(promNotaExSede))
                            .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(promNotaParSede)))
                        .addGap(271, 271, 271))
                    .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TituloEstadisticasSede)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        EstadisticasPanelLayout.setVerticalGroup(
            EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloLabel34)
                    .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(TituloEstadisticasSede)))
                .addGap(18, 18, 18)
                .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EnSedeSelecRadioButton)
                    .addComponent(EnTodasSedesRadioButton))
                .addGap(18, 18, 18)
                .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloLabel19)
                            .addComponent(promApCursosSede))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloLabel20)
                            .addComponent(promApCarrSede)))
                    .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloLabel22)
                            .addComponent(promNotaExSede))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloLabel23)
                            .addComponent(promNotaParSede))))
                .addGap(18, 18, 18)
                .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(carrConMasEstSede)
                        .addGap(18, 18, 18)
                        .addComponent(TituloLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(carrConMasApSede)
                        .addGap(18, 18, 18)
                        .addComponent(TituloLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(carrConMejorPromApSede))
                    .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cursoConMasEstSede)
                        .addGap(18, 18, 18)
                        .addComponent(TituloLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cursoConMasApSede)
                        .addGap(18, 18, 18)
                        .addComponent(TituloLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cursoConMejorPromApSede)))
                .addGap(19, 19, 19))
        );

        PanelPrincipal.add(EstadisticasPanel, "card16");

        EstadisticasCarreraPanel.setBackground(new java.awt.Color(73, 202, 114));

        TituloEstadisticasCarrera.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TituloEstadisticasCarrera.setForeground(new java.awt.Color(255, 255, 255));
        TituloEstadisticasCarrera.setText("Estadísticas para la carrera carrera");

        TituloLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel41.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel41.setText("Promedio de aprobación");

        TituloLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel44.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel44.setText("Promedios de notas obtenidas");

        TituloLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel45.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel45.setText("En Exámenes:");

        TituloLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel46.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel46.setText("En parciales:");

        promNotaParCarr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        promNotaParCarr.setForeground(new java.awt.Color(255, 255, 255));
        promNotaParCarr.setText("No hay datos");

        promNotaExCarr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        promNotaExCarr.setForeground(new java.awt.Color(255, 255, 255));
        promNotaExCarr.setText("No hay datos");

        promApCarr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        promApCarr.setForeground(new java.awt.Color(255, 255, 255));
        promApCarr.setText("No hay datos");

        TituloLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloLabel57.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/grafica.png"))); // NOI18N

        TituloLabel58.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel58.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel58.setText("Curso con más estudiantes cursando");

        conMasEstCarr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        conMasEstCarr.setForeground(new java.awt.Color(255, 255, 255));
        conMasEstCarr.setText("No hay datos");

        TituloLabel60.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel60.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel60.setText("Curso con más aprobaciones");

        conMasApCarr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        conMasApCarr.setForeground(new java.awt.Color(255, 255, 255));
        conMasApCarr.setText("No hay datos");

        TituloLabel62.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel62.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel62.setText("Curso con mejor promedio de aprobación");

        conMejorPromApCarr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        conMejorPromApCarr.setForeground(new java.awt.Color(255, 255, 255));
        conMejorPromApCarr.setText("No hay datos");

        buttonGroupEstadCarrera.add(EnSedeCarrRadioButton);
        EnSedeCarrRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EnSedeCarrRadioButton.setSelected(true);
        EnSedeCarrRadioButton.setText("En sede seleccionada");
        EnSedeCarrRadioButton.setFocusPainted(false);
        EnSedeCarrRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EnSedeCarrRadioButtonItemStateChanged(evt);
            }
        });
        EnSedeCarrRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnSedeCarrRadioButtonActionPerformed(evt);
            }
        });

        buttonGroupEstadCarrera.add(EnTodasCarrRadioButton);
        EnTodasCarrRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EnTodasCarrRadioButton.setText("En todas las sedes");
        EnTodasCarrRadioButton.setFocusPainted(false);
        EnTodasCarrRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EnTodasCarrRadioButtonItemStateChanged(evt);
            }
        });
        EnTodasCarrRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnTodasCarrRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EstadisticasCarreraPanelLayout = new javax.swing.GroupLayout(EstadisticasCarreraPanel);
        EstadisticasCarreraPanel.setLayout(EstadisticasCarreraPanelLayout);
        EstadisticasCarreraPanelLayout.setHorizontalGroup(
            EstadisticasCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasCarreraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstadisticasCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EstadisticasCarreraPanelLayout.createSequentialGroup()
                        .addComponent(EnSedeCarrRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EnTodasCarrRadioButton))
                    .addComponent(TituloLabel41)
                    .addComponent(promApCarr)
                    .addGroup(EstadisticasCarreraPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TituloEstadisticasCarrera))
                    .addComponent(TituloLabel44)
                    .addGroup(EstadisticasCarreraPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(promNotaExCarr))
                    .addGroup(EstadisticasCarreraPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(promNotaParCarr)))
                .addGap(44, 44, 44)
                .addGroup(EstadisticasCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloLabel58)
                    .addComponent(conMasEstCarr)
                    .addComponent(TituloLabel60)
                    .addComponent(conMasApCarr)
                    .addComponent(TituloLabel62)
                    .addComponent(conMejorPromApCarr))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        EstadisticasCarreraPanelLayout.setVerticalGroup(
            EstadisticasCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasCarreraPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(EstadisticasCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloLabel57)
                    .addGroup(EstadisticasCarreraPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(TituloEstadisticasCarrera)))
                .addGap(18, 18, 18)
                .addGroup(EstadisticasCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EnSedeCarrRadioButton)
                    .addComponent(EnTodasCarrRadioButton))
                .addGap(18, 18, 18)
                .addGroup(EstadisticasCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EstadisticasCarreraPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(promApCarr)
                        .addGap(18, 18, 18)
                        .addComponent(TituloLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EstadisticasCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloLabel45)
                            .addComponent(promNotaExCarr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EstadisticasCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloLabel46)
                            .addComponent(promNotaParCarr)))
                    .addGroup(EstadisticasCarreraPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conMasEstCarr)
                        .addGap(18, 18, 18)
                        .addComponent(TituloLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conMasApCarr)
                        .addGap(18, 18, 18)
                        .addComponent(TituloLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conMejorPromApCarr)))
                .addGap(107, 107, 107))
        );

        PanelPrincipal.add(EstadisticasCarreraPanel, "card16");

        EstadisticasCursoPanel.setBackground(new java.awt.Color(73, 202, 114));

        TituloEstadisticasCurso.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TituloEstadisticasCurso.setForeground(new java.awt.Color(255, 255, 255));
        TituloEstadisticasCurso.setText("Estadísticas para el curso Curso");

        TituloLabel42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel42.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel42.setText("Promedio de aprobación");

        TituloLabel47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel47.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel47.setText("Promedios de notas obtenidas");

        TituloLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel48.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel48.setText("En exámenes:");

        TituloLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel49.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel49.setText("En parciales:");

        promNotaParCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        promNotaParCurso.setForeground(new java.awt.Color(255, 255, 255));
        promNotaParCurso.setText("No hay datos");

        promNotaExCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        promNotaExCurso.setForeground(new java.awt.Color(255, 255, 255));
        promNotaExCurso.setText("No hay datos");

        promAprobCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        promAprobCurso.setForeground(new java.awt.Color(255, 255, 255));
        promAprobCurso.setText("No hay datos");

        TituloLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloLabel66.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/grafica.png"))); // NOI18N

        buttonGroupEstadCurso.add(EnSelecCursoRadioButton);
        EnSelecCursoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EnSelecCursoRadioButton.setSelected(true);
        EnSelecCursoRadioButton.setText("En sede seleccionada");
        EnSelecCursoRadioButton.setFocusPainted(false);
        EnSelecCursoRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EnSelecCursoRadioButtonItemStateChanged(evt);
            }
        });
        EnSelecCursoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnSelecCursoRadioButtonActionPerformed(evt);
            }
        });

        buttonGroupEstadCurso.add(EnTodasCursoRadioButton);
        EnTodasCursoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EnTodasCursoRadioButton.setText("En todas las sedes");
        EnTodasCursoRadioButton.setFocusPainted(false);
        EnTodasCursoRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EnTodasCursoRadioButtonItemStateChanged(evt);
            }
        });
        EnTodasCursoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnTodasCursoRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EstadisticasCursoPanelLayout = new javax.swing.GroupLayout(EstadisticasCursoPanel);
        EstadisticasCursoPanel.setLayout(EstadisticasCursoPanelLayout);
        EstadisticasCursoPanelLayout.setHorizontalGroup(
            EstadisticasCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasCursoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstadisticasCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EstadisticasCursoPanelLayout.createSequentialGroup()
                        .addComponent(EnSelecCursoRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EnTodasCursoRadioButton))
                    .addComponent(TituloLabel42)
                    .addComponent(promAprobCurso)
                    .addGroup(EstadisticasCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TituloEstadisticasCurso))
                    .addComponent(TituloLabel47)
                    .addGroup(EstadisticasCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(promNotaExCurso))
                    .addGroup(EstadisticasCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(promNotaParCurso)))
                .addContainerGap(528, Short.MAX_VALUE))
        );
        EstadisticasCursoPanelLayout.setVerticalGroup(
            EstadisticasCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasCursoPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(EstadisticasCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloLabel66)
                    .addGroup(EstadisticasCursoPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(TituloEstadisticasCurso)))
                .addGap(18, 18, 18)
                .addGroup(EstadisticasCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EnSelecCursoRadioButton)
                    .addComponent(EnTodasCursoRadioButton))
                .addGap(18, 18, 18)
                .addComponent(TituloLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(promAprobCurso)
                .addGap(18, 18, 18)
                .addComponent(TituloLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EstadisticasCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloLabel48)
                    .addComponent(promNotaExCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EstadisticasCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloLabel49)
                    .addComponent(promNotaParCurso))
                .addGap(147, 147, 147))
        );

        PanelPrincipal.add(EstadisticasCursoPanel, "card16");

        CargandoPanel.setBackground(new java.awt.Color(73, 202, 114));

        imgCargando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgCargando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cargandoGrande.gif"))); // NOI18N
        imgCargando.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cargando...");

        javax.swing.GroupLayout CargandoPanelLayout = new javax.swing.GroupLayout(CargandoPanel);
        CargandoPanel.setLayout(CargandoPanelLayout);
        CargandoPanelLayout.setHorizontalGroup(
            CargandoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CargandoPanelLayout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addGroup(CargandoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CargandoPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel18))
                    .addComponent(imgCargando))
                .addContainerGap(385, Short.MAX_VALUE))
        );
        CargandoPanelLayout.setVerticalGroup(
            CargandoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CargandoPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(imgCargando)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        PanelPrincipal.add(CargandoPanel, "card19");

        VerCarreraPanel.setBackground(new java.awt.Color(73, 202, 114));

        NombreCarreraLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        NombreCarreraLabel.setForeground(new java.awt.Color(255, 255, 255));
        NombreCarreraLabel.setText("Nombre");

        TituloLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel15.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel15.setText("Créditos:");

        CursosCarreraTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ObjCurso", "Nombre", "Creditos", "Optativo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane21.setViewportView(CursosCarreraTable);

        TituloLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel25.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel25.setText("Cursos:");

        descCarreraTextArea.setEditable(false);
        descCarreraTextArea.setColumns(20);
        descCarreraTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descCarreraTextArea.setLineWrap(true);
        jScrollPane23.setViewportView(descCarreraTextArea);

        TituloLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel27.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel27.setText("Descripción:");

        TituloLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel29.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel29.setText("Sede:");

        sedeCarreraLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sedeCarreraLabel.setForeground(new java.awt.Color(255, 255, 255));

        TituloLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel30.setForeground(new java.awt.Color(255, 255, 255));

        creditosCarrLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        creditosCarrLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout VerCarreraPanelLayout = new javax.swing.GroupLayout(VerCarreraPanel);
        VerCarreraPanel.setLayout(VerCarreraPanelLayout);
        VerCarreraPanelLayout.setHorizontalGroup(
            VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerCarreraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
                    .addGroup(VerCarreraPanelLayout.createSequentialGroup()
                        .addGroup(VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreCarreraLabel)
                            .addGroup(VerCarreraPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(creditosCarrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TituloLabel25)
                            .addGroup(VerCarreraPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TituloLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(VerCarreraPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sedeCarreraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane21))
                .addContainerGap())
        );
        VerCarreraPanelLayout.setVerticalGroup(
            VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerCarreraPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(NombreCarreraLabel)
                .addGap(24, 24, 24)
                .addGroup(VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloLabel29)
                    .addComponent(sedeCarreraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloLabel15)
                    .addComponent(creditosCarrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TituloLabel27)
                    .addComponent(TituloLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TituloLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerCarreraPanel, "card17");

        PanelCabecera.setBackground(new java.awt.Color(255, 51, 51));

        notificacionIcono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        notificacionIcono.setForeground(new java.awt.Color(255, 0, 0));
        notificacionIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/notification.png"))); // NOI18N
        notificacionIcono.setToolTipText("Notifiaciones");
        notificacionIcono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificacionIconoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                notificacionIconoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                notificacionIconoMouseExited(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/perfil2.png"))); // NOI18N
        jLabel15.setToolTipText("Ver Perfil");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

        nombreUsrLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreUsrLabel.setForeground(new java.awt.Color(255, 255, 255));

        VolverButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VolverButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/volver.png"))); // NOI18N
        VolverButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        VolverButton.setContentAreaFilled(false);
        VolverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCabeceraLayout = new javax.swing.GroupLayout(PanelCabecera);
        PanelCabecera.setLayout(PanelCabeceraLayout);
        PanelCabeceraLayout.setHorizontalGroup(
            PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VolverButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombreUsrLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(notificacionIcono)
                .addGap(10, 10, 10))
        );
        PanelCabeceraLayout.setVerticalGroup(
            PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCabeceraLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCabeceraLayout.createSequentialGroup()
                        .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(notificacionIcono)
                            .addComponent(nombreUsrLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addComponent(VolverButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PanelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CursosOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CursosOpcionMouseClicked
        if (Fabrica.getInstance().getContEdu().getSede() != null) {
            opcionSeleccionada(CursosOpcion, "cursos");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede");
        }
    }//GEN-LAST:event_CursosOpcionMouseClicked

    private void SedesOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SedesOpcionMouseClicked
        if (Fabrica.getInstance().getContEdu().getSede() != null) {
            opcionSeleccionada(SedesOpcion, "sedes");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede");
        }
    }//GEN-LAST:event_SedesOpcionMouseClicked

    private void CarrerasOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarrerasOpcionMouseClicked
        if (Fabrica.getInstance().getContEdu().getSede() != null) {
            opcionSeleccionada(CarrerasOpcion, "carreras");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede");
        }
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
        if (BuscarTextField.getText().equals("Buscar por curso, carrera")) {
            BuscarTextField.setText("");
            BuscarTextField.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_BuscarTextFieldFocusGained

    private void BuscarTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarTextFieldFocusLost
        if (BuscarTextField.getText().isEmpty()) {
            BuscarTextField.setText("Buscar por curso, carrera");
            BuscarTextField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_BuscarTextFieldFocusLost

    private void VerCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerCursoButtonActionPerformed
        if (CursosTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un curso", "", WARNING_MESSAGE);
        } else {
            opcionSeleccionada(CursosOpcion, "verCurso");            
        }
    }//GEN-LAST:event_VerCursoButtonActionPerformed

    private void InscripcionCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscripcionCButtonActionPerformed
        if (CursosTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un curso", "", WARNING_MESSAGE);
        } else {
            DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();
            Curso curso = (Curso) modelo.getValueAt(CursosTable.getSelectedRow(), 0);

            IContEstudiante contEst = Fabrica.getInstance().getContEst();
            try {
                contEst.inscripcionCurso(curso);
                JOptionPane.showMessageDialog(this, "Se ha inscrito correctamente al curso");
            } catch (Exception ex) {
                Logger.getLogger(Estudiante_MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "", WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_InscripcionCButtonActionPerformed

    private void CursandoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CursandoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CursandoRadioButtonActionPerformed

    private void BuscarTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarTextFieldKeyReleased

    }//GEN-LAST:event_BuscarTextFieldKeyReleased

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        String buscar = BuscarTextField.getText();
        if (buscar.equals("Buscar por curso, carrera")) {
            buscar = "";
        }
        listarCursos(buscar);
    }//GEN-LAST:event_BuscarButtonActionPerformed

    private void BuscarSedeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarSedeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarSedeFocusGained

    private void BuscarSedeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarSedeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarSedeFocusLost

    private void BuscarSedeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarSedeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarSedeKeyReleased

    private void SeleccionarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarSedeActionPerformed
        int index = SedeTable.getSelectedRow();
        if (index != -1) {
            Sede s = (Sede) SedeTable.getModel().getValueAt(index, 0);
            System.out.println(s.toString());
            Fabrica.getInstance().getContEdu().seleccionSede(s.getId());
            opcionSeleccionada(CursosOpcion,"cursos");
            SedeSelec.setText("<html>Sede: " + s.getNombre() + "</html>");
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado una sede");
        }
    }//GEN-LAST:event_SeleccionarSedeActionPerformed

    private void BuscarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarSedeActionPerformed
        
    }//GEN-LAST:event_BuscarSedeActionPerformed

    private void btnBuscarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSedeActionPerformed
        this.listarSedes();
    }//GEN-LAST:event_btnBuscarSedeActionPerformed

    private void BuscarCarreraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarCarreraFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarCarreraFocusGained

    private void BuscarCarreraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarCarreraFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarCarreraFocusLost

    private void BuscarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarCarreraActionPerformed

    private void BuscarCarreraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarCarreraKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarCarreraKeyReleased

    private void VerCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerCarreraActionPerformed
        if (CarreraTable.getSelectedRow() != -1) {
            opcionSeleccionada(CarrerasOpcion, "verCarrera");
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado una carrera");
        }
    }//GEN-LAST:event_VerCarreraActionPerformed

    private void btnBuscarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCarreraActionPerformed
        this.listarCarreras();
    }//GEN-LAST:event_btnBuscarCarreraActionPerformed
    private void AprobadosRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AprobadosRadioButtonActionPerformed
        
    }//GEN-LAST:event_AprobadosRadioButtonActionPerformed

    private void TodosRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TodosRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            listarCursos("");
        }
    }//GEN-LAST:event_TodosRadioButtonItemStateChanged

    private void CursandoRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CursandoRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            listarCursos("");
        }
    }//GEN-LAST:event_CursandoRadioButtonItemStateChanged

    private void AprobadosRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AprobadosRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            listarCursos("");
        }
    }//GEN-LAST:event_AprobadosRadioButtonItemStateChanged

    private void NoticiasOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoticiasOpcionMouseClicked
        if (Fabrica.getInstance().getContEdu().getSede() != null) {
            opcionSeleccionada(NoticiasOpcion, "noticias");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede");
        }
    }//GEN-LAST:event_NoticiasOpcionMouseClicked

    private void ExamenesOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExamenesOpcionMouseClicked
        if (Fabrica.getInstance().getContEdu().getSede() != null) {
            opcionSeleccionada(ExamenesOpcion, "examenes");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede");
        }
    }//GEN-LAST:event_ExamenesOpcionMouseClicked

    private void ExamenesOpcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExamenesOpcionMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_ExamenesOpcionMouseEntered

    private void ExamenesOpcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExamenesOpcionMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_ExamenesOpcionMouseExited

    private void BuscarNoticiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarNoticiaFocusGained
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BuscarNoticiaFocusGained

    private void BuscarNoticiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarNoticiaFocusLost
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_BuscarNoticiaFocusLost

    private void BuscarNoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNoticiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarNoticiaActionPerformed

    private void BuscarNoticiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarNoticiaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarNoticiaKeyReleased

    private void SeleccionarNoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarNoticiaActionPerformed
        MostrarNoticia();
    }//GEN-LAST:event_SeleccionarNoticiaActionPerformed

    private void btnBuscarNoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNoticiaActionPerformed
        this.Noticias();
    }//GEN-LAST:event_btnBuscarNoticiaActionPerformed

    private void BuscarExamenTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarExamenTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarExamenTextFieldFocusGained

    private void BuscarExamenTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarExamenTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarExamenTextFieldFocusLost

    private void BuscarExamenTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarExamenTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarExamenTextFieldActionPerformed

    private void BuscarExamenTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarExamenTextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarExamenTextFieldKeyReleased

    private void SeleccionarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarExamenActionPerformed
        if (ExamenesTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un exámen", "", WARNING_MESSAGE);
        } else {
            opcionSeleccionada(ExamenesOpcion, "verExamen");
        }
    }//GEN-LAST:event_SeleccionarExamenActionPerformed

    private void btnBuscarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarExamenActionPerformed
        listarExamenes(BuscarExamenTextField.getText());
    }//GEN-LAST:event_btnBuscarExamenActionPerformed

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel15MouseExited

    private void notificacionIconoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificacionIconoMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_notificacionIconoMouseEntered

    private void notificacionIconoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificacionIconoMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_notificacionIconoMouseExited

    private void NoticiasOpcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoticiasOpcionMouseEntered
         setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_NoticiasOpcionMouseEntered

    private void NoticiasOpcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoticiasOpcionMouseExited
         setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_NoticiasOpcionMouseExited

    private void InscripcionExButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscripcionExButtonActionPerformed
        if (ExamenesTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un exámen", "", WARNING_MESSAGE);
        } else {
            DefaultTableModel modelo = (DefaultTableModel) ExamenesTable.getModel();
            Examen examen = (Examen) modelo.getValueAt(ExamenesTable.getSelectedRow(), 0);

            IContEstudiante contEst = Fabrica.getInstance().getContEst();
            try {
                contEst.inscripcionExamen(examen);
                JOptionPane.showMessageDialog(this, "Se ha inscrito correctamente al exámen");
            } catch (Exception ex) {
                Logger.getLogger(Estudiante_MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "", WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_InscripcionExButtonActionPerformed

    private void MisExmenesRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MisExmenesRadioButtonItemStateChanged
        JRadioButton radioB = (JRadioButton) evt.getSource();
        if(evt.getStateChange() == ItemEvent.SELECTED && radioB.isEnabled()){
            listarExamenes("");
        }
    }//GEN-LAST:event_MisExmenesRadioButtonItemStateChanged

    private void TodosExRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TodosExRadioButtonItemStateChanged
        JRadioButton radioB = (JRadioButton) evt.getSource();
        if(evt.getStateChange() == ItemEvent.SELECTED && radioB.isEnabled()){
            listarExamenes("");
        }
    }//GEN-LAST:event_TodosExRadioButtonItemStateChanged

    private void ParcialesOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParcialesOpcionMouseClicked
        if (Fabrica.getInstance().getContEdu().getSede() != null) {
            opcionSeleccionada(ParcialesOpcion, "parciales");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede");
        }
    }//GEN-LAST:event_ParcialesOpcionMouseClicked

    private void ParcialesOpcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParcialesOpcionMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_ParcialesOpcionMouseEntered

    private void ParcialesOpcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParcialesOpcionMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_ParcialesOpcionMouseExited

    private void BuscarExamenTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarExamenTextField1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarExamenTextField1FocusGained

    private void BuscarExamenTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarExamenTextField1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarExamenTextField1FocusLost

    private void BuscarExamenTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarExamenTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarExamenTextField1ActionPerformed

    private void BuscarExamenTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarExamenTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarExamenTextField1KeyReleased

    private void SeleccionarParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarParcialActionPerformed
        if (ParcialesTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un parcial", "Advertencia", WARNING_MESSAGE);
        } else {
            opcionSeleccionada(ParcialesOpcion, "verParcial");
        }
    }//GEN-LAST:event_SeleccionarParcialActionPerformed

    private void btnBuscarParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarParcialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarParcialActionPerformed

    private void TodosParRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TodosParRadioButtonItemStateChanged
        JRadioButton radioB = (JRadioButton) evt.getSource();
        if(evt.getStateChange() == ItemEvent.SELECTED && radioB.isEnabled()){
            listarParciales("");
        }
    }//GEN-LAST:event_TodosParRadioButtonItemStateChanged

    private void MisParcialesRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MisParcialesRadioButtonItemStateChanged
        JRadioButton radioB = (JRadioButton) evt.getSource();
        if(evt.getStateChange() == ItemEvent.SELECTED && radioB.isEnabled()){
            listarParciales("");
        }
    }//GEN-LAST:event_MisParcialesRadioButtonItemStateChanged

    private void VolverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverButtonActionPerformed
        // Si es mayor a 1 porque si solo tiene 1 es el panel actual, no tiene anterior
        if(volver.size() > 1){
            CardLayout cl = (CardLayout) (PanelPrincipal.getLayout());
            String ultimaVentana = (String) volver.get(volver.size()-2)[0]; //el 0 tiene el panel principal
            JPanel ultimaOpcion = (JPanel) volver.get(volver.size()-2)[1]; //el 1 el tiene panel lateral
            cl.show(PanelPrincipal, ultimaVentana); //la ultima ventana visitada es el anteultimo agregado, el ultimo es el actual
            resaltarOpcioneleccionada(ultimaOpcion);
            volver.remove(volver.size()-1); //borrar la ventana actual
        }
    }//GEN-LAST:event_VolverButtonActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        if (Fabrica.getInstance().getContEdu().getSede() != null) {
            opcionSeleccionada(null, "verPerfil");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede");
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void VerMaterialSubidoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerMaterialSubidoButtonActionPerformed
        opcionSeleccionada(CursosOpcion, "verMaterial");
    }//GEN-LAST:event_VerMaterialSubidoButtonActionPerformed

    private void MaterialesSubidosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaterialesSubidosTableMouseClicked
        int row = MaterialesSubidosTable.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) MaterialesSubidosTable.getModel();
        Material material = (Material) modelo.getValueAt(row, 0);
        DescMaterialTextArea.setText(material.getDescripcion());
    }//GEN-LAST:event_MaterialesSubidosTableMouseClicked

    private void MaterialesSubidosTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_MaterialesSubidosTablePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_MaterialesSubidosTablePropertyChange

    private void MaterialesSubidosTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MaterialesSubidosTableKeyReleased
        // Si presionó la tecla arriba o abajo
        if(evt.getKeyCode()== KeyEvent.VK_DOWN || evt.getKeyCode()== KeyEvent.VK_UP){
            int row = MaterialesSubidosTable.getSelectedRow();
            DefaultTableModel modelo = (DefaultTableModel) MaterialesSubidosTable.getModel();
            Material material = (Material) modelo.getValueAt(row, 0);
            DescMaterialTextArea.setText(material.getDescripcion());
        }
    }//GEN-LAST:event_MaterialesSubidosTableKeyReleased

    private void DescargarMaterialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescargarMaterialButtonActionPerformed
        if(MaterialesSubidosTable.getSelectedRow()>-1){
            Material material = (Material) MaterialesSubidosTable.getModel().getValueAt(MaterialesSubidosTable.getSelectedRow(), 0);
            if(material.getRutaArchivo() != null){
                JFileChooser elegirArchivo = new JFileChooser();
                elegirArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                elegirArchivo.setAcceptAllFileFilterUsed(false);
                elegirArchivo.setDialogTitle("Seleccionar carpeta");

                int a= elegirArchivo.showDialog(this, "Seleccionar"); // guarda la accion que se realiza en el filechooser

                if(a == JFileChooser.APPROVE_OPTION){ // la accion si se le da a abrir
                    //            File archivo = elegirarchivo.getSelectedFile(); // capturar el nombre y ruta
                    //            String RutaArchivo = archivo.getPath();
                    String carpetaDestino = elegirArchivo.getSelectedFile().toString();

                    if(Fabrica.getInstance().getContEdu().descargarMaterial(carpetaDestino, material)){
                        JOptionPane.showMessageDialog(this,"Se ha descargado el material correctamente","Descarga completa",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this,"Ha ocurrido un error al decargar el material, la descarga ha sido cancelada","Descarga cancelada",javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this,"El tema seleccionado no tiene archivo","Aviso",javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_DescargarMaterialButtonActionPerformed

    private void BuscarNotifiacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarNotifiacionFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarNotifiacionFocusGained

    private void BuscarNotifiacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarNotifiacionFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarNotifiacionFocusLost

    private void BuscarNotifiacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNotifiacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarNotifiacionActionPerformed

    private void BuscarNotifiacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarNotifiacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarNotifiacionKeyReleased

    private void VerNotificacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerNotificacionButtonActionPerformed
        if(NotificacionesTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una notificación", "Advertencia", WARNING_MESSAGE);
        }else{
            opcionSeleccionada(null, "verNotificacion");
        }
    }//GEN-LAST:event_VerNotificacionButtonActionPerformed

    private void btnBuscarNotificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNotificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarNotificacionActionPerformed

    private void notificacionIconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificacionIconoMouseClicked
        opcionSeleccionada(null, "notificaciones");
    }//GEN-LAST:event_notificacionIconoMouseClicked

    private void TodosRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodosRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TodosRadioButtonActionPerformed

    private void VerCursosPerfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerCursosPerfilButtonActionPerformed
        CursandoRadioButton.setEnabled(false); // es para evitar el evento ItemStateChange, sino lista dos veces
        CursandoRadioButton.setSelected(true);
        CursandoRadioButton.setEnabled(true);
        opcionSeleccionada(CursosOpcion, "cursos");
    }//GEN-LAST:event_VerCursosPerfilButtonActionPerformed

    private void VerExamenesPerfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerExamenesPerfilButtonActionPerformed
        MisExmenesRadioButton.setEnabled(false); // es para evitar el evento ItemStateChange, sino lista dos veces
        MisExmenesRadioButton.setSelected(true);
        MisExmenesRadioButton.setEnabled(true);
        opcionSeleccionada(ExamenesOpcion, "examenes");
        
    }//GEN-LAST:event_VerExamenesPerfilButtonActionPerformed

    private void VerParcialesPerfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerParcialesPerfilButtonActionPerformed
        MisParcialesRadioButton.setEnabled(false); // es para evitar el evento ItemStateChange, sino lista dos veces
        MisParcialesRadioButton.setSelected(true);
        MisParcialesRadioButton.setEnabled(true);
        opcionSeleccionada(ParcialesOpcion, "parciales");
    }//GEN-LAST:event_VerParcialesPerfilButtonActionPerformed

    private void enviarMailsCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_enviarMailsCheckBoxItemStateChanged
        JCheckBox checkB = (JCheckBox) evt.getSource();
        if(evt.getStateChange() == ItemEvent.SELECTED && checkB.isEnabled()){
            Fabrica.getInstance().getContEst().configEnviarMails(true);
        }else{
            Fabrica.getInstance().getContEst().configEnviarMails(false);
        }

    }//GEN-LAST:event_enviarMailsCheckBoxItemStateChanged

    private void InscripcionCButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscripcionCButton1ActionPerformed
        if (CursosTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un curso", "Advertencia", WARNING_MESSAGE);
        } else {
            opcionSeleccionada(CursosOpcion, "estadisticasCurso");            
        }
    }//GEN-LAST:event_InscripcionCButton1ActionPerformed

    private void EnTodasCursoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnTodasCursoRadioButtonActionPerformed

    }//GEN-LAST:event_EnTodasCursoRadioButtonActionPerformed

    private void btnEstadCarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadCarrActionPerformed
        if (CarreraTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una carrera", "Advertencia", WARNING_MESSAGE);
        } else {
            opcionSeleccionada(CarrerasOpcion, "estadisticasCarrera");            
        }
    }//GEN-LAST:event_btnEstadCarrActionPerformed

    private void EnSelecCursoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnSelecCursoRadioButtonActionPerformed
        
    }//GEN-LAST:event_EnSelecCursoRadioButtonActionPerformed

    private void EnSedeSelecRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnSedeSelecRadioButtonActionPerformed
        
    }//GEN-LAST:event_EnSedeSelecRadioButtonActionPerformed

    private void EstadisticasOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstadisticasOpcionMouseClicked
        if (Fabrica.getInstance().getContEdu().getSede() != null) {
            opcionSeleccionada(EstadisticasOpcion, "estadisticas");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede");
        }
    }//GEN-LAST:event_EstadisticasOpcionMouseClicked

    private void EstadisticasOpcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstadisticasOpcionMouseEntered
         setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_EstadisticasOpcionMouseEntered

    private void EstadisticasOpcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstadisticasOpcionMouseExited
         setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_EstadisticasOpcionMouseExited

    private void EnSedeCarrRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnSedeCarrRadioButtonActionPerformed
        
    }//GEN-LAST:event_EnSedeCarrRadioButtonActionPerformed

    private void EnTodasCarrRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnTodasCarrRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnTodasCarrRadioButtonActionPerformed

    private void EnSedeSelecRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EnSedeSelecRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            opcionSeleccionada(EstadisticasOpcion, "estadisticas");
        }
    }//GEN-LAST:event_EnSedeSelecRadioButtonItemStateChanged

    private void EnTodasSedesRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EnTodasSedesRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            opcionSeleccionada(EstadisticasOpcion, "estadisticas");
        }
    }//GEN-LAST:event_EnTodasSedesRadioButtonItemStateChanged

    private void EnSedeCarrRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EnSedeCarrRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            opcionSeleccionada(CarrerasOpcion, "estadisticasCarrera");
        }
    }//GEN-LAST:event_EnSedeCarrRadioButtonItemStateChanged

    private void EnTodasCarrRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EnTodasCarrRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            opcionSeleccionada(CarrerasOpcion, "estadisticasCarrera");
        }
    }//GEN-LAST:event_EnTodasCarrRadioButtonItemStateChanged

    private void EnSelecCursoRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EnSelecCursoRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            opcionSeleccionada(CursosOpcion, "estadisticasCurso");
        }
    }//GEN-LAST:event_EnSelecCursoRadioButtonItemStateChanged

    private void EnTodasCursoRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EnTodasCursoRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            opcionSeleccionada(CursosOpcion, "estadisticasCurso");
        }
    }//GEN-LAST:event_EnTodasCursoRadioButtonItemStateChanged

    //opcionSelec = panel lateral seleccionado a cambiar de color, si es null es un panel del principal
    void opcionSeleccionada(JPanel opcionSelec, String opcion) {
        CardLayout cl = (CardLayout) (PanelPrincipal.getLayout());
        
        resaltarOpcioneleccionada(opcionSelec);
        
        boolean control = true;
        switch (opcion) {
            case "cursos":
                //Por defecto listar todos
                TodosRadioButton.setSelected(true);

                DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();
                while (modelo.getRowCount() > 0) {
                    modelo.removeRow(0);//limpiar la tabla
                }
                
                //Por defecto que se vea asi
                BuscarTextField.setText("Buscar por curso, carrera");
                BuscarTextField.setForeground(Color.GRAY);
                CursosTable.requestFocus();

                listarCursos("");
                this.setTitle("Menú: Cursos");
                break;
            case "carreras":
                this.listarCarreras();
                this.setTitle("Menú: Carreras");
                break;
            case "sedes":
                this.listarSedes();
                this.setTitle("Menú: Sedes");
                break;
            case "noticias":
                this.Noticias();
                this.setTitle("Menú: Noticias");
                break;
            case "ver noticia":
                this.setTitle("Menú: Noticias");
                break;
            case "examenes":
                this.listarExamenes("");
                this.setTitle("Menú: Exámenes");
                break;
            case "parciales":
                this.listarParciales("");
                this.setTitle("Menú: Parciales");
                break;
            case "verExamen":
                modelo = (DefaultTableModel) ExamenesTable.getModel();
                Examen examen = (Examen) modelo.getValueAt(ExamenesTable.getSelectedRow(), 0);
                CurExamenLabel.setText(examen.getCurso().getCurso().getNombre());
                
                InscripcionE insEx = Fabrica.getInstance().getContEst().getInscripcionExamen(examen);
                if(insEx == null){
                    JOptionPane.showMessageDialog(this, "No está inscrito a este exámen", "", WARNING_MESSAGE);
                    control = false;
                }else{
                    FechaInscLabel.setText(dateFormat.format(insEx.getFecha()));
                    
                    if(insEx.getNota() != null){
                        NotaLabel.setText(String.valueOf(insEx.getNota().getNota()));
                        fechaNotaLabel.setText(dateFormat.format(insEx.getNota().getFecha()));
                    }
                    
                    this.setTitle("Menú: Ver Exámen");
                }
                break;
            case "verParcial":
                modelo = (DefaultTableModel) ParcialesTable.getModel();
                Parcial parcial = (Parcial) modelo.getValueAt(ParcialesTable.getSelectedRow(), 0);
                ResultadoP rp = parcial.getNotaEstudiante(Fabrica.getInstance().getContEst().getLogin());
                if(rp != null){                
                    CurParcialLabel.setText(parcial.getCurso().getCurso().getNombre());
                    InstanciaLabel.setText(String.valueOf(parcial.getInstancia()));
                    FechaParcialLabel.setText(dateFormat.format(parcial.getFecha()));
                    NotaPLabel.setText(String.valueOf(rp.getNota()));
                    fechaNotaPLabel.setText(dateFormat.format(rp.getFecha()));
                    this.setTitle("Menú: Ver Parcial");                        
                }else{
                    JOptionPane.showMessageDialog(this, "No hay datos de resultado de este parcial para ti", "", WARNING_MESSAGE);
                    control = false;                        
                }
                    
                break;
            case "verCurso":    
                modelo = (DefaultTableModel) CursosTable.getModel();
                Curso curso = (Curso) modelo.getValueAt(CursosTable.getSelectedRow(), 0);
                String opt = "No";
                if (curso.isOptativo()) {
                    opt = "Si";
                }
                modelo = (DefaultTableModel) PreviasCurTable.getModel();
                while (modelo.getRowCount() > 0) {
                    modelo.removeRow(0);//limpiar la tabla
                }
                if(curso.getPrevias() != null && !curso.getPrevias().isEmpty()){
                    for(Previa p : curso.getPrevias()){
                        String aprobacion = "Con derecho a examen";
                        if(p.isExamenAprobado()) aprobacion = "Curso Aprobado";
                        Object[] row = {p.getCursoPrevia().getNombre(), aprobacion};
                        modelo.addRow(row);
                    }
                }
                notaAprobCurLabel.setText(String.valueOf(Fabrica.getInstance().getContEdu().getSede().getCurso(curso).getAproParciales()));
                notaExonExLabel.setText(String.valueOf(Fabrica.getInstance().getContEdu().getSede().getCurso(curso).getDerechoExamen()));
                TituloLabel.setText(curso.getNombre());
                CreditosLabel.setText(String.valueOf(curso.getCreditos()));
                OptativoLabel.setText(opt);
                HorariosTextArea.setText(curso.getHorarios());
                DescTextArea.setText(curso.getDescripcion());
                this.setTitle("Menú: Ver Curso");
                break;
            case "verPerfil":
                Estudiante est = Fabrica.getInstance().getContEst().getLogin();
                nombreEstLabel.setText(est.getNombres()+" "+est.getApellidos());
                idEstLabel.setText(est.getId());
                fechaNacLabel.setText(dateFormat.format(est.getFechaNac()));
                ciEstLabel.setText(est.getCi());
                emailEstLabel.setText(est.getEmail());      
                
                enviarMailsCheckBox.setEnabled(false); //es para evitar el evento ItemStateChanged
                enviarMailsCheckBox.setSelected(est.isEnviarMails()); 
                enviarMailsCheckBox.setEnabled(true);
                
                this.setTitle("Menú: Ver Perfil");
                break;
            case "verMaterial":  
                listarMateriales();
                this.setTitle("Menú: Material del curso");
                break;
            case "notificaciones":  
                List<Notificacion> notificaciones = Fabrica.getInstance().getContEst().getLogin().getNotificaciones();
                DefaultTableModel modeloNotif = (DefaultTableModel) NotificacionesTable.getModel();

                while (modeloNotif.getRowCount() > 0) {
                    modeloNotif.removeRow(0);
                }

                if (notificaciones.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No tienes notificaciones");
                } else {
                    for (Notificacion notif : notificaciones) {
                        Object[] datos = {notif, notif.getTitulo(), dateFormat.format(notif.getFecha()), notif.isVista()};
                        modeloNotif.addRow(datos);
                    }
                }
                
                this.setTitle("Menú: Notificaciones");
                break;
            case "verNotificacion":
                Notificacion notificacion = (Notificacion) NotificacionesTable.getModel().getValueAt(NotificacionesTable.getSelectedRow(), 0);
                tituloVerNotificacion.setText(notificacion.getTitulo());
                textoVerNotificacion.setText(notificacion.getTexto());
                fechaVerNotificacion.setText(dateFormat.format(notificacion.getFecha()));
                Fabrica.getInstance().getContEst().notificacionVista(notificacion);
                setCantidadNotif();
                this.setTitle("Menú: Ver Notificación");
                break;
            case "estadisticasCurso":
                control = false; //se muestra despues desde la funcion cargarEstadisticas()
                cargarEstadisticas("estadisticasCurso");
                this.setTitle("Menú: Estadísticas Curso");
                break;
            case "estadisticasCarrera":
                control = false; //se muestra despues desde la funcion cargarEstadisticas()
                cargarEstadisticas("estadisticasCarrera");
                this.setTitle("Menú: Estadísticas Carrera");
                break;
            case "estadisticas":
                control = false; //se muestra despues desde la funcion cargarEstadisticas()
                cargarEstadisticas("estadisticas");
                this.setTitle("Menú: Estadísticas Sede");
                break;
            case "verCarrera":
                modelo = (DefaultTableModel) CarreraTable.getModel();
                Carrera carrera = (Carrera) modelo.getValueAt(CarreraTable.getSelectedRow(), 0);
                
                sedeCarreraLabel.setText(Fabrica.getInstance().getContEdu().getSede().getNombre());
                NombreCarreraLabel.setText(carrera.getNombre());
                creditosCarrLabel.setText(String.valueOf(carrera.getCreditos()));
                descCarreraTextArea.setText(carrera.getDescripcion());
                
                DefaultTableModel modeloCursos = (DefaultTableModel) CursosCarreraTable.getModel();
                modeloCursos.setRowCount(0);
                for (Curso c : carrera.getCursos()) {
                    String optativo = "No";
                    if(c.isOptativo()){
                       optativo = "Si";
                    }
                    Object[] datos = {c, c.getNombre(), c.getCreditos(), optativo};
                    modeloCursos.addRow(datos);
                }                
                resizeColumnWidth(CursosCarreraTable);
                
                this.setTitle("Menú: Ver Carrera");
                break;
        }
        
        if(control){
            cl.show(PanelPrincipal, opcion);
            Object[] v = {opcion, opcionSelec};
            volver.add(v);
        }
    }
    
    public void resaltarOpcioneleccionada(JPanel opcionSelec){
        for (JPanel opcionAux : opciones) {
            // si viene null no queda inguna resaltada
            if(opcionSelec == null){
                opcionAux.setBackground(Color.decode("#1d8348"));
            }else{
                if(opcionAux.equals(opcionSelec)){
                    opcionAux.setBackground(Color.decode("#4a9f6e"));
                }else{
                    opcionAux.setBackground(Color.decode("#1d8348"));
                }
            }
        }
    }

    public void listarCursos(String buscar) {

        IContEducacion contEdu = Fabrica.getInstance().getContEdu();
        List<Curso> lista = new ArrayList<>();
        
        if(TodosRadioButton.isSelected()){
            lista = contEdu.listarCursos(buscar); // parametro de busqueda, si es vacia lista todo
        }else{
            if(CursandoRadioButton.isSelected()){
                    lista = contEdu.listarCursosCursando(buscar); // parametro de busqueda, si es vacia lista todo
            }else{
                lista = contEdu.listarCursosAprobados(buscar); // parametro de busqueda, si es vacia lista todo
            }
        }        
        
        DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Curso curso : lista) {
                String esOptativo = "No";
                if (curso.isOptativo()) {
                    esOptativo = "Si";
                }
                Object[] datos = {curso, curso.getNombre(), String.valueOf(curso.getCreditos()), esOptativo, curso.getCarrera().getNombre()};
                modelo.addRow(datos);
            }
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
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void listarSedes() {
        List<Sede> sedes;
        if (this.BuscarSede.getText().equals("")) {
            sedes = Fabrica.getInstance().getContEdu().listarSedes();
        } else {
            sedes = Fabrica.getInstance().getContEdu().listarSedes(this.BuscarSede.getText());
        }
        DefaultTableModel modelo = (DefaultTableModel) SedeTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (sedes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Sede s : sedes) {
                Object[] datos = {s, s.getNombre(), s.getTelefono(), s.getDireccion()};
                modelo.addRow(datos);
            }
        }
    }
    
    private void listarNoticias() {
        List<Noticia> noticias;
        if (this.BuscarNoticia.getText().equals("")) {
            noticias = Fabrica.getInstance().getContAdmin().listarNoticias("");
        } else {
            noticias = Fabrica.getInstance().getContAdmin().listarNoticias(this.BuscarNoticia.getText());
        }
        DefaultTableModel modelo = (DefaultTableModel) NoticiasTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (noticias.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Noticia n : noticias) {
                Object[] datos = {n, n.getTitulo(), dateFormat.format(n.getFecha())};
                modelo.addRow(datos);
            }
        }
    }

    private void listarCarreras() {
        List<Carrera> carreras;
        if (this.BuscarCarrera.getText().equals("")) {
            carreras = Fabrica.getInstance().getContEdu().listarCarrerasSede();
        } else {
            carreras = Fabrica.getInstance().getContEdu().listarCarrerasSede(this.BuscarCarrera.getText());
        }
        DefaultTableModel modelo = (DefaultTableModel) CarreraTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (carreras.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Carrera c : carreras) {
                Object[] datos = {c, c.getNombre(), c.getCreditos()};
                modelo.addRow(datos);
            }
        }
    }

    private void listarExamenes(String buscar) {
        List<Examen> examenes;
        
        if(TodosExRadioButton.isSelected()){
            examenes = Fabrica.getInstance().getContEdu().listarExamenes(buscar);
        }else{
            examenes = Fabrica.getInstance().getContEdu().listarExamenesEst(buscar);
        }
        
        DefaultTableModel modelo = (DefaultTableModel) ExamenesTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (examenes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Examen e : examenes) {
                String nombreCurso = e.getCurso().getCurso().getNombre();
                if(e.getFechaMuestra() == null){
                    Object[] datos = {e, nombreCurso, dateFormat.format(e.getFecha()), dateFormat.format(e.getInicioInsripcion()), dateFormat.format(e.getFinInsripcion()), "No disponible aún"};
                    modelo.addRow(datos);
                }else{
                    Object[] datos = {e, nombreCurso, dateFormat.format(e.getFecha()), dateFormat.format(e.getInicioInsripcion()), dateFormat.format(e.getFinInsripcion()), dateFormat.format(e.getFechaMuestra())};
                    modelo.addRow(datos);
                }
            }
        }
    }
    
    private void listarParciales(String buscar) {
        List<Parcial> parciales;
        
        if(TodosParRadioButton.isSelected()){
            parciales = Fabrica.getInstance().getContEdu().listarParciales(buscar);
        }else{
            parciales = Fabrica.getInstance().getContEdu().listarParcialesEst(buscar);
        }
        
        DefaultTableModel modelo = (DefaultTableModel) ParcialesTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (parciales.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Parcial p : parciales) {
                String nombreCurso = p.getCurso().getCurso().getNombre();
                Object[] datos = {p, nombreCurso, dateFormat.format(p.getFecha()), p.getInstancia()};
                modelo.addRow(datos);
            }
        }
    }
    
    private void Noticias() {
        List<Noticia> noticias; 
        
        if(BuscarNoticia.getText().equals("")){
            noticias = Fabrica.getInstance().getContEdu().listarNoticias();
        }else{
            noticias = Fabrica.getInstance().getContEdu().listarNoticias(BuscarNoticia.getText());
        }
        
        DefaultTableModel modelo = (DefaultTableModel) NoticiasTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (noticias.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Noticia n: noticias) {
                Object[] datos = {n, n.getTitulo(), dateFormat.format(n.getFecha())};
                modelo.addRow(datos);
            }
        }
    }
    
    private void MostrarNoticia(){
        int index = NoticiasTable.getSelectedRow();
        if(index != -1){
            Noticia n = (Noticia) NoticiasTable.getModel().getValueAt(index, 0);
            verNoticia_titulo.setText(n.getTitulo());
            verNoticia_fecha.setText(dateFormat.format(n.getFecha()));
            verNoticia_texto.setText(n.getTexto());
            DefaultListModel model = new DefaultListModel();
            for(String etiqueta : n.getEtiquetas()){
                model.addElement(etiqueta);
            }
            verNoticia_etiquetas.setModel(model);
            opcionSeleccionada(NoticiasPanel, "ver noticia");
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar una noticia", "Error", WARNING_MESSAGE);
        }
    }
    
    public void listarMateriales() {
        DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();
        Curso curso = (Curso) modelo.getValueAt(CursosTable.getSelectedRow(), 0);
        
        List<Material> lista = Fabrica.getInstance().getContEdu().listarMaterialCurso(curso);
        
        modelo = (DefaultTableModel) MaterialesSubidosTable.getModel();
        
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        DescMaterialTextArea.setText("");
        tituloMateriales.setText("");

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Material material : lista) {
                tituloMateriales.setText("Material subido para "+curso.getNombre());
                String nombreDocente = material.getDocente().getNombres()+" "+material.getDocente().getApellidos();
                Object[] datos = {material, material.getTitulo(), dateFormat.format(material.getFechaSubida()), nombreDocente};
                modelo.addRow(datos);
            }
        }

        resizeColumnWidth(MaterialesSubidosTable);
    }
    
    public void setCantidadNotif(){
        int cant = Fabrica.getInstance().getContEst().getLogin().cantNotifNoVista();
        notificacionIcono.removeAll();
        notificacionIcono.revalidate();
        notificacionIcono.repaint();
        if(cant > 0){
            notificacionIcono.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel text = new JLabel(String.valueOf(cant));
            text.setForeground(Color.red);
            text.setFont(new Font("Dialog", Font.BOLD, 13));
            notificacionIcono.add(text);
        }
    }
    
    public void cargarEstadisticas(String tipo){
        new SwingWorker<Object[], Void>(){
            @Override
            protected Object[] doInBackground() throws Exception {
                System.out.println(".doInBackground() "+tipo);
                switch(tipo){
                    case "estadisticasCurso":
                        Curso curso = (Curso) CursosTable.getModel().getValueAt(CursosTable.getSelectedRow(), 0);
                        boolean enTodas = EnTodasCursoRadioButton.isSelected();
                        double promExamenes = Fabrica.getInstance().getContEstad().promedioExamenesCurso(enTodas, curso);
                        double promParciales = Fabrica.getInstance().getContEstad().promedioParcialesCurso(enTodas, curso);
                        double promAprobacion = Fabrica.getInstance().getContEstad().promedioAprobacionCurso(enTodas, curso);
                        
                        Object[] promedios = {promExamenes, promParciales, promAprobacion};
                        return promedios;
                    case "estadisticasCarrera":
                        Carrera carrera = (Carrera) CarreraTable.getModel().getValueAt(CarreraTable.getSelectedRow(), 0);
                        boolean enTodasCarr = EnTodasCarrRadioButton.isSelected();
                        
                        double promExamenesCarr = Fabrica.getInstance().getContEstad().promedioExamenesCarrera(enTodasCarr, carrera);
                        double promParcialesCarr = Fabrica.getInstance().getContEstad().promedioParcialesCarrera(enTodasCarr, carrera);
                        double promAprobacionCarr = Fabrica.getInstance().getContEstad().promedioAprobacionCarrera(enTodasCarr, carrera);
                        Object[] cursoConMasEstCarr = Fabrica.getInstance().getContEstad().cursoConMasEstudiantesCursandoCarrera(enTodasCarr, carrera);
                        Object[] cursoConMasApCarr =  Fabrica.getInstance().getContEstad().cursoConMasAprobacionesCarrera(enTodasCarr, carrera);
                        Object[] cursoConMejorPromApCarr =  Fabrica.getInstance().getContEstad().cursoConMejorPrmedioAprobacionCarrera(enTodasCarr, carrera);
                        Object[] promediosCarr = {promExamenesCarr, promParcialesCarr, promAprobacionCarr, cursoConMasEstCarr, cursoConMasApCarr, cursoConMejorPromApCarr};
                        return promediosCarr;                        
                    case "estadisticas":
                        boolean enTodasSede = EnTodasSedesRadioButton.isSelected();
                        
                        double promExamenesSede = Fabrica.getInstance().getContEstad().promedioExamenesSede(enTodasSede);
                        double promParcialesSede = Fabrica.getInstance().getContEstad().promedioParcialesSede(enTodasSede);
                        double promApCursosSede = Fabrica.getInstance().getContEstad().promedioAprobacionCursoSede(enTodasSede);
                        double promApCarrerasSede = Fabrica.getInstance().getContEstad().promedioAprobacionCarreraSede(enTodasSede);
                        Object[] cursoConMasEstSede = Fabrica.getInstance().getContEstad().cursoConMasEstudiantesCursandoSede(enTodasSede);
                        Object[] cursoConMasApSede =  Fabrica.getInstance().getContEstad().cursoConMasAprobacionesCarreraSede(enTodasSede);
                        Object[] cursoConMejorPromApSede =  Fabrica.getInstance().getContEstad().cursoConMejorPrmedioAprobacionCarreraSede(enTodasSede);
                        Object[] carreraConMasEstCurs = Fabrica.getInstance().getContEstad().carreraConMasEstudiantesCursandoSede( enTodasSede);
                        Object[] carreraConMasApSede = Fabrica.getInstance().getContEstad().carreraConMasAprobacionesSede(enTodasSede);
                        Object[] carreraConMejorPromApSede = Fabrica.getInstance().getContEstad().carreraConMejorPrmedioAprobacionSede(enTodasSede);
                        Object[] promediosSede = {promExamenesSede, promParcialesSede, promApCursosSede, promApCarrerasSede, cursoConMasEstSede, cursoConMasApSede, cursoConMejorPromApSede, carreraConMasEstCurs, carreraConMasApSede, carreraConMejorPromApSede};
                        return promediosSede;
                }
                
                return null;
            }

            @Override
            protected void done(){
                try{
                    Object[] promedios = get(); // asi se obtiene lo que retorna el doInBackground
                    if(promedios!=null){
                        switch(tipo){
                            case "estadisticasCurso":
                                estadisticasCurso(promedios);
                                break;
                            case "estadisticasCarrera":
                                estadisticasCarrera(promedios);
                                break;
                            case "estadisticas":
                                estadisticasSede(promedios);
                                break;
                        }
                        mostrarCargando(false, tipo);   
                    }   
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
        mostrarCargando(true, null);  
    }
    
    public void estadisticasCurso(Object[] promedios){
        Curso curso = (Curso) CursosTable.getModel().getValueAt(CursosTable.getSelectedRow(), 0);
        TituloEstadisticasCurso.setText("Estadísticas para el curso "+curso.getNombre()+" - "+curso.getCarrera().getNombre());
        DecimalFormat df = new DecimalFormat("#.##");
        
        if((double)promedios[0] > -1){
            promNotaExCurso.setText(df.format((double)promedios[0]));
        }else{
            promNotaExCurso.setText("No hay datos disponibles");
        }
        
        if((double)promedios[1] > -1){
            promNotaParCurso.setText(df.format((double)promedios[1]));
        }else{
            promNotaParCurso.setText("No hay datos disponibles");
        }
        
        if((double)promedios[2] > -1){
            promAprobCurso.setText(df.format((double)promedios[2])+"%");
        }else{
            promAprobCurso.setText("No hay datos disponibles");
        }
        
        String panelMostrar = "estadisticasCurso";
        CardLayout cl = (CardLayout) (PanelPrincipal.getLayout());
        cl.show(PanelPrincipal, panelMostrar);
        Object[] v = {panelMostrar, CursosOpcion};
        volver.add(v);
    }
    
    public void estadisticasCarrera(Object[] promedios){
        Carrera carrera = (Carrera) CarreraTable.getModel().getValueAt(CarreraTable.getSelectedRow(), 0);
        TituloEstadisticasCarrera.setText("Estadísticas para la carrera "+carrera.getNombre());
        DecimalFormat df = new DecimalFormat("#.##");
        
        if((double)promedios[0] > -1){
            promNotaExCarr.setText(df.format((double)promedios[0]));
        }else{
            promNotaExCarr.setText("No hay datos disponibles");
        }
        
        if((double)promedios[1] > -1){
            promNotaParCarr.setText(df.format((double)promedios[1]));
        }else{
            promNotaParCarr.setText("No hay datos disponibles");
        }
        
        if((double)promedios[2] > -1){
            promApCarr.setText(df.format((double)promedios[2])+"%");
        }else{
            promApCarr.setText("No hay datos disponibles");
        }
        
        Object[] cursoAux = (Object[]) promedios[3]; // curso y cantidad
        if(cursoAux[0] != null){
            Curso curso = (Curso) cursoAux[0];
            conMasEstCarr.setText(curso.getNombre()+": "+String.valueOf((int)cursoAux[1]));
        }else{
            conMasEstCarr.setText("No hay datos disponibles");
        }
        
        cursoAux = (Object[]) promedios[4]; // curso y cantidad
        if(cursoAux[0] != null){
            Curso curso = (Curso) cursoAux[0];
            conMasApCarr.setText(curso.getNombre()+": "+String.valueOf((int)cursoAux[1]));
        }else{
            conMasApCarr.setText("No hay datos disponibles");
        }
        
        cursoAux = (Object[]) promedios[5]; // curso y cantidad
        if(cursoAux[0] != null){
            Curso curso = (Curso) cursoAux[0];
            conMejorPromApCarr.setText(curso.getNombre()+": "+df.format((double)cursoAux[1])+"%");
        }else{
            conMejorPromApCarr.setText("No hay datos disponibles");
        }
        
        String panelMostrar = "estadisticasCarrera";
        CardLayout cl = (CardLayout) (PanelPrincipal.getLayout());
        cl.show(PanelPrincipal, panelMostrar);
        Object[] v = {panelMostrar, CarrerasOpcion};
        volver.add(v);
    }
    
    public void estadisticasSede(Object[] promedios){
        Sede sede = Fabrica.getInstance().getContEdu().getSede();
        TituloEstadisticasSede.setText("Estadísticas para la sede "+sede.getNombre());
        DecimalFormat df = new DecimalFormat("#.##");
                        
        if((double)promedios[0] > -1){
            promNotaExSede.setText(df.format((double)promedios[0]));
        }else{
            promNotaExSede.setText("No hay datos disponibles");
        }
        
        if((double)promedios[1] > -1){
            promNotaParSede.setText(df.format((double)promedios[1]));
        }else{
            promNotaParSede.setText("No hay datos disponibles");
        }
        
        if((double)promedios[2] > -1){
            promApCursosSede.setText(df.format((double)promedios[2])+"%");
        }else{
            promApCursosSede.setText("No hay datos disponibles");
        }
        
        if((double)promedios[3] > -1){
            promApCarrSede.setText(df.format((double)promedios[3])+"%");
        }else{
            promApCarrSede.setText("No hay datos disponibles");
        }
        
        Object[] cursoAux = (Object[]) promedios[4]; // curso y cantidad
        if(cursoAux[0] != null){
            Curso curso = (Curso) cursoAux[0];
            cursoConMasEstSede.setText(curso.getNombre()+": "+String.valueOf((int)cursoAux[1]));
        }else{
            cursoConMasEstSede.setText("No hay datos disponibles");
        }
        
        cursoAux = (Object[]) promedios[5]; // curso y cantidad
        if(cursoAux[0] != null){
            Curso curso = (Curso) cursoAux[0];
            cursoConMasApSede.setText(curso.getNombre()+": "+String.valueOf((int)cursoAux[1]));
        }else{
            cursoConMasApSede.setText("No hay datos disponibles");
        }
        
        cursoAux = (Object[]) promedios[6]; // curso y cantidad
        if(cursoAux[0] != null){
            Curso curso = (Curso) cursoAux[0];
            cursoConMejorPromApSede.setText(curso.getNombre()+": "+df.format((double)cursoAux[1])+"%");
        }else{
            cursoConMejorPromApSede.setText("No hay datos disponibles");
        }
        
        cursoAux = (Object[]) promedios[7]; // curso y cantidad
        if(cursoAux[0] != null){
            Carrera carrera = (Carrera) cursoAux[0];
            carrConMasEstSede.setText(carrera.getNombre()+": "+String.valueOf((int)cursoAux[1]));
        }else{
            carrConMasEstSede.setText("No hay datos disponibles");
        }
        
        cursoAux = (Object[]) promedios[8]; // curso y cantidad
        if(cursoAux[0] != null){
            Carrera carrera = (Carrera) cursoAux[0];
            carrConMasApSede.setText(carrera.getNombre()+": "+String.valueOf((int)cursoAux[1]));
        }else{
            carrConMasApSede.setText("No hay datos disponibles");
        }
        
        cursoAux = (Object[]) promedios[9]; // curso y cantidad
        if(cursoAux[0] != null){
            Carrera carrera = (Carrera) cursoAux[0];
            carrConMejorPromApSede.setText(carrera.getNombre()+": "+df.format((double)cursoAux[1])+"%");
        }else{
            carrConMejorPromApSede.setText("No hay datos disponibles");
        }
        
        String panelMostrar = "estadisticas";
        CardLayout cl = (CardLayout) (PanelPrincipal.getLayout());
        cl.show(PanelPrincipal, panelMostrar);
        Object[] v = {panelMostrar, CarrerasOpcion};
        volver.add(v);
    }
    
    public void mostrarCargando(boolean mostrar, String panelMostar){
        CardLayout cl = (CardLayout) (PanelPrincipal.getLayout());
        if(mostrar){
            cl.show(PanelPrincipal, "cargando");
        }else{
            cl.show(PanelPrincipal, panelMostar);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AprobadosRadioButton;
    private javax.swing.JLabel AuxLabel;
    private javax.swing.JLabel AuxLabel1;
    private javax.swing.JLabel AuxLabel2;
    private javax.swing.JLabel AuxLabel3;
    private javax.swing.JLabel AuxLabel4;
    private javax.swing.JButton BuscarButton;
    private javax.swing.JTextField BuscarCarrera;
    private javax.swing.JTextField BuscarExamenTextField;
    private javax.swing.JTextField BuscarExamenTextField1;
    private javax.swing.JTextField BuscarNoticia;
    private javax.swing.JTextField BuscarNotifiacion;
    private javax.swing.JTextField BuscarSede;
    private javax.swing.JTextField BuscarTextField;
    private javax.swing.JPanel CargandoPanel;
    private javax.swing.JTable CarreraTable;
    private javax.swing.JPanel CarrerasOpcion;
    private javax.swing.JPanel CarrerasPanel;
    private javax.swing.JLabel CreditosLabel;
    private javax.swing.JLabel CurExamenLabel;
    private javax.swing.JLabel CurParcialLabel;
    private javax.swing.JRadioButton CursandoRadioButton;
    private javax.swing.JTable CursosCarreraTable;
    private javax.swing.JPanel CursosOpcion;
    private javax.swing.JPanel CursosPanel;
    private javax.swing.JTable CursosTable;
    private javax.swing.JTextArea DescMaterialTextArea;
    private javax.swing.JTextArea DescTextArea;
    private javax.swing.JButton DescargarMaterialButton;
    private javax.swing.JRadioButton EnSedeCarrRadioButton;
    private javax.swing.JRadioButton EnSedeSelecRadioButton;
    private javax.swing.JRadioButton EnSelecCursoRadioButton;
    private javax.swing.JRadioButton EnTodasCarrRadioButton;
    private javax.swing.JRadioButton EnTodasCursoRadioButton;
    private javax.swing.JRadioButton EnTodasSedesRadioButton;
    private javax.swing.JPanel EstadisticasCarreraPanel;
    private javax.swing.JPanel EstadisticasCursoPanel;
    private javax.swing.JPanel EstadisticasOpcion;
    private javax.swing.JPanel EstadisticasPanel;
    private javax.swing.JPanel ExamenesOpcion;
    private javax.swing.JPanel ExamenesPanel;
    private javax.swing.JTable ExamenesTable;
    private javax.swing.JLabel FechaInscLabel;
    private javax.swing.JLabel FechaParcialLabel;
    private javax.swing.JTextArea HorariosTextArea;
    private javax.swing.JButton InscripcionCButton;
    private javax.swing.JButton InscripcionCButton1;
    private javax.swing.JButton InscripcionExButton;
    private javax.swing.JLabel InstanciaLabel;
    private javax.swing.JPanel MaterialesSubidosPanel;
    private javax.swing.JTable MaterialesSubidosTable;
    private javax.swing.JRadioButton MisExmenesRadioButton;
    private javax.swing.JRadioButton MisParcialesRadioButton;
    private javax.swing.JLabel NombreCarreraLabel;
    private javax.swing.JLabel NotaLabel;
    private javax.swing.JLabel NotaPLabel;
    private javax.swing.JPanel NoticiasOpcion;
    private javax.swing.JPanel NoticiasPanel;
    private javax.swing.JTable NoticiasTable;
    private javax.swing.JPanel NotificacionesPanel;
    private javax.swing.JTable NotificacionesTable;
    private javax.swing.JLabel OptativoLabel;
    private javax.swing.JPanel PanelCabecera;
    private javax.swing.JPanel PanelLateral;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel ParcialesOpcion;
    private javax.swing.JPanel ParcialesPanel;
    private javax.swing.JTable ParcialesTable;
    private javax.swing.JTable PreviasCurTable;
    private javax.swing.JLabel SedeSelec;
    private javax.swing.JTable SedeTable;
    private javax.swing.JPanel SedesOpcion;
    private javax.swing.JPanel SedesPanel;
    private javax.swing.JButton SeleccionarExamen;
    private javax.swing.JButton SeleccionarNoticia;
    private javax.swing.JButton SeleccionarParcial;
    private javax.swing.JButton SeleccionarSede;
    private javax.swing.JLabel TituloEstadisticasCarrera;
    private javax.swing.JLabel TituloEstadisticasCurso;
    private javax.swing.JLabel TituloEstadisticasSede;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JLabel TituloLabel1;
    private javax.swing.JLabel TituloLabel10;
    private javax.swing.JLabel TituloLabel11;
    private javax.swing.JLabel TituloLabel12;
    private javax.swing.JLabel TituloLabel13;
    private javax.swing.JLabel TituloLabel14;
    private javax.swing.JLabel TituloLabel15;
    private javax.swing.JLabel TituloLabel16;
    private javax.swing.JLabel TituloLabel17;
    private javax.swing.JLabel TituloLabel18;
    private javax.swing.JLabel TituloLabel19;
    private javax.swing.JLabel TituloLabel2;
    private javax.swing.JLabel TituloLabel20;
    private javax.swing.JLabel TituloLabel21;
    private javax.swing.JLabel TituloLabel22;
    private javax.swing.JLabel TituloLabel23;
    private javax.swing.JLabel TituloLabel24;
    private javax.swing.JLabel TituloLabel25;
    private javax.swing.JLabel TituloLabel26;
    private javax.swing.JLabel TituloLabel27;
    private javax.swing.JLabel TituloLabel28;
    private javax.swing.JLabel TituloLabel29;
    private javax.swing.JLabel TituloLabel3;
    private javax.swing.JLabel TituloLabel30;
    private javax.swing.JLabel TituloLabel34;
    private javax.swing.JLabel TituloLabel35;
    private javax.swing.JLabel TituloLabel37;
    private javax.swing.JLabel TituloLabel39;
    private javax.swing.JLabel TituloLabel4;
    private javax.swing.JLabel TituloLabel41;
    private javax.swing.JLabel TituloLabel42;
    private javax.swing.JLabel TituloLabel44;
    private javax.swing.JLabel TituloLabel45;
    private javax.swing.JLabel TituloLabel46;
    private javax.swing.JLabel TituloLabel47;
    private javax.swing.JLabel TituloLabel48;
    private javax.swing.JLabel TituloLabel49;
    private javax.swing.JLabel TituloLabel5;
    private javax.swing.JLabel TituloLabel57;
    private javax.swing.JLabel TituloLabel58;
    private javax.swing.JLabel TituloLabel6;
    private javax.swing.JLabel TituloLabel60;
    private javax.swing.JLabel TituloLabel62;
    private javax.swing.JLabel TituloLabel66;
    private javax.swing.JLabel TituloLabel7;
    private javax.swing.JLabel TituloLabel8;
    private javax.swing.JLabel TituloLabel9;
    private javax.swing.JRadioButton TodosExRadioButton;
    private javax.swing.JRadioButton TodosParRadioButton;
    private javax.swing.JRadioButton TodosRadioButton;
    private javax.swing.JButton VerCarrera;
    private javax.swing.JPanel VerCarreraPanel;
    private javax.swing.JButton VerCursoButton;
    private javax.swing.JPanel VerCursoPanel;
    private javax.swing.JButton VerCursosPerfilButton;
    private javax.swing.JPanel VerExamenPanel;
    private javax.swing.JButton VerExamenesPerfilButton;
    private javax.swing.JButton VerMaterialSubidoButton;
    private javax.swing.JPanel VerNoticia;
    private javax.swing.JPanel VerNotificacion;
    private javax.swing.JButton VerNotificacionButton;
    private javax.swing.JPanel VerParcialPanel;
    private javax.swing.JButton VerParcialesPerfilButton;
    private javax.swing.JPanel VerPerfilPanel;
    private javax.swing.JButton VolverButton;
    private javax.swing.JButton btnBuscarCarrera;
    private javax.swing.JButton btnBuscarExamen;
    private javax.swing.JButton btnBuscarNoticia;
    private javax.swing.JButton btnBuscarNotificacion;
    private javax.swing.JButton btnBuscarParcial;
    private javax.swing.JButton btnBuscarSede;
    private javax.swing.JButton btnEstadCarr;
    private javax.swing.ButtonGroup buttonGroupCursos;
    private javax.swing.ButtonGroup buttonGroupEstadCarrera;
    private javax.swing.ButtonGroup buttonGroupEstadCurso;
    private javax.swing.ButtonGroup buttonGroupEstadSede;
    private javax.swing.ButtonGroup buttonGroupExamenes;
    private javax.swing.ButtonGroup buttonGroupParciales;
    private javax.swing.JLabel carrConMasApSede;
    private javax.swing.JLabel carrConMasEstSede;
    private javax.swing.JLabel carrConMejorPromApSede;
    private javax.swing.JLabel carreraCurLabel;
    private javax.swing.JLabel ciEstLabel;
    private javax.swing.JLabel conMasApCarr;
    private javax.swing.JLabel conMasEstCarr;
    private javax.swing.JLabel conMejorPromApCarr;
    private javax.swing.JLabel creditosCarrLabel;
    private javax.swing.JLabel cursoConMasApSede;
    private javax.swing.JLabel cursoConMasEstSede;
    private javax.swing.JLabel cursoConMejorPromApSede;
    private javax.swing.JTextArea descCarreraTextArea;
    private javax.swing.JLabel emailEstLabel;
    private javax.swing.JCheckBox enviarMailsCheckBox;
    private javax.swing.JLabel fechaNacLabel;
    private javax.swing.JLabel fechaNotaLabel;
    private javax.swing.JLabel fechaNotaPLabel;
    private javax.swing.JLabel fechaVerNotificacion;
    private javax.swing.JLabel idEstLabel;
    private javax.swing.JLabel imagenGif;
    private javax.swing.JLabel imgCargando;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel nombreEstLabel;
    private javax.swing.JLabel nombreUsrLabel;
    private javax.swing.JLabel notaAprobCurLabel;
    private javax.swing.JLabel notaExonExLabel;
    private javax.swing.JLabel notificacionIcono;
    private javax.swing.JLabel promApCarr;
    private javax.swing.JLabel promApCarrSede;
    private javax.swing.JLabel promApCursosSede;
    private javax.swing.JLabel promAprobCurso;
    private javax.swing.JLabel promNotaExCarr;
    private javax.swing.JLabel promNotaExCurso;
    private javax.swing.JLabel promNotaExSede;
    private javax.swing.JLabel promNotaParCarr;
    private javax.swing.JLabel promNotaParCurso;
    private javax.swing.JLabel promNotaParSede;
    private javax.swing.JLabel sedeCarreraLabel;
    private javax.swing.JTextArea textoVerNotificacion;
    private javax.swing.JLabel tituloMateriales;
    private javax.swing.JLabel tituloVerNotificacion;
    private javax.swing.JList<String> verNoticia_etiquetas;
    private javax.swing.JLabel verNoticia_fecha;
    private javax.swing.JTextArea verNoticia_texto;
    private javax.swing.JLabel verNoticia_titulo;
    // End of variables declaration//GEN-END:variables
}
