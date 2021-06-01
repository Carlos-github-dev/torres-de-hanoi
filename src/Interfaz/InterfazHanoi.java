/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import excepciones.JuegoExcepcion;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import juego.ClsJuego;
import juego.Movimientos;
import pilas.Nodo;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author luis arguello
 */
public class InterfazHanoi extends javax.swing.JFrame {

    DefaultTableModel modeloTablaTorre1, modeloTablaTorre2, modeloTablaTorre3;
    ClsJuego juego = new ClsJuego();
    int numDiscos;

    public InterfazHanoi() {
        initComponents();

        modeloTablaTorre1 = (DefaultTableModel) tb_Torre1.getModel();
        modeloTablaTorre1.setRowCount(10);

        modeloTablaTorre2 = (DefaultTableModel) tb_Torre2.getModel();
        modeloTablaTorre2.setRowCount(10);

        modeloTablaTorre3 = (DefaultTableModel) tb_Torre3.getModel();
        modeloTablaTorre3.setRowCount(10);

        DefaultTableCellRenderer renderTorre1 = new DefaultTableCellHeaderRenderer();
        renderTorre1.setHorizontalAlignment(SwingConstants.CENTER);
        tb_Torre1.getColumnModel().getColumn(0).setCellRenderer(renderTorre1);

        DefaultTableCellRenderer renderTorre2 = new DefaultTableCellHeaderRenderer();
        renderTorre2.setHorizontalAlignment(SwingConstants.CENTER);
        tb_Torre2.getColumnModel().getColumn(0).setCellRenderer(renderTorre2);

        DefaultTableCellRenderer renderTorre3 = new DefaultTableCellHeaderRenderer();
        renderTorre3.setHorizontalAlignment(SwingConstants.CENTER);
        tb_Torre3.getColumnModel().getColumn(0).setCellRenderer(renderTorre3);

    }

    private void presentarTorre(int numeroTorre) {
        if (numeroTorre == 1) {
            ((DefaultTableModel) tb_Torre1.getModel()).setRowCount(0);
            modeloTablaTorre1.setRowCount(10);

            int filaDisco = (10 - juego.obtenerPila(1).size());
            if (juego.obtenerPila(1).size() > 0) {
                String[] vector = juego.obtenerPila(1).imprimirPila();
                for (int i = 0; i < juego.obtenerPila(1).size(); i++) {
                    String[] vectorDato = {this.obtenerAsteriscos(Integer.parseInt(vector[i]))};
                    modeloTablaTorre1.insertRow(filaDisco, vectorDato);
                    filaDisco++;
                }
            }

            tb_Torre1.setModel(modeloTablaTorre1);
            modeloTablaTorre1.setRowCount(10);
        }

        if (numeroTorre == 2) {
            ((DefaultTableModel) tb_Torre2.getModel()).setRowCount(0);
            modeloTablaTorre2.setRowCount(10);

            int filaDisco = (10 - juego.obtenerPila(2).size());
            if (juego.obtenerPila(2).size() > 0) {
                String[] vector = juego.obtenerPila(2).imprimirPila();
                for (int i = 0; i < juego.obtenerPila(2).size(); i++) {
                    String[] vectorDato = {this.obtenerAsteriscos(Integer.parseInt(vector[i]))};
                    modeloTablaTorre2.insertRow(filaDisco, vectorDato);
                    filaDisco++;
                }
            }

            tb_Torre2.setModel(modeloTablaTorre2);
            modeloTablaTorre2.setRowCount(10);
        }

        if (numeroTorre == 3) {
            ((DefaultTableModel) tb_Torre3.getModel()).setRowCount(0);
            modeloTablaTorre3.setRowCount(10);

            int filaDisco = (10 - juego.obtenerPila(3).size());
            if (juego.obtenerPila(3).size() > 0) {
                String[] vector = juego.obtenerPila(3).imprimirPila();
                for (int i = 0; i < juego.obtenerPila(3).size(); i++) {
                    String[] vectorDato = {this.obtenerAsteriscos(Integer.parseInt(vector[i]))};
                    modeloTablaTorre3.insertRow(filaDisco, vectorDato);
                    filaDisco++;
                }
            }

            tb_Torre3.setModel(modeloTablaTorre3);
            modeloTablaTorre3.setRowCount(10);
        }
    }

