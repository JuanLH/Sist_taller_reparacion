/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mant;

import database.entities.Empleados;
import database.entities.Usuario;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
import resouces.Coordinates;
import resouces.Mant;
import resouces.Mensajes;
import resouces.Utilities;

/**
 *
 * @author juanlht
 */
public class mnt_empleado extends JDialog  {

    /**
     * Creates new form mnt_empleado
     */
    
    Empleados selected_employee=new Empleados();
    public mnt_empleado(JFrame form) {
        super(form, true);
        try {
            initComponents();
            cmbArea.setConn(Utilities.getConection().getConection());
            cmbArea.fillCombo("name", "areas");
            cmbArea.closeConn();
            clean();
        } catch (SQLException ex) {
            ActionEvent evt = new ActionEvent(this, 1,"DB");
            Mensajes.mensajeError(evt, "ERROR DE BASE DE DATOS");
        }
        
    }
    
    public mnt_empleado(Dialog form) {
        super(form, true);
        try {
            initComponents();
            cmbArea.setConn(Utilities.getConection().getConection());
            cmbArea.fillCombo("name", "areas");
            cmbArea.closeConn();
            clean();
        } catch (SQLException ex) {
            ActionEvent evt = new ActionEvent(this, 1,"DB");
            Mensajes.mensajeError(evt, "ERROR DE BASE DE DATOS");
        }
        
    }
    
    public mnt_empleado() {
        
        try {
            initComponents();
            cmbArea.setConn(Utilities.getConection().getConection());
            cmbArea.fillCombo("name", "areas");
            cmbArea.closeConn();
            clean();
        } catch (SQLException ex) {
            ActionEvent evt = new ActionEvent(this, 1,"DB");
            Mensajes.mensajeError(evt, "ERROR DE BASE DE DATOS");
        }
        
    }
    
    private boolean isEmpy(JTextComponent txt){
        if(txt.getText().equals(""))
            return true;
        else
            return false;
    }
    
    private void clean(){
        String txt="";
        txtCedula.setText(txt);
        txtNombre.setText(txt);
        txtApellido.setText(txt);
        txtSueldo.setText(txt);
        txtDireccion.setText(txt);
        txtTel.setText(txt);
        cmbFecha.setDate(null);
        btnMod.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnSeleccionar.setEnabled(false);
        fill_table(new ActionEvent(this,1, "Refresh"));
    }
    
    private boolean check(){
        if((isEmpy(txtCedula)) || isEmpy(txtNombre) || isEmpy(txtApellido)
                || isEmpy(txtSueldo) || isEmpy(txtDireccion) || isEmpy(txtTel)
                || cmbFecha.getDate()==null){
            return false;
        }
        else
            return true;
    }
    
    private void clean_table(JTable tabEmpleados){
        if (tabEmpleados.getRowCount() > 0) {
            for (int i = tabEmpleados.getRowCount() - 1; i > -1; i--) {
                tabEmpleados.remove(i);
            }
        }
    }
    
