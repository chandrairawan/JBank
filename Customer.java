
/**
 * JBank Program
 * Customer class
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 05.03.2016
 */

//Tambahan
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer
{
    /**
     * Deklarasi variabel
     * variabel bertipe Account berdasarkan class Account
     * variabel bertipe string,variable berupa sekumpulan karakter
     * variabel bertipe integer, yaitu variabel berisi angka dengan batasan -32768 sampai 32767
     */
    private Account accounts = new Account();
    private String cityName;
    private String dateOfBirth;
    private String email;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String phoneNumber;
    private String zipOrPostalCode;
    private int custId;
    private int numberOfCurrentAccounts; 
    
    //Tambahan
    private String emailVali;
    private String emailRegex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private Boolean boolVali;
    
    public Customer(){
        
    }
    
    public Customer(String fname, String lname){
       this(fname,lname,"none");
    }
   
    public Customer(String fname, String lname, String dob){
        firstName = fname;
        this.lastName = lname;
        this.dateOfBirth = dob;
        this.custId = Bank.getNextID();
    }
    public Customer(String firstName, String lastName, String dateOfBirth, int custId){
        
    }
    
    /**
     * membuat fungsi getAddress untuk mendapatkan informasi alamat
     * @return nilai pada atribut Address seperti Street Address, City Name,  dan Zip or Postal Code
     */
    public String getAddress(){
        return streetAddress + " " + cityName+ " " + zipOrPostalCode;
    }
    
    /**
     * Membuat fungsi getAccount untuk menerima nama akun
     * @return nilai pada atribut account
     */
    public Account getAccount(){ 
        return accounts;
    }
    
    /**
     * membuat fungsi getCustomerId untuk menerima id pelanggan
     * @return 0
     */
    public int getCustId(){
        return custId;
    }
    
    /**
     * membuat fungsi getEmail untuk menerima input email
     * @return ""
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * membuat fungsi setName untuk menerima input nama
     * @return lastname dan firstname
     */
    public String getName() {
        return lastName + "," + firstName;
    }
    
    /**
     * membuat fungsi getNumAccounts untuk menerima input nomer akun
     * @return 0
     */
    public int getNumOfAccounts(){
        return numberOfCurrentAccounts;
    }
    
    /**
     * membuat fungsi getPhoneNumber, untuk menerima input nomer telepon
     * @return phoneNumber
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    /**
     * membuat fungsi setaddress dengan variabel street,city dan code
     * @param street, city, dan code
     * @return 
     */
    public void setAddress(String street, String city, String code) {
        streetAddress = street;
        cityName = city;
        zipOrPostalCode = code;
    }
    
    /**
     * membuat fungsi setEmail, dengan variabel emailAddress
     * @return 
     */
    public void setEmail(String emailAddress) {
        emailVali = emailAddress;
        boolVali = emailVali.matches(emailRegex);
        
        if (boolVali == false){
            System.out.println("False");
        }
        else if(boolVali == true){
            System.out.println("True");
            email = emailAddress;
        }
    }
    
    /**
     * membuat fungsi setName, dengan variabel lname dan fname untuk mengganti nama costumer 
     * @param fname dan lname
     */
    public void setName(String lname, String fname) {
        firstName = fname;
        lastName = lname;
    }
    
    /**
     * membuat fungsi sePhoneNumber 
     * @return phoneNum
     */
    public void setPhoneNumber(String phoneNum) {
        phoneNumber = phoneNum;
    }
    
    /**
     * membuat fungsi setAccount untuk membuat account baru
     * @param new Account()
     */
    public void setAccount(Account account) { 
        accounts = new Account();
    }
    
    public void setCustId(int id){
        custId=id;
    }
    
    public boolean removeAccount(char type){
        return false;
    }
    
    public String toString(){
        return null;
    }
}
