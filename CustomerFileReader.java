import java.io.*;
import java.util.ArrayList;

/**
 * Write a description of class CustomerFileReader here.
 * 
 * @author Abdul Chandra Irawan(1306405244) 
 * @version 24.04.2016
 */
public class CustomerFileReader
{
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;
    private File objectFile;
    
    /**
     * Constructor for objects of class CustomerFileReader
     */
    public CustomerFileReader()
    {
    }
    
    public ArrayList<Customer> readCustomer() throws IOException, ClassNotFoundException
    {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            objectFile = new File("C:/Users/Aspire P3/Documents/GitHub/JBank/dat/customers.dat");
            fileInputStream = new FileInputStream(objectFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            customers = (ArrayList<Customer>) objectInputStream.readObject();
            objectInputStream.close();
            //fileInputStream.close();
        } catch (Exception e) {
            System.out.println("Exception Happened :" + e.getMessage());
        }
        return customers;
    }
}
