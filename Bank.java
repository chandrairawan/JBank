
/**
 * JBank Program
 * Bank class
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 05.03.2016
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
    private static String closeTime;
    private static String phone;
    private static String startTime;
    public static String website;
    public static int numOfCurrentCustomers;
    public static String bankName= "JBANK"; 
    public String bankAddress = "1234 JavaStreet, AnyCity, ThisState, 34567";
  
    private Bank(){
        
    }
   
    /**
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
     */
    public static String getHoursOfOperation() {
        return closeTime;
    }
    
    /**
     * membuat fungsi getLastID
     */
    public static int getLastID() {
        return lastCustID;
    }
    
    /**
     * membuat fungsi getMaxCustomers
     */
    public static int getMaxCustomers() {
        return maxNumOfCustomers;
    }
    
    /**
     * membuat fungsi getName
     */
    public static String getName() {
        return bankName;
    }
    
    /**
     * membuat fungsi getNextID
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
     */
    public static String getWebsite() {
        return website;
    }
    
    /**
     * membuat fungsi getPremiumRate
     */
    public static double getPremiumRate() {
        return premiumInterestRate;
    }
    
    /**
     * membuat fungsi getPhone
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
    
     /**
    public static int getMaxNumOfCustomers()
    {
        return maxNumOfCustomers;
    }
    */
   
    //Tambahan
    public static int getnumOfCurrentCustomers(){
        return numOfCurrentCustomers;
    }
    /*
    public int getNextId(){
        
    }*/
}
