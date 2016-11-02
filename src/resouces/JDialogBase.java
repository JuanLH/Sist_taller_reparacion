/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resouces;

import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.text.JTextComponent;

/**
 *
 * @author juanlht
 */
public class JDialogBase extends JDialog {

    public JDialogBase(Frame frame, boolean bln) {
        super(frame, bln);
    }

    public JDialogBase() {
    }

    public JDialogBase(Dialog dialog, boolean bln) {
        super(dialog, bln);
    }
    
    
    
    public boolean isEmpy(JTextComponent txt){
        if(txt.getText().equals(""))
            return true;
        else
            return false;
    }
}
