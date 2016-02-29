
/**
 * JBank Phase 2.
 * 
 * @author (Abdul Chandra Irawan) 
 * @version (27-02-2016)
 * 
 */
public class Account
{
    //deklarasi variabel
    private char acctType;
    private double balance;
    private String id;
    private double predictBalance;
    
    public Account() {//membuat fungsi Account
        
    }
    
    public Account(char type, double amount) {//membuat fungsi Account
        
    }
    
    private void deposit(double amount) {//membuat fungsi deposit
        
    }
    
    public char getAcctType() {//membuat fungsi getAccType
        return acctType; //mengembalikan nilai atribut acctType untuk metode ini  
    }
    
    public double getBalance() {//membuat fungsi getBalance
        return balance;
    }
    
    public String getId() {//membuat fungsi getId
        return id; //mengembalikan nilai atribut acctType untuk metode ini
    }
    
    public void setBalance(double amount) {//membuat fungsi setBalance
        balance = amount; //memberikan nilai amount untuk atribut objek balance
    }
    
    public void setID(String acctId) {//membuat fungsi setID
        id = acctId; //memberikan nilai acctId untuk atribut objek ID
    }
    
    public void setAcctType(char code) {//membuat fungsi setAccType
        acctType = code; //menetapkan type dari acctType ke objek atribut acctType
    }
    
    public void withdraw(double amount) {//membuat fungsi withdraw
        
    }
}
