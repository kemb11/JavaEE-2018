/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.util.Map;
import Clases.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

/**
 *
 * @author Usuario
 */
public class Admin_MenuPrincipal extends javax.swing.JFrame {

    private List<Sede> sedes = new ArrayList<>();
    private List<Carrera> carreras = new ArrayList<>();
    private List<Curso> previas = new ArrayList<>();
    private Curso cursoExamen;
    private Curso cursoParcial;
    private boolean crearCarrera = false;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Admin_MenuPrincipal() {
        initComponents();

        this.setLocationRelativeTo(null);
        // Cargar sedes existentes en el CB SEDES
        llenarListaSedes();

        CursosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        SedeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        CarreraTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        NoticiasTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        EstudiantesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DocentesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        CursosCarreraTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // ocultar la columna del objeto
        CursosTable.getColumnModel().removeColumn(CursosTable.getColumnModel().getColumn(0));
        SedeTable.getColumnModel().removeColumn(SedeTable.getColumnModel().getColumn(0));
        CarreraTable.getColumnModel().removeColumn(CarreraTable.getColumnModel().getColumn(0));
        NoticiasTable.getColumnModel().removeColumn(NoticiasTable.getColumnModel().getColumn(0));
        EstudiantesTable.getColumnModel().removeColumn(EstudiantesTable.getColumnModel().getColumn(0));
        DocentesTable.getColumnModel().removeColumn(DocentesTable.getColumnModel().getColumn(0));
        selecPreviaCurTable.getColumnModel().removeColumn(selecPreviaCurTable.getColumnModel().getColumn(0));
        selecSedeCarrTable.getColumnModel().removeColumn(selecSedeCarrTable.getColumnModel().getColumn(0));
        CursosCarreraTable.getColumnModel().removeColumn(CursosCarreraTable.getColumnModel().getColumn(0));
        MaterialesSubidosTable.getColumnModel().removeColumn(MaterialesSubidosTable.getColumnModel().getColumn(0));
        CursosTableAsociarDoc.getColumnModel().removeColumn(CursosTableAsociarDoc.getColumnModel().getColumn(0));

        // Agregar los paneles al contenedor(cardlayout)
        PanelPrincipal.add(CursosPanel, "cursos");
        PanelPrincipal.add(CarrerasPanel, "carreras");
        PanelPrincipal.add(SedesPanel, "sedes");
        PanelPrincipal.add(NoticiasPanel, "noticias");
        PanelPrincipal.add(Estudiante, "estudiante");
        PanelPrincipal.add(Estudiante_Crear, "crear estudiante");
        PanelPrincipal.add(Docente, "docente");
        PanelPrincipal.add(Docente_Crear, "crear docente");
        PanelPrincipal.add(ExamenCurso, "crear examen");
        PanelPrincipal.add(panelNuevaSede, "crear sede");
        PanelPrincipal.add(panelBorrarSede, "borrar sede");
        PanelPrincipal.add(panelModSede, "mod sede");
        PanelPrincipal.add(VerCursoPanel, "verCurso");
        PanelPrincipal.add(CrearCursoPanel, "crearCurso");
        PanelPrincipal.add(CrearCarreraPanel, "crearCarrera");
        PanelPrincipal.add(VerCarreraPanel, "verCarrera");
        PanelPrincipal.add(MaterialesSubidosPanel, "verMaterial");
        PanelPrincipal.add(AsociarDocentePanel, "asociarDocente");
        
        opciones.add(CursosOpcion);
        opciones.add(CarrerasOpcion);
        opciones.add(SedesOpcion);
        opciones.add(NoticiasOpcion);
        opciones.add(EstudiantesOpcion);
        opciones.add(DocentesOpcion);
        PanelPrincipal.add(VerNoticia, "ver noticia");
        
        opcionSeleccionada(SedesOpcion, "sedes");
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
        EstudiantesOpcion = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        DocentesOpcion = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();
        CursosPanel = new javax.swing.JPanel();
        BuscarTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        CursosTable = new javax.swing.JTable();
        VerCursoButton = new javax.swing.JButton();
        TodosRadioButton = new javax.swing.JRadioButton();
        CursandoRadioButton = new javax.swing.JRadioButton();
        AprobadosRadioButton = new javax.swing.JRadioButton();
        BuscarButton = new javax.swing.JButton();
        NuevoSurButton = new javax.swing.JButton();
        NuevoExamenCurso = new javax.swing.JButton();
        NuevosParciales = new javax.swing.JButton();
        CarrerasPanel = new javax.swing.JPanel();
        BuscarCarrera = new javax.swing.JTextField();
        VerCarrera = new javax.swing.JButton();
        btnBuscarCarrera = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        CarreraTable = new javax.swing.JTable();
        NuevaCarrButton = new javax.swing.JButton();
        SedesPanel = new javax.swing.JPanel();
        BuscarSede = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        SedeTable = new javax.swing.JTable();
        btn_abrirnuevasede = new javax.swing.JButton();
        btnBuscarSede = new javax.swing.JButton();
        SeleccionarSede1 = new javax.swing.JButton();
        NoticiasPanel = new javax.swing.JPanel();
        BuscarNoticia = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        NoticiasTable = new javax.swing.JTable();
        SeleccionarNoticia = new javax.swing.JButton();
        btnBuscarNoticia = new javax.swing.JButton();
        Estudiante = new javax.swing.JPanel();
        BuscarEstudiante = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        EstudiantesTable = new javax.swing.JTable();
        SeleccionarExamen = new javax.swing.JButton();
        btnBuscarEstudiante = new javax.swing.JButton();
        inscribirEstudiante = new javax.swing.JButton();
        panelNuevaSede = new javax.swing.JPanel();
        sede_txt_nombre = new javax.swing.JTextField();
        sede_txt_direccion = new javax.swing.JTextField();
        sede_txt_telefono = new javax.swing.JTextField();
        sede_btn_crear = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Estudiante_Crear = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        est_sede = new javax.swing.JComboBox<>();
        est_carrera = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        est_ci = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        est_nom = new javax.swing.JTextField();
        est_ape = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        est_fec = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        est_ema = new javax.swing.JTextField();
        est_btn_agregar = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        est_txt_sede = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        est_txt_carrera = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        panelBorrarSede = new javax.swing.JPanel();
        cb_listaSedes = new javax.swing.JComboBox<>();
        btn_borrarSede_1 = new javax.swing.JButton();
        panelModSede = new javax.swing.JPanel();
        selectSede = new javax.swing.JComboBox<>();
        mod_sede_nombre = new javax.swing.JTextField();
        mod_sede_direccion = new javax.swing.JTextField();
        mod_sede_telefono = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        mod_btn_confirmar = new javax.swing.JButton();
        btn_borrarSede = new javax.swing.JButton();
        Docente_Crear = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        doc_ci = new javax.swing.JFormattedTextField();
        jLabel41 = new javax.swing.JLabel();
        doc_nom = new javax.swing.JTextField();
        doc_ape = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        doc_fec = new javax.swing.JFormattedTextField();
        jLabel44 = new javax.swing.JLabel();
        doc_ema = new javax.swing.JTextField();
        doc_btn_agregar = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        Docente = new javax.swing.JPanel();
        BuscarDocentes = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        DocentesTable = new javax.swing.JTable();
        AsociarDocenteCurso = new javax.swing.JButton();
        btnBuscarDocente = new javax.swing.JButton();
        inscribirDocente = new javax.swing.JButton();
        ExamenCurso = new javax.swing.JPanel();
        exa_titulo = new javax.swing.JLabel();
        exa_fec = new javax.swing.JFormattedTextField();
        jLabel39 = new javax.swing.JLabel();
        exa_fecini = new javax.swing.JFormattedTextField();
        jLabel46 = new javax.swing.JLabel();
        exa_fecfin = new javax.swing.JFormattedTextField();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        exa_list_noselec = new javax.swing.JList<>();
        jScrollPane15 = new javax.swing.JScrollPane();
        exa_list_selec = new javax.swing.JList<>();
        exa_btn_selec = new javax.swing.JButton();
        exa_btn_deselec = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        exa_btn_aceptar = new javax.swing.JButton();
        exa_nota_apro = new javax.swing.JSpinner();
        exa_nota_tot = new javax.swing.JSpinner();
        jLabel63 = new javax.swing.JLabel();
        VerNoticia = new javax.swing.JPanel();
        verNoticia_titulo = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        verNoticia_fecha = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        verNoticia_etiquetas = new javax.swing.JList<>();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        verNoticia_texto = new javax.swing.JTextArea();
        CrearCarreraPanel = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        NombreCarrTextField = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        creditosCarrTextField = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        DescCarrTextArea = new javax.swing.JTextArea();
        crearCursoButton = new javax.swing.JButton();
        borrarCursoButton = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        SelecSedeCarrComboBox = new javax.swing.JComboBox<>();
        verSedeCarrButton = new javax.swing.JButton();
        quitarSedeCarrButton = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        selecSedeCarrTable = new javax.swing.JTable();
        jScrollPane18 = new javax.swing.JScrollPane();
        CursosCrearCarrTable = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        confirmarCarrButton = new javax.swing.JButton();
        cancelarCarrButton = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        inicioPrimerSemestre = new javax.swing.JFormattedTextField();
        inicioSegundoSemestre = new javax.swing.JFormattedTextField();
        finPrimerSemestre = new javax.swing.JFormattedTextField();
        finSegundoSemestre = new javax.swing.JFormattedTextField();
        CrearCursoPanel = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        NombreCurTextField = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        creditosCurTextField = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        DescCurTextArea = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        SemestreComboBox = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        OptativoComboBox = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        HorarioCurTextArea = new javax.swing.JTextArea();
        ConfirmarCurButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        SelecPreviaCurComboBox = new javax.swing.JComboBox<>();
        verCursoCurButton = new javax.swing.JButton();
        quitarPreviaCurButton = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        selecPreviaCurTable = new javax.swing.JTable();
        carreraCrearCurLabel = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        notaExonExCurTextField = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        notaAproCurTextField = new javax.swing.JTextField();
        VerCarreraPanel = new javax.swing.JPanel();
        NombreCarreraLabel = new javax.swing.JLabel();
        TituloLabel12 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        CursosCarreraTable = new javax.swing.JTable();
        TituloLabel13 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        descCarreraTextArea = new javax.swing.JTextArea();
        TituloLabel14 = new javax.swing.JLabel();
        TituloLabel15 = new javax.swing.JLabel();
        sedeCarreraLabel = new javax.swing.JLabel();
        TituloLabel17 = new javax.swing.JLabel();
        creditosCarrLabel = new javax.swing.JLabel();
        VerCursoPanel = new javax.swing.JPanel();
        CreditosLabel = new javax.swing.JLabel();
        OptativoLabel = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        DescTextArea = new javax.swing.JTextArea();
        jScrollPane25 = new javax.swing.JScrollPane();
        HorariosTextArea = new javax.swing.JTextArea();
        TituloLabel = new javax.swing.JLabel();
        TituloLabel7 = new javax.swing.JLabel();
        TituloLabel8 = new javax.swing.JLabel();
        TituloLabel9 = new javax.swing.JLabel();
        TituloLabel4 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        PreviasCurTable = new javax.swing.JTable();
        TituloLabel16 = new javax.swing.JLabel();
        TituloLabel18 = new javax.swing.JLabel();
        carreraCurLabel = new javax.swing.JLabel();
        TituloLabel19 = new javax.swing.JLabel();
        TituloLabel20 = new javax.swing.JLabel();
        notaExonExLabel = new javax.swing.JLabel();
        notaAprobCurLabel = new javax.swing.JLabel();
        VerMaterialSubidoButton = new javax.swing.JButton();
        MaterialesSubidosPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        MaterialesSubidosTable = new javax.swing.JTable();
        TituloLabel21 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        DescMaterialTextArea = new javax.swing.JTextArea();
        DescargarMaterialButton = new javax.swing.JButton();
        tituloMateriales = new javax.swing.JLabel();
        AsociarDocentePanel = new javax.swing.JPanel();
        BuscarTextFieldAsociarDoc = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        CursosTableAsociarDoc = new javax.swing.JTable();
        confirmarAsociarDoc = new javax.swing.JButton();
        BuscarAsociarDoc = new javax.swing.JButton();
        cancearAsociarDoc = new javax.swing.JButton();
        tituloAsociarDocente = new javax.swing.JLabel();
        MarcarParciales = new javax.swing.JPanel();
        marcarparciales_titulo = new javax.swing.JLabel();
        marcarparciales_fecha1 = new javax.swing.JFormattedTextField();
        marcarparciales_fecha2 = new javax.swing.JFormattedTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        marcarparciales_notaMax1 = new javax.swing.JSpinner();
        marcarparciales_notaMax2 = new javax.swing.JSpinner();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        marcarparciales_notaExa = new javax.swing.JSpinner();
        jLabel73 = new javax.swing.JLabel();
        marcarparciales_notaApro = new javax.swing.JSpinner();
        marcarparciales_aceptar = new javax.swing.JButton();
        PanelCabecera = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
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

        EstudiantesOpcion.setBackground(new java.awt.Color(29, 131, 72));
        EstudiantesOpcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EstudiantesOpcionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EstudiantesOpcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EstudiantesOpcionMouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/avatar.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Estudiantes");

        javax.swing.GroupLayout EstudiantesOpcionLayout = new javax.swing.GroupLayout(EstudiantesOpcion);
        EstudiantesOpcion.setLayout(EstudiantesOpcionLayout);
        EstudiantesOpcionLayout.setHorizontalGroup(
            EstudiantesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstudiantesOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        EstudiantesOpcionLayout.setVerticalGroup(
            EstudiantesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstudiantesOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstudiantesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DocentesOpcion.setBackground(new java.awt.Color(29, 131, 72));
        DocentesOpcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DocentesOpcionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DocentesOpcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DocentesOpcionMouseExited(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/avatar.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Docentes");

        javax.swing.GroupLayout DocentesOpcionLayout = new javax.swing.GroupLayout(DocentesOpcion);
        DocentesOpcion.setLayout(DocentesOpcionLayout);
        DocentesOpcionLayout.setHorizontalGroup(
            DocentesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DocentesOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DocentesOpcionLayout.setVerticalGroup(
            DocentesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DocentesOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DocentesOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelLateralLayout = new javax.swing.GroupLayout(PanelLateral);
        PanelLateral.setLayout(PanelLateralLayout);
        PanelLateralLayout.setHorizontalGroup(
            PanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CursosOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CarrerasOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SedesOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NoticiasOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EstudiantesOpcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SedeSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(DocentesOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(EstudiantesOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DocentesOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SedeSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelPrincipal.setBackground(new java.awt.Color(73, 202, 114));
        PanelPrincipal.setForeground(new java.awt.Color(255, 255, 255));
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

        TodosRadioButton.setBackground(new java.awt.Color(73, 202, 114));
        buttonGroupCursos.add(TodosRadioButton);
        TodosRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TodosRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        TodosRadioButton.setText("Todos");
        TodosRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TodosRadioButtonItemStateChanged(evt);
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

        NuevoSurButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NuevoSurButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/inscripcion_verde.png"))); // NOI18N
        NuevoSurButton.setText("Nuevo Curso");
        NuevoSurButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoSurButtonActionPerformed(evt);
            }
        });

        NuevoExamenCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NuevoExamenCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/inscripcion_verde.png"))); // NOI18N
        NuevoExamenCurso.setText("Nuevo Examen");
        NuevoExamenCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoExamenCursoActionPerformed(evt);
            }
        });

        NuevosParciales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NuevosParciales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/inscripcion_verde.png"))); // NOI18N
        NuevosParciales.setText("Marcar Parciales");
        NuevosParciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevosParcialesActionPerformed(evt);
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
                        .addComponent(NuevoSurButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NuevoExamenCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NuevosParciales))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(CursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VerCursoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NuevoSurButton)
                    .addComponent(NuevoExamenCurso)
                    .addComponent(NuevosParciales))
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

        NuevaCarrButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NuevaCarrButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/inscripcion_verde.png"))); // NOI18N
        NuevaCarrButton.setText("Nueva Carrera");
        NuevaCarrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaCarrButtonActionPerformed(evt);
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
                        .addComponent(NuevaCarrButton))
                    .addGroup(CarrerasPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(BuscarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CarrerasPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        CarrerasPanelLayout.setVerticalGroup(
            CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CarrerasPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarCarrera)
                    .addComponent(BuscarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(CarrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VerCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NuevaCarrButton))
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

        btn_abrirnuevasede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_abrirnuevasede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-square.png"))); // NOI18N
        btn_abrirnuevasede.setText("Nueva Sede");
        btn_abrirnuevasede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirnuevasedeActionPerformed(evt);
            }
        });

        btnBuscarSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarSede.setText("Buscar");
        btnBuscarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSedeActionPerformed(evt);
            }
        });

        SeleccionarSede1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SeleccionarSede1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-square.png"))); // NOI18N
        SeleccionarSede1.setText("Seleccionar");
        SeleccionarSede1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarSede1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SedesPanelLayout = new javax.swing.GroupLayout(SedesPanel);
        SedesPanel.setLayout(SedesPanelLayout);
        SedesPanelLayout.setHorizontalGroup(
            SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SedesPanelLayout.createSequentialGroup()
                .addGroup(SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SedesPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(BuscarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SedesPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SedesPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(SeleccionarSede1)
                        .addGap(33, 33, 33)
                        .addComponent(btn_abrirnuevasede)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SedesPanelLayout.setVerticalGroup(
            SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SedesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarSede)
                    .addComponent(BuscarSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3)
                .addGap(18, 18, 18)
                .addGroup(SedesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeleccionarSede1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_abrirnuevasede, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jScrollPane5)
                .addGap(18, 18, 18)
                .addComponent(SeleccionarNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelPrincipal.add(NoticiasPanel, "cardSedes");

        Estudiante.setBackground(new java.awt.Color(73, 202, 114));

        BuscarEstudiante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        EstudiantesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objeto", "CI", "Nombre", "Apellido", "Fecha de nacimiento", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(EstudiantesTable);

        SeleccionarExamen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SeleccionarExamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ver_verde.png"))); // NOI18N
        SeleccionarExamen.setText("Ver Exámen");
        SeleccionarExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarExamenActionPerformed(evt);
            }
        });

        btnBuscarEstudiante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarEstudiante.setText("Buscar");

        inscribirEstudiante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inscribirEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/inscripcion_verde.png"))); // NOI18N
        inscribirEstudiante.setText("Inscribir");
        inscribirEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscribirEstudianteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EstudianteLayout = new javax.swing.GroupLayout(Estudiante);
        Estudiante.setLayout(EstudianteLayout);
        EstudianteLayout.setHorizontalGroup(
            EstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstudianteLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(EstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EstudianteLayout.createSequentialGroup()
                        .addComponent(BuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EstudianteLayout.createSequentialGroup()
                        .addComponent(inscribirEstudiante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeleccionarExamen)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EstudianteLayout.setVerticalGroup(
            EstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstudianteLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(EstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarEstudiante)
                    .addComponent(BuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6)
                .addGap(18, 18, 18)
                .addGroup(EstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeleccionarExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inscribirEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        PanelPrincipal.add(Estudiante, "cardSedes");

        panelNuevaSede.setBackground(new java.awt.Color(73, 202, 114));

        sede_btn_crear.setText("Agregar");
        sede_btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sede_btn_crearActionPerformed(evt);
            }
        });

        jLabel24.setText("Nombre");

        jLabel25.setText("Direción");

        jLabel26.setText("Teléfono");

        javax.swing.GroupLayout panelNuevaSedeLayout = new javax.swing.GroupLayout(panelNuevaSede);
        panelNuevaSede.setLayout(panelNuevaSedeLayout);
        panelNuevaSedeLayout.setHorizontalGroup(
            panelNuevaSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaSedeLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(panelNuevaSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addGroup(panelNuevaSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sede_txt_nombre)
                        .addComponent(sede_txt_direccion)
                        .addComponent(sede_txt_telefono)
                        .addComponent(sede_btn_crear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNuevaSedeLayout.setVerticalGroup(
            panelNuevaSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaSedeLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(sede_txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(sede_txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(sede_txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sede_btn_crear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipal.add(panelNuevaSede, "card8");

        Estudiante_Crear.setBackground(new java.awt.Color(73, 202, 114));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecciona una sede:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selecciona una carrera:");

        est_sede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        est_sede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                est_sedeActionPerformed(evt);
            }
        });

        est_carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        est_carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                est_carreraActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cédula de identidad:");

        try {
            est_ci.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        est_ci.setText("");
        est_ci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                est_ciActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nombre : ");

        est_ape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                est_apeActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Apellido :");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Fecha de nacimiento:");

        try {
            est_fec.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        est_fec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                est_fecActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Email:");

        est_btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-square.png"))); // NOI18N
        est_btn_agregar.setText("Aceptar");
        est_btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                est_btn_agregarActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Datos estudiante");

        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        est_txt_sede.setEditable(false);
        est_txt_sede.setColumns(20);
        est_txt_sede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        est_txt_sede.setRows(5);
        jScrollPane1.setViewportView(est_txt_sede);

        jScrollPane7.setForeground(new java.awt.Color(255, 255, 255));

        est_txt_carrera.setEditable(false);
        est_txt_carrera.setColumns(20);
        est_txt_carrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        est_txt_carrera.setRows(5);
        jScrollPane7.setViewportView(est_txt_carrera);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Datos Sede");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Datos Carrera");

        javax.swing.GroupLayout Estudiante_CrearLayout = new javax.swing.GroupLayout(Estudiante_Crear);
        Estudiante_Crear.setLayout(Estudiante_CrearLayout);
        Estudiante_CrearLayout.setHorizontalGroup(
            Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Estudiante_CrearLayout.createSequentialGroup()
                .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Estudiante_CrearLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(est_nom)
                            .addComponent(est_ape)
                            .addComponent(est_ema)
                            .addComponent(est_fec)
                            .addComponent(est_carrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(est_ci)
                            .addComponent(est_sede, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(94, 94, 94)
                        .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jLabel22)
                                .addComponent(jScrollPane7))))
                    .addGroup(Estudiante_CrearLayout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(est_btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Estudiante_CrearLayout.setVerticalGroup(
            Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Estudiante_CrearLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Estudiante_CrearLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel23))
                    .addGroup(Estudiante_CrearLayout.createSequentialGroup()
                        .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(est_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(est_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Estudiante_CrearLayout.createSequentialGroup()
                        .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(est_ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(est_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(est_ape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(est_fec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Estudiante_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(est_ema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(est_btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        PanelPrincipal.add(Estudiante_Crear, "card7");

        panelBorrarSede.setBackground(new java.awt.Color(73, 202, 114));

        cb_listaSedes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_borrarSede_1.setText("Borrar Sede");
        btn_borrarSede_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarSede_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorrarSedeLayout = new javax.swing.GroupLayout(panelBorrarSede);
        panelBorrarSede.setLayout(panelBorrarSedeLayout);
        panelBorrarSedeLayout.setHorizontalGroup(
            panelBorrarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorrarSedeLayout.createSequentialGroup()
                .addGroup(panelBorrarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorrarSedeLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(cb_listaSedes, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorrarSedeLayout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btn_borrarSede_1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorrarSedeLayout.setVerticalGroup(
            panelBorrarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorrarSedeLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(cb_listaSedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btn_borrarSede_1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipal.add(panelBorrarSede, "card9");

        panelModSede.setBackground(new java.awt.Color(73, 202, 114));

        selectSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSedeActionPerformed(evt);
            }
        });

        jLabel27.setText("Nombre");

        jLabel28.setText("Dirección");

        jLabel29.setText("Telefono");

        mod_btn_confirmar.setText("Confirmar cambios");
        mod_btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod_btn_confirmarActionPerformed(evt);
            }
        });

        btn_borrarSede.setText("Borrar Sede");
        btn_borrarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarSedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModSedeLayout = new javax.swing.GroupLayout(panelModSede);
        panelModSede.setLayout(panelModSedeLayout);
        panelModSedeLayout.setHorizontalGroup(
            panelModSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModSedeLayout.createSequentialGroup()
                .addGroup(panelModSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModSedeLayout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(selectSede, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_borrarSede))
                    .addGroup(panelModSedeLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(panelModSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mod_btn_confirmar)
                            .addGroup(panelModSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel27)
                                .addComponent(jLabel28)
                                .addComponent(jLabel29)
                                .addComponent(mod_sede_nombre)
                                .addComponent(mod_sede_direccion)
                                .addComponent(mod_sede_telefono)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelModSedeLayout.setVerticalGroup(
            panelModSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModSedeLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(panelModSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_borrarSede))
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(mod_sede_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(mod_sede_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(mod_sede_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mod_btn_confirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipal.add(panelModSede, "card10");

        Docente_Crear.setBackground(new java.awt.Color(73, 202, 114));

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Cédula de identidad:");

        try {
            doc_ci.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        doc_ci.setText("");
        doc_ci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doc_ciActionPerformed(evt);
            }
        });

        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Nombre : ");

        doc_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doc_nomActionPerformed(evt);
            }
        });

        doc_ape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doc_apeActionPerformed(evt);
            }
        });

        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Apellido :");

        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Fecha de nacimiento:");

        try {
            doc_fec.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        doc_fec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doc_fecActionPerformed(evt);
            }
        });

        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Email:");

        doc_btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-square.png"))); // NOI18N
        doc_btn_agregar.setText("Aceptar");
        doc_btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doc_btn_agregarActionPerformed(evt);
            }
        });

        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Datos del docente");

        javax.swing.GroupLayout Docente_CrearLayout = new javax.swing.GroupLayout(Docente_Crear);
        Docente_Crear.setLayout(Docente_CrearLayout);
        Docente_CrearLayout.setHorizontalGroup(
            Docente_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Docente_CrearLayout.createSequentialGroup()
                .addGroup(Docente_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Docente_CrearLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(Docente_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44))
                        .addGap(11, 11, 11)
                        .addGroup(Docente_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(doc_nom)
                            .addComponent(doc_ape)
                            .addComponent(doc_ema)
                            .addComponent(doc_fec)
                            .addComponent(doc_ci, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Docente_CrearLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(doc_btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 448, Short.MAX_VALUE))
            .addGroup(Docente_CrearLayout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jLabel45)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Docente_CrearLayout.setVerticalGroup(
            Docente_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Docente_CrearLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Docente_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(doc_ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Docente_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(doc_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Docente_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doc_ape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Docente_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(doc_fec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Docente_CrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(doc_ema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(doc_btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );

        PanelPrincipal.add(Docente_Crear, "card7");

        Docente.setBackground(new java.awt.Color(73, 202, 114));

        BuscarDocentes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        DocentesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objeto", "CI", "Nombre", "Apellido", "Fecha de nacimiento", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(DocentesTable);

        AsociarDocenteCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AsociarDocenteCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/crear.png"))); // NOI18N
        AsociarDocenteCurso.setText("Asignar a Curso");
        AsociarDocenteCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsociarDocenteCursoActionPerformed(evt);
            }
        });

        btnBuscarDocente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarDocente.setText("Buscar");

        inscribirDocente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inscribirDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/inscripcion_verde.png"))); // NOI18N
        inscribirDocente.setText("Inscribir");
        inscribirDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscribirDocenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DocenteLayout = new javax.swing.GroupLayout(Docente);
        Docente.setLayout(DocenteLayout);
        DocenteLayout.setHorizontalGroup(
            DocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DocenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DocenteLayout.createSequentialGroup()
                        .addComponent(BuscarDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DocenteLayout.createSequentialGroup()
                        .addComponent(inscribirDocente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AsociarDocenteCurso)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DocenteLayout.setVerticalGroup(
            DocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DocenteLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(DocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarDocente)
                    .addComponent(BuscarDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AsociarDocenteCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inscribirDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(DocenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelPrincipal.add(Docente, "cardSedes");

        ExamenCurso.setBackground(new java.awt.Color(73, 202, 114));

        exa_titulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        exa_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exa_titulo.setText("Examen de ");

        try {
            exa_fec.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####-##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        exa_fec.setText("DD/MM/AAAA-hh:mm");

        jLabel39.setText("Fecha de realización:");

        try {
            exa_fecini.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel46.setText("Fecha de inicio inscripción:");

        try {
            exa_fecfin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel47.setText("Fecha de fin de inscripción:");

        jScrollPane14.setViewportView(exa_list_noselec);

        exa_list_selec.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        exa_list_selec.setToolTipText("");
        jScrollPane15.setViewportView(exa_list_selec);

        exa_btn_selec.setText(">>");
        exa_btn_selec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exa_btn_selecActionPerformed(evt);
            }
        });

        exa_btn_deselec.setText("<<");
        exa_btn_deselec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exa_btn_deselecActionPerformed(evt);
            }
        });

        jLabel48.setText("Sedes seleccionadas");

        jLabel49.setText("Sedes a seleccionar");

        jLabel50.setText("Nota de aprobación");

        jLabel51.setText("Nota total:");

        exa_btn_aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-square.png"))); // NOI18N
        exa_btn_aceptar.setText("Aceptar");
        exa_btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exa_btn_aceptarActionPerformed(evt);
            }
        });

        exa_nota_apro.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        exa_nota_tot.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel63.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 51, 51));
        jLabel63.setText("DD/MM/AAAA-hh:mm");

        javax.swing.GroupLayout ExamenCursoLayout = new javax.swing.GroupLayout(ExamenCurso);
        ExamenCurso.setLayout(ExamenCursoLayout);
        ExamenCursoLayout.setHorizontalGroup(
            ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamenCursoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExamenCursoLayout.createSequentialGroup()
                        .addComponent(exa_btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ExamenCursoLayout.createSequentialGroup()
                            .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ExamenCursoLayout.createSequentialGroup()
                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(exa_btn_selec)
                                        .addComponent(exa_btn_deselec)))
                                .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                                .addGroup(ExamenCursoLayout.createSequentialGroup()
                                    .addComponent(jLabel50)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(exa_nota_apro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(39, 39, 39)
                            .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(exa_fecfin)
                                .addComponent(exa_fec, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(exa_fecini, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addGroup(ExamenCursoLayout.createSequentialGroup()
                                    .addComponent(jLabel51)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                    .addComponent(exa_nota_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ExamenCursoLayout.createSequentialGroup()
                                    .addComponent(jLabel48)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ExamenCursoLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(exa_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(412, 412, 412))
        );
        ExamenCursoLayout.setVerticalGroup(
            ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamenCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exa_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exa_fec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exa_fecini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exa_fecfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExamenCursoLayout.createSequentialGroup()
                        .addComponent(exa_btn_selec)
                        .addGap(72, 72, 72)
                        .addComponent(exa_btn_deselec))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(ExamenCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addComponent(exa_nota_apro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exa_nota_tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(exa_btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );

        PanelPrincipal.add(ExamenCurso, "card15");

        VerNoticia.setBackground(new java.awt.Color(73, 202, 114));

        verNoticia_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verNoticia_titulo.setToolTipText("");
        verNoticia_titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel30.setText("Fecha de creación:");

        verNoticia_fecha.setText("jLabel3");

        verNoticia_etiquetas.setEnabled(false);
        jScrollPane19.setViewportView(verNoticia_etiquetas);

        jLabel62.setText("Etiquetas");

        verNoticia_texto.setEditable(false);
        verNoticia_texto.setColumns(20);
        verNoticia_texto.setRows(5);
        jScrollPane20.setViewportView(verNoticia_texto);

        javax.swing.GroupLayout VerNoticiaLayout = new javax.swing.GroupLayout(VerNoticia);
        VerNoticia.setLayout(VerNoticiaLayout);
        VerNoticiaLayout.setHorizontalGroup(
            VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerNoticiaLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VerNoticiaLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verNoticia_fecha)
                            .addComponent(verNoticia_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(VerNoticiaLayout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(348, 348, 348))
        );
        VerNoticiaLayout.setVerticalGroup(
            VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerNoticiaLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(verNoticia_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verNoticia_fecha)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerNoticiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerNoticia, "card11");

        CrearCarreraPanel.setBackground(new java.awt.Color(73, 202, 114));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Nombre:");

        NombreCarrTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Créditos:");

        creditosCarrTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        creditosCarrTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditosCarrTextFieldActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Descripción:");

        DescCarrTextArea.setColumns(20);
        DescCarrTextArea.setRows(5);
        jScrollPane16.setViewportView(DescCarrTextArea);

        crearCursoButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        crearCursoButton.setText("Agregar");
        crearCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCursoButtonActionPerformed(evt);
            }
        });

        borrarCursoButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        borrarCursoButton.setText("Borrar");
        borrarCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarCursoButtonActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Seleccionar sede:");

        SelecSedeCarrComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SelecSedeCarrComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        SelecSedeCarrComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelecSedeCarrComboBoxActionPerformed(evt);
            }
        });

        verSedeCarrButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verSedeCarrButton.setText("Ver sede");
        verSedeCarrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verSedeCarrButtonActionPerformed(evt);
            }
        });

        quitarSedeCarrButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quitarSedeCarrButton.setText("Quitar");
        quitarSedeCarrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarSedeCarrButtonActionPerformed(evt);
            }
        });

        selecSedeCarrTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objeto", "Sede"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane17.setViewportView(selecSedeCarrTable);

        CursosCrearCarrTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Creditos", "Semestre", "Optativo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane18.setViewportView(CursosCrearCarrTable);

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Cursos:");

        confirmarCarrButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirmarCarrButton.setText("Confirmar");
        confirmarCarrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarCarrButtonActionPerformed(evt);
            }
        });

        cancelarCarrButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelarCarrButton.setText("Cancelar");
        cancelarCarrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCarrButtonActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Períodos de inscripcion:");

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("1er semestre - Inicio:");

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("1er semestre - Fin:");

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("2do semestre - Inicio:");

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("2do semestre - Fin:");

        try {
            inicioPrimerSemestre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            inicioSegundoSemestre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            finPrimerSemestre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            finSegundoSemestre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout CrearCarreraPanelLayout = new javax.swing.GroupLayout(CrearCarreraPanel);
        CrearCarreraPanel.setLayout(CrearCarreraPanelLayout);
        CrearCarreraPanelLayout.setHorizontalGroup(
            CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                        .addComponent(quitarSedeCarrButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                        .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel52)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(NombreCarrTextField))
                                .addComponent(jLabel54)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                                .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel53)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(creditosCarrTextField)))
                            .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel55)
                                    .addGap(14, 14, 14)
                                    .addComponent(SelecSedeCarrComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(verSedeCarrButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane18)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearCarreraPanelLayout.createSequentialGroup()
                                .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel58)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(inicioPrimerSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel59)
                                        .addGap(18, 18, 18))
                                    .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel57)
                                        .addGap(266, 266, 266)))
                                .addComponent(finPrimerSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102))
                            .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                                .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel56)
                                    .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                                        .addComponent(crearCursoButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(borrarCursoButton))
                                    .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(inicioSegundoSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel61)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(finSegundoSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearCarreraPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelarCarrButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmarCarrButton)))
                .addContainerGap())
        );
        CrearCarreraPanelLayout.setVerticalGroup(
            CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(NombreCarrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                        .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel58)
                                .addComponent(inicioPrimerSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel53)
                                .addComponent(creditosCarrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel60)
                                .addComponent(jLabel61)
                                .addComponent(inicioSegundoSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(finSegundoSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel54))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel55)
                                    .addComponent(SelecSedeCarrComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(verSedeCarrButton))
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(crearCursoButton)
                                    .addComponent(borrarCursoButton))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitarSedeCarrButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(confirmarCarrButton)
                            .addComponent(cancelarCarrButton)))
                    .addGroup(CrearCarreraPanelLayout.createSequentialGroup()
                        .addGroup(CrearCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(finPrimerSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        PanelPrincipal.add(CrearCarreraPanel, "card12");

        CrearCursoPanel.setBackground(new java.awt.Color(73, 202, 114));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Carrera:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Nombre:");

        NombreCurTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Créditos:");

        creditosCurTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        creditosCurTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditosCurTextFieldActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Descripción:");

        DescCurTextArea.setColumns(20);
        DescCurTextArea.setRows(5);
        jScrollPane10.setViewportView(DescCurTextArea);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Semestre:");

        SemestreComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SemestreComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("¿Es optativo?:");

        OptativoComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        OptativoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Horario:");

        HorarioCurTextArea.setColumns(20);
        HorarioCurTextArea.setRows(5);
        jScrollPane11.setViewportView(HorarioCurTextArea);

        ConfirmarCurButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ConfirmarCurButton.setText("Confirmar");
        ConfirmarCurButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarCurButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Seleccionar previa:");

        SelecPreviaCurComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SelecPreviaCurComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        SelecPreviaCurComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelecPreviaCurComboBoxActionPerformed(evt);
            }
        });

        verCursoCurButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verCursoCurButton.setText("Ver curso");
        verCursoCurButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCursoCurButtonActionPerformed(evt);
            }
        });

        quitarPreviaCurButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quitarPreviaCurButton.setText("Quitar");
        quitarPreviaCurButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarPreviaCurButtonActionPerformed(evt);
            }
        });

        selecPreviaCurTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objeto", "Curso", "Tipo de previa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane13.setViewportView(selecPreviaCurTable);

        carreraCrearCurLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        carreraCrearCurLabel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Nota exoneración exámen:");

        notaExonExCurTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Nota aprobación curso:");

        notaAproCurTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        notaAproCurTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaAproCurTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearCursoPanelLayout = new javax.swing.GroupLayout(CrearCursoPanel);
        CrearCursoPanel.setLayout(CrearCursoPanelLayout);
        CrearCursoPanelLayout.setHorizontalGroup(
            CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                            .addComponent(jLabel32)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(NombreCurTextField))
                        .addComponent(jLabel34)
                        .addComponent(jScrollPane10)
                        .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                            .addComponent(jLabel33)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(creditosCurTextField))
                        .addComponent(jLabel37)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                            .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel36)
                                .addComponent(jLabel35))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(OptativoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SemestreComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                        .addComponent(ConfirmarCurButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(carreraCrearCurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                            .addComponent(jLabel38)
                            .addGap(14, 14, 14)
                            .addComponent(SelecPreviaCurComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(verCursoCurButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(quitarPreviaCurButton)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                        .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel64))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notaAproCurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notaExonExCurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        CrearCursoPanelLayout.setVerticalGroup(
            CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                        .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(NombreCurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(creditosCurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(SemestreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(OptativoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel37))
                    .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                        .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(carreraCrearCurLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(SelecPreviaCurComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verCursoCurButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quitarPreviaCurButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ConfirmarCurButton)
                            .addComponent(jButton2)))
                    .addGroup(CrearCursoPanelLayout.createSequentialGroup()
                        .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(notaExonExCurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CrearCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(notaAproCurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55))
        );

        PanelPrincipal.add(CrearCursoPanel, "card12");

        VerCarreraPanel.setBackground(new java.awt.Color(73, 202, 114));

        NombreCarreraLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        NombreCarreraLabel.setForeground(new java.awt.Color(255, 255, 255));
        NombreCarreraLabel.setText("Nombre");

        TituloLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel12.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel12.setText("Créditos:");

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

        TituloLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel13.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel13.setText("Cursos:");

        descCarreraTextArea.setEditable(false);
        descCarreraTextArea.setColumns(20);
        descCarreraTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descCarreraTextArea.setLineWrap(true);
        jScrollPane23.setViewportView(descCarreraTextArea);

        TituloLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel14.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel14.setText("Descripción:");

        TituloLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel15.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel15.setText("Sede:");

        sedeCarreraLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sedeCarreraLabel.setForeground(new java.awt.Color(255, 255, 255));

        TituloLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel17.setForeground(new java.awt.Color(255, 255, 255));

        creditosCarrLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        creditosCarrLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout VerCarreraPanelLayout = new javax.swing.GroupLayout(VerCarreraPanel);
        VerCarreraPanel.setLayout(VerCarreraPanelLayout);
        VerCarreraPanelLayout.setHorizontalGroup(
            VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerCarreraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addGroup(VerCarreraPanelLayout.createSequentialGroup()
                        .addGroup(VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreCarreraLabel)
                            .addGroup(VerCarreraPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(creditosCarrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TituloLabel13)
                            .addGroup(VerCarreraPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TituloLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(VerCarreraPanelLayout.createSequentialGroup()
                                .addComponent(TituloLabel15)
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
                    .addComponent(TituloLabel15)
                    .addComponent(sedeCarreraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloLabel12)
                    .addComponent(creditosCarrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerCarreraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TituloLabel14)
                    .addComponent(TituloLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TituloLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        PanelPrincipal.add(VerCarreraPanel, "card17");

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
        jScrollPane24.setViewportView(DescTextArea);

        HorariosTextArea.setEditable(false);
        HorariosTextArea.setColumns(20);
        HorariosTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        HorariosTextArea.setLineWrap(true);
        jScrollPane25.setViewportView(HorariosTextArea);

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

        TituloLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel16.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel16.setText("Previas:");

        TituloLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel18.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel18.setText("Carrera:");

        carreraCurLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        carreraCurLabel.setForeground(new java.awt.Color(255, 255, 255));

        TituloLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel19.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel19.setText("Nota aprobación:");

        TituloLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel20.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel20.setText("Nota exoneración exámen:");

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
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addComponent(jScrollPane25)
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
                        .addComponent(TituloLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carreraCurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notaAprobCurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(notaExonExLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloLabel16)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VerMaterialSubidoButton))
                .addContainerGap(111, Short.MAX_VALUE))
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
                            .addComponent(TituloLabel18)
                            .addComponent(carreraCurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(VerCursoPanelLayout.createSequentialGroup()
                                .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TituloLabel20)
                                    .addComponent(notaExonExLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TituloLabel19))
                            .addComponent(notaAprobCurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TituloLabel9)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TituloLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(VerCursoPanelLayout.createSequentialGroup()
                        .addComponent(TituloLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(VerMaterialSubidoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
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
        jScrollPane8.setViewportView(MaterialesSubidosTable);

        TituloLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TituloLabel21.setForeground(new java.awt.Color(255, 255, 255));
        TituloLabel21.setText("Descripción:");

        DescMaterialTextArea.setEditable(false);
        DescMaterialTextArea.setColumns(20);
        DescMaterialTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DescMaterialTextArea.setLineWrap(true);
        jScrollPane26.setViewportView(DescMaterialTextArea);

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
                        .addComponent(jScrollPane26)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                        .addComponent(TituloLabel21, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(tituloMateriales))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        MaterialesSubidosPanelLayout.setVerticalGroup(
            MaterialesSubidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MaterialesSubidosPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(tituloMateriales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TituloLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DescargarMaterialButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        PanelPrincipal.add(MaterialesSubidosPanel, "card15");

        AsociarDocentePanel.setBackground(new java.awt.Color(73, 202, 114));

        BuscarTextFieldAsociarDoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarTextFieldAsociarDoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscarTextFieldAsociarDocFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscarTextFieldAsociarDocFocusLost(evt);
            }
        });
        BuscarTextFieldAsociarDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarTextFieldAsociarDocKeyReleased(evt);
            }
        });

        CursosTableAsociarDoc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(CursosTableAsociarDoc);

        confirmarAsociarDoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirmarAsociarDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-square.png"))); // NOI18N
        confirmarAsociarDoc.setText("Confirmar");
        confirmarAsociarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarAsociarDocActionPerformed(evt);
            }
        });

        BuscarAsociarDoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarAsociarDoc.setText("Buscar");
        BuscarAsociarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarAsociarDocActionPerformed(evt);
            }
        });

        cancearAsociarDoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancearAsociarDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        cancearAsociarDoc.setText("Cancelar");
        cancearAsociarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancearAsociarDocActionPerformed(evt);
            }
        });

        tituloAsociarDocente.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tituloAsociarDocente.setForeground(new java.awt.Color(255, 255, 255));
        tituloAsociarDocente.setText("Asociar al docente Nombre a un curso");

        javax.swing.GroupLayout AsociarDocentePanelLayout = new javax.swing.GroupLayout(AsociarDocentePanel);
        AsociarDocentePanel.setLayout(AsociarDocentePanelLayout);
        AsociarDocentePanelLayout.setHorizontalGroup(
            AsociarDocentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AsociarDocentePanelLayout.createSequentialGroup()
                .addGroup(AsociarDocentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AsociarDocentePanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(AsociarDocentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AsociarDocentePanelLayout.createSequentialGroup()
                                .addComponent(confirmarAsociarDoc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancearAsociarDoc))
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AsociarDocentePanelLayout.createSequentialGroup()
                                .addComponent(BuscarTextFieldAsociarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BuscarAsociarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(AsociarDocentePanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(tituloAsociarDocente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AsociarDocentePanelLayout.setVerticalGroup(
            AsociarDocentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AsociarDocentePanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(tituloAsociarDocente)
                .addGap(18, 18, 18)
                .addGroup(AsociarDocentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarTextFieldAsociarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarAsociarDoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AsociarDocentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarAsociarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancearAsociarDoc))
                .addContainerGap())
        );

        PanelPrincipal.add(AsociarDocentePanel, "cardCursos");

        MarcarParciales.setBackground(new java.awt.Color(73, 202, 114));

        marcarparciales_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        marcarparciales_titulo.setForeground(new java.awt.Color(255, 255, 255));
        marcarparciales_titulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        marcarparciales_titulo.setText("jLabel66");

        try {
            marcarparciales_fecha1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####-##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        marcarparciales_fecha1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            marcarparciales_fecha2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####-##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        marcarparciales_fecha2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Fecha primer parcial :");

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Fecha segundo parcial :");

        marcarparciales_notaMax1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marcarparciales_notaMax1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        marcarparciales_notaMax2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marcarparciales_notaMax2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Nota máxima del parcial :");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Nota máxima del parcial :");

        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("DD/MM/AAAA-hh:mm");

        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("DD/MM/AAAA-hh:mm");

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Nota para ganar derecho de examen :");

        marcarparciales_notaExa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marcarparciales_notaExa.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Nota de aprobación del curso :");

        marcarparciales_notaApro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marcarparciales_notaApro.setModel(new javax.swing.SpinnerNumberModel());

        marcarparciales_aceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marcarparciales_aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-square.png"))); // NOI18N
        marcarparciales_aceptar.setText("Aceptar");
        marcarparciales_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcarparciales_aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MarcarParcialesLayout = new javax.swing.GroupLayout(MarcarParciales);
        MarcarParciales.setLayout(MarcarParcialesLayout);
        MarcarParcialesLayout.setHorizontalGroup(
            MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MarcarParcialesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(marcarparciales_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MarcarParcialesLayout.createSequentialGroup()
                        .addGroup(MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MarcarParcialesLayout.createSequentialGroup()
                                .addGroup(MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(MarcarParcialesLayout.createSequentialGroup()
                                        .addComponent(jLabel66)
                                        .addGap(29, 29, 29))
                                    .addGroup(MarcarParcialesLayout.createSequentialGroup()
                                        .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(marcarparciales_fecha1)
                                    .addComponent(marcarparciales_notaMax1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(MarcarParcialesLayout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addGap(18, 18, 18)
                                .addComponent(marcarparciales_notaExa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(marcarparciales_aceptar))
                        .addGap(105, 105, 105)
                        .addGroup(MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MarcarParcialesLayout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addGap(45, 45, 45)
                                .addComponent(marcarparciales_notaApro, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MarcarParcialesLayout.createSequentialGroup()
                                .addGroup(MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel68)
                                    .addComponent(jLabel67))
                                .addGap(33, 33, 33)
                                .addGroup(MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(marcarparciales_notaMax2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(marcarparciales_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel71))))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        MarcarParcialesLayout.setVerticalGroup(
            MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MarcarParcialesLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(marcarparciales_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcarparciales_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marcarparciales_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67))
                .addGap(18, 18, 18)
                .addGroup(MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcarparciales_notaMax1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marcarparciales_notaMax2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68)
                    .addComponent(jLabel69))
                .addGap(50, 50, 50)
                .addGroup(MarcarParcialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcarparciales_notaExa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72)
                    .addComponent(marcarparciales_notaApro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73))
                .addGap(27, 27, 27)
                .addComponent(marcarparciales_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        PanelPrincipal.add(MarcarParciales, "card21");

        PanelCabecera.setBackground(new java.awt.Color(73, 202, 114));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/perfil2.png"))); // NOI18N
        jLabel15.setToolTipText("Ver Perfil");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 833, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );
        PanelCabeceraLayout.setVerticalGroup(
            PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(VolverButton)
                    .addComponent(jLabel15))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        opcionSeleccionada(SedesOpcion, "sedes");
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
            JOptionPane.showMessageDialog(this, "Debe seleccionar un curso", "Advertencia", WARNING_MESSAGE);
        } else {
            opcionSeleccionada(CursosPanel, "verCurso");
        }
    }//GEN-LAST:event_VerCursoButtonActionPerformed

    private void InscripcionCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscripcionCButtonActionPerformed
        if (CursosTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un curso", "Advertencia", WARNING_MESSAGE);
        } else {
            DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();
            Curso curso = (Curso) modelo.getValueAt(CursosTable.getSelectedRow(), 0);

            IContEstudiante contEst = Fabrica.getInstance().getContEst();
            try {
                contEst.inscripcionCurso(curso);
                JOptionPane.showMessageDialog(this, "Se ha inscrito correctamente al curso");
            } catch (Exception ex) {
                Logger.getLogger(Admin_MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Advertencia", WARNING_MESSAGE);
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

    private void btn_abrirnuevasedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirnuevasedeActionPerformed
        opcionSeleccionada(SedesOpcion, "crear sede");
    }//GEN-LAST:event_btn_abrirnuevasedeActionPerformed

    private void BuscarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarSedeActionPerformed

    }//GEN-LAST:event_BuscarSedeActionPerformed

    private void btnBuscarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSedeActionPerformed
        this.listarSede();
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
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            listarCursos("");
        }
    }//GEN-LAST:event_TodosRadioButtonItemStateChanged

    private void CursandoRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CursandoRadioButtonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            listarCursos("");
        }
    }//GEN-LAST:event_CursandoRadioButtonItemStateChanged

    private void AprobadosRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AprobadosRadioButtonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
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
        /*if (Fabrica.getInstance().getContEdu().getSede() != null) {
            opcionSeleccionada("examenes");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede");
        }*/
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
        // TODO add your handling code here:
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
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionarExamenActionPerformed

    private void btnBuscarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarExamenActionPerformed

    }//GEN-LAST:event_btnBuscarExamenActionPerformed

    private void NoticiasOpcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoticiasOpcionMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_NoticiasOpcionMouseEntered

    private void NoticiasOpcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoticiasOpcionMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_NoticiasOpcionMouseExited

    private void InscripcionExButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscripcionExButtonActionPerformed

    }//GEN-LAST:event_InscripcionExButtonActionPerformed

    private void MisExmenesRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MisExmenesRadioButtonItemStateChanged

    }//GEN-LAST:event_MisExmenesRadioButtonItemStateChanged

    private void TodosExRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TodosExRadioButtonItemStateChanged

    }//GEN-LAST:event_TodosExRadioButtonItemStateChanged

    private void ExamenesOpcion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExamenesOpcion1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ExamenesOpcion1MouseClicked

    private void ExamenesOpcion1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExamenesOpcion1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ExamenesOpcion1MouseEntered

    private void ExamenesOpcion1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExamenesOpcion1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ExamenesOpcion1MouseExited

    private void est_ciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_est_ciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_est_ciActionPerformed

    private void est_fecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_est_fecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_est_fecActionPerformed

    private void est_apeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_est_apeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_est_apeActionPerformed

    private void est_btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_est_btn_agregarActionPerformed
        try {
            this.createEstudiante();
        } catch (InternalException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_est_btn_agregarActionPerformed

    private void sede_btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sede_btn_crearActionPerformed
        // TODO add your handling code here:
        String nombreSede = sede_txt_nombre.getText();
        String direccionSede = sede_txt_direccion.getText();
        String telefonoSede = sede_txt_telefono.getText();

        /*Fabrica f = Fabrica.getInstance();
        IContAdmin ica = f.getContAdmin();*/
        try {
            Fabrica.getInstance().getContAdmin().crearSedeVar(nombreSede, direccionSede, telefonoSede);
            opcionSeleccionada(SedesOpcion, "sedes");
        } catch (Exception e) {

        }
        
    }//GEN-LAST:event_sede_btn_crearActionPerformed

    private void SeleccionarSede1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarSede1ActionPerformed
        int index = SedeTable.getSelectedRow();
        if (index != -1) {
            Sede s = (Sede) SedeTable.getModel().getValueAt(index, 0);
            System.out.println(s.toString());
            Fabrica.getInstance().getContEdu().seleccionSede(s.getId());
            opcionSeleccionada(CursosOpcion, "cursos");
            SedeSelec.setText("<html>Sede: " + s.getNombre() + "</html>");
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado una sede");
        }
    }//GEN-LAST:event_SeleccionarSede1ActionPerformed

    private void btn_borrarSede_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarSede_1ActionPerformed
        // TODO add your handling code here:
        String nombre = cb_listaSedes.getItemAt(cb_listaSedes.getSelectedIndex());
        Fabrica.getInstance().getContAdmin().borrarSede(nombre);
    }//GEN-LAST:event_btn_borrarSede_1ActionPerformed

    private void selectSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSedeActionPerformed
        // TODO add your handling code here:
        String nombre = this.selectSede.getItemAt(selectSede.getSelectedIndex());
        Map<String, String> hm = Fabrica.getInstance().getContAdmin().getInfoSedeByNombre(nombre);
        mod_sede_direccion.setText(hm.get("direccion"));
        mod_sede_nombre.setText(hm.get("nombre"));
        mod_sede_telefono.setText(hm.get("telefono"));
    }//GEN-LAST:event_selectSedeActionPerformed

    private void mod_btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod_btn_confirmarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_mod_btn_confirmarActionPerformed

    private void btn_borrarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarSedeActionPerformed
        // TODO add your handling code here:
        String nombre = selectSede.getItemAt(selectSede.getSelectedIndex());
        Fabrica.getInstance().getContAdmin().borrarSede(nombre);
    }//GEN-LAST:event_btn_borrarSedeActionPerformed

    private void inscribirEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscribirEstudianteActionPerformed
        opcionSeleccionada(EstudiantesOpcion, "crear estudiante");
    }//GEN-LAST:event_inscribirEstudianteActionPerformed

    private void EstudiantesOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstudiantesOpcionMouseClicked
        if (Fabrica.getInstance().getContEdu().getSede() != null) {
            opcionSeleccionada(EstudiantesOpcion, "estudiante");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede");
        }
    }//GEN-LAST:event_EstudiantesOpcionMouseClicked

    private void EstudiantesOpcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstudiantesOpcionMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_EstudiantesOpcionMouseEntered

    private void EstudiantesOpcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstudiantesOpcionMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_EstudiantesOpcionMouseExited

    private void NuevoSurButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoSurButtonActionPerformed
        limpiarPanelCrearCurso();
        opcionSeleccionada(CursosOpcion, "crearCurso");
    }//GEN-LAST:event_NuevoSurButtonActionPerformed

    private void VolverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverButtonActionPerformed
        // Si es mayor a 1 porque si solo tiene 1 es el panel actual, no tiene anterior
        if (volver.size() > 1) {
            CardLayout cl = (CardLayout) (PanelPrincipal.getLayout());
            String ultimaVentana = (String) volver.get(volver.size() - 2)[0]; //el 0 tiene el panel principal
            JPanel ultimaOpcion = (JPanel) volver.get(volver.size() - 2)[1]; //el 1 el tiene panel lateral
            cl.show(PanelPrincipal, ultimaVentana); //la ultima ventana visitada es el anteultimo agregado, el ultimo es el actual
            resaltarOpcioneleccionada(ultimaOpcion);
            volver.remove(volver.size() - 1); //borrar la ventana actual
        }
    }//GEN-LAST:event_VolverButtonActionPerformed

    private void doc_ciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doc_ciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doc_ciActionPerformed

    private void doc_apeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doc_apeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doc_apeActionPerformed

    private void doc_fecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doc_fecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doc_fecActionPerformed

    private void doc_btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doc_btn_agregarActionPerformed
        try {
            this.createDocente();
        } catch (InternalException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_doc_btn_agregarActionPerformed

    private void est_carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_est_carreraActionPerformed
        int index = est_carrera.getSelectedIndex();
        if (est_carrera.getItemCount() > 0 && index != -1) {
            Carrera c = this.carreras.get(index);
            est_txt_carrera.setText(c.toString());
        }
    }//GEN-LAST:event_est_carreraActionPerformed

    private void est_sedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_est_sedeActionPerformed
        int index = est_sede.getSelectedIndex();
        if (est_sede.getItemCount() > 0 && index != -1) {
            Sede s = this.sedes.get(index);
            carreras = s.getCarreras();
            est_carrera.setEnabled(true);
            est_carrera.removeAllItems();
            for (Carrera c : carreras) {
                est_carrera.addItem(c.getNombre());
            }
            est_txt_sede.setText(s.toString());
        }
    }//GEN-LAST:event_est_sedeActionPerformed

    private void doc_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doc_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doc_nomActionPerformed

    private void DocentesOpcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DocentesOpcionMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_DocentesOpcionMouseEntered

    private void DocentesOpcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DocentesOpcionMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_DocentesOpcionMouseExited

    private void DocentesOpcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DocentesOpcionMouseClicked
        opcionSeleccionada(DocentesOpcion, "docente");
    }//GEN-LAST:event_DocentesOpcionMouseClicked

    private void AsociarDocenteCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsociarDocenteCursoActionPerformed
        if(DocentesTable.getSelectedRow() != -1)
            opcionSeleccionada(DocentesOpcion, "asociarDocente");
        else
            JOptionPane.showMessageDialog(this, "Seleccione un docente", "Advertencia", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_AsociarDocenteCursoActionPerformed

    private void inscribirDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscribirDocenteActionPerformed
        opcionSeleccionada(DocentesOpcion, "crear docente");
    }//GEN-LAST:event_inscribirDocenteActionPerformed

    private void NuevoExamenCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoExamenCursoActionPerformed
        if(CursosTable.getSelectedRow() != -1)
            opcionSeleccionada(CursosOpcion, "crear examen");
        else
            JOptionPane.showMessageDialog(this, "Seleccione un curso", "Advertencia", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_NuevoExamenCursoActionPerformed

    private void exa_btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exa_btn_aceptarActionPerformed
        try {
            crearExamen();
        } catch (InternalException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_exa_btn_aceptarActionPerformed

    private void exa_btn_deselecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exa_btn_deselecActionPerformed
        int index = exa_list_selec.getSelectedIndex();
        if(index != -1){
        DefaultListModel model2 = (DefaultListModel)exa_list_selec.getModel();
        DefaultListModel model = (DefaultListModel)exa_list_noselec.getModel();
        model.addElement(model2.get(index));
        model2.remove(index);
        }
    }//GEN-LAST:event_exa_btn_deselecActionPerformed

    private void exa_btn_selecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exa_btn_selecActionPerformed
        int index = exa_list_noselec.getSelectedIndex();
        if(index != -1){
        DefaultListModel model = (DefaultListModel)exa_list_selec.getModel();
        DefaultListModel model2 = (DefaultListModel)exa_list_noselec.getModel();
        model.addElement(model2.get(index));
        model2.remove(index);
        }
    }//GEN-LAST:event_exa_btn_selecActionPerformed

    private void NuevaCarrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaCarrButtonActionPerformed
        opcionSeleccionada(CarrerasOpcion, "crearCarrera");
        crearCarrera = true;
    }//GEN-LAST:event_NuevaCarrButtonActionPerformed

    private void creditosCarrTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditosCarrTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditosCarrTextFieldActionPerformed

    private void crearCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCursoButtonActionPerformed
        if(NombreCarrTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para la carrera", "Advertencia", WARNING_MESSAGE);
        }else{
            opcionSeleccionada(CursosOpcion, "crearCurso");
        }
    }//GEN-LAST:event_crearCursoButtonActionPerformed

    private void borrarCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarCursoButtonActionPerformed
        int fila = CursosCrearCarrTable.getSelectedRow();
        Fabrica.getInstance().getContEdu().borrarCursoNuevaCarrera(fila);
        DefaultTableModel modelo = (DefaultTableModel) CursosCrearCarrTable.getModel();
        modelo.removeRow(fila);
    }//GEN-LAST:event_borrarCursoButtonActionPerformed

    private void SelecSedeCarrComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecSedeCarrComboBoxActionPerformed
        int indexSede = SelecSedeCarrComboBox.getSelectedIndex();
        if(indexSede > 0){
            indexSede = indexSede - 1; // -1 porque el primer iten se "Seleccionar..."
            Sede sede = sedes.get(indexSede);
            if(Fabrica.getInstance().getContEdu().selecSedeCarr(sede)){
                DefaultTableModel modelo = (DefaultTableModel) selecSedeCarrTable.getModel();
                Object[] datos = {sede,sede.getNombre()};
                modelo.addRow(datos);
            }
        }
    }//GEN-LAST:event_SelecSedeCarrComboBoxActionPerformed

    private void verSedeCarrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verSedeCarrButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verSedeCarrButtonActionPerformed

    private void quitarSedeCarrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarSedeCarrButtonActionPerformed
        int fila = selecSedeCarrTable.getSelectedRow();
        if(fila >= 0){
            DefaultTableModel modelo = (DefaultTableModel) selecSedeCarrTable.getModel();
            Fabrica.getInstance().getContEdu().eliminarSedeSelec((Sede)modelo.getValueAt(fila, 0));
            modelo.removeRow(fila);
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar una sede", "Advertencia", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_quitarSedeCarrButtonActionPerformed

    private void confirmarCarrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarCarrButtonActionPerformed
        String nombre = NombreCarrTextField.getText();
        String creditosAux = creditosCarrTextField.getText();
        String descripcion = DescCarrTextArea.getText();
        String inicioPSAux = inicioPrimerSemestre.getText();
        String finPSAux = finPrimerSemestre.getText();
        String inicioSSAux = inicioSegundoSemestre.getText();
        String finSSAux = finSegundoSemestre.getText();
        
        if(nombre.isEmpty() || creditosAux.isEmpty() || descripcion.isEmpty() || 
            inicioPSAux.equals("  /  /    ") || finPSAux.equals("  /  /    ") || inicioSSAux.equals("  /  /    ") || finSSAux.equals("  /  /    ")){
            JOptionPane.showMessageDialog(this, "No pueden quedar campos vacíos", "Advertencia", WARNING_MESSAGE);
        }else{
            if(Fabrica.getInstance().getContEdu().seleccionoAlgunaSede() == false){
                JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un sede", "Advertencia", WARNING_MESSAGE);
                return; // corta aca
            }
            try {
                int creditos = Integer.valueOf(creditosAux);
                Date inicioPS = dateFormat.parse(inicioPSAux);
                Date finPS = dateFormat.parse(finPSAux);
                Date inicioSS = dateFormat.parse(inicioSegundoSemestre.getText());
                Date finSS = dateFormat.parse(finSegundoSemestre.getText());
                
                List<Date> fechas= new ArrayList<>();
                fechas.add(inicioPS);
                fechas.add(finPS);
                fechas.add(inicioSS);
                fechas.add(finSS);
                if(controlarAnioFechas(fechas)==false){
                    JOptionPane.showMessageDialog(this, "Las fechas deben ser de un mismo año calendario", "Advertencia", WARNING_MESSAGE);
                    return; // corta aca
                }

                if(inicioPS.before(new Date()) || finPS.before(new Date()) || inicioSS.before(new Date()) || finSS.before(new Date())){
                    JOptionPane.showMessageDialog(this, "Las fechas deben ser posteriores a la actual", "Advertencia", WARNING_MESSAGE);
                }else{
                    if(finPS.before(inicioPS) || finSS.before(inicioSS)){
                        JOptionPane.showMessageDialog(this, "Las fechas de fin deben ser posteriores a las de inicio", "Advertencia", WARNING_MESSAGE);
                    }else{
                        if(inicioSS.before(inicioPS) || finSS.before(finPS)){
                            JOptionPane.showMessageDialog(this, "Las fechas del segundo semestre deben ser posteriores a las del primer semestre", "Advertencia", WARNING_MESSAGE);
                        }else{
                            try{
                                Fabrica.getInstance().getContEdu().nuevaCarrera(nombre, creditos, descripcion, inicioPS,finPS,inicioSS,finSS);
                                JOptionPane.showMessageDialog(this, "Se ha creado la carrera correctamente");
                                limpiarPanelCrearCarrera();
                                VolverButton.doClick();
                            }catch (Exception ex) {
                                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", WARNING_MESSAGE);
                            }
                        }
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(Admin_MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_confirmarCarrButtonActionPerformed

    private void cancelarCarrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCarrButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarCarrButtonActionPerformed

    private void creditosCurTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditosCurTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditosCurTextFieldActionPerformed

    private void ConfirmarCurButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarCurButtonActionPerformed
        String nombre = NombreCurTextField.getText();
        String creditos = creditosCurTextField.getText();
        int semestre = SemestreComboBox.getSelectedIndex()+1; // +1 porque el index comienza en 0 y el primer item es 1
        String descripcion = DescCurTextArea.getText();
        String horario = HorarioCurTextArea.getText();
        int opt = OptativoComboBox.getSelectedIndex();
        boolean optativo;
        if(opt==0){
            optativo = false;
        }else{
            optativo = true;
        }
        
        if(nombre.isEmpty()||descripcion.isEmpty()||horario.isEmpty()||creditos.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "No pueden quedar campos vacíos", "Advertencia", WARNING_MESSAGE);
        }else{
            try {
                
                Carrera c;
                if(crearCarrera){
                    c = null; // se esta creando curso para nueva carrera, la carrera temporal se obtiene en el controlador
                }else{
                    c = (Carrera) CarreraTable.getModel().getValueAt(CarreraTable.getSelectedRow(), 0);
                }
                Fabrica.getInstance().getContEdu().nuevoCurso(nombre, Integer.valueOf(creditos), semestre, descripcion, horario, optativo, c);
                JOptionPane.showMessageDialog(this, "Se ha creado el curso correctamente");
                limpiarPanelCrearCurso();

                if(crearCarrera){
                    DefaultTableModel modelo = (DefaultTableModel) CursosCrearCarrTable.getModel();
                    Object[] datos = {nombre,Integer.valueOf(creditos),semestre,optativo};
                    modelo.addRow(datos);
                    VolverButton.doClick();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_ConfirmarCurButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiarPanelCrearCurso();
        VolverButton.doClick();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SelecPreviaCurComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecPreviaCurComboBoxActionPerformed
        int indexPrevia = SelecPreviaCurComboBox.getSelectedIndex();
        if(previas.isEmpty() == false && indexPrevia > 0){
            indexPrevia = indexPrevia - 1; // -1 porque el primer iten se "Seleccionar..."
            Curso previa = previas.get(indexPrevia);
            if(Fabrica.getInstance().getContEdu().esPrevia(previa)){
                DefaultTableModel modelo = (DefaultTableModel) selecPreviaCurTable.getModel();
                List<Curso> cursosSonPrevia = Fabrica.getInstance().getContEdu().selecSonPrevia(previa);
                if(cursosSonPrevia != null){
                    for (Curso curso : cursosSonPrevia) {
                        for (int i = 0; i < modelo.getRowCount(); i++) {
                            if(curso.equals((Curso)modelo.getValueAt(i, 0))){
                                modelo.removeRow(i);
                            }
                        }

                    }
                }

                Object[] datos = {previa,previa.getNombre(), "Curso"};
                modelo.addRow(datos);
            }
        }
    }//GEN-LAST:event_SelecPreviaCurComboBoxActionPerformed

    private void verCursoCurButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCursoCurButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verCursoCurButtonActionPerformed

    private void quitarPreviaCurButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarPreviaCurButtonActionPerformed
        int fila = selecPreviaCurTable.getSelectedRow();
        if(fila >= 0){
            DefaultTableModel modelo = (DefaultTableModel) selecPreviaCurTable.getModel();
            Fabrica.getInstance().getContEdu().eliminarPreviaSelec((Curso)modelo.getValueAt(fila, 0));
            modelo.removeRow(fila);
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar una previa", "Advertencia", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_quitarPreviaCurButtonActionPerformed

    private void notaAproCurTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaAproCurTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notaAproCurTextFieldActionPerformed

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

    private void confirmarAsociarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarAsociarDocActionPerformed
        if (CursosTableAsociarDoc.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un curso", "Advertencia", WARNING_MESSAGE);
        } else {
            Curso curso = (Curso) CursosTableAsociarDoc.getModel().getValueAt(CursosTableAsociarDoc.getSelectedRow(), 0);
            Docente docente = (Docente) DocentesTable.getModel().getValueAt(DocentesTable.getSelectedRow(), 0);
            try{
                Fabrica.getInstance().getContDocente().asociarACurso(curso, docente);
                String nomDoc = docente.getNombres()+" "+docente.getApellidos();                
                JOptionPane.showMessageDialog(this, "El docente "+nomDoc+" ahora esta a cargo del curso "+curso.getNombre()+
                        " en la sede "+Fabrica.getInstance().getContEdu().getSede().getNombre(), "Docente asignado", JOptionPane.INFORMATION_MESSAGE);
                VolverButton.doClick();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_confirmarAsociarDocActionPerformed

    private void cancearAsociarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancearAsociarDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancearAsociarDocActionPerformed

    private void BuscarAsociarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarAsociarDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarAsociarDocActionPerformed

    private void BuscarTextFieldAsociarDocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarTextFieldAsociarDocKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarTextFieldAsociarDocKeyReleased

    private void BuscarTextFieldAsociarDocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarTextFieldAsociarDocFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarTextFieldAsociarDocFocusLost

    private void BuscarTextFieldAsociarDocFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarTextFieldAsociarDocFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarTextFieldAsociarDocFocusGained

    private void NuevosParcialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevosParcialesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NuevosParcialesActionPerformed

    private void marcarparciales_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcarparciales_aceptarActionPerformed
        
    }//GEN-LAST:event_marcarparciales_aceptarActionPerformed

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel15MouseEntered

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
                this.listarSede();
                this.setTitle("Menú: Sedes");
                break;
            case "noticias":
                this.listarNoticias();
                this.setTitle("Menú: Noticias");
                break;
            case "ver noticia":
                this.setTitle("Menú: Noticias");
                break;
            case "crear estudiante":
                this.reiniciarCrearEstudiante();
                this.setTitle("Menú: Estudiate");
                break;
            case "crear docente":
                this.reiniciarCrearDocente();
                this.setTitle("Menú: Docente");
                break;
            case "crear examen":
                this.setTitle("Menú: Curso");
                this.seleccionarCursoExamen();
                break;
            case "docente":
                this.listarDocentes();
                this.setTitle("Menú: Docente");
                break;
            case "estudiante":
                this.listarEstudiante();
                this.setTitle("Menú: Estudiate");
                break;
            case "crear sede":
                this.sede_txt_telefono.setText("");
                this.sede_txt_nombre.setText("");
                this.sede_txt_direccion.setText("");
                this.setTitle("Menú: Sede");
                break;
            case "borrar sede":
                this.setTitle("Menú: Sede");
                break;
            case "mod sede":
                this.setTitle("Menú: Sede");
                break;
            case "verCurso":
                modelo = (DefaultTableModel) CursosTable.getModel();
                Curso curso = (Curso) modelo.getValueAt(CursosTable.getSelectedRow(), 0);
                String opt = "No";
                if(curso.isOptativo()){
                    opt = "Si";
                }

                notaAprobCurLabel.setText(String.valueOf(Fabrica.getInstance().getContEdu().getSede().getCurso(curso).getAproParciales()));
                notaExonExLabel.setText(String.valueOf(Fabrica.getInstance().getContEdu().getSede().getCurso(curso).getDerechoExamen()));
                TituloLabel.setText(curso.getNombre());
                CreditosLabel.setText(String.valueOf(curso.getCreditos()));
                OptativoLabel.setText(opt);
                HorariosTextArea.setText(curso.getHorarios());
                DescTextArea.setText(curso.getDescripcion());
                carreraCurLabel.setText(curso.getCarrera().getNombre());
                
                DefaultTableModel modeloPrevias = (DefaultTableModel) PreviasCurTable.getModel();
                modeloPrevias.setRowCount(0);
                for (Previa previa : curso.getPrevias()) {
                    previa.getCursoPrevia();
                    String tipoP = "Curso aprobado";
                    if(!previa.isExamenAprobado()){
                       tipoP = "Derecho a exámen";
                    }
                    Object[] datos = {previa.getCursoPrevia().getNombre(), tipoP};
                    modeloPrevias.addRow(datos);
                }                
                resizeColumnWidth(PreviasCurTable);
                
                this.setTitle("Menú: Ver Curso");
                break;
            case "crearCurso":
                if(crearCarrera == false){
                    Carrera c = (Carrera) CarreraTable.getModel().getValueAt(CarreraTable.getSelectedRow(), 0);
                    carreraCrearCurLabel.setText(c.getNombre());
                }else{ 
                    // Si no es porque se esta creando el curso dentro del crear carrera
                    carreraCrearCurLabel.setText(NombreCarrTextField.getText());
                    
                    DefaultComboBoxModel modeloCombo = (DefaultComboBoxModel) SelecPreviaCurComboBox.getModel();
                    modeloCombo.removeAllElements();
                    modeloCombo.addElement("Seleccionar...");
                    previas = Fabrica.getInstance().getContEdu().listarCursosCrearCarrera();
                    for (Curso c : previas) {
                        modeloCombo.addElement(c.getNombre());
                    }
                }
                this.setTitle("Menú: Nuevo Curso");
                break;
            case "crearCarrera":
                this.setTitle("Menú: Nuevo Carrera");
                
                DefaultComboBoxModel modeloComboSedeCarr = (DefaultComboBoxModel) SelecSedeCarrComboBox.getModel();
                modeloComboSedeCarr.removeAllElements();
                modeloComboSedeCarr.addElement("Seleccionar...");
                sedes.clear(); // limpiar la lista con las carreras
                sedes = Fabrica.getInstance().getContEdu().listarSedes();
                for (Sede s : sedes) {
                    modeloComboSedeCarr.addElement(s.getNombre());
                }
                
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
            case "verMaterial":  
                listarMateriales();
                this.setTitle("Menú: Material Subido");
                break;
            case "asociarDocente":
                IContEducacion contEdu = Fabrica.getInstance().getContEdu();
                List<Curso> lista = contEdu.listarCursos(""); // parametro de busqueda, si es vacia lista todo                

                Docente docente = (Docente) DocentesTable.getModel().getValueAt(DocentesTable.getSelectedRow(), 0);
                String nomDoc = docente.getNombres()+" "+docente.getApellidos();
                tituloAsociarDocente.setText("Asignar docente "+nomDoc+" a un curso");
                modelo = (DefaultTableModel) CursosTableAsociarDoc.getModel();

                while (modelo.getRowCount() > 0) {
                    modelo.removeRow(0);
                }

                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
                } else {
                    for (Curso cursoAD : lista) {
                        String esOptativo = "No";
                        if (cursoAD.isOptativo()) {
                            esOptativo = "Si";
                        }
                        
                        Object[] datos = {cursoAD, cursoAD.getNombre(), String.valueOf(cursoAD.getCreditos()), esOptativo, cursoAD.getCarrera().getNombre()};
                        modelo.addRow(datos);
                    }
                }

                resizeColumnWidth(CursosTable);
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

    ArrayList<Object[]> volver = new ArrayList<>();
    ArrayList<JPanel> opciones = new ArrayList<>();

    public void listarCursos(String buscar) {

        IContEducacion contEdu = Fabrica.getInstance().getContEdu();
        List<Curso> lista = new ArrayList<>();

        if (TodosRadioButton.isSelected()) {
            lista = contEdu.listarCursos(buscar); // parametro de busqueda, si es vacia lista todo
        } else {
            if (CursandoRadioButton.isSelected()) {
                lista = contEdu.listarCursosCursando(buscar); // parametro de busqueda, si es vacia lista todo
            } else {
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

    private void listarSede() {
        List<Sede> sedesAux;
        if (this.BuscarSede.getText().equals("")) {
            sedesAux = Fabrica.getInstance().getContEdu().listarSedes();
        } else {
            sedesAux = Fabrica.getInstance().getContEdu().listarSedes(this.BuscarSede.getText());
        }
        DefaultTableModel modelo = (DefaultTableModel) SedeTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (sedesAux.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Sede s : sedesAux) {
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
        this.resizeColumnWidth(CarreraTable);
    }

    private void createEstudiante() throws InternalException {
        try {
            InternetAddress correo = new InternetAddress(est_ema.getText());
            correo.validate();
            if (!est_carrera.isEnabled() || est_txt_carrera.getText().isEmpty()) {
                throw new InternalException("Seleccione sede y carrera");
            }
            if (controlCrearEstudiante()) {
                throw new InternalException("Rellene los campos");
            }
            Date fecha = null;
            try {
                fecha = dateFormat.parse(est_fec.getText());
                Estudiante e = new Estudiante();
                e.setApellidos(est_ape.getText());
                e.setNombres(est_nom.getText());
                e.setCi(est_ci.getText());
                e.setId(est_ci.getText());
                e.setEmail(est_ema.getText());
                e.setApellidos(est_ape.getText());
                e.setFechaNac(fecha);
                int index = est_carrera.getSelectedIndex();
                e.setCarrera(carreras.get(index));
                index = est_sede.getSelectedIndex();
                e.setSede(sedes.get(index));
                Fabrica.getInstance().getContAdmin().crearEstudiante(e);
                JOptionPane.showMessageDialog(this, "Se registró el estudiante", "Exito", JOptionPane.INFORMATION_MESSAGE);
                opcionSeleccionada(EstudiantesOpcion, "estudiante");
            } catch (Exception pe) {
                throw new InternalException("Fecha incorrecta");
            }

        } catch (Exception ex) {
            if (ex instanceof AddressException) {
                throw new InternalException("Formato de correo inválido");
            }
        }
    }

    private void createDocente() throws InternalException {
        try {
            InternetAddress correo = new InternetAddress(doc_ema.getText());
            correo.validate();
            if (controlCrearDocente()) {
                throw new InternalException("Rellene los campos");
            }
            Date fecha = null;
            try {
                fecha = dateFormat.parse(doc_fec.getText());
                Docente d = new Docente();
                d.setApellidos(doc_ape.getText());
                d.setNombres(doc_nom.getText());
                d.setCi(doc_ci.getText());
                d.setEmail(doc_ema.getText());
                d.setApellidos(doc_ape.getText());
                d.setFechaNac(fecha);
                Fabrica.getInstance().getContAdmin().crearDocente(d);
                JOptionPane.showMessageDialog(this, "Se registró el docente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                opcionSeleccionada(DocentesOpcion, "docente");
            } catch (Exception pe) {
                throw new InternalException("Fecha incorrecta");
            }

        } catch (Exception ex) {
            if (ex instanceof AddressException) {
                throw new InternalException("Formato de correo inválido");
            }
        }
        this.resizeColumnWidth(SedeTable);
    }

    private void llenarListaSedes() {
        List<String> ls = Fabrica.getInstance().getContAdmin().getSedes();
        for (String nombre : ls) {
            cb_listaSedes.addItem(nombre);
            selectSede.addItem(nombre);
        }
    }

    //retorna true si alguno está vacío
    private boolean controlCrearEstudiante() {
        if (est_nom.getText().isEmpty()) {
            return true;
        }
        if (est_ape.getText().isEmpty()) {
            return true;
        }
        if (est_ema.getText().isEmpty()) {
            return true;
        }
        if (est_ci.getText().isEmpty()) {
            return true;
        }
        if (est_fec.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean controlCrearDocente() {
        if (doc_nom.getText().isEmpty()) {
            return true;
        }
        if (doc_ape.getText().isEmpty()) {
            return true;
        }
        if (doc_ema.getText().isEmpty()) {
            return true;
        }
        if (doc_ci.getText().isEmpty()) {
            return true;
        }
        if (doc_fec.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    private void reiniciarCrearEstudiante() {
        est_nom.setText("");
        est_ci.setText("");
        est_ema.setText("");
        est_fec.setText("");
        est_ape.setText("");
        est_txt_carrera.setText("");
        est_txt_sede.setText("");
        est_carrera.removeAllItems();
        est_carrera.setEnabled(false);
        est_sede.removeAllItems();
        sedes = Fabrica.getInstance().getContEdu().listarSedes();
        for (Sede s : sedes) {
            est_sede.addItem(s.getNombre());
        }
    }

    private void reiniciarCrearDocente() {
        doc_nom.setText("");
        doc_ci.setText("");
        doc_ema.setText("");
        doc_fec.setText("");
        doc_ape.setText("");
    }

    private void limpiarPanelCrearCurso() {
        NombreCurTextField.setText("");
        creditosCurTextField.setText("");
        SemestreComboBox.setSelectedIndex(0);
        DescCurTextArea.setText("");
        HorarioCurTextArea.setText("");
        OptativoComboBox.setSelectedIndex(0);
    }
    
    private void limpiarPanelCrearCarrera(){
        NombreCarrTextField.setText("");
        creditosCarrTextField.setText("");
        DescCarrTextArea.setText("");
        SelecSedeCarrComboBox.setSelectedIndex(0);
        crearCarrera = false;
        inicioPrimerSemestre.setText("");
        finPrimerSemestre.setText("");
        inicioSegundoSemestre.setText("");
        finSegundoSemestre.setText("");
        DefaultTableModel modelo = (DefaultTableModel) CursosCrearCarrTable.getModel();
        modelo.setRowCount(0);
        modelo = (DefaultTableModel) selecSedeCarrTable.getModel();
        modelo.setRowCount(0);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AprobadosRadioButton;
    private javax.swing.JButton AsociarDocenteCurso;
    private javax.swing.JPanel AsociarDocentePanel;
    private javax.swing.JButton BuscarAsociarDoc;
    private javax.swing.JButton BuscarButton;
    private javax.swing.JTextField BuscarCarrera;
    private javax.swing.JTextField BuscarDocentes;
    private javax.swing.JTextField BuscarEstudiante;
    private javax.swing.JTextField BuscarNoticia;
    private javax.swing.JTextField BuscarSede;
    private javax.swing.JTextField BuscarTextField;
    private javax.swing.JTextField BuscarTextFieldAsociarDoc;
    private javax.swing.JTable CarreraTable;
    private javax.swing.JPanel CarrerasOpcion;
    private javax.swing.JPanel CarrerasPanel;
    private javax.swing.JButton ConfirmarCurButton;
    private javax.swing.JPanel CrearCarreraPanel;
    private javax.swing.JPanel CrearCursoPanel;
    private javax.swing.JLabel CreditosLabel;
    private javax.swing.JRadioButton CursandoRadioButton;
    private javax.swing.JTable CursosCarreraTable;
    private javax.swing.JTable CursosCrearCarrTable;
    private javax.swing.JPanel CursosOpcion;
    private javax.swing.JPanel CursosPanel;
    private javax.swing.JTable CursosTable;
    private javax.swing.JTable CursosTableAsociarDoc;
    private javax.swing.JTextArea DescCarrTextArea;
    private javax.swing.JTextArea DescCurTextArea;
    private javax.swing.JTextArea DescMaterialTextArea;
    private javax.swing.JTextArea DescTextArea;
    private javax.swing.JButton DescargarMaterialButton;
    private javax.swing.JPanel Docente;
    private javax.swing.JPanel Docente_Crear;
    private javax.swing.JPanel DocentesOpcion;
    private javax.swing.JTable DocentesTable;
    private javax.swing.JPanel Estudiante;
    private javax.swing.JPanel Estudiante_Crear;
    private javax.swing.JPanel EstudiantesOpcion;
    private javax.swing.JTable EstudiantesTable;
    private javax.swing.JPanel ExamenCurso;
    private javax.swing.JTextArea HorarioCurTextArea;
    private javax.swing.JTextArea HorariosTextArea;
    private javax.swing.JPanel MarcarParciales;
    private javax.swing.JPanel MaterialesSubidosPanel;
    private javax.swing.JTable MaterialesSubidosTable;
    private javax.swing.JTextField NombreCarrTextField;
    private javax.swing.JLabel NombreCarreraLabel;
    private javax.swing.JTextField NombreCurTextField;
    private javax.swing.JPanel NoticiasOpcion;
    private javax.swing.JPanel NoticiasPanel;
    private javax.swing.JTable NoticiasTable;
    private javax.swing.JButton NuevaCarrButton;
    private javax.swing.JButton NuevoExamenCurso;
    private javax.swing.JButton NuevoSurButton;
    private javax.swing.JButton NuevosParciales;
    private javax.swing.JComboBox<String> OptativoComboBox;
    private javax.swing.JLabel OptativoLabel;
    private javax.swing.JPanel PanelCabecera;
    private javax.swing.JPanel PanelLateral;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JTable PreviasCurTable;
    private javax.swing.JLabel SedeSelec;
    private javax.swing.JTable SedeTable;
    private javax.swing.JPanel SedesOpcion;
    private javax.swing.JPanel SedesPanel;
    private javax.swing.JComboBox<String> SelecPreviaCurComboBox;
    private javax.swing.JComboBox<String> SelecSedeCarrComboBox;
    private javax.swing.JButton SeleccionarExamen;
    private javax.swing.JButton SeleccionarNoticia;
    private javax.swing.JButton SeleccionarSede1;
    private javax.swing.JComboBox<String> SemestreComboBox;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JLabel TituloLabel12;
    private javax.swing.JLabel TituloLabel13;
    private javax.swing.JLabel TituloLabel14;
    private javax.swing.JLabel TituloLabel15;
    private javax.swing.JLabel TituloLabel16;
    private javax.swing.JLabel TituloLabel17;
    private javax.swing.JLabel TituloLabel18;
    private javax.swing.JLabel TituloLabel19;
    private javax.swing.JLabel TituloLabel20;
    private javax.swing.JLabel TituloLabel21;
    private javax.swing.JLabel TituloLabel4;
    private javax.swing.JLabel TituloLabel7;
    private javax.swing.JLabel TituloLabel8;
    private javax.swing.JLabel TituloLabel9;
    private javax.swing.JRadioButton TodosRadioButton;
    private javax.swing.JButton VerCarrera;
    private javax.swing.JPanel VerCarreraPanel;
    private javax.swing.JButton VerCursoButton;
    private javax.swing.JPanel VerCursoPanel;
    private javax.swing.JButton VerMaterialSubidoButton;
    private javax.swing.JPanel VerNoticia;
    private javax.swing.JButton VolverButton;
    private javax.swing.JButton borrarCursoButton;
    private javax.swing.JButton btnBuscarCarrera;
    private javax.swing.JButton btnBuscarDocente;
    private javax.swing.JButton btnBuscarEstudiante;
    private javax.swing.JButton btnBuscarNoticia;
    private javax.swing.JButton btnBuscarSede;
    private javax.swing.JButton btn_abrirnuevasede;
    private javax.swing.JButton btn_borrarSede;
    private javax.swing.JButton btn_borrarSede_1;
    private javax.swing.ButtonGroup buttonGroupCursos;
    private javax.swing.ButtonGroup buttonGroupExamenes;
    private javax.swing.JButton cancearAsociarDoc;
    private javax.swing.JButton cancelarCarrButton;
    private javax.swing.JLabel carreraCrearCurLabel;
    private javax.swing.JLabel carreraCurLabel;
    private javax.swing.JComboBox<String> cb_listaSedes;
    private javax.swing.JButton confirmarAsociarDoc;
    private javax.swing.JButton confirmarCarrButton;
    private javax.swing.JButton crearCursoButton;
    private javax.swing.JLabel creditosCarrLabel;
    private javax.swing.JTextField creditosCarrTextField;
    private javax.swing.JTextField creditosCurTextField;
    private javax.swing.JTextArea descCarreraTextArea;
    private javax.swing.JTextField doc_ape;
    private javax.swing.JButton doc_btn_agregar;
    private javax.swing.JFormattedTextField doc_ci;
    private javax.swing.JTextField doc_ema;
    private javax.swing.JFormattedTextField doc_fec;
    private javax.swing.JTextField doc_nom;
    private javax.swing.JTextField est_ape;
    private javax.swing.JButton est_btn_agregar;
    private javax.swing.JComboBox<String> est_carrera;
    private javax.swing.JFormattedTextField est_ci;
    private javax.swing.JTextField est_ema;
    private javax.swing.JFormattedTextField est_fec;
    private javax.swing.JTextField est_nom;
    private javax.swing.JComboBox<String> est_sede;
    private javax.swing.JTextArea est_txt_carrera;
    private javax.swing.JTextArea est_txt_sede;
    private javax.swing.JButton exa_btn_aceptar;
    private javax.swing.JButton exa_btn_deselec;
    private javax.swing.JButton exa_btn_selec;
    private javax.swing.JFormattedTextField exa_fec;
    private javax.swing.JFormattedTextField exa_fecfin;
    private javax.swing.JFormattedTextField exa_fecini;
    private javax.swing.JList<String> exa_list_noselec;
    private javax.swing.JList<String> exa_list_selec;
    private javax.swing.JSpinner exa_nota_apro;
    private javax.swing.JSpinner exa_nota_tot;
    private javax.swing.JLabel exa_titulo;
    private javax.swing.JFormattedTextField finPrimerSemestre;
    private javax.swing.JFormattedTextField finSegundoSemestre;
    private javax.swing.JFormattedTextField inicioPrimerSemestre;
    private javax.swing.JFormattedTextField inicioSegundoSemestre;
    private javax.swing.JButton inscribirDocente;
    private javax.swing.JButton inscribirEstudiante;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
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
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton marcarparciales_aceptar;
    private javax.swing.JFormattedTextField marcarparciales_fecha1;
    private javax.swing.JFormattedTextField marcarparciales_fecha2;
    private javax.swing.JSpinner marcarparciales_notaApro;
    private javax.swing.JSpinner marcarparciales_notaExa;
    private javax.swing.JSpinner marcarparciales_notaMax1;
    private javax.swing.JSpinner marcarparciales_notaMax2;
    private javax.swing.JLabel marcarparciales_titulo;
    private javax.swing.JButton mod_btn_confirmar;
    private javax.swing.JTextField mod_sede_direccion;
    private javax.swing.JTextField mod_sede_nombre;
    private javax.swing.JTextField mod_sede_telefono;
    private javax.swing.JTextField notaAproCurTextField;
    private javax.swing.JLabel notaAprobCurLabel;
    private javax.swing.JTextField notaExonExCurTextField;
    private javax.swing.JLabel notaExonExLabel;
    private javax.swing.JPanel panelBorrarSede;
    private javax.swing.JPanel panelModSede;
    private javax.swing.JPanel panelNuevaSede;
    private javax.swing.JButton quitarPreviaCurButton;
    private javax.swing.JButton quitarSedeCarrButton;
    private javax.swing.JLabel sedeCarreraLabel;
    private javax.swing.JButton sede_btn_crear;
    private javax.swing.JTextField sede_txt_direccion;
    private javax.swing.JTextField sede_txt_nombre;
    private javax.swing.JTextField sede_txt_telefono;
    private javax.swing.JTable selecPreviaCurTable;
    private javax.swing.JTable selecSedeCarrTable;
    private javax.swing.JComboBox<String> selectSede;
    private javax.swing.JLabel tituloAsociarDocente;
    private javax.swing.JLabel tituloMateriales;
    private javax.swing.JButton verCursoCurButton;
    private javax.swing.JList<String> verNoticia_etiquetas;
    private javax.swing.JLabel verNoticia_fecha;
    private javax.swing.JTextArea verNoticia_texto;
    private javax.swing.JLabel verNoticia_titulo;
    private javax.swing.JButton verSedeCarrButton;
    // End of variables declaration//GEN-END:variables

    private void listarEstudiante() {
        List<Estudiante> estudiante;
        if (this.BuscarEstudiante.getText().equals("")) {
            estudiante = Fabrica.getInstance().getContEst().getEstudiantes();
        } else {
            estudiante = Fabrica.getInstance().getContEst().getEstudiantes(this.BuscarEstudiante.getText());
        }
        DefaultTableModel modelo = (DefaultTableModel) EstudiantesTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (estudiante.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Estudiante e : estudiante) {
                Object[] datos = {e, e.getCi(), e.getNombres(), e.getApellidos(), dateFormat.format(e.getFechaNac()), e.getEmail()};
                modelo.addRow(datos);
            }
        }
        this.resizeColumnWidth(EstudiantesTable);
    }

    private void listarDocentes() {
        List<Docente> docentes;
        if (this.BuscarDocentes.getText().equals("")) {
            docentes = Fabrica.getInstance().getContAdmin().getDocentes();
        } else {
            docentes = Fabrica.getInstance().getContAdmin().getDocentes(this.BuscarDocentes.getText());
        }
        DefaultTableModel modelo = (DefaultTableModel) DocentesTable.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (docentes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Docente d : docentes) {
                Object[] datos = {d, d.getCi(), d.getNombres(), d.getApellidos(), dateFormat.format(d.getFechaNac()), d.getEmail()};
                modelo.addRow(datos);
            }
        }
        this.resizeColumnWidth(DocentesTable);
    }
    
    private void seleccionarCursoExamen(){
        int index = CursosTable.getSelectedRow();
        if(index != -1){
            Curso c = (Curso)CursosTable.getModel().getValueAt(index, 0);
            this.cursoExamen = c;
            exa_fec.setText("");
            exa_fecini.setText("");
            exa_fecfin.setText("");
            exa_nota_apro.setValue(((SpinnerNumberModel)exa_nota_apro.getModel()).getMinimum());
            exa_nota_tot.setValue(((SpinnerNumberModel) exa_nota_tot.getModel()).getMinimum());
            DefaultListModel list = new DefaultListModel();
            exa_list_selec.setModel(new DefaultListModel<>());
            for(CursoSede cs : c.getCursoSedes()){
                list.addElement(cs.getSede().getNombre());
            }
            exa_list_noselec.setModel(list);
            exa_titulo.setText("Examen de "+ c.getNombre());
        }else{
                JOptionPane.showMessageDialog(this, "Seleccione un curso", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void crearExamen()throws InternalException{
        Date fecha = crearFecha(exa_fec.getText(), " de examen");
        Date fechai = crearFecha(exa_fecini.getText(), " de inicio de inscripcion");
        Date fechaf = crearFecha(exa_fecfin.getText(), " de fin de inscripcion");
        DefaultListModel<String> model = (DefaultListModel) exa_list_selec.getModel();
        if(!fechaf.after(fechai))
            throw new InternalException("La fecha de inicio deinscripcion debe ser antes de la fecha final de inscripcion");
        if(!fecha.after(fechaf))
            throw new InternalException("La fecha final de inscripcion debe ser antes del examen");
        if(((int)exa_nota_tot.getValue()) <= ((int)exa_nota_apro.getValue()))
            throw new InternalException("La nota de aprobación debe ser menor a la nota total");
        if(model.isEmpty())
            throw new InternalException("Seleccione al menos una sede");
        Examen e = new Examen();
        e.setFecha(fecha);
        e.setInicioInsripcion(fechai);
        e.setFinInsripcion(fechaf);
        e.setNotaApro((int)exa_nota_apro.getValue());
        e.setNotaMax((int)exa_nota_tot.getValue());
        List<Sede> sedes = new ArrayList<>();        
        for(int i=0; i<model.getSize();i++){
            sedes.add(Fabrica.getInstance().getContEdu().getSede(model.elementAt(i)));
        }
        Fabrica.getInstance().getContAdmin().crearExamen(e, sedes, cursoExamen);
        JOptionPane.showMessageDialog(this, "Se registró el examen", "Exito", JOptionPane.INFORMATION_MESSAGE);
        opcionSeleccionada(CursosOpcion, "cursos");
    }
    
    public Date crearFecha(String fecha, String campo)throws InternalException{
        try {
            Date retornar = null;
            SimpleDateFormat dateFormatAux = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
            if(campo.equals(" de examen"))
                retornar = dateFormatAux.parse(fecha);
            if(campo.contains("parcial"))
                retornar = dateFormatAux.parse(fecha);
            else
                retornar = dateFormat.parse(fecha);
            return retornar;
        } catch (ParseException ex) {
            Logger.getLogger(Admin_MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            throw new InternalException("Formato de fecha"+campo+" incorrecto");
        }
    }
    
    public boolean controlarAnioFechas(List<Date> fechas){
        int anioAnterior = -1;
        for (Date fecha : fechas) {
            
            Date inicio = new Date();
            LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int anio  = localDate.getYear();
            if(anioAnterior!=-1 && anioAnterior!=anio){
                return false;
            }
        }
        
        return true;
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

        tituloMateriales.setText("Material subido para "+curso.getNombre());
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado resultados");
        } else {
            for (Material material : lista) {
                String nombreDocente = material.getDocente().getNombres()+" "+material.getDocente().getApellidos();
                Object[] datos = {material, material.getTitulo(), dateFormat.format(material.getFechaSubida()), nombreDocente};
                modelo.addRow(datos);
            }
        }

        resizeColumnWidth(MaterialesSubidosTable);
    }
    
    void crearParciales(){
        try{
            String fecha1 = marcarparciales_fecha1.getText();
            String fecha2 = marcarparciales_fecha2.getText();
            int nota1, nota2, notaApro, notaExa;
            nota1 = (int) marcarparciales_notaMax1.getModel().getValue();
            nota2 = (int) marcarparciales_notaMax2.getModel().getValue();
            notaExa = (int) marcarparciales_notaExa.getModel().getValue();
            notaApro = (int) marcarparciales_notaApro.getModel().getValue();
            if((nota1 + nota2) <= notaApro) throw new InternalException("La nota de aprobación debe ser menor a la suma de la nota de los dos parciales");
            if( notaExa >= notaApro) throw new InternalException("La nota de derecho a examen debe ser menor a la de aprobación");
            Parcial p1 = new Parcial(), p2 = new Parcial();
            p1.setFecha(this.crearFecha(fecha1, " de primer parcial"));
            p2.setFecha(this.crearFecha(fecha2, " de segundo parcial"));
            p1.setInstancia("Primer");
            p2.setInstancia("Segundo");
            p1.setNotaMaxima(nota1);
            p2.setNotaMaxima(nota2);
            Fabrica.getInstance().getContAdmin().crearParciales(cursoParcial, p1, p2, notaApro, notaExa); 
            JOptionPane.showMessageDialog(this, "Se han marcado con éxito");
            this.Volver();
            
        }catch(InternalException ex){
            JOptionPane.showMessageDialog(this, "Seleccione un curso", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    void limpiarCrearParciales(){
        DefaultTableModel modelo = (DefaultTableModel) CursosTable.getModel();
        cursoParcial = (Curso) modelo.getValueAt(CursosTable.getSelectedRow(), 0);
        this.marcarparciales_titulo.setText("Marcar parciales de "+ this.cursoParcial.getNombre());
        marcarparciales_notaMax1.setValue(((SpinnerNumberModel)marcarparciales_notaMax1.getModel()).getMinimum());
        marcarparciales_notaMax2.setValue(((SpinnerNumberModel)marcarparciales_notaMax2.getModel()).getMinimum());
        marcarparciales_notaApro.setValue(((SpinnerNumberModel)marcarparciales_notaApro.getModel()).getMinimum());
        marcarparciales_notaExa.setValue(((SpinnerNumberModel)marcarparciales_notaExa.getModel()).getMinimum());
        
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
}
