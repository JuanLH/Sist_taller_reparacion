/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resouces.components;

import database.entities.Modelo_Vehiculo;
import database.entities.Vehiculo;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.MutableComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author juanlht
 */
public class ComboModelo implements MutableComboBoxModel<Modelo_Vehiculo>{

    ArrayList<Modelo_Vehiculo> list;
    ArrayList <String> columns ;
    Modelo_Vehiculo selected;
    public ComboModelo() {
        list = new ArrayList<>();
        selected = new Modelo_Vehiculo();
        columns = new ArrayList();
    }

    @Override
    public void addElement(Modelo_Vehiculo e) {
        list.add(e);
        columns.add(e.getName());
        
    }

    @Override
    public void removeElement(Object o) {
    }

    @Override
    public void insertElementAt(Modelo_Vehiculo e, int i) {
    }

    @Override
    public void removeElementAt(int i) {
    }

    

    @Override
    public Modelo_Vehiculo getElementAt(int i) {
        return list.get(i);
    }

    @Override
    public void addListDataListener(ListDataListener ll) {
    }

    @Override
    public void removeListDataListener(ListDataListener ll) {
    }

   

    @Override
    public void setSelectedItem(Object o) {
        if(o instanceof String){
            String nameMod = (String)o;
            for(Modelo_Vehiculo mod : list){
                if(nameMod.equals(mod.getName())){
                    selected = mod;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

    @Override
    public int getSize() {
        return list.size();
    }
    
    
    
    
   
    
}
