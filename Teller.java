
/**
 * JBank Program
 * Teller class
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 27.02.2016
 */
public class Teller
{
    /**
     * Deklarasi variabel class :
     */
    private Customer c1 = new Customer(); //Objek Customer dan menyimpannya dalam variabel c1
    private Account a1 = new Account (); //Objek Account
    private String fullname; //objek nama costumer
    private Account acct; //objek Account
    private double Balance; //objek balance
    
    public static void main(String[] args){
    }
    
    /**
     * Fungsi Teller
     */
    public Teller(){
         c1.setName("Sutandi", "Sanadhi");
         fullname = c1.getName();
         
         System.out.println(fullname);
         
         a1.setBalance(45000);
         c1.setAccount(a1);
         
         acct = c1.getAccount();
         Balance = a1.getBalance();
         
         System.out.println(Balance);
    }
}
