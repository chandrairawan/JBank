import java.util.*;
import java.text.*;
import java.io.*;
import java.time.*;

/**
 * JBank Program
 * Bank class untuk mengelola objek terkait bank
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */
public class Bank
{
    /**
     * deklarasi variabel 
     */
    private static double cInterestRate;
    private static Date closeTime;
    private static double iInterestRate;
    private static int lastCustID;
    private static int nextCustID;
    private static double pInterestRate;
    private static Date startTime;
    public static String address = "1234 JavaStreet, AnyCity, ThisState, 34567";
    public static int maxNumOfAcctsPerCustomers = 4;
    private static int MAX_NUM_OF_CUSTOMERS = 20;
    public static String Name= "JBANK"; 
    private static String phone;
    public static String website;
    private static int numOfCurrentCustomers;
    private static int nextID; 
    
	private static Customer[] customers = new Customer[MAX_NUM_OF_CUSTOMERS];
    /*static
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Input max number customer : ");
        int x = reader.nextInt();
        MAX_NUM_OF_CUSTOMERS = x;
        System.out.println ("Max Number of Customer : " +MAX_NUM_OF_CUSTOMERS);
    }*/
    
    /**
     * Method constructor Bank
     */
    public Bank()
    {
        
    }
   
    /**
     * Method untuk menambahkan customer kedalam array
     * @param customer 
     * @return True dan false
     */
    public static boolean addCustomer (Customer customer)
    {
        boolean customerAdded = false;
        int i = 0;
        if(numOfCurrentCustomers <= customers.length) {
            int notUsed = -1;
            for(i = 0; i < customers.length; i++) {
                if(customers[i] == null && notUsed == -1) {
                    notUsed = i;
                }
                else {
                    customerAdded = false;
                }
            }
            if(notUsed != -1) {
                customers[notUsed] = customer;
                customerAdded = true;
            }
        }
        return customerAdded;
    }
    
    public static Customer getCustomer(int custID)
    {
        Customer c = null;
        int i = 0;
        for(i = 0; i < customers.length; i++) {
            if(customers[i] != null && custID == customers[i].getCustID()) {
                c = customers[i];
                return c;
            }
        }
        return c;
    }

    
    /*
     * membuat fungsi getAddress 
     *//*
    public static String getAddress() 
    {
        return address;
    }*/
       
    
    /**
     * membuat fungsi getCreditRate
     */
    public static double getCreditRate() 
    {
        return cInterestRate;
    }
    
    /**
     * membuat fungsi getInvestmentRate
     */
    public static double getInvestmentRate() 
    {
        return iInterestRate;
    }

    /**
     * membuat fungsi getHoursOfOperation
     * @param simpleDateFormat
     * @return startTime TO closeTime
     */
    public static String getHoursOfOperation() 
    {
        Calendar start = new GregorianCalendar();
        start.set(Calendar.DAY_OF_WEEK, 2);
        start.set(Calendar.HOUR_OF_DAY, 9);
        start.set(Calendar.MINUTE, 0);
        startTime = start.getTime();
        Calendar close = new GregorianCalendar();
        close.set(Calendar.DAY_OF_WEEK, 6);
        close.set(Calendar.HOUR_OF_DAY, 17);
        close.set(Calendar.MINUTE, 0);
        closeTime = close.getTime();

        SimpleDateFormat hour = new SimpleDateFormat("k:mm");
        SimpleDateFormat day = new SimpleDateFormat("EEE");
        
        String openclose = day.format(startTime) + " TO " + day.format(closeTime) + " " + hour.format(startTime) + " TO " + hour.format(closeTime);
        
        return openclose;
    }
    
    /**
     * membuat fungsi getLastID
     * @return lastCustID
     */
    public static int getLastID() 
    {
        return lastCustID;
    }
    
    /**
     * membuat fungsi getMaxCustomers
     * @return maxNumOfCustomers
     */
    public static int getMaxCustomers() 
    {
        return MAX_NUM_OF_CUSTOMERS;
    }
    
    /**
     * membuat fungsi getName
     * @return bankName
     *//*
    public static String getName() 
    {
        return bankName;
    }*/
    
    /**
     * membuat fungsi getNextID
     * @param numOfCurrentCustomers, maxNumOfCustomers
     * @return nextID
     */
    public static int getNextID() 
    {
        if(nextCustID == 0) {
            nextCustID = 1000;
            lastCustID = 1000;
            numOfCurrentCustomers++;
            
            return nextCustID;
        }
        else if(numOfCurrentCustomers == MAX_NUM_OF_CUSTOMERS) {
            return 0;
        }
        else {
            lastCustID = nextCustID;
            nextCustID = lastCustID + 1;
            numOfCurrentCustomers++;
            
            return nextCustID;
        }
    }
    
    /**
     * membuat fungsi getPhone
     * @return phone
     */
    public static String getPhone() 
    {
        return phone;
    }
    
    /**
     * membuat fungsi getPremiumRate
     * @return premiumInterestRate
     */
    public static double getPremiumRate() 
    {
        return pInterestRate;
    }
    
    /**
     * membuat fungsi getWebsite
     * @return website
     */
    public static String getWebsite() 
    {
        return website;
    }
    
    /**
     * membuat fungsi setCreditRate
     */
    public static void setCreditRate(double rate) 
    {
        //creditInterestRate = rate;
    }
   
    /**
     * Method setter untuk closeTime
     * @param closeTime
     */
    public static void setCloseTime(int hour, int min) 
    {
        //closeTime = new GregorianCalendar(0,0,0,hour, min).getTime();
    }
    
    /**
     * membuat fungsi setInvestmentRate
     */
    public static void setInvestmentRate(double rate) 
    {
        //investmentInterestRate = rate;
    }
    
    /**
     * membuat fungsi setPremium
     */
    public static void setPremium(double rate) 
    {
        //premiumInterestRate = rate;
    }
    
    /**
     * Method setter untuk startTime
     * @param startTime
     */
    public static void setStartTime(int hour, int min) 
    {
        //startTime = new GregorianCalendar(0,0,0,hour, min).getTime();
    }
  
   
    //Tambahan
    /**
     * method getter untuk NumOfCurrentCustomers
     * @return numOfCurrentCustomers
     */
    public static int getNumOfCurrentCustomers()
    {
        return numOfCurrentCustomers;
    }
    
    /**
     * Method getter untuk closeTime
     * @return closeTime
     */
    public static Date getCloseTime()
    {
       return closeTime;
    }
    
    /**
     * Method getter untuk startTime
     * @return startTime
     */
    public static Date getStartTime()
    {
       return startTime;
    }
}
