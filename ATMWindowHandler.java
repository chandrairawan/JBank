import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * GUI window handler
 * 
 * @author Danan Arya Pradana 1306368583 
 * @version 2016.04.07 (Modul 7)
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
