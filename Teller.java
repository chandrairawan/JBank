import java.util.*;
import java.math.*;
import java.text.*;
import java.time.*;
import java.lang.*;
import java.io.*;


/**
 * JBank Program
 * Class Teller yang menjadi main class dari JBank Program.
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */

public class Teller
{
    private static SortedSet<Customer> customers = new TreeSet<Customer>();
    
    /**
     * Constructor untuk objek Teller
     */
    public Teller()
    {
        CustomerFileReader reader = new CustomerFileReader();
        customers = new TreeSet<Customer>(reader.readCustomer());
    }
    
    /**
     * method untuk membuat customer baru
     * @param c Customer yang akan disimpan
	 */
    public static void createNewCustomer (Customer c)
    {
        customers.add(c);
        CustomerFileWriter writer = new CustomerFileWriter();
        writer.saveCustomers(customers);
    }
    
	/**
     * Method untuk mencari customer dalam SortedSet
     * @param custID
     * @return Customer
     */
    public static Customer getCustomer(int custID) 
    {
        Customer cust = null;
        Iterator<Customer> itr = customers.iterator();
        while(itr.hasNext()) {
            cust = itr.next();
            if(cust.getCustID() == custID) {
                return cust;
            }
            else {
                cust = null;
            }
        }
        return cust;
    }
	
    /**
     * Main Method dalam Teller Class
     */
    public static void main(String[] args)
    {
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Teller();
                new ATMGUI();
            }
        });
    }
	
    /**
     * Method untuk meng-edit customer dalam SortedSet
     * @param custID
     * @return Customer
     */
    public static void editCustomer(Customer c) 
    {
        Iterator<Customer> itr = customers.iterator();
        while(itr.hasNext()) {
            if(itr.next().getCustID() == c.getCustID()) {
                itr.remove();
            }
        }
        createNewCustomer(c);
    }
}