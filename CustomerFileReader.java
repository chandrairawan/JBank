import java.io.*;
import java.util.*;

/**
 * Class CustomerFileReader untuk mambaca info semua customer dari file customers.dat.
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
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
    
    /**
     * Method readCustomer untuk membaca info customer dari file
     * @return SortedSet customer
     */
    public SortedSet<Customer> readCustomer()
    {
        SortedSet<Customer> customers = null;
        try {
            objectFile = new File("dat/customers.dat");
            fileInputStream = new FileInputStream(objectFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            try {
                customers = (SortedSet<Customer>) objectInputStream.readObject();
            } finally {
                objectInputStream.close();
                fileInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return customers;
    }
}