    private void fill_table(ActionEvent evt){
        DefaultTableModel modelo = new DefaultTableModel();
        String [] cols = {
                "CEDULA", "NOMBRE", "APELLIDO", "AREA", "SUELDO",
                "DIRECCION", "TELEFONO", "FECHA ENTRADA"};
        for (int i=0;i<cols.length;i++)
            modelo.addColumn(cols[i]);
        
        ArrayList<Empleados> list = null;
        try { 
            list = Empleados.select();
        } catch (SQLException ex) {
            Mensajes.mensajeError(evt, "DB");
            Logger.getLogger(mnt_empleado.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        int k;
            for(Empleados emp : list){
                k=0;
                Object[] fila = new Object[9];
                fila[k++]=(Object)emp.getCedula();
                fila[k++]=(Object)emp.getName();
                fila[k++]=(Object)emp.getLastname();
                fila[k++]=(Object)emp.getId_area();
                fila[k++]=(Object)emp.getSueldo();
                fila[k++]=(Object)emp.getAddress();
                fila[k++]=(Object)emp.getPhone();
                fila[k++]=(Object)emp.getEntry_date();
                modelo.addRow(fila);
            }
            tabEmpleados.setModel(modelo);
        
         
     }
     
     private void llenar_campos(Empleados e){
        txtCedula.setText(e.getCedula());
        txtNombre.setText(e.getName());
        txtApellido.setText(e.getLastname());
        cmbArea.setSelectedIndex(e.getId_area()-1);//because begin is 0
        txtSueldo.setText(Float.toString(e.getSueldo()));
        txtDireccion.setText(e.getAddress());
        txtTel.setText(e.getPhone());
        cmbFecha.setDate(e.getEntry_date());
         
        btnGrabar.setEnabled(false);
        btnMod.setEnabled(true);
        btnSeleccionar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtCedula.setEditable(false);
         
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCedula = new Main.JlTextFields();
        jlLabel1 = new Main.jlLabel();
        txtNombre = new Main.JlTextFields();
        jlLabel2 = new Main.jlLabel();
        txtApellido = new Main.JlTextFields();
        jlLabel3 = new Main.jlLabel();
        txtSueldo = new Main.JlTextFields();
        jlLabel4 = new Main.jlLabel();
        jlLabel5 = new Main.jlLabel();
        cmbArea = new Main.JlComboBox();
        jlLabel6 = new Main.jlLabel();
        jlLabel7 = new Main.jlLabel();
        cmbFecha = new org.jdesktop.swingx.JXDatePicker();
        btnGrabar = new Main.JlButton();
        btnMod = new Main.JlButton();
        btnEliminar = new Main.JlButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabEmpleados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDireccion = new Main.JlTextArea();
        btnSalir = new Main.JlButton();
        txtTel = new Main.JlTextFields();
        jlLabel8 = new Main.jlLabel();
        btnLimpiar = new Main.JlButton();
        btnPresent = new Main.JlButton();
        btnSeleccionar = new Main.JlButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MANTENIMIENTO DE  EMPLEADOS");
        setResizable(false);

        txtCedula.setKind(Main.KindTextField.NUMBER);

        jlLabel1.setText("CEDULA:");

        jlLabel2.setText("NOMBRE(S):");

        jlLabel3.setText("APELLIDO(S):");

        txtSueldo.setKind(Main.KindTextField.NUMBER);

        jlLabel4.setText("SUELDO:");

        jlLabel5.setText("AREA:");

        jlLabel6.setText("DIRECION:");

        jlLabel7.setText("FECHA INGRESO:");

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

        tabEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabEmpleados);

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        jScrollPane2.setViewportView(txtDireccion);

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtTel.setKind(Main.KindTextField.TELEPHONE);

        jlLabel8.setText("TELEFONO:");

        btnLimpiar.setText("NUEVO");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnPresent.setText("PRESENTAR");
        btnPresent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresentActionPerformed(evt);
            }
        });

        btnSeleccionar.setText("SELECCIONAR");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(195, 195, 195))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnPresent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(cmbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPresent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        clean();
        btnGrabar.setEnabled(true);
        txtCedula.setEditable(true);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        // TODO add your handling code here:
        if(check()){
            Empleados e = new Empleados();
            e.setCedula(txtCedula.getText());
            e.setName(txtNombre.getText());
            e.setLastname(txtApellido.getText());
            e.setId_area(cmbArea.getSelectedIndex()+1);//Because begin is 0
            e.setSueldo(Float.parseFloat(txtSueldo.getText()));
            e.setAddress(txtDireccion.getText());
            e.setPhone(txtTel.getText());
            e.setEntry_date(Utilities.getJxDate(cmbFecha));
            e.setStatus(0); //Status 0 = Available
            try {
                e.insert(e);
                clean();
            } catch (SQLException ex) {
                Mensajes.mensajeError(evt, "DB");
                Logger.getLogger(mnt_empleado.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
        else{
            Mensajes.mensajeError(evt, "NO DEJE CAMPOS EN BLANCO");
        }
        
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        int descision = Mensajes.confirmar(evt,"DESEA ELIMINAR EL EMPLEADO");
        if(descision !=0){
            return;
        }
        
        Empleados e = new Empleados();
        e.setCedula(txtCedula.getText());
        e.setName(txtNombre.getText());
        e.setLastname(txtApellido.getText());
        e.setId_area(cmbArea.getSelectedIndex()+1);//Because begin is 0
        e.setSueldo(Float.parseFloat(txtSueldo.getText()));
        e.setAddress(txtDireccion.getText());
        e.setPhone(txtTel.getText());
        e.setEntry_date(Utilities.getJxDate(cmbFecha));
        e.setStatus(0); //Status 0 = Available
        try {
            selected_employee.update(e);
            clean();  
        } catch (SQLException ex) {
            Logger.getLogger(mnt_empleado.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
          
        
    }//GEN-LAST:event_btnModActionPerformed

    private void btnPresentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresentActionPerformed
        // TODO add your handling code here:
        
        fill_table(evt);
    }//GEN-LAST:event_btnPresentActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tabEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabEmpleadosMouseClicked
        // TODO add your handling code here:
        selected_employee.setCedula((String) tabEmpleados.getModel().
                getValueAt(tabEmpleados.getSelectedRow(), 0));
        selected_employee.setName((String) tabEmpleados.getModel().
                getValueAt(tabEmpleados.getSelectedRow(), 1));
        selected_employee.setLastname((String) tabEmpleados.getModel().
                getValueAt(tabEmpleados.getSelectedRow(), 2));
        selected_employee.setId_area((int)tabEmpleados.getModel().
                getValueAt(tabEmpleados.getSelectedRow(), 3));
        selected_employee.setSueldo((Float) tabEmpleados.getModel().
                getValueAt(tabEmpleados.getSelectedRow(), 4));
        selected_employee.setAddress((String) tabEmpleados.getModel().
                getValueAt(tabEmpleados.getSelectedRow(), 5));
        selected_employee.setPhone((String) tabEmpleados.getModel().
                getValueAt(tabEmpleados.getSelectedRow(), 6));
        selected_employee.setEntry_date((Date) tabEmpleados.getModel().
                getValueAt(tabEmpleados.getSelectedRow(), 7));
        selected_employee.setStatus(0);// its present in the table is available
        
        
        llenar_campos(selected_employee);
        
    }//GEN-LAST:event_tabEmpleadosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int descision = Mensajes.confirmar(evt,"DESEA ELIMINAR EL EMPLEADO");
        if(descision !=0){
            return;
        }
        
        try {
            selected_employee.delete(selected_employee);
            clean();
        } catch (SQLException ex) {
            Mensajes.mensajeError(evt, "DB");
            Logger.getLogger(mnt_empleado.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        Empleados.setEmp(selected_employee);
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(mnt_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mnt_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mnt_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mnt_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mnt_empleado().setVisible(true);
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
    private org.jdesktop.swingx.JXDatePicker cmbFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Main.jlLabel jlLabel1;
    private Main.jlLabel jlLabel2;
    private Main.jlLabel jlLabel3;
    private Main.jlLabel jlLabel4;
    private Main.jlLabel jlLabel5;
    private Main.jlLabel jlLabel6;
    private Main.jlLabel jlLabel7;
    private Main.jlLabel jlLabel8;
    private javax.swing.JTable tabEmpleados;
    private Main.JlTextFields txtApellido;
    private Main.JlTextFields txtCedula;
    private Main.JlTextArea txtDireccion;
    private Main.JlTextFields txtNombre;
    private Main.JlTextFields txtSueldo;
    private Main.JlTextFields txtTel;
    // End of variables declaration//GEN-END:variables
}
