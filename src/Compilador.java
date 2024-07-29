
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Allydocket
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<ErrorLSSL> erroresLexicos;
    private ArrayList<ErrorLSSL> erroresSintacticos;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private ArrayList<Production> mainProd;
    private ArrayList<Production> compProd;
    private ArrayList<Production> asigProd;
    private ArrayList<Production> asigProdConID;
    private ArrayList<Production> opProd;
    private ArrayList<Production> diviProd;
    private ArrayList<Production> mientrasProd;
    private ArrayList<Production> imprimirProd;
    public HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;
    private HashMap<String, String[]> tablaSimbolos;
    DefaultTableModel tablaS;
    HashMap<String, String> identDataType = new HashMap<>();
    Grammar gramatica;
    private ScopeManager scopeManager;

    private ArrayList<ErrorLSSL> errores;

    //Parte semantica 
    private HashMap<String, VariableInfo> symbolTable;
    private ArrayList<String> semanticErrors;

    //Aqui declaramos las variables de codigo intermedio
    private ASM asm;
    private ArrayList<Production> ifProd;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
        this.asm = new ASM();
        asm.generarCodigoIntermedio(tokens);
        List<String> tripletas = asm.obtenerTripletas();
        List<String> cuadruplos = asm.obtenerCuadruplos();
        symbolTable = new HashMap<>();
        semanticErrors = new ArrayList<>();
        errores = new ArrayList<>();
    }

    public void setImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth() - 105, labelName.getHeight() - 50, Image.SCALE_AREA_AVERAGING));
        labelName.setIcon(icon);
        this.repaint();
    }

    private void init() {
        errores = new ArrayList<>();
        jtpCode.setEnabled(false);
        title = "Farneze";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".Docket");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (10), (ActionEvent e) -> {
            timerKeyReleased.stop();
//            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        mainProd = new ArrayList<>();
        identificadores = new HashMap<>();
        tablaSimbolos = new HashMap<>();
        asigProd = new ArrayList<>();
        asigProdConID = new ArrayList<>();
        compProd = new ArrayList<>();
        opProd = new ArrayList<>();
        diviProd = new ArrayList<>();
        mientrasProd = new ArrayList<>();
        ifProd = new ArrayList<>();
        erroresLexicos = new ArrayList<>();
        erroresSintacticos = new ArrayList<>();
        tablaS = (DefaultTableModel) TblSimbolos.getModel();
        Functions.setAutocompleterJTextComponent(new String[]{"VAR { \n  \n }"}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        TabbedPane = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TblSimbolos = new javax.swing.JTable();
        btnTripletas = new javax.swing.JButton();
        btnCuadruplos = new javax.swing.JButton();
        btnIntermedio = new javax.swing.JButton();
        btn8088 = new javax.swing.JButton();
        PnlLogos1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuNuevoArchivo = new javax.swing.JMenuItem();
        jMenuAbrirArchivo = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuGuardarArchivo = new javax.swing.JMenuItem();
        jMenuGuardarArchivoComo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuSalir = new javax.swing.JMenuItem();
        mEjecutar = new javax.swing.JMenu();
        jMenuCompilar = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        AcercaDe = new javax.swing.JMenu();
        BtnIntegrantes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(51, 102, 0));

        buttonsFilePanel.setBackground(new java.awt.Color(51, 153, 0));

        btnAbrir.setBackground(new java.awt.Color(51, 102, 0));
        btnAbrir.setForeground(new java.awt.Color(200, 195, 199));
        btnAbrir.setText("Abrir");
        btnAbrir.setBorder(null);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(51, 102, 0));
        btnNuevo.setForeground(new java.awt.Color(200, 195, 199));
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(51, 102, 0));
        btnGuardar.setForeground(new java.awt.Color(200, 195, 199));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setBackground(new java.awt.Color(51, 102, 0));
        btnGuardarC.setForeground(new java.awt.Color(200, 195, 199));
        btnGuardarC.setText("Guardar como");
        btnGuardarC.setBorder(null);
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        btnCompilar.setBackground(new java.awt.Color(51, 102, 0));
        btnCompilar.setForeground(new java.awt.Color(200, 195, 199));
        btnCompilar.setText("Compilar");
        btnCompilar.setBorder(null);
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setBackground(new java.awt.Color(51, 102, 0));
        btnEjecutar.setForeground(new java.awt.Color(200, 195, 199));
        btnEjecutar.setText("Ejecutar");
        btnEjecutar.setBorder(null);
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manejador de entornos ");

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarC)
                .addGap(191, 191, 191)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarC)
                    .addComponent(btnCompilar)
                    .addComponent(btnEjecutar)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 102, 0));

        jtpCode.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(200, 195, 199)));
        jtpCode.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(jtpCode);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(51, 102, 0));

        TabbedPane.setBackground(new java.awt.Color(51, 102, 0));
        TabbedPane.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(200, 195, 199)));
        TabbedPane.setForeground(new java.awt.Color(200, 195, 199));
        TabbedPane.setFocusable(false);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.setFocusable(false);
        tblTokens.setRowSelectionAllowed(false);
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        TabbedPane.addTab("Tabla de tokens", jScrollPane3);

        TblSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Tipo de dato", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblSimbolos.setFocusable(false);
        TblSimbolos.setRowSelectionAllowed(false);
        TblSimbolos.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TblSimbolos);

        TabbedPane.addTab("Tabla de simbolos", jScrollPane4);

        btnTripletas.setBackground(new java.awt.Color(51, 102, 0));
        btnTripletas.setForeground(new java.awt.Color(200, 195, 199));
        btnTripletas.setText("Tripletas");
        btnTripletas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTripletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTripletasActionPerformed(evt);
            }
        });

        btnCuadruplos.setBackground(new java.awt.Color(51, 102, 0));
        btnCuadruplos.setForeground(new java.awt.Color(200, 195, 199));
        btnCuadruplos.setText("Cuadruplos");
        btnCuadruplos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCuadruplos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuadruplosActionPerformed(evt);
            }
        });

        btnIntermedio.setBackground(new java.awt.Color(51, 102, 0));
        btnIntermedio.setForeground(new java.awt.Color(200, 195, 199));
        btnIntermedio.setText("Intermedio");
        btnIntermedio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIntermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntermedioActionPerformed(evt);
            }
        });

        btn8088.setBackground(new java.awt.Color(51, 102, 0));
        btn8088.setForeground(new java.awt.Color(200, 195, 199));
        btn8088.setText("8086");
        btn8088.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn8088.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8088ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnTripletas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCuadruplos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIntermedio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn8088, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTripletas)
                    .addComponent(btnCuadruplos)
                    .addComponent(btnIntermedio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn8088)
                .addContainerGap())
        );

        PnlLogos1.setBackground(new java.awt.Color(51, 102, 0));

        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jtaOutputConsole.setFocusable(false);
        jScrollPane2.setViewportView(jtaOutputConsole);

        javax.swing.GroupLayout PnlLogos1Layout = new javax.swing.GroupLayout(PnlLogos1);
        PnlLogos1.setLayout(PnlLogos1Layout);
        PnlLogos1Layout.setHorizontalGroup(
            PnlLogos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlLogos1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        PnlLogos1Layout.setVerticalGroup(
            PnlLogos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlLogos1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(PnlLogos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlLogos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(rootPanel);

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setBorder(null);

        jMenu1.setText("Archivo");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuNuevoArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuNuevoArchivo.setText("Nuevo archivo");
        jMenuNuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNuevoArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuNuevoArchivo);

        jMenuAbrirArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuAbrirArchivo.setText("Abrir archivo");
        jMenuAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAbrirArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuAbrirArchivo);
        jMenu1.add(jSeparator6);

        jMenuGuardarArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuGuardarArchivo.setText("Guardar archivo");
        jMenuGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGuardarArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuGuardarArchivo);

        jMenuGuardarArchivoComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuGuardarArchivoComo.setText("Guardar como...");
        jMenuGuardarArchivoComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGuardarArchivoComoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuGuardarArchivoComo);
        jMenu1.add(jSeparator1);

        jMenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSalir);

        jMenuBar1.add(jMenu1);

        mEjecutar.setText("Ejecutar");

        jMenuCompilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuCompilar.setText("Compilar");
        jMenuCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCompilarActionPerformed(evt);
            }
        });
        mEjecutar.add(jMenuCompilar);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem15.setText("Ejecutar");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        mEjecutar.add(jMenuItem15);

        jMenuBar1.add(mEjecutar);

        AcercaDe.setText("Acerca de");

        BtnIntegrantes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        BtnIntegrantes.setText("Integrantes");
        BtnIntegrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIntegrantesActionPerformed(evt);
            }
        });
        AcercaDe.add(BtnIntegrantes);

        jMenuBar1.add(AcercaDe);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        clearFields();
        jtpCode.setEnabled(true);
        jtpCode.setText("VARIABLES {\n\n}\n\nPROCESOS {\n\n}");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
