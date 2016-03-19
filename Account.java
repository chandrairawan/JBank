
/**
 * JBank Program
 * Account class
 * 
 * @author Abdul Chandra Irawan - 1306405244 
 * @version 18.03.2016
 */
public class Account
{
    /**
     * Deklarasi variabel
     */
    private char acctType;
    private double balance;
    private String id;
    private double predictBalance;
    
    /**
     * membuat fungsi Account
     *//*
    public Account() {
        acctType = 'S';
        balance = 10.00;
    }*/
    
    /**
     * membuat fungsi Account
     */
    public Account(Customer cust, char type, double amount) {
        acctType = type;
        balance = amount;
        id = cust.getCustId()+ "" + type;
    }
    
    /**
     * membuat fungsi deposit
     * @param amount tidak boleh negatif
     * @return true, false
     */
    public boolean deposit(double amount) {
        if (amount >= 0)
        {
            balance += amount;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * membuat fungsi getAccType
     * @return atribut acctType
     */
    public char getAcctType() {
        return acctType;
    }
    
    /**
     * membuat fungsi getBalance
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * membuat fungsi getId
     * @return id
     */
    public String getId() {
        return id; 
    }
    
    /**
     * membuat fungsi setBalance
     * @param amount untuk atribut objek balance
     */
    public void setBalance(double amount) {
        balance = amount;
    }
    
    /**
     * membuat fungsi setID
     * @param acctId untuk atribut objek ID
     *//*
    public void setID(String acctId) {
        id = acctId;
    }*/
    
    /**
     * membuat fungsi setAccType
     * @param type dari acctType ke objek atribut acctType
     */
    public void setAcctType(char type) {
        acctType = type;
    }
    
    /**
     * membuat fungsi withdraw
     * @param amount, jumlah penarikan tidak boleh membuat balance menjadi negatif
     * @return true, false
     */
    public boolean withdraw(double amount) {
        predictBalance = balance - amount;
        
        if (predictBalance < 0)
        {
            return false;
        }
        else
        {
            balance = balance - amount;
            return true;
        }
    }
    
    public String toString() {
        System.out.println("Account Type  :   " + acctType);
        System.out.println("ID            :   " + id);
        System.out.println("Balance       :   " + balance);
        return "";
    }
}
