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
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

/**
 *
 * @author Usuario
 */
public class Docente_MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    ArrayList<Object[]> volver = new ArrayList<>();
    ArrayList<JPanel> opciones = new ArrayList<>();
    String ruta = null;
    private Parcial p;

    public Docente_MenuPrincipal() {
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
        subirNota_Estudiantes.getColumnModel().removeColumn(subirNota_Estudiantes.getColumnModel().getColumn(0));
        subirNota_notas.getColumnModel().removeColumn(subirNota_notas.getColumnModel().getColumn(0));
        subirNota_notas.getColumnModel().removeColumn(subirNota_notas.getColumnModel().getColumn(0));
        subirNota_EstudiantesParcial.getColumnModel().removeColumn(subirNota_EstudiantesParcial.getColumnModel().getColumn(0));
        subirNota_notasParcial.getColumnModel().removeColumn(subirNota_notasParcial.getColumnModel().getColumn(0));
        subirNota_notasParcial.getColumnModel().removeColumn(subirNota_notasParcial.getColumnModel().getColumn(0));
        MaterialesSubidosTable.getColumnModel().removeColumn(MaterialesSubidosTable.getColumnModel().getColumn(0));
        verExamen_tabla.getColumnModel().removeColumn(verExamen_tabla.getColumnModel().getColumn(0));
        verParcial_tabla.getColumnModel().removeColumn(verParcial_tabla.getColumnModel().getColumn(0));

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
        PanelPrincipal.add(SubirMaterialPanel, "subirMaterial");
        PanelPrincipal.add(SubirNotaExamen, "subir nota examen");
        PanelPrincipal.add(SubirNotaParcial, "subir nota parcial");
        PanelPrincipal.add(SubirMaterialPanel, "subirMaterial");
        PanelPrincipal.add(VerPerfilPanel, "verPerfil");
        PanelPrincipal.add(MaterialesSubidosPanel, "verMaterial");
        PanelPrincipal.add(EstadisticasCursoPanel, "estadisticasCurso");
        PanelPrincipal.add(EstadisticasCarreraPanel, "estadisticasCarrera");
        PanelPrincipal.add(EstadisticasPanel, "estadisticas");
        PanelPrincipal.add(CargandoPanel, "cargando");

//        String nombres = Fabrica.getInstance().getContEst().getLogin().getNombres();
//        String apellidos = Fabrica.getInstance().getContEst().getLogin().getApellidos();
//        nombreUsrLabel.setText(nombres+" "+apellidos);
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
        
        try {
            this.setIconImage(ImageIO.read(getClass().getResource("/Iconos/logoApp.png")));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Iconos/cargandoGrande.gif"));
        imgCargando.setIcon(icon);
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
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();
        CursosPanel = new javax.swing.JPanel();
        BuscarTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        CursosTable = new javax.swing.JTable();
        VerCursoButton = new javax.swing.JButton();
        SubirMaterialButton = new javax.swing.JButton();
        TodosRadioButton = new javax.swing.JRadioButton();
        DictandoRadioButton = new javax.swing.JRadioButton();
        InscripcionCButton1 = new javax.swing.JButton();
        BuscarButton = new javax.swing.JButton();
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
        subirNota_examen_btn = new javax.swing.JButton();
        btnBuscarExamen = new javax.swing.JButton();
        TodosExRadioButton = new javax.swing.JRadioButton();
        MisExmenesRadioButton = new javax.swing.JRadioButton();
        verExamen = new javax.swing.JButton();
        VerExamenPanel = new javax.swing.JPanel();
        verExamen_titulo = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        verExamen_fecha = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        verExamen_notaAprobacion = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        verExamen_notaTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        verExamen_tabla = new javax.swing.JTable();
        jScrollPane18 = new javax.swing.JScrollPane();
        verExamen_datosEstudiante = new javax.swing.JTextArea();
        ParcialesPanel = new javax.swing.JPanel();
        BuscarParcialTextField = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        ParcialesTable = new javax.swing.JTable();
        SubirNotasParcial = new javax.swing.JButton();
        btnBuscarParcial = new javax.swing.JButton();
        TodosParRadioButton = new javax.swing.JRadioButton();
        MisParcialesRadioButton = new javax.swing.JRadioButton();
        verParcial = new javax.swing.JButton();
        VerNoticia = new javax.swing.JPanel();
        verNoticia_titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        verNoticia_fecha = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        verNoticia_etiquetas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        verNoticia_texto = new javax.swing.JTextArea();
        SubirNotaExamen = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        subirNota_notas = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        subirNota_Estudiantes = new javax.swing.JTable();
        subirNota_btnAgregar = new javax.swing.JButton();
        btn_cancelar_subirNotaExamen = new javax.swing.JButton();
        subirNota_Eliminar = new javax.swing.JButton();
        subirNota_nota = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        subirNota_notaMax = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        subirNota_notaApro = new javax.swing.JLabel();
        subirNota_Titulo = new javax.swing.JLabel();
        btn_aceptar_subirNotaExamen = new javax.swing.JButton();
        subirNota_chkFecha = new javax.swing.JCheckBox();
        subirNota_fechaMuestra = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        SubirNotaParcial = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        subirNota_notasParcial = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        subirNota_EstudiantesParcial = new javax.swing.JTable();
        subirNota_btnAgregarParcial = new javax.swing.JButton();
        btn_cancelar_subirNotaParcial = new javax.swing.JButton();
        subirNota_EliminarParcial = new javax.swing.JButton();
        subirNota_notaParcial = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        subirNota_TituloParcial = new javax.swing.JLabel();
        btn_aceptar_subirNotaParcial = new javax.swing.JButton();
        VerPerfilPanel = new javax.swing.JPanel();
        nombrePerfilLabel = new javax.swing.JLabel();
        AuxLabel = new javax.swing.JLabel();
        idPerfilLabel = new javax.swing.JLabel();
        AuxLabel2 = new javax.swing.JLabel();
        fechaNacPerfilLabel = new javax.swing.JLabel();
        AuxLabel3 = new javax.swing.JLabel();
        ciPefilLabel = new javax.swing.JLabel();
        AuxLabel1 = new javax.swing.JLabel();
        emailPerfilLabel = new javax.swing.JLabel();
        VerCursosPerfilButton = new javax.swing.JButton();
        VerExamenesPerfilButton = new javax.swing.JButton();
        VerParcialesPerfilButton = new javax.swing.JButton();
        SubirMaterialPanel = new javax.swing.JPanel();
        CursoMaterialLabel = new javax.swing.JLabel();
        TituloLabel20 = new javax.swing.JLabel();
        TituloLabel21 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        descArchTextArea = new javax.swing.JTextArea();
        TituloArchivoTextField = new javax.swing.JTextField();
        SelecArchivoButton = new javax.swing.JButton();
        TituloLabel22 = new javax.swing.JLabel();
        confirmarSubirMButton = new javax.swing.JButton();
        rutaArchivoLabel = new javax.swing.JLabel();
        MaterialesSubidosPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        MaterialesSubidosTable = new javax.swing.JTable();
        TituloLabel14 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        DescMaterialTextArea = new javax.swing.JTextArea();
        DescargarMaterialButton = new javax.swing.JButton();
        tituloMateriales = new javax.swing.JLabel();
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
        VerParcialPanel = new javax.swing.JPanel();
        verParcial_titulo = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        verParcial_fecha = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        verParcial_notaTotal = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        verParcial_tabla = new javax.swing.JTable();
        jScrollPane20 = new javax.swing.JScrollPane();
        verParcial_datosEstudiante = new javax.swing.JTextArea();
        EstadisticasPanel = new javax.swing.JPanel();
        TituloEstadisticasSede = new javax.swing.JLabel();
        TituloLabel17 = new javax.swing.JLabel();
        TituloLabel19 = new javax.swing.JLabel();
        TituloLabel23 = new javax.swing.JLabel();
        TituloLabel24 = new javax.swing.JLabel();
        TituloLabel25 = new javax.swing.JLabel();
        TituloLabel26 = new javax.swing.JLabel();
        TituloLabel27 = new javax.swing.JLabel();
        carrConMasEstSede = new javax.swing.JLabel();
        TituloLabel28 = new javax.swing.JLabel();
        carrConMasApSede = new javax.swing.JLabel();
        TituloLabel29 = new javax.swing.JLabel();
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
        jLabel21 = new javax.swing.JLabel();
        NotificacionesPanel = new javax.swing.JPanel();
        BuscarNotifiacion = new javax.swing.JTextField();
        jScrollPane23 = new javax.swing.JScrollPane();
        NotificacionesTable = new javax.swing.JTable();
        VerNotificacionButton = new javax.swing.JButton();
        btnBuscarNotificacion = new javax.swing.JButton();
        VerNotificacion = new javax.swing.JPanel();
        tituloVerNotificacion = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        fechaVerNotificacion = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        textoVerNotificacion = new javax.swing.JTextArea();
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estadisticas-opcion.png"))); // NOI18N

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Estadísticas");

        javax.swing.GroupLayout EstadisticasOpcionLayout = new javax.swing.GroupLayout(EstadisticasOpcion);
        EstadisticasOpcion.setLayout(EstadisticasOpcionLayout);
        EstadisticasOpcionLayout.setHorizontalGroup(
            EstadisticasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        EstadisticasOpcionLayout.setVerticalGroup(
            EstadisticasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstadisticasOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/logoApp.png"))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Gestión Educativa");

        javax.swing.GroupLayout PanelLateralLayout = new javax.swing.GroupLayout(PanelLateral);
        PanelLateral.setLayout(PanelLateralLayout);
        PanelLateralLayout.setHorizontalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CursosOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CarrerasOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SedesOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NoticiasOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ExamenesOpcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ParcialesOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EstadisticasOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addGroup(PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SedeSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLateralLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel27))
                    .addGroup(PanelLateralLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLateralLayout.setVerticalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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

        SubirMaterialButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SubirMaterialButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/subir.png"))); // NOI18N
        SubirMaterialButton.setText("Subir Material");
        SubirMaterialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubirMaterialButtonActionPerformed(evt);
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

        DictandoRadioButton.setBackground(new java.awt.Color(73, 202, 114));
        buttonGroupCursos.add(DictandoRadioButton);
        DictandoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DictandoRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        DictandoRadioButton.setText("Dictando");
        DictandoRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DictandoRadioButtonItemStateChanged(evt);
            }
        });
        DictandoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DictandoRadioButtonActionPerformed(evt);
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

        BuscarButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarButton.setText("Buscar");
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
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
                        .addComponent(DictandoRadioButton))
                    .addGroup(CursosPanelLayout.createSequentialGroup()
                        .addComponent(VerCursoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SubirMaterialButton)
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
                    .addComponent(DictandoRadioButton)
                    .addComponent(BuscarButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VerCursoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubirMaterialButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InscripcionCButton1))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEstadCarr))
                    .addGroup(CarrerasPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(BuscarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CarrerasPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        CarrerasPanelLayout.setVerticalGroup(
            CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CarrerasPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarCarrera)
                    .addComponent(BuscarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VerCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstadCarr))
                .addContainerGap())
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
                .addContainerGap(244, Short.MAX_VALUE))
        );
        SedesPanelLayout.setVerticalGroup(
            SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SedesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarSede)
                    .addComponent(BuscarSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
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

        subirNota_examen_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subirNota_examen_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/crear.png"))); // NOI18N
        subirNota_examen_btn.setText("Subir notas");
        subirNota_examen_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirNota_examen_btnActionPerformed(evt);
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
        MisExmenesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MisExmenesRadioButtonActionPerformed(evt);
            }
        });

        verExamen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/escolaridad.png"))); // NOI18N
        verExamen.setText("Ver examen");
        verExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verExamenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ExamenesPanelLayout = new javax.swing.GroupLayout(ExamenesPanel);
        ExamenesPanel.setLayout(ExamenesPanelLayout);
        ExamenesPanelLayout.setHorizontalGroup(
            ExamenesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamenesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ExamenesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ExamenesPanelLayout.createSequentialGroup()
                        .addComponent(subirNota_examen_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verExamen))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ExamenesPanelLayout.createSequentialGroup()
                        .addComponent(BuscarExamenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TodosExRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MisExmenesRadioButton)))
                .addContainerGap())
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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamenesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subirNota_examen_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PanelPrincipal.add(ExamenesPanel, "cardSedes");

        VerExamenPanel.setBackground(new java.awt.Color(73, 202, 114));

        verExamen_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        verExamen_titulo.setForeground(new java.awt.Color(255, 255, 255));
        verExamen_titulo.setText("jLabel23");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Fecha de realización:");

        verExamen_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        verExamen_fecha.setForeground(new java.awt.Color(255, 255, 255));
        verExamen_fecha.setText("jLabel24");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Nota de aprobación:");

        verExamen_notaAprobacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        verExamen_notaAprobacion.setForeground(new java.awt.Color(255, 255, 255));
        verExamen_notaAprobacion.setText("jLabel25");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Nota total del examen:");

        verExamen_notaTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        verExamen_notaTotal.setForeground(new java.awt.Color(255, 255, 255));
        verExamen_notaTotal.setText("jLabel25");

        verExamen_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Objeto", "CI", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        verExamen_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verExamen_tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(verExamen_tabla);

        verExamen_datosEstudiante.setEditable(false);
        verExamen_datosEstudiante.setColumns(20);
        verExamen_datosEstudiante.setRows(5);
        jScrollPane18.setViewportView(verExamen_datosEstudiante);

        javax.swing.GroupLayout VerExamenPanelLayout = new javax.swing.GroupLayout(VerExamenPanel);
        VerExamenPanel.setLayout(VerExamenPanelLayout);
        VerExamenPanelLayout.setHorizontalGroup(
            VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerExamenPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(VerExamenPanelLayout.createSequentialGroup()
                            .addGroup(VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(VerExamenPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(70, 70, 70)))
                            .addGap(18, 18, 18)
                            .addGroup(VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(verExamen_notaAprobacion)
                                .addComponent(verExamen_notaTotal)
                                .addComponent(verExamen_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                        .addComponent(jScrollPane18))
                    .addComponent(verExamen_titulo))
                .addContainerGap(454, Short.MAX_VALUE))
        );
        VerExamenPanelLayout.setVerticalGroup(
            VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerExamenPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(verExamen_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(verExamen_fecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(verExamen_notaAprobacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VerExamenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(verExamen_notaTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerExamenPanel, "card7");

        ParcialesPanel.setBackground(new java.awt.Color(73, 202, 114));

        BuscarParcialTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarParcialTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscarParcialTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscarParcialTextFieldFocusLost(evt);
            }
        });
        BuscarParcialTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarParcialTextFieldActionPerformed(evt);
            }
        });
        BuscarParcialTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarParcialTextFieldKeyReleased(evt);
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

        SubirNotasParcial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SubirNotasParcial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/crear.png"))); // NOI18N
        SubirNotasParcial.setText("Subir notas");
        SubirNotasParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubirNotasParcialActionPerformed(evt);
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

        verParcial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verParcial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/escolaridad.png"))); // NOI18N
        verParcial.setText("Ver parcial");
        verParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verParcialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ParcialesPanelLayout = new javax.swing.GroupLayout(ParcialesPanel);
        ParcialesPanel.setLayout(ParcialesPanelLayout);
        ParcialesPanelLayout.setHorizontalGroup(
            ParcialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParcialesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ParcialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ParcialesPanelLayout.createSequentialGroup()
                        .addComponent(SubirNotasParcial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verParcial))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ParcialesPanelLayout.createSequentialGroup()
                        .addComponent(BuscarParcialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TodosParRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MisParcialesRadioButton)))
                .addContainerGap())
        );
        ParcialesPanelLayout.setVerticalGroup(
            ParcialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParcialesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ParcialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarParcial)
                    .addComponent(BuscarParcialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MisParcialesRadioButton)
                    .addComponent(TodosParRadioButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ParcialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubirNotasParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        PanelPrincipal.add(ParcialesPanel, "cardSedes");

        VerNoticia.setBackground(new java.awt.Color(73, 202, 114));

        verNoticia_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        verNoticia_titulo.setForeground(new java.awt.Color(255, 255, 255));
        verNoticia_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verNoticia_titulo.setText("Titulo");
        verNoticia_titulo.setToolTipText("");
        verNoticia_titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fecha de creación:");

        verNoticia_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
                .addGroup(VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VerNoticiaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(verNoticia_fecha))
                    .addComponent(verNoticia_titulo))
                .addContainerGap(594, Short.MAX_VALUE))
        );
        VerNoticiaLayout.setVerticalGroup(
            VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerNoticiaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(verNoticia_titulo)
                .addGap(42, 42, 42)
                .addGroup(VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(verNoticia_fecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerNoticia, "card11");

        SubirNotaExamen.setBackground(new java.awt.Color(73, 202, 114));

        subirNota_notas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Objeto", "Inscripcion", "CI", "Nombre", "Nota", "Aprobado"
            }
        ));
        jScrollPane11.setViewportView(subirNota_notas);

        subirNota_Estudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Objeto", "CI", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(subirNota_Estudiantes);

        subirNota_btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subirNota_btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nota.png"))); // NOI18N
        subirNota_btnAgregar.setText("Agregar");
        subirNota_btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirNota_btnAgregarActionPerformed(evt);
            }
        });

        btn_cancelar_subirNotaExamen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cancelar_subirNotaExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btn_cancelar_subirNotaExamen.setText("Cancelar");
        btn_cancelar_subirNotaExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_subirNotaExamenActionPerformed(evt);
            }
        });

        subirNota_Eliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subirNota_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        subirNota_Eliminar.setText("Borrar");
        subirNota_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirNota_EliminarActionPerformed(evt);
            }
        });

        subirNota_nota.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nota del estudiante:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nota máxima del examen:");

        subirNota_notaMax.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subirNota_notaMax.setForeground(new java.awt.Color(255, 255, 255));
        subirNota_notaMax.setText("jLabel18");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nota de aprobación:");

        subirNota_notaApro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subirNota_notaApro.setForeground(new java.awt.Color(255, 255, 255));
        subirNota_notaApro.setText("jLabel18");

        subirNota_Titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subirNota_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        subirNota_Titulo.setText("jLabel19");

        btn_aceptar_subirNotaExamen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_aceptar_subirNotaExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-square.png"))); // NOI18N
        btn_aceptar_subirNotaExamen.setText("Aceptar");
        btn_aceptar_subirNotaExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar_subirNotaExamenActionPerformed(evt);
            }
        });

        subirNota_chkFecha.setText("Fecha de muestra");
        subirNota_chkFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirNota_chkFechaActionPerformed(evt);
            }
        });

        try {
            subirNota_fechaMuestra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####-##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        subirNota_fechaMuestra.setEnabled(false);

        jLabel19.setText("DD/MM/AAAA-hh:mm");

        javax.swing.GroupLayout SubirNotaExamenLayout = new javax.swing.GroupLayout(SubirNotaExamen);
        SubirNotaExamen.setLayout(SubirNotaExamenLayout);
        SubirNotaExamenLayout.setHorizontalGroup(
            SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubirNotaExamenLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subirNota_Titulo)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SubirNotaExamenLayout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SubirNotaExamenLayout.createSequentialGroup()
                                .addGroup(SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(18, 18, 18)
                                .addGroup(SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subirNota_notaApro)
                                    .addComponent(subirNota_notaMax)
                                    .addComponent(subirNota_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(subirNota_btnAgregar)))
                    .addGroup(SubirNotaExamenLayout.createSequentialGroup()
                        .addComponent(subirNota_Eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar_subirNotaExamen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_aceptar_subirNotaExamen))
                    .addGroup(SubirNotaExamenLayout.createSequentialGroup()
                        .addComponent(subirNota_chkFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subirNota_fechaMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        SubirNotaExamenLayout.setVerticalGroup(
            SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SubirNotaExamenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(subirNota_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SubirNotaExamenLayout.createSequentialGroup()
                        .addGroup(SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(subirNota_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(subirNota_notaMax))
                        .addGap(26, 26, 26)
                        .addGroup(SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(subirNota_notaApro))
                        .addGap(34, 34, 34)
                        .addComponent(subirNota_btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subirNota_chkFecha)
                    .addComponent(subirNota_fechaMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubirNotaExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar_subirNotaExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subirNota_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_aceptar_subirNotaExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        PanelPrincipal.add(SubirNotaExamen, "card12");

        SubirNotaParcial.setBackground(new java.awt.Color(73, 202, 114));

        subirNota_notasParcial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Objeto", "Inscripcion", "CI", "Nombre", "Nota", "Aprobado"
            }
        ));
        jScrollPane15.setViewportView(subirNota_notasParcial);

        subirNota_EstudiantesParcial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Objeto", "CI", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane16.setViewportView(subirNota_EstudiantesParcial);

        subirNota_btnAgregarParcial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subirNota_btnAgregarParcial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nota.png"))); // NOI18N
        subirNota_btnAgregarParcial.setText("Agregar");
        subirNota_btnAgregarParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirNota_btnAgregarParcialActionPerformed(evt);
            }
        });

        btn_cancelar_subirNotaParcial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cancelar_subirNotaParcial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btn_cancelar_subirNotaParcial.setText("Cancelar");
        btn_cancelar_subirNotaParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_subirNotaParcialActionPerformed(evt);
            }
        });

        subirNota_EliminarParcial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subirNota_EliminarParcial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        subirNota_EliminarParcial.setText("Borrar");
        subirNota_EliminarParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirNota_EliminarParcialActionPerformed(evt);
            }
        });

        subirNota_notaParcial.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nota del estudiante:");

        subirNota_TituloParcial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subirNota_TituloParcial.setForeground(new java.awt.Color(255, 255, 255));
        subirNota_TituloParcial.setText("jLabel19");

        btn_aceptar_subirNotaParcial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_aceptar_subirNotaParcial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-square.png"))); // NOI18N
        btn_aceptar_subirNotaParcial.setText("Aceptar");
        btn_aceptar_subirNotaParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar_subirNotaParcialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SubirNotaParcialLayout = new javax.swing.GroupLayout(SubirNotaParcial);
        SubirNotaParcial.setLayout(SubirNotaParcialLayout);
        SubirNotaParcialLayout.setHorizontalGroup(
            SubirNotaParcialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubirNotaParcialLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(SubirNotaParcialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subirNota_TituloParcial)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SubirNotaParcialLayout.createSequentialGroup()
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(SubirNotaParcialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SubirNotaParcialLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(subirNota_notaParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(subirNota_btnAgregarParcial)))
                    .addGroup(SubirNotaParcialLayout.createSequentialGroup()
                        .addComponent(subirNota_EliminarParcial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar_subirNotaParcial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_aceptar_subirNotaParcial)))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        SubirNotaParcialLayout.setVerticalGroup(
            SubirNotaParcialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SubirNotaParcialLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(subirNota_TituloParcial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubirNotaParcialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SubirNotaParcialLayout.createSequentialGroup()
                        .addGroup(SubirNotaParcialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(subirNota_notaParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)
                        .addComponent(subirNota_btnAgregarParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(SubirNotaParcialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar_subirNotaParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subirNota_EliminarParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_aceptar_subirNotaParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        PanelPrincipal.add(SubirNotaParcial, "card12");

        VerPerfilPanel.setBackground(new java.awt.Color(73, 202, 114));

        nombrePerfilLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nombrePerfilLabel.setForeground(new java.awt.Color(255, 255, 255));
        nombrePerfilLabel.setText("Nombre");

        AuxLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuxLabel.setForeground(new java.awt.Color(255, 255, 255));
        AuxLabel.setText("Id:");

        idPerfilLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idPerfilLabel.setForeground(new java.awt.Color(255, 255, 255));

        AuxLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuxLabel2.setForeground(new java.awt.Color(255, 255, 255));
        AuxLabel2.setText("Fecha de nacimiento");

        fechaNacPerfilLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaNacPerfilLabel.setForeground(new java.awt.Color(255, 255, 255));

        AuxLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuxLabel3.setForeground(new java.awt.Color(255, 255, 255));
        AuxLabel3.setText("CI:");

        ciPefilLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ciPefilLabel.setForeground(new java.awt.Color(255, 255, 255));

        AuxLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AuxLabel1.setForeground(new java.awt.Color(255, 255, 255));
        AuxLabel1.setText("Email:");

        emailPerfilLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailPerfilLabel.setForeground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout VerPerfilPanelLayout = new javax.swing.GroupLayout(VerPerfilPanel);
        VerPerfilPanel.setLayout(VerPerfilPanelLayout);
        VerPerfilPanelLayout.setHorizontalGroup(
            VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombrePerfilLabel)
                    .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                        .addComponent(AuxLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaNacPerfilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                        .addComponent(AuxLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idPerfilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                        .addComponent(AuxLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailPerfilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                        .addComponent(AuxLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ciPefilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(VerParcialesPerfilButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VerCursosPerfilButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VerExamenesPerfilButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(759, Short.MAX_VALUE))
        );
        VerPerfilPanelLayout.setVerticalGroup(
            VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerPerfilPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(nombrePerfilLabel)
                .addGap(18, 18, 18)
                .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuxLabel)
                    .addComponent(idPerfilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuxLabel2)
                    .addComponent(fechaNacPerfilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuxLabel3)
                    .addComponent(ciPefilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerPerfilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuxLabel1)
                    .addComponent(emailPerfilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(VerCursosPerfilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VerExamenesPerfilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VerParcialesPerfilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerPerfilPanel, "card14");

        SubirMaterialPanel.setBackground(new java.awt.Color(73, 202, 114));

        CursoMaterialLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        CursoMaterialLabel.setForeground(new java.awt.Color(255, 255, 255));
        CursoMaterialLabel.setText("Curso");

        TituloLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel20.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel20.setText("Título:");

        TituloLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel21.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel21.setText("Descripción:");

        descArchTextArea.setColumns(20);
        descArchTextArea.setRows(5);
        jScrollPane21.setViewportView(descArchTextArea);

        TituloArchivoTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloArchivoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloArchivoTextFieldActionPerformed(evt);
            }
        });

        SelecArchivoButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SelecArchivoButton.setText("Seleccionar...");
        SelecArchivoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelecArchivoButtonActionPerformed(evt);
            }
        });

        TituloLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel22.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel22.setText("Archivo:");

        confirmarSubirMButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirmarSubirMButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-square.png"))); // NOI18N
        confirmarSubirMButton.setText("Confirmar");
        confirmarSubirMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarSubirMButtonActionPerformed(evt);
            }
        });

        rutaArchivoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rutaArchivoLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout SubirMaterialPanelLayout = new javax.swing.GroupLayout(SubirMaterialPanel);
        SubirMaterialPanel.setLayout(SubirMaterialPanelLayout);
        SubirMaterialPanelLayout.setHorizontalGroup(
            SubirMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubirMaterialPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SubirMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CursoMaterialLabel)
                    .addGroup(SubirMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SubirMaterialPanelLayout.createSequentialGroup()
                            .addComponent(TituloLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TituloArchivoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(SubirMaterialPanelLayout.createSequentialGroup()
                            .addComponent(TituloLabel21)
                            .addGap(212, 212, 212)))
                    .addGroup(SubirMaterialPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rutaArchivoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(confirmarSubirMButton)
                    .addComponent(SelecArchivoButton))
                .addContainerGap(679, Short.MAX_VALUE))
        );
        SubirMaterialPanelLayout.setVerticalGroup(
            SubirMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubirMaterialPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(CursoMaterialLabel)
                .addGap(18, 18, 18)
                .addGroup(SubirMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloLabel20)
                    .addComponent(TituloArchivoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TituloLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SubirMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TituloLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rutaArchivoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelecArchivoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(confirmarSubirMButton)
                .addContainerGap())
        );

        PanelPrincipal.add(SubirMaterialPanel, "card18");

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
                .addContainerGap(259, Short.MAX_VALUE))
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
                .addContainerGap(25, Short.MAX_VALUE))
        );

        PanelPrincipal.add(MaterialesSubidosPanel, "card15");

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
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
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
                .addContainerGap(190, Short.MAX_VALUE))
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
                .addContainerGap(14, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerCursoPanel, "card7");

        VerParcialPanel.setBackground(new java.awt.Color(73, 202, 114));

        verParcial_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        verParcial_titulo.setForeground(new java.awt.Color(255, 255, 255));
        verParcial_titulo.setText("jLabel23");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Fecha de realización:");

        verParcial_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        verParcial_fecha.setForeground(new java.awt.Color(255, 255, 255));
        verParcial_fecha.setText("jLabel24");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Nota total del parcial:");

        verParcial_notaTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        verParcial_notaTotal.setForeground(new java.awt.Color(255, 255, 255));
        verParcial_notaTotal.setText("jLabel25");

        verParcial_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Objeto", "CI", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        verParcial_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verParcial_tablaMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(verParcial_tabla);

        verParcial_datosEstudiante.setEditable(false);
        verParcial_datosEstudiante.setColumns(20);
        verParcial_datosEstudiante.setRows(5);
        jScrollPane20.setViewportView(verParcial_datosEstudiante);

        javax.swing.GroupLayout VerParcialPanelLayout = new javax.swing.GroupLayout(VerParcialPanel);
        VerParcialPanel.setLayout(VerParcialPanelLayout);
        VerParcialPanelLayout.setHorizontalGroup(
            VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerParcialPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(VerParcialPanelLayout.createSequentialGroup()
                            .addGroup(VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(VerParcialPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(70, 70, 70)))
                            .addGap(18, 18, 18)
                            .addGroup(VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(verParcial_notaTotal)
                                .addComponent(verParcial_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                        .addComponent(jScrollPane20))
                    .addComponent(verParcial_titulo))
                .addContainerGap(499, Short.MAX_VALUE))
        );
        VerParcialPanelLayout.setVerticalGroup(
            VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerParcialPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(verParcial_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(verParcial_fecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VerParcialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verParcial_notaTotal)
                    .addComponent(jLabel28))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerParcialPanel, "card7");

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

        TituloLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel23.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel23.setText("De carreras:");

        TituloLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel24.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel24.setText("Promedios de notas obtenidas");

        TituloLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel25.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel25.setText("En Exámenes:");

        TituloLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel26.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel26.setText("En parciales:");

        TituloLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel27.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel27.setText("Carrera con más estudiantes cursando");

        carrConMasEstSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        carrConMasEstSede.setForeground(new java.awt.Color(255, 255, 255));
        carrConMasEstSede.setText("Nombre");

        TituloLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel28.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel28.setText("Carrera con más egresados");

        carrConMasApSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        carrConMasApSede.setForeground(new java.awt.Color(255, 255, 255));
        carrConMasApSede.setText("No hay datos");

        TituloLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TituloLabel29.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel29.setText("Carrera con mejor promedio de egreso");

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
                            .addComponent(TituloLabel27)
                            .addComponent(carrConMasEstSede)
                            .addComponent(TituloLabel28)
                            .addComponent(carrConMasApSede)
                            .addComponent(TituloLabel29)
                            .addComponent(carrConMejorPromApSede))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
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
                                .addComponent(TituloLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(promApCarrSede)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TituloLabel24)
                            .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(promNotaExSede))
                            .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel26)
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
                            .addComponent(TituloLabel23)
                            .addComponent(promApCarrSede)))
                    .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloLabel25)
                            .addComponent(promNotaExSede))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloLabel26)
                            .addComponent(promNotaParSede))))
                .addGap(18, 18, 18)
                .addGroup(EstadisticasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EstadisticasPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(carrConMasEstSede)
                        .addGap(18, 18, 18)
                        .addComponent(TituloLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(carrConMasApSede)
                        .addGap(18, 18, 18)
                        .addComponent(TituloLabel29)
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
                .addContainerGap(215, Short.MAX_VALUE))
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
                .addContainerGap(667, Short.MAX_VALUE))
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

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Cargando...");

        javax.swing.GroupLayout CargandoPanelLayout = new javax.swing.GroupLayout(CargandoPanel);
        CargandoPanel.setLayout(CargandoPanelLayout);
        CargandoPanelLayout.setHorizontalGroup(
            CargandoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CargandoPanelLayout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addGroup(CargandoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CargandoPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel21))
                    .addComponent(imgCargando))
                .addContainerGap(524, Short.MAX_VALUE))
        );
        CargandoPanelLayout.setVerticalGroup(
            CargandoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CargandoPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(imgCargando)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        PanelPrincipal.add(CargandoPanel, "card19");

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
        jScrollPane23.setViewportView(NotificacionesTable);

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
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
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

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Fecha:");

        fechaVerNotificacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaVerNotificacion.setForeground(new java.awt.Color(255, 255, 255));
        fechaVerNotificacion.setText("-");

        textoVerNotificacion.setEditable(false);
        textoVerNotificacion.setColumns(20);
        textoVerNotificacion.setLineWrap(true);
        textoVerNotificacion.setRows(5);
        jScrollPane24.setViewportView(textoVerNotificacion);

        javax.swing.GroupLayout VerNotificacionLayout = new javax.swing.GroupLayout(VerNotificacion);
        VerNotificacion.setLayout(VerNotificacionLayout);
        VerNotificacionLayout.setHorizontalGroup(
            VerNotificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerNotificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerNotificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addGroup(VerNotificacionLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaVerNotificacion))
                    .addComponent(tituloVerNotificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(594, Short.MAX_VALUE))
        );
        VerNotificacionLayout.setVerticalGroup(
            VerNotificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VerNotificacionLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(tituloVerNotificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerNotificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(fechaVerNotificacion))
                .addGap(186, 186, 186))
        );

        PanelPrincipal.add(VerNotificacion, "card11");

        PanelCabecera.setBackground(new java.awt.Color(73, 202, 114));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCabeceraLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(notificacionIcono)
                    .addComponent(nombreUsrLabel))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCabeceraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(VolverButton))
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
                    .addComponent(PanelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
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
//            DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();
//            Curso curso = (Curso) modelo.getValueAt(CursosTable.getSelectedRow(), 0);
//            Estudiante_VerCurso verC = new Estudiante_VerCurso(curso);
//            verC.setVisible(true);
            opcionSeleccionada(CursosOpcion, "verCurso");

        }
    }//GEN-LAST:event_VerCursoButtonActionPerformed

    private void SubirMaterialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubirMaterialButtonActionPerformed
        if (CursosTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un curso", "", WARNING_MESSAGE);
        } else {
            DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();
            Curso curso = (Curso) modelo.getValueAt(CursosTable.getSelectedRow(), 0);
            if (Fabrica.getInstance().getContDocente().dictaCurso(curso)) {
                opcionSeleccionada(CursosOpcion, "subirMaterial");
            } else {
                JOptionPane.showMessageDialog(this, "No dicta este curso, no puede subir material");
            }
        }
    }//GEN-LAST:event_SubirMaterialButtonActionPerformed

    private void DictandoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DictandoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DictandoRadioButtonActionPerformed

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
            Fabrica.getInstance().getContEdu().seleccionSede(s.getId());
            opcionSeleccionada(CursosOpcion, "cursos");
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
        int index = CarreraTable.getSelectedRow();
        if (index != -1) {
            Carrera c = (Carrera) CarreraTable.getModel().getValueAt(index, 0);
            Estudiante_VerCarrera vc = new Estudiante_VerCarrera(c);
            vc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado una carrera");
        }
    }//GEN-LAST:event_VerCarreraActionPerformed

    private void btnBuscarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCarreraActionPerformed
        this.listarCarreras();
    }//GEN-LAST:event_btnBuscarCarreraActionPerformed

    private void TodosRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TodosRadioButtonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            listarCursos("");
        }
    }//GEN-LAST:event_TodosRadioButtonItemStateChanged

    private void DictandoRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DictandoRadioButtonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            listarCursos("");
        }
    }//GEN-LAST:event_DictandoRadioButtonItemStateChanged

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

    private void subirNota_examen_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirNota_examen_btnActionPerformed
        if (ExamenesTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un exámen", "", WARNING_MESSAGE);
        } else {
            try {
                subirNotaExamen();
                opcionSeleccionada(ExamenesOpcion, "subir nota examen");
            } catch (InternalException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "", WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_subirNota_examen_btnActionPerformed

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

    private void MisExmenesRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MisExmenesRadioButtonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            listarExamenes("");
        }
    }//GEN-LAST:event_MisExmenesRadioButtonItemStateChanged

    private void TodosExRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TodosExRadioButtonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
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

    private void BuscarParcialTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarParcialTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarParcialTextFieldFocusGained

    private void BuscarParcialTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarParcialTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarParcialTextFieldFocusLost

    private void BuscarParcialTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarParcialTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarParcialTextFieldActionPerformed

    private void BuscarParcialTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarParcialTextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarParcialTextFieldKeyReleased

    private void SubirNotasParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubirNotasParcialActionPerformed
        if (ParcialesTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un parcial", "", WARNING_MESSAGE);
        } else {
            try {
                subirNotaParcial();
                opcionSeleccionada(ParcialesOpcion, "subir nota parcial");
            } catch (InternalException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "", WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_SubirNotasParcialActionPerformed

    private void btnBuscarParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarParcialActionPerformed
        listarParciales(BuscarParcialTextField.getText());
    }//GEN-LAST:event_btnBuscarParcialActionPerformed

    private void TodosParRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TodosParRadioButtonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            listarParciales("");
        }
    }//GEN-LAST:event_TodosParRadioButtonItemStateChanged

    private void MisParcialesRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MisParcialesRadioButtonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            listarParciales("");
        }
    }//GEN-LAST:event_MisParcialesRadioButtonItemStateChanged

    private void VolverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverButtonActionPerformed
        // Si es mayor a 1 porque si solo tiene 1 es el panel actual, no tiene anterior
        this.Volver();
    }//GEN-LAST:event_VolverButtonActionPerformed

    private void subirNota_btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirNota_btnAgregarActionPerformed
        if (subirNota_Estudiantes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un estudiante", "Error", WARNING_MESSAGE);
        } else {
            DefaultTableModel modelo = (DefaultTableModel) subirNota_Estudiantes.getModel();
            InscripcionE ie = (InscripcionE) modelo.getValueAt(subirNota_Estudiantes.getSelectedRow(), 0);
            ResultadoE res = new ResultadoE();
            res.setFecha(new Date());
            res.setNota((int) subirNota_nota.getValue());
            DefaultTableModel modelo2 = (DefaultTableModel) subirNota_notas.getModel();
            String aprobado = "Aprobado";
            if (res.getNota() < ((int) Integer.valueOf(subirNota_notaApro.getText()))) {
                aprobado = "Reprobado";
            }
            Object[] datos = {res, ie, ie.getEstudiante().getCi(), ie.getEstudiante().getNombres() + " " + ie.getEstudiante().getApellidos(), res.getNota(), aprobado};
            modelo2.addRow(datos);
            resizeColumnWidth(subirNota_notas);
            subirNota_nota.setValue(((SpinnerNumberModel) subirNota_nota.getModel()).getMinimum());
            modelo.removeRow(subirNota_Estudiantes.getSelectedRow());
        }
    }//GEN-LAST:event_subirNota_btnAgregarActionPerformed

    private void btn_cancelar_subirNotaExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_subirNotaExamenActionPerformed
        if (volver.size() > 1) {
            CardLayout cl = (CardLayout) (PanelPrincipal.getLayout());
            String ultimaVentana = (String) volver.get(volver.size() - 2)[0]; //el 0 tiene el panel principal
            JPanel ultimaOpcion = (JPanel) volver.get(volver.size() - 2)[1]; //el 1 el tiene panel lateral
            cl.show(PanelPrincipal, ultimaVentana); //la ultima ventana visitada es el anteultimo agregado, el ultimo es el actual
            resaltarOpcioneleccionada(ultimaOpcion);
            volver.remove(volver.size() - 1); //borrar la ventana actual
        }
    }//GEN-LAST:event_btn_cancelar_subirNotaExamenActionPerformed

    private void subirNota_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirNota_EliminarActionPerformed
        if (subirNota_notas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar la nota de un estudiante para borrar", "Error", WARNING_MESSAGE);
        } else {
            DefaultTableModel modelo = (DefaultTableModel) subirNota_notas.getModel();
            InscripcionE ie = (InscripcionE) modelo.getValueAt(subirNota_notas.getSelectedRow(), 1);
            DefaultTableModel modelo2 = (DefaultTableModel) subirNota_Estudiantes.getModel();
            Object[] datos = {ie, ie.getEstudiante().getCi(), ie.getEstudiante().getNombres() + " " + ie.getEstudiante().getApellidos()};
            modelo2.addRow(datos);
            resizeColumnWidth(subirNota_notas);
            modelo.removeRow(subirNota_notas.getSelectedRow());
        }
    }//GEN-LAST:event_subirNota_EliminarActionPerformed

    private void btn_aceptar_subirNotaExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar_subirNotaExamenActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(this, "¿Estás seguro de guardar las notas?"
                + "\nLuego no se podrán editar", "", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            DefaultTableModel modelo = (DefaultTableModel) subirNota_notas.getModel();
            if (modelo.getRowCount() > 0) {
                try {
                    Examen e = ((InscripcionE) modelo.getValueAt(0, 1)).getExamen();
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        InscripcionE ie = (InscripcionE) modelo.getValueAt(i, 1);
                        ResultadoE re = (ResultadoE) modelo.getValueAt(i, 0);
                        ie.setNota(re);
                        if (e.getNotaApro() <= re.getNota()) {
                            CursoAprobado ca = new CursoAprobado();
                            ca.setCurso(p.getCurso().getCurso());
                            ca.setFecha(new Date());
                            ca.setAprobado(true);
                            ca.setEstudiante(ie.getEstudiante());
                            String nota = String.valueOf(re.getNota()) + "/" + String.valueOf(e.getNotaApro());
                            ie.getEstudiante().CursoAprobado(ca, nota);
                        }
                    }
                    if (subirNota_chkFecha.isSelected()) {
                        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
                        Date fecha = date.parse(subirNota_fechaMuestra.getText());
                        e.setFecha(fecha);
                    }
                    Fabrica.getInstance().getContDocente().subirNotasExamen(e);
                    this.Volver();
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto", "Error", WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_aceptar_subirNotaExamenActionPerformed

    private void subirNota_chkFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirNota_chkFechaActionPerformed
        if (subirNota_chkFecha.isSelected()) {
            subirNota_fechaMuestra.setEditable(true);
        } else {
            subirNota_fechaMuestra.setEditable(false);
        }
    }//GEN-LAST:event_subirNota_chkFechaActionPerformed

    private void subirNota_btnAgregarParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirNota_btnAgregarParcialActionPerformed
        if (subirNota_EstudiantesParcial.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un estudiante", "Error", WARNING_MESSAGE);
        } else {
            if(((int) subirNota_notaParcial.getValue()) > p.getNotaMaxima()){
                JOptionPane.showMessageDialog(this, "La nota maxima es " + String.valueOf(p.getNotaMaxima()) +" puntos" , "Error", WARNING_MESSAGE);
            }else{
                DefaultTableModel modelo = (DefaultTableModel) subirNota_EstudiantesParcial.getModel();
                InscripcionC ic = (InscripcionC) modelo.getValueAt(subirNota_EstudiantesParcial.getSelectedRow(), 0);
                ResultadoP res = new ResultadoP();
                res.setFecha(new Date());
                res.setNota((int) subirNota_notaParcial.getValue());
                res.setEstudiante(ic.getEstudiante());
                DefaultTableModel modelo2 = (DefaultTableModel) subirNota_notasParcial.getModel();
                Object[] datos = {null};
                if (p.getInstancia().equals("Segundo")) {
                    String aprobado = "Aprobado";
                    if (res.getNota() + res.getEstudiante().AprobacionParcial(p).getNota() < p.getCurso().getDerechoExamen()) {
                        aprobado = "Reprobado";
                    } else {
                        if (res.getNota() + res.getEstudiante().AprobacionParcial(p).getNota() < p.getCurso().getAproParciales()) {
                            aprobado = "Derecho a Examen";
                        }
                    }
                    Object[] aux = {res, ic, ic.getEstudiante().getCi(), ic.getEstudiante().getNombres() + " " + ic.getEstudiante().getApellidos(), res.getNota(), aprobado};
                    datos = aux;
                } else {
                    subirNota_notasParcial.getColumnModel().removeColumn(subirNota_notasParcial.getColumnModel().getColumn(subirNota_notasParcial.getColumnModel().getColumnCount() - 1));
                    Object[] aux = {res, ic, ic.getEstudiante().getCi(), ic.getEstudiante().getNombres() + " " + ic.getEstudiante().getApellidos(), res.getNota()};
                    datos = aux;
                }
                modelo2.addRow(datos);
                resizeColumnWidth(subirNota_notasParcial);
                modelo.removeRow(subirNota_EstudiantesParcial.getSelectedRow());
                subirNota_notaParcial.setValue(((SpinnerNumberModel) subirNota_notaParcial.getModel()).getMinimum());
            }
        }
    }//GEN-LAST:event_subirNota_btnAgregarParcialActionPerformed

    private void btn_cancelar_subirNotaParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_subirNotaParcialActionPerformed
        if (volver.size() > 1) {
            CardLayout cl = (CardLayout) (PanelPrincipal.getLayout());
            String ultimaVentana = (String) volver.get(volver.size() - 2)[0]; //el 0 tiene el panel principal
            JPanel ultimaOpcion = (JPanel) volver.get(volver.size() - 2)[1]; //el 1 el tiene panel lateral
            cl.show(PanelPrincipal, ultimaVentana); //la ultima ventana visitada es el anteultimo agregado, el ultimo es el actual
            resaltarOpcioneleccionada(ultimaOpcion);
            volver.remove(volver.size() - 1); //borrar la ventana actual
        }
    }//GEN-LAST:event_btn_cancelar_subirNotaParcialActionPerformed

    private void subirNota_EliminarParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirNota_EliminarParcialActionPerformed
        if (subirNota_notasParcial.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar la nota de un estudiante para borrar", "Error", WARNING_MESSAGE);
        } else {
            DefaultTableModel modelo = (DefaultTableModel) subirNota_notasParcial.getModel();
            InscripcionC ic = (InscripcionC) modelo.getValueAt(subirNota_notasParcial.getSelectedRow(), 1);
            DefaultTableModel modelo2 = (DefaultTableModel) subirNota_EstudiantesParcial.getModel();
            Object[] datos = {ic, ic.getEstudiante().getCi(), ic.getEstudiante().getNombres() + " " + ic.getEstudiante().getApellidos()};
            resizeColumnWidth(subirNota_notasParcial);
            modelo2.addRow(datos);
            modelo.removeRow(subirNota_notasParcial.getSelectedRow());
        }
    }//GEN-LAST:event_subirNota_EliminarParcialActionPerformed

    private void btn_aceptar_subirNotaParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar_subirNotaParcialActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(this, "¿Estás seguro de guardar las notas?"
                + "\nLuego no se podrán editar", "", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            DefaultTableModel modelo = (DefaultTableModel) subirNota_notasParcial.getModel();
            if (modelo.getRowCount() > 0) {
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    ResultadoP nota = (ResultadoP) modelo.getValueAt(i, 0);
                    nota.setParcial(p);
                    p.setNota(nota);
                    if (p.getInstancia().equals("Segundo")) {
                        ResultadoP notaAnterior = nota.getEstudiante().AprobacionParcial(p);
                        if (notaAnterior.getNota() + nota.getNota() > p.getCurso().getAproParciales()) {
                            CursoAprobado ca = new CursoAprobado();
                            ca.setCurso(p.getCurso().getCurso());
                            ca.setFecha(new Date());
                            ca.setAprobado(true);
                            ca.setEstudiante(nota.getEstudiante());
                            String notaEst = String.valueOf(nota.getNota() + notaAnterior.getNota()) + "/" + String.valueOf(p.getCurso().getMaxParciales());
                            nota.getEstudiante().CursoAprobado(ca, notaEst);
                        } else {
                            if (notaAnterior.getNota() + nota.getNota() > p.getCurso().getDerechoExamen()) {
                                CursoAprobado ca = new CursoAprobado();
                                ca.setCurso(p.getCurso().getCurso());
                                ca.setFecha(new Date());
                                ca.setAprobado(false);
                                ca.setEstudiante(nota.getEstudiante());
                                String notaEst = String.valueOf(nota.getNota() + notaAnterior.getNota()) + "/" + String.valueOf(p.getCurso().getMaxParciales());
                                nota.getEstudiante().CursoAprobado(ca, notaEst);
                            }
                        }
                    }
                }
                Fabrica.getInstance().getContDocente().subirNotasParcial(p);
                this.Volver();
            }
        }
    }//GEN-LAST:event_btn_aceptar_subirNotaParcialActionPerformed

    private void MisExmenesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MisExmenesRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MisExmenesRadioButtonActionPerformed

    private void VerCursosPerfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerCursosPerfilButtonActionPerformed
        opcionSeleccionada(CursosOpcion, "cursos");
        DictandoRadioButton.setSelected(true);
    }//GEN-LAST:event_VerCursosPerfilButtonActionPerformed

    private void VerExamenesPerfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerExamenesPerfilButtonActionPerformed
        opcionSeleccionada(ExamenesOpcion, "examenes");
        MisExmenesRadioButton.setSelected(true);
    }//GEN-LAST:event_VerExamenesPerfilButtonActionPerformed

    private void VerParcialesPerfilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerParcialesPerfilButtonActionPerformed
        opcionSeleccionada(ParcialesOpcion, "parciales");
        MisParcialesRadioButton.setSelected(true);
    }//GEN-LAST:event_VerParcialesPerfilButtonActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        if (Fabrica.getInstance().getContEdu().getSede() != null) {
            opcionSeleccionada(null, "verPerfil");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede");
        }
    }//GEN-LAST:event_jLabel15MouseClicked

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
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            int row = MaterialesSubidosTable.getSelectedRow();
            DefaultTableModel modelo = (DefaultTableModel) MaterialesSubidosTable.getModel();
            Material material = (Material) modelo.getValueAt(row, 0);
            DescMaterialTextArea.setText(material.getDescripcion());
        }
    }//GEN-LAST:event_MaterialesSubidosTableKeyReleased

    private void DescargarMaterialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescargarMaterialButtonActionPerformed
        if (MaterialesSubidosTable.getSelectedRow() > -1) {
            Material material = (Material) MaterialesSubidosTable.getModel().getValueAt(MaterialesSubidosTable.getSelectedRow(), 0);
            if (material.getRutaArchivo() != null) {
                JFileChooser elegirArchivo = new JFileChooser();
                elegirArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                elegirArchivo.setAcceptAllFileFilterUsed(false);
                elegirArchivo.setDialogTitle("Seleccionar carpeta");

                int a = elegirArchivo.showDialog(this, "Seleccionar"); // guarda la accion que se realiza en el filechooser

                if (a == JFileChooser.APPROVE_OPTION) { // la accion si se le da a abrir
                    //            File archivo = elegirarchivo.getSelectedFile(); // capturar el nombre y ruta
                    //            String RutaArchivo = archivo.getPath();
                    String carpetaDestino = elegirArchivo.getSelectedFile().toString();

                    if (Fabrica.getInstance().getContEdu().descargarMaterial(carpetaDestino, material)) {
                        JOptionPane.showMessageDialog(this, "Se ha descargado el material correctamente", "Descarga completa", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Ha ocurrido un error al decargar el material, la descarga ha sido cancelada", "Descarga cancelada", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "El tema seleccionado no tiene archivo", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_DescargarMaterialButtonActionPerformed

    private void TituloArchivoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloArchivoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TituloArchivoTextFieldActionPerformed

    private void SelecArchivoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecArchivoButtonActionPerformed
        JFileChooser selecArchivo = new JFileChooser();

        //        selecArchivo.setFont(new java.awt.Font("Segoe UI", 1, 14));
        //        pestaniaCosnfig.setBackground(new java.awt.Color(255, 255, 255));
        //        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
        //        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        //        selecArchivo.setAcceptAllFileFilterUsed(false);
        if (selecArchivo.showDialog(null, "Seleccionar archivo") == JFileChooser.APPROVE_OPTION) {
            ruta = selecArchivo.getSelectedFile().getPath();
            File archivo = new File(ruta);
            if (archivo.exists()) {
                rutaArchivoLabel.setText(ruta);
            } else {
                ruta = null;
                JOptionPane.showMessageDialog(this, "Archivo incorrecto. Seleccione un archivo válido", "", WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_SelecArchivoButtonActionPerformed

    private void confirmarSubirMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarSubirMButtonActionPerformed
        String titulo = TituloArchivoTextField.getText();
        String desc = descArchTextArea.getText();
        if (ruta != null) {
            DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();
            Curso curso = (Curso) modelo.getValueAt(CursosTable.getSelectedRow(), 0);

            if (Fabrica.getInstance().getContDocente().subirMaterial(titulo, desc, ruta, curso)) {
                JOptionPane.showMessageDialog(this, "El material se subió correctamente");
                VolverButton.doClick();
                limpiarPanelSubirMaterial();
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un problema al subir el material", "", WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo");
        }
    }//GEN-LAST:event_confirmarSubirMButtonActionPerformed

    private void verExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verExamenActionPerformed
        if (ExamenesTable.getSelectedRow() != -1) {
            opcionSeleccionada(ExamenesOpcion, "verExamen");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un examen");
        }
    }//GEN-LAST:event_verExamenActionPerformed

    private void verExamen_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verExamen_tablaMouseClicked
        if (verExamen_tabla.getSelectedRow() != -1) {
            InscripcionE ie = (InscripcionE) verExamen_tabla.getModel().getValueAt(verExamen_tabla.getSelectedRow(), 0);
            verExamen_datosEstudiante.setText(ie.toString());
        }
    }//GEN-LAST:event_verExamen_tablaMouseClicked

    private void verParcial_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verParcial_tablaMouseClicked
        if (verParcial_tabla.getSelectedRow() != -1) {
            ResultadoP rp = (ResultadoP) verParcial_tabla.getModel().getValueAt(verParcial_tabla.getSelectedRow(), 0);
            verParcial_datosEstudiante.setText(rp.toString());
        }
    }//GEN-LAST:event_verParcial_tablaMouseClicked

    private void verParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verParcialActionPerformed
        if (ParcialesTable.getSelectedRow() != -1) {
            opcionSeleccionada(ParcialesOpcion, "verParcial");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un parcial");
        }
    }//GEN-LAST:event_verParcialActionPerformed

    private void VerMaterialSubidoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerMaterialSubidoButtonActionPerformed
        opcionSeleccionada(CursosOpcion, "verMaterial");
    }//GEN-LAST:event_VerMaterialSubidoButtonActionPerformed

    private void EnSedeSelecRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EnSedeSelecRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            opcionSeleccionada(EstadisticasOpcion, "estadisticas");
        }
    }//GEN-LAST:event_EnSedeSelecRadioButtonItemStateChanged

    private void EnSedeSelecRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnSedeSelecRadioButtonActionPerformed

    }//GEN-LAST:event_EnSedeSelecRadioButtonActionPerformed

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

    private void EnSedeCarrRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnSedeCarrRadioButtonActionPerformed

    }//GEN-LAST:event_EnSedeCarrRadioButtonActionPerformed

    private void EnTodasCarrRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EnTodasCarrRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            opcionSeleccionada(CarrerasOpcion, "estadisticasCarrera");
        }
    }//GEN-LAST:event_EnTodasCarrRadioButtonItemStateChanged

    private void EnTodasCarrRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnTodasCarrRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnTodasCarrRadioButtonActionPerformed

    private void EnSelecCursoRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EnSelecCursoRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            opcionSeleccionada(CursosOpcion, "estadisticasCurso");
        }
    }//GEN-LAST:event_EnSelecCursoRadioButtonItemStateChanged

    private void EnSelecCursoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnSelecCursoRadioButtonActionPerformed

    }//GEN-LAST:event_EnSelecCursoRadioButtonActionPerformed

    private void EnTodasCursoRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EnTodasCursoRadioButtonItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            opcionSeleccionada(CursosOpcion, "estadisticasCurso");
        }
    }//GEN-LAST:event_EnTodasCursoRadioButtonItemStateChanged

    private void EnTodasCursoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnTodasCursoRadioButtonActionPerformed

    }//GEN-LAST:event_EnTodasCursoRadioButtonActionPerformed

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

    private void InscripcionCButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscripcionCButton1ActionPerformed
        if (CursosTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un curso", "Advertencia", WARNING_MESSAGE);
        } else {
            opcionSeleccionada(CursosOpcion, "estadisticasCurso");            
        }
    }//GEN-LAST:event_InscripcionCButton1ActionPerformed

    private void btnEstadCarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadCarrActionPerformed
        if (CarreraTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una carrera", "Advertencia", WARNING_MESSAGE);
        } else {
            opcionSeleccionada(CarrerasOpcion, "estadisticasCarrera");            
        }
    }//GEN-LAST:event_btnEstadCarrActionPerformed

    private void notificacionIconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificacionIconoMouseClicked
        opcionSeleccionada(null, "notificaciones");
    }//GEN-LAST:event_notificacionIconoMouseClicked

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

    //opcionSelec = panel lateral seleccionado a cambiar de color, si es null es un panel del principal
    void opcionSeleccionada(JPanel opcionSelec, String opcion) {
        CardLayout cl = (CardLayout) (PanelPrincipal.getLayout());

        if (opcionSelec != null) {
            resaltarOpcioneleccionada(opcionSelec);
        }

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
            case "subir nota examen":
                this.setTitle("Menú: Exámenes");
                break;
            case "subir nota parcial":
                this.setTitle("Menú: Parciales");
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
                this.MostrarExamen();
                this.setTitle("Menú: Exámenes");
                break;
            case "verParcial":
                this.MostrarParcial();
                this.setTitle("Menú: Exámenes");
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
                if (curso.getPrevias() != null && !curso.getPrevias().isEmpty()) {
                    for (Previa p : curso.getPrevias()) {
                        String aprobacion = "Con derecho a examen";
                        if (p.isExamenAprobado()) {
                            aprobacion = "Curso Aprobado";
                        }
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
            case "subirMaterial":
                limpiarPanelSubirMaterial();
                modelo = (DefaultTableModel) CursosTable.getModel();
                Curso cursoM = (Curso) modelo.getValueAt(CursosTable.getSelectedRow(), 0);
                CursoMaterialLabel.setText(cursoM.getNombre());
                break;
            case "verPerfil":
                Docente docente = Fabrica.getInstance().getContDocente().getLogin();
                nombrePerfilLabel.setText(docente.getNombres() + " " + docente.getApellidos());
                idPerfilLabel.setText(docente.getId());
                fechaNacPerfilLabel.setText(dateFormat.format(docente.getFechaNac()));
                ciPefilLabel.setText(docente.getCi());
                emailPerfilLabel.setText(docente.getEmail());
                this.setTitle("Menú: Ver Perfil");
                break;
            case "verMaterial":
                listarMateriales();
                this.setTitle("Menú: Material Subido");
                break;
            case "notificaciones":  
                List<Notificacion> notificaciones = Fabrica.getInstance().getContDocente().getLogin().getNotificaciones();
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
        }

        if (control) {
            cl.show(PanelPrincipal, opcion);
            Object[] v = {opcion, opcionSelec};
            volver.add(v);
        }
    }

    public void resaltarOpcioneleccionada(JPanel opcionSelec) {
        for (JPanel opcionAux : opciones) {
            if (opcionAux.equals(opcionSelec)) {
                opcionAux.setBackground(Color.decode("#4a9f6e"));
            } else {
                opcionAux.setBackground(Color.decode("#1d8348"));
            }
        }
    }

    public void listarCursos(String buscar) {

        IContEducacion contEdu = Fabrica.getInstance().getContEdu();
        List<Curso> lista = new ArrayList<>();

        if (TodosRadioButton.isSelected()) {
            lista = contEdu.listarCursos(buscar); // parametro de busqueda, si es vacia lista todo
        } else {
            lista = contEdu.listarCursosDictando(buscar); // parametro de busqueda, si es vacia lista todo
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

        if (TodosExRadioButton.isSelected()) {
            examenes = Fabrica.getInstance().getContEdu().listarExamenes(buscar);
        } else {
            examenes = Fabrica.getInstance().getContEdu().listarExamenesDoc(buscar);
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
                if (e.getFechaMuestra() == null) {
                    Object[] datos = {e, nombreCurso, dateFormat.format(e.getFecha()), dateFormat.format(e.getInicioInsripcion()), dateFormat.format(e.getFinInsripcion()), "No disponible aún"};
                    modelo.addRow(datos);
                } else {
                    Object[] datos = {e, nombreCurso, dateFormat.format(e.getFecha()), dateFormat.format(e.getInicioInsripcion()), dateFormat.format(e.getFinInsripcion()), dateFormat.format(e.getFechaMuestra())};
                    modelo.addRow(datos);
                }
            }
        }
    }

    private void listarParciales(String buscar) {
        List<Parcial> parciales;

        if (TodosParRadioButton.isSelected()) {
            parciales = Fabrica.getInstance().getContEdu().listarParciales(buscar);
        } else {
            parciales = Fabrica.getInstance().getContEdu().listarParcialesDoc(buscar);
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

        if (BuscarNoticia.getText().equals("")) {
            noticias = Fabrica.getInstance().getContEdu().listarNoticias();
        } else {
            noticias = Fabrica.getInstance().getContEdu().listarNoticias(BuscarNoticia.getText());
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

    private void MostrarNoticia() {
        int index = NoticiasTable.getSelectedRow();
        if (index != -1) {
            Noticia n = (Noticia) NoticiasTable.getModel().getValueAt(index, 0);
            verNoticia_titulo.setText(n.getTitulo());
            verNoticia_fecha.setText(dateFormat.format(n.getFecha()));
            verNoticia_texto.setText(n.getTexto());
            DefaultListModel model = new DefaultListModel();
            for (String etiqueta : n.getEtiquetas()) {
                model.addElement(etiqueta);
            }
            verNoticia_etiquetas.setModel(model);
            opcionSeleccionada(NoticiasPanel, "ver noticia");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una noticia", "Error", WARNING_MESSAGE);
        }
    }

    public void subirNotaExamen() throws InternalException {
        Examen e = (Examen) ExamenesTable.getModel().getValueAt(ExamenesTable.getSelectedRow(), 0);
        if (Fabrica.getInstance().getContDocente().isEditableExamen(e) && e.editable()) {
            subirNota_Titulo.setText("Examen de " + e.getCurso().getCurso().getNombre() + " del dia " + dateFormat.format(e.getFecha()));
            subirNota_notaApro.setText(String.valueOf(e.getNotaApro()));
            subirNota_notaMax.setText(String.valueOf(e.getNotaMax()));
            subirNota_nota.setValue(((SpinnerNumberModel) subirNota_nota.getModel()).getMinimum());
            DefaultTableModel modelo = (DefaultTableModel) subirNota_Estudiantes.getModel();
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            for (InscripcionE ie : e.getEstudiantesInscritos()) {
                if (ie.isHabilitado()) {
                    Object[] datos = {ie, ie.getEstudiante().getCi(), ie.getEstudiante().getNombres() + " " + ie.getEstudiante().getApellidos()};
                    modelo.addRow(datos);
                }
            }
            modelo = (DefaultTableModel) subirNota_notas.getModel();
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            resizeColumnWidth(subirNota_Estudiantes);
        } else {
            throw new InternalException("No puede editar el examen");
        }
    }

    public void subirNotaParcial() throws InternalException {
        p = (Parcial) ParcialesTable.getModel().getValueAt(ParcialesTable.getSelectedRow(), 0);
        if (Fabrica.getInstance().getContDocente().isEditableParcial(p) && p.editable()) {
            subirNota_TituloParcial.setText(p.getInstancia() + " parcial de " + p.getCurso().getCurso().getNombre() + " del dia " + dateFormat.format(p.getFecha()));
            subirNota_notaParcial.setValue(((SpinnerNumberModel) subirNota_notaParcial.getModel()).getMinimum());
            DefaultTableModel modelo = (DefaultTableModel) subirNota_EstudiantesParcial.getModel();
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            for (InscripcionC ic : p.getCurso().getEstudiantesActuales()) {
                if (ic.isHabilitado()) {
                    Object[] datos = {ic, ic.getEstudiante().getCi(), ic.getEstudiante().getNombres() + " " + ic.getEstudiante().getApellidos()};
                    modelo.addRow(datos);
                }
            }
            modelo = (DefaultTableModel) subirNota_notasParcial.getModel();
            if (p.getInstancia().equals("Primer")) {
                subirNota_notasParcial.getColumnModel().removeColumn(subirNota_notasParcial.getColumnModel().getColumn(5));
            }
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            resizeColumnWidth(subirNota_EstudiantesParcial);
        } else {
            throw new InternalException("No puede editar el parcial");
        }
    }

    private void limpiarPanelSubirMaterial() {
        TituloArchivoTextField.setText("");
        descArchTextArea.setText("");
        rutaArchivoLabel.setText("");
        ruta = null;
        CursoMaterialLabel.setText("");
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
                tituloMateriales.setText("Material subido para " + curso.getNombre());
                String nombreDocente = material.getDocente().getNombres() + " " + material.getDocente().getApellidos();
                Object[] datos = {material, material.getTitulo(), dateFormat.format(material.getFechaSubida()), nombreDocente};
                modelo.addRow(datos);
            }
        }

        resizeColumnWidth(MaterialesSubidosTable);
    }

    void MostrarExamen() {
        Examen e = (Examen) ExamenesTable.getModel().getValueAt(ExamenesTable.getSelectedRow(), 0);
        verExamen_titulo.setText("Examen de " + e.getCurso().getCurso().getNombre() + " de la carrera "
                + e.getCurso().getCurso().getCarrera().getNombre());
        verExamen_fecha.setText(dateFormat.format(e.getFecha()));
        verExamen_notaAprobacion.setText(String.valueOf(e.getNotaApro()));
        verExamen_notaTotal.setText(String.valueOf(e.getNotaMax()));
        verExamen_datosEstudiante.setText("");
        DefaultTableModel modelo = (DefaultTableModel) verExamen_tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        for (InscripcionE ie : e.getEstudiantesInscritos()) {
            Object[] o = {ie, ie.getEstudiante().getCi(), ie.getEstudiante().getNombres() + " " + ie.getEstudiante().getApellidos()};
            modelo.addRow(o);
        }
        resizeColumnWidth(verExamen_tabla);
    }

    void MostrarParcial() {
        Parcial p = (Parcial) ParcialesTable.getModel().getValueAt(ParcialesTable.getSelectedRow(), 0);
        verParcial_titulo.setText(p.getInstancia() + " parcial de " + p.getCurso().getCurso().getNombre() + " de la carrera "
                + p.getCurso().getCurso().getCarrera().getNombre());
        verParcial_fecha.setText(dateFormat.format(p.getFecha()));
        verParcial_notaTotal.setText(String.valueOf(p.getNotaMaxima()));
        DefaultTableModel modelo = (DefaultTableModel) verParcial_tabla.getModel();
        verParcial_datosEstudiante.setText("");
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (p.getNotasEstudiantes() != null) {
            for (ResultadoP rp : p.getNotasEstudiantes()) {
                Object[] o = {rp, rp.getEstudiante().getCi(), rp.getEstudiante().getNombres() + " " + rp.getEstudiante().getApellidos()};
                modelo.addRow(o);
            }
        }
        resizeColumnWidth(verParcial_tabla);
    }

    void Volver() {
        if (volver.size() > 1) {
            CardLayout cl = (CardLayout) (PanelPrincipal.getLayout());
            String ultimaVentana = (String) volver.get(volver.size() - 2)[0]; //el 0 tiene el panel principal
            JPanel ultimaOpcion = (JPanel) volver.get(volver.size() - 2)[1]; //el 1 el tiene panel lateral
            cl.show(PanelPrincipal, ultimaVentana); //la ultima ventana visitada es el anteultimo agregado, el ultimo es el actual
            resaltarOpcioneleccionada(ultimaOpcion);
            volver.remove(volver.size() - 1); //borrar la ventana actual
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
    
    public void setCantidadNotif(){
        int cant = Fabrica.getInstance().getContDocente().getLogin().cantNotifNoVista();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AuxLabel;
    private javax.swing.JLabel AuxLabel1;
    private javax.swing.JLabel AuxLabel2;
    private javax.swing.JLabel AuxLabel3;
    private javax.swing.JButton BuscarButton;
    private javax.swing.JTextField BuscarCarrera;
    private javax.swing.JTextField BuscarExamenTextField;
    private javax.swing.JTextField BuscarNoticia;
    private javax.swing.JTextField BuscarNotifiacion;
    private javax.swing.JTextField BuscarParcialTextField;
    private javax.swing.JTextField BuscarSede;
    private javax.swing.JTextField BuscarTextField;
    private javax.swing.JPanel CargandoPanel;
    private javax.swing.JTable CarreraTable;
    private javax.swing.JPanel CarrerasOpcion;
    private javax.swing.JPanel CarrerasPanel;
    private javax.swing.JLabel CreditosLabel;
    private javax.swing.JLabel CursoMaterialLabel;
    private javax.swing.JPanel CursosOpcion;
    private javax.swing.JPanel CursosPanel;
    private javax.swing.JTable CursosTable;
    private javax.swing.JTextArea DescMaterialTextArea;
    private javax.swing.JTextArea DescTextArea;
    private javax.swing.JButton DescargarMaterialButton;
    private javax.swing.JRadioButton DictandoRadioButton;
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
    private javax.swing.JTextArea HorariosTextArea;
    private javax.swing.JButton InscripcionCButton1;
    private javax.swing.JPanel MaterialesSubidosPanel;
    private javax.swing.JTable MaterialesSubidosTable;
    private javax.swing.JRadioButton MisExmenesRadioButton;
    private javax.swing.JRadioButton MisParcialesRadioButton;
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
    private javax.swing.JButton SelecArchivoButton;
    private javax.swing.JButton SeleccionarNoticia;
    private javax.swing.JButton SeleccionarSede;
    private javax.swing.JButton SubirMaterialButton;
    private javax.swing.JPanel SubirMaterialPanel;
    private javax.swing.JPanel SubirNotaExamen;
    private javax.swing.JPanel SubirNotaParcial;
    private javax.swing.JButton SubirNotasParcial;
    private javax.swing.JTextField TituloArchivoTextField;
    private javax.swing.JLabel TituloEstadisticasCarrera;
    private javax.swing.JLabel TituloEstadisticasCurso;
    private javax.swing.JLabel TituloEstadisticasSede;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JLabel TituloLabel12;
    private javax.swing.JLabel TituloLabel13;
    private javax.swing.JLabel TituloLabel14;
    private javax.swing.JLabel TituloLabel16;
    private javax.swing.JLabel TituloLabel17;
    private javax.swing.JLabel TituloLabel18;
    private javax.swing.JLabel TituloLabel19;
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
    private javax.swing.JLabel TituloLabel57;
    private javax.swing.JLabel TituloLabel58;
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
    private javax.swing.JButton btn_aceptar_subirNotaExamen;
    private javax.swing.JButton btn_aceptar_subirNotaParcial;
    private javax.swing.JButton btn_cancelar_subirNotaExamen;
    private javax.swing.JButton btn_cancelar_subirNotaParcial;
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
    private javax.swing.JLabel ciPefilLabel;
    private javax.swing.JLabel conMasApCarr;
    private javax.swing.JLabel conMasEstCarr;
    private javax.swing.JLabel conMejorPromApCarr;
    private javax.swing.JButton confirmarSubirMButton;
    private javax.swing.JLabel cursoConMasApSede;
    private javax.swing.JLabel cursoConMasEstSede;
    private javax.swing.JLabel cursoConMejorPromApSede;
    private javax.swing.JTextArea descArchTextArea;
    private javax.swing.JLabel emailPerfilLabel;
    private javax.swing.JLabel fechaNacPerfilLabel;
    private javax.swing.JLabel fechaVerNotificacion;
    private javax.swing.JLabel idPerfilLabel;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel nombrePerfilLabel;
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
    private javax.swing.JLabel rutaArchivoLabel;
    private javax.swing.JButton subirNota_Eliminar;
    private javax.swing.JButton subirNota_EliminarParcial;
    private javax.swing.JTable subirNota_Estudiantes;
    private javax.swing.JTable subirNota_EstudiantesParcial;
    private javax.swing.JLabel subirNota_Titulo;
    private javax.swing.JLabel subirNota_TituloParcial;
    private javax.swing.JButton subirNota_btnAgregar;
    private javax.swing.JButton subirNota_btnAgregarParcial;
    private javax.swing.JCheckBox subirNota_chkFecha;
    private javax.swing.JButton subirNota_examen_btn;
    private javax.swing.JFormattedTextField subirNota_fechaMuestra;
    private javax.swing.JSpinner subirNota_nota;
    private javax.swing.JLabel subirNota_notaApro;
    private javax.swing.JLabel subirNota_notaMax;
    private javax.swing.JSpinner subirNota_notaParcial;
    private javax.swing.JTable subirNota_notas;
    private javax.swing.JTable subirNota_notasParcial;
    private javax.swing.JTextArea textoVerNotificacion;
    private javax.swing.JLabel tituloMateriales;
    private javax.swing.JLabel tituloVerNotificacion;
    private javax.swing.JButton verExamen;
    private javax.swing.JTextArea verExamen_datosEstudiante;
    private javax.swing.JLabel verExamen_fecha;
    private javax.swing.JLabel verExamen_notaAprobacion;
    private javax.swing.JLabel verExamen_notaTotal;
    private javax.swing.JTable verExamen_tabla;
    private javax.swing.JLabel verExamen_titulo;
    private javax.swing.JList<String> verNoticia_etiquetas;
    private javax.swing.JLabel verNoticia_fecha;
    private javax.swing.JTextArea verNoticia_texto;
    private javax.swing.JLabel verNoticia_titulo;
    private javax.swing.JButton verParcial;
    private javax.swing.JTextArea verParcial_datosEstudiante;
    private javax.swing.JLabel verParcial_fecha;
    private javax.swing.JLabel verParcial_notaTotal;
    private javax.swing.JTable verParcial_tabla;
    private javax.swing.JLabel verParcial_titulo;
    // End of variables declaration//GEN-END:variables
}