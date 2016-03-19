import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * JBank Program
 * Bank class
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 18.03.2016
 */


public class Bank
{
    /**
     * deklarasi variabel 
     */
    private static double creditInterestRate;
    private static Date closeTime = null;
    private static double investmentInterestRate;
    private static int lastCustID;
    private static int nextCustID;
    private static double premiumInterestRate;
    private static Date startTime = null;
    public static String bankAddress = "1234 JavaStreet, AnyCity, ThisState, 34567";
    public static int maxNumOfAcctsPerCustomers = 4;
    private static int MAX_NUM_OF_CUSTOMERS;
    public static String bankName= "JBANK"; 
    private static String phone;
    public static String website;
    public static int numOfCurrentCustomers;
    private static int nextId; 
    private static Customer[] customers = new Customer[MAX_NUM_OF_CUSTOMERS];;
  
    
    static
    {
        System.out.println("Input max number customer : ");
        Scanner reader = new Scanner(System.in);
        int x = reader.nextInt();
        MAX_NUM_OF_CUSTOMERS = x;
    }
    
    
    public Bank(){
        
    }
   
    public static boolean addCustomer (Customer customer){
        for (int i=0; i < customers.length; i++){
            if(customers[i] == null){
                customers[i] = customer;
                return false;
            }
        }
        return false;
    }
    
    public static Customer getCustomer(int custID){
        for (int i=0; i<customers.length; i++){
            if(customers[i].getCustId() == custID){
                return customers[i];
            }
        }
        return null;
    }
    
    /*
     * membuat fungsi getAddress 
     */
    public static String getAddress() {
        return bankAddress;
    }
       
    
    /**
     * membuat fungsi getCreditRate
     */
    public static double getCreditRate() {
        return creditInterestRate;
    }
    
    /**
     * membuat fungsi getInvestmentRate
     */
    public static double getInvestmentRate() {
        return investmentInterestRate;
    }

    /**
     * membuat fungsi getHoursOfOperation
     * @param simpleDateFormat
     * @return startTime TO closeTime
     */
    public static String getHoursOfOperation() {
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm a");
        return ft.format(startTime) +" TO "+ ft.format(closeTime);
        //return new Date(ctime.getTime() - stime.getTime()); 
    }
    
    /**
     * membuat fungsi getLastID
     * @return lastCustID
     */
    public static int getLastID() {
        return lastCustID;
    }
    ///////////////////
    /**
     * membuat fungsi getMaxCustomers
     * @return maxNumOfCustomers
     */
    public static int getMaxCustomers() {
        //return maxNumOfCustomers;
        return MAX_NUM_OF_CUSTOMERS;
    }
    
    /**
     * membuat fungsi getName
     * @return bankName
     */
    public static String getName() {
        return bankName;
    }
    
    /**
     * membuat fungsi getNextID
     * @param numOfCurrentCustomers, maxNumOfCustomers
     * @return nextID
     */
    public static int getNextID() {
        int nextID=0;
        if(numOfCurrentCustomers==MAX_NUM_OF_CUSTOMERS)
        {
           nextID = 0;
           nextCustID = nextID;
        }
        else
        {
            if(nextCustID==0)
            {   
                lastCustID = 1000;
                nextID = 1000;
                //nextCustID=1000;
                nextCustID=nextID;
            }
            else
            {
                lastCustID=nextCustID;
                nextID = lastCustID+1;
                nextCustID=nextID;
                //nextID=nextCustID;
            }
            numOfCurrentCustomers ++;
        }
        return nextID;
    }
    
    /**
     * membuat fungsi getPhone
     * @return phone
     */
    public static String getPhone() {
        return phone;
    }
    
    /**
     * membuat fungsi getPremiumRate
     * @return premiumInterestRate
     */
    public static double getPremiumRate() {
        return premiumInterestRate;
    }
    
    /**
     * membuat fungsi getWebsite
     * @return website
     */
    public static String getWebsite() {
        return website;
    }
    
    /**
     * membuat fungsi setCreditRate
     */
    public static void setCreditRate(double rate) {
        creditInterestRate = rate;
    }
   
    /**
     * Method setter untuk closeTime
     * @param closeTime
     */
    public static void setCloseTime(int hour, int min) {
        closeTime = new GregorianCalendar(0,0,0,hour, min).getTime();
    }
    
    /**
     * membuat fungsi setInvestmentRate
     */
    public static void setInvestmentRate(double rate) {
        investmentInterestRate = rate;
    }
    
    /**
     * membuat fungsi setPremium
     */
    public static void setPremium(double rate) {
        premiumInterestRate = rate;
    }
    
    /**
     * Method setter untuk startTime
     * @param startTime
     */
    public static void setStartTime(int hour, int min) {
        startTime = new GregorianCalendar(0,0,0,hour, min).getTime();
    }
  
   
    //Tambahan
    /**
     * method getter untuk NumOfCurrentCustomers
     * @return numOfCurrentCustomers
     */
    public static int getNumOfCurrentCustomers(){
        return numOfCurrentCustomers;
    }
    
    /**
     * Method getter untuk closeTime
     * @return closeTime
     */
    public static Date getCloseTime(){
       return closeTime;
    }
    
    /**
     * Method getter untuk startTime
     * @return startTime
     */
    public static Date getStartTime(){
       return startTime;
    }
    
    /**
     * Menentukan waktu operasi
     * @return True, False
     */

    public boolean setHoursOfOperation(Date startTime, Date closeTime) {
        if (this.startTime != null || this.closeTime != null) {
            startTime = this.startTime;
            closeTime = this.closeTime;
            return true;
        } else {
            startTime = this.startTime;
            closeTime = this.closeTime;
            return false;
        }
    }
    
    public void printAllCustomers() {
        for (Customer c : customers) {
            if (c!=null)
                System.out.println(c);
        }
    }
}
