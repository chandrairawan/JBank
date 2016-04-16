import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class ATMWindowHandler. 
 *
 * @author Abdul Chandra Irawan
 * @version 16.04.2016
 */
public class ATMWindowHandler extends WindowAdapter
{
   public void windowClosing(WindowEvent w){
       quitMessage();
       System.exit(0);
   }
   
   private void quitMessage(){
       JOptionPane.showMessageDialog(null,"You are exiting, Thank you! :)");
   }
}
