import java.io.Serializable;

/**
 * JBank Program
 * Class Abstract Account. 
 * 
 * @author Abdul Chandra Irawan - 1306405244 
 * @version 21.04.2016
 */
public abstract class Account implements Serializable
{
    protected double balance;
    protected String ID;
    
    /**
     * Metode Constructor membuat fungsi Account
	 * @param customer, amount dan type 
     *//*
    public Account(Customer cust, char type, double amount) 
    {
        this.acctType = type;
        this.balance = amount;
        this.ID = cust.getCustId()+ "" + type;
    }*/
    
    /**
     * membuat fungsi deposit
     * @param (amount) uang yang simpan tidak boleh negatif
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
     * @return ID
     */
    public String getId() 
    {
        return ID; 
    }
    
    /**
     * membuat fungsi setBalance
     * @param amount untuk atribut objek balance
     */
    public void setBalance(double amount) 
    {
        this.balance = amount;
    }
    
    /**
     * membuat fungsi setID
     * @param acctId untuk atribut objek ID
     *//*
    public void setID(String acctId) {
        ID = acctId;
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
    public abstract void withdraw(double amount) throws AmountOverDrawnException; 
    
	/**
     * Metode untuk mendapatkan no ID
     * @return No ID
     */
    @Override
    public String toString() 
    {
        return ID;
    }
}
