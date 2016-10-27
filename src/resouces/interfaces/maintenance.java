/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resouces.interfaces;

import java.awt.event.ActionEvent;
import javax.swing.text.JTextComponent;

/**
 *
 * @author juanlht
 */
public interface maintenance {
    public boolean check();
    public void clean();
    public void fill_table(ActionEvent evt);
    public void llenar_campos(Object e);
}
