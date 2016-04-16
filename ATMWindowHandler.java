import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * class ATMWindowHandler.
 * 
 * @author Abdul Chandra Irawan 
 * @version 14.04.2016
 */
public class ATMWindowHandler extends WindowAdapter
{
    /**
     * Constructor for objects of class WindowHandler
     */
    public ATMWindowHandler()
    {
        
    }
    
    public void windowClosing(WindowEvent windowEvent) {
        JOptionPane.showMessageDialog(null, "You are exiting, goodbye!");
    }
}
