/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mant;

import database.entities.Servicio;
import database.entities.Vehiculo;
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
public class mnt_servicio extends JDialogBase implements maintenance {

    /**
     * Creates new form mnt_servicio
     */
    Servicio selected_servicio = new Servicio();
    public mnt_servicio() {
        initComponents();
        
        
        try {
            cmbArea.setConn(Utilities.getConection().getConection());
            cmbArea.fillCombo("name", "areas");
            cmbArea.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(mnt_servicio.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
    }
    
    public mnt_servicio(JDialogBase parent) {
        super(parent,true);
        initComponents();
        
        
        try {
            cmbArea.setConn(Utilities.getConection().getConection());
            cmbArea.fillCombo("name", "areas");
            cmbArea.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(mnt_servicio.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
    }
    
    public mnt_servicio(JFrame parent) {
        super(parent,true);
        initComponents();
        
        
        try {
            cmbArea.setConn(Utilities.getConection().getConection());
            cmbArea.fillCombo("name", "areas");
            cmbArea.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(mnt_servicio.class.getName())
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

        jlLabel1 = new Main.jlLabel();
        jlLabel2 = new Main.jlLabel();
        jlLabel3 = new Main.jlLabel();
        jlLabel4 = new Main.jlLabel();
        txtName = new Main.JlTextFields();
        txtCosto = new Main.JlTextFields();
        cmbArea = new Main.JlComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new Main.JlTextArea();
        btnSeleccionar = new Main.JlButton();
        btnGrabar = new Main.JlButton();
        btnMod = new Main.JlButton();
        btnLimpiar = new Main.JlButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbServicio = new javax.swing.JTable();
        btnPresent = new Main.JlButton();
        btnSalir = new Main.JlButton();
        btnEliminar = new Main.JlButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlLabel1.setText("Name:");

        jlLabel2.setText("Area:");

        jlLabel3.setText("Descripcion:");

        jlLabel4.setText("Costo:");

        txtName.setLimit(500);

        txtCosto.setLimit(9);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

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

        tbServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbServicioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbServicio);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPresent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                    .addComponent(btnPresent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        Servicio.setServicio(selected_servicio);
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(check()){
            Servicio s = new Servicio();
            s.setName(txtName.getText());
            s.setId_area(cmbArea.getSelectedIndex()+1);
            s.setDescripcion(txtDescripcion.getText());
            s.setCost(Double.parseDouble(txtCosto.getText()));
            try {
                s.insert(s);
            } catch (SQLException ex) {
                Logger.getLogger(mnt_vehiculo.class.getName()).
                log(Level.SEVERE, null, ex);
                System.out.println(ex.getSQLState());
            }

        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        if(check()){
            Servicio s = new Servicio();
            s.setId(selected_servicio.getId());
            s.setName(txtName.getText());
            s.setId_area(cmbArea.getSelectedIndex()+1);
            s.setDescripcion(txtDescripcion.getText());
            s.setCost(Double.parseDouble(txtCosto.getText()));

            try {
                s.update(s);
            } catch (SQLException ex) {
                Logger.getLogger(mnt_vehiculo.class.getName()).
                log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        clean();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbServicioMouseClicked
        // TODO add your handling code here:
        selected_servicio.setId((int)tbServicio.getModel()
            .getValueAt(tbServicio.getSelectedRow(), 0));
        selected_servicio.setName((String)tbServicio.getModel()
            .getValueAt(tbServicio.getSelectedRow(), 1));
        selected_servicio.setId_area((int) tbServicio.getModel()
            .getValueAt(tbServicio.getSelectedRow(), 2));
        selected_servicio.setDescripcion((String) tbServicio.getModel()
            .getValueAt(tbServicio.getSelectedRow(), 3));
        selected_servicio.setCost((Double) tbServicio.getModel()
            .getValueAt(tbServicio.getSelectedRow(), 4));
        llenar_campos(selected_servicio);

    }//GEN-LAST:event_tbServicioMouseClicked

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
            Servicio s = new Servicio();
            s.setId(selected_servicio.getId());
            s.setName(txtName.getText());
            s.setId_area(cmbArea.getSelectedIndex()+1);
            s.setDescripcion(txtDescripcion.getText());
            s.setCost(Double.parseDouble(txtCosto.getText()));

            try {
                s.delete(s);
            } catch (SQLException ex) {
                Logger.getLogger(mnt_vehiculo.class.getName()).
                log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(mnt_servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mnt_servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mnt_servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mnt_servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mnt_servicio().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Main.jlLabel jlLabel1;
    private Main.jlLabel jlLabel2;
    private Main.jlLabel jlLabel3;
    private Main.jlLabel jlLabel4;
    private javax.swing.JTable tbServicio;
    private Main.JlTextFields txtCosto;
    private Main.JlTextArea txtDescripcion;
    private Main.JlTextFields txtName;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean check() {
        if(isEmpy(txtName) || isEmpy(txtDescripcion) || isEmpy(txtCosto)){
            return false;
        }
        else
            return true;
    }

    @Override
    public void clean() {
        String txt="";
        txtName.setText(txt);
        txtCosto.setText(txt);
        txtDescripcion.setText(txt);
        
        
       
    }

    @Override
    public void fill_table(ActionEvent evt) {
        DefaultTableModel modelo = new DefaultTableModel();
        String [] cols = {
                "ID", "NAME", "ID_AREA", "DESCRIPCION",
                "COSTO"};
        
        for (int i=0;i<cols.length;i++)
            modelo.addColumn(cols[i]);
        
        ArrayList<Servicio> list = null;
        try { 
            list = Servicio.select();
        } catch (SQLException ex) {
            Mensajes.mensajeError(evt, "DB");
            Logger.getLogger(mnt_empleado.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        int k;
            for(Servicio s : list){
                k=0;
                Object[] fila = new Object[5];
                fila[k++]=(Object)s.getId();
                fila[k++]=(Object)s.getName();
                fila[k++]=(Object)s.getId_area();
                fila[k++]=(Object)s.getDescripcion();
                fila[k++]=(Object)s.getCost();
               
                modelo.addRow(fila);
            }
            tbServicio.setModel(modelo);
    }

    @Override
    public void llenar_campos(Object e) {
        if(e instanceof Servicio){
            Servicio service=(Servicio)e;
            txtName.setText(service.getName());
            txtCosto.setText(service.getCost().toString());
            txtDescripcion.setText(service.getDescripcion());
            cmbArea.setSelectedIndex(service.getId_area()-1);
        }
    }
}
