
/**
 * JBank Program
 * Account class
 * 
 * @author Abdul Chandra Irawan - 1306405244 
 * @version 27.02.2016
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
     */
    public Account() {
        
    }
    
    /**
     * membuat fungsi Account
     */
    public Account(char type, double amount) {
        
    }
    
    /**
     * membuat fungsi deposit
     * @param amount tidak boleh negatif
     */
    public void deposit(double amount) {
        if (amount > 0)
        {
            balance = balance + amount;
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
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
     */
    public void setID(String acctId) {
        id = acctId;
    }
    
    /**
     * membuat fungsi setAccType
     * @param code dari acctType ke objek atribut acctType
     */
    public void setAcctType(char code) {
        acctType = code;
    }
    
    /**
     * membuat fungsi withdraw
     * @param amount, jumlah penarikan tidak boleh membuat balance menjadi negatif
     */
    public void withdraw(double amount) {
        predictBalance = balance - amount;
        
        if (predictBalance < 0)
        {
            System.out.println("false");
        }
        else
        {
            balance = balance - amount;
            System.out.println("true");
        }
    }
}
