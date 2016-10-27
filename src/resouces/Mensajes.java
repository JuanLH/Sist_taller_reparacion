

package resouces;

import javax.swing.JOptionPane;

/**
 *
 * @author Ivan Reyes
 */
public class Mensajes 
{
     public void mensaje(String mensaje) 
    {
     JOptionPane.showMessageDialog(null,mensaje);
    }        
            
     public static int confirmar(java.awt.event.ActionEvent evt,String msj) 
     {                  
        /*
            O-->yes
            1-->no
            2-->cancel
         */ 
         
        return JOptionPane.showConfirmDialog(null, msj,"Selecciona uno", JOptionPane.YES_NO_CANCEL_OPTION);
     }                                             
 
    public void inputDialogActionPerformed(java.awt.event.ActionEvent evt) 
    {                                            
        JOptionPane.showInputDialog("Ingrese un dato");
    }                                           
 
    public static void mensajeError(java.awt.event.ActionEvent evt, String mensaje) 
    {                                              
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje Error", JOptionPane.ERROR_MESSAGE);
    }                                             
 
    public static void mensajeInfo(java.awt.event.ActionEvent evt,String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje Confirmacion", JOptionPane.INFORMATION_MESSAGE);
    }
    public void optionDialogActionPerformed(java.awt.event.ActionEvent evt) 
    {                                             
        Object[] options = { "Si", "Cancelar" };
        JOptionPane.showOptionDialog(null, "Clic en Si para continuar", "Advertencia",
        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0]);
    }
    
}
