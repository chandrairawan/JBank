import java.math.BigDecimal;
import java.lang.Math;
import java.math.MathContext;

/**
 * JBank Program
 * Class Account. 
 * 
 * @author Abdul Chandra Irawan - 1306405244 
 * @version 16.04.2016
 */
public abstract class Account
{
    /**
     * Deklarasi variabel
     */
    //private char acctType;
    protected double balance;
    protected String id;
    protected static MathContext mc = new MathContext(3);
    
    /**
     * membuat fungsi Account
     *//*
    public Account(char type, double amount) 
    {
        acctType = type;
        balance = amount;
    }*/
    
    /**
     * membuat fungsi Account
     *//*
    public Account(Customer cust, char type, double amount) 
    {
        acctType = type;
        balance = amount;
        id = cust.getCustId()+ "" + type;
    }*/
    
    /**
     * membuat fungsi deposit
     * @param amount tidak boleh negatif
     * @return true, false
     */
    public boolean deposit(double amount) 
    {
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
     *//*
    public char getAcctType() 
    {
        return acctType;
    }*/
    
    /**
     * membuat fungsi getBalance
     * @return balance
     */
    public double getBalance() 
    {
        return balance;
    }
    
    /**
     * membuat fungsi getId
     * @return id
     */
    public String getId() 
    {
        return id; 
    }
    
    /**
     * membuat fungsi setBalance
     * @param amount untuk atribut objek balance
     */
    public void setBalance(double amount) 
    {
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
     *//*
    public void setAcctType(char type) 
    {
        this.acctType = type;
    }*/
    
    /**
     * membuat fungsi withdraw
     * @param amount, jumlah penarikan tidak boleh membuat balance menjadi negatif
     * @return true, false
     */
    public abstract boolean withdraw(double amount) throws AmountOverDrawnException; 
    
    public String toString() 
    {
        if ( this instanceof Savings && !(this instanceof Investment)) {
            System.out.println("SAVING");
        } else if ( this instanceof LineOfCredit) {
            LineOfCredit l = (LineOfCredit)this;
            System.out.println("Line-Of-Credit");
            System.out.println("    Credit Balance:   "+ l.getCreditBalance());
            System.out.println("    Monthly Fee   :   "+ l.getMonthlyFee());
        } else if ( this instanceof OverDraftProtection) {
            OverDraftProtection o = (OverDraftProtection)this;
            System.out.println("Overdraft Protection");
            System.out.println("    Monthly Fee   :   "+ o.getMonthlyFee());
        } else if ( this instanceof Investment) {
            System.out.println("Investment");
        }
        System.out.println("    Balance       :   " + balance);
        return "";
    }
    
    /**
     */
    protected static double futureValue(double balance, double rate, double compound, double period) 
    {
        BigDecimal bal = new BigDecimal (balance);
        BigDecimal r = new BigDecimal (rate);
        BigDecimal n = new BigDecimal (compound);
        BigDecimal t = new BigDecimal (period);
        BigDecimal f1 = r.divide(n, mc.DECIMAL32).add(new BigDecimal(1));
        BigDecimal f2 = n.multiply(t, mc.DECIMAL32);
        BigDecimal f3 = new BigDecimal (Math.pow(f1.doubleValue(), f2.doubleValue()),mc.DECIMAL32);
        BigDecimal f4 = f3.multiply(bal, mc.DECIMAL32);
        return f4.doubleValue();
    }
}
