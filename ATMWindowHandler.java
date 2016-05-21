import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class ATMWindowHandler. 
 *
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */
public class ATMWindowHandler extends WindowAdapter
{
	/**
     * Constructor for objects of class WindowHandler
     */
    public ATMWindowHandler()
    {
    }    
    
   public void windowClosing(WindowEvent windowEvent){
       quitMessage();
       System.exit(0);
   }
   
   private void quitMessage(){
       JOptionPane.showMessageDialog(null,"You are exiting, Thank you! :)");
   }
}
