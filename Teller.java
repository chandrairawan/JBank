import java.util.*;
import java.math.*;


/**
 * JBank Program
 * Customer class
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 11.03.2016
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
    
    //Modul 4
    private static MathContext mc = new MathContext(8);
    private static MathContext mc1 = new MathContext(3);
    
    /**
     * Main Method in Teller Class
     */
    public static void main(String args[]){
        // Tugas 4 Modul 3
        String user_c;
        String nama_depan;
        String nama_belakang;
        Date dob;
        //Date startTime;
        //Date closeTime;
        String no_telp;
        String acct_type;
        int bal;
        int year=0, month=0, day=0;

        
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
                System.out.println("Masukkan Nama Depan Anda :");
                nama_depan = scan.nextLine();
                System.out.println("Masukkan Nama Belakang Anda :");
                nama_belakang = scan.nextLine();
                System.out.println("Masukan Tgl. Lahir Anda :");
                //dob = scan.nextLine();
                System.out.println("Masukkan No. Telepon Anda :");
                no_telp = scan.nextLine();
                
                Calendar start = new GregorianCalendar();
                start.set(Calendar.HOUR_OF_DAY,8);
                start.set(Calendar.MINUTE, 0);
                Date startTime = start.getTime();
                Calendar close = new GregorianCalendar();
                close.set(Calendar.HOUR_OF_DAY,17);
                close.set(Calendar.MINUTE, 0);
                Date closeTime = close.getTime();
                
                //create customer's object
                c[i] = new Customer(nama_depan, nama_belakang, (new GregorianCalendar(year, month, day).getTime()));
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
                System.out.print("Date    : "+c[i].getDateOfBirth());
                System.out.println();
               
                System.out.println("Nama    : "+c[i].getName());
                System.out.println("Phone   : "+c[i].getPhoneNumber());
                System.out.println("ID      : "+c[i].getCustId());
                System.out.println("Balance : "+a[i].getBalance());
                System.out.println("Account : "+a[i].getAcctType());
                System.out.println(startTime+" TO "+closeTime);
                
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
        
        
        //Objek Account Saving, Invest, dan CreditLine 
        Account saving = new Account ('S', 1000);
        Account invest = new Account ('I', 1000);
        Account creditline = new Account ('L', 500);
        
        
        BigDecimal balanceS = new BigDecimal (saving.getBalance());
        BigDecimal balanceI = new BigDecimal (invest.getBalance());
        BigDecimal balanceL = new BigDecimal (250);
        
        //Saving Interest Rates 3% setiap tahun, dihitung setiap hari
        BigDecimal rS = new BigDecimal (.03); 
        //Investment Interest Rates 7% jika Investment Termnya mencapai 12 bulan
        BigDecimal rI = new BigDecimal (.07);
        //LOC Interest Rates 18%, dihitung setiap hari 
        BigDecimal rL = new BigDecimal (.18);
        
        BigDecimal n = new BigDecimal (360); //compound harian
        BigDecimal t = new BigDecimal (1.0); //untuk 1 tahun
        
        BigDecimal f1S = rS.divide(n, mc).add(new BigDecimal(1.0));
        BigDecimal f1I = rI.divide(n, mc).add(new BigDecimal(1.0));
        BigDecimal f1L = rL.divide(n, mc).add(new BigDecimal(1.0));
        
        BigDecimal f2 = n.multiply(t, mc);
        
        BigDecimal f3S = new BigDecimal (Math.pow(f1S.doubleValue(), f2.doubleValue()),mc);
        BigDecimal f3I = new BigDecimal (Math.pow(f1I.doubleValue(), f2.doubleValue()),mc);
        BigDecimal f3L = new BigDecimal (Math.pow(f1L.doubleValue(), f2.doubleValue()),mc);
        
        
        BigDecimal f4S = f3S.multiply(balanceS, mc);
        BigDecimal f4I = f3I.multiply(balanceI, mc);
        BigDecimal f4L = f3L.multiply(balanceI, mc);
        
        //Menampilkan Balance
        System.out.println("Balance Saving : " +saving.getBalance());
        System.out.println("Balance Investment : "+invest.getBalance());        
        System.out.println("Balance Saving : " +f4S.doubleValue());
        System.out.println("Balance Investment : " +f4I.doubleValue());
        System.out.println("Balance Credit : " +f4L.doubleValue());
    }
}