//            colorAnalysis();
            jtpCode.setEnabled(true);
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        compile();
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                //  System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                //   System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void jMenuNuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNuevoArchivoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_jMenuNuevoArchivoActionPerformed

    private void jMenuAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAbrirArchivoActionPerformed
        if (directorio.Open()) {
//            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jMenuAbrirArchivoActionPerformed

    private void jMenuGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGuardarArchivoActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenuGuardarArchivoActionPerformed

    private void jMenuGuardarArchivoComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGuardarArchivoComoActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenuGuardarArchivoComoActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                // System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                // System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCompilarActionPerformed
        compile();
    }//GEN-LAST:event_jMenuCompilarActionPerformed

    private void BtnIntegrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIntegrantesActionPerformed
        JOptionPane.showMessageDialog(null, "Este compilador fue realizado por:\n- Arath De Jesus Cortez Salinas.\n- Hannia Ali Ortega De Luna.\n- Alan Daniel Rodriguez Godinez.\n- Jose Fernando Ruiz Campos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BtnIntegrantesActionPerformed

    private void btnTripletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTripletasActionPerformed
        String entrada = jtpCode.getText();
        List<Token> tokens = analizarLexicamente(entrada);
        asm.generarCodigoIntermedio(tokens);
        List<String> codigoTresDirecciones = asm.obtenerTripletas();
        StringBuilder codigoInt = new StringBuilder();
        for (String linea : codigoTresDirecciones) {
            codigoInt.append(linea).append("\n");
        }
        JTextArea textArea = new JTextArea(codigoInt.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        scrollPane.setPreferredSize(new Dimension(400, 500));
        JOptionPane.showMessageDialog(null, scrollPane, "Tripletas", JOptionPane.PLAIN_MESSAGE);


    }//GEN-LAST:event_btnTripletasActionPerformed

    private void btnCuadruplosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuadruplosActionPerformed

        String entrada = jtpCode.getText();
        List<Token> tokens = analizarLexicamente(entrada);
        asm.generarCodigoIntermedio(tokens);
        List<String> cuadruplos = asm.obtenerCuadruplos();
        StringBuilder codigoInt2 = new StringBuilder();
        for (String linea : cuadruplos) {
            codigoInt2.append(linea).append("\n");
        }
        JTextArea textArea1 = new JTextArea(codigoInt2.toString());
        JScrollPane scrollPane = new JScrollPane(textArea1);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setEditable(false);
        scrollPane.setPreferredSize(new Dimension(400, 500));
        JOptionPane.showMessageDialog(null, scrollPane, "Cuadruplos", JOptionPane.PLAIN_MESSAGE);


    }//GEN-LAST:event_btnCuadruplosActionPerformed

    private void btnIntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntermedioActionPerformed
        String entrada = jtpCode.getText();
        List<Token> tokens = analizarLexicamente(entrada);
        asm.generarCodigoIntermedio(tokens);
        codigoObjeto generador = new codigoObjeto();
        List<String> codigoEnsamblador = generador.generateCode(asm.obtenerCuadruplos());
        StringBuilder codigoObj = new StringBuilder();
        for (String linea : codigoEnsamblador) {
            codigoObj.append(linea).append("\n");
        }
        JTextArea textArea = new JTextArea(codigoObj.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        scrollPane.setPreferredSize(new Dimension(400, 500));
        JOptionPane.showMessageDialog(null, scrollPane, "Código Objeto", JOptionPane.PLAIN_MESSAGE);


    }//GEN-LAST:event_btnIntermedioActionPerformed

    private void btn8088ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8088ActionPerformed

        String entrada = jtpCode.getText();
        List<Token> tokens = analizarLexicamente(entrada);

        ASM asm = new ASM();
        asm.generarCodigoIntermedio(tokens);

        codigoObjeto generador = new codigoObjeto();
        List<String> codigoObjeto = generador.generateCode(asm.obtenerCuadruplos());

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Código Ensamblador");
        fileChooser.setSelectedFile(new File("codigo.asm"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                for (String line : codigoObjeto) {
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                String emu8086Path = "N:\\Tecnologico\\8ctavo semestre\\LYA Definitivo\\logica\\Ma.Lya\\emu8086\\emu8086.exe";
                String command = emu8086Path + " " + fileToSave.getAbsolutePath();

                // Imprimir el comando para depuración
                System.out.println("Comando ejecutado: " + command);

                // Ejecutar el comando
                ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
                processBuilder.redirectErrorStream(true);
                Process process = processBuilder.start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_btn8088ActionPerformed

    private List<Token> analizarLexicamente(String entrada) {
        List<Token> tokens = new ArrayList<>();
        File codigo = null;
        try {
            // Escribir la entrada en un archivo temporal
            codigo = File.createTempFile("farneze_code_", ".tmp");
            try (FileWriter writer = new FileWriter(codigo)) {
                writer.write(entrada);
            }

            // Crear un BufferedReader para el archivo
            try (BufferedReader reader = new BufferedReader(new FileReader(codigo))) {
                // Crear una instancia del Lexer
                Lexer lexer = new Lexer(reader);

                // Obtener todos los tokens
                Token token;
                while ((token = lexer.yylex()) != null) {
                    tokens.add(token);
                }
            }
        } catch (IOException ex) {
            System.err.println("Error de E/S durante el análisis léxico: " + ex.getMessage());
        } finally {
            // Eliminar el archivo temporal
            if (codigo != null && codigo.exists()) {
                codigo.delete();
            }
        }
        return tokens;
    }

    private void compile() {
        System.out.println("Iniciando compilación");
        codeHasBeenCompiled = true;
        clearFields();

        String codeText = jtpCode.getText(); // Obtiene el texto del editor

        try {
            // Análisis léxico
            tokens = lexicalAnalysis(codeText);
            fillTableTokens(tokens);

            // Análisis sintáctico
            syntacticAnalysis();

            // Análisis semántico
            semanticAnalysis();
            printConsole();
        } catch (Exception e) {
            e.printStackTrace();
            jtaOutputConsole.setText("Error durante la compilación: " + e.getMessage());
        }

        System.out.println("Compilación completada");
    }

    public static String removeSubstring(String originalString, String substringToRemove) {
        if (originalString == null || substringToRemove == null) {
            return originalString;
        }
        return originalString.replace(substringToRemove, "");
    }

    private void fillTableTokens(List<Token> tokens) {
        DefaultTableModel model = (DefaultTableModel) tblTokens.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de llenarla

        for (Token token : tokens) {
            Object[] row = new Object[]{
                token.getLexicalComp(),
                token.getLexeme(),
                "[" + token.getLine() + ", " + token.getColumn() + "]"
            };
            model.addRow(row);
        }
    }

    private void printConsole() {
        StringBuilder output = new StringBuilder();
        boolean hasErrors = false;

        // Errores léxicos
        if (!erroresLexicos.isEmpty()) {
            hasErrors = true;
            output.append("Errores léxicos:\n");
            for (ErrorLSSL error : erroresLexicos) {
                output.append(error.toString()).append("\n");
            }
            output.append("\n");
        }

        // Errores sintácticos
        if (!erroresSintacticos.isEmpty()) {
            hasErrors = true;
            output.append("Errores sintácticos:\n");
            for (ErrorLSSL error : erroresSintacticos) {
                output.append(error.toString()).append("\n");
            }
            output.append("\n");
        }

        // Errores semánticos
        if (!semanticErrors.isEmpty()) {
            hasErrors = true;
            output.append("Errores semánticos:\n");
            for (String error : semanticErrors) {
                output.append(error).append("\n");
            }
            output.append("\n");
        }

        if (hasErrors) {
            output.insert(0, "Compilación terminada con errores:\n\n");
        } else {
            output.append("Compilación terminada exitosamente.\n");
        }

        jtaOutputConsole.setText(output.toString());
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        errors.clear();
        Functions.clearDataInTable(tblTokens);
        Functions.clearDataInTable(TblSimbolos);
        jtaOutputConsole.setText("");
        tokens.clear();
        identProd.clear();
        identificadores.clear();
        mainProd.clear();
        asigProd.clear();
        asigProdConID.clear();
        opProd.clear();
        compProd.clear();
        tablaSimbolos.clear();
        diviProd.clear();
        mientrasProd.clear();
        codeHasBeenCompiled = false;
        if (errores != null) {
            errores.clear();
        } else {
            errores = new ArrayList<>();
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
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    //Getters and Setters
    public Grammar getGramatica() {
        return gramatica;
    }

    public void setGramatica(Grammar gramatica) {
        this.gramatica = gramatica;
    }

    /*         Analizadores         */
    /**
     * ****************************************************************
     */
    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<ErrorLSSL> getErrores() {
        return errores;
    }

    public void setErrores(ArrayList<ErrorLSSL> errores) {
        this.errores = errores;
    }

    public ArrayList<String> getSemanticErrors() {
        return semanticErrors;
    }

    public void setSemanticErrors(ArrayList<String> semanticErrors) {
        this.semanticErrors = semanticErrors;
    }

    public void syntacticAnalysis() {
        gramatica = new Grammar(tokens, erroresSintacticos);
        gramatica.delete(new String[]{"ERROR", "ERROR_1", "Error_2"}, 1);
        gramatica.initialLineColumn();
        // Gramática para definición de variables
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) IDENTIFICADOR ASIGNACION ( CADENA |NDECIMAL|NUMERO|FALSO|VERDADERO) FINLINEA", identProd);
        gramatica.group("variable", "IDENTIFICADOR ASIGNACION ( CADENA |NDECIMAL|NUMERO|FALSO|VERDADERO) FINLINEA", 103, "Error Sintactico {}: Falta colocar el tipo de dato a definir [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) ASIGNACION ( CADENA | NUMERO|NDECIMAL|FALSO|VERDADERO) FINLINEA", 104, "Error Sintactico {}: Falta colocar el identificador de la variable a definir [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) IDENTIFICADOR ( CADENA | NUMERO|NDECIMAL|FALSO|VERDADERO) FINLINEA", 105, "Error Sintactico {}: Falta colocar la asignacion --> '='  [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) IDENTIFICADOR ASIGNACION FINLINEA", 106, "Error Sintactico {}: Falta colocar el valor a asignar [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) IDENTIFICADOR ASIGNACION (CADENA | NUMERO|NDECIMAL|FALSO|VERDADERO)", 107, "Error Sintactico {}: Falta colocar el fin de linea --> ; [#,%]");
        gramatica.finalLineColumn();
        // Operaciones básicas
        gramatica.initialLineColumn();
        gramatica.group("operacion", "(SUMA | RESTA | MULTIPLICACION | DIVISION) PARA (IDENTIFICADOR | NUMERO | NDECIMAL) SEPARADOR (IDENTIFICADOR | NUMERO | NDECIMAL) PARC", opProd);
        gramatica.group("operacion", "PARA (IDENTIFICADOR | NUMERO | NDECIMAL) SEPARADOR (IDENTIFICADOR | NUMERO | NDECIMAL) PARC", 200, "Error Sintactico {}: Falta colocar el tipo de operacion a realizar [#,%]");
        gramatica.group("operacion", "(SUMA | RESTA | MULTIPLICACION | DIVISION) PARA (IDENTIFICADOR | NUMERO | NDECIMAL)  (IDENTIFICADOR | NUMERO | NDECIMAL) PARC", 200, "Error Sintactico {}: Falta colocar el separador de los operandos[#,%]");
        gramatica.group("operacion", "(SUMA | RESTA | MULTIPLICACION | DIVISION) PARA (IDENTIFICADOR | NUMERO | NDECIMAL) SEPARADOR  PARC", 200, "Error Sintactico {}: Falta colocar el operador derecho[#,%]");
        gramatica.group("operacion", "(SUMA | RESTA | MULTIPLICACION | DIVISION) PARA SEPARADOR (IDENTIFICADOR | NUMERO | NDECIMAL) PARC", 200, "Error Sintactico {}: Falta colocar el operador izquierdo[#,%]");
        gramatica.group("operacion", "(SUMA | RESTA | MULTIPLICACION | DIVISION)  (IDENTIFICADOR | NUMERO | NDECIMAL) SEPARADOR (IDENTIFICADOR | NUMERO | NDECIMAL) PARC", 200, "Error Sintactico {}: Falta colocar el parentesis de apertura[#,%]");
        gramatica.group("operacion", "(SUMA | RESTA | MULTIPLICACION | DIVISION) PARA (IDENTIFICADOR | NUMERO | NDECIMAL) SEPARADOR (IDENTIFICADOR | NUMERO | NDECIMAL) ", 200, "Error Sintactico {}: Falta colocar el parentesis de cierre[#,%]");
         // Gramática para comparaciones         0                                               1                                                                                           2
        gramatica.group("comparacion", "(IDENTIFICADOR | NUMERO) (IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO) (IDENTIFICADOR | NUMERO)", compProd);
        gramatica.group("comparacion", "(IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO) (IDENTIFICADOR | NUMERO)", 100, "Error Sintactico {}: Falta colocar el primer valor [#,%]");
        gramatica.group("comparacion", "(IDENTIFICADOR | NUMERO) (IDENTIFICADOR | NUMERO)", 101, "Error Sintactico {}: Falta colocar la operacion de comparacion [#,%]");
        gramatica.group("comparacion", "(IDENTIFICADOR | NUMERO) (IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO)", 102, "Error Sintactico {}: Falta colocar el valor a comparar [#,%]");
// Generación de mapa
        gramatica.finalLineColumn();
        gramatica.initialLineColumn();
        gramatica.group("funcion_generar_mapa", "generar_mapa PARA IDENTIFICADOR PARC");
        gramatica.finalLineColumn();
        //         Asignación
        gramatica.initialLineColumn();
        gramatica.group("asignacion", "IDENTIFICADOR ASIGNACION (CADENA |NDECIMAL|NUMERO|FALSO|VERDADERO| operacion |funcion_generar_mapa )", asigProd);
        gramatica.finalLineColumn();
        // Imprimir
        gramatica.initialLineColumn();
        gramatica.group("imprimir", "IMPRIMIR PARA (IDENTIFICADOR | CADENA) (SEPARADOR contenido_imprimir)* PARC", imprimirProd);
        gramatica.finalLineColumn();
        // Instrucciones
        gramatica.group("instruccion", "imprimir| operacion | asignacion|funcion_generar_mapa");
        // Estructuras de control
        gramatica.initialLineColumn();
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            //0   1        2         3     4                           5                            6
            gramatica.group("estructura_si", "SI PARA comparacion PARC CORA (instruccion| estructura_si | estructura_mientras)* CORC (SINO CORA (instruccion| estructura_si | estructura_mientras)* CORC)?", ifProd);
        });
        gramatica.finalLineColumn();
        gramatica.group("estructura_mientras", "MIENTRAS PARA comparacion PARC CORA (instruccion| estructura_si | estructura_mientras)* CORC", mientrasProd);

        gramatica.group("estructura_control", "estructura_si | estructura_mientras");
        // Gramática para bloque de variables
        gramatica.initialLineColumn();
        gramatica.group("bloque_variables", "VARIABLES CORA (variable)* CORC");
        gramatica.group("bloque_variables", "VARIABLES (variable)* CORC", 2001, "Error Sintáctico: Falta la llave de apertura '{' en el bloque de variables [#,%]");
        gramatica.group("bloque_variables", "VARIABLES CORA (variable)*", 2002, "Error Sintáctico: Falta la llave de cierre '}' en el bloque de variables [#,%]");
        gramatica.finalLineColumn();

        // Gramática para bloque de procesos
        gramatica.initialLineColumn();
        gramatica.group("bloque_procesos", "PROCESOS CORA (instruccion|estructura_control)* CORC ");
        gramatica.group("bloque_procesos", "PROCESOS CORA ", 3001, "Error Sintáctico: Falta la llave de cierre '}' en el bloque de procesos [#,%]");
        gramatica.group("bloque_procesos", "PROCESOS  CORC", 3002, "Error Sintáctico: Falta la llave de apertura '{' en el bloque de procesos [#,%]");
        gramatica.finalLineColumn();

        // Gramática para bloque programa
        gramatica.group("programa", "bloque_variables bloque_procesos");
        gramatica.group("programa", "bloque_variables", 1001, "Error Sintáctico: Falta el bloque de procesos [#,%]");
        gramatica.group("programa", "bloque_procesos", 1002, "Error Sintáctico: Falta el bloque de variables [#,%]");

        gramatica.show();

    }

    /**
     * ********************************************************************
     */
    //Analizador lexico apartir de aqui
    public ArrayList<Token> lexicalAnalysis(String codeText) {
        ArrayList<Token> localTokens = new ArrayList<>();  // Lista local para almacenar los tokens
        erroresLexicos.clear();

        try {
            File tempFile = File.createTempFile("sourceCode", ".temp");
            try (FileWriter writer = new FileWriter(tempFile)) {
                writer.write(codeText);
            }
            // Crear el lexer
            Lexer lexer = new Lexer(new FileReader(tempFile));

            // Procesar todos los tokens
            Token token;
            while ((token = lexer.yylex()) != null) {
                System.out.println("Token: " + token.getLexeme() + " - Tipo: " + token.getLexicalComp());
                if (token.getLexicalComp().startsWith("ERROR_")) {
                    // Procesar errores léxicos
                    erroresLexicos.add(new ErrorLSSL(token.getLine(),
                            "Error léxico: " + token.getLexicalComp() + " - " + token.getLexeme(), token));
                } else {
                    // Añadir tokens válidos a la lista local
                    localTokens.add(token);
                }
            }

            // Eliminar el archivo temporal
            tempFile.delete();

        } catch (IOException e) {
            e.printStackTrace();
            erroresLexicos.add(new ErrorLSSL(0, "Error de E/S durante el análisis léxico: " + e.getMessage(), null));
        }

        // Imprimir resultados
        if (!erroresLexicos.isEmpty()) {
            System.out.println("Se encontraron " + erroresLexicos.size() + " errores léxicos:");
            for (ErrorLSSL error : erroresLexicos) {
                System.out.println(error);
            }
        } else {
            System.out.println("Análisis léxico completado sin errores.");
        }
        System.out.println("Tokens encontrados: " + localTokens.size());

        return localTokens;  // Devolver la lista local de tokens
    }

    private boolean isPalabraReservada(String lexeme) {
        return Arrays.asList(
                "VARIABLES", "PROCESOS", "MIENTRAS", "SI", "SINO", "IMPRIMIR",
                "ENTERO", "DECIMAL", "BOOLEANO", "TEXTO", "verdadero", "falso",
                "generar_mapa", "GENERAR_MAPA"
        ).contains(lexeme);
    }

    /**
     * ***************************************************************************
     * //
     */
//    /*                     Analizador Semantico                                   */
    public void semanticAnalysis() {
        semanticErrors.clear();
        scopeManager = new ScopeManager();

        // Análisis del bloque de variables
        analyzeVariableDeclarations();

        // Análisis del bloque de procesos
        analyzeProcessBlock();

        // Verificar variables no utilizadas
        checkUnusedVariables();
    }
    private void printSemanticErrors() {
        StringBuilder output = new StringBuilder();
        if (semanticErrors.isEmpty()) {
            output.append("Análisis semántico completado. No se encontraron errores.\n");
        } else {
            output.append("Se encontraron los siguientes errores semánticos:\n\n");
            for (String error : semanticErrors) {
                output.append(error).append("\n");
            }
        }
        jtaOutputConsole.setText(output.toString());
        jtaOutputConsole.setCaretPosition(0);  // Scroll al inicio del texto
    }

    private void analyzeVariableDeclarations() {
      
        // Definición de tipos de datos--------------------------------------------------------------------------------------------------------------
        //llave    //valor
        identDataType.put("BOOLEANO", "BOOLEANO");
        identDataType.put("TEXTO", "TEXTO");
        identDataType.put("DECIMAL", "DECIMAL");
        identDataType.put("ENTERO", "ENTERO");
        // Errores Tipos de datos incompatibles con las variables
        for (Production id : identProd) {
            String tipoDato = id.lexemeRank(0);
            String valorAsignado = id.lexemeRank(3);
            verificarCompatibilidadTipo(tipoDato, valorAsignado, id);
            // Verificar si la variable ya está en el conjunto de identificadores
            String variable = id.lexemeRank(1); //Almacenar variable temporal con el lexema osease el identificador como tal Ejemplo #C3
            if (identificadores.containsKey(variable))//Utilizamos el identificador para buscar duplicados en el HashMap de iidentificadores ya guardados
            {
                //Si encuentra duplicados emite el error y lo almacena tambien
                System.out.println("Error: Variable duplicada = " + variable);
                errors.add(new ErrorLSSL(2, "Error semántico {}: declaracion de variable duplicada [#,%] = " + variable.concat(""), id, false));
            } else {
                //Cuando no se detecta ningun error se agregan a los respectivos HashMap y Tabla de Simbolos
                identificadores.put(id.lexemeRank(1), tipoDato);
                //LLAVE       VALOR[tipoDato, valor]
                String[] datos = {tipoDato, valorAsignado};
                //#A        //ENTERO  //12
                tablaSimbolos.put(id.lexemeRank(1), datos);
                //#A            //ENTERO
                identificadores.put(id.lexemeRank(1), datos[0]);
                String[] getDatos = tablaSimbolos.get(id.lexemeRank(1));
                tablaS.addRow(new Object[]{id.lexemeRank(1), getDatos[0], getDatos[1]});//tambien se mandan a la tabla en la GUI
//                
//                GCI.generarCodigoIntermedio("ASIGNAR", datos[1], "", id.lexemeRank(1));//GENERAR CUADRUPLOS
//                
//                GCO.agregarVariable(id.lexemeRank(1), valorAsignado);
//                

                System.out.println("Agregado a la tabla de simbolos : " + identificadores.toString());

            }

        }//for identProd
        variableNoDeclarada();
    }
        private void verificarCompatibilidadTipo(String tipoDato, String valorAsignado, Production id) {
        if (!identDataType.containsKey(tipoDato)) {
            errors.add(new ErrorLSSL(1, "Error semántico {}: tipo de dato desconocido [#,%]", id, true));
            return;
        }

        String tipoEsperado = identDataType.get(tipoDato);
        if (!tipoEsperado.equals(id.lexicalCompRank(0))) {
            errors.add(new ErrorLSSL(1, "Error semántico {}: valor no compatible con el tipo de dato [#,%]", id, true));
        } else {
            validarValorAsignado(tipoDato, valorAsignado, id);
        }
    }
        private void validarValorAsignado(String tipoDato, String valorAsignado, Production id) {
        switch (tipoDato) {
            case "ENTERO":
                if (!valorAsignado.matches("[0-9]+")) {
                    errors.add(new ErrorLSSL(1, "Error semántico {}: el valor no es un número entero [#,%]", id, false));
                }
                break;
            case "TEXTO":
                if (!valorAsignado.matches("\"[0-9]*[a-zA-Z]+\"")) {
                    errors.add(new ErrorLSSL(1, "Error semántico {}: el valor no es una cadena [#,%]", id, false));
                }
                break;
            case "DECIMAL":
                if (!valorAsignado.matches("[+-]?([0-9]*[.])?[0-9]+([eE][+-]?[0-9]+)?")) {
                    errors.add(new ErrorLSSL(1, "Error semántico {}: el valor no es un número flotante [#,%]", id, false));
                }
                break;
            case "BOOLEANO":
                if (!valorAsignado.matches("verdadero|falso")) {
                    errors.add(new ErrorLSSL(1, "Error semántico {}: solo se acepta 'verdadero' o 'falso' [#,%]", id, false));
                }
                break;
        }
    }
        private void variableNoDeclarada() {
        int contador = 0;
        // Error de variable siendo usada sin declararse------------------------------------------------------------------------------
        if (!mainProd.isEmpty()) {
            // Recorrer la producción principal en búsqueda de una variable
            for (Token token : mainProd.get(0).getTokens()) {
                if ("IDENTIFICADOR".equals(token.getLexicalComp())) {
                    String lexema = token.getLexeme();
                    if (!tablaSimbolos.containsKey(lexema)) {
                        System.out.println("NO ESTA DECLARADA ESTA VARIABLE!!!= " + token.getLexeme());
                        errors.add(new ErrorLSSL(3, "Error semántico {}: este identificador no está declarado [#,%] = " + token.getLexeme(), token));
                    }
                }//if

            }//for
            contador++;
        }//if
    }

    private void analyzeProcessBlock() {
        for (Production p : mainProd) {
            analyzeInstruction(p.getTokens());
        }
    }

    private void analyzeInstruction(List<Token> tokens) {
        if (tokens.isEmpty()) {
            return;
        }

        String firstToken = tokens.get(0).getLexeme();
        switch (firstToken) {
            case "MIENTRAS":
            case "SI":
                analyzeControlStructure(tokens);
                break;
            case "IMPRIMIR":
                analyzeImprimir(tokens);
                break;
            case "RESTA":
            case "SUMA":
            case "MULTIPLICACION":
            case "DIVISION":
                analyzeOperation(tokens);
                break;
            default:
                if (tokens.size() > 2 && tokens.get(1).getLexeme().equals("=")) {
                    analyzeAssignment(tokens);
                } else if (firstToken.equals("generar_mapa")) {
                    analyzeGenerarMapa(tokens);
                } else {
                    addSemanticError("Instrucción no reconocida", tokens.get(0).getLine());
                }
                break;
        }
    }

    private void analyzeImprimir(List<Token> tokens) {
        for (int i = 2; i < tokens.size() - 1; i++) {
            if (tokens.get(i).getLexicalComp().equals("IDENTIFICADOR")) {
                String varName = tokens.get(i).getLexeme();
                VariableInfo info = scopeManager.lookup(varName);
                if (info == null) {
                    addSemanticError("Variable '" + varName + "' no declarada en IMPRIMIR", tokens.get(i).getLine());
                } else {
                    info.used = true;
                }
            }
        }
    }

    private void analyzeControlStructure(List<Token> tokens) {
        String structureType = tokens.get(0).getLexeme();
        int conditionStart = findTokenIndex(tokens, "(", "PARA", 0) + 1;
        int conditionEnd = findTokenIndex(tokens, ")", "PARC", conditionStart);
        int bodyStart = findTokenIndex(tokens, "{", "CORA", conditionEnd) + 1;
        int bodyEnd = findLastTokenIndex(tokens, "}", "CORC");

        scopeManager.enterScope();

        if (conditionStart > 0 && conditionEnd > conditionStart) {
            List<Token> condition = tokens.subList(conditionStart, conditionEnd);
            analyzeCondition(condition, structureType);

            if (bodyStart > 0 && bodyEnd > bodyStart) {
                List<Token> body = tokens.subList(bodyStart, bodyEnd);
                analyzeStructureBody(body, structureType);
            } else {
                addSemanticError("Cuerpo de la estructura " + structureType + " mal formado", tokens.get(0).getLine());
            }
        } else {
            addSemanticError("Estructura de control '" + structureType + "' mal formada", tokens.get(0).getLine());
        }

        if (structureType.equals("SI")) {
            int elseIndex = findTokenIndex(tokens, "SINO", "SINO", 0);
            if (elseIndex != -1) {
                int elseBodyStart = findTokenIndex(tokens, "{", "CORA", elseIndex) + 1;
                int elseBodyEnd = findLastTokenIndex(tokens, "}", "CORC");
                if (elseBodyStart > 0 && elseBodyEnd > elseBodyStart) {
                    List<Token> elseBody = tokens.subList(elseBodyStart, elseBodyEnd);
                    analyzeStructureBody(elseBody, "SINO");
                } else {
                    addSemanticError("Cuerpo del SINO mal formado", tokens.get(elseIndex).getLine());
                }
            }
        }

        scopeManager.exitScope();
    }

    private int findMatchingBrace(List<Token> tokens, int start) {
        int braceCount = 0;
        for (int i = start; i < tokens.size(); i++) {
            if (tokens.get(i).getLexeme().equals("{")) {
                braceCount++;
            } else if (tokens.get(i).getLexeme().equals("}")) {
                braceCount--;
                if (braceCount == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int findTokenIndex(List<Token> tokens, String lexeme, String lexicalComp, int startIndex) {
        for (int i = startIndex; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token.getLexeme().equals(lexeme) && token.getLexicalComp().equals(lexicalComp)) {
                return i;
            }
        }
        return -1;
    }

    private int findLastTokenIndex(List<Token> tokens, String lexeme, String lexicalComp) {
        for (int i = tokens.size() - 1; i >= 0; i--) {
            Token token = tokens.get(i);
            if (token.getLexeme().equals(lexeme) && token.getLexicalComp().equals(lexicalComp)) {
                return i;
            }
        }
        return -1;
    }

    private void analyzeStructureBody(List<Token> body, String structureType) {
        for (int i = 0; i < body.size(); i++) {
            Token token = body.get(i);
            switch (token.getLexeme()) {
                case "IMPRIMIR":
                case "SUMA":
                case "RESTA":
                case "MULTIPLICACION":
                case "DIVISION":
                case "MODULO":
                case "GENERAR_MAPA":
                    analyzeInstruction(body.subList(i, body.size()));
                    break;
                case "SI":
                    if (structureType.equals("SI")) {
                        int elseIndex = findTokenIndex(tokens, "SINO", "SINO", 0);
                        if (elseIndex != -1) {
                            int elseBodyStart = findTokenIndex(tokens, "{", "CORA", elseIndex) + 1;
                            int elseBodyEnd = tokens.size() - 1; // Asumimos que el último token es '}'
                            if (elseBodyStart > 0 && elseBodyEnd > elseBodyStart) {
                                List<Token> elseBody = tokens.subList(elseBodyStart, elseBodyEnd);
                                analyzeStructureBody(elseBody, "SINO");
                            } else {
                                addSemanticError("Cuerpo del SINO mal formado", tokens.get(elseIndex).getLine());
                            }
                        }
                    }
                    break;
                case "MIENTRAS":
                    int endIndex = findMatchingBrace(body, i);
                    if (endIndex != -1) {
                        analyzeControlStructure(body.subList(i, endIndex + 1));
                        i = endIndex;
                    } else {
                        addSemanticError("Estructura " + token.getLexeme() + " mal formada", token.getLine());
                    }
                    break;
                default:
                    if (token.getLexicalComp().equals("IDENTIFICADOR")) {
                        analyzeAssignment(body.subList(i, body.size()));
                    }
                    break;
            }
        }
    }

    private void analyzeCondition(List<Token> condition, String structureType) {
        if (condition.size() >= 3) {
            String leftOperand = condition.get(0).getLexeme();
            String operator = condition.get(1).getLexeme();
            String rightOperand = condition.get(2).getLexeme();

            checkVariableDeclared(leftOperand, condition.get(0).getLine());
            checkVariableDeclared(rightOperand, condition.get(2).getLine());

            if (!isValidComparisonOperator(operator)) {
                addSemanticError("Operador de comparación inválido en " + structureType, condition.get(1).getLine());
            }
        } else {
            addSemanticError("Condición mal formada en " + structureType, condition.get(0).getLine());
        }
    }

    private void checkVariableDeclared(String variable, int line) {
        if (!variable.matches("\\d+") && scopeManager.lookup(variable) == null) {
            addSemanticError("Variable '" + variable + "' no declarada", line);
        }
    }

    private void checkOperandType(String operand, String context) {
        VariableInfo info = scopeManager.lookup(operand);
        if (info != null) {
            info.used = true;
        } else if (!operand.matches("-?\\d+(\\.\\d+)?") && !operand.equals("verdadero") && !operand.equals("falso")) {
            addSemanticError("Operando '" + operand + "' no reconocido en " + context, 0);
        }
    }

    private boolean isValidComparisonOperator(String operator) {
        return operator.equals("==") || operator.equals("!=")
                || operator.equals("<") || operator.equals(">")
                || operator.equals("<=") || operator.equals(">=");
    }

    private void analyzeOperation(List<Token> tokens) {
        String operation = tokens.get(0).getLexeme();
        if (tokens.size() >= 5) {
            String leftOperand = tokens.get(2).getLexeme();
            String rightOperand = tokens.get(4).getLexeme();

            checkNumericOperand(leftOperand, operation, tokens.get(2).getLine());
            checkNumericOperand(rightOperand, operation, tokens.get(4).getLine());

            if (operation.equals("DIVISION") && rightOperand.equals("0")) {
                addSemanticError("División por cero", tokens.get(4).getLine());
            }
        } else {
            addSemanticError("Operación " + operation + " mal formada", tokens.get(0).getLine());
        }
    }

    private void checkNumericOperand(String operand, String context, int line) {
        VariableInfo info = scopeManager.lookup(operand);
        if (info != null) {
            if (!info.type.equals("ENTERO") && !info.type.equals("DECIMAL")) {
                addSemanticError("Se esperaba un tipo numérico para '" + operand + "' en " + context, line);
            }
            info.used = true;
        } else if (!operand.matches("-?\\d+(\\.\\d+)?")) {
            addSemanticError("Operando '" + operand + "' no es un número válido en " + context, line);
        }
    }

    private void analyzeGenerarMapa(List<Token> tokens) {
        if (tokens.size() >= 4) {
            String parameter = tokens.get(2).getLexeme();
            if (!symbolTable.containsKey(parameter)) {
                addSemanticError("Variable '" + parameter + "' no declarada para generar_mapa", tokens.get(2).getLine());
            } else {
                VariableInfo info = symbolTable.get(parameter);
                if (!info.type.equals("ENTERO") || !info.value.startsWith("[")) {
                    addSemanticError("Se espera una lista de ENTERO para generar_mapa", tokens.get(2).getLine());
                }
                info.used = true;
            }
        } else {
            addSemanticError("Función generar_mapa mal formada", tokens.get(0).getLine());
        }
    }

    private void analyzeAssignment(List<Token> tokens) {
        if (tokens.size() >= 3) {
            String identifier = tokens.get(0).getLexeme();
            String value = tokens.get(2).getLexeme();
            VariableInfo varInfo = scopeManager.lookup(identifier);
            if (varInfo == null) {
                addSemanticError("Variable '" + identifier + "' no declarada", tokens.get(0).getLine());
            } else {
                if (!isTypeCompatible(varInfo.type, value)) {
                    addSemanticError("Tipo incompatible en asignación para '" + identifier + "'", tokens.get(0).getLine());
                }
                varInfo.used = true;
            }
        }
    }

    private boolean isTypeCompatible(String type, String value) {
        switch (type) {
            case "ENTERO":
                return value.matches("-?\\d+") || value.startsWith("[") && value.endsWith("]");
            case "DECIMAL":
                return value.matches("-?\\d+(\\.\\d+)?");
            case "BOOLEANO":
                return value.equals("verdadero") || value.equals("falso");
            case "TEXTO":
                return value.startsWith("\"") && value.endsWith("\"");
            default:
                return false;
        }
    }

    private void checkUnusedVariables() {
        for (Map.Entry<String, VariableInfo> entry : scopeManager.getAllVariables().entrySet()) {
            if (!entry.getValue().used) {
                addSemanticError("Advertencia: Variable '" + entry.getKey() + "' declarada pero no utilizada", entry.getValue().declarationLine);
            }
        }
    }

    private void addSemanticError(String message, int line) {
        semanticErrors.add("Error semántico en línea " + line + ": " + message);
    }

    protected class VariableInfo {

        String type;
        String value;
        int declarationLine;
        boolean used;

        VariableInfo(String type, String value, int declarationLine) {
            this.type = type;
            this.value = value;
            this.declarationLine = declarationLine;
            this.used = false;
        }
    }

    //validar sistema

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AcercaDe;
    private javax.swing.JMenuItem BtnIntegrantes;
    private javax.swing.JPanel PnlLogos1;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JTable TblSimbolos;
    private javax.swing.JButton btn8088;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnCuadruplos;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnIntermedio;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnTripletas;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuAbrirArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCompilar;
    private javax.swing.JMenuItem jMenuGuardarArchivo;
    private javax.swing.JMenuItem jMenuGuardarArchivoComo;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuNuevoArchivo;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JMenu mEjecutar;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
