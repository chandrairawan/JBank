import java.io.*;
import java.util.ArrayList;

/**
 * class CustomerFileWriter.
 * 
 * @author Abdul Chandra Irawan
 * @version 21.04.2016
 */
public class CustomerFileWriter
{
    private File objectFile;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    
    /**
     * Constructor for objects of class CustomerFileWriter
     */
    public CustomerFileWriter()
    {
    }
    
    public void saveCustomers(ArrayList<Customer> customers)
    {
        try {
            objectFile = new File("C:/Users/Aspire P3/Documents/GitHub/JBank/dat/customers.dat");
            fileOutputStream = new FileOutputStream(objectFile);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customers);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

