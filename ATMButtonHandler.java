import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;

/**
 * Class ATMButtonHandler.
 * 
 * @author Abdul Chandra Irawan. 
 * @version 14.04.2016
 */
public class ATMButtonHandler implements ActionListener
{
    private ATMGUI gui;
    private String newline = "\n\n";
    
    /**
     * Constructor for objects of class ATMButtonHandler
     */
    public ATMButtonHandler(ATMGUI gui)
    {
        this.gui=gui;
    }
    
    public void actionPerformed(ActionEvent event)
    {
        JTextArea text = gui.text;
        if(event.getActionCommand().equals("Deposit")){
              text.append(newline + "Customer: " + gui.getIDcostumer() +" saves amount of money:" + gui.getNominal());
        }
        else if(event.getActionCommand().equals("Withdraw")){
            text.append(newline + "Customer: " + gui.getIDcostumer() +" withdraws amount of money:" + gui.getNominal());
        }
        else if(event.getActionCommand().equals("Exit")){
            JOptionPane.showMessageDialog(null,"You are Exiting, Thank you!");
            System.exit(0);
        }
        
    }
}
