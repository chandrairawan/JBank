import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;
/**
 * GUI button handler
 * 
 * @author Danan Arya Pradana 1306368583 
 * @version 2016.04.07 (Modul 7)
 */
public class ATMButtonHandler implements ActionListener
{
    public String ID;
    public BigDecimal amount = new BigDecimal(5000000000.00);
    public BigDecimal amountEntered;
    public String text;
    public JTextField idfield;
    public JTextField amountfield;
    public JTextArea textarea;
    
    /**
     * Constructor for objects of class ATMButtonHandler
     */
    public ATMButtonHandler(JTextField idfield, JTextField amountfield, JTextArea textarea)
    {
        this.idfield = idfield;
        this.amountfield = amountfield;
        this.textarea = textarea;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        this.ID = idfield.getText();
        this.amountEntered = new BigDecimal(Double.parseDouble(amountfield.getText()));

        if(e.getActionCommand().equals("deposit")) {
            this.amount = amount.add(amountEntered);
            textarea.setText("" + ID 
                + " saves an amount of money: Rp" 
                + amountfield.getText());
        }
        else if(e.getActionCommand().equals("withdraw")) {
            if(amountEntered.compareTo(amount) > 0) {
                JOptionPane.showMessageDialog(null, "Transaction failed");
            }
            else {
                this.amount = amount.subtract(amountEntered);
                textarea.setText("" + ID 
                    + " withdraws an amount of money: Rp" 
                    + amountfield.getText());
            }
        }
        else if(e.getActionCommand().equals("total")) {
            textarea.setText("Total amount of money in ATM: Rp" + amount);
        }
        else if(e.getActionCommand().equals("exit")) {
            JOptionPane.showMessageDialog(null, "You are exiting, goodbye!");
            System.exit(0);
        }
    }
    
    public String getID()
    {
        return ID;
    }
    
    public BigDecimal getAmount() 
    {
        return amount;
    }
    
    public String getText()
    {
        return text;
    }
    
    public void setText(String text)
    {
        this.text = text;
    }
}
