package GUI;

import javax.swing.JLabel;
import Logica.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfazFabrica1 extends javax.swing.JFrame 
{

    Fabrica fabrica_autos;
    boolean flag;

    public InterfazFabrica1() throws IOException
    {
        initComponents();
        this.setLocationRelativeTo(null);
        fabrica_autos= new Fabrica (this.nroDiasDespacho, this.cantidadMotores, this.cantidadParabrisas, this.cantidadRuedas, this.cantidadProdMot, this.cantidadProdPar, this.cantidadProdRu, this.cantidadEnsambladores, this.cantidadAutos, this.estadoGerente, this.estadoCrono, this.nroDias);
        fabrica_autos.Inicializar_ArrayLists();
        flag=false;
    }
    public void activar_botones()
    {
        flag=true;
        fabrica_autos.Producir_Ensamblar();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ruedasAuto = new javax.swing.JLabel();
        parabrisaAuto = new javax.swing.JLabel();
        cantAutosProducidos = new javax.swing.JLabel();
        diasDespacho = new javax.swing.JLabel();
        ibmw = new javax.swing.JLabel();
        motorAuto = new javax.swing.JLabel();
        estatusGerente = new javax.swing.JLabel();
        estatusCronometrador = new javax.swing.JLabel();
        motorDatos = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cantidadMotores = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cantidadProdMot = new javax.swing.JLabel();
        contratarProdMot = new javax.swing.JButton();
        despedirProdMot = new javax.swing.JButton();
        parabrisaDatos = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cantidadParabrisas = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cantidadProdPar = new javax.swing.JLabel();
        contratarProPar = new javax.swing.JButton();
        despedirProdPar = new javax.swing.JButton();
        ruedasDatos = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cantidadRuedas = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cantidadProdRu = new javax.swing.JLabel();
        contratarProdRu = new javax.swing.JButton();
        despedirProdRu = new javax.swing.JButton();
        ensambladores = new javax.swing.JLabel();
        contratarEnsamblador = new javax.swing.JButton();
        despedirEnsamblador = new javax.swing.JButton();
        cantidadEnsambladores = new javax.swing.JLabel();
        robotimg = new javax.swing.JLabel();
        cantidadAutos = new javax.swing.JLabel();
        nroDiasDespacho = new javax.swing.JLabel();
        estadoGerente = new javax.swing.JLabel();
        estadoCrono = new javax.swing.JLabel();
        Iniciar = new javax.swing.JButton();
        diasTranscurridos = new javax.swing.JLabel();
        nroDias = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ruedasAuto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ruedasAuto.setForeground(new java.awt.Color(255, 255, 255));
        ruedasAuto.setText("Ruedas");
        jPanel1.add(ruedasAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 105, -1));

        parabrisaAuto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        parabrisaAuto.setForeground(new java.awt.Color(255, 255, 255));
        parabrisaAuto.setText("Parabrisas");
        jPanel1.add(parabrisaAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        cantAutosProducidos.setBackground(new java.awt.Color(255, 255, 204));
        cantAutosProducidos.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        cantAutosProducidos.setForeground(new java.awt.Color(255, 255, 255));
        cantAutosProducidos.setText("Nro. Autos Producidos");
        jPanel1.add(cantAutosProducidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(801, 104, -1, -1));

        diasDespacho.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        diasDespacho.setForeground(new java.awt.Color(255, 255, 255));
        diasDespacho.setText("Días que faltan para el despacho:");
        jPanel1.add(diasDespacho, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 390, 237, -1));

        ibmw.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        ibmw.setForeground(new java.awt.Color(255, 255, 255));
        ibmw.setText("IBMW C.A.");
        jPanel1.add(ibmw, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 21, -1, 37));

        motorAuto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        motorAuto.setForeground(new java.awt.Color(255, 255, 255));
        motorAuto.setText("Motor");
        jPanel1.add(motorAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 60, -1));

        estatusGerente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        estatusGerente.setForeground(new java.awt.Color(255, 255, 255));
        estatusGerente.setText("Estatus Gerente:");
        jPanel1.add(estatusGerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 338, -1, -1));

        estatusCronometrador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        estatusCronometrador.setForeground(new java.awt.Color(255, 255, 255));
        estatusCronometrador.setText("Estatus Cronometrador:");
        jPanel1.add(estatusCronometrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 390, -1, -1));

        jLabel1.setText("Motores producidos:");

        cantidadMotores.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        cantidadMotores.setText("X");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/head.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(cantidadMotores)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(cantidadMotores)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        motorDatos.addTab("Producción", jPanel2);

        jLabel3.setText("Productores de motores:");

        cantidadProdMot.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        cantidadProdMot.setText("X");

        contratarProdMot.setText("contratar");
        contratarProdMot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contratarProdMotActionPerformed(evt);
            }
        });

        despedirProdMot.setText("despedir");
        despedirProdMot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                despedirProdMotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(cantidadProdMot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contratarProdMot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(despedirProdMot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cantidadProdMot)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(contratarProdMot)
                        .addGap(18, 18, 18)
                        .addComponent(despedirProdMot)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        motorDatos.addTab("Productor", jPanel3);

        jPanel1.add(motorDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 139, 210, -1));

        jLabel4.setText("Parabrisas producidos:");

        cantidadParabrisas.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        cantidadParabrisas.setText("X");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/body.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(cantidadParabrisas)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(cantidadParabrisas)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parabrisaDatos.addTab("Producción", jPanel4);

        jLabel7.setText("Productores de parabrisas:");

        cantidadProdPar.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        cantidadProdPar.setText("X");

        contratarProPar.setText("contratar");
        contratarProPar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contratarProdParActionPerformed(evt);
            }
        });

        despedirProdPar.setText("despedir");
        despedirProdPar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                despedirProdParActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(cantidadProdPar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contratarProPar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(despedirProdPar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(cantidadProdPar))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(contratarProPar)
                        .addGap(18, 18, 18)
                        .addComponent(despedirProdPar)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        parabrisaDatos.addTab("Productor", jPanel5);

        jPanel1.add(parabrisaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 141, 210, 175));

        jLabel8.setText("Ruedas producidas:");

        cantidadRuedas.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        cantidadRuedas.setText("X");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/arms.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(cantidadRuedas)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(cantidadRuedas))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ruedasDatos.addTab("Producción", jPanel6);

        jLabel9.setText("Productores de Ruedas:");

        cantidadProdRu.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        cantidadProdRu.setText("X");

        contratarProdRu.setText("contratar");
        contratarProdRu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contratarProdRuActionPerformed(evt);
            }
        });

        despedirProdRu.setText("despedir");
        despedirProdRu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                despedirProdRuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(cantidadProdRu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contratarProdRu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(despedirProdRu, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(49, 49, 49))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(cantidadProdRu))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(contratarProdRu)
                        .addGap(18, 18, 18)
                        .addComponent(despedirProdRu)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        ruedasDatos.addTab("Productor", jPanel7);

        jPanel1.add(ruedasDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 141, 210, 175));

        ensambladores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ensambladores.setForeground(new java.awt.Color(255, 255, 255));
        ensambladores.setText("Cantidad de Ensambladores:");
        jPanel1.add(ensambladores, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 338, -1, -1));

        contratarEnsamblador.setText("contratar");
        contratarEnsamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contratarEnsambladorActionPerformed(evt);
            }
        });
        jPanel1.add(contratarEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 370, 108, -1));

        despedirEnsamblador.setText("despedir");
        despedirEnsamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                despedirEnsambladorActionPerformed(evt);
            }
        });
        jPanel1.add(despedirEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 399, 108, -1));

        cantidadEnsambladores.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cantidadEnsambladores.setForeground(new java.awt.Color(255, 153, 51));
        cantidadEnsambladores.setText("X");
        jPanel1.add(cantidadEnsambladores, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 374, -1, -1));

        robotimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/robot.jpg"))); // NOI18N
        jPanel1.add(robotimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 141, -1, -1));

        cantidadAutos.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        cantidadAutos.setForeground(new java.awt.Color(255, 153, 51));
        cantidadAutos.setText("X");
        jPanel1.add(cantidadAutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 188, -1, -1));

        nroDiasDespacho.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nroDiasDespacho.setForeground(new java.awt.Color(255, 153, 51));
        nroDiasDespacho.setText("X");
        jPanel1.add(nroDiasDespacho, new org.netbeans.lib.awtextra.AbsoluteConstraints(864, 386, -1, -1));

        estadoGerente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        estadoGerente.setForeground(new java.awt.Color(255, 153, 51));
        estadoGerente.setText("X");
        jPanel1.add(estadoGerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, -1, -1));

        estadoCrono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        estadoCrono.setForeground(new java.awt.Color(255, 153, 51));
        estadoCrono.setText("X");
        jPanel1.add(estadoCrono, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, -1));

        Iniciar.setText("Iniciar");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });
        jPanel1.add(Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 94, -1));

        diasTranscurridos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        diasTranscurridos.setForeground(new java.awt.Color(255, 255, 255));
        diasTranscurridos.setText("Días transcurridos:");
        jPanel1.add(diasTranscurridos, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 338, -1, -1));

        nroDias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nroDias.setForeground(new java.awt.Color(255, 153, 51));
        nroDias.setText("X");
        jPanel1.add(nroDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(864, 334, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 50, 1010, 450));

        salir.setText("salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondogrey.jpg"))); // NOI18N
        Fondo.setText("jLabel2");
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        // TODO add your handling code here:
        if(flag==false){
            activar_botones();
        }
    }//GEN-LAST:event_IniciarActionPerformed

    private void despedirEnsambladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despedirEnsambladorActionPerformed
        // TODO add your handling code here:
        if(flag)
        {
            fabrica_autos.Despedir_Ensamblador();
        }
    }//GEN-LAST:event_despedirEnsambladorActionPerformed

    private void contratarEnsambladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contratarEnsambladorActionPerformed
        // TODO add your handling code here:
        if(flag)
        {
            fabrica_autos.Contratar_Ensamblador();
        }
    }//GEN-LAST:event_contratarEnsambladorActionPerformed

    private void despedirProdRuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despedirProdRuActionPerformed
        // TODO add your handling code here:
        if(flag)
        {
            fabrica_autos.Despedir_Prod_Rueda();
        }
    }//GEN-LAST:event_despedirProdRuActionPerformed

    private void contratarProdRuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contratarProdRuActionPerformed
        // TODO add your handling code here:
        if(flag)
        {
            fabrica_autos.Contratar_Prod_Rueda();
        }
    }//GEN-LAST:event_contratarProdRuActionPerformed

    private void despedirProdParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despedirProdParActionPerformed
        // TODO add your handling code here:
        if(flag)
        {
            fabrica_autos.Despedir_Prod_Parabrisa();
        }
    }//GEN-LAST:event_despedirProdParActionPerformed

    private void contratarProdParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contratarProdParActionPerformed
        // TODO add your handling code here:
        if(flag)
        {
            fabrica_autos.Contratar_Prod_Parabrisa();
        }
    }//GEN-LAST:event_contratarProdParActionPerformed

    private void despedirProdMotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despedirProdMotActionPerformed
        // TODO add your handling code here:
        if(flag)
        {
            fabrica_autos.Despedir_Prod_Motor();
        }
    }//GEN-LAST:event_despedirProdMotActionPerformed

    private void contratarProdMotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contratarProdMotActionPerformed
        // TODO add your handling code here:
        if(flag)
        {
            fabrica_autos.Contratar_Prod_Motor();
        }
    }//GEN-LAST:event_contratarProdMotActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazFabrica1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazFabrica1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazFabrica1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazFabrica1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    new InterfazFabrica1().setVisible(true);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(InterfazFabrica1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton Iniciar;
    private javax.swing.JLabel cantAutosProducidos;
    private javax.swing.JLabel cantidadAutos;
    private javax.swing.JLabel cantidadEnsambladores;
    private javax.swing.JLabel cantidadMotores;
    private javax.swing.JLabel cantidadParabrisas;
    private javax.swing.JLabel cantidadProdMot;
    private javax.swing.JLabel cantidadProdPar;
    private javax.swing.JLabel cantidadProdRu;
    private javax.swing.JLabel cantidadRuedas;
    private javax.swing.JButton contratarEnsamblador;
    private javax.swing.JButton contratarProPar;
    private javax.swing.JButton contratarProdMot;
    private javax.swing.JButton contratarProdRu;
    private javax.swing.JButton despedirEnsamblador;
    private javax.swing.JButton despedirProdMot;
    private javax.swing.JButton despedirProdPar;
    private javax.swing.JButton despedirProdRu;
    private javax.swing.JLabel diasDespacho;
    private javax.swing.JLabel diasTranscurridos;
    private javax.swing.JLabel ensambladores;
    private javax.swing.JLabel estadoCrono;
    private javax.swing.JLabel estadoGerente;
    private javax.swing.JLabel estatusCronometrador;
    private javax.swing.JLabel estatusGerente;
    private javax.swing.JLabel ibmw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel motorAuto;
    private javax.swing.JTabbedPane motorDatos;
    private javax.swing.JLabel nroDias;
    private javax.swing.JLabel nroDiasDespacho;
    private javax.swing.JLabel parabrisaAuto;
    private javax.swing.JTabbedPane parabrisaDatos;
    private javax.swing.JLabel robotimg;
    private javax.swing.JLabel ruedasAuto;
    private javax.swing.JTabbedPane ruedasDatos;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
