import java.util.regex.Matcher; //Tambahan Modul 3
import java.util.regex.Pattern;
import java.util.*;             //Modul 4
import java.text.*; 
import java.io.*;

/**
 * JBank Program
 * Customer class menghasilkan Object Customer
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */

public class Customer implements Serializable, Comparable<Customer>
{
    /**
     * Deklarasi variabel
     * variabel bertipe Account berdasarkan class Account
     * variabel bertipe string,variable berupa sekumpulan karakter
     * variabel bertipe integer, yaitu variabel berisi angka dengan batasan -32768 sampai 32767
     */
    public Account[] accounts = new Account[4];
    private int custID;
    private int numOfAccounts;
    private Date DOB;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String cityAddress;
    private String streetAddress;
    private String stateAddress;
    private String zipOrPostalCode;
    private Pattern pattern;
	
	//Mengecek validasi alamat email
    private transient Matcher matcher;
    private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    /**
     * Method addAccount untuk menambahkan account baru
     * 
     * 
     */
    public void addAccount (Account acct) throws AccountTypeAlreadyExistsException
    {
        int i = 0;
        if(numOfAccounts < 5) {
            int notUsed = -1;
            for(i = 0; i < accounts.length; i++) {
                if(accounts[i] != null) {
                    if(accounts[i].getClass().equals(acct.getClass())) {
                        throw new AccountTypeAlreadyExistsException(acct);
                    }
                }
                else if(accounts[i] == null && notUsed == -1) {
                    notUsed = i;
                }
            }
            if(notUsed != -1) {
                this.accounts[notUsed] = acct;
                numOfAccounts++;
            }
        }
        else {
            System.out.println("Jumlah akun sudah maksimum!");
        }
    }
    
    /**
     * Constructor Customer
     * @param fname, lname
     */
    public Customer(String fname, String lname)
    {
       this(fname,lname, null);
    }
    
