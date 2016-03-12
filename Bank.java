import java.util.*;
import java.text.SimpleDateFormat;

/**
 * JBank Program
 * Bank class
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 11.03.2016
 */


public class Bank
{
    /**
     * deklarasi variabel 
     */
    private static double creditInterestRate;
    private static double investmentInterestRate;
    private static double premiumInterestRate;
    private static int nextId; 
    private static int lastCustID; 
    private static int nextCustID;
    public static int maxNumOfCustomers = 20;
    private static Date closeTime;
    private static String phone;
    private static Date startTime;
    public static String website;
    public static int numOfCurrentCustomers;
    public static String bankName= "JBANK"; 
    public String bankAddress = "1234 JavaStreet, AnyCity, ThisState, 34567";
  
    private Bank(){
        
    }
   
    /*
     * membuat fungsi getAddress 
     *//*
    public static String getAddress() {
        return bankAddress;
    }*/
    
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
    }
    
    /**
     * membuat fungsi getLastID
     * @return lastCustID
     */
    public static int getLastID() {
        return lastCustID;
    }
    
    /**
     * membuat fungsi getMaxCustomers
     * @return maxNumOfCustomers
     */
    public static int getMaxCustomers() {
        return maxNumOfCustomers;
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
        if(numOfCurrentCustomers>=maxNumOfCustomers)
        {
           
        }
        else
        {
            numOfCurrentCustomers ++;
            if(nextCustID==0)
            {   
                nextCustID=1000;
                nextID=nextCustID;
            }
            else
            {
                lastCustID=nextCustID;
                nextCustID++;
                nextID=nextCustID;
            }
            
        }
        return nextID;
    }
    
    /**
     * membuat fungsi getWebsite
     * @return website
     */
    public static String getWebsite() {
        return website;
    }
    
    /**
     * membuat fungsi getPremiumRate
     * @return premiumInterestRate
     */
    public static double getPremiumRate() {
        return premiumInterestRate;
    }
    
    /**
     * membuat fungsi getPhone
     * @return phone
     */
    public static String getPhone() {
        return phone;
    }
    
    /**
     * membuat fungsi setCreditRate
     */
    public static void setCreditRate(double rate) {
        
    }
    
    /**
     * membuat fungsi setInvestmentRate
     */
    public static void setInvestmentRate(double rate) {
        
    }
    
    /**
     * membuat fungsi setPremium
     */
    public static void setPremium(double rate) {
    }
    
     /*
    public static int getMaxNumOfCustomers()
    {
        return maxNumOfCustomers;
    }
    */
   
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
     * Method setter untuk closeTime
     * @param closeTime
     */
    public static void setCloseTime(int hour, int min) {
        closeTime = new GregorianCalendar(0,0,0,hour, min).getTime();
    }
    
    /**
     * Method setter untuk startTime
     * @param startTime
     */
    public static void setStartTime(int hour, int min) {
        startTime = new GregorianCalendar(0,0,0,hour, min).getTime();
    }
}
