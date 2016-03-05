import java.util.*;

/**
 * JBank Program
 * Customer class
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 05.03.2016
 */

public class Teller
{
	/**
     * Deklarasi variabel class :
     */
    //public Customer c1 = new Customer(); //Objek Customer dan menyimpannya dalam variabel c1
    //public Account a1 = new Account (); //Objek Account
    //public String fullname; //objek nama costumer
    //public Account acct; //objek Account
    //public double Balance; //objek balance
	
    
    /**
     * Main Method in Teller Class
     */
    public static void main(String args[]){
        // Tugas 4 Modul 3
        String user_c;
        String nama_depan;
        String nama_belakang;
        String dob;
        String no_telp;
        String acct_type;
        int bal;

        
        Scanner scan = new Scanner(System.in);
        Scanner cycle = new Scanner(System.in);
        ArrayList array = new ArrayList();
        
        System.out.println("Apakah anda ingin membuat customer? Ya/Tidak");
        user_c = scan.nextLine();
        if(user_c.equalsIgnoreCase("Ya")){
            //membuat array variable untuk object customer
            Customer[] c = new Customer[20];
            Account[] a = new Account[20];
            int i = 0;
            do{
                //input customer's data
                System.out.println("Masukkan Nama Depan Anda   :");
                nama_depan = scan.nextLine();
                System.out.println("Masukkan Nama Belakang Anda:");
                nama_belakang = scan.nextLine();
                System.out.println("Masukkan Tgl. Lahir Anda   :");
                dob = scan.nextLine();
                System.out.println("Masukkan No. Telepon Anda  :");
                no_telp = scan.nextLine();
                
                //create customer's object
                c[i] = new Customer(nama_depan, nama_belakang, dob);
                c[i].setPhoneNumber(no_telp);
                
                //create account object
                System.out.println("Masukkan tipe akun? Savings, Overdraft, Credit, Investment");
                acct_type = scan.nextLine();
                if(acct_type.equalsIgnoreCase("Savings")){
                    System.out.println("Berapa nominal initial balance?");
                    bal = scan.nextInt();
                    a[i] = new Account('S', bal);
                }
                else if(acct_type.equalsIgnoreCase("Overdraft")){
                    System.out.println("Berapa nominal initial balance?");
                    bal = scan.nextInt();
                    a[i] = new Account('O', bal);
                }
                else if(acct_type.equalsIgnoreCase("Credit")){
                    System.out.println("Berapa nominal initial balance?");
                    bal = scan.nextInt();
                    a[i] = new Account('L', bal);
                }
                else if(acct_type.equalsIgnoreCase("Investment")){
                    System.out.println("Berapa nominal initial balance?");
                    bal = scan.nextInt();
                    a[i] = new Account('I', bal);
                }
                else{
                    a[i] = new Account();
                }
               //Menampilkan informasi akun
                System.out.println("Nama    : "+c[i].getName());
                System.out.println("Phone   : "+c[i].getPhoneNumber());
                System.out.println("ID      : "+c[i].getCustId());
                System.out.println("Balance : "+a[i].getBalance());
                System.out.println("Account : "+a[i].getAcctType());
                
                //Ingin membuat customer lagi atau tidak
                System.out.println("Apakah ingin membuat customer lagi? Ya/Tidak");
                user_c = cycle.nextLine();
                
                i++;
                if(i==20){
                    break;
                }
            }while(user_c.equalsIgnoreCase("Ya"));
        }
        else{
            System.out.println("Finish. Terima Kasih");
        }
    }
	
	/**
     * Constructor untuk objek Teller
     */
    public Teller(){
       /*
         c1.setName("Sutandi", "Sanadhi");
         fullname = c1.getName();
         
         System.out.println(fullname);
         
         a1.setBalance(45000);
         c1.setAccount(a1);
         
         acct = c1.getAccount();
         Balance = a1.getBalance();
         
         System.out.println(Balance);
         */
    }
}