    /**
     * Method Constructor Customer
     * @param firstName, lastName & DOB(DateOfBirth)
     */
    public Customer(String firstName, String lastName, Date DOB)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.custID = Bank.getNextID();
    }
    
    /**
     * Method override untuk membandingkan ID customer
     * @param c Customer
     * @return 1, 0, atau -1 apabila ID lebih besar, sama dengan, atau lebih kecil
     */
    public int compareTo(Customer c)
    {
        if(this.custID > c.custID) {
            return 1;
        }
        else if(this.custID < c.custID) {
            return -1;
        }
        else {
            return 0;
        }
    }
    
    /**
     * Construct DOB
     * @return dateOfBirth
     */
    public Date getDateOfBirth()
    { 
        return DOB;
    }
    
    /**
     * membuat fungsi getAddress untuk mendapatkan informasi alamat
     * @return nilai pada atribut Address seperti Street Address, City Name,  dan Zip or Postal Code
     */
    public String getAddress()
    {
        String address = streetAddress + " " + cityAddress + " " + stateAddress + " " + zipOrPostalCode;
        return address;
	}
    
	/**
     * method getZipCode yang merupakan accessor kode pos alamat
     * @return zipOrPostalCode
     */
    public String getZipCode()
    {
        return zipOrPostalCode;
    }
	
	/**
     * method getStreetAddress yang merupakan accessor alamat jalan
     * @return streetAddress
     */
    public String getStreetAddress()
    {
        return streetAddress;
    }
	
	/**
     * method getStateAddress yang merupakan method accessor negara nasabah
     * @return stateAddress
     */
    public String getStateAddress()
    {
        return stateAddress;
    }
	
	/**
     * Metode getCityAddress yang merupakan accessor alamat kota nasabah
     * @return cityAddress
     */
    public String getCityAddress()
    {
        return cityAddress;
    }
	
    /**
     * method getAccount untuk menerima nama akun
     * @param type
	 * @return semua account yang dimiiki oleh satu customer
	 * @throws AccountTypeNotFoundException
     */
    public Account getAccount(char type) throws AccountTypeNotFoundException
    {
        Account a = null;
        int i = 0;
        for(i = 0; i < accounts.length; i++) {
            switch(type) {
                case 'S': 
                    if((accounts[i] instanceof Savings) && !(accounts[i] instanceof Investment)) {
                        a = accounts[i];
                        return a;
                    }
                    break;
                case 'I': 
                    if(accounts[i] instanceof Investment) {
                        a = accounts[i];
                        return a;
                    }
                    break;
                case 'L': 
                    if(accounts[i] instanceof LineOfCredit) {
                        a = accounts[i];
                        return a;
                    }
                    break;
                case 'O': 
                    if(accounts[i] instanceof OverDraftProtection) {
                        a = accounts[i];
                        return a;
                    }
                    break;
            }
        }
        throw new AccountTypeNotFoundException(type);
    }
    
    /**
     * membuat fungsi getCustomerId untuk menerima ID pelanggan
     * @return custID
     */
    public int getCustID()
    {
        return custID;
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
		String name = firstName + " " + lastName;
        return name;
	}
    
	/**
     * Metode accessor nama belakang nasabah
     * @return Nama belakang
     */
    public String getLastName()
    {
        return lastName;
    }
	
	/**
     * Metode accessor nama depan nasabah
     * @return Nama depan
     */
    public String getFirstName()
    {
        return firstName;
    }
	
    /**
     * membuat fungsi getNumAccounts untuk menerima input jumlah akun
     * @return numOfAccounts
     */
    public int getNumOfAccounts()
    {
        return numOfAccounts;
    }
    
    /**
     * membuat fungsi getPhone, untuk menerima input nomer telepon
     * @return phone
     */
    public String getPhone()
    {
        return phone;
    }
    
	/**
     * Metode accessor DOB
     * @return DOB
     */
    public Date getDOB()
    {
        return DOB;
    }
	
    /**
     * membuat fungsi setaddress dengan variabel street,city dan code
     * @param street, city, state dan code
     */
    public void setAddress(String street, String city, String state, String code) 
    {
        this.streetAddress = street;
        this.cityAddress = city;
        this.stateAddress = state;
        this.zipOrPostalCode = code;
    }
    
    /**
     * membuat fungsi setEmail, dengan variabel emailAddress
     * @return 
     */
    public void setEmail(String emailAddress) 
    {
        pattern = Pattern.compile(emailPattern);
        matcher = pattern.matcher(emailAddress);
        
        if(matcher.matches()) {
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
    public void setDOB(Date DOB)
    {
        this.DOB = DOB;
    }
    
    /**
     * membuat fungsi sePhoneNumber 
     * @return phoneNum
     */
    public void setPhone(String phonenum)
    {
        this.phone = phonenum;
    }
    
    /**
     * Method untuk meng-set Customer id
     * @param id 
     */
    public void setCustID(int id)
    {
        this.custID=id;
    }
    
    /**
     * Method untuk menghapus sebuah Account
     * @param type
	 * @return true, false
     * @throws AccountTypeNotFoundException
     */
    public boolean removeAccount(char type)throws AccountTypeNotFoundException
    {
        Account a = null;
        boolean acctRemoved = false;
        int i = 0;
        for(i = 0; i < accounts.length; i++) {
            switch(type) {
                case 'S': 
                    if((accounts[i] instanceof Savings) && !(accounts[i] instanceof Investment)) {
                        accounts[i] = null;
                        numOfAccounts--;
                        acctRemoved = true;
                    }
                    break;
                case 'I': 
                    if(accounts[i] instanceof Investment) {
                        accounts[i] = null;
                        numOfAccounts--;
                        acctRemoved = true;
                    }
                    break;
                case 'L': 
                    if(accounts[i] instanceof LineOfCredit) {
                        accounts[i] = null;
                        numOfAccounts--;
                        acctRemoved = true;
                    }
                    break;
                case 'O': 
                    if(accounts[i] instanceof OverDraftProtection) {
                        accounts[i] = null;
                        numOfAccounts--;
                        acctRemoved = true;
                    }
                    break;
            }
            
            if(accounts[i] == null && acctRemoved) {
                if(i < accounts.length - 1) {
                    a = accounts[i];
                    accounts[i] = accounts[i+1];
                    accounts[i+1] = a;
                }
                return acctRemoved;
            }
        }
        throw new AccountTypeNotFoundException(type);
    }
    
    /**
     * Method toString untuk menampilkan info customer
	 * @return String
     */
    public String toString()
    {
        SimpleDateFormat dobFormat = new SimpleDateFormat("dd MMM yyyy");
        System.out.println("Informasi Kostumer");
        System.out.println("Nama                    : " + this.getName());
        try {
            System.out.println("DOB                     : " + dobFormat.format(this.getDOB()));
        } catch (NullPointerException e) {
            System.out.println("DOB                     : ");
        }
        System.out.println("No Telepon              : " + this.getPhone());
        System.out.println("Email                   : " + this.getEmail());
        System.out.println("Address                 : " + this.getAddress());
        System.out.println("ID Customer             : " + this.getCustID());
        System.out.println("Informasi Akun Kostumer");
        try {
            System.out.println("Balance Savings         : " + this.getAccount('S').getBalance());
        } catch (AccountTypeNotFoundException e) {
            System.out.println("Customer tidak memiliki account Savings");
        }
        try {
            System.out.println("Balance Investment      : " + this.getAccount('I').getBalance());
        } catch (AccountTypeNotFoundException e) {
            System.out.println("Customer tidak memiliki account Investment");
        }
        try {
            System.out.println("Balance Line-of-Credit  : " + this.getAccount('L').getBalance());
        } catch (AccountTypeNotFoundException e) {
            System.out.println("Customer tidak memiliki account Line-of-Credit");
        }
        try {
            System.out.println("Balance Overdraft       : " + this.getAccount('O').getBalance());
        } catch (AccountTypeNotFoundException e) {
            System.out.println("Customer tidak memiliki account Overdraft");
        }
        return "";
    }
}
