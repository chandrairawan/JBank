import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;

/**
 * Class ATMButtonHandler.
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */
public class ATMButtonHandler implements ActionListener
{
    private ATMGUI gui;
    private String newline = "\n\n";
    
    /**
     * Constructor for objects of class ATMButtonHandler
     * @param objek ATM GUI
     */
    public ATMButtonHandler(ATMGUI gui)
    {
        this.gui = gui;
    }
    
    /**
     * method override untuk handle event saat tombol atau button ditekan
     * @param event
     */
    public void actionPerformed(ActionEvent e)
    {
		if(e.getActionCommand().equals("deposit")) {
            if(locateAccount() != null) {
                depositAction(locateAccount(), gui.getAmount());
                Teller.editCustomer(Teller.getCustomer(gui.getID()));
            }
        }
        else if(e.getActionCommand().equals("withdraw")) {
            if(locateAccount() != null) {
                withdrawAction(locateAccount(), gui.getAmount());
                Teller.editCustomer(Teller.getCustomer(gui.getID()));
            }
        }
        else if(e.getActionCommand().equals("total")) {
            if(locateAccount() != null) {
                gui.setText("Total amount of money in Account " + locateAccount().getId() + ": Rp" + locateAccount().getBalance());
            }
        }
        else if(e.getActionCommand().equals("exit")) {
            JOptionPane.showMessageDialog(null, "You are exiting, goodbye!");
            System.exit(0);
        }
        else if(e.getActionCommand().equals("cust")) {
            System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new CustomerGUI();
                }
            });
        }
    }
    
    /**
     * Method locateAccount untuk mencari account berdasarkan input dari ATMGUI
     * @return account
     */
    public Account locateAccount()
    {
        Account a = null;
        Customer c = null;
        try {
            c = Teller.getCustomer(gui.getID());
            try {
                a = c.getAccount(gui.getAcctType());
            } catch (AccountTypeNotFoundException notfound) {
                gui.setText(notfound.getMessage());
            }
        } catch (NullPointerException e) {
            gui.setText("Customer ID does not exist");
        }
        return a;
    }
	
	/**
     * Method untuk melakukan withdraw
     * @param a Account
     * @param amount Jumlah uang yang akan diambil
     */
    public void withdrawAction(Account a, double amount)
    {
        try {
            a.withdraw(amount);
            gui.setText("" + a.getId() 
                        + " withdraws an amount of money: Rp" 
                        + gui.getAmount());
        } catch (AmountOverDrawnException e) {
            gui.setText(e.getMessage());
            JOptionPane.showMessageDialog(null, "Transaction failed");
        }
    }
    
    /**
     * Method untuk melakukan deposit
     * @param a Account
     * @param amount Jumlah uang yang akan disimpan
     */
    public void depositAction(Account a, double amount) {
        a.deposit(amount);
        gui.setText("" + a.getId() 
                    + " saves an amount of money: Rp" 
                    + gui.getAmount());
    }
}
