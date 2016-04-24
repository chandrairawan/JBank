import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 * class CustomerFileWriter.
 * 
 * @author Abdul Chandra Irawan
 * @version 24.04.2016
 */
public class CustomerFileWriter implements Serializable
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
    
    public void saveCustomers(ArrayList<Customer> customers) throws IOException
    {
        try {
            objectFile = new File("C:/Users/Aspire P3/Documents/GitHub/JBank/dat/CustomerData.dat");
            objectFile.createNewFile();
            fileOutputStream = new FileOutputStream(objectFile);
            BufferedOutputStream buffer = new BufferedOutputStream(fileOutputStream);
            objectOutputStream = new ObjectOutputStream(buffer);
            try{
                objectOutputStream.writeObject(customers);
            }
            finally{
                objectOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

