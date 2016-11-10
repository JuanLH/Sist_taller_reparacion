/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mant;

import database.entities.Cliente;
import database.entities.Modelo;
import database.entities.Orden;
import database.entities.Servicio;
import database.entities.Vehiculo;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import resouces.JDialogBase;
import resouces.Mensajes;
import resouces.Utilities;
import resouces.interfaces.maintenance;

/**
 *
 * @author juanlht
 */
public class mnt_orden extends JDialogBase implements maintenance {

    /**
     * Creates new form mnt_orden
     */
    Orden selected_orden = new Orden();
    
    public mnt_orden() {
        initComponents();
        
        try {
            Connection cnn = Utilities.getConection().getConection();
            cmbEstado.setConn(cnn);
            cmbEstado.fillCombo("name","estado_orden");
            cmbServicio.setConn(cnn);
            cmbServicio.fillCombo("name","servicios");
            cmbServicio.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(mnt_orden.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public mnt_orden(JDialogBase parent) {
        super(parent,true);
        initComponents();
        
        try {
            Connection cnn = Utilities.getConection().getConection();
            cmbEstado.setConn(cnn);
            cmbEstado.fillCombo("name","estado_orden");
            cmbServicio.setConn(cnn);
            cmbServicio.fillCombo("name","servicios");
            cmbServicio.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(mnt_orden.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public mnt_orden(JFrame parent) {
        super(parent,true);
        initComponents();
        
        try {
            Connection cnn = Utilities.getConection().getConection();
            cmbEstado.setConn(cnn);
            cmbEstado.fillCombo("name","estado_orden");
            cmbServicio.setConn(cnn);
            cmbServicio.fillCombo("name","servicios");
            cmbServicio.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(mnt_orden.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jlLabel1 = new Main.jlLabel();
        jlLabel2 = new Main.jlLabel();
        jlLabel3 = new Main.jlLabel();
        cmbServicio = new Main.JlComboBox();
        cmbEstado = new Main.JlComboBox();
        btnSeleccionar = new Main.JlButton();
        btnGrabar = new Main.JlButton();
        btnMod = new Main.JlButton();
        btnLimpiar = new Main.JlButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbOrdenes = new javax.swing.JTable();
        btnPresent = new Main.JlButton();
        btnSalir = new Main.JlButton();
        btnEliminar = new Main.JlButton();
        txtPlaca = new Main.JlTextFields();
        txtVehiculo = new Main.JlTextFields();
        txtCliente = new Main.JlTextFields();
        jlLabel4 = new Main.jlLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new Main.JlTextArea();
        jButton1 = new javax.swing.JButton();
        rbListos = new javax.swing.JRadioButton();
        rbEspera = new javax.swing.JRadioButton();
        rbProceso = new javax.swing.JRadioButton();
        rbFacturadas = new javax.swing.JRadioButton();
        rbCotizada = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlLabel1.setText("SERVICIO:");

        jlLabel2.setText("VEHICULO:");

        jlLabel3.setText("ESTADO:");

        btnSeleccionar.setText("SELECCIONAR");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnGrabar.setText("GRABAR");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnMod.setText("MODIFICAR");
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        btnLimpiar.setText("NUEVO");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tbOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOrdenesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbOrdenes);

        btnPresent.setText("PRESENTAR");
        btnPresent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresentActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        jlLabel4.setText("DESCRIPCION:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resouces/img/lupa.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbListos);
        rbListos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        rbListos.setText("LISTOS");

        buttonGroup1.add(rbEspera);
        rbEspera.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        rbEspera.setText("EN ESPERA");

        buttonGroup1.add(rbProceso);
        rbProceso.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        rbProceso.setText("EN PROCESO");

        buttonGroup1.add(rbFacturadas);
        rbFacturadas.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        rbFacturadas.setText("FACTURADAS");

        buttonGroup1.add(rbCotizada);
        rbCotizada.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        rbCotizada.setText("COTIZADAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jlLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbCotizada)
                                .addGap(18, 18, 18)
                                .addComponent(rbEspera)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(rbProceso)
                                .addGap(18, 18, 18)
                                .addComponent(rbListos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbFacturadas)
                                .addGap(40, 40, 40)
                                .addComponent(btnPresent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jlLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jlLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPresent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbEspera)
                    .addComponent(rbListos)
                    .addComponent(rbProceso)
                    .addComponent(rbFacturadas)
                    .addComponent(rbCotizada))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(check()){
            Orden o = new Orden();
            o.setId_servicio(cmbServicio.getSelectedIndex()+1);
            o.setId_vehiculo(txtPlaca.getText());
            o.setDescripcion(txtDescripcion.getText());
            o.setId_estado_orden(cmbEstado.getSelectedIndex()+1);
            try {
                o.insert(o);
            } catch (SQLException ex) {
                Logger.getLogger(mnt_vehiculo.class.getName()).
                log(Level.SEVERE, null, ex);
                System.out.println(ex.getSQLState());
            }

        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        if(check()){
            Orden o = new Orden();
            o.setId(selected_orden.getId());
            o.setId_servicio(cmbServicio.getSelectedIndex()+1);
            o.setId_vehiculo(txtPlaca.getText());
            o.setDescripcion(txtDescripcion.getText());
            o.setId_estado_orden(cmbEstado.getSelectedIndex()+1);
            try {
                o.update(o);
            } catch (SQLException ex) {
                Logger.getLogger(mnt_vehiculo.class.getName()).
                log(Level.SEVERE, null, ex);
                System.out.println(ex.getSQLState());
            }

        }
    }//GEN-LAST:event_btnModActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        clean();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOrdenesMouseClicked
        // TODO add your handling code here:
        selected_orden.setId((int)tbOrdenes.getModel()
            .getValueAt(tbOrdenes.getSelectedRow(), 0));
        selected_orden.setId_servicio((int)tbOrdenes.getModel()
            .getValueAt(tbOrdenes.getSelectedRow(), 1));
        selected_orden.setId_vehiculo((String) tbOrdenes.getModel()
            .getValueAt(tbOrdenes.getSelectedRow(), 2));
        selected_orden.setDescripcion((String) tbOrdenes.getModel()
            .getValueAt(tbOrdenes.getSelectedRow(), 3));
        selected_orden.setEntry_date((Date) tbOrdenes.getModel()
            .getValueAt(tbOrdenes.getSelectedRow(), 4));
        
        selected_orden.setId_estado_orden((int) tbOrdenes.getModel()
            .getValueAt(tbOrdenes.getSelectedRow(), 5));
        selected_orden.setDeparture_date((Date) tbOrdenes.getModel()
            .getValueAt(tbOrdenes.getSelectedRow(), 6));
        llenar_campos(selected_orden);
    }//GEN-LAST:event_tbOrdenesMouseClicked

    private void btnPresentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresentActionPerformed
        // TODO add your handling code here:
        fill_table(evt);
    }//GEN-LAST:event_btnPresentActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(check()){
            Orden o = new Orden();
            o.setId(selected_orden.getId());
            o.setId_servicio(cmbServicio.getSelectedIndex()+1);
            o.setId_vehiculo(txtPlaca.getText());
            o.setDescripcion(txtDescripcion.getText());
            o.setId_estado_orden(cmbEstado.getSelectedIndex()+1);
            try {
                o.delete(o);
            } catch (SQLException ex) {
                Logger.getLogger(mnt_vehiculo.class.getName()).
                log(Level.SEVERE, null, ex);
                System.out.println(ex.getSQLState());
            }

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        new mnt_vehiculo(this).setVisible(true);
        txtPlaca.setText(Vehiculo.getVehiculo().getChapa());
        try {
            txtVehiculo.setText(Modelo.get(Vehiculo.getVehiculo().
                    getChapa()).getName());
            txtCliente.setText((String)Cliente.get("name",Vehiculo.getVehiculo().getId_cliente()));
        } catch (SQLException ex) {
            Logger.getLogger(mnt_orden.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

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
            java.util.logging.Logger.getLogger(mnt_orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mnt_orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mnt_orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mnt_orden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mnt_orden().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Main.JlButton btnEliminar;
    private Main.JlButton btnGrabar;
    private Main.JlButton btnLimpiar;
    private Main.JlButton btnMod;
    private Main.JlButton btnPresent;
    private Main.JlButton btnSalir;
    private Main.JlButton btnSeleccionar;
    private javax.swing.ButtonGroup buttonGroup1;
    private Main.JlComboBox cmbEstado;
    private Main.JlComboBox cmbServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Main.jlLabel jlLabel1;
    private Main.jlLabel jlLabel2;
    private Main.jlLabel jlLabel3;
    private Main.jlLabel jlLabel4;
    private javax.swing.JRadioButton rbCotizada;
    private javax.swing.JRadioButton rbEspera;
    private javax.swing.JRadioButton rbFacturadas;
    private javax.swing.JRadioButton rbListos;
    private javax.swing.JRadioButton rbProceso;
    private javax.swing.JTable tbOrdenes;
    private Main.JlTextFields txtCliente;
    private Main.JlTextArea txtDescripcion;
    private Main.JlTextFields txtPlaca;
    private Main.JlTextFields txtVehiculo;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean check() {
        if(isEmpy(txtPlaca) || isEmpy(txtCliente) || 
                txtDescripcion.getText().isEmpty() || isEmpy(txtVehiculo))
            return false;
        else
            return true;       
    }

    @Override
    public void clean() {
        String txt = "";
        txtCliente.setText(txt);
        txtDescripcion.setText(txt);
        txtPlaca.setText(txt);
        txtVehiculo.setText(txt);
    }

    @Override
    public void fill_table(ActionEvent evt) {
        DefaultTableModel modelo = new DefaultTableModel();
        String [] cols = {
                "ID", "SERVICIO", "VEHICULO","DESCRIPCION", "ENTRADA",
                "ESTADO","SALIDA"};
        
        for (int i=0;i<cols.length;i++)
            modelo.addColumn(cols[i]);
        
        ArrayList<Orden> list = null;
        try { 
            
            if(rbCotizada.isSelected())
                list = Orden.select(1);
            else if(rbEspera.isSelected())
                list = Orden.select(2);
            else if(rbProceso.isSelected())
                list = Orden.select(3);
            else if(rbListos.isSelected())
                list = Orden.select(4);
            else if(rbFacturadas.isSelected())  
                list = Orden.select(5);
            
            
        } catch (SQLException ex) {
            Mensajes.mensajeError(evt, "DB");
            Logger.getLogger(mnt_empleado.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        int k;
            for(Orden s : list){
                k=0;
                Object[] fila = new Object[7];
                fila[k++]=(Object)s.getId();
                fila[k++]=(Object)s.getId_servicio();
                fila[k++]=(Object)s.getId_vehiculo();
                fila[k++]=(Object)s.getDescripcion();
                fila[k++]=(Object)s.getEntry_date();
                fila[k++]=(Object)s.getId_estado_orden();
                fila[k++]=(Object)s.getDeparture_date();
                modelo.addRow(fila);
            }
            tbOrdenes.setModel(modelo);
    }

    @Override
    public void llenar_campos(Object e) {
        if(e instanceof Orden){
            Orden or = (Orden)e;
            cmbServicio.setSelectedIndex(or.getId_servicio()-1);
            txtPlaca.setText(or.getId_vehiculo());
            txtDescripcion.setText(or.getDescripcion());
            
            try {
                txtVehiculo.setText(Modelo.get(or.getId_vehiculo()).getName());
                txtCliente.setText((String)Cliente.get
                ("name",Vehiculo.get(or.getId_vehiculo()).getId_cliente()));
            } catch (SQLException ex) {
                Logger.getLogger(mnt_orden.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
            cmbEstado.setSelectedIndex(or.getId_estado_orden()-1);
        }
    }
}
