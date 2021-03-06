/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mant;

import database.entities.Articulo;
import database.entities.Empleados;
import database.entities.Suplidor;
import java.awt.event.ActionEvent;
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
public class mnt_articulo extends JDialogBase implements maintenance {

    /**
     * Creates new form mnt_articulo
     */
    Articulo selected_articulo = new Articulo();
    public mnt_articulo() {
        initComponents();
        
        try {
            cmbArea.setConn(Utilities.getConection().getConection());
            cmbArea.fillCombo("name", "areas");
            cmbArea.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(mnt_articulo.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public mnt_articulo(JDialogBase parent) {
        super(parent, true);
        initComponents();
        
        try {
            cmbArea.setConn(Utilities.getConection().getConection());
            cmbArea.fillCombo("name", "areas");
            cmbArea.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(mnt_articulo.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
    }
    
    public mnt_articulo(JFrame parent) {
        super(parent, true);
        initComponents();
        
        try {
            cmbArea.setConn(Utilities.getConection().getConection());
            cmbArea.fillCombo("name", "areas");
            cmbArea.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(mnt_articulo.class.getName())
                    .log(Level.SEVERE, null, ex);
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

        txtIdSupl = new Main.JlTextFields();
        jlLabel1 = new Main.jlLabel();
        txtNomSupl = new Main.JlTextFields();
        jButton1 = new javax.swing.JButton();
        jlLabel2 = new Main.jlLabel();
        txtNomArt = new Main.JlTextFields();
        jlLabel3 = new Main.jlLabel();
        txtCosto = new Main.JlTextFields();
        jlLabel4 = new Main.jlLabel();
        txtExistencia = new Main.JlTextFields();
        jlLabel5 = new Main.jlLabel();
        txtPuntReorden = new Main.JlTextFields();
        btnSeleccionar = new Main.JlButton();
        btnLimpiar = new Main.JlButton();
        btnGrabar = new Main.JlButton();
        btnMod = new Main.JlButton();
        btnEliminar = new Main.JlButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabArt = new javax.swing.JTable();
        btnPresent = new Main.JlButton();
        btnSalir = new Main.JlButton();
        jlLabel6 = new Main.jlLabel();
        cmbArea = new Main.JlComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlLabel1.setText("SUPLIDOR:");

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

        jlLabel2.setText("NOMBRE:");

        txtNomArt.setLimit(100);

        jlLabel3.setText("COSTO:");

        txtCosto.setKind(Main.KindTextField.NUMBER);
        txtCosto.setLimit(5);

        jlLabel4.setText("EXISTENCIA:");

        txtExistencia.setKind(Main.KindTextField.NUMBER);
        txtExistencia.setLimit(4);

        jlLabel5.setText("PUNTO REORDEN:");

        txtPuntReorden.setKind(Main.KindTextField.NUMBER);
        txtPuntReorden.setLimit(2);

        btnSeleccionar.setText("SELECCIONAR");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("NUEVO");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
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

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tabArt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabArt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabArtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabArt);

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

        jlLabel6.setText("AREA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtIdSupl, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNomSupl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNomArt, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 102, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPuntReorden, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 108, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPresent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdSupl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNomSupl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPuntReorden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPresent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
       

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new mnt_suplidor(this).setVisible(true);
        txtIdSupl.setText(Integer.toString(Suplidor.getSuplidor().getId()));
        txtNomSupl.setText(Suplidor.getSuplidor().getNombre());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        Articulo.setArticulo(selected_articulo);
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        clean();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        // TODO add your handling code here:
        if(check()){
            Articulo a = new Articulo();
            
            a.setId_suplidor(Integer.parseInt(txtIdSupl.getText()));
            a.setId_area(cmbArea.getSelectedIndex()+1);
            a.setName(txtNomArt.getText());
            a.setCost(Double.parseDouble(txtCosto.getText()));
            a.setExistencia(Integer.parseInt(txtExistencia.getText()));
            a.setPunto_reorden(Integer.parseInt(txtPuntReorden.getText()));
            
            try {
                a.insert(a);
                clean();
            } catch (SQLException ex) {
                Logger.getLogger(mnt_usuario.class.getName())
                .log(Level.SEVERE, null, ex);
                Mensajes.mensajeError(evt,"ERROR AL INSERTAR REGISTRO ");
            }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        if(check()){
            Articulo a = new Articulo();
            a.setId(selected_articulo.getId());
            a.setId_suplidor(Integer.parseInt(txtIdSupl.getText()));
            a.setId_area(cmbArea.getSelectedIndex()+1);
            a.setName(txtNomArt.getText());
            a.setCost(Double.parseDouble(txtCosto.getText()));
            a.setExistencia(Integer.parseInt(txtExistencia.getText()));
            a.setPunto_reorden(Integer.parseInt(txtPuntReorden.getText()));
            try {
                a.update(a);
                clean();
            } catch (SQLException ex) {
                Logger.getLogger(mnt_usuario.class.getName())
                .log(Level.SEVERE, null, ex);
                Mensajes.mensajeError(evt,"ERROR DE BASE DE DATOS ");
            }
        }
    }//GEN-LAST:event_btnModActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(check()){
            
            try {
                selected_articulo.delete(selected_articulo);
                clean();
            } catch (SQLException ex) {
                Logger.getLogger(mnt_usuario.class.getName())
                .log(Level.SEVERE, null, ex);
                Mensajes.mensajeError(evt,"ERROR DE BASE DE DATOS ");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tabArtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabArtMouseClicked
        // TODO add your handling code here:
        selected_articulo.setId((int) tabArt.getModel()
            .getValueAt(tabArt.getSelectedRow(), 0));
        selected_articulo.setId_suplidor((int) tabArt.getModel()
            .getValueAt(tabArt.getSelectedRow(), 1));
        selected_articulo.setId_area((int) tabArt.getModel()
            .getValueAt(tabArt.getSelectedRow(), 2));
        selected_articulo.setName((String) tabArt.getModel()
            .getValueAt(tabArt.getSelectedRow(), 3));
        selected_articulo.setCost(Double.parseDouble(tabArt.getModel()
            .getValueAt(tabArt.getSelectedRow(), 4).toString()));
        selected_articulo.setExistencia((int) tabArt.getModel()
            .getValueAt(tabArt.getSelectedRow(), 5));
        selected_articulo.setPunto_reorden((int) tabArt.getModel()
            .getValueAt(tabArt.getSelectedRow(), 6));

        llenar_campos(selected_articulo);
    }//GEN-LAST:event_tabArtMouseClicked

    private void btnPresentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresentActionPerformed
        // TODO add your handling code here:
        fill_table(evt);

    }//GEN-LAST:event_btnPresentActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(mnt_articulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mnt_articulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mnt_articulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mnt_articulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mnt_articulo().setVisible(true);
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
    private Main.JlComboBox cmbArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private Main.jlLabel jlLabel1;
    private Main.jlLabel jlLabel2;
    private Main.jlLabel jlLabel3;
    private Main.jlLabel jlLabel4;
    private Main.jlLabel jlLabel5;
    private Main.jlLabel jlLabel6;
    private javax.swing.JTable tabArt;
    private Main.JlTextFields txtCosto;
    private Main.JlTextFields txtExistencia;
    private Main.JlTextFields txtIdSupl;
    private Main.JlTextFields txtNomArt;
    private Main.JlTextFields txtNomSupl;
    private Main.JlTextFields txtPuntReorden;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean check() {
        if(isEmpy(txtIdSupl) || isEmpy(txtNomSupl) || isEmpy(txtNomArt) 
                || isEmpy(txtCosto) || isEmpy(txtExistencia) 
                || isEmpy(txtPuntReorden))
            return false;
        else
            return true;
    }

    @Override
    public void clean() {
        String txt = "";
        txtIdSupl.setText(txt);
        txtNomSupl.setText(txt);
        txtNomArt.setText(txt);
        txtCosto.setText(txt);
        txtExistencia.setText(txt);
        txtPuntReorden.setText(txt);
        
        btnGrabar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnMod.setEnabled(false);
        btnSeleccionar.setEnabled(false);
        
        
    }

    @Override
    public void fill_table(ActionEvent evt) {
        DefaultTableModel modelo = new DefaultTableModel();
        String [] cols = {
                "ID", "ID_SUPLIDOR","AREA", "NOMBRE", "COSTO", "EXISTENCIA",
                "PUNTO_REORDEN"};
        
        for (int i=0;i<cols.length;i++)
            modelo.addColumn(cols[i]);
        
        ArrayList<Articulo> list = null;
        try { 
            list = Articulo.select();
        } catch (SQLException ex) {
            Mensajes.mensajeError(evt, "DB");
            Logger.getLogger(mnt_empleado.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        int k;
            for(Articulo a : list){
                k=0;
                Object[] fila = new Object[7];
                fila[k++]=(Object)a.getId();
                fila[k++]=(Object)a.getId_suplidor();
                fila[k++]=(Object)a.getId_area();
                fila[k++]=(Object)a.getName();
                fila[k++]=(Object)a.getCost();
                fila[k++]=(Object)a.getExistencia();
                fila[k++]=(Object)a.getPunto_reorden();
                modelo.addRow(fila);
            }
            tabArt.setModel(modelo);
    }

    @Override
    public void llenar_campos(Object e) {
        if(e instanceof Articulo){
            Articulo a = (Articulo)e;
            txtIdSupl.setText(Integer.toString(a.getId_suplidor()));
            try {
                txtNomSupl.setText(
                        (String) Suplidor.get(a.getId_suplidor(), "name"));
            } catch (SQLException ex) {
                Logger.getLogger(mnt_articulo.class.getName())
                        .log(Level.SEVERE, null, ex);
                Mensajes.mensajeError(new ActionEvent(this,1, "Suplidor"),
                        "ERROR BUSCANDO EL NOMBRE DEL SUPLIDOR");
            }
            txtNomArt.setText(a.getName());
            txtCosto.setText(Double.toString(a.getCost()));
            txtExistencia.setText(Integer.toString(a.getExistencia()));
            txtPuntReorden.setText(Integer.toString(a.getPunto_reorden()));
            btnSeleccionar.setEnabled(true);
        }
    }
}
