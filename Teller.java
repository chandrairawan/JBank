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
 * @version 16.04.2016
 */

public class Teller
{
    private static MathContext mc = new MathContext(3);
    private static Date ctime, stime; 
    
    /**
     * Main Method in Teller Class
     */
    public static void main(String args[])
    {
        //Modul 7
        //ATMGUI atm = new ATMGUI();
        //atm.showATM();
        Bank b = new Bank();
        String input;
        Scanner scan = new Scanner(System.in);
        //Account a = new Account();
        Customer c = new Customer("Chandra","Irawan");
        
        Savings s = new Savings(c,500);
        s.addDailyInterest(280); //6 bulan 10 hari = 280 hari
        
        Investment i = new Investment(c, 1000, 12);
        i.addDailyInterest(280);
        
        OverDraftProtection o = new OverDraftProtection(c, 1500, s);
        LineOfCredit l = new LineOfCredit (c, 3000, 1000);
        
        try {
            c.addAccount(s);
        } catch (AccountTypeAlreadyExistException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            c.addAccount(l);
        } catch (AccountTypeAlreadyExistException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            c.addAccount(i);
        } catch (AccountTypeAlreadyExistException e) {
            System.out.println(e.getMessage());
        }
        
        LineOfCredit l2 = new LineOfCredit (c, 500, 800);
        try {
            c.addAccount(l2);
        } catch (AccountTypeAlreadyExistException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            c.getAccount('O');
        } catch (AccountTypeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            s.withdraw(2000);
        } catch (AmountOverDrawnException e) {
            System.out.println(e.getMessage());
        }
        
        b.addCustomer(c);
        System.out.println("Akun:");
        b.printAllCustomers();
        c.printAllAccounts();
        
    }
        /*
        Customer c = new Customer("Chandra", "Irawan", null);
        Savings s = new Savings(c, 500);
        Investment i = new Investment(c, 1000, 12);
        s.addDailyInterest(280);
        i.addDailyInterest(280);
        OverDraftProtection o = new OverDraftProtection(c, 1500, s);
        LineOfCredit l = new LineOfCredit (c, 3000, 1000);
        c.addAccount(s);
        c.addAccount(i);
        c.addAccount(o);
        c.addAccount(l);
        System.out.println("Sebelum di Tarik\n");
        c.printAllAccounts();
        o.withdraw(1000);
        o.withdraw(800);
        l.withdraw(2000);
        l.withdraw(2000);
        System.out.println("Setelah di Tarik\n");
        c.printAllAccounts();
        /*
        Account account = new Account();
        
        Bank b = new Bank();
        Scanner s = new Scanner(System.in);
        String input = "",fname,lname,phone,addr,city,email,zip;
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
               System.out.print("Masukkan nama depan: ");
               input = s.nextLine();
               fname = input;
               System.out.print("Masukkan nama belakang: ");
               input = s.nextLine();
               lname = input;
               System.out.print("Masukkan nama kota: ");
               input = s.nextLine();
               city = input;
               System.out.print("Masukkan alamat jalan: ");
               input = s.nextLine();
               addr = input;
               System.out.print("Masukkan alamat email: ");
               input = s.nextLine();
               email = input;
               System.out.print("Masukkan nomor telepon: ");
               input = s.nextLine();
               phone = input;
               System.out.print("Masukkan kode pos / zip: ");
               input = s.nextLine();
               zip = input;
               System.out.print("Masukkan tanggal lahir (DD-MM-YY): ");
               input = s.nextLine();
               try {
                   DOB = new SimpleDateFormat("dd-MM-yyyy").parse(input);
                  
               } catch (ParseException e) {
                System.out.println("Tidak Sesuai");
               }
              System.out.println("S: Savings; O: Overdraft; I:Investment; L: Credit Checking; T: Tidak Membuat");
              System.out.print("Masukkan jenis akun (S/O/I/L/T): ");
              input = s.nextLine();
              if (input.equals("T")) {
                  
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
               System.out.println( b.addCustomer(c)?"Customer ditambahkan": "Customer tidak ditambahkan" );
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
        }*/
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
        }
    }*/
    
    /**
     * Constructor untuk objek Teller
     */
    public Teller()
    {
        /*Modul 5
        Bank bank = new Bank();
        Bank.getHoursOfOperation();
        */
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
    
    public static void setStartTime(int year,int month,int day, int hour, int min) 
    {
        stime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    public Customer createNewCustomer(String fname, String lname, Date DOB) {
        return new Customer(fname, lname, DOB);
    }
    
    public Customer getCustomer(int customerID) {
        return new Customer();
    }
    
    public static void setCloseTime(int year,int month,int day,int hour, int min) {
        ctime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    public static void printTime() {
        System.out.println(Bank.getHoursOfOperation());
    }
    
    public static double futureValue(double balance, double rate, double compound, double period) 
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
    
    public static void getAccount(Customer customer)
    {
        for (int x = 0; x < customer.accounts.length; x++)
        {
            if (customer.accounts[x] != null)
            {
                System.out.println("Account : " + customer.accounts[0].getId());
                System.out.println("Balance : " + customer.accounts[0].getBalance());
            }
        }
    }
}