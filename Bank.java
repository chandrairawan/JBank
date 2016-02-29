
/**
 * JBank Program
 * Bank class
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 27.02.2016
 */
public class Bank
{
    /**
     * deklarasi variabel 
     */
    private static double creditInterestRate, investmentInterestRate,premiumInterestRate;
    private static int lastCustID = 1000, nextCustID = 1000;
    public static int maxNumOfCustomers = 20;
    private static String closeTime, phone, startTime;
    public static String website, bankName= "JBANK"; 
    public String bankAddress = "1234 JavaStreet, AnyCity, ThisState, 34567";
    
    //Tambahan
    private static int numOfCurrentCustomer, nextId;
    
    /**
     * membuat fungsi getAddress 
     */
    public static String getAddress() {
        return "";
    }
    
    /**
     * membuat fungsi getCreditRate
     */
    public static double getCreditRate() {
        return 0;
    }
    
    /**
     * membuat fungsi getInvestmentRate
     */
    public static double getInvestmentRate() {
        return 0;
    }

    /**
     * membuat fungsi getHoursOfOperation
     */
    public static String getHoursOfOperation() {
        return "";
    }
    
    /**
     * membuat fungsi getLastID
     */
    public static int getLastID() {
        return 0;
    }
    
    /**
     * membuat fungsi getMaxCustomers
     */
    public static int getMaxCustomers() {
        return 0;
    }
    
    /**
     * membuat fungsi getName
     */
    public static String getName() {
        return "";
    }
    
    /**
     * membuat fungsi getNextID
     */
    public static int getNextID() {
        return 0;
    }
    
    /**
     * membuat fungsi getWebsite
     */
    public static String getWebsite() {
        return "";
    }
    
    /**
     * membuat fungsi getPremiumRate
     */
    public static double getPremiumRate() {
        return 0;
    }
    
    /**
     * membuat fungsi getPhone
     */
    public static String getPhone() {
        return "";
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
    
    //Tambahan
    public static int getnumOfCurrentCustomer(){
        return numOfCurrentCustomer;
    }
    
    public int getNextId(){
        nextCustID = lastCustID + 1;
        lastCustID = lastCustID + 1;
        return nextCustID;
    }
}