    public String obtenerAsteriscos(int numero) {
        if (numero == 1) {
            return "(*)";
        }
        if (numero == 2) {
            return "(**)";
        }
        if (numero == 3) {
            return "(***)";
        }
        if (numero == 4) {
            return "(****)";
        }
        if (numero == 5) {
            return "(*****)";
        }
        if (numero == 6) {
            return "(******)";
        }
        if (numero == 7) {
            return "(*******)";
        }
        if (numero == 8) {
            return "(********)";
        }
        if (numero == 9) {
            return "(*********)";
        }
        if (numero == 10) {
            return "(**********)";
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tb_Torre2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_Torre1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_Torre3 = new javax.swing.JTable();
        btn_1_B = new javax.swing.JButton();
        btn_1_C = new javax.swing.JButton();
        btn_2_A = new javax.swing.JButton();
        btn_2_C = new javax.swing.JButton();
        btn_3_A = new javax.swing.JButton();
        btn_3_B = new javax.swing.JButton();
        cb_NumDiscos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btn_Resolver = new javax.swing.JButton();
        btn_Iniciar = new javax.swing.JButton();
        label1 = new java.awt.Label();
        lbl_lastMove = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_Torre2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Torre2.setAutoscrolls(false);
        tb_Torre2.setFocusable(false);
        tb_Torre2.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(tb_Torre2);
        if (tb_Torre2.getColumnModel().getColumnCount() > 0) {
            tb_Torre2.getColumnModel().getColumn(0).setResizable(false);
        }

        tb_Torre1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Torre1.setAutoscrolls(false);
        tb_Torre1.setFocusable(false);
        tb_Torre1.setRowSelectionAllowed(false);
        jScrollPane3.setViewportView(tb_Torre1);
        if (tb_Torre1.getColumnModel().getColumnCount() > 0) {
            tb_Torre1.getColumnModel().getColumn(0).setResizable(false);
        }

        tb_Torre3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Torre3.setAutoscrolls(false);
        tb_Torre3.setFocusable(false);
        tb_Torre3.setRowSelectionAllowed(false);
        jScrollPane4.setViewportView(tb_Torre3);
        if (tb_Torre3.getColumnModel().getColumnCount() > 0) {
            tb_Torre3.getColumnModel().getColumn(0).setResizable(false);
        }

        btn_1_B.setText("2");
        btn_1_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1_BActionPerformed(evt);
            }
        });

        btn_1_C.setText("3");
        btn_1_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1_CActionPerformed(evt);
            }
        });

        btn_2_A.setText("1");
        btn_2_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2_AActionPerformed(evt);
            }
        });

        btn_2_C.setText("3");
        btn_2_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2_CActionPerformed(evt);
            }
        });

        btn_3_A.setText("1");
        btn_3_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3_AActionPerformed(evt);
            }
        });

        btn_3_B.setText("2");
        btn_3_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3_BActionPerformed(evt);
            }
        });

        cb_NumDiscos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));
        cb_NumDiscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_NumDiscosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("Numero Discos");

        btn_Resolver.setText("Resolver");
        btn_Resolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResolverActionPerformed(evt);
            }
        });

        btn_Iniciar.setText("Iniciar");
        btn_Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IniciarActionPerformed(evt);
            }
        });

        label1.setText("Ultimo movimiento:");

        lbl_lastMove.setText("...");

        label2.setText("Enviar a:");

        label3.setText("Enviar a:");

        label4.setText("Enviar a:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(191, 191, 191)
                            .addComponent(cb_NumDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(btn_1_B)
                                    .addGap(38, 38, 38)
                                    .addComponent(btn_1_C)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btn_2_A)
                            .addGap(38, 38, 38)
                            .addComponent(btn_2_C)
                            .addGap(8, 8, 8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btn_Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_lastMove, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_Resolver, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_3_A)
                .addGap(35, 35, 35)
                .addComponent(btn_3_B)
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_1_B)
                    .addComponent(btn_1_C)
                    .addComponent(btn_2_A)
                    .addComponent(btn_2_C)
                    .addComponent(btn_3_A)
                    .addComponent(btn_3_B))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_NumDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(lbl_lastMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Resolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_NumDiscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_NumDiscosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_NumDiscosActionPerformed

    public void bloquearBotones() {
        btn_1_B.setEnabled(false);
        btn_1_C.setEnabled(false);
        btn_2_A.setEnabled(false);
        btn_2_C.setEnabled(false);
        btn_3_A.setEnabled(false);
        btn_3_B.setEnabled(false);
    }

    public void desbloquearBotones() {
        btn_1_B.setEnabled(true);
        btn_1_C.setEnabled(true);
        btn_2_A.setEnabled(true);
        btn_2_C.setEnabled(true);
        btn_3_A.setEnabled(true);
        btn_3_B.setEnabled(true);

    }

    private void btn_3_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3_AActionPerformed
        // TODO add your handling code here:
        try {
            boolean movimiento = juego.moverDisco(3, 1);
            if (movimiento) {
                lbl_lastMove.setText("Ultimo movimiento de 3 a 1");
                this.presentarTorre(3);
                this.presentarTorre(1);
            }
            if (juego.comprobarSiJuegoTermina()) {
                System.out.println(juego.imprimirHistorial());
                JOptionPane.showMessageDialog(null, "Felicidades gano\n"
                        + "Cantidad minima de movimientos" + juego.cantidadMinimaDeMovimientos()
                        + "\nMovimientos realizados: " + juego.obtenerTamanoHistorial());
            }
        } catch (JuegoExcepcion ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());;
        }
    }//GEN-LAST:event_btn_3_AActionPerformed

    private void btn_ResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResolverActionPerformed
        try {
            // TODO add your handling code here:
            this.simulacion();
        } catch (JuegoExcepcion ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());;
        }
    }//GEN-LAST:event_btn_ResolverActionPerformed

    class Simulacion implements Runnable {

        private ClsJuego juego;
        private InterfazHanoi interfaz;

        public Simulacion(ClsJuego juego, InterfazHanoi hanoi) {
            this.juego = juego;
            this.interfaz = hanoi;
        }

        @Override
        public void run() {
            try {
                ArrayList<Movimientos> movimientosASimular = this.juego.simuladorDeJuego();
                for (Movimientos movimiento : movimientosASimular) {
                    this.juego.moverDisco(movimiento.getOrigen(), movimiento.getDestino());
                    interfaz.presentarTorre(movimiento.getOrigen());
                    interfaz.presentarTorre(movimiento.getDestino());
                    Thread.sleep(500);
                }
                if (juego.comprobarSiJuegoTermina()) {
                    int tamanoHistorial = juego.obtenerTamanoHistorial();
                    System.out.println(juego.imprimirHistorial());
                    JOptionPane.showMessageDialog(null, "La maquina finalizo la simulacion\n"
                            + "Cantidad minima de movimientos" + juego.cantidadMinimaDeMovimientos()
                            + "\nMovimientos realizados por maquina: " + tamanoHistorial);
                    interfaz.bloquearBotones();
                }

            } catch (JuegoExcepcion ex) {
                System.out.println(ex.getMessage());
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());;
            }
        }
    }

    private void simulacion() throws JuegoExcepcion {
        Runnable simulacion = new Simulacion(juego, this);
        new Thread(simulacion).start();
    }

    private void btn_IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IniciarActionPerformed
        try {
            // TODO add your handling code here:
            juego.iniciarJuego(Integer.parseInt(cb_NumDiscos.getSelectedItem().toString()));
            this.desbloquearBotones();
            this.presentarTorre(1);
            this.presentarTorre(2);
            this.presentarTorre(3);

        } catch (JuegoExcepcion ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());;
        }
    }//GEN-LAST:event_btn_IniciarActionPerformed


    private void btn_1_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1_BActionPerformed
        try {
            boolean movimiento = juego.moverDisco(1, 2);
            if (movimiento) {
                lbl_lastMove.setText("Ultimo movimiento de 1 a 2");
                this.presentarTorre(1);
                this.presentarTorre(2);
            }
            if (juego.comprobarSiJuegoTermina()) {
                System.out.println(juego.imprimirHistorial());
                JOptionPane.showMessageDialog(null, "Felicidades gano\n"
                        + "Cantidad minima de movimientos" + juego.cantidadMinimaDeMovimientos()
                        + "\nMovimientos realizados: " + juego.obtenerTamanoHistorial());
            }

        } catch (JuegoExcepcion ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());;
        }
    }//GEN-LAST:event_btn_1_BActionPerformed

    private void btn_1_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1_CActionPerformed
        try {
            boolean movimiento = juego.moverDisco(1, 3);
            if (movimiento) {
                lbl_lastMove.setText("Ultimo movimiento de 1 a 3");
                this.presentarTorre(1);
                this.presentarTorre(3);
            }
            if (juego.comprobarSiJuegoTermina()) {
                System.out.println(juego.imprimirHistorial());
                JOptionPane.showMessageDialog(null, "Felicidades gano\n"
                        + "Cantidad minima de movimientos" + juego.cantidadMinimaDeMovimientos()
                        + "\nMovimientos realizados: " + juego.obtenerTamanoHistorial());

            }
        } catch (JuegoExcepcion ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());;
        }
    }//GEN-LAST:event_btn_1_CActionPerformed

    private void btn_2_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2_AActionPerformed
        // TODO add your handling code here:
        try {
            boolean movimiento = juego.moverDisco(2, 1);
            if (movimiento) {
                lbl_lastMove.setText("Ultimo movimiento de 2 a 1");
                this.presentarTorre(2);
                this.presentarTorre(1);
            }
            if (juego.comprobarSiJuegoTermina()) {
                System.out.println(juego.imprimirHistorial());
                JOptionPane.showMessageDialog(null, "Felicidades gano\n"
                        + "Cantidad minima de movimientos" + juego.cantidadMinimaDeMovimientos()
                        + "\nMovimientos realizados: " + juego.obtenerTamanoHistorial());
            }
        } catch (JuegoExcepcion ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());;
        }
    }//GEN-LAST:event_btn_2_AActionPerformed

    private void btn_2_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2_CActionPerformed
        // TODO add your handling code here:
        try {
            boolean movimiento = juego.moverDisco(2, 3);
            if (movimiento) {
                lbl_lastMove.setText("Ultimo movimiento de 2 a 3");
                this.presentarTorre(2);
                this.presentarTorre(3);
            }
            if (juego.comprobarSiJuegoTermina()) {
                System.out.println(juego.imprimirHistorial());
                JOptionPane.showMessageDialog(null, "Felicidades gano\n"
                        + "Cantidad minima de movimientos" + juego.cantidadMinimaDeMovimientos()
                        + "\nMovimientos realizados: " + juego.obtenerTamanoHistorial());

            }
        } catch (JuegoExcepcion ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());;
        }
    }//GEN-LAST:event_btn_2_CActionPerformed

    private void btn_3_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3_BActionPerformed
        // TODO add your handling code here:
        try {
            boolean movimiento = juego.moverDisco(3, 2);
            if (movimiento) {
                lbl_lastMove.setText("Ultimo movimiento de 3 a 2");
                this.presentarTorre(3);
                this.presentarTorre(2);
            }
            if (juego.comprobarSiJuegoTermina()) {
                System.out.println(juego.imprimirHistorial());
                JOptionPane.showMessageDialog(null, "Felicidades gano\n"
                        + "Cantidad minima de movimientos" + juego.cantidadMinimaDeMovimientos()
                        + "\nMovimientos realizados: " + juego.obtenerTamanoHistorial());

            }
        } catch (JuegoExcepcion ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());;
        }
    }//GEN-LAST:event_btn_3_BActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazHanoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazHanoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazHanoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazHanoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new InterfazHanoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_1_B;
    private javax.swing.JButton btn_1_C;
    private javax.swing.JButton btn_2_A;
    private javax.swing.JButton btn_2_C;
    private javax.swing.JButton btn_3_A;
    private javax.swing.JButton btn_3_B;
    private javax.swing.JButton btn_Iniciar;
    private javax.swing.JButton btn_Resolver;
    private javax.swing.JComboBox<String> cb_NumDiscos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label lbl_lastMove;
    private javax.swing.JTable tb_Torre1;
    private javax.swing.JTable tb_Torre2;
    private javax.swing.JTable tb_Torre3;
    // End of variables declaration//GEN-END:variables
}
