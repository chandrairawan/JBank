import java.io.*;
import java.util.*;

/**
 * class CustomerFileWriter untuk menuliskan info customer kedalam file customers.dat
 * 
 * @author Abdul Chandra Irawan - 1306405244
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
    
    /**
     * Method untuk file writer untuk informasi customer
     * 
     * @param customers
     */
    public void saveCustomers(SortedSet<Customer> customers)
    {
        try {
            objectFile = new File("dat/customers.dat");
            objectFile.createNewFile();
            fileOutputStream = new FileOutputStream(objectFile);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            try {
                objectOutputStream.writeObject(customers);
            } finally {
                objectOutputStream.close();
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

