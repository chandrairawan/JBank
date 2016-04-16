
//Tambahan Modul 3
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Modul 4
import java.util.*;
import java.text.*;

import java.io.*;

/**
 * JBank Program
 * Customer class
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 16.04.2016
 */

public class Customer
{
    /**
     * Deklarasi variabel
     * variabel bertipe Account berdasarkan class Account
     * variabel bertipe string,variable berupa sekumpulan karakter
     * variabel bertipe integer, yaitu variabel berisi angka dengan batasan -32768 sampai 32767
     */
    public Account[] accounts = new Account[4];
    private Account a;
    private String cityName;
    private int custId;
    private Date dateOfBirth;
    private String email;
    private String firstName;
    private String lastName;
    private int numberOfCurrentAccounts; 
    private String stAddress;
    private String phoneNumber;
    private String zipOrPostalCode;
    private int indexArrayAccount = 0;
    private Date date;
    private Boolean check;
    
    //Tambahan
    private String emailVali;
    private String emailRegex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private Boolean boolVali;
    
    /**
     * 
     */
    public boolean addAccount (Account acct) 
    {
        boolean accountAdded = false, sameType = false;
        int index = -1;
        if ( numberOfCurrentAccounts < 5 ) {
            for (int i = indexArrayAccount; i < 4; i++) {
                if (accounts[i] == null && index == -1) {
                    index = i;
                } else if (accounts[i] != null ) {
                    if (accounts[i].getClass().equals( acct.getClass() )){
                        sameType = true;
                        break;
                    }
                }
            }
            if (!sameType && index != -1){
                accounts[index] = acct;
                accountAdded = true;
                numberOfCurrentAccounts++;
                indexArrayAccount++;
            }
        }
        return accountAdded;
        //return false;
    }
    
    
    /**
     * Constructor Customer
     */
    public Customer()
    { 
    }
    
    /**
     * Constructor Customer
     * @param fname, lname
     */
    public Customer(String fname, String lname)
    {
       this(fname,lname, null);
    }
    
    public Customer(String fname, String lname, Date dateOfBirth)
    {
        this.firstName = fname;
        this.lastName = lname;
        this.dateOfBirth = dateOfBirth;
        custId = Bank.getNextID();
    }
    
    
    public Customer(String firstName, String lastName, String DOB, int custId)
    {
    }
    
    /**
     * Construct DOB
     * @return dateOfBirth
     */
    public Date getDateOfBirth()
    { 
        return dateOfBirth;
    }
    
    /**
     * membuat fungsi getAddress untuk mendapatkan informasi alamat
     * @return nilai pada atribut Address seperti Street Address, City Name,  dan Zip or Postal Code
     */
    public String getAddress()
    {
        return stAddress + " " + cityName+ " " + zipOrPostalCode;
    }
    
    /**
     * Membuat fungsi getAccount untuk menerima nama akun
     * @return semua account yang dimiiki oleh satu customer
     */
    public Account getAccount(char type)
    {
        Account acct = null;
        for (Account a: accounts ) {
            switch (type) {
                case 'S' : if( (a instanceof Savings) && !(a instanceof Investment) ) {
                    acct = a;
                }
                break;
                case 'L' : if(a instanceof LineOfCredit) {
                    acct = a;
                }
                break;
                case 'O' : if(a instanceof OverDraftProtection) {
                    acct = a;
                }
                break;
                case 'I' : if(a instanceof Investment) {
                    acct = a;
                }
                break;
            }   
        }
        return acct;
    }
    
    /**
     * membuat fungsi getCustomerId untuk menerima id pelanggan
     * @return custId
     */
    public int getCustId()
    {
        return custId;
    }
    
    /**
     * membuat fungsi getEmail untuk menerima input email
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * membuat fungsi setName untuk menerima input nama
     * @return lastname dan firstname
     */
    public String getName() 
    {
        return lastName + "," + firstName +","+dateOfBirth;
    }
    
    /**
     * membuat fungsi getNumAccounts untuk menerima input nomer akun
     * @return 0
     */
    public int getNumOfAccounts()
    {
        return numberOfCurrentAccounts;
    }
    
    /**
     * membuat fungsi getPhoneNumber, untuk menerima input nomer telepon
     * @return phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * membuat fungsi setaddress dengan variabel street,city dan code
     * @param street, city, dan code
     * @return 
     */
    public void setAddress(String street, String city, String code) 
    {
        this.stAddress = street;
        this.cityName = city;
        this.zipOrPostalCode = code;
    }
    
