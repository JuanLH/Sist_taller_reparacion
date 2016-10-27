/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resouces;

import javax.swing.JFrame;
import javax.swing.text.JTextComponent;

/**
 *
 * @author juanlht
 */
public class Mant extends JFrame{
    
    private boolean isEmpy(JTextComponent txt){
        if(txt.getText().equals(""))
            return true;
        else
            return false;
    }
    
    
    
}
