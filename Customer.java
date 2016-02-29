
/**
 * JBank Phase 2.
 * 
 * @author (Abdul Chandra Irawan)
 * @NPM (1306405244)
 * @version (27-02-2016)
 */
public class Customer
{
    private Account accounts = new Account(); //Membuat variabel bertipe Account berdasarkan class Account
    private String cityName,dateOfBirth,email,firstName,lastName,streetAddress,phoneNumber,zipOrPostalCode; //membuat variabel bertipe string,variable berupa sekumpulan karakter
    private int custId,numberOfCurrentAccounts; //membuat variabel bertipe integer, yaitu variabel berisi angka dengan batasan -32768 sampai 32767

    
    public Customer(){}
    public Customer(String fname, String lname, String dob){}
    public Customer(String firstName, String lastName, String dateOfBirth, int custId){}
    
    /**
     * @return merupakan fungsi untuk return nilai gabungan dari variabel tersebut secara berurutan
     */
    public String getAddress(){
        return streetAddress + " " + cityName+ " " + zipOrPostalCode; //mengembalikan nilai pada atribut Address
    }
    
    
    public Account getAccount(){ //pembuatan fungsi getAccount untuk menerima nama akun
        return accounts; //mengembalikan nilai pada atribut account
    }
    
    public int getCustomerId(){//pembuatan fungsi getCustomerId untuk menerima id pelanggan
        return 0;
    }
    
    public String getEmail(){//membuat fungsi getEmail untuk menerima input email
        return "";
    }
    
    public String getName() {//membuat fungsi setName untuk menerima input nama
        return lastName + "," + firstName;
    }
    
    public int getNumOfAccounts(){//membuat fungsi getNumAccounts untuk menerima input nomer akun
        return 0;
    }
    
    public String getPhoneNumber(){//membuat fungsi getPhoneNumber, untuk menerima input nomer telepon
        return "";
    }
    
    public void setAddress(String street, String city, String code) {//membuat fungsi setaddress dengan variabel street,city dan code
        streetAddress = street;
        cityName = city;
        zipOrPostalCode = code;
        return;
    }
    
    public void setEmail(String emailAddress) {//membuat fungsi setEmail, dengan variabel emailAddress
        return;
    }
    
    public void setName(String lname, String fname) {//membuat fungsi setCustomerName, dengan variabel lname dan cfname 
        firstName = fname;
        lastName = lname;
    }
    
    public void setPhoneNumber(String phoneNum) {//membuat fungsi sePhoneNumber 
        return;
    }
    
    public void setAccount(Account account) {//membuat fungsi 
        accounts = new Account();
    }
}
