import java.util.*;
import java.math.*;
import java.text.*;
import java.time.*;
import java.lang.Math;


/**
 * JBank Program
 * Customer class
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 18.03.2016
 */

public class Teller
{
    /**
     * Deklarasi variabel class :
     */
    //public Customer c1 = new Customer(); //Objek Customer dan menyimpannya dalam variabel c1
    //private Account[] a1 = new Account (4); //Objek Account
    private String fullname; //objek nama costumer
    private String firstName;
    private String lastName;
    private Date startTime;
    private Date closeTime;
    public Account acc; //objek Account
    public int Balance; //objek balance
    
    private static Date ctime, stime;
    
    //Modul 4
    private static MathContext mc = new MathContext(8);
    private static MathContext mc1 = new MathContext(3);
    
    
    /**
     * Main Method in Teller Class
     */
    public static void main(String args[])
    {
        
        Bank b = new Bank();
        Scanner s = new Scanner(System.in);
        String input = "",fname,lname,phone,addr,city,email,zip;
        int year = GregorianCalendar.YEAR; 
        int month = GregorianCalendar.MONTH;
        int day = GregorianCalendar.DAY_OF_MONTH;
        Customer c = null;
        Date DOB;
        char acctType;
        boolean loopState,customerAdded;
        int customerCreated = 0;
        double balance;
        Bank.getCreditRate();
        System.out.println("");
        
        for (int i = 0; i <= Bank.getMaxCustomers(); i++) {
            fname = null;
            lname = null;
            phone = null;
            city = null;
            DOB = null;
            acctType = '\0';
            loopState = false;
            email = null;
            zip = null;
            addr = null;
            input = "";
            balance = 0;
            do {
                
                System.out.println("Apakah ingin membuat Customer? (Y/N)");
                input = s.nextLine();
                if ( ( input.equals("y") ) || ( input.equals("Y")) ) {
                    loopState = true;
                    break;
                } 
                else if ( ( input.equals("n") ) || ( input.equals("N") ) ) {
                    loopState = false;
                    break;
                }    
                else {
                   System.out.println("Input Terbatas Y Atau N Saja\n");
               } 
           } while (!loopState);
           

           if(loopState) {
               System.out.print("Masukkan nama depan anda: ");
               fname = s.nextLine();
               System.out.print("Masukkan nama belakang anda : ");
               lname = s.nextLine();
               System.out.println("Masukkan tanggal lahir anda (MM/dd/yyyy): ");
               input = s.nextLine();
               try {
                    DOB = new SimpleDateFormat("MM/dd/yyyy").parse(input);
               } catch (ParseException e) {
                System.out.println("input salah");
               }
               System.out.print("Masukkan alamat email Anda: ");
               email = s.nextLine();
               System.out.print("Masukkan Alamat kota anda: ");
               city = s.nextLine();
               System.out.print("Masukkan alamat anda : ");
               addr = s.nextLine();
               System.out.print("Masukkan kode pos anda : ");
               zip = s.nextLine();
               System.out.print("Masukkan nomor telepon anda : ");
               phone = s.nextLine();
               System.out.println("S: Savings; O: Overdraft; I:Investment; L: Credit Checking; N: Tidak Membuat");
               System.out.print("Masukkan jenis akun (S/O/I/L/N): ");
               input = s.nextLine();
               if (input.equals("N")) {
                  
              } else {
                  acctType = input.charAt(0);
                  do {
                    System.out.print("Memasukkan nilai saldo awal: ");
                    input = s.nextLine();
                    balance = Integer.parseInt(input);
                    if (balance<=0) {
                        System.out.println("Masukkan nilai yang benar!");
                    } else {
                        break;
                    }
                  } while(true);
              }
              c = new Customer(fname, lname, DOB);
              c.setAddress(addr, city, zip);
              c.setEmail(email);
              c.setPhoneNumber(phone);
              c.addAccount(acctType, balance);


           } else {
               break;
            }
           if (c!= null) {
               System.out.println( b.addCustomer(c)?"Account Berhasil dibuat": "Account tidak berhasil di tambahkan" );
               customerCreated++;
           }
       }
       if (c!= null) {
            b.printAllCustomers();
            c = Bank.getCustomer(1000);
            Account acc = new Account(c, 'C', 1000);
            System.out.println("Account Type: " + acc.getAcctType());
            System.out.println("Balance     : " + acc.getBalance());
            System.out.println("ID          : " + acc.getId());
        }
        /*
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
        }*/
    }
    
    /**
     * Constructor untuk objek Teller
     */
    public Teller()
    {
       // Modul 5
        //Bank bank = new Bank();
        Bank.getHoursOfOperation();
        
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
        /*Account saving = new Account ('S', 1000);
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
        System.out.println("Balance Credit : " +f4L.doubleValue());*/
    }
    
    public static Date getCloseTime() {
        return ctime;
    }
    
     public static Date getStartTime() {
        return stime;
    }
    
      public static void setCloseTime(int year,int month,int day,int hour, int min) {
        stime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
      public static void setStartTime(int year,int month,int day,int hour, int min) {
        stime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    public static void printTime() {
        System.out.println(Bank.getHoursOfOperation());
    }

    public Customer createNewCustomer(String fname, String lname, Date DOB) {
        return new Customer(fname, lname, DOB);
    }
    
    public Customer getCustomer(int customerID) {
        return new Customer();
    }
}