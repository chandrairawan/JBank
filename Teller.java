
/**
 * JBank Phase 2.
 * 
 * @author (Abdul Chandra Irawan)
 * @NPM (1306405244)
 * @version (24-02-2016)
 */
public class Teller
{
    private Customer c1 = new Customer(); //perintah untuk membuat object Customer dan menyimpannya dalam variabel c1
    private Account a1 = new Account (); //objek Account
    private String fullname; //nama lengkap pelanggan yang mendaftar di teller
    private Account acc; //objek Account
    private double balance; //jumlah saldo
    
    public static void main(String[] args){
    }
    
    public Teller(){//Membuat fungsi teller
         c1.setName("Sutandi", "Sanadhi");
         fullname = c1.getName();
         
         System.out.println(fullname);
         
         a1.setBalance(20000);
         c1.setAccount(a1);
         
         acc = c1.getAccount();
         balance = acc.getBalance();
         
         System.out.println(balance);
    }
}