    /**
     * membuat fungsi setEmail, dengan variabel emailAddress
     * @return 
     */
    public void setEmail(String emailAddress) 
    {
        emailVali = emailAddress;
        boolVali = emailVali.matches(emailRegex);
        
        if (boolVali == false){
            System.out.println("False");
        }
        else if(boolVali == true){
            System.out.println("True");
            this.email = emailAddress;
        }
    }
    
    /**
     * membuat fungsi setName, dengan variabel lname dan fname untuk mengganti nama costumer 
     * @param fname dan lname
     */
    public void setName(String lname, String fname) 
    {
        this.firstName = fname;
        this.lastName = lname;
    }
    
    /**
     * memasukkan tanggal lahir nasabah
     * @param dob
     */
    public void setDateOfBirth(Date dateOfBirth)
    {
        dateOfBirth = dateOfBirth;
    }
    
    /**
     * membuat fungsi sePhoneNumber 
     * @return phoneNum
     */
    public void setPhoneNumber(String phoneNum) 
    {
        this.phoneNumber = phoneNum;
    }
    
    /**
     * membuat fungsi setAccount untuk membuat account baru
     * @param new Account()
     *//*
    public void setAccount(Account account) { 
        accounts = new Account();
    }*/
    
    /**
     * Method untuk meng-set Customer ID
     * 
     */
    public void setCustId(int id)
    {
        custId=id;
    }
    
    /**
     * Method untuk menghapus sebuah Account
     * @return false
     */
    public boolean removeAccount(char type)
    {
        Account a = null;
        boolean accountRemoved = false;
        for (int i = 0; i<=3; i++) {
            switch (type) {
                case 'S' : if ( accounts[i] instanceof Savings && !(accounts[i] instanceof Investment)) {
                    accounts[i] = null;
                    indexArrayAccount--;
                    numberOfCurrentAccounts--;
                    accountRemoved = true;
                }
                break;
                case 'L' : if ( accounts[i] instanceof LineOfCredit) {
                    accounts[i] = null;
                    indexArrayAccount--;
                    numberOfCurrentAccounts--;
                    accountRemoved = true;
                }
                break;
                case 'O' : if ( accounts[i] instanceof OverDraftProtection) {
                    accounts[i] = null;
                    indexArrayAccount--;
                    numberOfCurrentAccounts--;
                    accountRemoved = true;
                }
                break;
                case 'I' : if ( accounts[i] instanceof Investment) {
                    accounts[i] = null;
                    indexArrayAccount--;
                    numberOfCurrentAccounts--;
                    accountRemoved = true;
                }
                break;
            }
            
            if (accounts[i] == null && accountRemoved) {
                if ( i != 3) {
                    a = accounts[i];
                    accounts[i] = accounts [i+1];
                    accounts [i+1] = a;
                }
            }
        }
        return accountRemoved;
    }
    
    /**
     * @return null
     */
    public String toString()
    {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        System.out.println("Customer ID   :   " + custId);
        System.out.println("First Name    :   " + firstName);
        System.out.println("Last Name     :   " + lastName);
        System.out.println("City Address  :   " + cityName);
        System.out.println("Stret Address :   " + stAddress);
        System.out.println("Email         :   " + email);
        System.out.println("Phone Number  :   " + phoneNumber);
        System.out.println("Zip / Postal  :   " + zipOrPostalCode);
        System.out.println("DOB           :   " + ft.format(dateOfBirth));
        System.out.println("Account       :");
        /*
        for (Account a : accounts) {
            if ( a!= null) {
                switch (a.getAcctType()) {
                    case 'S': System.out.println("          SAVINGS, " + a.getBalance());
                              break;
                    case 'O': System.out.println("          OVERDRAFT, " + a.getBalance());
                              break;
                    case 'I': System.out.println("          INVESTMENT, " + a.getBalance());
                              break;
                    case 'L': System.out.println("          LINEOFCREDIT, " + a.getBalance());
                              break;
                    default : System.out.println("          Belum Membuat");
                }
            }
        }
        System.out.println("");*/
        return "";
    }
    
    public void printAllAccounts() {
        for (Account a : accounts) {
            if (a!=null)
                System.out.println(a);
        }
    }
}
